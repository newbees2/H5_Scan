package com.h5scan;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.h5scan.qr.R;
import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Permission;
import com.yzq.zxinglibrary.android.CaptureActivity;
import com.yzq.zxinglibrary.bean.ZxingConfig;
import com.yzq.zxinglibrary.common.Constant;

import java.util.List;

public class MyScanActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_scan);

        AndPermission.with(this)
                .permission(Permission.CAMERA, Permission.READ_EXTERNAL_STORAGE)
                .onGranted(new Action() {
                    @Override
                    public void onAction(List<String> permissions) {
                        Intent intent = new Intent(MyScanActivity.this, CaptureActivity.class);
                        /*ZxingConfig是配置类
                         *可以设置是否显示底部布局，闪光灯，相册，
                         * 是否播放提示音  震动
                         * 设置扫描框颜色等
                         * 也可以不传这个参数
                         * */
                        ZxingConfig config = new ZxingConfig();
                        //config.setPlayBeep(false);//是否播放扫描声音 默认为true
                        //config.setShake(false);//是否震动  默认为true
                        //config.setDecodeBarCode(false);//是否扫描条形码 默认为true
                        //config.setReactColor(R.color.colorAccent);//设置扫描框四个角的颜色 默认为白色
                        //config.setFrameLineColor(R.color.colorAccent);//设置扫描框边框颜色 默认无色
                        config.setScanLineColor(R.color.scanLineColor);//设置扫描线的颜色 默认白色
                        //config.setShowAlbum(false);//设置显示相册
                        //config.setShowFlashLight(false);//设置开启闪光灯
                        //config.setShowbottomLayout(false);//设置显示底部布局
                        config.setFullScreenScan(false);//是否全屏扫描  默认为true  设为false则只会在扫描框中扫描
                        intent.putExtra(Constant.INTENT_ZXING_CONFIG, config);
                        startActivityForResult(intent, 666);
                    }
                })
                .onDenied(new Action() {
                    @Override
                    public void onAction(List<String> permissions) {
                        Uri packageURI = Uri.parse("package:" + getPackageName());
                        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, packageURI);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        Toast.makeText(MyScanActivity.this, "没有权限无法扫描", Toast.LENGTH_LONG).show();
                    }
                }).start();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 扫描二维码/条码回传
        if (requestCode == 666 && resultCode == RESULT_OK) {
            if (data != null) {
                Intent intent = new Intent();
                intent.putExtra("result", data.getStringExtra(Constant.CODED_CONTENT));
                setResult(666, intent);
             }
        }
        finish();
    }

}

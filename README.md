<h1>H5_Scan</h1><br>
<h3>H5_Scan实现的功能是通过安卓的webview调用摄像头扫描二维码或条形码并返回扫码结果给webview,开发人员只需编写HTML5页面就能实现扫码功能。</h3>
<br>
说明：<br>
1.请使用android studio打开本项目。<br>
2.重写了javascript的alert和confirm函数,弹窗界面更美观。 <br>
3.集成了zxing3.3.3。 <br><br>

示例：<br>
\<script\> <br>
function scan() { <br>
&ensp;&ensp;&ensp;&ensp;android.doScan();<br>
}<br>    
function setScanResult(result){<br>
&ensp;&ensp;&ensp;&ensp;document.getElementById("result").value = result ;<br>
}<br>
\</script\><br>
\<input type="text" id="result" placeholder="扫码结果" Value=""\><br>
\<button onclick="scan();"\>扫码\</button\>

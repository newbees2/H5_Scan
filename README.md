1.请使用android studio打开本项目。

2.重写了javascript的alert和confirm函数。 

3.集成了zxing3.3.3。


实例：

<script>
function scan() {
     android.doScan();
}
 
function setScanResult(result){
     document.getElementById("result").value = result ;    
}
</script>
<input type="text" id="result" placeholder="扫码结果" Value="">
<button onclick="scan();">扫码</button>


1.请使用android studio打开本项目。<br>
2.重写了javascript的alert和confirm函数。 <br>
3.集成了zxing3.3.3。 <br><br>

实例：<br>
\<script\> <br>
function scan() { <br>
     android.doScan();<br>
}<br>    
function setScanResult(result){<br>
    document.getElementById('result').value = result ;<br>
}<br>
\</script\><br>
\<input type='text' id='result' placeholder='扫码结果' Value=''\><br>
\<button onclick='scan();'\>扫码\</button\><br>



<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>

<head>
<meta charset="utf-8">
<title>서명 테스트</title>
<link href="http://www.jqueryscript.net/css/jquerysctipttop.css" rel="stylesheet" type="text/css">
<style>
body {
font: normal 100.01%/1.375 "Helvetica Neue", Helvetica, Arial, sans-serif;
}
</style>
<link href="/assets/jquery.signaturepad.css" rel="stylesheet">
<!--[if lt IE 9]><script src="../assets/flashcanvas.js"></script><![endif]-->

</head>
<body>
<img id="privacy" >
<form method="post" action="response.do">

<div class="sigPad" id="smoothed-variableStrokeWidth" style="width:404px;">
<ul class="sigNav">
<li class="drawIt"><a href="#draw-it" >Draw It</a></li>
<li class="clearButton"><a href="#clear">Clear</a></li>
</ul>
<div class="sig sigWrapper" style="height:auto;">
<div class="typed"></div>
<canvas class="pad" width="400" height="250"></canvas>
<input type="hidden" name="output-3" class="output">
</div> 
</div>
<button type="submit" >전송</button>
</form>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="/assets/numeric-1.2.6.min.js"></script> 
<script src="/assets/bezier.js"></script> 
<script src="/assets/jquery.signaturepad.js"></script> 
<script>
    $(document).ready(function() {
      $('#linear').signaturePad({drawOnly:true, lineTop:200});
      $('#smoothed').signaturePad({drawOnly:true, drawBezierCurves:true, lineTop:200});
      $('#smoothed-variableStrokeWidth').signaturePad({drawOnly:true, drawBezierCurves:true, variableStrokeWidth:true, lineTop:200});
      
      $('#privacy').attr('src','/img/privacy.png');
    });
  </script> 
<script src="/assets/json2.min.js"></script>
<script type="text/javascript">

  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-36251023-1']);
  _gaq.push(['_setDomainName', 'jqueryscript.net']);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();

</script>

</body>

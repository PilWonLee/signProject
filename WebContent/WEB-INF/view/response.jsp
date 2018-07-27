<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    <%
    String res = (String)request.getAttribute("res");
    
    System.out.println(res);
    
    %>
<!DOCTYPE html>
<head>
  <meta charset="utf-8">
  <title>Regenerate a Signature · Signature Pad</title>
  <style>
    body { font: normal 100.01%/1.375 "Helvetica Neue",Helvetica,Arial,sans-serif; }
    p { margin: 0.515em 0 0; padding: 0 6px; }
    div.sigPad { margin-bottom: 20px;}
  </style>
  <link href="/assets/jquery.signaturepad.css" rel="stylesheet">
  <!--[if lt IE 9]><script src="../assets/flashcanvas.js"></script><![endif]-->
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.5.1/jquery.min.js"></script>
</head>
<body>
<div id="wrapp" style="visibility: hidden">
  <div id="sig3" class="sigPad signed" style="width:700px;border:solid black 1px;" >
    <div class="sigWrapper" style="height:250px;">
      <canvas class="pad" id="pad3" width="700" height="250"></canvas>
    </div>
  </div>
	<img id="img3" >
	<img id="privacy" >
	<canvas id="new" width="798" height="709" ></canvas>
	<a id="resDownload" href="" download="result" ><img id="res"></a>
	<form id="frm" action="submit.do" method="post">
		<input type="hidden" name="sign" id="signUrl">
		<input type="hidden" name="result" id="resultUrl">
	</form>
</div>	
  <script src="/assets/numeric-1.2.6.min.js"></script>
  <script src="/assets/bezier.js"></script>

  <script src="/assets/jquery.signaturepad.js"></script>
  <script>
    $(document).ready(function() {
    	
    	var sig =<%=res%>;	
      $('#sig3').signaturePad({displayOnly:true, autoscale:true, drawBezierCurves:true, variableStrokeWidth:true}).regenerate(sig);//전달된 값을 캔버스에 그림
      var canvas = document.getElementById("pad3");//캔버스 객체 가져오기
      console.log(canvas.toDataURL("image/jpeg"));
      var signImage = canvas.toDataURL("image/jpeg");//캔버스에서 이미지 URL가져오기
      $('#img3').attr('src',signImage);//캔버스에서 가져온 이미지 그리기
      /* $('#privacy').attr('src','/img/privacy.png');//약관 이미지 불러오기 */
      
      var imgPriv = new Image();//이미지 객체 생성
      var imgSign = new Image();//이미지 객체 생성
      imgPriv.src="/img/privacy.png";
      imgSign.src= signImage;
      
      imgPriv.onload=function(){
    	  var newCanvas = document.getElementById('new').getContext("2d");
    	  newCanvas.drawImage(imgPriv,0,0,798,709);
    	  newCanvas.drawImage(imgSign,520,632,200,80);
    	  
    	  var newCanvasURL = document.getElementById('new').toDataURL("image/jpeg");//결과 캔버스 이미지 URL
    	  $('#res').attr('src',newCanvasURL);//결과 이미지 그리기
    	  $('#resDownload').attr('href',newCanvasURL);
    	  
    	  $('#signUrl').val(signImage);
    	  console.log("sign :"+$('#signUrl').val());
    	  $('#resultUrl').val(newCanvasURL);
		  $('#frm').submit();       
    	  
      };
      
      
      
      
    });
  </script>
  <script src="/assets/json2.min.js"></script>
  
</body>
    
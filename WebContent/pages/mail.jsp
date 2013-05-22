<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <meta name="GENERATOR" content="Mozilla/4.61 [en] (WinNT; I) [Netscape]">
   <meta name="Author" content="Anil K. Vijendran">

<link href="../css/stylegreyEx.css" rel="stylesheet" type="text/css" />
<link href="../css/stylegreysegEx.css" rel="stylesheet" type="text/css" />
<link href="../css/stylecolsegEx.css" rel="stylesheet" type="text/css" />
<link href="../css/stylecolsegGEx.css" rel="stylesheet" type="text/css" />
<link href="../css/rbox.css" rel="stylesheet" type="text/css" />
<title>Jordi</title>
																	




<script type="text/javascript">
function envia(){

	var cos = document.getElementById('EditDIV').innerHTML;
	self.location = "../Envia?message="+cos;


	}
 
   

    	</script>
</head>


<body  style="background-color: #000000" marginheight="0" marginwidth="0" >
<h3 style="color: #ffffff; ">Edita el missatge</h3>

<button Title="Bold" unselectable="on"
  onclick="document.execCommand('Bold'); 
  document.getElementById('EditDIV').focus()">
    <b>B</b>
</button>

<button Title="Italic" unselectable="on"
  onclick="document.execCommand('Italic'); 
  document.getElementById('EditDIV').focus()">
    <b><i>I</i></b>
</button>

<button Title="Underline" unselectable="on"
  onclick="document.execCommand('Underline'); 
  document.getElementById('EditDIV').focus()">
    <b><u>U</u></b>
</button>
 
<button Title="Copy" unselectable="on"
  onclick="document.execCommand('Copy'); 
  document.getElementById('EditDIV').focus()">
    <b>Copy</b>
</button>

<button Title="Paste" unselectable="on"
  onclick="document.execCommand('Paste'); 
  document.getElementById('EditDIV').focus()">
    <b>Paste</b>
</button>
 
<button Title="View Code" unselectable="on"
  onclick="document.getElementById('CodeDIV').innerText = 
  document.getElementById('EditDIV').innerHTML">
    ViewCode
</button>
<br/>
<div id="EditDIV" contentEditable="true" style="width:350px; background-color:#ffffff;  height:100px; 
border:solid 1px; font-family:times new roman; font-size:12pt; padding:5px; 
overflow:auto; margin-top:3px">
  Edit the content in this window.
</div>
Code:<br/>
<div id="CodeDIV" style="width:350px; background-color:#ffffff; padding:5px; border:solid 1px"></div>

<button Title="Send" unselectable="on"
  onclick="envia(); window.close();">
    <b>Send</b>
</button>

</body> 
</html>
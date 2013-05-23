<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ page import="java.util.List,ca.Entitys.Images"%>
<html:html lang="ca">
<head>
<title><bean:message key="welcome.title" /></title>
<LINK REL=STYLESHEET
      HREF="<html:rewrite href='/PPJJ/css/960.css'></html:rewrite>"
      TYPE="text/css">
<LINK REL=STYLESHEET
      HREF="<html:rewrite href='/PPJJ/css/back.css' ></html:rewrite>"
      TYPE="text/css">


</head>

<body bgcolor="white">
<div id=header class=container_12 sizcache="291" sizset="0">


<div id=header class="grid_12 "><h3>Nova Obra</h3></div>

</div>

<div id=content class=container_12 sizcache="303" sizset="0">


<div id=content class="grid_12 ">

<html:form action="/backend/SaveNewObra" >

<select onchange="changeObra(this.value)"  id="ObraRefSelect">
<option value="">*escollir un tipus*</option>
<option value="bloc">BLOC</option>
<option value="masia">MASIA</option>
<option value="xalet">XALET</option>
</select>

<html:text name="SaveObraNewForm" style="visibility:hidden;" property="obraRef" value=""  ></html:text>

Titol:<html:text name="SaveObraNewForm" property="titolPag" value=""/>
Menu: <html:text name="SaveObraNewForm" property="titolMenu"  value="" />
<br><br><br><br>
<table id="urlimages" >
<tbody>
<tr>
<td>
URL de la imatge:<html:text name="SaveObraNewForm"  property="url"  value="" />
</td>
</tr>
</tbody>
</table>
<br>
<table id="urlnoticies" >
<tbody>
<tr>
<td>
URL de la noticia:</td>
<td>Text Catala:</td>
<td>Text Castella:</td>
<td>Text Angles:</td>
</tr>
<tr>
<td><html:text name="SaveObraNewForm"  property="urlnoticia"  value="" /></td>
<td><html:text name="SaveObraNewForm" property="textca" value=""></html:text></td>
<td><html:text name="SaveObraNewForm" property="textes" value=""></html:text></td>
<td><html:text name="SaveObraNewForm" property="texten" value=""></html:text></td>
</tr>
</tbody>
</table>
<br><br>
<div id="planos">
<table>
<tbody>
<tr><td>
Nou planol: <html:file name="SaveObraNewForm" property="plano"></html:file></td>
<td>Text catala: <html:text name="SaveObraNewForm"  property="platextca"  value="" /></td><td>Text anglès: <html:text name="SaveObraNewForm"  property="platexten"  value="" /></td><td>Text castella: <html:text name="SaveObraNewForm"  property="platextes"  value="" /></td><br>
</tr>
</tbody>
</table>
</div>
<br><br>
<input type="button" value="New Url imatge" onclick="newUrl()" />
<input type="button" value="New Url noticia" onclick="newUrlNoticia()" />
<input type="button" value="Afegir planols" onclick="addPlanols()" />
<input type="submit" value="Save"/>
</div></div>
</html:form>
<script type="text/javascript">
function newUrl(){
var table = document.getElementById("urlimages");
var tBody = table.getElementsByTagName('tbody')[0];
var newTR = document.createElement('tr');
var newTD = document.createElement('td');
newTD.innerHTML = 'URL de la imatge:<html:text name="SaveObraNewForm"  property="url"  value="" />';
newTR.appendChild (newTD);
tBody.appendChild(newTR);
}

function newUrlNoticia(){
var table = document.getElementById("urlnoticies");
var tBody = table.getElementsByTagName('tbody')[0];
var newTR = document.createElement('tr');
var newTD = document.createElement('td');
newTD.innerHTML = 'URL de la noticia:<html:text name="SaveObraNewForm"  property="urlnoticia"  value="" /><br>Nom Catala:<html:text name="SaveObraNewForm" property="textca" value=""></html:text><br>Nom Castella:<html:text name="SaveObraNewForm" property="textes" value=""></html:text><br>Nom Angles:<html:text name="SaveObraNewForm" property="texten" value=""></html:text>';
newTR.appendChild (newTD);
tBody.appendChild(newTR);
}

function changeObra(obra){
		var elements = document.getElementsByName("obraRef");
		elements.item(0).value=obra;
}
function addPlanols(){
//window.location.href="/PPJJ/AddPlanols.do";
var table = document.getElementById("planos");
var tBody = table.getElementsByTagName('tbody')[0];
var newTR = document.createElement('tr');
var newTD = document.createElement('td');
newTD.innerHTML = 'Nou planol: <html:file name="SaveObraNewForm" property="plano"></html:file><br> Text catala: <html:text name="SaveObraNewForm"  property="platextca"  value="" /><br>Text anglès: <html:text name="SaveObraNewForm"  property="platexten"  value="" /><br>Text castella: <html:text name="SaveObraNewForm"  property="platextes"  value="" /><br>';
newTR.appendChild (newTD);
tBody.appendChild(newTR);
}

</script>
<br><br>
<jsp:include page="/pages/includes/buttonsBack.jsp"></jsp:include>
</body>
</html:html>

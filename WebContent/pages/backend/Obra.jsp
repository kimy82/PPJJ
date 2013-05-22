<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ page
	import="java.util.List,ca.Entitys.Obra,java.util.Iterator,ca.Entitys.Images,ca.Entitys.Noticia,ca.Entitys.Pdf"%>
<head>
<title><bean:message key="welcome.title" /></title>
<LINK REL=STYLESHEET
	HREF="<html:rewrite href='/PPJJ/css/960.css'></html:rewrite>"
	TYPE="text/css">
<LINK REL=STYLESHEET
	HREF="<html:rewrite href='/PPJJ/css/back.css' ></html:rewrite>"
	TYPE="text/css">


</head>
<html:html lang="ca">
<body>

<div id=header class=container_12 sizcache="291" sizset="0">


<div id=header class="grid_12 ">
<h3>Obres</h3>
</div>

</div>



<div id=content class=container_12 sizcache="303" sizset="0">


<div id=content class="grid_12 ">

<div id=obres class="grid_12 ">
<h1>Obres Creades</h1>
<%
			if (request.getSession().getAttribute("admin") != null
			&& request.getSession().getAttribute("admin").toString()
			.equals("yes")) {
%> <%
 List obres = (List) request.getAttribute("obraList");
 %> <%
 int i = 0;
 %> <%
 for (i = 0; i < obres.size(); i++) {
 %> <%
 Obra obr = (Obra) obres.get(i);
 %>

<p>
<table>
	<tr>
		<td style="width: 120px;"><%=obr.getTitolMenu()%></td>
		<td><input type="button" value="Modificar"
			onclick="visible('obra_<%=i%>');">
			<input type="button" value="Borrar"
			onclick="borrar('<%=obr.getId() %>');"></td>
	</tr>
</table>
  </p>
<div id="obra_<%=i%>" style="visibility: hidden; display: none;">
<div style="background-color: #CCCCCC; height: 5px;"></div>
<br>
<html:form action="/backend/UpdateObra">
  Titol pagina: <html:text name="UpdateObraForm" property="titolpag"
		value="<%=obr.getTitolPag()%>" />
  Titol del menu: <html:text name="UpdateObraForm"
		value="<%=obr.getTitolMenu()%>" property="titolmenu" />
  Tipus obra: <%
			if (obr.getTipusObra() != null
			&& obr.getTipusObra().toString().equals("bloc")) {
%>
	<select onchange="changeObra(this.value,<%=i%>)" id="ObraRefSelect">
		<option selected="selected" value="bloc">BLOC</option>
		<option value="masia">MASIA</option>
		<option value="xalet">XALET</option>
	</select>
	<html:text name="obraRef" property="obraRef" value="bloc"></html:text>
	<%
				} else if (obr.getTipusObra() != null
				&& obr.getTipusObra().toString().equals("xalet")) {
	%>
	<select onchange="changeObra(this.value,<%=i%>)" id="ObraRefSelect">
		<option selected="selected" value="xalet">XALET</option>
		<option value="bloc">BLOC</option>
		<option value="masia">MASIA</option>
	</select>
	<html:text name="obraRef" property="obraRef" value="xalet"></html:text>
	<%
	} else {
	%>
	<select onchange="changeObra(this.value,<%=i%>)" id="ObraRefSelect">
		<option selected="selected" value="masia">MASIA</option>
		<option value="xalet">XALET</option>
		<option value="bloc">BLOC</option>
	</select>
	<html:text name="obraRef" property="obraRef"
		style="visibility: hidden;" value="masia"></html:text>
	<%
	}
	%>
	<%
	int j = 0;
	%>
	<br>
	<br>IMAGES
  <table id="img_<%=obr.getId()%>">
		<tbody>

			<%
			Iterator imgIt = obr.getImages().iterator();
			%>
			<%
			for (j = 0; j < obr.getImages().size(); j++) {
			%>
			<br>
			<%
			Images img = (Images) imgIt.next();
			%>
			<tr>
				<td><html:text name="UpdateObraForm"
					alt="img_<%=img.getId()%>" property="url"
					value="<%=img.getImageUrl() %>"></html:text> <html:text
					name="UpdateObraForm" style="visibility:hidden;" property="urlid"
					value="<%=String.valueOf(img.getId()) %>"></html:text></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	
	<br>
	<br>NOTICIES
  <table id="not_<%=obr.getId()%>">
		<tbody>

			<%
			Iterator notIt = obr.getNoticies().iterator();
			%>
			<%
			for (j = 0; j < obr.getNoticies().size(); j++) {
			%>
			<br>
			<%
			Noticia not = (Noticia) notIt.next();
			%>
			<tr>
				<td>URL: <html:text name="UpdateObraForm"
					alt="img_<%=not.getId()%>" property="urlnoticia"
					value="<%=not.getNoticiaUrl() %>"></html:text>
					Text catala:<html:text name="UpdateObraForm"
					 property="textca"
					value="<%=not.getNomCA() %>"></html:text>
					Text castella:<html:text name="UpdateObraForm"
					 property="textes"
					value="<%=not.getNomES() %>"></html:text>
					Text angles:<html:text name="UpdateObraForm"
					 property="texten"
					value="<%=not.getNomEN() %>">
					</html:text> <html:text
					name="UpdateObraForm" style="visibility:hidden;" property="urlidnoticia"
					value="<%=String.valueOf(not.getId()) %>"></html:text></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<br>PLANOLS
  <table id="pl_<%=obr.getId()%>">
		<tbody>

			<%
			Iterator plIt = obr.getPdf().iterator();
			%>
			<%
			for (j = 0; j < obr.getPdf().size(); j++) {
			%>
			<br>
			<%
			Pdf pl = (Pdf) plIt.next();
			%>
			<tr>
				<td>Planol: <html:text name="UpdateObraForm"
					alt="img_<%=pl.getId()%>" property="plano"
					value="<%=pl.getNomPDF() %>"></html:text>
					Text Catala:<html:text style="width:110px;" name="UpdateObraForm"
					 property="platxtca"
					value="<%=pl.getNomCA() %>"></html:text>
					Text Castella:<html:text style="width:110px;" name="UpdateObraForm"
					 property="platxtes"
					value="<%=pl.getNomES() %>"></html:text>
					Text Angles:<html:text style="width:110px;" name="UpdateObraForm"
					 property="platxten"
					value="<%=pl.getNomEN() %>">
					</html:text> <html:text 
					name="UpdateObraForm" style="visibility:hidden;" property="planolid"
					value="<%=String.valueOf(pl.getId()) %>"></html:text></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<input type="button" value="+ imatges"
		onclick="newimg(<%=obr.getId()%>);" />
	<input type="button" value="+ noticies"
		onclick="newnot(<%=obr.getId()%>);" />
	
	
	<input type="button" value="+ planols"
		onclick="addPlanols(<%=obr.getId()%>);" />
	
	<html:text name="UpdateObraForm" property="idObra"
		style="visibility:hidden; display=none;"
		value="<%= new String(String.valueOf(obr.getId())) %>"></html:text>
	<input type="submit" value="Guardar" />
	<input type="button" value="Tanca" onclick="cloused('obra_<%=i%>');">
	<br>
	<div style="background-color: #CCCCCC; height: 5px;"></div>
</html:form></div>
<%
}
%> <%
 }
 %>
</p>
</div>
</div>
</DIV>
<script type="text/javascript">
function changeObra(obra, i){
var elements = document.getElementsByName("obraRef");
elements.item(i).value=obra;
}
function borrar(id){
	if(confirm('Segur que vols borrar la obra?')){
	window.location.href="/PPJJ/backend/DeleteObra.do?id="+id;
	}
}
function visible(id){
document.getElementById(id).style.visibility= "visible";
document.getElementById(id).style.display = "";
}
function cloused(id){
document.getElementById(id).style.visibility= "hidden";
document.getElementById(id).style.display = "none";
}
function newimg(id){
var table = document.getElementById("img_"+id);
var tBody = table.getElementsByTagName('tbody')[0];
var newTR = document.createElement('tr');
var newTD = document.createElement('td');
newTD.innerHTML = '<html:text name="UpdateObraForm"  property="url"  value="" />';
newTR.appendChild (newTD);
tBody.appendChild(newTR);
}
function newnot(id){
var table = document.getElementById("not_"+id);
var tBody = table.getElementsByTagName('tbody')[0];
var newTR = document.createElement('tr');
var newTD = document.createElement('td');
newTD.innerHTML = 'URL: <html:text name="UpdateObraForm" property="urlnoticia"	value=""></html:text>Text catala:<html:text name="UpdateObraForm" property="textca" value=""></html:text>Text castella:<html:text name="UpdateObraForm" property="textes"	value=""></html:text>Text angles:<html:text name="UpdateObraForm" property="texten" value=""></html:text> <html:text name="UpdateObraForm" style="visibility:hidden;" property="urlidnoticia" value=""></html:text>';
newTR.appendChild (newTD);
tBody.appendChild(newTR);
}
function addPlanols(id){
var table = document.getElementById("pl_"+id);
var tBody = table.getElementsByTagName('tbody')[0];
var newTR = document.createElement('tr');
var newTD = document.createElement('td');
newTD.innerHTML = 'Planol: <html:file name="UpdateObraForm" property="plano" value=""></html:file> Text catala: <html:text style="width:110px;" name="UpdateObraForm"  property="platxtca"  value="" />Text anglès: <html:text style="width:110px;" name="UpdateObraForm"  property="platxten"  value="" />Text castella: <html:text style="width:110px;" name="UpdateObraForm"  property="platxtes"  value="" /><br>';
newTR.appendChild (newTD);
tBody.appendChild(newTR);
}
</script>
<br>
<br>
<input type="button" value="Afegir"
	onclick="window.location.href= '/PPJJ/backend/Afegir.do'">
<jsp:include page="/pages/includes/buttonsBack.jsp"></jsp:include>
</body>
</html:html>

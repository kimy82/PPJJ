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
<body>

<div id=header class=container_12 sizcache="291" sizset="0">


<div id=header class="grid_12 ">
<h3>Dades visites i configuració pantalla principal</h3>
</div>

</div>



<div id=content class=container_12 sizcache="303" sizset="0">


<div id=content class="grid_12 ">
<div id=visites class="grid_12 ">

<p>
<h1>Visites</h1>
<%=request.getAttribute("NumVisitsLastMonth")%><br>
<%=request.getAttribute("NumVisitsAvui")%>
</p>
<br>
<br> 
</div>
<div id=fotos class="grid_12 ">
<h1>Fotos pantalla principal</h1>
<p>
<%
			if (request.getSession().getAttribute("admin") != null
			&& request.getSession().getAttribute("admin").toString()
			.equals("yes")) {
%> <%
 		List images = (List) request.getSession()
 		.getAttribute("images");
 %> <%
 int i = 0;
 %> <%
 for (i = 0; i < images.size(); i++) {
 %> <%
 Images img = (Images) images.get(i);
 %> <img src="<%=img.getImageUrl() %>" height="80px"
	id="img_<%=img.getId()%>" title="<%=img.getOnn()%>"
	value="<%=img.getId()%>"> <input type="button"
	value="Canviar foto"
	onclick="window.open('/PPJJ/backend/PreChangeUrlFoto.do?img=img_<%=img.getId()%>&id=<%=img.getId()%>','changeurlfoto','width=500,height=100') ">
<%
}
%> <%
 }
 %>
</p>
<br>
</div>
<div id=obra class="grid_12 "><input type="button"
	value="Canviar Obra"
	onclick="window.location.href= '/PPJJ/backend/Obra.do'" /> <jsp:include
	page="/pages/includes/buttonsBack.jsp"></jsp:include>
	
	</div>
</div>
</DIV>
</body>
</html:html>

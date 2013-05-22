<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List,ca.Entitys.Images"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Jordi Arquitecte</title>
</head>
<html>
<jsp:include page="/pages/includes/head.jsp"></jsp:include>
<body>
<jsp:include page="/pages/includes/menu.jsp"></jsp:include>
<div class="fotosprincipal">

<div id="carousel">

<%
 		List images = (List) request.getSession()
 		.getAttribute("images");
 %>
 <%int i=0; %> 
 <%
 for (i = 0; i < images.size(); i++) {
 %> <%
 Images img = (Images) images.get(i);
 %> 
	<a href="<%=img.getImageUrl() %>"  rel="imagebox"><img src="<%=img.getImageUrl() %>" width="100%" /></a>
<%
}
%>
</div>
<script type="text/javascript">
	window.onload = 
		function()
		{
			$('#carousel').Carousel(
				{
					itemWidth: 110,
					itemHeight: 62,
					itemMinWidth: 50,
					items: 'a',
					reflections: .5,
					rotationSpeed: 1.8
				}
			);
			$.ImageBox.init(
				{
					loaderSRC: 'http://interface.eyecon.ro/demos/images/imagebox/loading.gif',
					closeHTML: '<img src="images/cerrar_circular.jpg">'
				}
			);
		};
</script>
</div>

<jsp:include page="includes/Mapes.jsp"></jsp:include>

</body>


</html>

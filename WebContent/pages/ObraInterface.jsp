<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Iterator,ca.Entitys.Obra,ca.Entitys.Images"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Jordi Arquitecte</title>
<jsp:include page="/pages/includes/head.jsp"></jsp:include>
<script type="text/javascript">
    $(function(){
        $("div.foo").carousel({direction: "vertical"});
    });
</script>
</head>
<html>

<body>
<%Obra obra = (Obra)request.getSession().getAttribute("obra"); %>
<div class="letra"><%=obra.getTitolPag()%></div>
<div class="botons">
<ul id="menu">
	<li><a href="/PPJJ/Welcome.do" id="show-panel"><bean:message
		key="tornar" /></a></li>
	<%if (obra.getNoticies().size()>0){ %>
	<li><a href="#" id="show-panel3"><bean:message
		key="noticies" /></a></li>
	<%} %>
	<%if (obra.getPdf().size()>0){ %>
	<li><a href="#" id="show-panel4"><bean:message
		key="planols" /></a></li>
	<%} %>
</ul>
</div>
<div class="carrosel">
<div class="foo">

    <ul style="width: 0px !important;">
    <% Iterator images = obra.getImages().iterator(); %>
    <%while(images.hasNext()){ %>
    	<%Images img = (Images)images.next(); %>
        <li><img width="500" height="335" src="<%=img.getImageUrl()%>" alt="image1" /></li>
    <%} %>
    </ul>
</div>
</div>
<jsp:include page="noticiesInterface.jsp"></jsp:include>
<jsp:include page="planolsInterface.jsp"></jsp:include>
</body>
</html>
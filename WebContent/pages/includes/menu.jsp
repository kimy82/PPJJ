<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.List,ca.Entitys.Obra"%>
<script type="text/javascript" charset="utf-8">
	$(function() {
		$('#menu li a').click(function(event) {
			var elem = $(this).next();
			if (elem.is('ul')) {
				event.preventDefault();
				$('#menu ul:visible').not(elem).slideUp();
				elem.slideToggle("slow");
			}
		});
		$('.sub').click(function(event) {
			event.preventDefault();
			$('#menu ul:visible').slideDown();
			$('.sub ul').slideToggle("slow");
		});

	});
	$(document).ready(function() {
		$("a#show-panel").click(function() {
			$("#lightbox, #lightbox-panel").fadeIn(300);
		})
		$("a#close-panel").click(function() {
			$("#lightbox, #lightbox-panel").fadeOut(300);
		})
	})

	$(document).ready(function() {
		$("a#show-panel2").click(function() {
			$("#lightbox2, #lightbox-panel2").fadeIn(300);
			load20();
		})
		$("a#close-panel2").click(function() {
			$("#lightbox2, #lightbox-panel2").fadeOut(300);
		})
	})
	$(document).ready(function() {
		$("a#show-panel3").click(function() {
			$("#lightbox3, #lightbox-panel3").fadeIn(300);
			load20();
		})
		$("a#close-panel3").click(function() {
			$("#lightbox3, #lightbox-panel3").fadeOut(300);
		})
	})
	$(document).ready(function() {
		$("a#show-panel4").click(function() {
			$("#lightbox4, #lightbox-panel4").fadeIn(300);
			
		})
		$("a#close-panel4").click(function() {
			$("#lightbox4, #lightbox-panel4").fadeOut(300);
		})
	})
	
</script>
<div class="premenu">
<ul id="menu">
	<li><a href="#" id="show-panel"><bean:message
		key="principal.presentacio" /></a></li>
	<li><a href="#"><bean:message key="principal.projectes" /></a>
	<ul>
		<li><a class="sub" href="#"><bean:message
			key="principal.xalets" /></a>
		<ul>
		
		<%
 		List obres = (List) request.getSession()
 		.getAttribute("obres");
		 %>
 		<%int i=0; %> 
 		<% for (i = 0; i < obres.size(); i++) {%> 
 		<%
		 Obra obra = (Obra) obres.get(i);
		 %> 
		 <%if (obra.getTipusObra()!= null && obra.getTipusObra().toString().equals("xalet") ){ %>
		 	<li><a href="/PPJJ/ObreObra.do?idObra=<%=obra.getId()%>">&nbsp;&nbsp;&nbsp;<%=obra.getTitolMenu() %></a></li>
		<%} %>
<%
}
%>
		</ul>
		</li>
		<li><a class="sub" href="#"><bean:message
			key="principal.blocs" /></a>
		<ul>
		<% for (i = 0; i < obres.size(); i++) {%> 
 		<%
		 Obra obra = (Obra) obres.get(i);
		 %> 
		 <%if (obra.getTipusObra()!= null && obra.getTipusObra().toString().equals("bloc") ){ %>
		 	<li><a href="/PPJJ/ObreObra.do?idObra=<%=obra.getId()%>">&nbsp;&nbsp;&nbsp;<%=obra.getTitolMenu() %></a></li>
		<%} %>
		<%}%>
		</ul>
		</li>
		<li><a class="sub" href="#"><bean:message
			key="principal.masies" /></a>
		<ul>
		<% for (i = 0; i < obres.size(); i++) {%> 
 		<%
		 Obra obra = (Obra) obres.get(i);
		 %> 
		 <%if (obra.getTipusObra()!= null && obra.getTipusObra().toString().equals("masia") ){ %>
		 	<li><a href="/PPJJ/ObreObra.do?idObra=<%=obra.getId()%>">&nbsp;&nbsp;&nbsp;<%=obra.getTitolMenu() %></a></li>
		<%} %>
		<%}%>
		</ul>
		</li>
	</ul>
	</li>
	<li><a href="#" id="show-panel2"><bean:message
		key="principal.contactar" /></a></li>
	<li><a href="/PPJJ/Private.do"><bean:message key="area.privada" /></a></li>
</ul>
</div>
<jsp:include page="../Presentacio.jsp"></jsp:include>
<jsp:include page="../Contactar.jsp"></jsp:include>
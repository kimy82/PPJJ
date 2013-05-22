<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.Iterator,ca.Entitys.Obra,ca.Entitys.Pdf"%>
<%Obra obra = (Obra)request.getSession().getAttribute("obra"); %>
<script type="text/javascript">


function obrePresentacio(enter){
//scrip per menu desplegable
$("#menu").slideUp();
document.getElementById(enter).style.display="";
document.getElementById(enter).style.visibility="visible";
}


</script>
<div id="lightbox-panel4">
<div class="rightcss"><a id="close-panel4" href="#"><img
	src="images/cerrar_circular.jpg"></a></div>

<table border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td width=10% bgcolor="black" valign=top></td>
		<td width=20% valign=top bgcolor="#CCCCCC"><br>
		<br>
		<font face="Verdana:bold" color="#CCCC33" size="6"> <br>
		    <% Iterator pdfIter = obra.getPdf().iterator(); %>
    		<%while(pdfIter.hasNext()){ %>
    			<%Pdf pdf = (Pdf)pdfIter.next(); %>
								<ul class="menu flt">    			
									<li class=""><a href="#"
										onclick="javascript:obrePresentacio('pdf_<%=pdf.getId()%>');">
										<%if(request.getSession().getAttribute("idioma")!= null && request.getSession().getAttribute("idioma").toString().equals("EN")){ %>
											<%=pdf.getNomEN() %>
										<%} else if (request.getSession().getAttribute("idioma")!= null && request.getSession().getAttribute("idioma").toString().equals("ES")){%>
											<%=pdf.getNomES() %>
										<%}else{ %>
											<%=pdf.getNomCA() %>
										<%} %>
										</a></li>
						
								</ul>
								<br>    			

    		<%} %>
		</td>
		<td width=5% valign=top bgcolor="#CCCCCC"></td>
		<td width="500px">
		    <% pdfIter = obra.getPdf().iterator(); %>
    		<%while(pdfIter.hasNext()){ %>
    			<%Pdf pdf = (Pdf)pdfIter.next(); %>
    					<div id="pdf_<%=pdf.getId() %>"><embed src="pdf/<%=pdf.getNomPDF()%>" width="600" height="475"></embed></div>
    		<%} %>
		
		</td>
		<td bgcolor="black"></td>


	</tr>
</table>


<p align="center">
</div>
<!-- /lightbox-panel -->

<div id="lightbox4"></div>
<!-- /lightbox -->



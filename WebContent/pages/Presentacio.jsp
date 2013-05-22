<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<div id="lightbox-panel">
<div class="rightcss"><a id="close-panel" href="#"><img
	src="images/cerrar_circular.jpg"></a></div>
<h2><bean:message key="titlepresentacio" /></h2>
<p><bean:message key="infopresentacio" /></p>
<p align="center">
<ul class="menus flts">

	<lis class="">
	<a href="#" onclick=""><bean:message key="dissenyProjec" /></a>
	</lis>
	<lis class="">
	<a href="#"><bean:message key="direcControl" /></a>
	</lis>
	<lis class="">
	<a href="#"><bean:message key="estVia" /></a>
	</lis>
	<lis class="">
	<a href="#"><bean:message key="cedules" /></a>
	</lis>

</ul>



</div>
<!-- /lightbox-panel -->

<div id="lightbox"></div>
<!-- /lightbox -->



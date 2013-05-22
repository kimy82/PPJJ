<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<script
	src="http://maps.google.com/maps?file=api&amp;v=2&amp;sensor=true&amp;key=ABQIAAAAeVUCihIEA01FwNVVaBTV-RSHeUN1fgw0-Z6DP24oSwGAKQlwnBRYrU_tm1o5z_IsjWwRlL6bHAekkA"
	type="text/javascript"></script>
<div id="lightbox-panel2">
<div class="rightcss"><a id="close-panel2" href="#"><img
	src="images/cerrar_circular.jpg"></a></div>
<h2><bean:message key="titlecontactar" /></h2>
<table>
<td width=55%  style="background-color: #CCCC33">

 <div id="map" style="width:500px;height:300px"></div>
	<div class="menubg flt">
	<ul class="menu flt">
		<li class=""><a href="#" onclick="javascript:load10();" >zoom in</a></li>
		<li class=""><a href="#" onclick="javascript:load20();" >zoom out</a></li>
</ul>	

</div>
</td>
</table>
<table class="info" >
<tr>
<td>
<bean:message key="direccio" /></td><td><bean:message key="adreca" /></td>
</tr>
<tr>
<td>
<bean:message key="tel" /></td>
</tr>
<tr><td><bean:message key="mobil" /></td><td><a href="pages/mail.jsp" target="_blank" onClick="window.open(this.href, this.target, 'width=500,height=400'); return false;" ><font color="black" style="font-family: fantasy" > info@arquitectejordiorra.com</font></a></td></tr>
</table>
<p align="center">
</div>
<!-- /lightbox-panel -->

<div id="lightbox2"></div>
<!-- /lightbox -->

<script type="text/javascript">
	function load() {
		if (GBrowserIsCompatible()) {
			var map = new GMap2(document.getElementById("map"));
			map.setCenter(new GLatLng(41.788817, 3.032098), 14);
			map.addOverlay(new GMarker(new GPoint(3.032098, 41.788817)));
		}
	}
	function load2() {
		if (GBrowserIsCompatible()) {
			var map = new GMap2(document.getElementById("map"));
			map.setCenter(new GLatLng(41.788817, 3.032098), 13);
			map.addOverlay(new GMarker(new GPoint(3.032098, 41.788817)));
		}
	}
	function load22() {
		if (GBrowserIsCompatible()) {
			var map = new GMap2(document.getElementById("map"));
			map.setCenter(new GLatLng(41.788817, 3.032098), 12);
			map.addOverlay(new GMarker(new GPoint(3.032098, 41.788817)));
		}
	}
	function load1() {
		if (GBrowserIsCompatible()) {
			var map = new GMap2(document.getElementById("map"));
			map.setCenter(new GLatLng(41.788817, 3.032098), 15);
			map.addOverlay(new GMarker(new GPoint(3.032098, 41.788817)));
		}
	}
	function load11() {
		if (GBrowserIsCompatible()) {
			var map = new GMap2(document.getElementById("map"));
			map.setCenter(new GLatLng(41.788817, 3.032098), 16);
			map.addOverlay(new GMarker(new GPoint(3.032098, 41.788817)));
		}
	}

	var m = 2;
	function load10() {

		if (m == 0) {
			load2();
			m++;
		} else if (m == 1) {
			load();
			m++;
		} else if (m == 2) {
			load1();
			m++;
		} else if (m == 3) {
			load11();
			m++;
		} else if (m == 4) {
		}

	}
	function load20() {

		if (m == 0) {
		} else if (m == 1) {
			load22();
			m--;
		} else if (m == 2) {
			load2();
			m--;
		}
		if (m == 3) {
			load();
			m--;
		}
		if (m == 4) {
			load1();
			m--;
		}

	}
	
</script>


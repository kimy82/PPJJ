<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ page import="java.util.LinkedList,ca.Entitys.Images"%>
<html:html lang="ca">
<head>
<title><bean:message key="welcome.title" /></title>
<html:base />
</head>
<body bgcolor="white">

New Url:
<input type="text" id="url" width="90px" value="" />
<input type="button" id="accept" value="acceptar" onclick="ChangeUrl()" title="Accept">
<script type="text/javascript">

function ChangeUrl(){
var img ='<%= request.getAttribute("img")%>';
var id = '<%= request.getAttribute("id")%>';
var onn = window.opener.document.getElementById(img).title;
var urlvalue =document.getElementById("url").value;
window.location.href="/PPJJ/backend/ChangeUrlFoto.do?url="+urlvalue+"&id="+id+"&onn=principals";
}

</script>
</body>
</html:html>

<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
 
<SCRIPT LANGUAGE="JavaScript">
function GetCookie (name) { 
var arg = name + "="; 
var alen = arg.length; 
var clen = document.cookie.length; 
var i = 0; 
while (i < clen) {
var j = i + alen; 
if (document.cookie.substring(i, j) == arg) 
return getCookieVal (j); 
i = document.cookie.indexOf(" ", i) + 1; 
if (i == 0) break; 
} 
return null;
}
function SetCookie (name, value) { 
var argv = SetCookie.arguments; 
var argc = SetCookie.arguments.length; 
var expires = (argc > 2) ? argv[2] : null; 
var path = (argc > 3) ? argv[3] : null; 
var domain = (argc > 4) ? argv[4] : null; 
var secure = (argc > 5) ? argv[5] : false; 
document.cookie = name + "=" + escape (value) + 
((expires == null) ? "" : ("; expires=" + expires.toGMTString())) + 
((path == null) ? "" : ("; path=" + path)) + 
((domain == null) ? "" : ("; domain=" + domain)) + 
((secure == true) ? "; secure" : "");
}
function DeleteCookie (name) { 
var exp = new Date(); 
exp.setTime (exp.getTime() - 1); 
var cval = GetCookie (name); 
document.cookie = name + "=" + cval + "; expires=" + exp.toGMTString();
}
var expDays = 30;
var exp = new Date(); 
exp.setTime(exp.getTime() + (expDays*24*60*60*1000));
function amt(){
var count = GetCookie('count')
if(count == null) {
SetCookie('count','1')
return 1
}
else {
var newcount = parseInt(count) + 1;
DeleteCookie('count')
SetCookie('count',newcount,exp)
return count
}
}
function getCookieVal(offset) {
var endstr = document.cookie.indexOf (";", offset);
if (endstr == -1)
endstr = document.cookie.length;
return unescape(document.cookie.substring(offset, endstr));
}
</SCRIPT>

<head>
<title>Login</title>
<LINK REL=STYLESHEET
      HREF="css/960.css"
      TYPE="text/css">
<LINK REL=STYLESHEET
      HREF="css/back.css"
      TYPE="text/css">


</head>
<body>

<div id=header class=container_12 sizcache="1241" sizset="0">


<div class=grid_12></div>

</div>



<div id=content class=container_12 sizcache="1535" sizset="0">


<div class="grid_12 container" sizcache="1535" sizset="0">


<div class="grid_12 building alpha omega"></div>
<html:form action="/Login" >         
<table class=middle >
<tr>
<td>
User Name :</td><td><html:text name="LoginForm" property="userName" />  </td></tr>
<tr>
<td>
Password  :</td><td><html:password name="LoginForm" property="password" /> </td></tr>
<tr>
<td>
<html:submit value="Login" />     </td></tr></table>
</html:form> 
</div>
<SCRIPT LANGUAGE="JavaScript">
<!-- Begin
document.write("Tu has estado aqui <b>" + amt() + "</b> veces.")
// End -->
</SCRIPT>
</DIV>


<div id=footer class=container_12>


<div class="grid_12 footerback"></div>

</div>
<%if(request.getParameter("error")!=null && request.getParameter("error").toString().equals("noAdmin")){ %>
<h4>NO HAS INTRODUIT EL PASSWORD</h4>
<%} %>
</body>
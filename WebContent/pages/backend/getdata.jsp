<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="ca.Listeners.DummyDB"%>
<%
    DummyDB db = new DummyDB();
 
    String query = request.getParameter("q");
 
    List countries = db.getData(query);
 
    Iterator iterator = countries.iterator();
    while(iterator.hasNext()) {
        String country = (String)iterator.next();
        out.println(country);
    }
%>

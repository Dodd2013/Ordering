<%--
  Created by IntelliJ IDEA.
  User: Dodd
  Date: 2015/4/19
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="com.language.properties.GetLanguage" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Home</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
</head>

<body>
<a href="reg.jsp"><%= GetLanguage.getString(request, "reg")%>
</a>
</body>
</html>

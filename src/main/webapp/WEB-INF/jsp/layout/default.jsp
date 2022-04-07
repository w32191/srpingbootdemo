<%--
  Created by IntelliJ IDEA.
  User: samwang
  Date: 2022/3/30
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Title</title>
    <%--  這樣用contextRoot，就會對應到webapp這層資料夾--%>
    <link href="${contextRoot}/css/bootstrap.min.css" rel="stylesheet"/>
</head>

<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="${contextRoot}/">Home
                    <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${contextRoot}/message/add">新增留言</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${contextRoot}/message/viewMessages">查看留言</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${contextRoot}/message/ajax">Ajax+RESTful </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Disabled</a>
            </li>
        </ul>
    </div>
</nav>

<script src="${contextRoot}/js/jquery-3.6.0.min.js"></script>
<script src="${contextRoot}/js/bootstrap.bundle.min.js"></script>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: samwang
  Date: 2022/3/31
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>

<jsp:include page="layout/default.jsp"/>
<div class="container">
    <p></p>
    <div class="row justify-content-center">
        <div class="col-12">
            <div class="card">
                <div class="card-header">
                    編輯訊息
                </div>
                <div class="card-body">
                    <%--@elvariable id="workMessages" type="com.ispan.springbootdemo.Entity.WorkMessages"--%>
                    <form:form class="form" method="post" modelAttribute="workMessages">
                        <form:input path="id" type="hidden"/>
                        <form:input path="added" type="hidden"/>
                        <div class="input-group">
                            <form:textarea path="text" class="form-control"/>
                        </div>
                        <p></p>
                        <input type="submit" name="submit" value="送出">
                        <!-- form:errors bindResult回傳的error -->
                        <p style="color:red"><form:errors path="text"/></p>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>

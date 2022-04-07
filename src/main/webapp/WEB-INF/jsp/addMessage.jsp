<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="layout/default.jsp"/>

<div class="container">
    <p></p>
    <div class="row justify-content-center">
        <div class="col-12">
            <div class="card">
                <div class="card-header">
                    新增訊息
                </div>
                <div class="card-body">
                    <%--@elvariable id="workMessages" type="com.ispan.springbootdemo.Entity.WorkMessages"--%>
                    <form:form class="form" method="post" modelAttribute="workMessages">
                        <div class="input-group">
                            <form:textarea path="text" class="form-control"/>
                        </div>
                        <input type="submit" name="submit" value="新增訊息">
                        <!-- form:errors bindResult回傳的error -->
                        <p style="color:red"><form:errors path="text"/></p>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
    <p></p>
    <div class="row justify-content-center">
        <div class="col-9">
            <div class="card">
                <div class="card-header">
                    最新訊息（時間）
                    <span>
                        <%--@elvariable id="lastMsg" type="com.ispan.springbootdemo.Entity.WorkMessages"--%>
                        <fmt:formatDate value="${lastMsg.added}"
                                        pattern="yyyy-MM-dd HH:mm:ss EEEE"/>
                    </span>
                </div>
                <div class="card-body">
                    <c:out value="${lastMsg.text}"/>

                </div>
            </div>
        </div>
    </div>

</div>

<%--
  Created by IntelliJ IDEA.
  User: samwang
  Date: 2022/3/31
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>

<jsp:include page="layout/default.jsp"/>

<div class="container">
    <%--@elvariable id="pagesBack" type="org.springframework.data.domain.Page"--%>
    <c:forEach var="workMessage" items="${pagesBack.content}">
        <p></p>
        <div class="row justify-content-center">
            <div class="col-9">
                <div class="card">
                    <div class="card-header">
                        時間：
                        <span>
                            <%--@elvariable id="lastMsg" type="com.ispan.springbootdemo.Entity.WorkMessages"--%>
                            <fmt:formatDate value="${workMessage.added}"
                                            pattern="yyyy-MM-dd  HH:mm:ss EEEE"/>
                        </span>
                    </div>
                    <div class="card-body">
                        <c:out value="${workMessage.text}"/>
                        <div class="edit-link">
                            <a href="${contextRoot}/message/editMessage?id=${workMessage.id}">編輯</a>
                            <span>|</span>
                            <a onclick="return confirm('確認是否要刪除？')"
                               href="${contextRoot}/message/deleteMessage?id=${workMessage.id}">刪除</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <p></p>
    </c:forEach>

    <div class="row justify-content-center">
        <div class="col-9">
            <c:forEach begin="1" end="${pagesBack.totalPages}" step="1" var="pageNumber">
                <c:choose>
                    <c:when test="${pagesBack.number != pageNumber-1}">
                        <a href="${contextRoot}/message/viewMessages?p=${pageNumber}">
                            <c:out value="${pageNumber}"/>
                        </a>
                    </c:when>
                    <c:otherwise>
                        <c:out value="${pageNumber}"/>
                    </c:otherwise>
                </c:choose>
                <c:if test="${pageNumber != pagesBack.totalPages}">
                    <span> | </span>
                </c:if>
            </c:forEach>
        </div>
    </div>
</div>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>

<jsp:include page="layout/default.jsp"/>
<html>

<head>
    <title>Title</title>

</head>

<body>
<h1>Ajax Page</h1>

<div class="container">
    <input id="myMessage"/>
    <button id="submitBtn">Submit</button>

    <div>
        <table class="mytable" id="list_table_json">
            <thead>
            <tr>
                <th>訊息內容</th>
                <th>時間</th>
            </tr>
            </thead>
            <tbody id="theTbody"></tbody>
        </table>
    </div>
</div>

<script>
  $(function () {
    $('#submitBtn').click(function () {
      let inputText = $("#myMessage").val();
      let dtoObject = {'message': inputText};
      let dtoJsonString = JSON.stringify(dtoObject);

      $.ajax({
        url: 'http://localhost:8080/myapp/api/postMessage',
        contentType: 'application/json; charset=UTF-8', // 送過去的
        dataType: 'json', // 傳回來的
        method: 'post',
        data: dtoJsonString,
        success: function (result) {
          $('#theTbody').children().remove();
          console.log(result);
          let msg_data = '';

          $.each(result, function (index, value) {
            msg_data += '<tr>';
            msg_data += '<td>' + value.text + '</td>';
            msg_data += '<td>' + value.added + '</td>';
            msg_data += '</tr>';
          });

          $('#theTbody').append(msg_data);

        },
        error: function (err) {
          console.log(err)
        }
      });


    });

  });


</script>

</body>

</html>

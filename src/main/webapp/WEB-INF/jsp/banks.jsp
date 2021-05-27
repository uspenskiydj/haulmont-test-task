<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Banks</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<section>
    <h3><a href="/">Домой</a></h3>
    <hr/>
    <h2>Банки</h2>
    <form method="post" action="banks">
        <button type="submit">Добавить банк</button>
    </form>
    <br><br>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>Идентификатор банка</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <c:forEach items="${banks}" var="bank">
            <jsp:useBean id="bank" type="com.haulmont.testtask.model.Bank"/>
            <tr>
                <td>${bank.id}</td>
                <td><a href="#">Update</a></td>
                <td><a href="banks/delete?id=${bank.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</section>
</body>
</html>

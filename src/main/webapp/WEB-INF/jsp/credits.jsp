<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Credits</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<section>
    <h3><a href="/">Домой</a></h3>
    <hr/>
    <h2>Кредиты</h2>
    <a href="creditCreateForm">Добавить кредит</a>
    <br><br>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>Лимит по кредиту</th>
            <th>Процентная ставка</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <c:forEach items="${credits}" var="credit">
            <jsp:useBean id="credit" type="com.haulmont.testtask.model.Credit"/>
            <tr>
                <td>${credit.limit}</td>
                <td>${credit.interestRate}</td>
                <td><a href="creditUpdateForm?id=${credit.id}">Update</a></td>
                <td><a href="credits/delete?id=${credit.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</section>
</body>
</html>

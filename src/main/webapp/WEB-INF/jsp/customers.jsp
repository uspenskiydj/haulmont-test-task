<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customers</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<section>
    <h3><a href="/">Домой</a></h3>
    <hr/>
    <h2>Клиенты</h2>
    <a href="customerCreateForm">Добавить клиента</a>
    <br><br>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>ФИО</th>
            <th>Номер телефона</th>
            <th>Электронная почта</th>
            <th>Номер паспорта</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <c:forEach items="${customers}" var="customer">
            <jsp:useBean id="customer" type="com.haulmont.testtask.model.Customer"/>
            <tr>
                <td>${customer.FIO}</td>
                <td>${customer.phoneNumber}</td>
                <td>${customer.email}</td>
                <td>${customer.passportNumber}</td>
                <td><a href="customerUpdateForm?id=${customer.id}">Update</a></td>
                <td><a href="customers/delete?id=${customer.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</section>
</body>
</html>

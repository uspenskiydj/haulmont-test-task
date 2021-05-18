<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Клиент</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<section>
    <h3><a href="/">Домой</a></h3>
    <hr>
    <h2>${param.action == 'create' ? 'Добавить клиента' : 'Редактирование клиента'}</h2>
    <jsp:useBean id="customer" type="com.haulmont.testtask.model.Customer" scope="request"/>
    <form method="post" action="customers">
        <input type="hidden" name="id" value="${customer.id}">
        <dl>
            <dt>ФИО:</dt>
            <dd><input type="text" value="${customer.FIO}" name="FIO" required></dd>
        </dl>
        <dl>
            <dt>Номер телефона:</dt>
            <dd><input type="text" value="${customer.phoneNumber}" name="phoneNumber" required></dd>
        </dl>
        <dl>
            <dt>Электронная почта:</dt>
            <dd><input type="text" value="${customer.email}" name="email" required></dd>
        </dl>
        <dl>
            <dt>Номер паспорта:</dt>
            <dd><input type="text" value="${customer.passportNumber}" name="passportNumber" required></dd>
        </dl>
        <button type="submit">Save</button>
        <button onclick="window.history.back()" type="button">Cancel</button>
    </form>
</section>
</body>
</html>

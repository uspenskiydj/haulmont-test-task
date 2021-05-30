<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="webjars/bootstrap/4.5.3/css/bootstrap.min.css">
</head>
<body>
<section>
    <h3><a href="/">Домой</a></h3>
    <hr>
    <div class="container">
        <h2>${param.action == 'create' ? 'Добавить клиента' : 'Редактирование клиента'}</h2>
        <br>
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
            <dl>
                <dt>Банк:</dt>
                <dd><select name="bankId">
                    <c:forEach items="${banks}" var="bank" varStatus="сounter">
                        <option value="${bank.id}">
                            Банк ${сounter.count}
                        </option>
                    </c:forEach>
                </select>
                <dd>
            </dl>
            <button class="btn btn-primary" type="submit">Сохранить</button>
            <button class="btn btn-secondary" onclick="window.history.back()" type="button">Назад</button>
        </form>
</section>
</div>
</body>
</html>

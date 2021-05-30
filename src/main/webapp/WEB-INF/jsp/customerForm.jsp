<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Customer</title>
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
        <form:form method="post" action="customers" modelAttribute="customer">
        <input type="hidden" name="id" value="${customer.id}">
        <dl>
            <dt><form:label path="fio">ФИО:</form:label></dt>
            <dd><form:input path="fio" class="form-control"/>
                <form:errors path="fio" cssClass="error"/></dd>
        </dl>
        <dl>
            <dt><form:label path="phoneNumber">Номер телефона:</form:label></dt>
            <dd><form:input path="phoneNumber" class="form-control"/>
                <form:errors path="phoneNumber" cssClass="error"/></dd>
        </dl>
        <dl>
            <dt><form:label path="email">Электронная почта:</form:label></dt>
            <dd><form:input path="email" class="form-control"/>
                <form:errors path="email" cssClass="error"/></dd>
        </dl>
        <dl>
            <dt><form:label path="passportNumber">Номер паспорта:</form:label></dt>
            <dd><form:input path="passportNumber" class="form-control"/>
                <form:errors path="passportNumber" cssClass="error"/></dd>
        </dl>
        <dl>
            <dt>Банк:</dt>
            <dd><form:select path="bank" class="form-control">
                    <c:forEach items="${banks}" var="bank" varStatus="сounter">
                        <form:option value="${bank.id}">Банк ${сounter.count}</form:option>
                    </c:forEach>
                </form:select>
            </dd>
        </dl>
        <button class="btn btn-primary" type="submit">Сохранить</button>
        <button class="btn btn-secondary" onclick="window.history.back()" type="button">Назад</button>
        </form:form>
</section>
</div>
</body>
</html>

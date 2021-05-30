<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customers</title>
    <link rel="stylesheet" href="webjars/bootstrap/4.5.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="webjars/noty/3.1.4/demo/font-awesome/css/font-awesome.min.css">
</head>
<body>
<section>
    <h3><a href="/">Домой</a></h3>
    <hr/>
    <div class="container">
        <h2>Клиенты</h2>
        <br>
        <form action="customerCreateForm">
            <button class="btn btn-primary" type="submit">
                <span class="fa fa-plus"></span>
                Добавить клиента
            </button>
        </form>
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
                    <td>${customer.fio}</td>
                    <td>${customer.phoneNumber}</td>
                    <td>${customer.email}</td>
                    <td>${customer.passportNumber}</td>
                    <td><a href="customerUpdateForm?id=${customer.id}"><span class="fa fa-pencil"></span></a></td>
                    <td><a href="customers/delete?id=${customer.id}"><span class="fa fa-remove"></span></a></td>
                </tr>
            </c:forEach>
        </table>
</section>
</div>
</body>
</html>

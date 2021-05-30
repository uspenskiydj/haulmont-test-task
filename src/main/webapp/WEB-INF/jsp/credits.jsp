<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Credits</title>
    <link rel="stylesheet" href="webjars/bootstrap/4.5.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="webjars/noty/3.1.4/demo/font-awesome/css/font-awesome.min.css">
</head>
<body>
<section>
    <h3><a href="/">Домой</a></h3>
    <hr/>
    <div class="container">
        <h2>Кредиты</h2>
        <br>
        <form action="creditCreateForm">
            <button class="btn btn-primary" type="submit">
                <span class="fa fa-plus"></span>
                Добавить кредит
            </button>
        </form>
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
                    <td><a href="creditUpdateForm?id=${credit.id}"><span class="fa fa-pencil"></span></a></td>
                    <td><a href="credits/delete?id=${credit.id}"><span class="fa fa-remove"></span></a></td>
                </tr>
            </c:forEach>
        </table>
</section>
</div>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Payments</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="webjars/bootstrap/4.5.3/css/bootstrap.min.css">
</head>
<body>
<section>
    <h3><a href="/">Домой</a></h3>
    <button class="btn btn-secondary" onclick="window.history.back()" type="button">Назад</button>
    <hr/>
    <div class="container">
        <h2>Платежи</h2>
        <br>
        <table border="1" cellpadding="8" cellspacing="0">
            <thead>
            <tr>
                <th>Дата платежа</th>
                <th>Сумма платежа</th>
                <th>Сумма гашения тела кредита</th>
                <th>Сумма гашения процентов</th>
                <th>Остаток долга</th>
            </tr>
            </thead>
            <c:forEach items="${payments}" var="payment" varStatus="сounter">
                <jsp:useBean id="payment" type="com.haulmont.testtask.model.Payment"/>
                <tr>
                    <td>${payment.date}</td>
                    <td><fmt:formatNumber value="${payment.totalAmount}" maxFractionDigits="2"/></td>
                    <td><fmt:formatNumber value="${payment.amountOfCreditBodyRepayment}" maxFractionDigits="2"/></td>
                    <td><fmt:formatNumber value="${payment.amountOfInterestRepayment}" maxFractionDigits="2"/></td>
                    <td><fmt:formatNumber value="${creditBalancePerMonth.get(сounter.index)}"
                                          maxFractionDigits="2"/></td>
                </tr>
            </c:forEach>
        </table>
</section>
</div>
</body>
</html>

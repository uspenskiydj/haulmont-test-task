<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Payments</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<section>
    <h3><a href="/">Домой</a></h3>
    <hr/>
    <h2>Платежи</h2>
    <br><br>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>Дата платежа</th>
            <th>Сумма платежа</th>
            <th>Сумма гашения тела кредита</th>
            <th>Сумма гашения процентов</th>
        </tr>
        </thead>
        <c:forEach items="${payments}" var="payment">
            <jsp:useBean id="payment" type="com.haulmont.testtask.model.Payment"/>
            <tr>
                <td>${payment.date}</td>
                <td>${payment.totalAmount}</td>
                <td>${payment.amountOfCreditBodyRepayment}</td>
                <td>${payment.amountOfInterestRepayment}</td>
            </tr>
        </c:forEach>
    </table>
</section>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>New Credit Proposal</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<section>
    <h3><a href="/">Домой</a></h3>
    <hr>
    <h2>Оформление кредита</h2>
    <jsp:useBean id="creditProposal" type="com.haulmont.testtask.model.CreditProposal" scope="request"/>
    <form method="post" action="creditProposals">
        <dl>
            <dt>Клиент:</dt>
            <dd><select name="customerId" disabled>
                <jsp:useBean id="customer" type="com.haulmont.testtask.model.Customer" scope="request"/>
                    <option value="${customer.id}">
                            ${customer.FIO} &nbsp; ${customer.email}
                    </option>
            </select><dd>
        </dl>
        <dl>
            <dt>Кредит:</dt>
            <dd><select name="creditId" disabled>
                <jsp:useBean id="credit" type="com.haulmont.testtask.model.Credit" scope="request"/>
                <option value="${credit.id}">
                    Ставка: &nbsp; ${credit.interestRate} &nbsp; Лимит: &nbsp; ${credit.limit}
                </option>
            </select><dd>
        </dl>
        <dl>
            <dt>Сумма кредита:</dt>
            <dd><input type="text" value="${creditProposal.creditAmount}" name="creditAmount" disabled required></dd>
        </dl>
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
        <button type="submit">Оформить кредит</button>
        <button onclick="window.history.back()" type="button">Cancel</button>
    </form>
</section>
</body>
</html>


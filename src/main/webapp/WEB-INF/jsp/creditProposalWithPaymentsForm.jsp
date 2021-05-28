<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <form:form method="post" action="creditProposals" modelAttribute="creditProposal">
        <dl>
            <dt>Клиент:</dt>
            <dd><select name="customerId" disabled>
                    <option value="${creditProposal.customer.id}">
                            ${creditProposal.customer.FIO} &nbsp; ${creditProposal.customer.email}
                    </option>
            </select><dd>
        </dl>
        <dl>
            <dt>Кредит:</dt>
            <dd><select name="creditId" disabled>
                <option value="${creditProposal.credit.id}">
                    Ставка: &nbsp; ${creditProposal.credit.interestRate} &nbsp; Лимит: &nbsp; ${creditProposal.credit.limit}
                </option>
            </select><dd>
        </dl>
        <dl>
            <dt>Сумма кредита:</dt>
            <dd><input type="text" value="${creditProposal.creditAmount}" name="creditAmount" disabled></dd>
        </dl>
        <dl>
            <dt>Итоговая сумма процентов по кредиту:</dt>
            <dd><input type="text" value="${percentSum}" name="percentSum" disabled></dd>
        </dl>
        <button type="submit">Оформить кредит</button>
        <button onclick="window.history.back()" type="button">Назад</button>
        <br><br>
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
            <c:forEach items="${creditProposal.payments}" var="payment" varStatus="сounter">
                <jsp:useBean id="payment" type="com.haulmont.testtask.model.Payment"/>
                <tr>
                    <td>${payment.date}</td>
                    <td><fmt:formatNumber value="${payment.totalAmount}" maxFractionDigits="2"/></td>
                    <td><fmt:formatNumber value="${payment.amountOfCreditBodyRepayment}" maxFractionDigits="2"/></td>
                    <td><fmt:formatNumber value="${payment.amountOfInterestRepayment}" maxFractionDigits="2"/></td>
                    <td>${creditBalancePerMonth.get(сounter.index)}</td>
                </tr>
            </c:forEach>
        </table>
    </form:form>
</section>
</body>
</html>


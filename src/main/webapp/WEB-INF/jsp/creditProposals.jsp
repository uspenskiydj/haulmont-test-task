<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Credit Proposals</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<section>
    <h3><a href="/">Домой</a></h3>
    <hr/>
    <h2>Кредитные предложения</h2>
    <a href="creditCreateForm">Добавить кредитное предложение</a>
    <br><br>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>Клиент</th>
            <th>Кредит</th>
            <th>Сумма кредита</th>
            <th>График платежей</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <c:forEach items="${creditsProposals}" var="creditProposal">
            <jsp:useBean id="creditProposal" type="com.haulmont.testtask.model.CreditProposal"/>
            <tr>
                <td>${creditProposal.customer}</td>
                <td>${creditProposal.credit}</td>
                <td>${creditProposal.creditAmount}</td>
                <td><a href="paymentsByCreditProposalId?id=${creditProposal.id}">График платежей</a></td>
                <td><a href="#">Update</a></td>
                <td><a href="creditProposals/delete?id=${creditProposal.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</section>
</body>
</html>

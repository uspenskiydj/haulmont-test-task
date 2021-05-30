<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>New Credit Proposal</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="webjars/bootstrap/4.5.3/css/bootstrap.min.css">
</head>
<body>

<section>
    <h3><a href="/">Домой</a></h3>
    <hr>
    <div class="container">
        <h2>Составление кредитного предложения</h2>
        <br>
        <jsp:useBean id="creditProposal" type="com.haulmont.testtask.model.CreditProposal" scope="request"/>
        <form method="post" action="creditProposalCreateForm">
            <dl>
                <dt>Клиент:</dt>
                <dd><select name="customerId">
                    <c:forEach items="${customers}" var="customer">
                        <option value="${customer.id}">
                                ${customer.FIO} &nbsp; ${customer.email}
                        </option>
                    </c:forEach>
                </select>
                <dd>
            </dl>
            <dl>
                <dt>Кредит:</dt>
                <dd><select name="creditId">
                    <c:forEach items="${credits}" var="credit">
                        <option value="${credit.id}">
                            Ставка: &nbsp; ${credit.interestRate} &nbsp; Лимит: &nbsp; ${credit.limit}
                        </option>
                    </c:forEach>
                </select>
                <dd>
            </dl>
            <dl>
                <dt>Сумма кредита:</dt>
                <dd><input type="text" value="${creditProposal.creditAmount}" name="creditAmount" required></dd>
            </dl>
            <button class="btn btn-primary" type="submit">Построить график платежей</button>
            <button class="btn btn-secondary" onclick="window.history.back()" type="button">Назад</button>
        </form>
</section>
</div>
</body>
</html>

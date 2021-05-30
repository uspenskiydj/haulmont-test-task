<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Banks</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<section>
    <h3><a href="/">Домой</a></h3>
    <hr/>
    <h2>Банки</h2>
    <form method="post" action="banks">
        <button type="submit">Добавить банк</button>
    </form>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>Банк</th>
            <th>Клиенты</th>
            <th>Кредиты</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <c:forEach items="${banks}" var="bank" varStatus="сounter">
            <jsp:useBean id="bank" type="com.haulmont.testtask.model.Bank"/>
            <tr>
                <td>Банк ${сounter.count}</td>
                <td><a href="customersByBank?bankId=${bank.id}">Клиенты</a></td>
                <td><a href="creditsByBank?bankId=${bank.id}">Кредиты</a></td>
                <td><a href="#">Update</a></td>
                <td><a href="banks/delete?id=${bank.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</section>
</body>
</html>

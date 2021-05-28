<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Credit</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<section>
    <h3><a href="/">Домой</a></h3>
    <hr>
    <h2>${param.action == 'create' ? 'Добавить кредит' : 'Редактирование кредита'}</h2>
    <jsp:useBean id="credit" type="com.haulmont.testtask.model.Credit" scope="request"/>
    <form method="post" action="credits">
        <input type="hidden" name="id" value="${credit.id}">
        <dl>
            <dt>Лимит по кредиту:</dt>
            <dd><input type="text" value="${credit.limit}" name="limit" required></dd>
        </dl>
        <dl>
            <dt>Процентная ставка:</dt>
            <dd><input type="text" value="${credit.interestRate}" size=40 name="interestRate" required></dd>
        </dl>
        <button type="submit">Сохранить</button>
        <button onclick="window.history.back()" type="button">Назад</button>
    </form>
</section>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Credit</title>
    <link rel="stylesheet" href="webjars/bootstrap/4.5.3/css/bootstrap.min.css">
</head>
<body>

<section>
    <h3><a href="/">Домой</a></h3>
    <hr>
    <div class="container">
        <h2>${param.action == 'create' ? 'Добавить кредит' : 'Редактирование кредита'}</h2>
        <br>
        <jsp:useBean id="credit" type="com.haulmont.testtask.model.Credit" scope="request"/>
        <form:form method="post" action="credits" modelAttribute="credit">
        <input type="hidden" name="id" value="${credit.id}">
        <dl>
            <dt><form:label path="limit">Лимит по кредиту:</form:label></dt>
            <dd><form:input path="limit" class="form-control"/>
                <form:errors path="limit" cssClass="error"/></dd>
        </dl>
        <dl>
            <dt><form:label path="interestRate">Процентная ставка:</form:label></dt>
            <dd><form:input path="interestRate" class="form-control"/>
                <form:errors path="interestRate" cssClass="error"/></dd>
        </dl>
        <dl>
            <dt>Банк:</dt>
            <dd><form:select path="bank" class="form-control">
                <c:forEach items="${banks}" var="bank" varStatus="сounter">
                    <form:option value="${bank.id}">Банк ${сounter.count}</form:option>
                </c:forEach>
            </form:select>
            </dd>
        </dl>
        <button class="btn btn-primary" type="submit">Сохранить</button>
        <button class="btn btn-secondary" onclick="window.history.back()" type="button">Назад</button>
        </form:form>
</section>
</div>
</body>
</html>

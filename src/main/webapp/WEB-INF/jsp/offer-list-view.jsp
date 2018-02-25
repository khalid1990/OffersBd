<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html lang="en">
<head>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery-3.3.1.js"/> "></script>
    <script type="text/javascript" src="<c:url value="/resources/bootstrap-3.3.7-dist/js/bootstrap.js"/> "></script>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery-ui-1.12.1/jquery-ui.js"/> "></script>
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/js/jquery-ui-1.12.1/jquery-ui.css"/> "/>
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/bootstrap-3.3.7-dist/css/bootstrap.css"/> "/>
</head>

<body>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">
            <fmt:message key="label.offer.list"/>
        </div>

        <div class="panel-body">
            <table class="table table-responsive">
                <thead>
                <tr>
                    <th><fmt:message key="label.offer"/></th>
                    <th><fmt:message key="label.action"/></th>
                </tr>
                </thead>

                <tbody>
                <c:forEach items="${offers}" var="offer">
                    <tr>
                        <td>
                            <c:out value="${offer.title}"/>
                        </td>

                        <td>
                            <c:url var="offerEditUrl" value="/offer/edit">
                                <c:param name="id" value="${offer.id}"/>
                            </c:url>
                            <a href="${offerEditUrl}">
                                <fmt:message key="label.edit"/>
                            </a>

                            <c:url var="offerDeleteUrl" value="/offer/delete">
                                <c:param name="id" value="${offer.id}"/>
                            </c:url>
                            <c:out value="|"/>
                            <a href="${offerDeleteUrl}">
                                <fmt:message key="label.delete"/>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>

</html>

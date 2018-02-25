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
            <fmt:message key="label.company.list"/>
        </div>

        <div class="panel-body">
            <table class="table table-responsive">
                <thead>
                    <tr>
                        <th><fmt:message key="label.company"/></th>
                        <th><fmt:message key="label.action"/></th>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach items="${companies}" var="company">
                        <tr>
                            <td>
                                <a href="<c:url value="${company.url}"/>">
                                    <c:out value="${company.name}"/>
                                </a>
                            </td>

                            <td>
                                <c:url var="companyEditUrl" value="/company/edit">
                                    <c:param name="id" value="${company.id}"/>
                                </c:url>
                                <a href="${companyEditUrl}">
                                    <fmt:message key="label.edit"/>
                                </a>

                                <c:url var="companyDeleteUrl" value="/company/delete">
                                    <c:param name="id" value="${company.id}"/>
                                </c:url>
                                <c:out value="|"/>
                                <a href="${companyDeleteUrl}">
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

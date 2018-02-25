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
    <script>
        $( function() {
            $( ".date-field" ).datepicker();
        } );
    </script>
</head>

<body>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">
            <fmt:message key="label.offer"/>
        </div>

        <div class="panel-body">
            <div class="row">
                <label class="col-sm-2"><fmt:message key="label.title"/></label>
                <div class="col-sm-10"><c:out value="${offerCommand.offer.title}"/></div>
            </div>

            <div class="row">
                <label class="col-sm-2"><fmt:message key="label.offer.url"/></label>
                <div class="col-sm-10"><c:out value="${offerCommand.offer.offerUrl}"/></div>
            </div>

            <div class="row">
                <label class="col-sm-2"><fmt:message key="label.offer.desc"/></label>
                <div class="col-sm-10"><c:out value="${offerCommand.offer.description}"/></div>
            </div>

            <!--image file-->

            <div class="row">
                <label class="col-sm-2"><fmt:message key="label.company"/></label>
                <div class="col-sm-10"><c:out value="${offerCommand.offer.company.name}"/></div>
            </div>

            <div class="row">
                <label class="col-sm-2"><fmt:message key="label.offerType"/></label>
                <div class="col-sm-10"><c:out value="${offerCommand.offer.offerType.type}"/></div>
            </div>

            <div class="row">
                <label class="col-sm-2"><fmt:message key="label.from.date"/></label>
                <div class="col-sm-10">
                    <fmt:formatDate value="${offerCommand.offer.fromDate}" pattern="dd/MM/yyyy"/>
                </div>
            </div>

            <div class="row">
                <label class="col-sm-2"><fmt:message key="label.to.date"/></label>
                <div class="col-sm-10">
                    <fmt:formatDate value="${offerCommand.offer.toDate}" pattern="dd/MM/yyyy"/>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

</html>

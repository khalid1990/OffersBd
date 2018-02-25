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
            <fmt:message key="label.company"/>
        </div>

        <div class="panel-body">
            <form:form action="index" method="post" modelAttribute="company">

                <div class="row">
                    <form:label path="name" cssClass="col-sm-2">
                        <fmt:message key="label.company"/>
                    </form:label>

                    <form:input path="name" cssClass="form-control col-sm-10"/>
                </div>

                <div class="row">
                    <form:label path="url" cssClass="col-sm-2">
                        <fmt:message key="label.company.url"/>
                    </form:label>

                    <form:input path="url" cssClass="form-control col-sm-10"/>
                </div>

                <div class="row">
                    <input type="submit" name="_action_save_company" class="btn btn-primary"
                           value="${company.id == 0 ? 'Save' : 'Update'}">
                </div>
            </form:form>
        </div>
    </div>
</div>
</body>

</html>

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
                    <form:form action="index" method="post" commandName="offerCommand" enctype="multipart/form-data">

                        <div class="row">
                            <form:label cssClass="col-sm-2" path="offer.title">
                                <fmt:message key="label.title"/>
                            </form:label>

                            <form:input path="offer.title"
                                        cssClass="form-control col-sm-10"
                                        maxlength="100"/>
                        </div>

                        <div class="row">
                            <form:label path="offer.offerUrl" cssClass="col-sm-2">
                                <fmt:message key="label.offer.url"/>
                            </form:label>

                            <form:input path="offer.offerUrl" cssClass="form-control col-sm-10"/>
                        </div>

                        <div class="row">
                            <form:label path="offer.description" cssClass="col-sm-2">
                                <fmt:message key="label.offer.desc"/>
                            </form:label>

                            <form:textarea path="offer.description" cssClass="form-control col-sm-10"/>
                        </div>

                        <!--image file-->
                        <div class="row">
                            <c:if test="${offerCommand.offer.id == 0}">
                                <div class="form-group form-inline">
                                    <form:label path="imageFile" cssClass="col-sm-2">
                                        <fmt:message key="label.upload.image"/>
                                    </form:label>
                                    <input type="file" name="imageFile" class="form-control"/>
                                </div>
                            </c:if>
                        </div>

                        <div class="row">
                            <form:label path="offer.company" cssClass="col-sm-2">
                                <fmt:message key="label.company"/>
                            </form:label>

                            <form:select path="offer.company" cssClass="form-control col-sm-10">
                                <form:options items="${companies}"
                                              itemLabel="name"
                                              itemValue="id"/>
                            </form:select>
                        </div>

                        <div class="row">
                            <form:label path="offer.offerType" cssClass="col-sm-2">
                                <fmt:message key="label.offerType"/>
                            </form:label>

                            <form:select path="offer.offerType" cssClass="form-control col-sm-10">
                                <form:options items="${offerTypes}"
                                              itemLabel="type"
                                              itemValue="id"/>
                            </form:select>
                        </div>

                        <div class="row">
                            <form:label path="offer.fromDate" cssClass="col-sm-2">
                                <fmt:message key="label.from.date"/>
                            </form:label>

                            <form:input path="offer.fromDate" cssClass="form-control col-sm-10 date-field"/>
                        </div>

                        <div class="row">
                            <form:label path="offer.toDate" cssClass="col-sm-2">
                                <fmt:message key="label.to.date"/>
                            </form:label>

                            <form:input path="offer.toDate" cssClass="form-control col-sm-10 date-field"/>
                        </div>

                        <div class="row">
                            <input type="submit" name="_action_save" class="btn btn-primary" value="Save">
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </body>

</html>

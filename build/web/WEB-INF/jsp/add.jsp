<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"   %>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>ajout colis</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    </head>
    <body style='background:url(images/3.jpg) '>
        <div class="container">
            <ol class="breadcrumb">
                <li><a href="<c:url value="/home.htm" />">Liste des colis</a></li>
                <li class="active">Ajout</li>
            </ol>
            <div class="panel panel-primary">
                <div class="panel-heading">Ajouter un colis</div>
                <div class="panel-body">
                   
                        <form:form method="post" commandName="colis">
                            
                            <form:errors path="*" element="div" cssClass="alert alert-danger" />
                            
                            <p>
                                <form:label path="nom">Nom :</form:label>
                                <form:input path="nom" cssClass="form-control" />
                                
                            </p>
                            
                            <p>
                                <form:label path="quantite">Quantité :</form:label>
                                <form:input path="quantite" cssClass="form-control" />
                            </p>
                            
                            <p>
                                <form:label path="lien">Lien :</form:label>
                                <form:input path="lien" cssClass="form-control" />
                            </p>
                            <hr />
                            <input type="submit" value="Ajouter" class="btn btn-danger" />
                        </form:form>
                </div>
            </div>
        </div>
    </body>
</html>

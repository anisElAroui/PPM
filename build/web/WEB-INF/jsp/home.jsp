<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>accueil</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    </head>
    <body>
        
        <div class="container">
            <div class="row">
                <p>
                    <a href="<c:url value="add.htm"/>" class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Ajouter Colis</a>                    
                </p>
                <table class="table table-bordered table-striped table-hover">
                    <thead>
                        <tr>
                            <th> Id </th>
                            <th> Nom </th>
                            <th> Quantité </th>
                            <th> Lien </th>
                            <th> Action </th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${data}" var="d">
                            <tr>
                                <td><c:out value="${d.id}"/></td>
                                <td><c:out value="${d.nom}"/></td>
                                <td><c:out value="${d.quantite}"/></td>
                                <td><c:out value="${d.lien}"/></td>
                                <td>
                                    <a href="<c:url value="edit.htm?id=${d.id}"/>" ><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>
                                    <a href="<c:url value="delete.htm?id=${d.id}"/>" ><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>
                                </td>
                            </tr>
                        </c:forEach>
                                                
                    </tbody>
                </table>
                
            </div>
            
            
        </div>
        
    </body>
</html>

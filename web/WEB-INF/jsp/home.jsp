<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>accueil</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900" rel="stylesheet" />
        <link href="default.css" rel="stylesheet" type="text/css" media="all" />
        <link href="fonts.css" rel="stylesheet" type="text/css" media="all" />
    </head>
    <body>
        
    <div id="header" class="container">
	<div id="logo">
		<h1><a href="#">Accueil</a></h1>
	</div>
           <div id="menu">
		<ul>
			<li><a href="#" accesskey="1" title="">User</a></li>
			<li><a href="#" accesskey="2" title="">Déconnexion</a></li>
                </ul>
           </div>
    </div>
    <div id="banner-wrapper">
            <div id="banner" class="container">
                    <div class="boxA">
                            <h3>Envoyer un colis</h3>
                            <p>Entrer les données necéssaires pour envoyer un colis.</p>
                            <a href="#envoyer" class="button">envoyer</a>
                    </div>
                    <div class="boxB">
                            <h3>Commander un colis</h3>
                            <p>Entrer l'url de votre commande et nous occuperons de l'achat du produit.</p>
                            <a href="#acheter" class="button">commander</a>
                    </div>
                    <div class="boxC">
                            <h3>Etat des colis</h3>
                            <p>Suivez l'état de vos colis envoyés ainsi que celle commandés.</p>
                            <a href="#etats1" class="button">===></a>
                            <a href="#etats" class="button" style='margin-left: 20px'><===</a>
                    </div>
            </div>
    </div>
        
    <section id="envoyer">
       <div class="container" style="padding-top: 50px">
           <h2>Envoyer un colis</h2><br>
           <div class="panel panel-primary" >
                <div class="panel-heading">Saisir les données</div>
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
    </section>
        
    <section id="etats1">
        <div id="footer-wrapper">
            <div id="footer" class="container">    
                <h2>Colis Envoyés</h2><br>
                    <div id="fbox1">
                                <ul class="style3">
                                    <li class="first">
                                            <p class="date"><a href="#">Dec<b>15</b></a></p>
                                            <h3>pc asus</h3>
                                            <p><a href="#">destination du colis.</a></p>
                                    </li>
                                    <li>
                                            <p class="date"><a href="#">Dec<b>2</b></a></p>
                                            <h3>montre</h3>
                                            <p><a href="#">destination du colis.</a></p>
                                    </li>
                                    <li>
                                            <p class="date"><a href="#">Nov<b>14</b></a></p>
                                            <h3>telephone</h3>
                                            <p><a href="#">destination du colis.</a></p>
                                    </li>
                            </ul>
                    </div>
                <div id="fbox2">
                            <ul class="style3">
                                    <li class="first">
                                            <p class="date"><a href="#">Oct<b>14</b></a></p>
                                            <h3>parfum</h3>
                                            <p><a href="#">destination du colis.</a></p>
                                    </li>
                                    <li>
                                            <p class="date"><a href="#">Oct<b>11</b></a></p>
                                            <h3>livres</h3>
                                            <p><a href="#">destination du colis.</a></p>
                                    </li>
                                    <li>
                                            <p class="date"><a href="#">Sep<b>09</b></a></p>
                                            <h3>cadeau</h3>
                                            <p><a href="#">destination du colis.</a></p>
                                    </li>
                            </ul>
                    </div>
            </div>
        </div>
    </section>
        
        
        
        
    <section id="acheter">    
        <div class="container" style="padding-top: 50px">
            
            <h2>Commander un colis</h2><br>
            
            <div class="row">
                <p>
                    <a href="<c:url value="add.htm"/>" class="btn btn-success" style="margin-left: 20px;margin-top: 10px"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Ajouter un colis</a>                    
                </p>
                <br>
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
    </section>
                
    <section id="etats">
        <div id="footer-wrapper">
            <div id="footer" class="container">
                <h2>Colis Commandés</h2><br>
                <div id="fbox1">
                               <ul class="style3">
                                    <li class="first">
                                            <p class="date"><a href="#">Dec<b>24</b></a></p>
                                            <h3>capteur ultrason</h3>
                                            <p><a href="#">destination du colis.</a></p>
                                    </li>
                                    <li>
                                            <p class="date"><a href="#">Dec<b>11</b></a></p>
                                            <h3>Raspberry pi 3</h3>
                                            <p><a href="#">destination du colis.</a></p>
                                    </li>
                                    <li>
                                            <p class="date"><a href="#">Nov<b>26</b></a></p>
                                            <h3>pc portable</h3>
                                            <p><a href="#">destination du colis.</a></p>
                                    </li>
                            </ul>
                    </div>
                <div id="fbox2">
                            <ul class="style3">
                                    <li class="first">
                                            <p class="date"><a href="#">Oct<b>15</b></a></p>
                                            <h3>camera</h3>
                                            <p><a href="#">destination du colis.</a></p>
                                    </li>
                                    <li>
                                            <p class="date"><a href="#">Oct<b>03</b></a></p>
                                            <h3>montre</h3>
                                            <p><a href="#">destination du colis.</a></p>
                                    </li>
                                    <li>
                                            <p class="date"><a href="#">Sep<b>12</b></a></p>
                                            <h3>livres</h3>
                                            <p><a href="#">destination du colis.</a></p>
                                    </li>
                            </ul>
                    </div>
                </div>
        </div>
    </section>
        
        <div id="copyright">
                <ul class="contact">
                        <li><a href="#" class="icon icon-twitter"><span>Twitter</span></a></li>
                        <li><a href="#" class="icon icon-facebook"><span></span></a></li>
                        <li><a href="#" class="icon icon-dribbble"><span>Pinterest</span></a></li>
                        <li><a href="#" class="icon icon-tumblr"><span>Google+</span></a></li>
                        <li><a href="#" class="icon icon-rss"><span>Pinterest</span></a></li>
                </ul>
        </div>
                
    </body>

</html>

<%-- 
    Document   : newTrain
    Created on : 31 janv. 2022, 13:53:01
    Author     : flvivet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <h1>Création d'une nouvelle station de train :</h1>
        <form action="http://localhost:8080/servlet_tp3/NewTrainStation" method="POST">
            <div class="form-group col-md-6">
                <label for="name">Name :</label>
                <input class="form-control" type="text" name="name" required></input>
            </div>
            <div class="form-group col-md-6">
                <label for="road">Road :</label>
                <input class="form-control" type="text" name="road" required></input>
            </div>
            <div class="form-group col-md-6">
                <label for="city">City :</label>
                <input class="form-control" type="text" name="city" required></input>
            </div>
            <div class="form-group col-md-6">
                <label for="postal_code">Postal Code :</label>
                <input class="form-control" type="number" pattern="[0-9]{5}" name="postal_code" min="01000" max="99999" required></input>
            </div>
            <div class="form-group col-md-6">
                <label for="price">Price :</label>
                <input class="form-control" type="number" name="price" required></input>
            </div>
            <div class="form-group col-md-6">
                <input class="btn btn-primary" type="submit" value="Ajouter la station" required></input>
            </div>
        </form>
    </body>
</html>

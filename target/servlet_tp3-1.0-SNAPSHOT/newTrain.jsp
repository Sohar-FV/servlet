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
    </head>
    <body>
        <h1>I lkei trians</h1>
        <form action="http://localhost:8080/servlet_tp3/TrainStation" method="POST">
            <label for="name">Name :</label>
            <input type="text" name="name"></input>
            <label for="road">Road :</label>
            <input type="text" name="road"></input>
            <label for="city">City :</label>
            <input type="text" name="city"></input>
            <label for="postal_code">Postal Code :</label>
            <input type="number" name="postal_code"></input>
            <label for="price">Price :</label>
            <input type="number" name="price"></input>
            
            <input type="submit" value="Ajouter la station"></input>
        </form>
    </body>
</html>

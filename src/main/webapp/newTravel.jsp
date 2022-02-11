<%-- 
    Document   : newTravel
    Created on : 11 févr. 2022, 14:21:11
    Author     : flvivet
--%>

<%@page import="java.util.List"%>
<%@page import="servlet.servlet_tp3.TrainStation"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% List<TrainStation> stations = (List<TrainStation>)request.getAttribute("stations");%>
        
        
        
        
        <h1>Création d'un nouveau voyage</h1>
        <form action="http://localhost:8080/servlet_tp3/NewTrainStation" method="POST">
            <div class="form-group col-md-6">
                <label for="name">Station de départ :</label>
                <select class="form-control" type="text" name="depart_station" required>
                    <% for(TrainStation station : stations) { %>
                    <option value='<%= station.getId() %>' > <%= station.getName() %></option>
                    <% } %>
                </select>
            </div>
            <div class="form-group col-md-6">
                <label for="road">Station d'arrivée :</label>
                <select class="form-control" type="text" name="arrival_station" required>
                    <% for(TrainStation station : stations) { %>
                    <option value='<%= station.getId() %>' > <%= station.getName() %></option>
                    <% } %>
                </select>
            </div>
            <div class="form-group col-md-6">
                <input class="btn btn-primary" type="submit" value="Ajouter la station" required></input>
            </div>
        </form>
    </body>
</html>

<%-- 
    Document   : newLine
    Created on : 11 févr. 2022, 15:06:12
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
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  
    </head>
    <body>
        <% List<TrainStation> stations = (List<TrainStation>)request.getAttribute("stations");
            System.out.println(stations);%>
            
        <h1>Création d'une ligne</h1>
        
        <div class="table-responsive">
            
            Cochez les stations à ajouter à la ligne :
            <form action="http://localhost:8080/servlet_tp3/NewLine" method="POST">
                <table class="table table-striped table-bordered">
                    <thead>
                        <th>Name</th>
                        <th>Choice</th>
                    </thead>
                    <tbody>
                <% for(TrainStation station : stations) { 
                    if (station.getLine() == null){%>
                    <tr>      
                        <td><%= station.getName() %></td>
                        <td><input type="checkbox" name="stations" value="<%= station.getId() %>"></input></td> 
                    </tr>
                <% }}%>
                </tbody>
                </table>           
            <input class="btn btn-primary" type="submit" value="Ajouter la ligne"></input>
            </form>
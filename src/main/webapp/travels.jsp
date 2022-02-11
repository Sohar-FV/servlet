<%-- 
    Document   : travels
    Created on : 11 févr. 2022, 15:01:39
    Author     : flvivet
--%>

<%@page import="servlet.servlet_tp3.Travel"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <h1>Les voyages enregistrés</h1>
        
        <% List<Travel> travels = (List<Travel>)request.getAttribute("travels");%>
        
        <div class="table-responsive">
            <table class="table table-striped table-bordered">
                <thead>
                    <th>Departure</th>
                    <th>Arrival</th>
                    <th>Price</th>
                </thead>
                <tbody>
            <% for(Travel travel : travels) { %>
                <tr>      
                    <td><%= travel.getDepartureStation() %></td>
                    <td><%= travel.getArrivalStation() %></td>
                    <td><%= travel.getPrice() %></</td>  
                </tr>
            <% } %>
            </tbody>
            </table>
        </div>
            
            <a class="btn btn-primary" href="http://localhost:8080/servlet_tp3/NewTravel">Ajouter un voyage</a>
    </body>
</html>

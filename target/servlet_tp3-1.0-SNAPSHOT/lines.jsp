<%-- 
    Document   : lines
    Created on : 11 févr. 2022, 16:27:35
    Author     : flvivet
--%>

<%@page import="servlet.servlet_tp3.TrainStation"%>
<%@page import="servlet.servlet_tp3.Line"%>
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
        
        <% List<Line> lines = (List<Line>)request.getAttribute("lines");%>
        <% List<TrainStation> stations = (List<TrainStation>)request.getAttribute("stations");%>
        
        <h1>Nos lignes</h1>
        
        <div class="table-responsive">
            <table class="table table-striped table-bordered">
                <thead>
                    <th>Line</th>
                    <th>Stations</th>
                </thead>
                <tbody>
            <% for(Line line : lines) { %>
                <tr>      
                    <td><%= line.getId() %></td>
                    <td>
                        <% String result = "";
                            for(TrainStation station : stations) { 
                                if (station.getLine() != null) {
                                    if(station.getLine().getId() == line.getId()) {
                                        result += " - " + station.getName();
                                    }
                                }
                           }%>
                            
                        <%= result %>
                    </td> 
                </tr>
            <% } %>
            </tbody>
            </table>
        </div>
            <a class="btn btn-primary" href="http://localhost:8080/servlet_tp3/NewLine">Ajouter une ligne</a>
        
        
    </body>
</html>

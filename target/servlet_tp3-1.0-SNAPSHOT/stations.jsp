<%-- 
    Document   : stations
    Created on : 11 févr. 2022, 10:23:47
    Author     : flvivet
--%>

<%@page import="java.util.List"%>
<%@page import="servlet.servlet_tp3.TrainStation"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
        <h1>Salut a tous les amis</h1>
        <% List<TrainStation> stations = (List<TrainStation>)request.getAttribute("stations");
            System.out.println(stations);%>
        
        
        <table>
        <% for(TrainStation station : stations) { %>
        
            <tr>      
                <td><%= station.getName() %></td>
                <td><%= station.getRoad() %></td>
                <td><%= station.getCity() %></td>
                <td><%= station.getPostalCode() %></td>
                <td><%= station.getPrice() %></</td>  
            </tr>
        <% } %>
        </table>
        
        
    


<%-- 
    Document   : AgendarConsulta
    Created on : 24/06/2016, 10:41:37
    Author     : manoel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
    </head>
    <body>
        <h1>Agendar Consulta</h1>
        
            <form action="/consulta/agendar" method="post">
               <div>numero do cpf do paciente  <input type="text" name="pacienteCpf"> </div></br>
               <div>numero do cpf do medico  <input type="text" name="medicoCpf"> </div>

            <div> dia da consulta<input type="text" name="diaConsulta"> </div>
            <div> hora da consulta<input type="text" name="horaConsulta"> </div>
            <div> situacao da consulta <input type="text" name="situacaoConsulta"> </div>

            <input type="submit" value="agendar consulta">
            
            </form>
    </body>
</html>

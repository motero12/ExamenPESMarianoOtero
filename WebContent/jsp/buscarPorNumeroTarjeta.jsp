<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../template/header.jsp"%>
<form method="post" action="${pageContext.request.contextPath}/Tarjeta/buscarPorNumeroTarjeta" name="buscarPorNumeroTarjeta"> 
    <label>Numero de tarjeta:</label>
    <input type="text" name="numeroTarjeta" id="numeroTarjeta"/>
    <br>
    <label>Contraseña:</label>
    <input type="text" name="contrasenha" id="contrasenha"/>
     <br>
    <label>Ampliacion de cupo en euros:</label>
    <input type="text" name="ampliarCupo" id="ampliarCupo"/>
    <br> <br>
    <input type="submit" name="ampliar" value="Ampliar"/>
    <input type="reset" name="cancelar" value="Cancelar"/>
    
</form>
<%@include file="../template/footer.jsp"%>
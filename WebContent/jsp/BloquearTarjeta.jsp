<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../template/header.jsp"%>
<form method="post" action="${pageContext.request.contextPath}/Tarjeta/bloquearTarjeta" name="bloquearTarjeta"> 
    <label>Numero de tarjeta:</label>
    <input type="text" name="numeroTarjeta" id="numeroTarjeta"/>
    <br>
    <label>Contraseña:</label>
    <input type="text" name="contrasenha" id="contrasenha"/>
    <br> <br>
    <input type="submit" name="ampliar" value="Bloquear"/>
    <input type="reset" name="cancelar" value="Cancelar"/>
</form>
<%@include file="../template/footer.jsp"%>
    
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../template/header.jsp"%>
<form method="post" action="${pageContext.request.contextPath}/Tarjeta/pagarConTarjeta" name="pagarConTarjeta"> 
    <label>Numero de tarjeta:</label>
    <input type="text" name="numeroTarjeta" id="numeroTarjeta"/>
    <br>
    <label>Contraseña:</label>
    <input type="number" name="contrasenha" id="contrasenha"/>
    <br>
    <label>Número de comprobación:</label>
    <input type="text" name="numeroComproba" id="numeroComproba"/>
    <br>
    <label>Importe del pago:</label>
    <input type="number" name="importePago" id="importePago"/>
    <br> <br>
    <input type="submit" name="ampliar" value="Pagar"/>
    <input type="reset" name="cancelar" value="Cancelar"/>
</form>
<%@include file="../template/footer.jsp"%>
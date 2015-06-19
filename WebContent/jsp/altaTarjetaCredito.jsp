<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../template/header.jsp"%>
<h1>Alta de tarjeta de credito</h1>
    <section id="contenedor">
        <section id="formulario">
            <form name="tarjeta" method="post" action="/ExamenPESMarianoOtero/Tarjeta/altaTarjeta" enctype="text/html">
                <h2>Datos de la tarjeta</h2>
                <div class="texto">
                    <label for="numerotarjeta" class="mano">Número de la tarjeta</label>
                </div>
                <div class="elemento">
                    <input type="number" id="numerotarjeta" name="numerotarjeta" maxlength=12 required/>
                </div>
                <div class="texto">
                    <label for="cupomaximo" class="mano">Cupo máximo</label>
                </div>
                <div class="elemento">
                    <input type="number" id="cupomaximo" name="cupomaximo" size=8 required/>
                </div>
                <div class="texto">
                    <label for="cupodisponible" class="mano">Cupo disponible</label>
                </div>
                <div class="elemento">
                    <input type="number" id="cupodisponible" name="cupodisponible" size=8 required/>
                </div>
                <div class="texto">
                    <label for="tipotarjeta" class="mano">Tipo de tarjeta</label>
                </div>
                <select name="tipotarjeta">
                    <option value="NoSeleccionado">Seleccione uno</option>
                    <option value="Visa">VISA</option>
                    <option value="MasterCard">MASTER CARD</option>
                </select>
                <div class="texto">
                    <label for="numerocomproba" class="mano">Número de comprobación</label>
                </div>
                <div class="elemento">
                    <input type="text" id="numerocomproba" name="numerocomproba" maxlength=7 required/>
                </div>
                <div class="texto">
                    <label for="contrasenha" class="mano">Contraseña</label>
                </div>
                <div class="elemento">
                    <input type="number" id="contrasenha" name="contrasenha" size=4 required/>
                </div>
                <div class="texto">
                    <label for="bloqueada" class="mano">Tarjeta bloqueada</label>
                </div>
                <select name="bloqueada">
                    <option value=0>NO</option>
                    <option value=1>SI</option>
                </select>
                <br/><br/>
                <input type="submit" id="Enviar" class="mano" value="enviar">
                <input type="reset" id="Borrar" class="mano" value="borrar">
            </form>
        </section>
    </section>

<%@include file="../template/footer.jsp"%>
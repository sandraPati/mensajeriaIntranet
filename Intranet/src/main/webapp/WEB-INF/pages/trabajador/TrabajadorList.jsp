<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<c:if test="${not empty mensaje}">
	<div class="msg">${mensaje}</div>
    </c:if>
        <h1 align="center">Trabajadores</h1><br/>
        <table  align="center" width="70%" cellpadding="2" cellspacing="4" >
            <tr>
                <td><a href="/FinalEscobarSpring/home/TrabNew.htm">Insertar</a></td>
            </tr>
        </table>
        <br>
        
        <c:if test="${empty listTrab}">
            <h2 align="center"><font color="#800080">No hay Usuarios</font></h2>
        </c:if>
        <c:if test="${!empty listTrab}">
        <table  align="center" width="70%"   cellpadding="2" cellspacing="4" >
            <tr>
              <td><b><font color="#000000">CODIGO</font ></b></td>
              <td><b><font color="#000000">NOMBRES</font ></b></td>
              <td><b><font color="#000000">APELLIDOS</font ></b></td>
              <td><b><font color="#000000">CONTRASE&Ntilde;A</font ></b></td>
              <td><b><font color="#000000">TIPO</font ></b></td>
              <td>&nbsp;</td>
              <td>&nbsp;</td>
              <td>&nbsp;</td>
            </tr>
            <tr valign="middle"  class="catalogo"><td colspan="8">&nbsp;</td></tr> 

        
            <c:forEach items="${listTrab}" var="item">
            <tr>
                <td><font color='#000000'><c:out value="${item.codigo}" /></font></td>
                <td><font color='#000000'><c:out value="${item.nombre}" /></font></td>
                <td><font color='#000000'><c:out value="${item.apellidos}" /> </font></td>
                <td><font color='#000000'><c:out value="${item.contrasena}" /></font></td>
                <td><font color='#000000'><c:out value="${item.tipT.nombre}" /></font></td>
                <td align=right><a href="/FinalEscobarSpring/home/TrabUpdate.htm?cod=${item.codigo}">Modificar</a></td>
                <c:if test="${item.est==true}">
                <td align=right><a href="/FinalEscobarSpring/home/TrabBaja.htm?cod=${item.codigo}">Dar de Baja</a></td>
                </c:if>
                <c:if test="${item.est==false}">
                <td align=right><a href="/FinalEscobarSpring/home/TrabActivar.htm?cod=${item.codigo}">Activar</a></td>
                </c:if>
                <td align=right><a href="/FinalEscobarSpring/home/TrabCargos.htm?cod=${item.codigo}">Cargos</a></td>
                </tr>
                <tr><td colspan='8'><hr></td></tr>
            </c:forEach>
        </table>
        </c:if>
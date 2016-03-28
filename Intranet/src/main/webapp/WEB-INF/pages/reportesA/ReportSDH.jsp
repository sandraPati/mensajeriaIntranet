<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<script type="text/javascript"> 
	try {
	var pageTracker = _gat._getTracker("UA-16343774-1");
	pageTracker._setDomainName();
	pageTracker._trackPageview();
	} catch(err) {}
  
  </script>   
   <script type="text/javascript">
                function imprimir() {
                    window.print()
                }
         </script>
         
<div id="wrapper">
            <div id="page">
        <a href="/FinalEscobarSpring/principal.htm" title="Pag. Principal">Pag. Principal</a><br>
        <h1 align="center">DIA: por Hora Inicio y Fin</h1><br/>
            
       <form:form id="form1" action="" method="GET" commandName="report">
           <table  align="center" width="70%"   cellpadding="2" cellspacing="4">
            <tr>
            <td align="center">&nbsp;</td>
            <td align="center">
                Codigo:&nbsp;<form:input id="codigoT" path="codigoT" required="true"/>
            </td>
            <td align="right" rowspan="3">
                &nbsp; 
                <c:if test="${!empty trabajadores}">
                <a href="javascript:imprimir()">
                    <img src="/FinalEscobarSpring/resources/img/imprime.gif" border="0" title="Imprimir Documento" width='70' height='57'>
                </a>
                 </c:if>
            </td>            
           </tr> 
           <tr>
            <td>&nbsp;</td>
            <td align="center">
                Fecha:&nbsp;<form:input id="fecha" path="fecha" required="true"/>
            </td>
           </tr> 
           <tr>
            <td>&nbsp;</td>
            <td align="center">
                Hora Inicio:&nbsp;<form:input id="h1" path="h1" required="true"/>
            </td>
           </tr> 
           <tr>
            <td>&nbsp;</td>
            <td align="center">
                Hora Fin:&nbsp;<form:input id="h2" path="h2" required="true"/>
            </td>
           </tr> 
           <tr>
               <td colspan="2" align="center">
                   <br><input class="boton" type="submit" value="Consultar" />
            </td>
           </tr> 
        </table>
        </form:form>
       <c:if test="${not empty Negacion}">
           <br><br> 
           <h2 align="center">${Negacion}</h2>
        </c:if>
        <c:if test="${trabajadores.size()==0}">
           <br><br> 
           <h2 align="center">No hay Registros!</h2>
        </c:if>
        <c:if test="${!empty trabajadores}">
        <table  align="center" width="70%"   cellpadding="2" cellspacing="4" >
            <tr>
              <td align="right" colspan="3"><b><font color="#FF3333">Cant. Total:</font ></b></td>
              <c:set value="0" var="suma" scope="page"/>
              <c:forEach items="${trabajadores}" var="item">
                  <c:set value="${suma+item.nCajas}" var="suma" scope="page"/>
              </c:forEach>
              <td><b><font color="#FF3333"><c:out value="${suma}"/></font></b></td>
            </tr>
            <tr>
              <td><b><font color="#000000">CODIGO</font ></b></td>
              <td><b><font color="#000000">NOMBRES</font ></b></td>
              <td><b><font color="#000000">APELLIDOS</font ></b></td>
              <td><b><font color="#000000">N_Cajas</font ></b></td>
            </tr>
            <tr valign="middle"  class="catalogo"><td colspan="4">&nbsp;</td></tr> 

        
            <c:forEach items="${trabajadores}" var="item">
            <tr>
                <td><font color='#000000'><c:out value="${item.codigoT}" /></font></td>
                <td><font color='#000000'><c:out value="${item.nombre}" /></font></td>
                <td><font color='#000000'><c:out value="${item.apellidos}" /> </font></td>
                <td><font color='#000000'><c:out value="${item.nCajas}" /></font></td>
                </tr>
                <tr><td colspan='4'><hr></td></tr>
            </c:forEach>
               
        </table>
        
                
              
        </c:if>
        <br>
        
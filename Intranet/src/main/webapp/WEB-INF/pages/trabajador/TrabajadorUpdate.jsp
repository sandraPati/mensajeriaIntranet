<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:form id="form1" action="" method="POST" commandName="trabajador">
        <table align="center">
           
            <tr>
            <td>CODIGO</td>
            <td>
                <form:input id="codigo" path="codigo"  readonly="true"/>
            </td>
           </tr> 
           <tr>
            <td>NOMBRE</td>
            <td>
                <form:input id="nombre" path="nombre" required="true"/>
            </td>
           </tr> 
           <tr>
            <td>APELLIDOS</td>
            <td>
                <form:input id="apellidos" path="apellidos" required="true"/>
            </td>
           </tr> 
           <tr>
            <td>CONTRASEÑA</td>
            <td>
                <form:input id="contrasena" path="contrasena" required="true"/>
            </td>
           </tr> 
            
           <tr>
               <td>TIPO_TRABAJADOR</td>
               <td>
                   <form:select id="tipT" name="tipT" path="tipT.id"  >
                        <form:options items="${tipo}" itemValue="id" itemLabel="nombre" />
                  </form:select>
                   
               </td>
           </tr>
            
           <tr>
               <td colspan="2" align="right">
                   <br><input class="boton" type="submit" value="ENVIAR" />
            </td>
           </tr> 
        </table>
            </form:form>
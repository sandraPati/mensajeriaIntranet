<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div id="content"> 
<form:form id="form1" action="" method="POST" commandName="trabajo">
        <table align="center">
           
            
           <tr>
            <td>TRABAJADOR</td>
            <td>                
                <form:input id="cod_trab" path="cod_trab.codigo" required="true"/> 
               </td>
           </tr>
           
           <tr>
               <td colspan="2" align="right">
                   <br><input class="boton" type="submit" value="ENVIAR" />
            </td>
           </tr> 
        </table>
</form:form>
</div>
    
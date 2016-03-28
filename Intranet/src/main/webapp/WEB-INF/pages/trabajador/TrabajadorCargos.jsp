<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h2 align=center><font color="#800080">Cargos</font></h2>      
<table align="center" width="70%"  cellpadding="0" cellspacing="0" >           
    <tr>
       <td>CODIGO</td>
       <td>NOMBRE</td>
       <td>APELLIDOS</td>
       <td>TIPO_TRABAJADOR</td>
       <td>&nbsp;</td>
    </tr>
    <tr valign="middle"  class="catalogo"><td colspan="5">&nbsp;</td></tr>
<c:forEach items="${lista}" var="lta">
        <tr bgcolor='#CCFF66'>
                <td><c:out value="${lta.codigo}" /></td> 
                <td><c:out value="${lta.nombre}" /></td>
                <td><c:out value="${lta.apellidos}" /></td>  
                <td><c:out value="${lta.tipT.nombre}" /></td>
<form:form id="form1" action="/FinalEscobarSpring/home/ACargo.htm" method="POST" commandName="cargo">
            <form:hidden id="id" path="id" value=""/>
            <form:hidden id="anio" path="anio" value=""/>
            <form:hidden id="cod_tra" path="cod_tra.codigo" value="${cod_tra}"/>
            <form:hidden id="cod_tracargo" path="cod_tracargo.codigo" value="${lta.codigo}"/>
            
                <c:if test="${lta.codigo!=cod_tra}">
                <c:if test="${!empty tiendaV}">
                <c:set value="0" var="encontrado" scope="page"/>
                <c:forEach items="${tiendaV}" var="car">
                    <c:if test="${car.cod_tracargo.codigo.equals(lta.codigo)}">
                        <c:set value="1" var="encontrado" scope="page"/>    
                    </c:if>
                </c:forEach>
            
                <c:if test="${encontrado==0}">
                    <td><input type="image" title="Dar" src='/FinalEscobarSpring/resources/img/noagregado.gif'/></td>
                </c:if>
                </c:if>
                <c:if test="${empty tiendaV}">
                    <td><input type="image" title="Dar" src='/FinalEscobarSpring/resources/img/noagregado.gif'/></td>
                </c:if>
                </c:if>
                <c:if test="${lta.codigo==cod_tra}"><td>-</td></c:if>    
           
</form:form>
<form:form id="form2" action="/FinalEscobarSpring/home/QCargo.htm" method="POST" commandName="cargo">
            <form:hidden id="id" path="id" value=""/>
            <form:hidden id="anio" path="anio" value=""/>
            <form:hidden id="cod_tra" path="cod_tra.codigo" value="${cod_tra}"/>
            <form:hidden id="cod_tracargo" path="cod_tracargo.codigo" value="${lta.codigo}"/>
            
                <c:if test="${lta.codigo!=cod_tra}">
                <c:if test="${!empty tiendaV}">
                <c:set value="0" var="encontrado" scope="page"/>
                <c:forEach items="${tiendaV}" var="car">
                    <c:if test="${car.cod_tracargo.codigo.equals(lta.codigo)}">
                        <c:set value="1" var="encontrado" scope="page"/>    
                    </c:if>
                </c:forEach>
            
                <c:if test="${encontrado==1}">
                    <td><input type="image" title="Dar" src="/FinalEscobarSpring/resources/img/agregado.gif" border="0" title="Quitar">
                    </td>
                </c:if>
                </c:if>
                </c:if>    
          
</form:form>
                     </tr>
           <tr><td colspan='5'><hr></td></tr>
</c:forEach>
</table>
    
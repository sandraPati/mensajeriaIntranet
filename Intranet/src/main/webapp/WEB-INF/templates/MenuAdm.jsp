<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<div id="header">
	<div id="logo">
		<h1><a href="http://agrilap.pe/es/"><span>Agri</span>Lap</a></h1>
		<p>Desde los valles de Piura, en el norte del Per&uacute;, a diferentes destinos alrededor del mundo.</p>
	</div>
    <div id="menu">
        <ul id="main">
            <li class="current_page_item"><a href="/FinalEscobarSpring/principal.htm" title="Pag. Principal">Pag. Principal</a></li>
        </ul>
	      
<ul id="main">
	<li class="current_page_item"><a href="/FinalEscobarSpring/home/TrabList.htm" title="Trabajadores">Trabajadores</a></li>
    </ul>
    <ul id="main">
	<li class="current_page_item"><a href="/FinalEscobarSpring/reg/RegTrabajo.htm" title="Trabajadores">Trabajo</a></li>
    </ul>
    <ul id="main">
	<li class="current_page_item"><a href="<c:url value='/j_spring_security_logout' />" title="Cerrar sesión">Cerrar sesión</a></li>
    </ul>
    </div></div>
    
<div id="wrapper">
            <div id="page">
                <tiles:insertAttribute name="report1" ignore="true" /><br>
                <tiles:insertAttribute name="report2" ignore="true" /><br>
                   
            
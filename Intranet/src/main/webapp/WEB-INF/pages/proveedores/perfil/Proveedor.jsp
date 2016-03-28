<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<div id="signup-box" class="signup-box visible widget-box no-border">
        <div class="widget-body">
            <c:if test="${not empty error}">
                <div class="error"><p>${error}</p></div>
            </c:if>
            <c:if test="${not empty mensaje}">
                <div >
                    <p class="alert alert-success">
                        ${mensaje}
                    </p>
            </div>
            </c:if>
                <div class="widget-main">
                        <h4 class="header green lighter bigger">
                                <i class="ace-icon fa fa-users blue"></i>
                                Registro de Proveedor
                        </h4>

                        <div class="space-6"></div>
                        
                        <form:form id="form1" action="" method="POST" commandName="proveedor" class="form-horizontal" role="form">
                            <fieldset>
                                <label class="block clearfix">
                                    <span class="block input-icon input-icon-right">
                                    <form:input id="cif" type="text" class="form-control" placeholder="CIF" path="cif" required="true"/>
                                     <i class="ace-icon fa fa-pencil-square-o"></i>
                                    </span>
                                </label>
                                <label class="block clearfix">
                                    <span class="block input-icon input-icon-right">
                                    <form:input id="nombre" type="text" class="form-control" placeholder="Nombre" path="nombre" required="true"/>
                                     <i class="ace-icon fa fa-pencil-square-o"></i>
                                    </span>
                                </label>
                                <label class="block clearfix">
                                    <span class="block input-icon input-icon-right">
                                    <form:input id="persona_contacto" type="text" class="form-control" placeholder="PERSONA CONTACTO" path="persona_contacto" required="true"/>
                                     <i class="ace-icon fa fa-pencil-square-o"></i>
                                    </span>
                                </label>     
                                <label for="form-field-select-3">Actividad</label>												<br />
                                <form:select id="id_actividad" name="id_actividad" path="id_actividad.id" class="form-control" data-placeholder="Choose a State...">
                                    <form:options items="${allTipoActividad}" itemValue="id" itemLabel="nombre" />
                                </form:select>
                                <br/>
                                <label class="block clearfix">
                                    <span class="block input-icon input-icon-right">
                                    <form:input id="direccion" type="text" class="form-control" placeholder="DIRECCION" path="direccion" required="true"/>
                                    
                                    <i class="ace-icon fa fa-pencil-square-o"></i>
                                    </span>
                                </label>
                                <label class="block clearfix">
                                    <span class="block input-icon input-icon-right">
                                        <form:input id="telefono" type="text" class="form-control" placeholder="TELEFONO" path="telefono" required="true"/>
                                    
                                            <i class="ace-icon fa fa-envelope"></i>
                                    </span>
                                </label>
                                <label class="block clearfix">
                                    <span class="block input-icon input-icon-right">
                                        <form:input id="email" type="text" class="form-control" placeholder="Email" path="email" required="true"/>
                                    
                                            <i class="ace-icon fa fa-envelope"></i>
                                    </span>
                                </label>
                                <label class="block clearfix">
                                    <span class="block input-icon input-icon-right">
                                        <form:input id="link" type="text" class="form-control" placeholder="Link" path="link" />
                                    
                                            <i class="ace-icon">url</i>
                                    </span>
                                </label>
       
                                <div class="space-24"></div>

                                <div class="clearfix">
                                        <button type="reset" class="width-30 pull-left btn btn-sm">
                                                <i class="ace-icon fa fa-refresh"></i>
                                                <span class="bigger-110">Reset</span>
                                        </button>
                                    
                                        <button type="submit" class="width-65 pull-right btn btn-sm btn-success" >
                                                <span class="bigger-110">Register</span>

                                                <i class="ace-icon fa fa-arrow-right icon-on-right"></i>
                                        </button>
                                </div>
                                
                        </fieldset>
                 </form:form>

                </div>

                <div class="toolbar center">
                        <a href="/Intranet/login.htm" data-target="#login-box" class="back-to-login-link">
                                <i class="ace-icon fa fa-arrow-left"></i>
                                Atr&aacute;s para iniciar sesi&oacute;n
                        </a>
                </div>
            
        </div><!-- /.widget-body -->
</div><!-- /.signup-box -->

	
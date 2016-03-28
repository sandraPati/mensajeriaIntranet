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
                <div id="terminos" class="error" hidden="true"><p>no ha aceptado los terminos.</p></div>
                <div id="contra" class="error" hidden="true"><p>Contraseñas vacias.</p></div>
                <div id="contranocoinciden" class="error" hidden="true"><p>Las contraseñas no Coinciden.</p></div>
                <div id="usuarionif" class="error" hidden="true"><p>Ya existe un Usuario con el nismo Docuemento NIF</p></div>
                <div id="usuarioDes" class="error" hidden="true"><p>Ya existe un Usuario con la misma descripcion</p></div>
                <div id="errorinesperado" class="error" hidden="true"><p>Error Inesperado del sistema, vuelva intentarlo mas tarde.</p></div>
                
                <div class="widget-main">
                        <h4 class="header green lighter bigger">
                                <i class="ace-icon fa fa-users blue"></i>
                                Trabaja con Nosotros
                        </h4>

                        <div class="space-6"></div>
                        <p> Si eres tan amable complementa los siguientes datos que nos ayudaran a conocerte. Te llevara poco tiempo. Gracias... </p>

                        <form:form id="form1" action="" method="POST" commandName="postulante">
                            <fieldset>
                                <label class="block clearfix">
                                    <span class="block input-icon input-icon-right">
                                    <form:input id="docuemnto_identidad" type="text" class="form-control" placeholder="NIF / NIE / PASAPORTE" path="docuemnto_identidad" required="true"/>
                                    
                                    <i class="ace-icon fa fa-pencil-square-o"></i>
                                    </span>
                                </label>                                                                                                    

                                <label for="form-field-select-3">Perfil Profesional</label>												<br />
                                <form:select id="perfilprof" name="perfilprof" path="perfilprof.id" class="form-control" data-placeholder="Choose a State...">
                                    <form:options items="${listaPerfilProfesional}" itemValue="id" itemLabel="nombre" />
                                </form:select>
                                
                                <br/>
                                <div id="labelOficio">
                                <label id="" for="form-field-select-3" visible="false">Oficio</label>												<br />
                                <form:select id="" name="oficio" path="oficio.id" class="form-control" data-placeholder="Choose a State..." >
                                    <form:options items="${listaOficios}" itemValue="id" itemLabel="nombre" />
                                </form:select>
                                </div>
                                <br/>
                                <div id="otroP">
                                <label id="" for="form-field-select-3" visible="false">Otro Perfil Profesional</label>												<br />
                                <form:input type="text" name="otroperfilprofesional" id="otroperfilprofesional" path="otroperfilprofesional" class="form-control"/>
                                </div>
                                <br/>         

                                    <label class="block clearfix">
                                    <span class="block input-icon input-icon-right">
                                    <form:input id="nombre" type="text" class="form-control" placeholder="Nombres" path="nombre" required="true"/>
                                     <i class="ace-icon fa fa-pencil-square-o"></i>
                                    </span>
                                </label>
                                <label class="block clearfix">
                                    <span class="block input-icon input-icon-right">
                                    <form:input id="apellidos" type="text" class="form-control" placeholder="Apellidos" path="apellidos" required="true"/>
                                    
                                    <i class="ace-icon fa fa-pencil-square-o"></i>
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
                                            <form:input id="usuario" type="text" class="form-control" placeholder="Username" path="usuario" required="true"/>
                                    
                                                <i class="ace-icon fa fa-user"></i>
                                        </span>
                                </label>

                                <label class="block clearfix">
                                        <span class="block input-icon input-icon-right">
                                            <form:input id="contrasenna2" type="password" class="form-control" placeholder="Password" path="contrasenna2" required="true"/>
                                      
                                                <i class="ace-icon fa fa-lock"></i>
                                        </span>
                                </label>

                                <label class="block clearfix">
                                        <span class="block input-icon input-icon-right">
                                           <form:input id="contrasenna" type="password" class="form-control" placeholder="Repeat password" path="contrasenna" required="true"/>
                                      
                                                <i class="ace-icon fa fa-retweet"></i>
                                        </span>
                                </label>
                                <label class="block clearfix">
                                                        
                                                        <div id="labelCoincide" class="col-sm-12">
                                                            <p class="text-success">Coinciden</p>
                                                        </div>
                                                        <div id="labelNOCoincide" class="col-sm-9">
                                                              <p class="text-danger">NO Coinciden</p>
                                                        </div>
                                </label>          
                                <label class="block">
                                    <form:checkbox path="condiciones" required="true"/>
                                     <span class="lbl">
                                            
                                            <a href="#">Acepto condiciones de uso y privacidad: </a>
                                        </span>
                                </label>

                                <div class="space-24"></div>

                                <div class="clearfix">
                                        <button type="reset" class="width-30 pull-left btn btn-sm">
                                                <i class="ace-icon fa fa-refresh"></i>
                                                <span class="bigger-110">Reset</span>
                                        </button>
                                    
                                        <button type="button" id="btn_enviar" class="width-65 pull-right btn btn-sm btn-success" >
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

			<input id="gritter-light"  hidden="true"checked="" type="checkbox" class="ace ace-switch ace-switch-5"/>


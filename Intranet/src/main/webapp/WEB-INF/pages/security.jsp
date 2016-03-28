<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<div id="forgot-box" class="forgot-box visible widget-box no-border">
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
                        <h4 class="header red lighter bigger">
                                <i class="ace-icon fa fa-key"></i>
                                Recuperar Contrase&ntilde;a
                        </h4>

                        <div class="space-6"></div>
                        <p>
                                Ingrese su correo electr&oacute;nico para recibir instrucciones
                        </p>
                        <form:form id="form1" action="" method="POST" commandName="user">
                        
                                <fieldset>
                                        <label class="block clearfix">
                                                <span class="block input-icon input-icon-right">
                                                    <form:input id="email" type="text" class="form-control" placeholder="Email" path="email" required="true"/>
                                                    <i class="ace-icon fa fa-envelope"></i>
                                                </span>
                                        </label>

                                        <div class="clearfix">
                                                <button type="submit" class="width-35 pull-right btn btn-sm btn-danger">
                                                        <i class="ace-icon fa fa-lightbulb-o"></i>
                                                        <span class="bigger-110">Send Me!</span>
                                                </button>
                                        </div>
                                </fieldset>
                        </form:form>
                </div><!-- /.widget-main -->

                <div class="toolbar center">
                        <a href="/Intranet/login.htm" data-target="#login-box" class="back-to-login-link">
                                Atr&aacute;s para iniciar sesi&oacute;n
                                <i class="ace-icon fa fa-arrow-right"></i>
                        </a>
                </div>
        </div><!-- /.widget-body -->
</div><!-- /.forgot-box -->
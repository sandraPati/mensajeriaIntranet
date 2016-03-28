<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<div id="login-box" class="login-box visible widget-box no-border">
     <c:if test="${not empty error}">
	
        <div class="alert alert-danger">
            ${error}
            <br />
        </div>
    </c:if>
    <c:if test="${not empty msg}">
	<div >
            <p class="alert alert-success">
		Se ha cerrado Sesion Satisfactoriamente
            </p>
    </div>
    </c:if>
    <div class="widget-body">
            <div class="widget-main">
                    <h4 class="header blue lighter bigger">
                            <i class="ace-icon fa fa-coffee green"></i>
                            Ingrese sus Datos
                    </h4>

                    <div class="space-6"></div>

                    <form name="loginForm" action="<c:url value='/j_spring_security_check' />" method="POST">
                            <fieldset>
                                    <label class="block clearfix">
                                            <span class="block input-icon input-icon-right">
                                                <input type='text' class="form-control" name='j_username' placeholder="Username" >
                                                <i class="ace-icon fa fa-user"></i>
                                            </span>
                                    </label>

                                    <label class="block clearfix">
                                            <span class="block input-icon input-icon-right">
                                                <input type='password' name='j_password' class="form-control" placeholder="Password" />
                                                <i class="ace-icon fa fa-lock"></i>
                                            </span>
                                    </label>

                                    <div class="space"></div>

                                    <div class="clearfix">
                                            <label class="inline">
                                                <input type="checkbox" class="ace" />
                                                <span class="lbl"> Remember Me</span>
                                            </label>
                                            
                                            <button type="submit" class="width-35 pull-right btn btn-sm btn-primary">
                                                <i class="ace-icon fa fa-key"></i>
                                                <span class="bigger-110">Login</span>
                                            </button>
                                    </div>

                                    <div class="space-4"></div>
                            </fieldset>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                    </form>

                <div class="social-or-login center">
                        <span class="bigger-110">Siguenos en</span>
                </div>

                <div class="space-6"></div>

                <div class="social-login center">
                        <a class="btn btn-primary">
                            <i class="ace-icon fa fa-facebook"></i>
                        </a>

                        <a class="btn btn-info">
                            <i class="ace-icon fa fa-twitter"></i>
                        </a>

                        <a class="btn btn-danger">
                            <i class="ace-icon fa fa-google-plus"></i>
                        </a>
                </div>
                
        </div><!-- /.widget-main -->

        <div class="toolbar clearfix">
                <div>
                        <a href="/Intranet/security.htm" data-target="#forgot-box" class="forgot-password-link">
                            <i class="ace-icon fa fa-arrow-left"></i>
                            Olvid&eacute; mi contrase&ntilde;a
                        </a>
                </div>

                <div>
                     
                    <a href="/Intranet/Postular.htm" data-target="#signup-box" class="user-signup-link">
                            Trabaja con Nosotros
                            <i class="ace-icon fa fa-arrow-right"></i>
                        </a>
                </div>
        </div>
</div><!-- /.widget-body -->   
</div>
                    
                    



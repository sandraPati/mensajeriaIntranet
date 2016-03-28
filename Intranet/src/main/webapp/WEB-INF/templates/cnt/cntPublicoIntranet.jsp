<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<meta charset="utf-8" />
        <title><tiles:insertAttribute name="titulo" ignore="true" /></title>
        <tiles:insertAttribute name="header" ignore="true" />
        
    </head>
    
    <body onload='document.loginForm.username.focus();' class="login-layout light-login">
        
        <div class="main-container">
            <div class="main-content">
		<div class="row">
                    <div class="col-sm-10 col-sm-offset-1">
                        <div class="login-container">
                            <div class="center">
                                <div class="center">
                                <image src="/Intranet/resources/assets/img/logonomina.png"/>    							
                                </div>
                            </div>

                            <div class="position-relative">						
                                <div class="space-6"></div>           
                                    <tiles:insertAttribute name="content" ignore="true" />

                            </div>
                        </div>
                    </div><!-- /.col -->
		</div><!-- /.row -->
            </div><!-- /.main-content -->
        </div><!-- /.main-container -->
        <tiles:insertAttribute name="js" ignore="true" /> 
    </body>
</html>

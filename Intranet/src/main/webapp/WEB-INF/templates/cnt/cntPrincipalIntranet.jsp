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
    
    <body class="no-skin" onload="initialize()">
        <tiles:insertAttribute name="${menu}" ignore="true" />
        <div class="main-content">
            <div class="main-content-inner">
                <tiles:insertAttribute name="menuCentral" ignore="true" /> 
                <tiles:insertAttribute name="content" ignore="true" />
            </div>                    
        </div> 
        <tiles:insertAttribute name="footer" ignore="true" />  
        </div><!-- /.main-container -->
        <tiles:insertAttribute name="js" ignore="true" /> 
    </body>
</html>

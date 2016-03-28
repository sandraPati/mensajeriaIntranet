<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		
		<meta name="description" content="User login page" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
                <title><tiles:insertAttribute name="titulo" ignore="true" /></title>  
		<!-- bootstrap & fontawesome -->
		<link rel="stylesheet" href="/Intranet/resources/assets/css/bootstrap.css" />
		<link rel="stylesheet" href="/Intranet/resources/assets/css/font-awesome.css" />

		<!-- text fonts -->
		<link rel="stylesheet" href="/Intranet/resources/assets/css/ace-fonts.css" />

		<!-- ace styles -->
		<link rel="stylesheet" href="/Intranet/resources/assets/css/ace.css" />

		<!--[if lte IE 9]>
			<link rel="stylesheet" href="../assets/css/ace-part2.css" />
		<![endif]-->
		<link rel="stylesheet" href="/Intranet/resources/assets/css/ace-rtl.css" />

		<!--[if lte IE 9]>
		  <link rel="stylesheet" href="../assets/css/ace-ie.css" />
		<![endif]-->

		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

		<!--[if lt IE 9]>
		<script src="../assets/js/html5shiv.js"></script>
		<script src="../assets/js/respond.js"></script>
		<![endif]-->
               
                <style>
.error {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #a94442;
	background-color: #f2dede;
	border-color: #ebccd1;
}
</style>
    </head>  
      
<body onload='document.loginForm.username.focus();' class="login-layout light-login">        
<!-- start header -->
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

	<div class="position-relative">						<div class="space-6"></div>  
         
                <tiles:insertAttribute name="content" ignore="true" />
            
        </div>
            
            
            
        
            
            
            
        </div>
					</div><!-- /.col -->
				</div><!-- /.row -->
			</div><!-- /.main-content -->
		</div><!-- /.main-container -->    
            
            
</body>
</html>

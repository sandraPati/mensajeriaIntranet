<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
	<head>
            <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		
		<meta name="description" content="User login page" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
		<title><tiles:insertAttribute name="titulo" ignore="true" /></title>  

		<meta name="description" content="overview &amp; stats" />		
		<meta name="description" content="Static &amp; Dynamic Tables" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

		<!-- bootstrap & fontawesome -->
		<link rel="stylesheet" href="/Intranet/resources/assets/css/bootstrap.css" />
		<link rel="stylesheet" href="/Intranet/resources/assets/css/font-awesome.css" />
                
                
                
                

		<!-- page specific plugin styles -->
                <link rel="stylesheet" href="/Intranet/resources/assets/css/jquery-ui.css" />
		<!-- text fonts -->
		<link rel="stylesheet" href="/Intranet/resources/assets/css/ace-fonts.css" />

		<!-- ace styles -->
		<link rel="stylesheet" href="/Intranet/resources/assets/css/ace.css" class="ace-main-stylesheet" id="main-ace-style" />

		<!--[if lte IE 9]>
			<link rel="stylesheet" href="../assets/css/ace-part2.css" class="ace-main-stylesheet" />
		<![endif]-->

		<!--[if lte IE 9]>
		  <link rel="stylesheet" href="../assets/css/ace-ie.css" />
		<![endif]-->

		<!-- inline styles related to this page -->

		<!-- ace settings handler -->
		<script src="/Intranet/resources/assets/js/ace-extra.js"></script>

		<!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

		<!--[if lte IE 8]>
		<script src="../assets/js/html5shiv.js"></script>
		<script src="../assets/js/respond.js"></script>
		<![endif]-->
	</head>

	<body class="no-skin" onload="initialize()">
		<!-- #section:basics/navbar.layout -->
		<tiles:insertAttribute name="${menu}" ignore="true" /> 
                <tiles:insertAttribute name="report3" ignore="true" />
					<!-- /section:basics/content.breadcrumbs -->
					<div class="page-content">
						<tiles:insertAttribute name="content" ignore="true" />	

	</body>
</html>

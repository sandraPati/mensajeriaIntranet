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

	</head>

	<body class="no-skin">
		<!-- #section:basics/navbar.layout -->
		
					<!-- /section:basics/content.breadcrumbs -->
					<div class="page-content">
						<tiles:insertAttribute name="content" ignore="true" />	

	</body>
</html>

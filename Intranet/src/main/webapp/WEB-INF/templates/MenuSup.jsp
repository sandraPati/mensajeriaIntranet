<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<div id="navbar" class="navbar navbar-default navbar-fixed-top" STYLE="background-color:#FFFFFF">
	<div class="navbar-container" id="navbar-container">
				<!-- #section:basics/sidebar.mobile.toggle -->
				<button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler" data-target="#sidebar">
					<span class="sr-only">Toggle sidebar</span>

					<span class="icon-bar"></span>

					<span class="icon-bar"></span>

					<span class="icon-bar"></span>
				</button>

				<!-- /section:basics/sidebar.mobile.toggle -->
				<div class="navbar-header pull-left">
					<!-- #section:basics/navbar.layout.brand -->
					<div class="center">
			            <image src="/Intranet/resources/assets/img/logonomina.png" width="200" height="46"/>    							
			        </div>
					<!--<a href="#" class="navbar-brand">
						<small>
							<i class="fa fa-leaf"></i>

							Ace Admin
						</small>
					</a>-->

					<!-- /section:basics/navbar.layout.brand -->

					<!-- #section:basics/navbar.toggle -->

					<!-- /section:basics/navbar.toggle -->
				</div>
                <tiles:insertAttribute name="report1" ignore="true" />
            
</div>    
</div>
					 
<div class="main-container" id="main-container">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>            
       
        <tiles:insertAttribute name="report2" ignore="true" />
        <div class="main-content">
				<div class="main-content-inner">
					<!-- #section:basics/content.breadcrumbs -->
					
					<!-- /section:basics/content.breadcrumbs -->
					
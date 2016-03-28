<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!--<script type="text/javascript">
					try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
				</script>-->
<div id="sidebar" class="sidebar responsive sidebar-fixed">
				<div class="sidebar-shortcuts" id="sidebar-shortcuts">
					<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
						<button class="btn btn-success">
							<i class="ace-icon fa fa-signal"></i>
						</button>

						<button class="btn btn-info">
							<i class="ace-icon fa fa-pencil"></i>
						</button>

						<!-- #section:basics/sidebar.layout.shortcuts -->
						<button class="btn btn-warning">
							<i class="ace-icon fa fa-users"></i>
						</button>

						<button class="btn btn-danger">
							<i class="ace-icon fa fa-cogs"></i>
						</button>

						<!-- /section:basics/sidebar.layout.shortcuts -->
					</div>

					<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
						<span class="btn btn-success"></span>

						<span class="btn btn-info"></span>

						<span class="btn btn-warning"></span>

						<span class="btn btn-danger"></span>
					</div>
				</div><!-- /.sidebar-shortcuts -->

				<ul class="nav nav-list">

					<li class="active">
						<a href="/Intranet/Home.htm">
							<i class="menu-icon fa fa-book"></i>
							<span class="menu-text"> Men&uacute; </span>
						</a>

						<b class="arrow"></b>
					</li>
                                        <li class="">
						<a href="" class="dropdown-toggle">
							<i class="menu-icon fa fa-wrench"></i>
							<span class="menu-text">
								Informacion
							</span>

							<b class="arrow fa fa-angle-down"></b>
						</a>						

						<b class="arrow"></b>

						<ul class="submenu">
							<li class="">
								<a href="/Intranet/cli/DatosCliente.htm">
									<i class="menu-icon fa fa-caret-right"></i>

									Datos
									
								</a>

							</li>
                                                        <li class="">
								<a href="/Intranet/cli/CsecurityDatosCliente.htm">
									<i class="menu-icon fa fa-cog align-top"></i>
									Configuracion de Seguridad
								</a>

								<b class="arrow"></b>
							</li>
                                                        <li class="">
								<a href="/Intranet/cli/CfichaCliente.htm">
									<i class="menu-icon fa fa-cog align-top"></i>
									Ficha
								</a>

								<b class="arrow"></b>
							</li>
							
						</ul>
					</li>
					
				</ul><!-- /.nav-list -->

				<!-- #section:basics/sidebar.layout.minimize -->
				<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
					<i class="ace-icon fa fa-angle-double-left" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
				</div>

				<!-- /section:basics/sidebar.layout.minimize -->
				<script type="text/javascript">
					try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
				</script>
                                
                                
</div>                               
                                
                             
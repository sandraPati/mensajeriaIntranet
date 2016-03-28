<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>

			<!-- #section:basics/sidebar -->
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
								<a href="/Intranet/emp/Datos.htm" >
									<i class="menu-icon fa fa-caret-right"></i>

									Datos
									
								</a>

							</li>
                                                        <li class="">
								<a href="/Intranet/emp/ActualizarfotoEmpleado.htm">
									<i class="menu-icon fa fa-cog align-top"></i>
									Actualizar Foto
								</a>

								<b class="arrow"></b>
							</li>
							<li class="">
								<a href="/Intranet/emp/securityEmpleado.htm">
									<i class="menu-icon fa fa-cog align-top"></i>
									Configuracion de Seguridad
								</a>

								<b class="arrow"></b>
							</li>
						</ul>
					</li>
                                        <li class="">
						<a href="" class="dropdown-toggle">
							<i class="menu-icon fa fa-list"></i>
							<span class="menu-text">
								Mis Archivos
							</span>

							<b class="arrow fa fa-angle-down"></b>
                                                     
						</a>						

						<b class="arrow"></b>

						<ul class="submenu">
							
                                                        <li class="">
                                                                <a href="/Intranet/emp/verContratosEmp.htm">
                                                                        <i class="menu-icon fa fa-list"></i>
                                                                      Nominas y Deducciones
                                                                </a>

                                                                <b class="arrow"></b>
                                                        </li>
                                                       
						</ul>
					</li>
					
                                        <li class="">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-list"></i>
							<span class="menu-text"> Agenda </span>

							<b class="arrow fa fa-angle-down"></b>
						</a>

						<b class="arrow"></b>

						<ul class="submenu">
							
							<li class="">
								<a href="/Intranet/emp/EverAgenda.htm">
									<i class="menu-icon fa fa-caret-right"></i>
									Agenda Tareas
								</a>

								<b class="arrow"></b>
							</li>

							<li class="">
								<a href="/Intranet/emp/EAgendaPlanObra.htm">
									<i class="menu-icon fa fa-caret-right"></i>
									Agenda Plan de Obras
								</a>

								<b class="arrow"></b>
							</li>
						</ul>
					</li>

                                        <li class="">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-pencil-square-o"></i>
							<span class="menu-text"> Propuestas </span>

							<b class="arrow fa fa-angle-down"></b>
						</a>

						<b class="arrow"></b>

						<ul class="submenu">
                                                    <li class="">
								<a href="" class="dropdown-toggle">
									<i class="menu-icon fa fa-caret-right"></i>

									Nueva Propuesta
									<b class="arrow fa fa-angle-down"></b>
								</a>

								<b class="arrow"></b>

								<ul class="submenu">
									<li class="">
										<a href="/Intranet/emp/ENuevaPropuesta.htm">
											<i class="menu-icon fa fa-caret-right"></i>
											Propuesta y Presupuesto
										</a>

										<b class="arrow"></b>
									</li>

									<li class="">
										<a href="/Intranet/emp/ENuevaPropuestaExpres.htm">
											<i class="menu-icon fa fa-caret-right"></i>
											Propuesta y Presupuesto Expres Baño
										</a>

										<b class="arrow"></b>
									</li>
                                                                        <li class="">
										<a href="/Intranet/emp/ENuevaPropuestaExpresC.htm">
											<i class="menu-icon fa fa-caret-right"></i>
											Propuesta y Presupuesto Expres Cocina
										</a>

										<b class="arrow"></b>
									</li>

								</ul>
							</li>
                                                  
							<li class="">
								<a href="/Intranet/emp/ELtaClientesPropuesta.htm">
									<i class="menu-icon fa fa-caret-right"></i>
									Consultar Propuesta
								</a>

								<b class="arrow"></b>
							</li>

							<li class="">
								<a href="/Intranet/emp/ELtaClientesProyecto.htm">
									<i class="menu-icon fa fa-caret-right"></i>
									Consultar Proyecto
								</a>

								<b class="arrow"></b>
							</li>
							
						</ul>
					</li>
                                        <li class="">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-tag"></i>
							<span class="menu-text"> Clientes </span>

							<b class="arrow fa fa-angle-down"></b>
						</a>

						<b class="arrow"></b>

						<ul class="submenu">
							<li class="">
								<a href="/Intranet/emp/EClientes.htm">
									<i class="menu-icon fa fa-caret-right"></i>
									Gestion 
								</a>

								<b class="arrow"></b>
							</li>

						</ul>
					</li>
                                        <li class="">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-tag"></i>
							<span class="menu-text"> Proveedores </span>

							<b class="arrow fa fa-angle-down"></b>
						</a>

						<b class="arrow"></b>

						<ul class="submenu">
							<li class="">
								<a href="/Intranet/emp/EPGestion.htm">
									<i class="menu-icon fa fa-caret-right"></i>
									Gestionar 
								</a>

								<b class="arrow"></b>
							</li>

							<li class="">
								<a href="/Intranet/emp/EPTipoActividad.htm">
									<i class="menu-icon fa fa-caret-right"></i>
									Tipos de Actividad
								</a>

								<b class="arrow"></b>
							</li>

						</ul>
					</li>
                                        <li class="">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-bar-chart-o"></i>
							<span class="menu-text"> Contabilidad </span>

							<b class="arrow fa fa-angle-down"></b>
						</a>

						<b class="arrow"></b>

						<ul class="submenu">
                                                        
							<li class="">
								<a href="" class="dropdown-toggle">
									<i class="menu-icon fa fa-caret-right"></i>

									Gastos
									<b class="arrow fa fa-angle-down"></b>
								</a>

								<b class="arrow"></b>

								<ul class="submenu">
									<li class="">
										<a href="/Intranet/emp/ECompra.htm">
											<i class="menu-icon fa fa-caret-right"></i>
											Facturas de Compra
										</a>

										<b class="arrow"></b>
									</li>


									<li class="">
										<a href="/Intranet/emp/EGastos.htm">
											<i class="menu-icon fa fa-caret-right"></i>
											Otros Gastos
										</a>

										<b class="arrow"></b>
									</li>

								</ul>
							</li>


						</ul>
					</li>
                                         <li >
						<a href="<c:out value="http://decorakia.ddns.net:85/Mail/" />" target="_blank"onClick="window.open(this.href); return false;">
							<i class="menu-icon fa fa fa-envelope"></i>
							<span class="menu-text"> Email </span>
						</a>

						<b class="arrow"></b>
					</li>
                                        <li >
						<a href="/Intranet/emp/EMensajeria.htm">
							<i class="menu-icon fa fa-users"></i>
							<span class="menu-text"> Mensajeria </span>
						</a>

						<b class="arrow"></b>
					</li>
                                        <li >
						<a href="/Intranet/emp/ESMS.htm">
							<i class="menu-icon fa fa-phone"></i>
							<span class="menu-text"> SMS </span>
						</a>

						<b class="arrow"></b>
					</li>
                                        <li class="">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-tag"></i>
							<span class="menu-text"> Herramientas </span>

							<b class="arrow fa fa-angle-down"></b>
						</a>

						<b class="arrow"></b>

						<ul class="submenu">
							<li class="">
								<a href="/Intranet/resources/decorakia.rar">
									<i class="menu-icon fa fa-cloud-download"></i>
									Decorakia.exe 
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
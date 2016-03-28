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
								<a href="/Intranet/sup/DatosSupervisor.htm">
									<i class="menu-icon fa fa-caret-right"></i>

									Datos
									
								</a>

							</li>
                                                        <li class="">
								<a href="/Intranet/sup/ActualizarfotoSupervisor.htm">
									<i class="menu-icon fa fa-cog align-top"></i>
									Actualizar Foto
								</a>

								<b class="arrow"></b>
							</li>
							<li class="">
								<a href="/Intranet/sup/securitySupervisor.htm">
									<i class="menu-icon fa fa-cog align-top"></i>
									Configuracion de Seguridad
								</a>

								<b class="arrow"></b>
							</li>
						</ul>
					</li>
					<li class="">
						<a href="" class="dropdown-toggle">
							<i class="menu-icon fa fa-desktop"></i>
							<span class="menu-text">
								Recursos Humanos
							</span>

							<b class="arrow fa fa-angle-down"></b>
						</a>						

						<b class="arrow"></b>

						<ul class="submenu">
							<li class="">
								<a href="" class="dropdown-toggle">
									<i class="menu-icon fa fa-caret-right"></i>

									Empleados
									<b class="arrow fa fa-angle-down"></b>
								</a>

								<b class="arrow"></b>

								<ul class="submenu">
									<li class="">
										<a href="/Intranet/sup/DocumentosContratos.htm">
											<i class="menu-icon fa fa-caret-right"></i>
											Documentos de Contratos
										</a>

										<b class="arrow"></b>
									</li>

									<li class="">
										<a href="/Intranet/sup/verEmpleados.htm">
											<i class="menu-icon fa fa-caret-right"></i>
											Gestion de Empleados
										</a>

										<b class="arrow"></b>
									</li>

								</ul>
							</li>

							<li class="">
								<a href="/Intranet/sup/cvrecibidos.htm">
									<i class="menu-icon fa fa-caret-right"></i>
									C.V Recibidos
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
								<a href="/Intranet/sup/verAgendaEmpleados.htm">
									<i class="menu-icon fa fa-caret-right"></i>
									Agenda Empleados
								</a>

								<b class="arrow"></b>
							</li>

							<li class="">
								<a href="/Intranet/sup/verPlanObraAgendaEmpleados.htm">
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
								<a href="/Intranet/sup/SLtaClientesPropuesta.htm">
									<i class="menu-icon fa fa-caret-right"></i>
									Consultar Propuesta
								</a>

								<b class="arrow"></b>
							</li>

							<li class="">
								<a href="/Intranet/sup/SLtaClientesProyecto.htm">
									<i class="menu-icon fa fa-caret-right"></i>
									Consultar Proyecto
								</a>

								<b class="arrow"></b>
							</li>
							
						</ul>
					</li>

                                        <li class="">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon glyphicon  glyphicon-map-marker"></i>
							<span class="menu-text"> GPS </span>

							<b class="arrow fa fa-angle-down"></b>
						</a>

						<b class="arrow"></b>

						<ul class="submenu">
							<li class="">
								<a href="/Intranet/sup/SeguimientoGPS.htm">
									<i class="menu-icon fa fa-caret-right"></i>
									Seguimiento GPS 
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
								<a href="/Intranet/sup/Clientes.htm">
									<i class="menu-icon fa fa-caret-right"></i>
									Gestion 
								</a>

								<b class="arrow"></b>
							</li>

						</ul>
					</li>

					<li class="">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-file-o"></i>

							<span class="menu-text">
								Base de Precios

								<!-- #section:basics/sidebar.layout.badge -->
								<span class="badge badge-primary">2</span>

								<!-- /section:basics/sidebar.layout.badge -->
							</span>

							<b class="arrow fa fa-angle-down"></b>
						</a>

						<b class="arrow"></b>

						<ul class="submenu">
							<li class="">
								<a href="/Intranet/sup/Capitulos.htm">
                                                                  <i class="menu-icon fa fa-caret-right"></i>
                                                                  Capitulos
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
								<a href="/Intranet/sup/Gestion.htm">
									<i class="menu-icon fa fa-caret-right"></i>
									Gestionar 
								</a>

								<b class="arrow"></b>
							</li>

							<li class="">
								<a href="/Intranet/sup/Calificar.htm">
									<i class="menu-icon fa fa-caret-right"></i>
									Calificar
								</a>

								<b class="arrow"></b>
							</li>

							<li class="">
								<a href="/Intranet/sup/STipoActividad.htm">
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

									Venta
									<b class="arrow fa fa-angle-down"></b>
								</a>

								<b class="arrow"></b>

								<ul class="submenu">
									<li class="">
										<a href="/Intranet/sup/FacturasVentas.htm">
											<i class="menu-icon fa fa-caret-right"></i>
											Facturas de Venta
										</a>

										<b class="arrow"></b>
									</li>

									<li class="">
										<a href="/Intranet/sup/Ingresos.htm">
											<i class="menu-icon fa fa-caret-right"></i>
											Otros ingresos
										</a>

										<b class="arrow"></b>
									</li>

								</ul>
							</li>

							<li class="">
								<a href="" class="dropdown-toggle">
									<i class="menu-icon fa fa-caret-right"></i>

									Gastos
									<b class="arrow fa fa-angle-down"></b>
								</a>

								<b class="arrow"></b>

								<ul class="submenu">
									<li class="">
										<a href="/Intranet/sup/DocumentosContratos.htm">
											<i class="menu-icon fa fa-caret-right"></i>
											Facturas de Compra
										</a>

										<b class="arrow"></b>
									</li>

									<li class="">
										<a href="/Intranet/sup/Gastos.htm">
											<i class="menu-icon fa fa-caret-right"></i>
											Otros Gastos
										</a>

										<b class="arrow"></b>
									</li>

								</ul>
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
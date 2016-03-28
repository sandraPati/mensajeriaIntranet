<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- #section:settings.box -->

<div class="page-content">  
<div class="page-header">
    <div class="row">
        <div class="col-lg-8">
        <h1>
               Contrato 
        <small>
            <i class="ace-icon fa fa-angle-double-right"></i>
            ${cont.id_tipo_contrato.nombre} DESDE: ${empleado.duracion_contrato_desde} HASTA: ${empleado.duracion_contrato_hasta}
        </small>
        </h1>
        </div>
         
             
             
    </div>
</div><!-- /.page-header -->
                         
<div id="signup-box" class="signup-box visible widget-box no-border">
    <div class="widget-body">
        <c:if test="${not empty error}">
           
        <div class="alert alert-danger">
            <button type="button" class="close" data-dismiss="alert">
                    <i class="ace-icon fa fa-times"></i>
            </button>

            <strong>
                    <i class="ace-icon fa fa-times"></i>
                    
            </strong>

            ${error}
            <br />
        </div>

        </c:if>
        <c:if test="${not empty mensaje}">
            <div >
                <p class="alert alert-success">
                    ${mensaje}
                </p>
        </div>
        </c:if>  
    </div> 
</div>
                         <div class="row">
									<div class="col-xs-12">
										
										<div class="clearfix">
											<div class="pull-right tableTools-container3"></div>
										</div>
										<div class="table-header">
											Lista de Nominas
										</div>

										<!-- div.table-responsive -->

										<!-- div.dataTables_borderWrap -->
										<div class="table-responsive">
											<table id="dynamic-table3" class="table table-striped table-bordered table-hover table-condensed">
												<thead>
													<tr>
														<th>MES</th>
														<th>AÑO</th>
														<th class="hidden-480">SALARIO BASE</th>
														<th></th>
                                                                                                                <th></th>
													</tr>
												</thead>

												<tbody>
                                                                                                <c:forEach items="${ltanomi}" var="item">
													<tr>
														
														<td><c:out value="${item.mes}" /></td>
														<td><c:out value="${item.anio}" /></td>
														<td class="hidden-480"><c:out value="${item.salario_base}" /></td>

														<td>
															<div class="hidden-sm hidden-xs action-buttons">
																    
                                                                                                                              
																<a class="blue tooltip-info" data-rel="tooltip" href="/Intranet/emp/viewNominaEmp.htm?idN=${item.id}" title="Consultar Nomina">
																	<i class="ace-icon fa fa-search-plus bigger-130" ></i>
																</a>
							</div>

															<div class="hidden-md hidden-lg">
																<div class="inline pos-rel">
																	<button class="btn btn-minier btn-yellow dropdown-toggle" data-toggle="dropdown" data-position="auto">
																		<i class="ace-icon fa fa-caret-down icon-only bigger-120"></i>
																	</button>

																	<ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
																		
                                                                                                                                                
                                                                                                                                                <li>
																			<a href="/Intranet/emp/viewNominaEmp.htm?idN=${item.id}" class="tooltip-success" data-rel="tooltip" title="Consultar Nomina">
																				<span class="blue">
																					<i class="ace-icon fa fa-search-plus bigger-120"></i>
																				</span>
																			</a>
																		</li>
								</ul>
																</div>
															</div>
														</td>
                                                                                                                <td>
															<div class="hidden-sm hidden-xs action-buttons">     
                                                                                                                            <a class="" href="/Intranet/emp/verNominaCEmp.htm?idC=${cont.id}&idN=${item.id}">Nomina</a>
															</div>
                                                                                                                     
															<div class="hidden-md hidden-lg">
																<div class="inline pos-rel">
																	<button class="btn btn-minier btn-yellow dropdown-toggle" data-toggle="dropdown" data-position="auto">
																		<i class="ace-icon fa fa-caret-down icon-only bigger-120"></i>
																	</button>

																	<ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
																		

																		<li>
																			<a href="/Intranet/sup/verNominaCEmp.htm?idC=${cont.id}&idN=${item.id}" class="tooltip-error" data-rel="tooltip" title="Eliminar Nomina">Nomina</a>
																		</li>
																	</ul>
																</div>
															</div>
														</td>
													</tr>
													</c:forEach> 

													
													
												</tbody>
											</table>
										</div>
										
										
									</div>

					    </div>
   
	
					</div><!-- /.row -->    
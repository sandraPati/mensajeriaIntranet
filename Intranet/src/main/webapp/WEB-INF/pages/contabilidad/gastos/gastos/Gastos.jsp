<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- #section:settings.box -->
<div class="page-content">	
<div class="page-header">
    <div class="row">
        <div class="col-lg-8">
        <h1>
        Gastos
        <small>
                <i class="ace-icon fa fa-angle-double-right"></i>
        </small>
    </h1>
        </div>
         <div class="col-lg-4 align-right">
            <a class=" btn btn-white btn-warning" href="/Intranet/sup/addGasto.htm" data-rel="tooltip">
                Agregar Gasto
            </a>
            <a class=" btn btn-white btn-warning" href="/Intranet/sup/addGastoR.htm" data-rel="tooltip">
                Gasto 
            </a> 
        </div>
             
             
    </div>
</div><!-- /.page-header -->

<div class="row">
    <div class="col-xs-12">
        
        <div class="clearfix">
            <div class="pull-right tableTools-container2"></div>
        </div>
        
        <div class="table-header" STYLE="background-color:#8C94C6">
                Lista de Gastos
        </div>

        <!-- div.table-responsive -->

        <!-- div.dataTables_borderWrap -->
        <div class="table-responsive">
            <table id="dynamic-table2" class="table table-striped table-bordered table-hover table-condensed">
                <thead>
                    <tr>

                        <th>FORMA DE PAGO</th>
                        <th>TIPO DE GASTO</th>
                        <th>PROVEEDOR</th>
                        <th>FECHA PAGO</th>
                        <th>Empleado</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach items="${gastosListbox}" var="item">
                        <tr>


                                <td>
                                     <c:out value="${item.formapago_id.nombre}" />
                                </td>
                                <td><c:out value="${item.tipogasto_id.nombre}" /></td>
                                <td><c:out value="${item.proveedor_id.id}" /> <c:out value="${item.proveedor_id.nombre}" />, <c:out value="${item.proveedor_id.persona_contacto}" /></td>
                                <td><c:out value="${item.fechapago}" /></td>
                                <td><c:out value="${item.nifempleado.nif}" /><c:out value="${item.nifempleado.nombre}" /></td>
                                
                                <td>
                                    <c:if test="${item.estado==0}">
                                        <a id="factPagada" name="factP" class="orange tooltip-warning" data-rel="tooltip"  href="/Intranet/sup/GastoPagada.htm?id=${item.id}" title="Pagada">
                                            <i class="ace-icon fa fa-square-o bigger-130"></i>
                                        </a>
                                    </c:if>
                                    <c:if test="${item.estado==1}">
                                        <a class="green tooltip-success" data-rel="tooltip"  href="/Intranet/sup/GastoPendiente.htm?id=${item.id}" title="Pendiente">
                                            <i class="ace-icon fa fa-check-square-o bigger-130"></i>
                                        </a>
                                    </c:if>
                                </td>
                                
                                <td>
                                    <c:if test="${item.imgfactura==0}">
                                        <div class="hidden-sm hidden-xs action-buttons">
                                            
                                             <a class="green tooltip-success" data-rel="tooltip"  href="/Intranet/sup/updateGasto.htm?id=${item.id}" title="Actualizar">
                                                            <i class="ace-icon fa fa-pencil bigger-130"></i>
                                            </a>

                                            <a class="red tooltip-error" data-rel="tooltip"  href="/Intranet/sup/deleteGasto.htm?id=${item.id}" title="Eliminar">
                                                    <i class="ace-icon fa fa-trash-o bigger-130"></i>
                                            </a>   

                                        </div>

                                        <div class="hidden-md hidden-lg">
                                                <div class="inline pos-rel">
                                                        <button class="btn btn-minier btn-yellow dropdown-toggle" data-toggle="dropdown" data-position="auto">
                                                                <i class="ace-icon fa fa-caret-down icon-only bigger-120"></i>
                                                        </button>

                                                        <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
                                                              
                                                            <li>
                                                                    <a href="/Intranet/sup/updateGasto.htm?id=${item.id}" class="tooltip-success" data-rel="tooltip" title="Actualizar">
                                                                            <span class="green">
                                                                                    <i class="ace-icon fa fa-pencil-square-o bigger-120"></i>
                                                                            </span>
                                                                    </a>
                                                                </li>

                                                                <li>
                                                                    <a href="/Intranet/sup/deleteGasto.htm?id=${item.id}" class="tooltip-error" data-rel="tooltip" title="Eliminar">
                                                                            <span class="red">
                                                                                    <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                                                            </span>
                                                                    </a>
                                                                </li>


                                                        </ul>
                                                </div>
                                        </div>
                                    </c:if>
                                    <c:if test="${item.imgfactura==1}">
                                        <div class="hidden-sm hidden-xs action-buttons">
                                            
                                             <a class="green tooltip-success" data-rel="tooltip"  href="/Intranet/sup/updateGastoR.htm?id=${item.id}" title="Actualizar">
                                                            <i class="ace-icon fa fa-pencil bigger-130"></i>
                                            </a>

                                            <a class="red tooltip-error" data-rel="tooltip"  href="/Intranet/sup/deleteGastoR.htm?id=${item.id}" title="Eliminar">
                                                    <i class="ace-icon fa fa-trash-o bigger-130"></i>
                                            </a>   

                                        </div>

                                        <div class="hidden-md hidden-lg">
                                                <div class="inline pos-rel">
                                                        <button class="btn btn-minier btn-yellow dropdown-toggle" data-toggle="dropdown" data-position="auto">
                                                                <i class="ace-icon fa fa-caret-down icon-only bigger-120"></i>
                                                        </button>

                                                        <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
                                                              
                                                            <li>
                                                                    <a href="/Intranet/sup/updateGastoR.htm?id=${item.id}" class="tooltip-success" data-rel="tooltip" title="Actualizar">
                                                                            <span class="green">
                                                                                    <i class="ace-icon fa fa-pencil-square-o bigger-120"></i>
                                                                            </span>
                                                                    </a>
                                                                </li>

                                                                <li>
                                                                    <a href="/Intranet/sup/deleteGastoR.htm?id=${item.id}" class="tooltip-error" data-rel="tooltip" title="Eliminar">
                                                                            <span class="red">
                                                                                    <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                                                            </span>
                                                                    </a>
                                                                </li>


                                                        </ul>
                                                </div>
                                        </div>
                                    </c:if>
                                </td>

                        </tr>
                    </c:forEach> 


                </tbody>
        </table>
                </div>
                <br/>
                <br/>                    
        </div>
</div>

					</div><!-- /.row -->
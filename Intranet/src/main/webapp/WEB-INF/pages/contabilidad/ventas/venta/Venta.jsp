<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- #section:settings.box -->
<div class="page-content"> 	
<div class="page-header">
    <div class="row">
        <div class="col-lg-8">
        <h1>
        Facturas de Venta
        <br/>
        <small>
                <i class="ace-icon fa fa-angle-double-right"></i>
                Crea aqui tus facturas de ventas
        </small>
    </h1>
        </div>
         <div class="col-lg-4 align-right">
            <a class=" btn btn-sm btn-success" href="/Intranet/sup/FacturaVenta.htm" data-rel="tooltip">
                Crear Factura de Venta
            </a>
            
        </div>
             
             
    </div>
</div><!-- /.page-header -->
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
    <c:if test="${not empty msg}">
	<div class="alert alert-block alert-success">
            <button type="button" class="close" data-dismiss="alert">
                    <i class="ace-icon fa fa-times"></i>
            </button>

            <strong>
                    <i class="ace-icon fa fa-check"></i>
                    
            </strong>

            ${msg}
            <br />
        </div>

    </c:if>
<div class="row">
    <div class="col-xs-12">
        
        <div class="clearfix">
            <div class="pull-right tableTools-container2"></div>
        </div>
        

        <!-- div.table-responsive -->

        <!-- div.dataTables_borderWrap -->
        <div class="table-responsive">
            <table id="dynamic-table2" class="table table-striped table-bordered table-hover table-condensed">
                <thead>
                    <tr>
                        <th>NUM</th>
                        <th>FECHA FACTURA</th>
                        <th>CLIENTE</th>
                        <th>REFERENCIA</th>
                        <th>TOTAL</th>							
                        <th>PENDIENTE</th>														
                        <th>ESTADO DE PAGO</th>
                        <th>Rect.</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach items="${ventaListbox}" var="item">
                        <tr>

                                 <td>
                                     <c:out value="${item.num}" />
                                </td>
                                <td>
                                     <c:out value="${item.fecha}" />
                                </td>
                                <td><c:out value="${item.cliente_nif.nif}" /> <c:out value="${item.cliente_nif.nombre}" />, <c:out value="${item.cliente_nif.apellidos}" /></td>
                                <td><c:out value="${item.referencia}" /></td>
                                <td><c:out value="${item.total}" /></td>
                                <td></td>
                                <td><c:out value="${item.estado}" /></td>
                                <td><c:out value="${item.rectificactiva}" /></td>
                                <td>
                                    <c:if test="${item.estado==0}">
                                        <a  class="orange tooltip-warning" data-rel="tooltip"  href="/Intranet/sup/VFacturaPagada.htm?id=${item.num}" title="Factura Pagada">
                                            <i class="ace-icon fa fa-square-o bigger-130"></i>
                                        </a>
                                    </c:if>
                                    <c:if test="${item.estado==1}">
                                        <a class="green tooltip-success" data-rel="tooltip"  href="/Intranet/sup/VFacturaPendiente.htm?id=${item.num}" title="Factura Pendiente">
                                            <i class="ace-icon fa fa-check-square-o bigger-130"></i>
                                        </a>
                                    </c:if>
                                </td>
                                <td>
                                        <div class="hidden-sm hidden-xs action-buttons">
                                            
                                             <a class="green tooltip-success" data-rel="tooltip"  href="/Intranet/sup/updateFV.htm?id=${item.num}" title="Actualizar">
                                                            <i class="ace-icon fa fa-pencil bigger-130"></i>
                                            </a>

                                            <a class="red tooltip-error" data-rel="tooltip"  href="/Intranet/sup/deleteFacturaVenta.htm?id=${item.num}" title="Eliminar">
                                                    <i class="ace-icon fa fa-trash-o bigger-130"></i>
                                            </a> 
                                            <a class="blue tooltip-info" data-rel="tooltip"  href="/Intranet/sup/verFacturaVentaPdf.htm?id=${item.num}" title="Ver Factura">
                                                    <i class="ace-icon fa fa fa-search-plus bigger-130"></i>
                                            </a>         
                                            <a class="blue tooltip-info" data-rel="tooltip"  href="/Intranet/sup/enviarFacturaVenta.htm?id=${item.num}" title="Enviar Factura">
                                                    <i class="ace-icon fa fa-envelope-o bigger-130"></i>
                                            </a>         
                                        </div>

                                        <div class="hidden-md hidden-lg">
                                                <div class="inline pos-rel">
                                                        <button class="btn btn-minier btn-yellow dropdown-toggle" data-toggle="dropdown" data-position="auto">
                                                                <i class="ace-icon fa fa-caret-down icon-only bigger-120"></i>
                                                        </button>

                                                        <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
                                                              
                                                            <li>
                                                                    <a href="/Intranet/sup/updateFV.htm?id=${item.num}" class="tooltip-success" data-rel="tooltip" title="Actualizar">
                                                                            <span class="green">
                                                                                    <i class="ace-icon fa fa-pencil-square-o bigger-120"></i>
                                                                            </span>
                                                                    </a>
                                                                </li>

                                                                <li>
                                                                    <a href="/Intranet/sup/deleteFacturaVenta.htm?id=${item.num}" class="tooltip-error" data-rel="tooltip" title="Eliminar">
                                                                            <span class="red">
                                                                                    <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                                                            </span>
                                                                    </a>
                                                                </li>
                                                                <li>
                                                                    <a href="/Intranet/sup/verFacturaVentaPdf.htm?id=${item.num}" class="tooltip-info" data-rel="tooltip" title="Ver Factura">
                                                                            <span class="blue">
                                                                                    <i class="ace-icon fa fa fa-search-plus bigger-120"></i>
                                                                            </span>
                                                                    </a>
                                                                </li>
                                                                <li>
                                                                    <a href="/Intranet/sup/enviarFacturaVenta.htm?id=${item.num}" class="tooltip-info" data-rel="tooltip" title="Enviar Factura">
                                                                            <span class="blue">
                                                                                    <i class="ace-icon fa fa-envelope-o bigger-120"></i>
                                                                            </span>
                                                                    </a>
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
                <br/>
                <br/>                    
        </div>
</div>

					</div><!-- /.row -->
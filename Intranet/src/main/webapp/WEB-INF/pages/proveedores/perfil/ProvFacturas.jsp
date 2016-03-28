<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- #section:settings.box -->
<div class="page-content">  	
<div class="page-header">
    
        <h1>
        Facturas de Compra
        
    </h1>
      
</div><!-- /.page-header -->

<div class="row">
    <div class="col-xs-12">
        
        <div class="clearfix">
            <div class="pull-right tableTools-container2"></div>
        </div>
        <div class="table-header" STYLE="background-color:#8C94C6">
                Facturas
        </div>

        <!-- div.table-responsive -->

        <!-- div.dataTables_borderWrap -->
        <div class="table-responsive">
            <table id="dynamic-table2" class="table table-striped table-bordered table-hover table-condensed">
                <thead>
                    <tr>
                        <th>NUM</th>
                        <th>FECHA FACTURA</th>
                        <th>PROVEEDOR</th>
                        <th>REFERENCIA</th>
                        <th>TOTAL</th>							
                        <th>PENDIENTE</th>														
                        <th>ESTADO DE PAGO</th>
                        <th>Rect.</th>
                        <th></th>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach items="${compraListbox}" var="item">
                        <tr>

                                <td>
                                     <c:out value="${item.num}" />
                                </td>
                                <td>
                                     <c:out value="${item.fecha}" />
                                </td>
                                <td><c:out value="${item.proveeedor_id.id}" /> <c:out value="${item.proveeedor_id.nombre}" />, <c:out value="${item.proveeedor_id.persona_contacto}" /></td>
                                <td><c:out value="${item.referencia}" /></td>
                                <td><c:out value="${item.total}" /></td>
                                <td></td>
                                <td><c:out value="${item.estado}" /></td>
                                <td><c:out value="${item.retificativo}" /></td>
                                <td>
                                        <a class="blue tooltip-info" data-rel="tooltip"  href="/Intranet/prov/PverFacturaCompraPdf.htm?id=${item.num}" title="Ver Factura">
                                                    <i class="ace-icon fa fa fa-search-plus bigger-130"></i>
                                            </a> 
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
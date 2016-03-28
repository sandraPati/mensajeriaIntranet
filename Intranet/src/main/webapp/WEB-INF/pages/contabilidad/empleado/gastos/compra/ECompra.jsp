<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- #section:settings.box -->
<div class="page-content">  	
<div class="page-header">
    <div class="row">
        <div class="col-lg-8">
        <h1>
        Facturas de Compra
        <br/>
        <small>
                <i class="ace-icon fa fa-angle-double-right"></i>
                Crea aqui tus facturas de compras
        </small>
    </h1>
        </div>
         <div class="col-lg-4 align-right">
            <a class=" btn btn-sm btn-success" href="/Intranet/emp/EFacturaCompra.htm" data-rel="tooltip">
                Crear Factura de Compra
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
                        <th>PROVEEDOR</th>
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
                                    <c:if test="${item.estado==0}">
                                        <a id="factPagada" name="factP" class="orange tooltip-warning" data-rel="tooltip"  href="/Intranet/emp/EFacturaPagada.htm?id=${item.num}" title="Factura Pagada">
                                            <i class="ace-icon fa fa-square-o bigger-130"></i>
                                        </a>
                                    </c:if>
                                    <c:if test="${item.estado==1}">
                                        <a class="green tooltip-success" data-rel="tooltip"  href="/Intranet/emp/EFacturaPendiente.htm?id=${item.num}" title="Factura Pendiente">
                                            <i class="ace-icon fa fa-check-square-o bigger-130"></i>
                                        </a>
                                    </c:if>
                                </td>
                                <td>
                                        
                                            
                                             <a class="green tooltip-success" data-rel="tooltip"  href="/Intranet/emp/EupdateFC.htm?id=${item.num}" title="Actualizar">
                                                            <i class="ace-icon fa fa-pencil bigger-130"></i>
                                            </a>

                                            <a class="red tooltip-error" data-rel="tooltip"  href="/Intranet/emp/EdeleteFacturaCompra.htm?id=${item.num}" title="Eliminar">
                                                    <i class="ace-icon fa fa-trash-o bigger-130"></i>
                                            </a> 
                                            <a class="blue tooltip-info" data-rel="tooltip"  href="/Intranet/emp/EverFacturaCompraPdf.htm?id=${item.num}" title="Ver Factura">
                                                    <i class="ace-icon fa fa-search-plus bigger-130"></i>
                                            </a> 
                                                    <button id="descuento" value="${item.num} "class="descuento btn btn-yellow btn-xs">
                                                        <i class="ace-icon  glyphicon glyphicon-picture bigger-50"></i>
                                                        <span class="bigger-110 no-text-shadow"></span>
                                                </button>
                                            <a class="orange tooltip-warning" data-rel="tooltip"  href="/Intranet/emp/EupdateFacturaCompraRF.htm?id=${item.num}" title="Actualizar_Foto_Factura">
                                                    <i class="ace-icon glyphicon glyphicon-picture bigger-130"></i>
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


<div id="myModalDescuento" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Factura</h4>
      </div>
       
      
      <div class="modal-body">
         
          
         <div class="form-group">
                <label class="control-label col-xs-12 col-sm-3 no-padding-right" for="name"></label>

                <div class="col-xs-12 col-sm-9">
                        <div class="clearfix" >
                           <img id="avatar" class="editable img-responsive" width="300px" height="300px" onclick="javascript:this.width=1000;this.height=1500" ondblclick="javascript:this.width=300;this.height=300" alt="" src="" />
                        </div>
                </div>
        </div>
          
              <label></label>
              
       
      </div>
         

     
    </div>

  </div>
</div>
					</div><!-- /.row -->
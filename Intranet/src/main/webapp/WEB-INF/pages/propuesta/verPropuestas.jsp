<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- #section:settings.box -->
						
<div class="page-content"> 
<div class="page-header">
    <div class="row">
        <div class="col-lg-8">
        <h1>
               Propuestas Por Cliente:
                <small>
                    <i class="ace-icon fa fa-angle-double-right"></i>
                   ${cliente.nif} ${cliente.nombre} ${cliente.apellidos} 
                </small>
        </h1>
        </div>
         <div class="col-lg-4 align-right">
            <a class=" btn btn-white btn-success" href="/Intranet/sup/NuevaPropuestaAdd.htm?cli=${cliente.nif}" data-rel="tooltip">
                Agregar
            </a>
            <a class=" btn btn-white btn-warning" href="/Intranet/sup/SLtaClientesPropuesta.htm" data-rel="tooltip">
                <i class="ace-icon fa fa-reply icon-only"></i>

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
    <c:if test="${empty ltaPropuestas}">
        <div class="alert alert-warning">
            <button type="button" class="close" data-dismiss="alert">
                    <i class="ace-icon fa fa-times"></i>
            </button>

            <strong>
                    <i class="ace-icon fa fa-times"></i>
                    
            </strong>

            Este cliente no tiene ninguna propuesta registrada!
            <br />
        </div>
        
    </c:if>
<c:if test="${not empty ltaPropuestas}">
<div class="row">
    <div class="col-xs-12">
        
        <div class="clearfix">
            <div class="pull-right tableTools-container"></div>
        </div>
        
        <div class="table-header" STYLE="background-color:#8C94C6">
                Lista de Propuestas
        </div>

        <!-- div.table-responsive -->

        <!-- div.dataTables_borderWrap -->
        <div class="table-responsive">
            <table id="dynamic-table" class="table table-striped table-bordered table-hover table-condensed">
                <thead>
                    <tr>

                        <th>DESCRIPCION</th>
                        <th>EMPLEADO</th>
                        <th>DIA</th>
                        <th>HORA</th>
                        <th>CLIENTE</th>							
                        <th>DIRECCION</th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                    <tbody>
                        <c:forEach items="${ltaPropuestas}" var="item">
                            <tr>


                                    <td>
                                         <c:out value="${item.descipcion}" />
                                    </td>
                                    <td><c:out value="${item.empleado_nif.nif}" /> <c:out value="${item.empleado_nif.apellidos}" />, <c:out value="${item.empleado_nif.nombre}" /></td>
                                    <td><c:out value="${item.dia}" /></td>
                                    <td><c:out value="${item.hora}" /></td>
                                    <td><c:out value="${item.cliente_nif.nif}" /> <c:out value="${item.cliente_nif.apellidos}" />, <c:out value="${item.cliente_nif.nombre}" /></td>
                                    <td><c:out value="${item.direccion}" /></td>

                                    <td>
                                            <div class="hidden-sm hidden-xs action-buttons">
                                                <a class="green tooltip-success" data-rel="tooltip" href="/Intranet/sup/updatePropuesta.htm?idP=${item.id}" title="Actualizar">
                                                   <i class="ace-icon fa fa-pencil bigger-130"></i>
                                                </a>
                                                <a class="blue tooltip-info" data-rel="tooltip" href="/Intranet/sup/consultarPropuesta.htm?idP=${item.id}" title="Consultar">
                                                   <i class="ace-icon fa fa-search-plus bigger-130"></i>
                                                </a>    
                                                <a class="orange tooltip-warning" data-rel="tooltip" href="/Intranet/sup/Presupuesto.htm?idP=${item.id}" title="Presupuesto">
                                                   <i class="ace-icon glyphicon glyphicon-list-alt bigger-130"></i>
                                                </a>
                                                   <button id="descuento" value="${item.id} "class="descuento btn btn-xs btn-warning">
                                                        <i class="ace-icon fa fa-fire bigger-50"></i>
                                                        <span class="bigger-110 no-text-shadow"></span>
                                                </button>



                                            </div>

                                            <div class="hidden-md hidden-lg">
                                                    <div class="inline pos-rel">
                                                            <button class="btn btn-minier btn-yellow dropdown-toggle" data-toggle="dropdown" data-position="auto">
                                                                    <i class="ace-icon fa fa-caret-down icon-only bigger-120"></i>
                                                            </button>

                                                            <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
                                                                    <li>
                                                                            <a href="/Intranet/sup/updatePropuesta.htm?idP=${item.id}" class="tooltip-success" data-rel="tooltip" title="Actualizar">
                                                                                    <span class="green">
                                                                                            <i class="ace-icon fa fa-pencil bigger-120"></i>
                                                                                    </span>
                                                                            </a>

                                                                    </li>
                                                                    <li>
                                                                            <a href="/Intranet/sup/consultarPropuesta.htm?idP=${item.id}" class="tooltip-info" data-rel="tooltip" title="Consultar">
                                                                                    <span class="blue">
                                                                                            <i class="ace-icon fa fa-search-plus bigger-120"></i>
                                                                                    </span>
                                                                            </a>

                                                                    </li>
                                                                    <li>
                                                                            <a href="/Intranet/sup/Presupuesto.htm?idP=${item.id}" class="tooltip-warning" data-rel="tooltip" title="Presupuesto">
                                                                                    <span class="orange">
                                                                                            <i class="ace-icon glyphicon glyphicon-list-alt bigger-120"></i>
                                                                                    </span>
                                                                            </a>
                                                                    </li>
                                                                   

                                                            </ul>
                                                    </div>
                                            </div>
                                    </td>
                                     <td>
                                            <div class="hidden-sm hidden-xs action-buttons">
                                                  
                                                <a class="green tooltip-success" data-rel="tooltip" href="/Intranet/sup/contratarPresupuesto.htm?idP=${item.id}" title="Contratar">
                                                   <i class="ace-icon glyphicon glyphicon-tags bigger-130"></i>
                                                </a>    
                                                <a class="blue tooltip-info" data-rel="tooltip" href="/Intranet/sup/enviarPresupuesto.htm?idP=${item.id}" title="Enviar Presupuesto">
                                                   <i class="ace-icon fa fa-envelope-o bigger-130"></i>
                                                </a>    
                                                <a class="grey " data-rel="tooltip" href="/Intranet/sup/verPresupuestoPdf.htm?idP=${item.id}" title="Ver Presupuesto">
                                                   <i class="ace-icon fa fa-eye bigger-130"></i>
                                                </a>    
                                                <c:if test="${item.descuentoproveedor>0}">
                                                   <a class="grey " data-rel="tooltip" href="/Intranet/sup/verPresupuestoDescuentoPdf.htm?idP=${item.id}" title="Ver Presupuesto Descuento">
                                                   <i class="ace-icon fa fa-eye bigger-130"></i>
                                                </a> 
                                                   </c:if>
                                            </div>

                                            <div class="hidden-md hidden-lg">
                                                    <div class="inline pos-rel">
                                                            <button class="btn btn-minier btn-yellow dropdown-toggle" data-toggle="dropdown" data-position="auto">
                                                                    <i class="ace-icon fa fa-caret-down icon-only bigger-120"></i>
                                                            </button>

                                                            <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
                                                                    
                                                                    <li>
                                                                            <a href="/Intranet/sup/contratarPresupuesto.htm?idP=${item.id}" class="tooltip-success" data-rel="tooltip" title="Contratar">
                                                                                    <span class="green">
                                                                                            <i class="ace-icon glyphicon glyphicon-tags bigger-120"></i>
                                                                                    </span>
                                                                            </a>
                                                                    </li>
                                                                    <li>
                                                                            <a href="/Intranet/sup/enviarPresupuesto.htm?idP=${item.id}" class="tooltip-info" data-rel="tooltip" title="Enviar_Presupuesto">
                                                                                    <span class="blue">
                                                                                            <i class="ace-icon fa fa-envelope-o bigger-120"></i>
                                                                                    </span>
                                                                            </a>
                                                                    </li>
                                                                    <li>
                                                                            <a href="/Intranet/sup/verPresupuestoPdf.htm?idP=${item.id}" class="" data-rel="tooltip" title="Ver_Presupuesto">
                                                                                    <span class="grey">
                                                                                            <i class="ace-icon fa fa-eye bigger-120"></i>
                                                                                    </span>
                                                                            </a>
                                                                    </li>
                                                                    <c:if test="${item.descuentoproveedor>0}">
                                                                    <li>
                                                                            <a href="/Intranet/sup/verPresupuestoDescuentoPdf.htm?idP=${item.id}" class="" data-rel="tooltip" title="Ver_Presupuesto_Descuento">
                                                                                    <span class="grey">
                                                                                            <i class="ace-icon fa fa-eye bigger-120"></i>
                                                                                    </span>
                                                                            </a>
                                                                    </li>
                                                                    </c:if>
                                                            </ul>
                                                    </div>
                                            </div>
                                    </td>
                                    <td>
                                        <c:if test="${item.tienePresupuesto==0}">
                                            <c:if test="${item.plantilla==0}">
                                                <c:if test="${existePlantilla>0}">
                                                    <c:forEach items="${ltaPlantillas}" var="item2">
                                                        <a class="orange tooltip-warning" data-rel="tooltip" href="/Intranet/sup/AsignarPlantilla.htm?nifC=${cliente.nif}&idPlan=${item2.id}&idP=${item.id}" title="${item2.descripcion}">
                                                            <i class="ace-icon fa  fa-circle-o bigger-130"></i>${item2.descripcion}
                                                         </a> 
                                                    </c:forEach>
                                                </c:if>
                                            </c:if>
                                        </c:if>
                                        <c:if test="${item.tienePresupuesto==1}">
                                            -
                                        </c:if>
                                    </td>
                                    <td>
                                        <c:if test="${item.plantilla==0}">
                                            <c:if test="${item.tienePresupuesto==1}">
                                                <input type="checkbox" name="plantilla" id="plantilla" value="${item.id}" class="chk" >
                                                   
                                            </c:if>            
                                        </c:if>
                                        <c:if test="${item.plantilla>0}">
                                            <input type="checkbox" name="plantilla" id="plantilla" value="${item.id}" class="chk" checked="true" >
                                            Plantilla: ${item.objplantilla.descripcion}
                                        </c:if>
                                    </td>
                                    <td>
                                        <c:if test="${item.estado==1}">
                                            <a class="green tooltip-success" data-rel="tooltip" href="/Intranet/sup/ActivarPresupuesto.htm?idP=${item.id}" title="Activar">
                                                <i class="ace-icon glyphicon glyphicon-ok bigger-130"></i>
                                             </a>
                                             <a class="red tooltip-error" data-rel="tooltip" href="/Intranet/sup/RechazarPresupuesto.htm?idP=${item.id}" title="Rechazar">
                                                <i class="ace-icon glyphicon glyphicon-remove bigger-130"></i>
                                             </a>
                                        </c:if>
                                        <c:if test="${item.estado==3}">
                                            <a class="green tooltip-success" data-rel="tooltip" href="/Intranet/sup/ActivarPresupuesto.htm?idP=${item.id}" title="Rechazado_Volver_Activar">
                                                <i class="ace-icon glyphicon glyphicon-ok bigger-130"></i>
                                             </a> 
                                           
                                        </c:if>
                                        <c:if test="${item.estado==4}">
                                            
                                         <a class="red tooltip-error" data-rel="tooltip" href="/Intranet/sup/RechazarPresupuesto.htm?idP=${item.id}" title="Activo_opcion_Rechazar">
                                           <i class="ace-icon glyphicon glyphicon-remove bigger-130"></i>
                                        </a>  
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
</c:if>




<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Guardar Plantilla</h4>
      </div>
       
      <form class="form-horizontal "  method="post"id="form1">
      <div class="modal-body">
          <input type="hidden" id="propuesta_id" />
          
         <div class="form-group">
                <label class="control-label col-xs-12 col-sm-3 no-padding-right" for="name">Descripcion:</label>

                <div class="col-xs-12 col-sm-9">
                        <div class="clearfix">
                                <input type="text" id="descripcion" name="descripcion" class="col-xs-12 col-sm-5" />
                        </div>
                </div>
        </div>

              <label></label>
              
       
      </div>
         

      <div class="modal-footer">
        
        <button type="button" class="btn btn-default" id="btn_cancel">Cancelar</button>
        <button type="button" class="btn btn-info" id="btn_enviar"><i class="ace-icon fa fa-check"></i> Ok</button>
      </div>
      </form>
    </div>

  </div>
</div>
<div id="myModalDescuento" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Descuento Proveedor %</h4>
      </div>
       
      <form class="form-horizontal "  method="post"id="formD">
      <div class="modal-body">
          <input type="hidden" id="propuesta_idD" />
          
         <div class="form-group">
                <label class="control-label col-xs-12 col-sm-3 no-padding-right" for="name">Descuento % </label>

                <div class="col-xs-12 col-sm-9">
                        <div class="clearfix">
                                <input type="text" id="descuentop" name="descuentop" class="col-xs-12 col-sm-5" />
                        </div>
                </div>
        </div>
          
              <label></label>
              
       
      </div>
         

      <div class="modal-footer">
        
        <button type="button" class="btn btn-default" id="btn_cancel">Cancelar</button>
        <button type="button" class="btn btn-info" id="btn_enviarD"><i class="ace-icon fa fa-check"></i> Ok</button>
      </div>
      </form>
    </div>

  </div>
</div>

					</div><!-- /.row -->
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- #section:settings.box -->
						
<div class="page-content"> 
<div class="page-header">
    <div class="row">
        <div class="col-lg-8">
        <h1>
               Propuesta: 
                <small>
                    <i class="ace-icon fa fa-angle-double-right"></i>
                   ${prop.descipcion}
                </small>
        </h1>
        </div>
         <div class="col-lg-4 align-right">
            
            <a class=" btn btn-white btn-warning" href="/Intranet/sup/verPropuestas.htm?nifC=${prop.cliente_nif.nif}" data-rel="tooltip">
                <i class="ace-icon fa fa-reply icon-only"></i>

            </a>
        </div>
        
             
             
    </div>
</div><!-- /.page-header -->

<br/>


<div class="page-header">
    <div class="row">
        <div class="col-lg-8">
        <h1>
               Presupuestos de Propuesta
                <small>
                    <i class="ace-icon fa fa-angle-double-right"></i>
                   
                </small>
        </h1>
        </div>
         <div class="col-lg-4 align-right">
             <c:if test="${presuProp==false}">
            <a class=" btn btn-white btn-warning" href="/Intranet/sup/addPresupuesto.htm?idP=${prop.id}" data-rel="tooltip">
                <i class="ace-icon glyphicon glyphicon-list-alt bigger-120"></i>Agregar
            </a>
                </c:if>
             <c:if test="${presuProp==true}">
            <a class=" btn btn-white btn-warning" href="/Intranet/sup/addPresupuesto.htm?idP=${prop.id}" data-rel="tooltip">
                <i class="ace-icon glyphicon glyphicon-list-alt bigger-120"></i>Actualizar
            </a>
                </c:if>
        </div>
             
             
    </div>
</div><!-- /.page-header -->
<div class="row">
    <div class="col-xs-12">
        <c:if test="${not empty result}">
            <div class="alert alert-block alert-danger">
            <button type="button" class="close" data-dismiss="alert">
                    <i class="ace-icon fa fa-times"></i>
            </button>

            <strong>
                    <i class="ace-icon fa fa-check"></i>
                    
            </strong>

            ${result}
            <br />
        </div>
        </c:if>
    </div>
    
             
    <div class="col-xs-12">
        
        <div class="clearfix">
            <div class="pull-right tableTools-container2"></div>
        </div>
        
        <div class="table-header" STYLE="background-color:#8C94C6">
                Lista de Capitulos
        </div>

        <!-- div.table-responsive -->

        <!-- div.dataTables_borderWrap -->
        <div class="table-responsive">
            <table id="dynamic-table2" class="table table-striped table-bordered table-hover table-condensed">
                <thead>
                    <tr>
                        
                        <th>COD</th>
                        <th>NOMBRE</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>

                    <tbody>
                        <c:forEach items="${ltaCapitulos}" var="item">
                            <tr>


                                    
                                    <td>
                                        <c:out value="${item.cap.cod}" />
                                    </td>
                                    <td>
                                        <c:out value="${item.cap.nombre}" /> 
                                    </td>
                                    <td>
                                        <a class="blue tooltip-info" data-rel="tooltip" href="/Intranet/sup/verPresupuesto.htm?idPres=${item.id}&idP=${prop.id}" title="Ver_Presupuesto"><i class="ace-icon fa  fa-pencil-square-o bigger-130"></i></a>
                                        <a class="red tooltip-error" data-rel="tooltip" href="/Intranet/sup/deletePresupuestoGCap.htm?idPres=${item.id}&idP=${prop.id}" title="Eliminar">
                                                    <i class="ace-icon fa fa-trash-o bigger-130"></i>
                                                </a> 
                                    </td>
                                    <td>
                                        <c:if test="${listaGuradada==item.id}">
                                            
                                            <p class="green"><b>Lista de Panos GUARDADO</b></p>

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
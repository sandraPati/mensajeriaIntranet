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
                   ${prop.descipcion} del CLIENTE: ${prop.cliente_nif.nif} ${prop.cliente_nif.apellidos}, ${prop.cliente_nif.nombre}
                </small>
        </h1>
        </div>
         <div class="col-lg-4 align-right">
           
            <a class=" btn btn-white btn-warning" href="/Intranet/sup/PlanObraC.htm?idPres=${idPres}" data-rel="tooltip">
            <i class="ace-icon fa fa-reply icon-only "></i>

        </a>
        </div>
        
             
             
    </div>
</div><!-- /.page-header -->

<br/>


<div class="page-header">
   <div class="row">
        <div class="col-lg-8">
            <h1>
               Certificaciones
                <small>
                    
                    <i class="ace-icon fa fa-angle-double-right"></i>
                  
                </small>
            </h1>
        </div>
         <div class="col-lg-4 align-right">
           
            <a class=" btn btn-white btn-warning" href="/Intranet/sup/addCertificacion.htm?idPP=${idPP}" data-rel="tooltip">
            Insertar Certificacion

        </a>
        </div>
        
             
             
    </div>
</div><!-- /.page-header -->
<div class="row">
        <div class="col-lg-12">
            <h1>
               
                <small>
                    
                    <i class="ace-icon fa fa-angle-double-right"></i> Valor Llenado: ${valorllenado}
                  
                </small>
            </h1>
            
        </div>
</div>
<div class="row">
    <div class="col-xs-12">
        
        <div class="clearfix">
            <div class="pull-right tableTools-container2"></div>
        </div>
        
        <div class="table-header" STYLE="background-color:#8C94C6">
                Lista de Plan de Obra
        </div>

        <!-- div.table-responsive -->

        <!-- div.dataTables_borderWrap -->
        <div class="table-responsive">
            <table id="dynamic-table2" class="table table-striped table-bordered table-hover table-condensed">
                <thead>
                    <tr>

                        <th>SEMANA</th>
                        <th>FECHA</th>
                        <th>PORCENTAJE TERMINADO</th>
                        <th>MONTO</th>
                        <th></th>
                        
                    </tr>
                </thead>

                    <tbody>
                        <c:forEach items="${listapryCert}" var="item">
                            <tr>


                                    <td>
                                         <c:out value="${item.numsemana}" /> 
                                    </td>
                                    <td><c:out value="${item.fecha}" /> </td>
                                    <td><c:out value="${item.porcentaje_terminado}" /> </td>
                                    <td><c:out value="${item.monto_semana}" /> </td>
                                    <td>
                                            <div class="hidden-sm hidden-xs action-buttons">
                                                <a class="blue tooltip-info" data-rel="tooltip" href="/Intranet/sup/Certificaciones_galeria.htm?idC=${item.id}" title="Certificaciones_galeria">
                                                            <i class="ace-icon fa fa-search-plus bigger-130"></i>
                                                </a> 
                                                <a class="red tooltip-error" data-rel="tooltip" href="/Intranet/sup/deleteCertificacion.htm?idCert=${item.id}" title="Eliminar">
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
                                                                            <a href="/Intranet/sup/Certificaciones_galeria.htm?idC=${item.id}" class="tooltip-info" data-rel="tooltip" title="Certificaciones_galeria">
                                                                                    <span class="blue">
                                                                                            <i class="ace-icon fa fa-search-plus bigger-120"></i>
                                                                                    </span>
                                                                            </a>

                                                                    </li>   
                                                                <li>
                                                                            <a href="/Intranet/sup/deleteCertificacion.htm?idCert=${item.id}" class="tooltip-error" data-rel="tooltip" title="Eliminar">
                                                                                    <span class="red">
                                                                                            <i class="ace-icon fa fa-trash-o bigger-120"></i>
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
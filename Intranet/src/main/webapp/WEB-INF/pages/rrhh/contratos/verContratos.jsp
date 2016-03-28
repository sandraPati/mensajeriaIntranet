<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- #section:settings.box -->
						
<div class="page-content">
<div class="page-header">
    <div class="row">
        <div class="col-lg-8">
        <h1>
               Contratos de 
                <small>
                    <i class="ace-icon fa fa-angle-double-right"></i>
                    ${empleado.nif} ${empleado.nombre} ${empleado.apellidos}
                </small>
        </h1>
        </div>
         <div class="col-lg-4 align-right">
            <a class=" btn btn-white btn-success" href="/Intranet/sup/addContrato.htm?nif=${empleado.nif}" data-rel="tooltip">
                Agregar
            </a>
            
        </div>
             
             
    </div>
</div><!-- /.page-header -->

<div class="row">
    <div class="col-xs-12">
        
        <div class="clearfix">
            <div class="pull-right tableTools-container2"></div>
        </div>
        
        <div class="table-header" STYLE="background-color:#3FBC63">
                Lista de Contratos
        </div>

        <!-- div.table-responsive -->

        <!-- div.dataTables_borderWrap -->
        <div class="table-responsive">
            <table id="dynamic-table2" class="table table-striped table-bordered table-hover table-condensed">
                <thead>
                    <tr>

                        <th>CATEGORIA PROFESIONAL</th>
                        <th>NIVEL PROFESIONAL</th>
                        <th class="hidden-480">TIPO CONTRATO</th>
                        <th>															
                                JORNADA
                        </th>
                        <th class="hidden-480">NUMERO DE HORAS</th>							
                        <th><i class="ace-icon fa fa-clock-o bigger-110 hidden-480"></i>DURACION DE CONTRATO DESDE</th>														
                        <th><i class="ace-icon fa fa-clock-o bigger-110 hidden-480"></i>DURACION DE CONTRATO HASTA</th>
                        <th>TIEMPO / RANGO</th>
                        <th>RETRIBUCION TOTAL</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>

                                                                            <tbody>
                                                                                <c:forEach items="${ltacont}" var="item">
                                                                                    <tr>
                                                                                            

                                                                                            <td>
                                                                                                 <c:out value="${item.categoria_profesional}" />
                                                                                            </td>
                                                                                            <td><c:out value="${item.nivel_profesional}" /></td>
                                                                                            <td class="hidden-480"><c:out value="${item.id_tipo_contrato.nombre}" /></td>
                                                                                            <td><c:out value="${item.jornada}" /></td>
                                                                                            <td class="hidden-480"><c:out value="${item.num_horas}" /></td>
                                                                                            
                                                                                            <td><c:out value="${item.duracion_contrato_desde}" /></td>
                                                                                            <td><c:out value="${item.duracion_contrato_hasta}" /></td>
                                                                                            <td><c:out value="${item.tiempo_rango}" /></td>
                                                                                            <td class="hidden-480"><c:out value="${item.retribucion_total}" /></td>

                                                                                            <td>
                                                                                                    <div class="hidden-sm hidden-xs action-buttons">
                                                                                                        <a class="blue tooltip-info" data-rel="tooltip" href="/Intranet/sup/verNominas.htm?nif=${item.nif_empleado.nif}&idC=${item.id}" title="Ver Nominas">
                                                                                                                    <i class="ace-icon fa fa-search-plus bigger-130"></i>
                                                                                                            </a>    
                                                                                                       

                                                                                                        <a class="green tooltip-success" href="/Intranet/sup/updateContrato.htm?idC=${item.id}" data-rel="tooltip"  title="Actualizar Contrato">
                                                                                                                <i class="ace-icon fa fa-pencil bigger-130"></i>
                                                                                                        </a>
                                                                                                        <a class="red tooltip-error" href="/Intranet/sup/deleteContrato.htm?nif=${item.nif_empleado.nif}&idC=${item.id}" data-rel="tooltip"  title="Eliminar Contrato">
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
                                                                                                                                    <a href="/Intranet/sup/verNominas.htm?nif=${item.nif_empleado.nif}&idC=${item.id}" class="tooltip-info" data-rel="tooltip" title="Ver Nominas">
                                                                                                                                            <span class="blue">
                                                                                                                                                    <i class="ace-icon fa fa-search-plus bigger-120"></i>
                                                                                                                                            </span>
                                                                                                                                    </a>
                                                                                                                                            
                                                                                                                            </li>

                                                                                                                           
                                                                                                                            <li>
                                                                                                                                    <a href="/Intranet/sup/updateContrato.htm?idC=${item.id}" class="tooltip-success" data-rel="tooltip" title="Actualizar Contrato">
                                                                                                                                            <span class="green">
                                                                                                                                                    <i class="ace-icon fa fa-pencil bigger-120"></i>
                                                                                                                                            </span>
                                                                                                                                    </a>
                                                                                                                            </li>

                                                                                                                            <li>
                                                                                                                                    <a href="/Intranet/sup/deleteContrato.htm?nif=${item.nif_empleado.nif}&idC=${item.id}" class="tooltip-error" data-rel="tooltip" title="Eliminar Contrato">
                                                                                                                                            <span class="red">
                                                                                                                                                    <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                                                                                                                            </span>
                                                                                                                                    </a>
                                                                                                                            </li>
                                                                                                                           
                                                                                                                    </ul>
                                                                                                            </div>
                                                                                                    </div>
                                                                                            </td>
                                                                                            <td>
                                                                                                <div class="hidden-sm hidden-xs action-buttons">
                                                                                                    <a class="blue tooltip-info"  href="/Intranet/sup/verContratoConfidencial.htm?nif=${item.nif_empleado.nif}&idC=${item.id}" >
                                                                                                        Contrato Confidencial
                                                                                                    </a>
                                                                                                    <a class="blue tooltip-info" href="/Intranet/sup/verContratoC.htm?nif=${item.nif_empleado.nif}&idC=${item.id}" >
                                                                                                        Contrato
                                                                                                    </a>    
                                                                                                           

                                                                                                    </div>
                                                                                                        
                                                                                                    <div class="hidden-md hidden-lg">
                                                                                                            <div class="inline pos-rel">
                                                                                                                    <button class="btn btn-minier btn-yellow dropdown-toggle" data-toggle="dropdown" data-position="auto">
                                                                                                                            <i class="ace-icon fa fa-caret-down icon-only bigger-120"></i>
                                                                                                                    </button>

                                                                                                                    <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
                                                                                                                            
                                                                                                                            <li>
                                                                                                                                    <a href="/Intranet/sup/verContratoConfidencial.htm?nif=${item.nif_empleado.nif}&idC=${item.id}" >Contrato Confidencial</a>
                                                                                                                            </li>
                                                                                                                            <li>
                                                                                                                                    <a href="/Intranet/sup/verContratoC.htm?nif=${item.nif_empleado.nif}&idC=${item.id}" >Contrato</a>
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
</div>
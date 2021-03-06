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
           
            <a class=" btn btn-white btn-warning" href="/Intranet/sup/PlanObra.htm?idPres=${idPres}" data-rel="tooltip">
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
               Presupuestos del Capitulo:
                <small>
                    <i class="ace-icon fa fa-angle-double-right"></i>
                   ${cap.cod} ${cap.nombre}
                </small>
        </h1>
       </div>
         <div class="col-lg-4 align-right">
           
            <a class=" btn btn-white btn-warning" href="/Intranet/sup/addPlanObraEmpleados.htm?idPP=${idPP}" data-rel="tooltip">
                Asignar Empleado
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
                Lista de Empleados Asignados
        </div>

        <!-- div.table-responsive -->

        <!-- div.dataTables_borderWrap -->
        <div class="table-responsive">
            <table id="dynamic-table2" class="table table-striped table-bordered table-hover table-condensed">
                <thead>
                    <tr>

                        <th>EMPLEADOO</th>
                        <th>DESCRIPCION</th>
                        <th>DESDE</th>
                        <th>HASTA</th>
                        <th>N� Horas</th>
                        <th></th>
                        
                    </tr>
                </thead>

                    <tbody>
                        <c:forEach items="${proyempledosLista}" var="item">
                            <tr>


                                    <td>
                                         <c:out value="${item.nif_empleado.nif}" /> <c:out value="${item.nif_empleado.apellidos}" />, <c:out value="${item.nif_empleado.nombre}" /> 
                                    </td>
                                    <td><c:out value="${item.descripcion}" /> </td>
                                    <td><c:out value="${item.finicio}" /> </td>
                                    <td><c:out value="${item.ffin}" /> </td>
                                    <td><c:out value="${item.numhoras}" /> </td>
                                    <td>
                                            <div class="hidden-sm hidden-xs action-buttons">
                                                <a class="green tooltip-success" data-rel="tooltip" href="/Intranet/sup/updatePlanObraEmpleado.htm?idPT=${item.id}" title="Actualizar">
                                                            <i class="ace-icon fa fa-pencil bigger-130"></i>
                                                    </a>

                                                    <a class="red tooltip-error" data-rel="tooltip" href="/Intranet/sup/deletePlanObraEmpleado.htm?idPT=${item.id}" title="Eliminar">
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
                                                                            <a href="/Intranet/sup/updatePlanObraEmpleado.htm?idPT=${item.id}" class="tooltip-success" data-rel="tooltip" title="Actualizar">
                                                                                    <span class="green">
                                                                                            <i class="ace-icon fa fa-pencil-square-o bigger-120"></i>
                                                                                    </span>
                                                                            </a>
                                                                    </li>

                                                                    <li>
                                                                            <a href="/Intranet/sup/deletePlanObraEmpleado.htm?idPT=${item.id}" class="tooltip-error" data-rel="tooltip" title="Eliminar">
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
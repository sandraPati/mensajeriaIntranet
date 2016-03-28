<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- #section:settings.box -->
<div class="page-content">  	
<div class="page-header">
    <div class="row">
        <div class="col-lg-8">
        <h1>
               Lista de Proyectos de :
                <small>
                        <i class="ace-icon fa fa-angle-double-right"></i>
                       ${cli.nif} ${cli.apellidos}, ${cli.nombre}
                </small>
        </h1>
        </div>
         <div class="col-lg-4 align-right">
           
            
            <a class=" btn btn-white btn-warning" href="/Intranet/sup/verPlanObraAgendaEmpleados.htm" data-rel="tooltip">
               <i class="ace-icon fa fa-reply icon-only"></i>
            </a>
        </div>
        
             
             
    </div>
</div><!-- /.page-header -->

                            <!-- /section:settings.box -->
                            <br/>
                            <div class="row">
                    <div class="col-xs-12">
                        <c:if test="${not empty mensaje}">
                            <div class="msg">${mensaje}</div>
                        </c:if>

                            <div class="clearfix">
                                    <div class="pull-right tableTools-container1"></div>
                            </div>
                            <div class="table-header" STYLE="background-color:#8C94C6">
                                    Lista de Propuestas
                            </div>

                            <!-- div.table-responsive -->

                            <!-- div.dataTables_borderWrap -->
                            <div class="table-responsive">

                                    <table id="dynamic-table1" class="table table-striped table-bordered table-hover table-condensed">
                                            <thead>
                                                    <tr>

                                                            <th>DESCRIPCION</th>
                                                            <th>EMPLEADO</th>
                                                            <th>DIA</th>                                                                                            
                                                            <th>HORA</th>
                                                            <th>CLIENTE</th>
                                                            <th>DIRECCION</th>
                                                            <th>PAIS</th>
                                                            <th>PROVINCIA</th>
                                                            <th>POBLACION</th>
                                                            <th></th>
                                                    </tr>
                                            </thead>

                                            <tbody>

                                                <c:forEach items="${empleadoListbox}" var="item">
                                                    <tr>


                                                            <td>
                                                                <c:out value="${item.descipcion}" />
                                                            </td>
                                                            <td><c:out value="${item.empleado_nif.nif}" /> <c:out value="${item.empleado_nif.apellidos}" />, <c:out value="${item.empleado_nif.nombre}" /></td>
                                                            <td><c:out value="${item.dia}" /></td>

                                                            <td><c:out value="${item.hora}" /></td>
                                                            <td><c:out value="${item.cliente_nif.nif}" /> <c:out value="${item.cliente_nif.apellidos}" />, <c:out value="${item.cliente_nif.nombre}" /></td>
                                                            <td><c:out value="${item.direccion}" /></td>
                                                            <td><c:out value="${item.pais}" /></td>
                                                            <td><c:out value="${item.provincia}" /></td>
                                                            <td><c:out value="${item.poblacion}" /></td>

                                                            <td>
                                                                    <div class="hidden-sm hidden-xs action-buttons">
                                                                            <a class="tooltip-info" data-rel="tooltip" href="/Intranet/sup/PlanObraTareasEmpleado.htm?id=${item.id}" title="Ver Tareas">
                                                                                    <i class="ace-icon fa fa-search-plus bigger-130"></i>
                                                                            </a>


                                                                    </div>

                                                                    <div class="hidden-md hidden-lg">
                                                                            <div class="inline pos-rel">
                                                                                    <button class="btn btn-minier btn-yellow dropdown-toggle" data-toggle="dropdown" data-position="auto">
                                                                                            <i class="ace-icon fa fa-caret-down icon-only bigger-120"></i>
                                                                                    </button>

                                                                                    <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
                                                                                            <li>
                                                                                                    <a href="/Intranet/sup/PlanObraTareasEmpleado.htm?id=${item.id}" class="tooltip-info" data-rel="tooltip" title="Ver Tareas">
                                                                                                            <span class="blue">
                                                                                                                    <i class="ace-icon fa fa-search-plus bigger-120"></i>
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


                    </div>
                            </div>
 
                            
                            
					</div><!-- /.row -->
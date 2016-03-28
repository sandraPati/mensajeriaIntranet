<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- #section:settings.box -->
<div class="page-content">  	
<div class="page-header">
    
        <h1>
               Lista de Empleados
                <small>
                        <i class="ace-icon fa fa-angle-double-right"></i>
                       
                </small>
        </h1>
        
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
                                                                    Lista de Empleados
                                                            </div>

                                                            <!-- div.table-responsive -->

                                                            <!-- div.dataTables_borderWrap -->
                                                            <div class="table-responsive">
                                                                
                                                                    <table id="dynamic-table1" class="table table-striped table-bordered table-hover table-condensed">
                                                                            <thead>
                                                                                    <tr>

                                                                                            <th>NIF</th>
                                                                                            <th>NOMBRE</th>
                                                                                            <th>APELLIDOS</th>                                                                                            
                                                                                            <th>TELEFONO</th>
                                                                                            <th>OTRO TELEFONO</th>
                                                                                            <th>MAIL</th>
                                                                                            <th>OTRO MAIL</th>
                                                                                            <th>PERFIL</th>
                                                                                            <th></th>
                                                                                    </tr>
                                                                            </thead>

                                                                            <tbody>

                                                                                <c:forEach items="${empleadoListbox}" var="item">
                                                                                    <tr>


                                                                                            <td>
                                                                                                <c:out value="${item.nif}" />
                                                                                            </td>
                                                                                            <td><c:out value="${item.nombre}" /></td>
                                                                                            <td><c:out value="${item.apellidos}" /></td>
                                                                                            
                                                                                            <td><c:out value="${item.telefono}" /></td>
                                                                                            <td><c:out value="${item.otro_telefono}" /></td>
                                                                                            <td><c:out value="${item.email}" /></td>
                                                                                            <td><c:out value="${item.otro_email}" /></td>

                                                                                            <td class="hidden-480"><c:out value="${item.id_perfil.nombrep}" /></td>

                                                                                            <td>
                                                                                                    <div class="hidden-sm hidden-xs action-buttons">
                                                                                                            <a class="tooltip-info" data-rel="tooltip" href="/Intranet/sup/TareasEmpleado.htm?nif=${item.nif}" title="Ver Tareas">
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
                                                                                                                                    <a href="/Intranet/sup/TareasEmpleado.htm?nif=${item.nif}" class="tooltip-info" data-rel="tooltip" title="Ver Tareas">
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
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- #section:settings.box -->
						
<div class="page-content">  
<div class="page-header">
    
        <h1>
               Clientes 
                <small>
                    <i class="ace-icon fa fa-angle-double-right"></i>
                   
                </small>
        </h1>
        
</div><!-- /.page-header -->

<div class="row">
    <div class="col-xs-12">
        
        <div class="clearfix">
            <div class="pull-right tableTools-container2"></div>
        </div>
        
        <div class="table-header" STYLE="background-color:#8C94C6">
                Lista de Clientes
        </div>

        <!-- div.table-responsive -->

        <!-- div.dataTables_borderWrap -->
        <div class="table-responsive">
            <table id="dynamic-table2" class="table table-striped table-bordered table-hover table-condensed">
                <thead>
                    <tr>

                        <th>NIF</th>
                        <th>NOMBRE</th>
                        <th>APELLIDOS</th>
                        <th>DIRECCION</th>
                        <th>PAIS</th>							
                        <th>PROVINCIA</th>														
                        <th>POBLACION</th>
                        <th>NACIONALIDAD</th>
                        <th>CODIGO POSTAL</th>
                        <th></th>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach items="${clientesListbox}" var="item">
                        <tr>


                                <td>
                                     <c:out value="${item.nif}" />
                                </td>
                                <td><c:out value="${item.nombre}" /></td>
                                <td><c:out value="${item.apellidos}" /></td>
                                <td><c:out value="${item.direccion}" /></td>
                                <td><c:out value="${item.pais}" /></td>
                                <td><c:out value="${item.provincia}" /></td>
                                <td><c:out value="${item.poblacion}" /></td>
                                <td><c:out value="${item.nacionalidad}" /></td>
                                <td><c:out value="${item.codigo_postal}" /></td>

                                <td>
                                        <div class="hidden-sm hidden-xs action-buttons">
                                            <a class="blue tooltip-info" data-rel="tooltip" href="/Intranet/sup/verPropuestasP.htm?nifC=${item.nif}" title="Ver Proyectos">
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
                                                                        <a href="/Intranet/sup/verPropuestasP.htm?nifC=${item.nif}" class="tooltip-info" data-rel="tooltip" title="Ver Proyectos">
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
                <br/>
                <br/>                    
        </div>
</div>

					</div><!-- /.row -->
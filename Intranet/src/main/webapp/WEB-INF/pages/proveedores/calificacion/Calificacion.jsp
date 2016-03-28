<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- #section:settings.box -->
<div class="page-content">  						

<div class="page-header">
    <div class="row">
        <div class="col-lg-8">  
        <h1>
               Calificaciones
                <small>
                    <i class="ace-icon fa fa-angle-double-right"></i>
                </small>
        </h1>
     </div>
         <div class="col-lg-4 align-right">
            
        </div>
        
             
             
    </div> 
</div><!-- /.page-header -->
<br/>


<div class="row">
    <div class="col-xs-12">
        
        <div class="clearfix">
            <div class="pull-right tableTools-container2"></div>
        </div>
        
        <div class="table-header" STYLE="background-color:#8C94C6">
                Lista de Calificaciones
        </div>

        <!-- div.table-responsive -->

        <!-- div.dataTables_borderWrap -->
        <div class="table-responsive">
            <table id="dynamic-table2" class="table table-striped table-bordered table-hover table-condensed">
                <thead>
                    <tr>
                        <th>FOTO</th>
                        <th>NUMERO DE CUENTA</th>
                        <th>NOMBRE</th>
                        <th>ACTIVIDAD</th>
                        <th>LINK</th>
                        <th>CALIFICACION</th>
                        
                        <th></th>
                    </tr>
                </thead>

                    <tbody>
                        <c:forEach items="${listaProveedores}" var="item">
                            <tr>

                                <td>
                                        <img class="nav-user-photo" width="30px" height="30px"  src="/Intranet/resources/fotosPerfil/proveedores/${item.nombreFoto}" alt="${item.nombre}" />
                                         
                                    </td>
                                    <td>
                                         <c:out value="${item.num_cuenta}" />
                                    </td>
                                    <td><c:out value="${item.nombre}" /></td>
                                    <td><c:out value="${item.id_actividad.nombre}" /></td>
                                    <td><a href="<c:out value="${item.link}" />"><c:out value="${item.link}" /></a></td>
                                    <td><c:out value="${item.cantCalificacion}" /></td>
                                    <td>
                                            <div class="hidden-sm hidden-xs action-buttons">
                                                <a class="blue tooltip-info" data-rel="tooltip" href="/Intranet/sup/verCalificacion.htm?id=${item.id}" title="Ver Calificacion">
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
                                                                            <a href="/Intranet/sup/verCalificacion.htm?id=${item.id}" class="tooltip-success" data-rel="tooltip" title="Ver Calificacion">
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
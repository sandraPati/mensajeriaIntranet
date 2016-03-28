<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- #section:settings.box -->
						
<div class="page-content">  
<div class="page-header">
    <div class="row">
        <div class="col-lg-8">  
        <h1>
               Gestion 
                <small>
                    <i class="ace-icon fa fa-angle-double-right"></i>
                </small>
        </h1>
     </div>
         <div class="col-lg-4 align-right">
            <a class=" btn btn-white btn-warning" href="/Intranet/sup/addProveedor.htm" data-rel="tooltip">
                Registrar Provedor
            </a>
           
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
                Lista de Proveedores
        </div>

        <!-- div.table-responsive -->

        <!-- div.dataTables_borderWrap -->
        <div class="table-responsive">
            <table id="dynamic-table2" class="table table-striped table-bordered table-hover table-condensed">
                <thead>
                    <tr>
                        <th>FOTO</th>
                        <th>CIF</th>
                        <th>NOMBRE</th>
                        
                        <th>ACTIVIDAD</th>
                        <th>LINK</th>
                        <th>APROBADO</th>
                        <th>CALIFICACION</th>
                        <th></th>
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
                                         <c:out value="${item.cif}" />
                                    </td>
                                    <td><c:out value="${item.nombre}" /></td>
                                    <td><c:out value="${item.id_actividad.nombre}" /></td>
                                    
                                    <td>
                                        <a href="<c:out value="${item.link}" />" target="_blank"        onClick="window.open(this.href); return false;"><c:out value="${item.link}" /></a>
                                       
                                    
                                    <td>
                                        <c:if test="${item.aprobado==true}">
                                            Aprobado
                                        </c:if>
                                        <c:if test="${item.aprobado==false}">
                                            NO Aprobado
                                        </c:if>
                                    </td>
                                    <td><c:out value="${item.cantCalificacion}" /></td>
                                    <td>
                                            <div class="hidden-sm hidden-xs action-buttons">
                                                <a class="blue tooltip-info" data-rel="tooltip" href="/Intranet/sup/verProveedor.htm?id=${item.id}" title="Detalles">
                                                   <i class="ace-icon fa fa-search-plus bigger-130"></i>
                                                </a> 
                                                <a class="orange tooltip-warnnig" data-rel="tooltip" href="/Intranet/sup/updateCalificar.htm?id=${item.id}" title="Calificacion General">
                                                   <i class="ace-icon glyphicon  glyphicon-star-empty bigger-130"></i>
                                                </a>    
                                                <a class="blue tooltip-info" data-rel="tooltip" href="/Intranet/sup/fotoProveedor.htm?id=${item.id}" title="Cambiar Foto">
                                                   <i class="ace-icon glyphicon glyphicon-user bigger-130"></i>
                                                </a> 
                                                <a class="green tooltip-success" data-rel="tooltip" href="/Intranet/sup/updateProveedor.htm?id=${item.id}" title="Actualizar">
                                                   <i class="ace-icon fa fa-pencil bigger-130"></i>
                                                </a>   
                                                <a class="red tooltip-error" data-rel="tooltip" href="/Intranet/sup/deleteProveedor.htm?id=${item.id}" title="Eliminar">
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
                                                                            <a href="/Intranet/sup/verProveedor.htm?id=${item.id}" class="tooltip-info" data-rel="tooltip" title="Detalles">
                                                                                    <span class="blue">
                                                                                            <i class="ace-icon fa fa-search-plus bigger-120"></i>
                                                                                    </span>
                                                                            </a>
                                                                    </li> 
                                                                <li>
                                                                            <a href="/Intranet/sup/updateCalificar.htm?id=${item.id}" class="tooltip-warnnig" data-rel="tooltip" title="Calificacion_General">
                                                                                    <span class="orange">
                                                                                            <i class="ace-icon glyphicon  glyphicon-star-empty bigger-120"></i>
                                                                                    </span>
                                                                            </a>
                                                                    </li>      
                                                                <li>
                                                                            <a href="/Intranet/sup/fotoProveedor.htm?id=${item.id}" class="tooltip-info" data-rel="tooltip" title="Cambiar_Foto">
                                                                                    <span class="blue">
                                                                                            <i class="ace-icon glyphicon glyphicon-user bigger-120"></i>
                                                                                    </span>
                                                                            </a>
                                                                    </li>    
                                                                <li>
                                                                            <a href="/Intranet/sup/updateProveedor.htm?id=${item.id}" class="tooltip-success" data-rel="tooltip" title="Actualizar">
                                                                                    <span class="green">
                                                                                            <i class="ace-icon fa fa-pencil bigger-120"></i>
                                                                                    </span>
                                                                            </a>
                                                                    </li>
                                                                     <li>
                                                                            <a href="/Intranet/sup/deleteProveedor.htm?id=${item.id}" class="tooltip-error" data-rel="tooltip" title="Eliminar">
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
                                        <a class="blue tooltip-info" data-rel="tooltip" href="/Intranet/sup/verLtaPresupuestos.htm?id=${item.id}" title="ver Presupuestos">
                                           <i class="ace-icon fa fa-pencil-square-o bigger-130 "></i>
                                        </a> 
                                        <c:if test="${item.aprobado==true}">
                                            <a class="blue tooltip-info" data-rel="tooltip"  href="/Intranet/sup/verContratoProveedorPdf.htm?id=${item.id}" title="Ver Contrato">
                                                    <i class="ace-icon fa fa fa-search-plus bigger-130"></i>
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

					</div><!-- /.row -->
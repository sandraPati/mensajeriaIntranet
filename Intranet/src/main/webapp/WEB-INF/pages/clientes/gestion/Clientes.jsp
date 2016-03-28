<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- #section:settings.box -->
<div class="page-content">  	
<div class="page-header">
    <div class="row">
        <div class="col-lg-8">
        <h1>
        Clientes
        <small>
                <i class="ace-icon fa fa-angle-double-right"></i>
        </small>
    </h1>
        </div>
         <div class="col-lg-4 align-right">
            <a class=" btn btn-white btn-warning" href="/Intranet/sup/addDatosCliente.htm" data-rel="tooltip">
                Agregar Cliente
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
                        <th>EMAIL</th>
                        <th>TELEFONO</th>
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
                                <td><c:out value="${item.email}" /></td>
                                <td><c:out value="${item.telefono}" /></td>
                                <td>
                                        <div class="hidden-sm hidden-xs action-buttons">
                                            <a class="blue tooltip-info" data-rel="tooltip" href="/Intranet/sup/fichaCliente.htm?nifC=${item.nif}" title="Ver ficha">
                                               <i class="ace-icon fa fa-leaf bigger-130"></i>
                                            </a>
                                            <a class="blue tooltip-info" data-rel="tooltip" href="/Intranet/sup/securityDatosCliente.htm?nif=${item.nif}" title="Configurar Usuario/Contraseña">
                                               <i class="ace-icon fa fa-key bigger-130"></i>
                                            </a>
                                             <a class="green tooltip-success" data-rel="tooltip"  href="/Intranet/sup/updateDatosCliente.htm?nif=${item.nif}" title="Actualizar">
                                                            <i class="ace-icon fa fa-pencil bigger-130"></i>
                                            </a>

                                            <a class="red tooltip-error" data-rel="tooltip"  href="/Intranet/sup/deleteDatosCliente.htm?nif=${item.nif}" title="Eliminar">
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
                                                                    <a href="/Intranet/sup/fichaCliente.htm?nifC=${item.nif}" class="tooltip-info" data-rel="tooltip" title="Ver_ficha">
                                                                            <span class="blue">
                                                                                    <i class="ace-icon fa-leaf bigger-120"></i>
                                                                            </span>
                                                                    </a>
                                                                </li> 
                                                            <li>
                                                                    <a href="/Intranet/sup/securityDatosCliente.htm?nif=${item.nif}" class="tooltip-info" data-rel="tooltip" title="Configurar_Usuario/Contraseña">
                                                                            <span class="blue">
                                                                                    <i class="ace-icon fa fa-key bigger-120"></i>
                                                                            </span>
                                                                    </a>
                                                                </li>    
                                                            <li>
                                                                    <a href="/Intranet/sup/updateDatosCliente.htm?nif=${item.nif}" class="tooltip-success" data-rel="tooltip" title="Actualizar">
                                                                            <span class="green">
                                                                                    <i class="ace-icon fa fa-pencil-square-o bigger-120"></i>
                                                                            </span>
                                                                    </a>
                                                                </li>

                                                                <li>
                                                                    <a href="/Intranet/sup/deleteDatosCliente.htm?nif=${item.nif}" class="tooltip-error" data-rel="tooltip" title="Eliminar">
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
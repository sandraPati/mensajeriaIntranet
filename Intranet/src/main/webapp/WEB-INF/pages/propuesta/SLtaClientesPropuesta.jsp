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
            <a class=" btn btn-white btn-success" href="/Intranet/sup/NuevaPropuesta.htm" data-rel="tooltip">
                Nueva Propuesta
            </a>
            
        </div>
             
             
    </div>
</div><!-- /.page-header -->
<c:if test="${empty clientesListbox}">
        <div class="alert alert-warning">
            <button type="button" class="close" data-dismiss="alert">
                    <i class="ace-icon fa fa-times"></i>
            </button>

            <strong>
                    <i class="ace-icon fa fa-times"></i>
                    
            </strong>

            Este hay clientes registrados!
            <br />
        </div>
        
    </c:if>
<c:if test="${not empty clientesListbox}">
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
                        <th>NOMBRE Y APELLIDOS</th>
                        <th>DIRECCION</th>
                        <th></th>
                    </tr>
                </thead>

                                                                            <tbody>
                                                                                <c:forEach items="${clientesListbox}" var="item">
                                                                                    <tr>
                                                                                            

                                                                                            <td>
                                                                                                 <c:out value="${item.nif}" />
                                                                                            </td>
                                                                                            <td><c:out value="${item.nombre}" />, <c:out value="${item.apellidos}" /></td>
                                                                                            <td><c:out value="${item.direccion}" /></td>
                                                                                            

                                                                                            <td>
                                                                                                    <div class="hidden-sm hidden-xs action-buttons">
                                                                                                        <a class="blue tooltip-info" data-rel="tooltip" href="/Intranet/sup/verPropuestas.htm?nifC=${item.nif}" title="Ver Propuestas">
                                                                                                                    <i class="ace-icon fa fa-search-plus bigger-130"></i>
                                                                                                            </a>    
                                                                                                       
                                                                                                        <a class="grey " data-rel="tooltip" href="/Intranet/sup/NuevaPropuestaAdd.htm?cli=${item.nif}" title="Agregar Propuesta">
                                                                                                                    <i class="ace-icon glyphicon glyphicon-file bigger-130"></i>
                                                                                                            </a>             
                                                                                                        <a class="orange tooltip-warning" data-rel="tooltip" href="/Intranet/sup/NuevaPropuestaExpresAdd.htm?cli=${item.nif}" title="Presupuesto Expres">
                                                                                                                    <i class="ace-icon fa  fa-asterisk bigger-130"></i>
                                                                                                            </a>
                                                                                                       
                                                                                                          

                                                                                                    </div>

                                                                                                    <div class="hidden-md hidden-lg">
                                                                                                            <div class="inline pos-rel">
                                                                                                                    <button class="btn btn-minier btn-yellow dropdown-toggle" data-toggle="dropdown" data-position="auto">
                                                                                                                            <i class="ace-icon fa fa-caret-down icon-only bigger-120"></i>
                                                                                                                    </button>

                                                                                                                    <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
                                                                                                                            <li>
                                                                                                                                    <a href="/Intranet/sup/verPropuestas.htm?nifC=${item.nif}" class="tooltip-info" data-rel="tooltip" title="Ver_Propuestas">
                                                                                                                                            <span class="blue">
                                                                                                                                                    <i class="ace-icon fa fa-search-plus bigger-120"></i>
                                                                                                                                            </span>
                                                                                                                                    </a>
                                                                                                                                            
                                                                                                                            </li>

                                                                                                                           
                                                                                                                            <li>
                                                                                                                                    <a href="/Intranet/sup/NuevaPropuestaAdd.htm?cli=${item.nif}" data-rel="tooltip" title="Agregar_Propuesta">
                                                                                                                                            <span class="grey">
                                                                                                                                                    <i class="ace-icon glyphicon glyphicon-file bigger-120"></i>
                                                                                                                                            </span>
                                                                                                                                    </a>
                                                                                                                            </li>
                                                                                                                            <li>
                                                                                                                                    <a href="/Intranet/sup/NuevaPropuestaExpresAdd.htm?cli=${item.nif}"  class="tooltip-warning" data-rel="tooltip" title="Presupuesto_Expres">
                                                                                                                                            <span class="orange">
                                                                                                                                                    <i class="ace-icon fa  fa-asterisk bigger-120"></i>
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
</c:if>
					</div><!-- /.row -->
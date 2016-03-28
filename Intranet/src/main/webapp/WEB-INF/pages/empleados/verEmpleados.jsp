<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!-- #section:settings.box -->
<div class="page-content">	
<div class="page-header">
    <div class="row">
        <div class="col-lg-8">
        <h1>
               Lista de Empleados
                <small>
                        <i class="ace-icon fa fa-angle-double-right"></i>
                       
                </small>
        </h1>
        </div>
         <div class="col-lg-4 align-right">
            <a class=" btn btn-white btn-warning" href="/Intranet/sup/NuevoEmpleado.htm" data-rel="tooltip">
               <i class="orange-light ace-icon fa fa-user bigger-130"></i> Nuevo Empleado
            </a>
            
        </div>
             
             
    </div>
</div><!-- /.page-header -->
<c:if test="${not empty error}">
	<div class="alert alert-danger">
            <button type="button" class="close" data-dismiss="alert">
                    <i class="ace-icon fa fa-times"></i>
            </button>

            <strong>
                    <i class="ace-icon fa fa-times"></i>
                    
            </strong>

            ${error}
            <br />
        </div>

    </c:if>
    <c:if test="${not empty msg}">
	<div class="alert alert-block alert-success">
            <button type="button" class="close" data-dismiss="alert">
                    <i class="ace-icon fa fa-times"></i>
            </button>

            <strong>
                    <i class="ace-icon fa fa-check"></i>
                    
            </strong>

            ${msg}
            <br />
        </div>

    </c:if>

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
                                                                                        <th>FOTO</th>
                                                                                            <th>NIF</th>
                                                                                            <th>NOMBRE</th>
                                                                                            <th>APELLIDOS</th>                                                                                            
                                                                                            <th>TELEFONO</th>
                                                                                            <th>OTRO TELEFONO</th>
                                                                                            <th>MAIL</th>
                                                                                            <th>OTRO MAIL</th>
                                                                                            <th>PERFIL</th>
                                                                                            <th></th>
                                                                                            <th></th>
                                                                                            <th></th>
                                                                                    </tr>
                                                                            </thead>

                                                                            <tbody>

                                                                                <c:forEach items="${empleadoListbox}" var="item">
                                                                                    <tr>
                                                                                         <td>
                                                                                            <img class="nav-user-photo" width="30px" height="30px"  src="/Intranet/resources/fotosPerfil/proveedores/${item.nombrefotografia}" alt="${item.nombre}" />

                                                                                        </td>

                                                                                            <td>
                                                                                                <div id="nif"><c:out value="${item.nif}" /></div>
                                                                                            </td>
                                                                                            <td><c:out value="${item.nombre}" /></td>
                                                                                            <td><c:out value="${item.apellidos}" /></td>
                                                                                            
                                                                                            <td><c:out value="${item.telefono}" /></td>
                                                                                            <td><c:out value="${item.otro_telefono}" /></td>
                                                                                            <td><c:out value="${item.email}" /></td>
                                                                                            <td><c:out value="${item.otro_email}" /></td>

                                                                                            <td><c:out value="${item.id_perfil.nombrep}" /></td>

                                                                                            <td>
                                                                                                    <div class="hidden-sm hidden-xs action-buttons">
                                                                                                            <a class="tooltip-info" data-rel="tooltip" href="/Intranet/sup/verDatosEmpleado.htm?nif=${item.nif}" title="Ver Informacion">
                                                                                                                    <i class="ace-icon fa fa-search-plus bigger-130"></i>
                                                                                                            </a>
                                                                                                                     <a class="blue tooltip-info" data-rel="tooltip" href="/Intranet/sup/securityDatosEmpleados.htm?nif=${item.nif}" title="Configurar Usuario/Contraseña">
                                                                                                                       <i class="ace-icon fa fa-key bigger-130"></i>
                                                                                                                    </a>
                                                                                                            <a class="green tooltip-success" data-rel="tooltip" href="/Intranet/sup/securityDecorakiaEmp.htm?nif=${item.nif}" title="Correo Decorakia">
                                                                                                                    <i class="ace-icon glyphicon glyphicon-envelope bigger-130"></i>
                                                                                                            </a> 
                                                                                                        
                                                                                                    </div>

                                                                                                    <div class="hidden-md hidden-lg">
                                                                                                            <div class="inline pos-rel">
                                                                                                                    <button class="btn btn-minier btn-yellow dropdown-toggle" data-toggle="dropdown" data-position="auto">
                                                                                                                            <i class="ace-icon fa fa-caret-down icon-only bigger-120"></i>
                                                                                                                    </button>

                                                                                                                    <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
                                                                                                                            <li>
                                                                                                                                    <a href="/Intranet/sup/verDatosEmpleado.htm?nif=${item.nif}" class="tooltip-info" data-rel="tooltip" title="Ver Informacion">
                                                                                                                                            <span class="blue">
                                                                                                                                                    <i class="ace-icon fa fa-search-plus bigger-120"></i>
                                                                                                                                            </span>
                                                                                                                                    </a>
                                                                                                                            </li>
                                                                                                                            <li>
                                                                                                                                <a href="/Intranet/sup/securityDatosEmpleados.htm?nif=${item.nif}" class="tooltip-info" data-rel="tooltip" title="Configurar_Usuario/Contraseña">
                                                                                                                                        <span class="blue">
                                                                                                                                                <i class="ace-icon fa fa-key bigger-120"></i>
                                                                                                                                        </span>
                                                                                                                                </a>
                                                                                                                            </li>  
                                                                                                                            <li>
                                                                                                                                    <a href="/Intranet/sup/securityDecorakiaEmp.htm?nif=${item.nif}" class="tooltip-success" data-rel="tooltip" title="Correo_Decorakia">
                                                                                                                                            <span class="green">
                                                                                                                                                    <i class="ace-icon glyphicon glyphicon-envelope bigger-120"></i>
                                                                                                                                            </span>
                                                                                                                                    </a>
                                                                                                                            </li>
                                                                                                                    </ul>
                                                                                                                          
                                                                                                            </div>
                                                                                                    </div>
                                                                                            </td>
                                                                                             <td>
                                                                                                    <div class="hidden-sm hidden-xs action-buttons">
                                                                                                            
                                                                                                        <c:if test="${item.estadoaltabaja==1}">            
                                                                                                            <a   id="btn_baja" class="red tooltip-error" data-rel="tooltip" href="/Intranet/sup/finiquito.htm?nif=${item.nif}" title="Dar de Baja">
                                                                                                                    <i class="ace-icon glyphicon glyphicon-user bigger-130"></i>
                                                                                                            </a>
                                                                                                            



                                                                                                        </c:if>   
                                                                                                        <c:if test="${item.estadoaltabaja==2}">
                                                                                                            Empleado dado de baja
                                                                                                            <a class="green tooltip-success" data-rel="tooltip" href="/Intranet/sup/VerFiniquito.htm?nif=${item.nif}" title="Finiquito">
                                                                                                                    <i class="ace-icon glyphicon glyphicon-tags bigger-130"></i>
                                                                                                            </a>
                                                                                                            <a id="btn_alta" class="green tooltip-success" data-rel="tooltip" href="/Intranet/sup/ajaxEAlta.json?nif=${item.nif}" title="Dar de Alta">
                                                                                                                    <i class="ace-icon glyphicon glyphicon-user bigger-130"></i>
                                                                                                            </a>         
                                                                                                        </c:if>    
                                                                                                    </div>

                                                                                                    <div class="hidden-md hidden-lg">
                                                                                                            <div class="inline pos-rel">
                                                                                                                    

                                                                                                                            <c:if test="${item.estadoaltabaja==1}">
                                                                                                                           
                                                                                                                                    <a id="btn_baja2" href="/Intranet/sup/finiquito.htm?nif=${item.nif}" class="tooltip-error" data-rel="tooltip" title="Dar_de_Baja">
                                                                                                                                            <span class="red">
                                                                                                                                                    <i class="ace-icon glyphicon glyphicon-user bigger-120"></i>
                                                                                                                                            </span>
                                                                                                                                    </a>
                                                                                                                            
                                                                                                                            </c:if> 
                                                                                                                            <c:if test="${item.estadoaltabaja==2}">
                                                                                                                           
                                                                                                                                Empleado dado de baja
                                                                                                                                <a href="/Intranet/sup/VerFiniquito.htm?nif=${item.nif}" class="tooltip-success" data-rel="tooltip" title="Finiquito">
                                                                                                                                            <span class="green">
                                                                                                                                                    <i class="ace-icon glyphicon glyphicon-tags bigger-120"></i>
                                                                                                                                            </span>
                                                                                                                                    </a>
                                                                                                                                    <a id="btn_alta2" href="/Intranet/sup/ajaxEAlta.json?nif=${item.nif}" class="tooltip-success" data-rel="tooltip" title="Dar_de_Alta">
                                                                                                                                            <span class="green">
                                                                                                                                                    <i class="ace-icon glyphicon glyphicon-user bigger-120"></i>
                                                                                                                                            </span>
                                                                                                                                    </a>
                                                                                                                            
                                                                                                                            </c:if>  
                                                                                                                   
                                                                                                                          
                                                                                                            </div>
                                                                                                    </div>
                                                                                            </td>
                                                                                            
                                                                                            <td>
                                                                                              <c:if test="${item.perfilprof.id==1}">  
                                                                                                  <a class="tooltip-info" data-rel="tooltip" href="/Intranet/sup/Objetivos.htm?nif=${item.nif}" title="Objetivos">
                                                                                                    <i class="ace-icon fa fa-tachometer bigger-130"></i>
                                                                                                  </a>
                                                                                              </c:if>
                                                                                              <c:if test="${item.perfilprof.id!=1}">
                                                                                                  -
                                                                                              </c:if>
                                                                                            </td>
                                                                                    </tr>
                                                                                 </c:forEach>        



                                                                            </tbody>
                                                                    </table>
                                                              
                                                            </div>
                                                            

                                                    </div>
                            </div>
                      
                            
</div><!-- /.row -->

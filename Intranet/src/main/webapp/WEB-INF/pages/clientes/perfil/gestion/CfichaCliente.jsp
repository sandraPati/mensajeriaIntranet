<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- #section:settings.box -->
						
<div class="page-content">  
<div class="page-header">
    <div class="row">
        <div class="col-lg-8">
        <h1>
               Propuestas Por Cliente:
                <small>
                    <i class="ace-icon fa fa-angle-double-right"></i>
                  
                </small>
        </h1>
        </div>
         <div class="col-lg-4 align-right">
            
           
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
<div class="row">
    <div class="col-xs-12">

        <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-4">
            <div class="profile-info-row">
                <div class="profile-info-name"> NIF/NIE/PASAPORTE </div>

                <div class="profile-info-value">
                    <span class="editable" id="username"><c:out value=" ${cliente.nif}" /></span>
                </div>
            </div>
            <div class="profile-info-row">
                <div class="profile-info-name"> Direccion </div>

                <div class="profile-info-value">
                    <span class="editable" id="username"><c:out value="${cliente.direccion} " /></span>
                </div>
            </div>
                 <div class="hr hr-dotted hr-16"><br/><br/><br/></div>    
    </div>
                
    <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-4">
        <div class="profile-info-row">
            <div class="profile-info-name"> Nombre </div>

            <div class="profile-info-value">
                <span class="editable" id="username"><c:out value="${cliente.nombre}" /></span>
            </div>
        </div>
        <div class="profile-info-row">
            <div class="profile-info-name"> Codigo Postal </div>

            <div class="profile-info-value">
                <span class="editable" id="username"><c:out value="${cliente.codigo_postal} " /></span>
            </div>
        </div> 
             <div class="hr hr-dotted hr-16"><br/><br/><br/></div>    
    </div>  
    <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-4">
        <div class="profile-info-row">
            <div class="profile-info-name"> Apellidos </div>

            <div class="profile-info-value">
                <span class="editable" id="username"><c:out value="${cliente.apellidos} " /></span>
            </div>
        </div>
        <div class="profile-info-row">
            <div class="profile-info-name"> EMAIL </div>

            <div class="profile-info-value">
                <span class="editable" id="username"><c:out value="${cliente.email}" /></span>
            </div>

        </div>
             <div class="hr hr-dotted hr-16"><br/><br/><br/></div>    
    </div>
               
</div>
</div>         

<div class="row">
    <div class="col-xs-12">
        
        <div class="clearfix">
            <div class="pull-right tableTools-container2"></div>
        </div>
        
        <div class="table-header" STYLE="background-color:#8C94C6">
                Lista de Propuestas
        </div>

        <!-- div.table-responsive -->

        <!-- div.dataTables_borderWrap -->
        <div class="table-responsive">
            <table id="dynamic-table2" class="table table-striped table-bordered table-hover table-condensed">
                <thead>
                    <tr>

                        <th>DESCRIPCION</th>
                        <th>EMPLEADO</th>
                        <th>DIA</th>
                        <th>HORA</th>
                        <th>CLIENTE</th>							
                        <th>DIRECCION</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                    <tbody>
                        <c:forEach items="${ltaPropuestas}" var="item">
                            <tr>


                                    <td>
                                         <c:out value="${item.descipcion}" />
                                    </td>
                                    <td><c:out value="${item.empleado_nif.nif}" /> <c:out value="${item.empleado_nif.apellidos}" />, <c:out value="${item.empleado_nif.nombre}" /></td>
                                    <td><c:out value="${item.dia}" /></td>
                                    <td><c:out value="${item.hora}" /></td>
                                    <td><c:out value="${item.cliente_nif.nif}" /> <c:out value="${item.cliente_nif.apellidos}" />, <c:out value="${item.cliente_nif.nombre}" /></td>
                                    <td><c:out value="${item.direccion}" /></td>

                                    <td>
                                            <div class="hidden-sm hidden-xs action-buttons">
                                                   
                                                <a class="blue tooltip-info" data-rel="tooltip" href="/Intranet/cli/CfichaverPropuesta.htm?idP=${item.id}" title="Gestionar Propuesta">
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
                                                                            <a href="/Intranet/cli/CfichaverPropuesta.htm?idP=${item.id}" class="tooltip-info" data-rel="tooltip" title="Gestionar_Propuesta">
                                                                                    <span class="blue">
                                                                                            <i class="ace-icon fa fa-search-plus bigger-120"></i>
                                                                                    </span>
                                                                            </a>
                                                                    </li>
                                                                   

                                                            </ul>
                                                    </div>
                                            </div>
                                    </td>
                                      <td>
                                            <div class="hidden-sm hidden-xs action-buttons">
                                                  
                                                <a class="grey " data-rel="tooltip" href="/Intranet/cli/CFichaverPresupuestoPdf.htm?idP=${item.id}" title="Ver Presupuesto">
                                                   <i class="ace-icon fa fa-eye bigger-130"></i>
                                                </a>  
                                               
                                            </div>

                                            <div class="hidden-md hidden-lg">
                                                    <div class="inline pos-rel">
                                                            <button class="btn btn-minier btn-yellow dropdown-toggle" data-toggle="dropdown" data-position="auto">
                                                                    <i class="ace-icon fa fa-caret-down icon-only bigger-120"></i>
                                                            </button>

                                                            <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
                                                                     <li>
                                                                            <a href="/Intranet/cli/CFichaverPresupuestoPdf.htm?idP=${item.id}" class="" data-rel="tooltip" title="Ver Presupuesto">
                                                                                    <span class="grey">
                                                                                            <i class="ace-icon fa fa-eye bigger-120"></i>
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
            

<div class="page-header">
   
        <h1>
               PROYECTOS
                <small>
                    <i class="ace-icon fa fa-angle-double-right"></i>
                  
                </small>
        </h1>
      
</div><!-- /.page-header -->

<div class="row">
    <div class="col-xs-12">
        
        <div class="clearfix">
            <div class="pull-right tableTools-container1"></div>
        </div>
        
        <div class="table-header" STYLE="background-color:#3FBC63">
                Lista de Proyectos
        </div>

        <!-- div.table-responsive -->

        <!-- div.dataTables_borderWrap -->
        <div class="table-responsive " >
            <table id="dynamic-table1" class="table table-striped table-bordered table-hover table-condensed">
                <thead>
                    <tr>

                        <th>DESCRIPCION</th>
                        <th>EMPLEADO</th>
                        <th>DIA</th>
                        <th>HORA</th>
                        <th>CLIENTE</th>							
                        <th>DIRECCION</th>
                        <th></th>
                    </tr>
                </thead>
                    <tbody>
                        <c:forEach items="${ltaProyectos}" var="item">
                            <tr>


                                    <td>
                                         <c:out value="${item.descipcion}" />
                                    </td>
                                    <td><c:out value="${item.empleado_nif.nif}" /> <c:out value="${item.empleado_nif.apellidos}" />, <c:out value="${item.empleado_nif.nombre}" /></td>
                                    <td><c:out value="${item.dia}" /></td>
                                    <td><c:out value="${item.hora}" /></td>
                                    <td><c:out value="${item.cliente_nif.nif}" /> <c:out value="${item.cliente_nif.apellidos}" />, <c:out value="${item.cliente_nif.nombre}" /></td>
                                    <td><c:out value="${item.direccion}" /></td>

                                    <td>
                                         <div class="hidden-sm hidden-xs action-buttons">
                                                <a class="grey " data-rel="tooltip" href="/Intranet/cli/CFichaverContratoPdf.htm?idP=${item.id}" title="Ver Contrato">
                                                   <i class="ace-icon fa fa-eye bigger-130"></i>
                                                </a>   
                                                <a class="grey " data-rel="tooltip" href="/Intranet/cli/verCFichaPlanObraPdf.htm?idP=${item.id}" title="Ver Plan de Obra">
                                                   <i class="ace-icon fa fa-eye bigger-130"></i>
                                                </a>    
                                                <a class="grey " data-rel="tooltip" href="/Intranet/cli/CFichaverPresupuestoPdf.htm?idP=${item.id}" title="Ver Presupuesto">
                                                   <i class="ace-icon fa fa-eye bigger-130"></i>
                                                </a>  
                                                <a class="grey " data-rel="tooltip" href="/Intranet/cli/CFichaverCertificacionesPdf.htm?idP=${item.id}" title="Ver Certificaciones">
                                                   <i class="ace-icon fa fa-eye bigger-130"></i>
                                                </a>    
                                                <a class="green tooltip-success" data-rel="tooltip" href="/Intranet/cli/CProyectoGaleria.htm?id=${item.id}" title="Galeria del Proyecto">
                                                   <i class="ace-icon glyphicon glyphicon-picture bigger-130"></i>
                                                </a>    
                                            </div>

                                            <div class="hidden-md hidden-lg">
                                                    <div class="inline pos-rel">
                                                            <button class="btn btn-minier btn-yellow dropdown-toggle" data-toggle="dropdown" data-position="auto">
                                                                    <i class="ace-icon fa fa-caret-down icon-only bigger-120"></i>
                                                            </button>

                                                            <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
                                                                <li>
                                                                            <a href="/Intranet/cli/CFichaverContratoPdf.htm?idP=${item.id}" class="" data-rel="tooltip" title="Ver_Contrato">
                                                                                    <span class="grey">
                                                                                            <i class="ace-icon fa fa-eye bigger-120"></i>
                                                                                    </span>
                                                                            </a>
                                                                    </li>
                                                                    <li>
                                                                            <a href="/Intranet/cli/verCFichaPlanObraPdf.htm?idP=${item.id}" class="" data-rel="tooltip" title="Ver_PlanObra">
                                                                                    <span class="grey">
                                                                                            <i class="ace-icon fa fa-eye bigger-120"></i>
                                                                                    </span>
                                                                            </a>
                                                                    </li>     
                                                                <li>
                                                                            <a href="/Intranet/cli/CFichaverPresupuestoPdf.htm?idP=${item.id}" class="" data-rel="tooltip" title="Ver Presupuesto">
                                                                                    <span class="grey">
                                                                                            <i class="ace-icon fa fa-eye bigger-120"></i>
                                                                                    </span>
                                                                            </a>
                                                                    </li>
                                                                    
                                                                    <li>
                                                                            <a href="/Intranet/cli/CFichaverCertificacionesPdf.htm?idP=${item.id}" class="" data-rel="tooltip" title="Ver_Certificaciones">
                                                                                    <span class="grey">
                                                                                            <i class="ace-icon fa fa-eye bigger-120"></i>
                                                                                    </span>
                                                                            </a>
                                                                    </li>
                                                                     <li>
                                                                            <a href="/Intranet/cli/CProyectoGaleria.htm?id=${item.id}" class="tooltip-success" data-rel="tooltip" title="Galeria_del_Proyecto">
                                                                                    <span class="green">
                                                                                            <i class="ace-icon glyphicon glyphicon-picture bigger-120"></i>
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


								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
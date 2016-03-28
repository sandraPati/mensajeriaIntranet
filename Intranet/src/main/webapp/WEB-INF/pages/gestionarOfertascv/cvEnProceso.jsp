<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- #section:settings.box -->
<div class="page-content">
<div class="page-header">
        <h1>
                Candidatos en Proceso
                <small>
                        <i class="ace-icon fa fa-angle-double-right"></i>
                       
                </small>
        </h1>
</div><!-- /.page-header -->						

<!-- /section:settings.box -->
<br/>
<div class="row">
    <div class="col-xs-1">
        <div ><img src="/Intranet/resources/assets/img/postulantes.png"/></div>
        
    </div>
    <div class="col-xs-1">
        <div >   <img src="/Intranet/resources/assets/img/enproceso.png"/></div>

    </div>
    <div class="col-xs-1">
        <div >   <img src="/Intranet/resources/assets/img/descartados.png"/></div>

    </div>
</div>
<div class="row">
    <div class="col-xs-1">
        <a href="/Intranet/sup/cvrecibidos.htm">${cvp.cantidad1}</a>

    </div>
    <div class="col-xs-1">
       <a href="/Intranet/sup/cvEnProceso.htm">${cvp.cantidad2}</a>

    </div>
    <div class="col-xs-1">
       <a href="/Intranet/sup/cvDescartado.htm">${cvp.cantidad3}</a>

    </div>
</div>
<div class="row">
    <div class="col-xs-12">
        <c:if test="${not empty mensaje}">
            <div class="msg">${mensaje}</div>
        </c:if>
           
            <!-- /section:pages/dashboard.infobox.dark -->

            <div class="clearfix">
                    <div class="pull-right tableTools-container1"></div>
            </div>
            <div class="table-header" STYLE="background-color:#8C94C6">
                    Lista de Candidatos
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
                                            <th>EMAIL</th>
                                            <th>PAIS</th>
                                            <th>PROVINCIA</th>
                                            <th>POBLACION</th>
                                            <th>DIRECCION</th>
                                            <th>FECHA Registro</th>
                                            <th></th>
                                    </tr>
                            </thead>

                            <tbody>

                                <c:forEach items="${listaPostulantes}" var="item">
                                    <tr>
                                        <td>
                                        <img class="nav-user-photo" width="30px" height="30px"  src="/Intranet/resources/fotosPerfil/${item.nombrefotografia}" alt="${item.nombre}" />
                                         
                                    </td>
                                            <td>
                                                <c:out value="${item.docuemnto_identidad}" />
                                            </td>
                                            <td><c:out value="${item.nombre}" /></td>
                                            <td><c:out value="${item.apellidos}" /></td>

                                            <td><c:out value="${item.email}" /></td>
                                            <td><c:out value="${item.pais}" /></td>
                                            <td><c:out value="${item.provincia}" /></td>
                                            <td><c:out value="${item.poblacion}" /></td>

                                            <td><c:out value="${item.direccion}" /></td>
                                            <td><c:out value="${item.fecharegistrado}" /></td>
                                            <td>
                                                    <div class="hidden-sm hidden-xs action-buttons">
                                                            <a class="tooltip-info" data-rel="tooltip" href="/Intranet/sup/verCvEnProceso.htm?nif=${item.docuemnto_identidad}" title="Ver Informacion" >
                                                                    <i class="ace-icon fa fa-search-plus bigger-130"></i>
                                                            </a>
                                                             
                                                            
                                                            <a class="green tooltip-success" href="/Intranet/sup/enprocesoFin.htm?nif=${item.docuemnto_identidad}" data-rel="tooltip"  title="Proceso de Finalizacion">
                                                                  <i class="ace-icon fa fa-check bigger-130"></i>

                                                            </a>     

                                                            <a class="red tooltip-error" href="/Intranet/sup/cvDescartadoaddp.htm?nif=${item.docuemnto_identidad}" data-rel="tooltip"  title="Descartado">
                                                                  <i class="ace-icon fa fa-trash-o bigger-120"></i>

                                                            </a>

                                                    </div>

                                                    <div class="hidden-md hidden-lg">
                                                            <div class="inline pos-rel">
                                                                    <button class="btn btn-minier btn-yellow dropdown-toggle" data-toggle="dropdown" data-position="auto">
                                                                            <i class="ace-icon fa fa-caret-down icon-only bigger-120"></i>
                                                                    </button>

                                                                    <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
                                                                            <li>
                                                                                    <a href="/Intranet/sup/verCvEnProceso.htm?nif=${item.docuemnto_identidad}" class="tooltip-info" data-rel="tooltip" title="Ver Informacion">
                                                                                            <span class="blue">
                                                                                                    <i class="ace-icon fa fa-search-plus bigger-120 info"></i>
                                                                                            </span>
                                                                                    </a>
                                                                            </li>
                                                                            <li>
                                                                                    <a href="/Intranet/sup/enprocesoFin.htm?nif=${item.docuemnto_identidad}" class="tooltip-success" data-rel="tooltip" title="Proceso de Finalizacion">
                                                                                            <span class="green">
                                                                                                    <i class="ace-icon fa fa-check bigger-120 success"></i>
                                                                                            </span>
                                                                                    </a>
                                                                            </li>
                                                                            <li>
                                                                                    <a href="/Intranet/sup/cvDescartadoaddp.htm?nif=${item.docuemnto_identidad}" class="tooltip-error" data-rel="tooltip" title="Descartado">
                                                                                            <span class="red">
                                                                                                    <i class="ace-icon fa fa-trash-o bigger-120 error"></i>
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
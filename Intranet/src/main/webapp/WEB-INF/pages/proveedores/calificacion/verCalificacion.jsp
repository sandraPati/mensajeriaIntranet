<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- #section:settings.box -->
<div class="page-content">  						

<div class="page-header">
    <div class="row">
        <div class="col-lg-8">  
        <h1>
               Calificaciones de:
                <small>
                    <i class="ace-icon fa fa-angle-double-right"></i>
                    ${prov.num_cuenta} ${prov.nombre} de Actividad: ${prov.id_actividad.nombre}
                </small>
        </h1>
     </div>
         <div class="col-lg-4 align-right">
            <a class=" btn btn-white btn-warning" href="/Intranet/sup/Calificacion.htm" data-rel="tooltip">
                <i class="ace-icon fa fa-reply icon-only"></i>
            </a>
        </div>
        
             
             
    </div> 
</div><!-- /.page-header -->
<br/>


<div class="row">
    <div class="col-xs-12 col-sm-3 center">
                            <div>
                                    <!-- #section:pages/profile.picture -->
                                    <span class="profile-picture">
                                            <img id="avatar" class="editable img-responsive" alt="${prov.nombre}" src="/Intranet/resources/fotosPerfil/proveedores/${prov.foto}" />
                                    </span>

                                    <!-- /section:pages/profile.picture -->
                                    <div class="space-4"></div>

                                    <div class="width-80 label label-info label-xlg arrowed-in arrowed-in-right">
                                            <div class="inline position-relative">
                                                    <a href="#" class="user-title-label dropdown-toggle" data-toggle="dropdown">
                                                            <i class="ace-icon fa fa-circle light-green"></i>
                                                            &nbsp;
                                                            <span class="white">${prov.nombre}</a></span>
                                                    </a>

                                                   
                                            </div>
                                    </div>
                            </div>

                            <div class="space-6"></div>

                            <!-- #section:pages/profile.contact -->
                         

                    </div>
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

                        <th>EMPLEADO</th>
                        <th>CALIFICACION</th>
                        <th>COMENTARIO</th>
                    </tr>
                </thead>

                    <tbody>
                        <c:forEach items="${listaCalificaciones}" var="item">
                            <tr>


                                    <td>
                                        <c:out value="${item.empleado_nif.nif}" />  <c:out value="${item.empleado_nif.apellidos}" />, <c:out value="${item.empleado_nif.nombre}" />
                                    </td>
                                    <td><c:out value="${item.calificacion}" /></td>
                                    <td><c:out value="${item.comentario}" /></td>
                                   
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
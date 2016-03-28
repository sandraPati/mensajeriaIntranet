<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<div class="page-content">
<c:if test="${postulante.estadoinf==false}">
<div class="row">
    <div class="col-xs-12">
        
        <!-- #section:plugins/fuelux.wizard.steps -->
        <ul class="steps  ">
                <li data-step="1" class="active">
                    <span class="step "><a href="/Intranet/pos/Informacion.htm"><i class="ace-icon glyphicon glyphicon-ok bigger-100 light-green"></i></a></span>
                        <span class="title ">Información Personal</span>
                </li>

                <li data-step="2" class="active ">
                        <span class="step"><a href="/Intranet/pos/ActualizarfotoPostulante.htm"><i class="ace-icon glyphicon glyphicon-ok bigger-100 light-green"></i></a></span>
                        <span class="title">Subir Foto / CV.</span>
                </li>

                <li data-step="3" class="active ">
                        <span class="step"><a href="/Intranet/pos/EstudiosP.htm"><i class="ace-icon glyphicon glyphicon-ok bigger-100 light-green"></i></a></span>
                        <span class="title">Estudios</span>
                </li>

                <li data-step="4" class="active ">
                        <span class="step"><a href="/Intranet/pos/IdiomasP.htm"><i class="ace-icon glyphicon glyphicon-ok bigger-100 light-green"></i></a></span>
                        <span class="title">Idiomas</span>
                </li>
                <li data-step="5" class="active ">
                        <span class="step">5</span>
                        <span class="title">Conocimientos</span>
                </li>
                <li data-step="6">
                        <span class="step">6</span>
                        <span class="title">Experiencias Laborales</span>
                </li>
                <li data-step="7">
                        <span class="step">7</span>
                        <span class="title">Futuro Empleo</span>
                </li>
        </ul>

    </div>

</div>
<br/>
</c:if>
<br/>                    
<div class="page-header">
    <h1>
        Mis Conocimientos
        <small>
                <i class="ace-icon fa fa-angle-double-right"></i>
              
        </small>
    </h1>
</div><!-- /.page-header -->                
<!-- #section:settings.box -->
<div>
        <a class=" btn btn-white btn-warning" href="/Intranet/pos/addConocimiento.htm" data-rel="tooltip">
            Agregar Conocimiento
        </a>
    </div>
    <br/>
<div class="row">
<div class="col-xs-12">
   
    <div class="clearfix">
            <div class="pull-right tableTools-container2"></div>
    </div>
    <div class="table-header" STYLE="background-color:#3FBC63">
            Lista de Conocimientos
    </div>
    
    <!-- div.table-responsive -->

    <!-- div.dataTables_borderWrap -->
    <div class="table-responsive">
            <table id="dynamic-table2" class="table table-striped table-bordered table-hover table-condensed">
                    <thead>
                            <tr>
                                <th>DESCRIPCION</th>
                                <th>NIVEL</th>
                                <th></th>
                            </tr>
                    </thead>

                    <tbody>
                        <c:forEach items="${listaConocimientos}" var="item">
                            <tr>
                                    <td>
                                         <c:out value="${item.descripcion}" />
                                    </td>
                                    <td><c:out value="${item.nivel}" /></td>
                                    <td>
                                            <div class="hidden-sm hidden-xs action-buttons">
                                                    

                                                    <a class="green" href="/Intranet/pos/updateConocimiento.htm?id=${item.id}" title="Actualizar">
                                                            <i class="ace-icon fa fa-pencil bigger-130"></i>
                                                    </a>

                                                    <a class="red" href="/Intranet/pos/deleteConocimiento.htm?id=${item.id}" title="Eliminar">
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
                                                                            <a href="/Intranet/pos/updateConocimiento.htm?id=${item.id}" class="tooltip-success" data-rel="tooltip" title="Actualizar">
                                                                                    <span class="green">
                                                                                            <i class="ace-icon fa fa-pencil-square-o bigger-120"></i>
                                                                                    </span>
                                                                            </a>
                                                                    </li>

                                                                    <li>
                                                                            <a href="/Intranet/pos/deleteConocimiento.htm?id=${item.id}" class="tooltip-error" data-rel="tooltip" title="Eliminar">
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
    <c:if test="${postulante.estadoinf==false}">
                                <div class="form-group">
                                    <div class="col-sm-9"></div>
                                        
                                        <div class="col-sm-3 no-padding-right">
                                            <a class="btn btn-prev col-xs-12 col-sm-4 col-md-3 col-lg-6 "  href="/Intranet/pos/IdiomasP.htm">
                                                  <i class="ace-icon fa fa-arrow-left"></i> Anterior
                                            </a> 
                                            <a class="btn btn-success col-xs-12 col-sm-4 col-md-3 col-lg-6 "  href="/Intranet/pos/ExperienciaLaboralesP.htm">
                                                   Siguiente<i class="ace-icon fa fa-arrow-right icon-on-right"></i>
                                                </a>
                                        </div>
                                </div> 
    </c:if>
</div>																																
</div>
	
</div><!-- /.row -->

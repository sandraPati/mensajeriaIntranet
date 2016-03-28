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
                        <span class="step">3</span>
                        <span class="title">Estudios</span>
                </li>

                <li data-step="4">
                        <span class="step">4</span>
                        <span class="title">Idiomas</span>
                </li>
                <li data-step="5">
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
<br/></c:if>
<br/>                 
<div class="page-header">
    <h1>
        Mis Estudios
        <small>
                <i class="ace-icon fa fa-angle-double-right"></i>
              
        </small>
    </h1>
</div><!-- /.page-header -->                
<!-- #section:settings.box -->
<div>
        <a class=" btn btn-white btn-warning" href="/Intranet/pos/addEstudio.htm" data-rel="tooltip">
            Agregar Estudio
        </a>
    </div>
    <br/>
<div class="row">
<div class="col-xs-12">
   
    <div class="clearfix">
            <div class="pull-right tableTools-container2"></div>
    </div>
    <div class="table-header" STYLE="background-color:#3FBC63">
            Lista de Estudios
    </div>
    
    <!-- div.table-responsive -->

    <!-- div.dataTables_borderWrap -->
    <div class="table-responsive">
            <table id="dynamic-table2" class="table table-striped table-bordered table-hover table-condensed">
                    <thead>
                            <tr>

                                    <th>CURSO</th>
                                    <th>FECHA DE INICIO</th>
                                    <th class="hidden-480">FECHA DE FIN</th>
                                    <th>CURSANDO</th>
                                    <th class="hidden-480">CENTRO</th>	
                                    <th></th>
                            </tr>
                    </thead>

                    <tbody>
                        <c:forEach items="${listaEstudios}" var="item">
                            <tr>
                                    <td>
                                         <c:out value="${item.curso_id.nombre}" />
                                    </td>
                                    <td><c:out value="${item.fecha_inicio}" /></td>
                                    <td class="hidden-480"><c:out value="${item.fecha_fin}" /></td>
                                    <td class="hidden-480"><c:out value="${item.cursandoM}" /></td>
                                    <td><c:out value="${item.centro}" /></td>

                                    <td>
                                            <div class="hidden-sm hidden-xs action-buttons">
                                                    

                                                    <a class="green" href="/Intranet/pos/updateEstudio.htm?id=${item.id}" title="Actualizr">
                                                            <i class="ace-icon fa fa-pencil bigger-130"></i>
                                                    </a>

                                                    <a class="red" href="/Intranet/pos/deleteEstudio.htm?id=${item.id}" title="Eliminar">
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
                                                                            <a href="/Intranet/pos/updateEstudio.htm?id=${item.id}" class="tooltip-success" data-rel="tooltip" title="Actualizar">
                                                                                    <span class="green">
                                                                                            <i class="ace-icon fa fa-pencil-square-o bigger-120"></i>
                                                                                    </span>
                                                                            </a>
                                                                    </li>

                                                                    <li>
                                                                            <a href="/Intranet/pos/deleteEstudio.htm?id=${item.id}" class="tooltip-error" data-rel="tooltip" title="Eliminar">
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
    <br/><br/>
    <c:if test="${postulante.estadoinf==false}">
    <div class="form-group">
                                    <div class="col-sm-9"></div>
                                        
                                        <div class="col-sm-3 no-padding-right">
                                            <a class="btn btn-prev col-xs-12 col-sm-4 col-md-3 col-lg-6 "  href="/Intranet/pos/ActualizarfotoPostulante.htm">
                                                  <i class="ace-icon fa fa-arrow-left"></i> Anterior
                                            </a> 
                                            <a class="btn btn-success col-xs-12 col-sm-4 col-md-3 col-lg-6 "  href="/Intranet/pos/IdiomasP.htm">
                                                   Siguiente<i class="ace-icon fa fa-arrow-right icon-on-right"></i>
                                                </a>
                                        </div>
                                </div>  
    </c:if>
</div>																																
</div>
	
</div><!-- /.row -->
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<div class="page-content">  
<!-- #section:settings.box -->
<div class="page-header">
    <div class="row">
        <div class="col-lg-8">
        <h1>
                Empleado:
                <small>
                        <i class="ace-icon fa fa-angle-double-right"></i>
                       ${empleado.nif} ${empleado.nombre}, ${empleado.apellidos}
                </small>
        </h1>
        </div>
         <div class="col-lg-4 align-right">
            <a class=" btn btn-white btn-warning" href="/Intranet/sup/UpdateDatosEmpleado.htm?nif=${empleado.nif}" data-rel="tooltip">
               <i class="ace-icon fa fa-undo bigger-130"></i> Actualizar
            </a>
            <a class=" btn btn-white btn-warning" href="/Intranet/sup/verEmpleados.htm" data-rel="tooltip">
                <i class="ace-icon fa fa-reply icon-only"></i>
            </a>
        </div>
             
             
    </div>
</div><!-- /.page-header -->

 <div class="row" >
            <div class="col-xs-12 col-sm-3 center">
                            <div>
                                    <!-- #section:pages/profile.picture -->
                                    <span class="profile-picture">
                                            <img id="avatar" class="editable img-responsive" width="300px" height="300px" alt="${empleado.nombre}" src="/Intranet/resources/fotosPerfil/${empleado.nombrefotografia}" />
                                    </span>

                                    <!-- /section:pages/profile.picture -->
                                    <div class="space-4"></div>

                                    <div class="width-80 label label-info label-xlg arrowed-in arrowed-in-right">
                                            <div class="inline position-relative">
                                                    <a href="#" class="user-title-label dropdown-toggle" data-toggle="dropdown">
                                                            <i class="ace-icon fa fa-circle light-green"></i>
                                                            &nbsp;
                                                            <span class="white">${empleado.nombre} </span>
                                                    </a>

                                                   
                                            </div>
                                    </div>
                            </div>

                            <div class="space-6"></div>

                            <!-- #section:pages/profile.contact -->
                         

                    </div>
                    
                                           
        </div>

<div class="row">
    <div class="col-xs-12">

        <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-4">
                <div class="profile-info-row">
                    <div class="profile-info-name"> NIF/NIE/PASAPORTE </div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${empleado.nif}" /></span>
                    </div>
                </div>
                <div class="profile-info-row">
                    <div class="profile-info-name"> Nombre </div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${empleado.nombre}" /></span>
                    </div>
                </div>
                <div class="profile-info-row">
                    <div class="profile-info-name"> Apellidos </div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${empleado.apellidos}" /></span>
                    </div>
                </div>
                <div class="profile-info-row">
                    <div class="profile-info-name"> EMAIL </div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${empleado.email}" /></span>
                    </div>
                </div>
                    <div class="profile-info-row">
                    <div class="profile-info-name"> OTRO EMAIL </div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${empleado.otro_email}" /></span>
                    </div>
                </div>
                <div class="profile-info-row">
                    <div class="profile-info-name"> FECHA DE NACIMIENTO </div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${empleado.fecha_nacimiento}" /></span>
                    </div>
                </div>
                <div class="profile-info-row">
                    <div class="profile-info-name"> TELEFONO</div>

                    <div class="profile-info-value">
                            <span class="editable" id="username"><c:out value="${empleado.telefono}" /></span>
                    </div>
            </div>
                     <div class="profile-info-row">
                    <div class="profile-info-name"> OTRO TELEFONO</div>

                    <div class="profile-info-value">
                            <span class="editable" id="username"><c:out value="${empleado.otro_telefono}" /></span>
                    </div>
                    </div>
                 <div class="profile-info-row">
                    <div class="profile-info-name"> CODIGO POSTAL</div>

                    <div class="profile-info-value">
                            <span class="editable" id="username"><c:out value="${empleado.codigo_postal}" /></span>
                    </div>
            </div>
               <div class="profile-info-row">
                    <div class="profile-info-name"> GENERO</div>

                    <div class="profile-info-value">
                            <span class="editable" id="username"><c:out value="${empleado.genero}" /></span>
                    </div>
            </div>


        </div>
        <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-4">


            <div class="profile-info-row">
                    <div class="profile-info-name">PAIS </div>

                    <div class="profile-info-value">
                            <span class="editable" id="username"><c:out value="${empleado.pais}" /></span>
                    </div>
            </div>
            <div class="profile-info-row">
                    <div class="profile-info-name"> PROVINCIA </div>

                    <div class="profile-info-value">
                            <span class="editable" id="username"><c:out value="${empleado.provincia}" /></span>
                    </div>
            </div>

            <div class="profile-info-row">
                    <div class="profile-info-name"> POBLACI&Oacute;N </div>

                    <div class="profile-info-value">
                            <span class="editable" id="username"><c:out value="${empleado.poblacion}" /></span>
                    </div>
            </div>
                    <div class="profile-info-row">
                    <div class="profile-info-name"> NACIONALIDAD </div>

                    <div class="profile-info-value">
                            <span class="editable" id="username"><c:out value="${empleado.nacionalidad}" /></span>
                    </div>
            </div>
            <div class="profile-info-row">
                    <div class="profile-info-name"> DIRECCI&Oacute;N </div>

                    <div class="profile-info-value">
                            <span class="editable" id="username"><c:out value="${empleado.direccion}" /></span>
                    </div>
            </div>
            <div class="profile-info-row">
                    <div class="profile-info-name"> NUMERO DE SEGURIDAD SOCIAL </div>

                    <div class="profile-info-value">
                            <span class="editable" id="username"><c:out value="${empleado.numero_seguridad_social}" /></span>
                    </div>
            </div>
            <div class="profile-info-row">
                    <div class="profile-info-name"> DOBA </div>

                    <div class="profile-info-value">
                            <span class="editable" id="username"><c:out value="${empleado.doba}" /></span>
                    </div>
            </div>
            <div class="profile-info-row">
                    <div class="profile-info-name"> FECHA ALTA </div>

                    <div class="profile-info-value">
                            <span class="editable" id="username"><c:out value="${empleado.fecha_alta}" /></span>
                    </div>
            </div>
            <div class="profile-info-row">
                    <div class="profile-info-name"> OBSERVACIONES </div>

                    <div class="profile-info-value">
                            <span class="editable" id="username"><c:out value="${empleado.observacion}" /></span>
                    </div>
            </div>
            
            
        </div>
                    
                    
        <div class="profile-striped col-xs-12 col-sm-12 col-md-12 col-lg-4">
            <div class="profile-info-row">
                    <div class="profile-info-name"> NUMERO AFILIACION S.S </div>

                    <div class="profile-info-value">
                            <span class="editable" id="username"><c:out value="${empleado.numero_afiliacionss}" /></span>
                    </div>
            </div>       
             
            <div class="profile-info-row">
                    <div class="profile-info-name"> NIVEL FORMATIVO </div>

                    <div class="profile-info-value">
                            <span class="editable" id="username"><c:out value="${empleado.nivel_formativo}" /></span>
                    </div>
            </div> 

            <div class="profile-info-row">
                    <div class="profile-info-name">PERMISO CONDUCIR  </div>

                    <div class="profile-info-value">
                            <span class="editable" id="username"><c:out value="${empleado.permiso_conducir}" /></span>
                    </div>
            </div>
            <div class="profile-info-row">
                    <div class="profile-info-name"> VEHICULO PROPIO </div>

                    <div class="profile-info-value">
                            <span class="editable" id="username"><c:out value="${empleado.vehiculo_propio}" /></span>
                    </div>
            </div>

            <div class="profile-info-row">
                    <div class="profile-info-name"> AUTONOMO </div>

                    <div class="profile-info-value">
                            <span class="editable" id="username"><c:out value="${empleado.autonomo}" /></span>
                    </div>
            </div>
                    <div class="profile-info-row">
                    <div class="profile-info-name"> PRESENCIA EN </div>

                    <div class="profile-info-value">
                            <span class="editable" id="username"><c:out value="${empleado.presencia}" /></span>
                    </div>
            </div>
            <div class="profile-info-row">
                    <div class="profile-info-name"> Nombre de Busqueda</div>

                    <div class="profile-info-value">
                            <span class="editable" id="username"><c:out value="${empleado.nombrepresencia}" /></span>
                    </div>
            </div>
            <div class="profile-info-row">
                    <div class="profile-info-name">Perfil Profesional </div>

                    <div class="profile-info-value">
                            <span class="editable" id="username"><c:out value="${empleado.perfilprof.nombre}" /></span>
                    </div>
            </div>       
            <div class="profile-info-row">
                    <div class="profile-info-name"> Oficio </div>

                    <div class="profile-info-value">
                            <span class="editable" id="username"><c:out value="${empleado.oficio.nombre}" /></span>
                    </div>
            </div>  
            
        </div>
        <div class="hr hr-dotted hr-16"></div>
										


    </div>
</div>
<div class="page-header">
<div class="row">
<div class="col-lg-8 ">
    <h1>
        Estudios
        <small>
                <i class="ace-icon fa fa-angle-double-right"></i>
              
        </small>
    </h1>
</div><!-- /.page-header -->  
    <div class="col-lg-4 align-right">
        <a class=" btn btn-white btn-success" href="/Intranet/sup/addEstudioE.htm?nif=${empleado.nif}" data-rel="tooltip">
          Agregar
        </a>
    </div>
          
</div>
</div>
<div class="row">
<div class="col-xs-12">
   
    <div class="clearfix">
            <div class="pull-right tableTools-container2"></div>
    </div>
    <div class="table-header" STYLE="background-color:#8C94C6">
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
                        <c:forEach items="${ltaestudios}" var="item">
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
                                                    

                                                    <a class="green" href="/Intranet/sup/updateEstudioE.htm?id=${item.id}" title="Actualizar">
                                                            <i class="ace-icon fa fa-pencil bigger-130"></i>
                                                    </a>
                                                    <a class="red" href="/Intranet/sup/deleteEstudioE.htm?id=${item.id}&nif=${item.postulante_doc_identidad}" title="Eliminar">
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
                                                                            <a href="/Intranet/sup/updateEstudioE.htm?id=${item.id}" class="tooltip-success" data-rel="tooltip" title="Actualizar">
                                                                                    <span class="green">
                                                                                            <i class="ace-icon fa fa-pencil-square-o bigger-120"></i>
                                                                                    </span>
                                                                            </a>
                                                                    </li>
                                                                     <li>
                                                                            <a href="/Intranet/sup/deleteEstudioE.htm?id=${item.id}&nif=${item.postulante_doc_identidad}" class="tooltip-error" data-rel="tooltip" title="Eliminar">
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
</div>																																
</div>
          <br/>
<div class="page-header">
<div class="row">
<div class="col-lg-8 ">
    <h1>
        Idiomas
        <small>
                <i class="ace-icon fa fa-angle-double-right"></i>
              
        </small>
    </h1>
</div><!-- /.page-header -->  
    <div class="col-lg-4 align-right">
        <a class=" btn btn-white btn-success" href="/Intranet/sup/addIdiomaE.htm?nif=${empleado.nif}" data-rel="tooltip">
          Agregar
        </a>
    </div>
          
</div>
</div>
<div class="row">
<div class="col-xs-12">
   
    <div class="clearfix">
            <div class="pull-right tableTools-container1"></div>
    </div>
    <div class="table-header" STYLE="background-color:#3FBC63">
            Lista de Idiomas
    </div>
    
    <!-- div.table-responsive -->

    <!-- div.dataTables_borderWrap -->
    <div class="table-responsive">
            <table id="dynamic-table1" class="table table-striped table-bordered table-hover table-condensed">
                    <thead>
                            <tr>
                                <th>IDIOMA</th>
                                <th>NIVEL DE HABLADO</th>
                                <th class="hidden-480">NIVEL ESCRITO</th>
                                <th class="hidden-480">NIVEL LEIDO</th>
                                <th></th>
                                    
                        </tr>
                    </thead>

                    <tbody>
                        <c:forEach items="${ltaidiomas}" var="item">
                            <tr>
                                    <td>
                                         <c:out value="${item.tipoidioma_id.nombre}" />
                                    </td>
                                    <td><c:out value="${item.nivelhablado}" /></td>
                                    <td class="hidden-480"><c:out value="${item.nivelescrito}" /></td>
                                    <td class="hidden-480"><c:out value="${item.nivelleido}" /></td>
                                   <td>
                                            <div class="hidden-sm hidden-xs action-buttons">
                                                    

                                                    <a class="green" href="/Intranet/sup/updateIdiomaE.htm?id=${item.id}" title="Actualizar">
                                                            <i class="ace-icon fa fa-pencil bigger-130"></i>
                                                    </a>
                                                     <a class="red" href="/Intranet/sup/deleteIdiomaE.htm?id=${item.id}&nif=${item.postulante_doc_identidad}" title="Eliminar">
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
                                                                            <a href="/Intranet/sup/updateIdiomaE.htm?id=${item.id}" class="tooltip-success" data-rel="tooltip" title="Actualizar">
                                                                                    <span class="green">
                                                                                            <i class="ace-icon fa fa-pencil-square-o bigger-120"></i>
                                                                                    </span>
                                                                            </a>
                                                                    </li>
                                                                    <li>
                                                                            <a href="/Intranet/sup/deleteIdiomaE.htm?id=${item.id}&nif=${item.postulante_doc_identidad}" class="tooltip-error" data-rel="tooltip" title="Eliminar">
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
</div>																																
</div>
<br/>
<div class="page-header">
<div class="row">
<div class="col-lg-8 ">
    <h1>
        Conocimientos
        <small>
                <i class="ace-icon fa fa-angle-double-right"></i>
              
        </small>
    </h1>
</div><!-- /.page-header -->  
    <div class="col-lg-4 align-right">
        <a class=" btn btn-white btn-success" href="/Intranet/sup/addConocimientoE.htm?nif=${empleado.nif}" data-rel="tooltip">
          Agregar
        </a>
    </div>
          
</div>
</div>
<div class="row">
<div class="col-xs-12">
   
    <div class="clearfix">
            <div class="pull-right tableTools-container3"></div>
    </div>
    <div class="table-header" >
            Lista de Conocimientos
    </div>
    
    <!-- div.table-responsive -->

    <!-- div.dataTables_borderWrap -->
    <div class="table-responsive">
            <table id="dynamic-table3" class="table table-striped table-bordered table-hover table-condensed">
                    <thead>
                            <tr>
                                <th>DESCRIPCION</th>
                                <th>NIVEL</th>
                                <th></th>
                            </tr>
                    </thead>

                    <tbody>
                        <c:forEach items="${ltaconocimientos}" var="item">
                            <tr>
                                    <td>
                                         <c:out value="${item.descripcion}" />
                                    </td>
                                    <td><c:out value="${item.nivel}" /></td>
                                   <td>
                                            <div class="hidden-sm hidden-xs action-buttons">
                                                    

                                                    <a class="green" href="/Intranet/sup/updateConocimientoE.htm?id=${item.id}" title="Actualizar">
                                                            <i class="ace-icon fa fa-pencil bigger-130"></i>
                                                    </a>
                                                    <a class="red" href="/Intranet/sup/deleteConocimientoE.htm?id=${item.id}&nif=${item.postulante_doc_identidad}" title="Eliminar">
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
                                                                            <a href="/Intranet/sup/updateConocimientoE.htm?id=${item.id}" class="tooltip-success" data-rel="tooltip" title="Actualizar">
                                                                                    <span class="green">
                                                                                            <i class="ace-icon fa fa-pencil-square-o bigger-120"></i>
                                                                                    </span>
                                                                            </a>
                                                                    </li>

                                                                    <li>
                                                                            <a href="/Intranet/sup/deleteConocimientoE.htm?id=${item.id}&nif=${item.postulante_doc_identidad}" class="tooltip-error" data-rel="tooltip" title="Eliminar">
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
</div>																																
</div>
<br/>
<div class="page-header">          
<div class="row">
<div class="col-lg-8 ">
    <h1>
       Experiencias Laborales
        <small>
                <i class="ace-icon fa fa-angle-double-right"></i>
              
        </small>
    </h1>
</div><!-- /.page-header -->  
    <div class="col-lg-4 align-right">
        <a class=" btn btn-white btn-success" href="/Intranet/sup/addExperienciaLaboralE.htm?nif=${empleado.nif}" data-rel="tooltip">
          Agregar
        </a>
    </div>
          
</div>
</div>
<div class="row">
<div class="col-xs-12">
   
    <div class="clearfix">
            <div class="pull-right tableTools-container4"></div>
    </div>
    <div class="table-header" STYLE="background-color:#B8860B">
            Lista de Experiencias Laborales
    </div>
    
    <!-- div.table-responsive -->

    <!-- div.dataTables_borderWrap -->
    <div class="table-responsive">
            <table id="dynamic-table4" class="table table-striped table-bordered table-hover table-condensed">
                    <thead>
                            <tr>
                                <th>PUESTO</th>
                                <th>EMPRESA</th>
                                <th class="hidden-480">FECHA DE INICIO</th>
                                <th>FECHA DE FIN</th>
                                <th class="hidden-480">TRABAJANDO</th>	
                                <th></th>
                            </tr>
                    </thead>

                    <tbody>
                        <c:forEach items="${ltaexperienciaLaboral}" var="item">
                            <tr>
                                    <td>
                                         <c:out value="${item.puesto}" />
                                    </td>
                                    <td><c:out value="${item.empresa}" /></td>
                                    <td class="hidden-480"><c:out value="${item.fecha_inicio}" /></td>
                                    <td class="hidden-480"><c:out value="${item.fecha_fin}" /></td>
                                    <td><c:out value="${item.trabajandoM}" /></td>
<td>
                                            <div class="hidden-sm hidden-xs action-buttons">
                                                    

                                                    <a class="green" href="/Intranet/sup/updateExperienciaLaboralE.htm?id=${item.id}" title="Actualizar">
                                                            <i class="ace-icon fa fa-pencil bigger-130"></i>
                                                    </a>
                                                    <a class="red" href="/Intranet/sup/deleteExperienciaLaboralE.htm?id=${item.id}&nif=${item.postulante_doc_identidad}" title="Eliminar">
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
                                                                            <a href="/Intranet/sup/updateExperienciaLaboralE.htm?id=${item.id}" class="tooltip-success" data-rel="tooltip" title="Actualizar">
                                                                                    <span class="green">
                                                                                            <i class="ace-icon fa fa-pencil-square-o bigger-120"></i>
                                                                                    </span>
                                                                            </a>
                                                                    </li>
                                                                    <li>
                                                                            <a href="/Intranet/sup/deleteExperienciaLaboralE.htm?id=${item.id}&nif=${item.postulante_doc_identidad}" class="tooltip-error" data-rel="tooltip" title="Eliminar">
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
</div>																																
</div>

               

<br/>       
<div class="page-header">
<div class="row">
<div class="col-lg-8">
    <h1>
       Futuro Empleo
        <small>
                <i class="ace-icon fa fa-angle-double-right"></i>
              
        </small>
    </h1>
</div><!-- /.page-header -->  
    <div class="col-lg-4 align-right">
        <a class=" btn btn-white btn-success" href="/Intranet/sup/FuturoEmpleoE.htm?nif=${empleado.nif}" data-rel="tooltip">
         <i class="ace-icon fa fa-pencil-square-o bigger-120"></i> Actualizar
        </a>
    </div>
          
</div>           
</div>
<div class="row">
    <div class="col-xs-12">

        <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-6">
                <div class="profile-info-row">
                    <div class="profile-info-name">¿Est&aacute;s buscando trabajo? </div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${ltafuturoEmpleo.buscas_trabajo}" /></span>
                    </div>
                </div>
                <div class="profile-info-row">
                    <div class="profile-info-name"> ¿Qu&eacute; puesto prefieres ? </div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${ltafuturoEmpleo.puesto}" /></span>
                    </div>
                </div>
                <div class="profile-info-row">
                    <div class="profile-info-name"> ¿Disponibilidad para cambiar de residencia?  </div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${ltafuturoEmpleo.cambiar_residencia}" /></span>
                    </div>
                </div>
                <div class="profile-info-row">
                    <div class="profile-info-name"> Destinos preferidos </div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${ltafuturoEmpleo.destinos}" /></span>
                    </div>
                </div>
            
                <div class="profile-info-row">
                    <div class="profile-info-name">Disponibilidad para viajar </div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${ltafuturoEmpleo.viajar}" /></span>
                    </div>
                </div>
                    
            </div>
            <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-6">
                <div class="profile-info-row">
                    <div class="profile-info-name"> Jornada Laboral Preferida</div>

                    <div class="profile-info-value">
                            <span class="editable" id="username"><c:out value="${ltafuturoEmpleo.jornada_laboral_preferida}" /></span>
                    </div>
            </div>
                 <div class="profile-info-row">
                    <div class="profile-info-name"> ¿Qu&eacute; tipo de contrato prefieres?</div>

                    <div class="profile-info-value">
                            <span class="editable" id="username"><c:out value="${ltafuturoEmpleo.tipo_contrato}" /></span>
                    </div>
            </div>
               <div class="profile-info-row">
                    <div class="profile-info-name"> Expectativas salariales: minimo aceptado bruto mensual </div>

                    <div class="profile-info-value">
                            <span class="editable" id="username"><c:out value="${ltafuturoEmpleo.expectativas_salariales_minimo}" /></span>
                    </div>
            </div>
            <div class="profile-info-row">
                    <div class="profile-info-name">Salario deseado bruto mensual </div>

                    <div class="profile-info-value">
                            <span class="editable" id="username"><c:out value="${ltafuturoEmpleo.salario_deseado}" /></span>
                    </div>
            </div>


        </div>
        
                    
                    
        
        <div class="hr hr-dotted hr-16"></div>
										


    </div>
</div>

<!-- /section:settings.box -->
<br/>

</div><!-- /.row -->

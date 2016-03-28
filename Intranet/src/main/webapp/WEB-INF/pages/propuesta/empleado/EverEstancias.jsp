<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- #section:settings.box -->
						
<div class="page-content">  
<div class="page-header">
    <div class="row">
        <div class="col-lg-8">   
        <h1>
               Popuesta: 
                <small>
                    <i class="ace-icon fa fa-angle-double-right"></i>
                   ${estancia.propuesta_id.descipcion} del CLIENTE: ${estancia.propuesta_id.cliente_nif.nif} ${estancia.propuesta_id.cliente_nif.apellidos}, ${estancia.propuesta_id.cliente_nif.nombre}
                </small>
        </h1>
      </div>
         <div class="col-lg-4 align-right">
            
            <a class=" btn btn-white btn-warning" href="/Intranet/emp/EconsultarPropuesta.htm?idP=${estancia.propuesta_id.id}" data-rel="tooltip">
                <i class="ace-icon fa fa-reply icon-only"></i>

            </a>
        </div>
        
             
             
    </div> 
</div><!-- /.page-header -->

<div class="row">
    <div class="col-xs-12">

        <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-4">
                
                <div class="profile-info-row">
                    <div class="profile-info-name"> ESTANCIA</div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${estancia.numero}" />  <c:out value="${estancia.tipo_estancia_id.nombre}" /> </span>
                    </div>
                </div>    
               
        </div>
       
    </div>
</div>

<br/>


<div class="page-header">
    <div class="row">
        <div class="col-lg-8">
        <h1>
               Paños de Estancia 
                <small>
                    <i class="ace-icon fa fa-angle-double-right"></i>
                   
                </small>
        </h1>
        </div>
         <div class="col-lg-4 align-right">
            <a class=" btn btn-white btn-warning" href="/Intranet/emp/EmpjaddPano2.htm?idE=${estancia.id}" data-rel="tooltip">
                Agregar
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
                Lista de Paños
        </div>

        <!-- div.table-responsive -->

        <!-- div.dataTables_borderWrap -->
        <div class="table-responsive">
            <table id="dynamic-table2" class="table table-striped table-bordered table-hover table-condensed">
                <thead>
                    <tr>

                        <th>NOMBRE Paños por Estancia</th>
                        <th>LARGO</th>
                        <th>ALTO</th>
                        <th>lado3</th>
                        <th>SUPERFICIE</th>
                        <th></th>
                    </tr>
                </thead>

                    <tbody>
                        <c:forEach items="${ltaPanos}" var="item">
                            <tr>


                                    <td>
                                         <c:out value="${item.nombrepano}" />
                                    </td>
                                    <td><c:out value="${item.largo}" /></td>
                                    <td><c:out value="${item.alto}" /></td>
                                    <td><c:out value="${item.lado3}" /></td>
                                    <td><c:out value="${item.superficie}" /></td>
                                    <td>
                                            <div class="hidden-sm hidden-xs action-buttons">
                                                <a class="orange tooltip-warning" data-rel="tooltip" href="/Intranet/emp/EvolcarPano.htm?idPano=${item.id}" title="Volcar Paño">
                                                            <i class="ace-icon glyphicon glyphicon-repeat bigger-130"></i>
                                                    </a> 
                                                <a class="blue tooltip-info" data-rel="tooltip" href="/Intranet/emp/EverPanos.htm?idPano=${item.id}" title="Consultar Paño">
                                                            <i class="ace-icon fa fa-search-plus bigger-130"></i>
                                                    </a>    
                                                <a class="green tooltip-success" data-rel="tooltip" href="/Intranet/emp/EmpjupdatePano.htm?idPano=${item.id}" title="Actualizar">
                                                   <i class="ace-icon fa fa-pencil bigger-130"></i>
                                                </a>            
                                                <a class="red" href="/Intranet/emp/EdeletePano.htm?idE=${estancia.id}&idP=${item.id}" title="Eliminar">
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
                                                                            <a href="/Intranet/emp/EvolcarPano.htm?idPano=${item.id}" class="tooltip-warning" data-rel="tooltip" title="Volcar_Paño">
                                                                                    <span class="orange">
                                                                                            <i class="ace-icon glyphicon glyphicon-repeat bigger-120"></i>
                                                                                    </span>
                                                                            </a>

                                                                    </li>
                                                                    <li>
                                                                            <a href="/Intranet/emp/EverPanos.htm?idPano=${item.id}" class="tooltip-info" data-rel="tooltip" title="Consultar_Paño">
                                                                                    <span class="blue">
                                                                                            <i class="ace-icon fa fa-search-plus bigger-120"></i>
                                                                                    </span>
                                                                            </a>

                                                                    </li>
                                                                     <li>
                                                                            <a href="/Intranet/emp/EmpjupdatePano.htm?idPano=${item.id}" class="tooltip-success" data-rel="tooltip" title="Actualizar">
                                                                                    <span class="green">
                                                                                            <i class="ace-icon fa fa-pencil-square-o bigger-120"></i>
                                                                                    </span>
                                                                            </a>
                                                                    </li>
                                                                     <li>
                                                                            <a href="/Intranet/emp/EdeletePano.htm?idE=${estancia.id}&idP=${item.id}" class="tooltip-error" data-rel="tooltip" title="Eliminar">
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


<div class="row">
    <div class="col-xs-12">

        <div class="profile-striped col-xs-12 col-sm-12 col-md-12 col-lg-12">
                
                <div class="profile-info-row">
                    <div class="profile-info-value">
                       Total de superficie de estancia (suma de superficies de todos los paños)
                    </div>
                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${estancia.totalSpanos}" /> m cuadrados</span>
                    </div>
                </div>    
                <div class="profile-info-row">
                    <div class="profile-info-value">
                       Total de superficie de estancia (sin elementos de los paños restando ventanas puertas y armarios)
                    </div>
                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${estancia.superficie}" /> m cuadrados</span>
                    </div>
                </div>  
                <div class="profile-info-row">
                    <div class="profile-info-value">
                      Total Superficie ventanas
                    </div>
                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${estancia.totalSventanas}" /> m cuadrados</span>
                    </div>
                </div> 
                <div class="profile-info-row">
                    <div class="profile-info-value">
                      Total Superficie Puertas
                    </div>
                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${estancia.totalSpuertas}" /> m cuadrados</span>
                    </div>
                </div>  
                <div class="profile-info-row">
                    <div class="profile-info-value">
                      Total Superficie Armarios
                    </div>
                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${estancia.totalSarmarios}" /> m cuadrados</span>
                    </div>
                </div>  
                <div class="profile-info-row">
                    <div class="profile-info-value">
                     Total superficie suelos
                    </div>
                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${estancia.totalSsuelos}" /> m cuadrados</span>
                    </div>
                </div> 
                <div class="profile-info-row">
                    <div class="profile-info-value">
                    Total Superficie Techos
                    </div>
                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${estancia.totalStechos}" /> m cuadrados</span>
                    </div>
                </div>    
        </div>
              

    </div>
</div>
					</div><!-- /.row -->
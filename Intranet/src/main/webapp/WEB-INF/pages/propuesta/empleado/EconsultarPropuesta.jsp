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
                   ${prop.descipcion}
                </small>
        </h1>
        </div>
         <div class="col-lg-4 align-right">
            <a class=" btn btn-white btn-warning" href="/Intranet/emp/EupdatePropuesta.htm?idP=${prop.id}" data-rel="tooltip">
                Actualizar
            </a>
            <a class=" btn btn-white btn-warning" href="/Intranet/emp/EverPropuestas.htm?nifC=${prop.cliente_nif.nif}" data-rel="tooltip">
                <i class="ace-icon fa fa-reply icon-only"></i>

            </a>
        </div>
        
             
             
    </div>
</div><!-- /.page-header -->

<div class="row">
    <div class="col-xs-12">

        <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-4">
                
                <div class="profile-info-row">
                    <div class="profile-info-name"> CLIENTE</div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${prop.cliente_nif.nif}" /> <c:out value="${prop.cliente_nif.apellidos}" />, <c:out value="${prop.cliente_nif.nombre}" /></span>
                    </div>
                </div>    
                <div class="profile-info-row">
                    <div class="profile-info-name"> PAIS </div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${prop.pais}" /></span>
                    </div>
                </div>
        </div>
        <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-4">
                <div class="profile-info-row">
                    <div class="profile-info-name"> DIRECCION </div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${prop.direccion}" /></span>
                    </div>
                </div>    
           
                <div class="profile-info-row">
                    <div class="profile-info-name"> PROVINCIA </div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${prop.provincia}" /></span>
                    </div>
                </div>
                
                
        </div>
        <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-4">
            <div class="profile-info-row">
                <div class="profile-info-name"><p> </p></div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><p> </p></span>
                    </div>
                </div>    
            <div class="profile-info-row">
                    <div class="profile-info-name"> POBLACION</div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${prop.poblacion}" /></span>
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
               Estancias de Propuesta: 
                <small>
                    <i class="ace-icon fa fa-angle-double-right"></i>
                   
                </small>
        </h1>
        </div>
         <div class="col-lg-4 align-right">
            <a class=" btn btn-white btn-warning" href="/Intranet/emp/EmpjaddEstancia.htm?idP=${prop.id}" data-rel="tooltip">
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
                Lista de Estancias
        </div>

        <!-- div.table-responsive -->

        <!-- div.dataTables_borderWrap -->
        <div class="table-responsive">
            <table id="dynamic-table2" class="table table-striped table-bordered table-hover table-condensed">
                <thead>
                    <tr>

                        <th>N°</th>
                        <th>NOMBRE ESTANCIA</th>
                        <th>Total Superficie</th>
                        <th></th>
                    </tr>
                </thead>

                    <tbody>
                        <c:forEach items="${ltaEstancias}" var="item">
                            <tr>


                                    <td>
                                         <c:out value="${item.numero}" />
                                    </td>
                                    <td><c:out value="${item.tipo_estancia_id.nombre}" /></td>
                                    <td><c:out value="${item.totalSpanos}" /></td>

                                    <td>
                                            <a class="blue tooltip-info" data-rel="tooltip" href="/Intranet/emp/EverEstancias.htm?idE=${item.id}" title="Consultar_Estancia">
                                                    <i class="ace-icon fa fa-search-plus bigger-130"></i>
                                            </a>
                                            <a class="red tooltip-error" data-rel="tooltip" href="/Intranet/emp/EdeleteEstancia.htm?idE=${item.id}&idP=${prop.id}" title="Eliminar_Estancia">
                                                    <i class="ace-icon fa fa-trash-o bigger-130"></i>
                                            </a>                 
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
            Totales de Propuesta 
                <small>
                    <i class="ace-icon fa fa-angle-double-right"></i>                    
                </small>
        </h1>
    </div>

<div class="row">
    <div class="col-xs-12">
         <div class="profile-striped col-xs-12">  
            <div class="profile-info-row">
                <div class="profile-info-value">Total de superficie de estancia (suma de superficies de todos los paños)</div>
                <div class="profile-info-name"></div>
                <div class="profile-info-name">
                    <span class="editable" id="username"><c:out value="${prop.totalSpanos}" /> m</span>
                </div>
                <div class="profile-info-name">cuadrados</div>
            </div>
            <div class="profile-info-row">
                <div class="profile-info-value">Total de superficie de estancia (sin elementos de los paños restando ventanas puertas y armarios)</div>
                <div class="profile-info-name"></div>
                <div class="profile-info-name">
                    <span class="editable" id="username"><c:out value="${prop.superficie}" /> m</span>
                </div>
                <div class="profile-info-name">cuadrados</div>
            </div>
            <div class="profile-info-row">
                <div class="profile-info-value"> Total Superficie ventanas</div>
                <div class="profile-info-name">
                    <span class="editable" id="username"><c:out value="${prop.numventanas}" /> Ventanas</span>
                </div>
                <div class="profile-info-name">
                    <span class="editable" id="username"><c:out value="${prop.totalSventanas}" /> m</span>
                </div>
                <div class="profile-info-name">cuadrados</div>
            </div>    
            <div class="profile-info-row">
                <div class="profile-info-value"> Total Superficie Puertas</div>
                <div class="profile-info-name">
                    <span class="editable" id="username"><c:out value="${prop.numpuertas}" /> Puertas</span>
                </div>
                <div class="profile-info-name">
                    <span class="editable" id="username"><c:out value="${prop.totalSpuertas}" /> m</span>
                </div>
                <div class="profile-info-name">cuadrados</div>
            </div> 
            <div class="profile-info-row">
                <div class="profile-info-value"> Total Superficie Armarios</div>
                <div class="profile-info-name">
                    <span class="editable" id="username"><c:out value="${prop.numarmarios}" /> Armarios</span>
                </div>
                <div class="profile-info-name">
                    <span class="editable" id="username"><c:out value="${prop.totalSarmarios}" /> m</span>
                </div>
                <div class="profile-info-name">cuadrados</div>
            </div> 
            <div class="profile-info-row">
                <div class="profile-info-value"> Total Superficie suelos</div>
                <div class="profile-info-name"></div>
                <div class="profile-info-name">
                    <span class="editable" id="username"><c:out value="${prop.totalSsuelos}" /> m</span>
                </div>
                <div class="profile-info-name">cuadrados</div>
            </div>     
            <div class="profile-info-row">
                <div class="profile-info-value"> Total Superficie Techos</div>
                <div class="profile-info-name"></div>
                <div class="profile-info-name">
                    <span class="editable" id="username"><c:out value="${prop.totalStechos}" /> m</span>
                </div>
                <div class="profile-info-name">cuadrados</div>
            </div>      
                 <div class="hr hr-dotted hr-16"><br/><br/><br/></div>    
        </div>   
    </div>
</div>

					</div><!-- /.row -->
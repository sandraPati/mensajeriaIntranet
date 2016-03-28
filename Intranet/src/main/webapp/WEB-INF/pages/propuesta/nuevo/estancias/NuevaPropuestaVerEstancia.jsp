<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<div class="page-content"> 
 		
<div class="row">
    <div class="col-xs-12">
        <ul class="steps  ">
                <li data-step="1 " class="active ">
                        <span class="step "><i class="ace-icon glyphicon glyphicon-ok bigger-100 light-green"></i></span>
                        <span class="title ">Seleccionar un Ciente</span>
                </li>

                <li data-step="2" class="active ">
                        <span class="step">2</span>
                        <span class="title">Registro de Estancias</span>
                </li>

                <li data-step="3">
                        <span class="step">3</span>
                        <span class="title">Presupuesto</span>
                </li>

                <li data-step="4">
                        <span class="step">4</span>
                        <span class="title">Envio de Presupuesto</span>
                </li>
                
        </ul>
    </div>
</div>
        
    <div class="row">
    <div class="col-xs-12">
        <ul class="steps  ">
                <li data-step="1 " class="active ">
                        <span class="step "><i class="ace-icon glyphicon glyphicon-ok bigger-100 light-green"></i></span>
                        <span class="title ">Nueva Estancia</span>
                </li>
                <li data-step="2" class="active ">
                        <span class="step"><i class="ace-icon glyphicon glyphicon-ok bigger-100 light-green"></i></span>
                        <span class="title">Registro de Paños</span>
                </li>
                <li data-step="2" class="active ">
                        <span class="step">2.3</span>
                        <span class="title">Ver Estancias</span>
                </li>
                
        </ul>
        

    </div>
</div>
    <div class="page-header">
        <h1>
           
                <small>
                    <i class="ace-icon fa fa-angle-double-right"></i> Estancias Registradas                  
                </small>
        </h1>
    </div>
    <br/>
     <br/>
    <div class="row">
        <div class="col-xs-12">
            <div class="tabbable">
                 <ul class="nav nav-tabs padding-12 tab-color-blue background-blue" id="myTab4">
                           
                    </ul>
                <div class="tab-content">
                            <div id="home4" class="tab-pane in active">
                                
                                
                               <div class="col-lg-12 align-right">
                               <a class=" btn btn-error btn-md" href="/Intranet/sup/NuevaPropuestaEstancias.htm?idP=${prop.id}" data-rel="tooltip">
                                    Registrar estancia

                                </a>
                                   
                                <c:if test="${not empty ltaEstancias}">    
                                <a class="btn btn-success  btn-md "  href="/Intranet/sup/NuevaPropuestaPresupuesto.htm?idP=${prop.id}">
                                   Paso 3 PRESUPUESTO<i class="ace-icon fa fa-arrow-right icon-on-right"></i>
                                </a>
                                   </c:if> 
                                </div>
                                     <br/><br/>
                                       <br/><br/>
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
                                                                <a class="blue tooltip-info" data-rel="tooltip" href="/Intranet/sup/NuevaPropuestaVerPanos.htm?idE=${item.id}" title="Consultar_Estancia">
                                                                                <i class="ace-icon fa fa-search-plus bigger-130"></i>
                                                                        </a> 
                                                                <a class="red tooltip-error" data-rel="tooltip" href="/Intranet/sup/NuevaPropuestaDeleteEstancia.htm?idE=${item.id}&idP=${prop.id}" title="Eliminar_Estancia">
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
<div class="page-header">
        <h1>
            Totales de Propuesta 
                <small>
                    <i class="ace-icon fa fa-angle-double-right"></i>                    
                </small>
        </h1>
    </div>
 <div class="table-responsive">
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
 </div>
                </div>
                   
                    </div>
            </div>
        </div>
        
    </div>
                                
</div><!-- /.row -->
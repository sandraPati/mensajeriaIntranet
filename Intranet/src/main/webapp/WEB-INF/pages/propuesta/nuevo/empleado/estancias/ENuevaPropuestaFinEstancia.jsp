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
                        <span class="step">2.2</span>
                        <span class="title">Registro de Paños</span>
                </li>
                <li data-step="2">
                        <span class="step">2.3</span>
                        <span class="title">VerPaños</span>
                </li>
                <li data-step="2">
                        <span class="step">2.4</span>
                        <span class="title">Ver Estancias</span>
                </li>
                
        </ul>
        

    </div>
</div>
    <div class="page-header">
        <h1>
           
                <small>
                    <i class="ace-icon fa fa-angle-double-right"></i> Registro de nueva estancia                   
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
                                 <div class="page-header">
                                <h1>
                                    Paño Registrado
                                    
                                </h1>
                                 </div>
                                <br/>
                                <a class=" btn btn-white btn-success" href="/Intranet/emp/ENuevaPropuestaPanos.htm?idE=${est}" data-rel="tooltip">
                                    NUEVO Paño

                              </a>
                              <a class=" btn btn-white btn-success" href="/Intranet/emp/ENuevaPropuestaFinPropuesta.htm?idE=${est}" data-rel="tooltip">
                                  Guardar y Registrar otra estancia
                              </a> 
                              <a class=" btn btn-white btn-success" href="/Intranet/emp/ENuevaPropuestaFinPropuesta2.htm?idE=${est}" data-rel="tooltip">
                                  Ver Estancias
                              </a>     
                </div>
                  
                    </div>
            </div>
        </div>
        
    </div>
</div><!-- /.row -->
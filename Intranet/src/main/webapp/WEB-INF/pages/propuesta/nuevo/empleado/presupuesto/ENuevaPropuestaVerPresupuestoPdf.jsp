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
                        <span class="step"><i class="ace-icon glyphicon glyphicon-ok bigger-100 light-green"></i></span>
                        <span class="title">Registro de Estancias</span>
                </li>

                <li data-step="3">
                        <span class="step"class="active "><i class="ace-icon glyphicon glyphicon-ok bigger-100 light-green"></i></span>
                        <span class="title">Presupuesto</span>
                </li>

                <li data-step="4">
                        <span class="step"class="active ">4</span>
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
                            <a class=" btn btn-white btn-warning" href="/Intranet/emp/ENuevaPropuestaPresupuesto.htm?idP=${idP}" data-rel="tooltip">
                                <i class="ace-icon fa fa-reply icon-only"></i>

                            </a> 
                                <a class="btn btn-success  btn-md "  href="/Intranet/emp/ENuevaPropuestaenviarPresupuesto.htm?idP=${idP}">
                                   Enviar Presupuesto<i class="ace-icon fa fa fa-envelope-o icon-on-right"></i>
                                </a>
                        </div>
                         <br/><br/> <br/>
                        <div >
                            <div>
                                  <iframe width="1060" height="900" src="/Intranet/emp/EpdfPresupuesto.htm?idP=${idP}" scrolling="no" frameborder="no" ></iframe>
                            </div>
                        </div>
                       <br/><br/><br/> 
                    </div>
                </div>
            </div>
        </div>
        
    </div>
                                
</div><!-- /.row -->
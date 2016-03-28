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
                            <form:form id="form1" action="" method="POST" commandName="pu" class="form-horizontal" role="form">
                   <form:hidden id="id" path="id" class="col-xs-10 col-sm-4" value="${pu.id}"/>
                   <form:hidden id="idpano" path="idpano.id" class="col-xs-10 col-sm-4" value="${pu.idpano.id}"/>
                          <div class="form-group" >
                            <label class="col-sm-1 control-label no-padding-right" for="form-field-1">Ventana N° ${vent.num}</label>
                            <form:hidden id="numV" path="num" class="col-xs-10 col-sm-4" />
                            <label class="col-sm-1 control-label no-padding-right" for="form-field-1">Medida standar</label>
                            <div class="col-sm-1">
                               <form:select class="ddl" name="estandar" id="estandar" attrmain="true"  path="estandar"> 
                                   <form:option value="1">0.60 x 2.1</form:option>
                                    <form:option value="2">0.70 x 2.1</form:option>
                                    <form:option value="3">0.80 x 2.1</form:option>
                                    <form:option value="4">0.90 x 2.1</form:option>
                                    <form:option value="5">Otro</form:option>
                                </form:select>
                            </div>
                            <div id="oculto" hidden="true">
                            <label class="col-sm-1 control-label no-padding-right" for="form-field-1">LARGO</label>
                            <div class="col-sm-1">
                                <form:input type="text" id="largopuerta" path="largo" class="col-xs-10 col-sm-12" />
                            </div>
                            
                            <label class="col-sm-1 control-label no-padding-right" for="form-field-1">ALTO</label>
                            <div class="col-sm-1">
                                <form:input type="text" id="altopuerta" path="alto" class="col-xs-10 col-sm-12" />
                            </div>
                            </div>
                            <label class="col-sm-1 control-label no-padding-right" for="form-field-1">SUPERFICIE</label>
                            <div class="col-sm-1">
                                <form:input type="text" id="superficiepuerta" path="superficie" class="col-xs-10 col-sm-12"  readonly="true"/>
                            </div>
                             <div class="col-sm-5">
                             <button type="submit" class="btn btn-primary btn-xs col-xs-12 col-sm-4 col-md-3 col-lg-3">Guardar</button>
                             </div> 
                        </div><br/><br/>
                        </form:form>
                </div>
                    
                    </div>
            </div>
        </div>
        
    </div>
</div><!-- /.row -->
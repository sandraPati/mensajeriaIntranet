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
                        <span class="step ">2.1</span>
                        <span class="title ">Nueva Estancia</span>
                </li>
                <li data-step="2">
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
            <form:form id="form1" class="form-horizontal" role="form" action="" method="POST" commandName="estancia">
               <form:hidden id="propuesta_id" path="propuesta_id.id" value="${prop}"/>
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">N°</label>

                        <div class="col-sm-9">
                            <form:input type="text" id="numero" path="numero" class="col-xs-10 col-sm-1" required="true"/>
                           
                        </div>
                </div>
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">Tipo de Estancia</label>

                        <div class="col-sm-9">
                        <form:select id="tipo_estancia_id" name="tipo_estancia_id" path="tipo_estancia_id.id" class="col-xs-10 col-sm-4" data-placeholder="Choose a State...">
                            <form:options items="${ltaTipoEstancia}" itemValue="id" itemLabel="nombre" />
                        </form:select>
                        </div>
                </div>
                <div class="form-group" id="Otro" hidden="true">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">Nombre</label>

                        <div class="col-sm-9">
                            <form:input type="text" id="otro_tipo" path="otro_tipo" class="col-xs-10 col-sm-4" />
                        </div>
                </div>
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">ALTO</label>

                        <div class="col-sm-9">
                            <form:input type="text" id="alto" path="alto" class="col-xs-10 col-sm-4" />
                        </div>
                </div>        
                <div class="form-group">
                        <label id="" class="col-sm-3 control-label no-padding-right" for="form-field-1">  </label>

                        <div class="col-sm-9">
                               <button type="submit" class="btn btn-primary col-xs-12 col-sm-4 col-md-3 col-lg-3">Agregar</button>
                        </div>
                </div>
                         
                <br/><br/>

                <div class="hr hr-dotted hr-16"></div>

        </form:form>
                </div>
                   
            </div>
        </div>
        
    </div>
</div><!-- /.row -->
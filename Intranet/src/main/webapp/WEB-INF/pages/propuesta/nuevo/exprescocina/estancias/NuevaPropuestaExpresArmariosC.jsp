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
           <form:form id="form1" class="form-horizontal" role="form" action="" method="POST" commandName="pa">
               <form:hidden path="id" value="${pa.id}"/>
           <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">¿TIENES ARMARIOS? </label>

                                        <div class="col-sm-9">

                                                <div class="radio">
                                                        <label>
                                                            <form:radiobutton id="armario1" path="armario" value="SI" class="ace"/>
                                                            
                                                                <span class="lbl"> SI</span>
                                                        </label>
                                                </div>

                                                <div class="radio">
                                                        <label>
                                                            <form:radiobutton id="armario2" path="armario" value="NO" class="ace" checked="true"/>
                                                             
                                                                <span class="lbl"> NO</span>
                                                        </label>
                                                </div>


                                        </div>
                                </div>
            
                <div id="Numarmarios">
                <div class="form-group" id="Otro">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">N° DE ARMARIOS: </label>
                        <div class="col-sm-1">
                           
                            <form:select id="numarmarios" name="numarmarios" path="numarmarios" >
                                <form:option value="1"></form:option>
                                <form:option value="2"></form:option>
                                <form:option value="3"></form:option>
                                <form:option value="4"></form:option>
                                <form:option value="5"></form:option>
                                <form:option value="6"></form:option>
                                <form:option value="7"></form:option>
                                <form:option value="8"></form:option>
                                <form:option value="9"></form:option>
                                <form:option value="10"></form:option>
                            </form:select>
                        </div>
                        
                </div>
                  
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> </label>
                    <div class="col-sm-8">
                        <button type="submit" class="btn btn-primary col-xs-12 col-sm-4 col-md-3 col-lg-3">Siguiente</button> 
                    </div> 
                </div>                                           
        </form:form>           
                </div>
                   
                    </div>
            </div>
        </div>
        
    </div>
</div><!-- /.row -->
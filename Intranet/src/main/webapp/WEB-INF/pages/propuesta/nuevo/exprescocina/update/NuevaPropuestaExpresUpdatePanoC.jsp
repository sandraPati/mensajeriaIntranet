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
            <form:form id="form1" class="form-horizontal" role="form" action="" method="POST" commandName="pa">
                <form:hidden id="id" path="id" />
                <form:hidden id="estancia_id" path="estancia_id.id" value="${pa.estancia_id.id}"/>
                <div class="form-group" id="Otro">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">N°</label>

                        <div class="col-sm-9">
                            <form:input type="text" id="numero" path="numero" class="col-xs-10 col-sm-4" required="true"/>
                        </div>
                </div>
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">Tipo de Paño</label>

                        <div class="col-sm-9">
                        <form:select id="tipo_pano_id" name="tipo_pano_id" path="tipo_pano_id.id" class="col-xs-10 col-sm-4" data-placeholder="Choose a State...">
                            <form:options items="${ltaTipoPano}" itemValue="id" itemLabel="nombre" />
                        </form:select>
                        </div>
                </div>
                <div class="form-group" id="forma"  hidden="true">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"></label>

                        <div class="col-sm-9">
                           
                            <div class="radio">
                                                        <label>
                                                            <form:radiobutton id="formapano1" path="formapano" value="1" class="ace" checked="true"/>
                                                            
                                                            <span class="lbl"><img src="/Intranet/resources/figuras/cuadrado.jpg" width="50"/></span>
                                                                
                                                        </label>
                                                         <label>
                                                            <form:radiobutton id="formapano2" path="formapano" value="2" class="ace" />
                                                            
                                                                <span class="lbl">  <img src="/Intranet/resources/figuras/rectangulo_1.jpg" width="170"/></span>
                                                                
                                                        </label>    
                                                        <label>
                                                            
                                                                <form:radiobutton id="formapano3" path="formapano" value="3" class="ace" />
                                                             
                                                                <span class="lbl">  <img src="/Intranet/resources/figuras/L.jpg" width="80"/></span>
                                                        </label>
                                                        <label>
                                                            
                                                                <form:radiobutton id="formapano4" path="formapano" value="4" class="ace" />
                                                             
                                                                <span class="lbl">  <img src="/Intranet/resources/figuras/rombo.jpg" width="50"/></span>
                                                        </label>
                                                       <label>
                                                            
                                                                <form:radiobutton id="formapano5" path="formapano" value="5" class="ace" />
                                                             
                                                                <span class="lbl"> <img src="/Intranet/resources/figuras/trapecio.jpg" width="120"/></span>
                                                        </label>          
                                                </div>
                        </div>
                </div>    
                <div class="form-group" id="ladoa">
                        <label id="labela"class="col-sm-3 control-label no-padding-right" for="form-field-1">ALTO</label>

                        <div class="col-sm-9">
                            <form:input type="text" id="a" path="alto" class="col-xs-10 col-sm-4" value="${est.alto}" required="true"/>
                        </div>
                </div>   
                
                <div class="form-group"  id="ladob">
                        <label id="labelb" class="col-sm-3 control-label no-padding-right" for="form-field-1">LARGO</label>

                        <div class="col-sm-9">
                            <form:input type="text" id="b" path="largo" class="col-xs-10 col-sm-4"/>
                        </div>
                </div>  
                
               
                <div class="form-group" hidden="true" id="ladoc">
                        <label id="labelc"class="col-sm-3 control-label no-padding-right" for="form-field-1">c</label>

                        <div class="col-sm-9">
                            <form:input type="text" id="c" path="lado3" class="col-xs-10 col-sm-4"/>
                        </div>
                </div>
                <div class="form-group" hidden="true" id="ladod">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">d</label>

                        <div class="col-sm-9">
                            <form:input type="text" id="d" path="lado4" class="col-xs-10 col-sm-4"/>
                        </div>
                </div>
                      
                
                
                <div class="form-group" >
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">SUPERFICIE</label>

                        <div class="col-sm-9">
                            <form:input type="text" id="superficie" path="superficie" class="col-xs-10 col-sm-4"  readonly="true"/>
                        </div>
                </div>
                      
                
                <div class="form-group">
                        <label id="" class="col-sm-3 control-label no-padding-right" for="form-field-1">  </label>

                        <div class="col-sm-9">
                               <button type="submit" class="btn btn-success col-xs-12 col-sm-4 col-md-3 col-lg-3">Siguiente</button>
                        </div>
                </div>
                         
                <br/><br/>

                <div class="hr hr-dotted hr-16"></div>

        </form:form>
                </div>
                    
                    </div>
            </div>
        </div>
        
    </div>
</div><!-- /.row -->
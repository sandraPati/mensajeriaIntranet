<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<div class="page-content"> 
 		
<div class="row">
    <div class="col-xs-12">
        <ul class="steps  ">
                <li data-step="1 " class="active ">
                        <span class="step ">1</span>
                        <span class="title ">Seleccionar un Ciente</span>
                </li>

                <li data-step="2">
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
                        <span class="title ">Seleccionar un Ciente</span>
                </li>
                <li data-step="2"  class="active ">
                        <span class="step">1.2</span>
                        <span class="title">Registro de Propuesta</span>
                </li>
                
        </ul>
        

    </div>
</div>
       <div class="page-header">
        <h1>
           
                <small>
                    <i class="ace-icon fa fa-angle-double-right"></i> Paso 1.2: Escoja la misma direccion del cliente o nueva direccion                   
                </small>
        </h1>
    </div>
    <br/>
     <br/>
     <div class="row">
    <div class="col-xs-12">
        <div class="col-sm-2"></div>
        <div class="col-sm-8">
           
                
                <blockquote class="pull-left">
                        <p>Informacion Cliente:</p>

                        <small>
                                <h6 class="text-info">NIF/NIE/PASAPORTE: <c:out value=" ${cliente.nif}" /></h6>
                                
                                <h6 class="text-info">Nombre: <c:out value="${cliente.nombre} " /></h6>
                                
                                <h6 class="text-info">Apellidos: <c:out value="${cliente.apellidos} " /></h6>
                                
                                <h6 class="text-info">Direccion: <c:out value="${cliente.direccion} " /></h6>
                                
                                <h6 class="text-info">Codigo Postal: <c:out value="${cliente.codigo_postal} " /></h6>
                                
                                <h6 class="text-info">EMAIL: <c:out value="${cliente.email} " /></h6>
                <div id="direccion" hidden="true"><c:out value="${cliente.direccion} " /></div>
                <div id="pais" hidden="true"><c:out value="${cliente.pais} " /></div>
                <div id="provincia" hidden="true"><c:out value="${cliente.provincia} " /></div>
                <div id="poblacion" hidden="true"><c:out value="${cliente.poblacion} " /></div>
                        </small>
                </blockquote>

        </div>
        
    </div>
    </div>  
    <div class="row">
        <div class="col-xs-12">
            <form:form id="form1" class="form-horizontal" role="form" action="" method="POST" commandName="prop">
                <form:hidden id="nifCliente" value="${cliente.nif}" path="nifCliente"/>
                
            <div class="form-group"> 
                <div class="col-sm-2"></div>
                <div class="col-sm-3">
                <div class="radio">
                    <label>
                        <input type="radio" id="tipo1" name="tipo" value="1" class="ace" checked="true"/>

                        <span class="lbl">Usar la misma direccion</span>

                    </label>
                    
                </div> 
                </div>    
                 <div class="col-sm-2">
                <div class="radio">
                    <label>
                        <input type="radio" id="tipo2" name="tipo" value="2" class="ace"/>

                        <span class="lbl">Nueva Direccion</span>

                    </label>
                    
                </div> 
                </div>    
            </div>             
            
               
                <div class="form-group">
                        <label class="col-sm-2 control-label no-padding-right" for="form-field-1"> </label>

                        <div class="col-sm-9">
                             <form:input id="descipcion" type="text" path="descipcion"  class="col-xs-10 col-sm-3" placeholder="Descripcion de La Propuesta" />
                             
                        </div>
                </div>
                <div class="form-group">
                        <label class="col-sm-2 control-label no-padding-right" for="form-field-1">  </label>

                        <div class="col-sm-9">
                            <form:input id="direccion2" type="text" path="direccion" value="${cliente.direccion}"class="col-xs-10 col-sm-3" placeholder="Direccion" required="true"/>
                               
                        </div>
                </div>
                <div class="form-group">
                        <label class="col-sm-2 control-label no-padding-right" for="form-field-1"> </label>

                        <div class="col-sm-9">
                            <form:input id="pais2" type="text" path="pais" value="${cliente.pais}"class="col-xs-10 col-sm-3" placeholder="Pais" />
                               
                        </div>
                </div>
               	
               
                <div class="form-group">
                        <label class="col-sm-2 control-label no-padding-right" for="form-field-1">  </label>

                        <div class="col-sm-10">
                            <form:input id="provincia2" type="text" path="provincia" value="${cliente.provincia}"class="col-xs-10 col-sm-4" placeholder="Provincia" required="true"/>
                              
                        </div>

                </div>
            <div class="form-group">
                        <label class="col-sm-2 control-label no-padding-right" for="form-field-1">  </label>

                        <div class="col-sm-10">
                            <form:input id="poblacion2" type="text" path="poblacion" value="${cliente.poblacion}"class="col-xs-10 col-sm-4" placeholder="Poblacion" required="true"/>
                              
                        </div>

                </div>
            </div>    
             <div class="form-group">
                 <div class="col-sm-2"></div>
                 <div class="col-sm-8 ">
                    <div class="clearfix form-actions">

                        <div class="col-md-offset-5 col-md-12">
                            <button id="btnsubmit" class="btn btn-info" type="submit">
                                        <i class="ace-icon fa fa-check bigger-110"></i>
                                        Siguiente
                                </button>

                            
                        </div>
                    </div>
                 </div>     
                 <div class="col-sm-2"></div>
            </div>
            </form:form>
        </div>

</div><!-- /.row -->
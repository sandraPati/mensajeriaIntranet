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
                        <span class="step ">1.1</span>
                        <span class="title ">Seleccionar un Ciente</span>
                </li>
                <li data-step="2">
                        <span class="step">1.2</span>
                        <span class="title">Registro de Propuesta</span>
                </li>
                
        </ul>
        

    </div>
</div>
    <div class="page-header">
        <h1>
           
                <small>
                    <i class="ace-icon fa fa-angle-double-right"></i> Busque un Cliente y ¡seleccionelo!, si es un nuevo Cliente ¡Registrelo!                   
                </small>
        </h1>
    </div>
    <br/>
     <br/>
    <div class="row">
        <div class="col-xs-12">
            <form id="form1" class="form-horizontal" role="form" action="" method="POST" >    
            <div class="form-group"> 
                <div class="col-sm-2"></div>
                <div class="col-sm-2">
                <div class="radio">
                    <label>
                        <input type="radio" id="tipo1" name="tipo" value="1" class="ace" checked="true"/>

                        <span class="lbl">Seleccione Cliente</span>

                    </label>
                    
                </div> 
                </div>    
                 <div class="col-sm-2">
                <div class="radio">
                    <label>
                        <input type="radio" id="tipo2" name="tipo" value="2" class="ace"/>

                        <span class="lbl">Nuevo Cliente</span>

                    </label>
                    
                </div> 
                </div>    
            </div>             
            <div class="form-group">
                        <div class="col-sm-2"></div>
                        <div class="col-sm-8">
                            <select class="chosen-select form-control" id="form-field-select-3" data-placeholder="Elegir Cliente...">
                                <option value="">  </option>
                                <c:forEach items="${clientesListbox}" var="item">                            
                                    <option value="<c:out value="${item.nif}" />"><c:out value="${item.nif}" /> <c:out value="${item.nombre}" /> <c:out value="${item.apellidos}" /></option>
                                </c:forEach> 
                            </select>
                        </div>
                        <div class="col-sm-2"></div>
            </div>
                       
            <div id="formC" hidden="true">
                <div class="form-group">
                        <label class="col-sm-2 control-label no-padding-right" for="form-field-1"> </label>

                        <div class="col-sm-9">
                          <input id="nif" type="text" class="col-xs-10 col-sm-3" placeholder="NIF" required="true"/>
                        </div>
                </div>
                <div class="form-group">
                        <label class="col-sm-2 control-label no-padding-right" for="form-field-1">  </label>

                        <div class="col-sm-10">
                            <input id="nombre" type="text" class="col-xs-10 col-sm-4" placeholder="Nombre"  required="true"/>
                            
                        </div>
                </div>
                <div class="form-group">
                        <label class="col-sm-2 control-label no-padding-right" for="form-field-1">  </label>

                        <div class="col-sm-10">
                             <input id="apellidos" type="text" class="col-xs-10 col-sm-4" placeholder="Apellidos" required="true"/>
                                
                        </div>
                </div>
                <div class="form-group">
                        <label class="col-sm-2 control-label no-padding-right" for="form-field-1">  </label>

                        <div class="col-sm-10">
                             <input id="direccion" type="text" class="col-xs-10 col-sm-7" placeholder="Direccion"  required="true"/>
                                
                        </div>
                </div>
                
                <div class="form-group">
                        <label class="col-sm-2 control-label no-padding-right" for="form-field-1">  </label>

                        <div class="col-sm-10">
                            <input id="pais" type="text" class="col-xs-10 col-sm-4" placeholder="Pais"required="true"/>
                            
                        </div>
                </div>
                <div class="form-group">
                        <label class="col-sm-2 control-label no-padding-right" for="form-field-1">  </label>

                        <div class="col-sm-10">
                            <input id="provincia" type="text" class="col-xs-10 col-sm-4" placeholder="Provincia" required="true"/>
                           
                        </div>
                </div>
                <div class="form-group">
                        <label class="col-sm-2 control-label no-padding-right" for="form-field-1">  </label>

                        <div class="col-sm-10">
                            <input id="poblacion" type="text" class="col-xs-10 col-sm-4" placeholder="Población" required="true"/>
                             
                        </div>
                </div>
                <div class="form-group">
                        <label class="col-sm-2 control-label no-padding-right" for="form-field-1">  </label>

                        <div class="col-sm-10">
                             <input id="nacionalidad" type="text" class="col-xs-10 col-sm-4" placeholder="Nacionalidad" required="true"/>
                            
                        </div>
                </div>
               
                <div class="form-group">
                        <label class="col-sm-2 control-label no-padding-right" for="form-field-1"> </label>

                        <div class="col-sm-9">
                             <input id="codigo_postal" type="text" class="col-xs-10 col-sm-3" placeholder="Codigo Postal" />
                             
                        </div>
                </div>
                <div class="form-group">
                        <label class="col-sm-2 control-label no-padding-right" for="form-field-1">  </label>

                        <div class="col-sm-9">
                            <input id="telefono" type="text" class="col-xs-10 col-sm-3" placeholder="Telefono" required="true"/>
                               
                        </div>
                </div>
                <div class="form-group">
                        <label class="col-sm-2 control-label no-padding-right" for="form-field-1"> </label>

                        <div class="col-sm-9">
                            <input id="otro_telefono" type="text" class="col-xs-10 col-sm-3" placeholder="Otro Telefono" />
                               
                        </div>
                </div>
               	
               
                <div class="form-group">
                        <label class="col-sm-2 control-label no-padding-right" for="form-field-1">  </label>

                        <div class="col-sm-10">
                            <input id="email" type="text" class="col-xs-10 col-sm-4" placeholder="email" required="true"/>
                              
                        </div>

                </div>
            </div>    
             <div class="form-group">
                 <div class="col-sm-2"></div>
                 <div class="col-sm-8 ">
                    <div class="clearfix form-actions">

                        <div class="col-md-offset-5 col-md-12">
                            <button id="btnsubmit" class="btn btn-info" type="submit" disabled="true">
                                        <i class="ace-icon fa fa-check bigger-110"></i>
                                        Siguiente
                                </button>

                            
                        </div>
                    </div>
                 </div>     
                 <div class="col-sm-2"></div>
            </div>
            </form>
        </div>

    </div>
</div><!-- /.row -->
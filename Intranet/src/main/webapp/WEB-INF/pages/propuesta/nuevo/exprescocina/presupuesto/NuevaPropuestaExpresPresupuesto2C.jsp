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

                <li data-step="3" class="active ">
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
        
   
    <br/>
    <div class="row">
       
<div class="col-xs-12">
    <div class="tabbable">
                 <ul class="nav nav-tabs padding-12 tab-color-blue background-blue" id="myTab4">
                        
                    </ul>
                <div class="tab-content">
                    
                            <div id="home4" class="tab-pane in active">
        <div class="col-lg-12 align-right">
            <a class=" btn btn-white btn-warning" href="/Intranet/sup/NuevaPropuestaExpresPresupuestoC.htm?idP=${p.id}" data-rel="tooltip">
                <i class="ace-icon fa fa-reply icon-only"></i>

            </a> 
        </div>
                 <br/><br/><br/>
        <!-- PAGE CONTENT BEGINS -->
           <form:form id="form1" class="form-horizontal" role="form" action="" method="POST" commandName="presup">
                
                <div class="form-group">
                        <label class="col-sm-1 control-label no-padding-right" for="form-field-1">CAPITULOS: </label>

                        <div class="col-sm-11">
                            <label class="control-label ">${cap.cod} ${cap.nombre} </label>
                            
                        </div>
                </div>
                <div class="form-group">
                        <label class="col-sm-1 control-label no-padding-right" for="form-field-1">SUB CAPITULOS: </label>

                        <div class="col-sm-11">
                      
                        <table id="dynamic-table2" class="table table-striped table-bordered table-hover table-condensed">
                             <thead>
                                <tr>
                                    
                                    <th>COD</th>
                                    <th>NOMBRE</th>
                                    <th>DESCRIPCION</th>
                                    <th>CANTIDAD</th>
                                    <th>Medida:</th>
                                    <th></th>
                                    <th></th>
                                    <th>Usar Lista Guardada de Panos</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${ltaSubCapitulos}" var="item">
                                <tr>
                                    <input type="hidden" name="presup_id" id="presup_id"value="${presup}"/>
                                    
                                    <td><c:out value="${item.subcapitulo.cod}" /></td>
                                    <td><c:out value="${item.subcapitulo.nombre}" /></td>
                                    <td><c:out value="${item.subcapitulo.nota}" /></td>
                                    <td><c:out value="${item.subcapitulo.cantidad}" /></td>
                                    <td><select class="ddl" name="tipoCantidad" id="tipoc" attrmain="true"> 
                                            <c:set value="0" var="r" scope="page"/>
                                            <c:if test="${item.tipoCantidad=='und.'}">
                                                <c:set value="1" var="r" scope="page"/>
                                                <option value="und." selected="true">und.</option>
                                                <option value="m2">m2</option>
                                                <option value="ml">m. lineales</option>
                                            </c:if>
                                            <c:if test="${item.tipoCantidad=='m2'}">
                                                <c:set value="1" var="r" scope="page"/>
                                                <option value="und.">und.</option>
                                                <option value="m2" selected="true">m2</option>
                                                <option value="ml">m. lineales</option>
                                            </c:if> 
                                            <c:if test="${item.tipoCantidad=='ml'}">
                                                <c:set value="1" var="r" scope="page"/>
                                                <option value="und.">und.</option>
                                                <option value="m2" >m2</option>
                                                <option value="ml" selected="true">m. lineales</option>
                                            </c:if>     
                                            <c:if test="${r==0}">     
                                                <option value="und.">und.</option>
                                                <option value="m2">m2</option>
                                                <option value="ml">m. lineales</option>
                                            </c:if>
                                        </select></td>
                                    <td>
                                        <c:if test="${item.id!=0}">
                                            <input type="checkbox" name="idSubCap" id="idSubCap" value="${item.subcapitulo.id}" class="chk" checked="true">
                                        </c:if>
                                        <c:if test="${item.id==0}">
                                        <input type="checkbox" name="idSubCap" id="idSubCap" value="${item.subcapitulo.id}" class="chk">
                                        </c:if>
                                    </td>    
                                    <td>
                                        <div id="SubCapCheck">
                                            <c:if test="${item.id!=0}">
                                                <div class="SubCapCheckIcon1">
                                            <a class="blue tooltip-info" data-rel="tooltip" href="/Intranet/sup/NuevaPropuestaExpresPresupuesto3C.htm?idP=${idP}&idPre=${presup}&idSC=${item.subcapitulo.id}" title="Registro_Medidas">
                                                <i class="ace-icon fa  fa-pencil-square-o bigger-130"></i>
                                            </a>
                                                 </div>
                                                
                                            </c:if>
                                            <div class="SubCapCheckIcon" hidden="true">
                                            <a class="blue tooltip-info" data-rel="tooltip" href="/Intranet/sup/NuevaPropuestaExpresPresupuesto3C.htm?idP=${idP}&idPre=${presup}&idSC=${item.subcapitulo.id}" title="Registro_Medidas">
                                                <i class="ace-icon fa  fa-pencil-square-o bigger-130"></i>
                                            </a>
                                                </div>
                                             
                                        </div>
                                        
                                     </td> 
                                     <td>
                                        <div id="SubCapCheck">
                                            
                                                <c:if test="${item.tipoCantidad=='m2' || item.tipoCantidad=='ml'}">
                                                   
                                                    <c:if test="${res!=0}">
                                                        <c:if test="${presm2!=item.subcapitulo.id}">
                                                    <div class="UsarPanosGuardado4" >
                                                    <a class="green tooltip-success" data-rel="tooltip"href="/Intranet/sup/NuevaPropuestaExpresPresupuestoasignarLtaGuardadaC.htm?idP=${idP}&idPre=${presup}&idSC=${item.subcapitulo.id}" title="Asignar_Panos_Guardados">
                                                        <i class=" ace-icon fa  fa-folder-open-o bigger-130"></i>
                                                    </a>
                                                        </div> 
                                                        </c:if>
                                                        </c:if>
                                                
                                            
                                            <div class="UsarPanosGuardado3" hidden="true">
                                                <c:if test="${res!=0}">
                                            <a class="green tooltip-success" data-rel="tooltip"href="/Intranet/sup/NuevaPropuestaExpresPresupuestoasignarLtaGuardadaC.htm?idP=${idP}&idPre=${presup}&idSC=${item.subcapitulo.id}" title="Asignar_Panos_Guardados">
                                                <i class=" ace-icon fa  fa-folder-open-o bigger-130"></i>
                                            </a>
                                                </c:if>
                                                </div> 
                                                    </c:if>
                                            
                                        </div>
                                        
                                     </td>
                                     <td>
                                    <div  class="guardarPanos">
                                    <c:if test="${item.tipoCantidad!='und.'}">
                                           <c:if test="${item.tienePanosM2!=0}">
                                                    
                                                        
                                                    <c:if test="${presm2==item.subcapitulo.id}">
                                                        <div class="presupuestom1">
                                                        <div class="radio">
                                                            <label>
                                                                <input type="radio" id="presupuestom" name="presupuestom2" value="${item.subcapitulo.id}" class="chk2 ace" checked="true"/>
                                                                <span class="lbl"> </span>
                                                            </label>
                                                        </div>  
                                                        </div>
                                                    </c:if>
                                                    <c:if test="${presm2!=item.subcapitulo.id}">
                                                        <div class="presupuestom2">
                                                        <div class="radio">
                                                            <label>
                                                                <input type="radio" id="presupuestom" name="presupuestom2" value="${item.subcapitulo.id}" class="chk2 ace" />
                                                                <span class="lbl"> </span>
                                                            </label>
                                                        </div>
                                                        </div>

                                                    </c:if>
                                                          
                                                </c:if>
                                                
                                            </c:if>
                                                           
                                    </div>
                                    
                                         
                                </td>
                                       
                                </tr> 
                                </c:forEach>
                               

                            </tbody>
                        </table>
                            
                        </div>
                </div>
              
               
                  
                
                         
                <br/><br/>

                <div class="hr hr-dotted hr-16"></div>

        </form:form>
                             </div></div>
    </div>
</div>
</div>	
</div><!-- /.row -->
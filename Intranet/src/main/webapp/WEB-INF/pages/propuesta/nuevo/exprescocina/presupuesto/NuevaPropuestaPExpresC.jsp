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
                                
                                <div class="col-lg-12 align-right">
            <a class=" btn btn-white btn-warning" href="/Intranet/sup/NuevaPropuestaExpresVerPanosC.htm?idE=${pex.idestancia}" data-rel="tooltip">
                <i class="ace-icon fa fa-reply icon-only"></i>

            </a> 
              <a class="btn btn-success  btn-md "  href="/Intranet/sup/NuevaPropuestaExpresPresupuestoC.htm?idP=${idP}">
                Paso 3 Ver Presupuesto <i class="ace-icon fa fa-arrow-right icon-on-right"></i>
             </a>  
        </div>
                 <br/><br/><br/>
            <form id="form1" class="form-horizontal" role="form" action="" method="POST">
                            <input type="hidden" id="id" value="${pex.id}" />
                            <input type="hidden" id="idpropuesta" value="${pex.idpropuesta}" />
                            <input type="hidden" id="idestancia" value="${pex.idestancia}"/>
                        <div class="form-group">
                            <div class="col-sm-1"></div>
                            <div class="col-sm-11">
                                 
                            <h3 class="header blue lighter smaller">
                                    <i class="ace-icon fa fa-asterisk"></i>
                                    Medidas
                            </h3>
                            </div>
                        </div>    
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1">Paños(PP) </label>
                            <div class="col-sm-9">
                                <div class="clearfix">
                                    
                                <div class="table-responsive">
                                    <table id="dynamic-table2" class="table table-striped table-bordered table-hover table-condensed">
                                        <thead>
                                            <tr>

                                                <th>NOMBRE Paños por Estancia</th>
                                                <th>LARGO</th>
                                                <th>ALTO</th>
                                                
                                                <th>SUPERFICIE</th>
                                                <th>Altura Media</th>
                                                <th></th>
                                            </tr>
                                        </thead>

                                        <tbody>
                                            <c:forEach items="${ltaPanos}" var="item">
                                                <tr>

                                                    <c:if test="${item.tipo_pano_id.id==1}">
                                                        <td>
                                                             <c:out value="${item.nombrepano}" />
                                                        </td>
                                                        <td><c:out value="${item.largo}" /></td>
                                                        <td><c:out value="${item.alto}" /></td>
                                                        <td><c:out value="${item.superficie}" /></td>
                                                        <td><input type="text" class="ddl" value="${item.largopresupuesto}"></td>
                                                        <td>
                                                            
                                                            <div class="checkbox">
                                                                    <label>
                                                                        <c:if test="${item.ageregado==1}">
                                                                            <input name="idpano" id="idpano" name="form-field-checkbox" type="checkbox" value="${item.id}" class="chk ace"  checked="true"/>
                                                                        </c:if>
                                                                        <c:if test="${item.ageregado==0}">
                                                                            <input name="idpano" id="idpano" name="form-field-checkbox" type="checkbox" value="${item.id}" class="chk ace" />
                                                                        </c:if>
                                                                            <span class="lbl"> </span>
                                                                    </label>
                                                            </div>
                                                        </td>
                                                    </c:if> 
                                                    <c:if test="${item.tipo_pano_id.id==2}">
                                                        <c:set value="${item.id}" var="panosuelo" scope="page"/>
                                                    </c:if>
                                                    <c:if test="${item.tipo_pano_id.id==3}">
                                                        <c:set value="${item.id}" var="panotecho" scope="page"/>
                                                    </c:if>
                                                </tr>
                                            </c:forEach> 


                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            
                        </div>  
                            </div>
                        <div class="form-group">
                            
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"></label>
                            <div class="col-sm-9">
                               <div class="radio">
                                   <c:if test="${pex.panotipo==1}">
                                    <label>
                                        <input type="radio" id="panotipo1" name="panotipo" value="1" class="ace" checked="true"/>

                                        <span class="lbl">Pared Pintado (PPP)</span>
                                    </label>    
                                    <label>
                                        <input type="radio" id="panotipo2" name="panotipo" value="2" class="ace"/>

                                        <span class="lbl">Pared Alicatado (PPA)</span>
                                    </label>
                                   </c:if>
                                   <c:if test="${pex.panotipo==2}">
                                    <label>
                                        <input type="radio" id="panotipo1" name="panotipo" value="1" class="ace"/>

                                        <span class="lbl">Pared Pintado (PPP)</span>
                                    </label>    
                                    <label>
                                        <input type="radio" id="panotipo2" name="panotipo" value="2" class="ace" checked="true"/>

                                        <span class="lbl">Pared Alicatado (PPA)</span>
                                    </label>
                                   </c:if>
                                   <c:if test="${pex.panotipo==0}">
                                    <label>
                                        <input type="radio" id="panotipo1" name="panotipo" value="1" class="ace"/>

                                        <span class="lbl">Pared Pintado (PPP)</span>
                                    </label>    
                                    <label>
                                        <input type="radio" id="panotipo2" name="panotipo" value="2" class="ace"/>

                                        <span class="lbl">Pared Alicatado (PPA)</span>
                                    </label>
                                   </c:if>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Mobiliario existente (MOBE)</label>

                            <div class="col-sm-9">
                               <input type="text" id="mobe" name="mobe"  class="ace" value="${pex.mobe}"/>

                            </div>
                        </div> 
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Mobiliario Nuevo (MOBN)</label>

                            <div class="col-sm-9">
                               <input type="text" id="mobn" name="mobn"  class="ace" value="${pex.mobn}"/>

                            </div>
                        </div> 
                        <div class="form-group">
                            <input type="hidden" id="panosuelo" value="${panosuelo}"/>
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1">¿Cambiar Falso Techo? </label>

                            <div class="col-sm-9">
                                <div class="radio">
                                    <c:if test="${pex.cambiarfalsotecho==1}">
                                    <label>
                                        <input type="radio" id="cambiarfalsotecho1" name="cambiarfalsotecho" value="1" class="ace" checked="true"/>

                                        <span class="lbl">SI</span>
                                    </label>    
                                    <label>
                                        <input type="radio" id="cambiarfalsotecho2"  name="cambiarfalsotecho" value="0" class="ace"/>

                                        <span class="lbl">NO</span>
                                    </label>
                                    </c:if>
                                    <c:if test="${pex.cambiarfalsotecho==0}">
                                    <label>
                                        <input type="radio" id="cambiarfalsotecho1" name="cambiarfalsotecho" value="1" class="ace" />

                                        <span class="lbl">SI</span>
                                    </label>    
                                    <label>
                                        <input type="radio" id="cambiarfalsotecho2"  name="cambiarfalsotecho" value="0" class="ace"checked="true"/>

                                        <span class="lbl">NO</span>
                                    </label>
                                    </c:if>
                                </div>
                                
                            </div>
                        </div>
                        <div class="form-group" id="ft" hidden="true">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> </label>

                            <div class="col-sm-9">
                                <input type="text" id="falsotechopano" name="falsotechopano"  class="ace" value="${panotecho}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Ventanas (V)</label>

                            <div class="col-sm-9">
                                <div class="clearfix">
                               N° <input type="text" id="nventana" name="nventana"  class="ace" value="${pex.nventana}"/>
                                
                              
                               </div>
                            </div>
                        </div>    
                            <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1">Puerta (P)</label>
                            <div class="col-sm-9">
                               N°<input type="text" id="puerta" name="puerta"  class="ace" value="${pex.puerta}"/>

                            </div>
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"></label>
                            <div class="col-sm-9">
                               <div class="radio">
                                   <c:if test="${pex.puertatipo==0}">
                                    <label>
                                        <input type="radio" id="puertatipo1" name="puertatipo" value="0" class="ace" checked="true"/>

                                        <span class="lbl">Corredera (PC)</span>
                                    </label>    
                                    <label>
                                        <input type="radio" id="puertatipo2" name="puertatipo" value="1" class="ace"/>

                                        <span class="lbl">Normal (PN)</span>
                                    </label>
                                   </c:if>
                                   <c:if test="${pex.puertatipo==1}">
                                    <label>
                                        <input type="radio" id="puertatipo1" name="puertatipo" value="0" class="ace"/>

                                        <span class="lbl">Corredera (PC)</span>
                                    </label>    
                                    <label>
                                        <input type="radio" id="puertatipo2" name="puertatipo" value="1" class="ace" checked="true"/>

                                        <span class="lbl">Normal (PN)</span>
                                    </label>
                                   </c:if>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-1"></div>
                            <div class="col-sm-11">
                                 
                            <h3 class="header blue lighter smaller">
                                    <i class="ace-icon fa fa-asterisk"></i>
                                    Electricidad
                            </h3>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Puntos de Luz (PL)</label>

                            <div class="col-sm-9">
                               <input type="text" id="puntosluz" name="puntosluz"  class="ace" value="${pex.puntosluz}"/>

                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Puntos de Enchufe (PE)</label>

                            <div class="col-sm-9">
                               <input type="text" id="puntosenchufe" name="puntosenchufe"  class="ace" value="${pex.puntosenchufe}"/>

                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Puntos de Vitroceramica y Horno (PVH)</label>

                            <div class="col-sm-9">
                               <input type="text" id="puntospvh" name="puntospvh"  class="ace" value="${pex.puntospvh}"/>

                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Puntos de Television (PTV)</label>

                            <div class="col-sm-9">
                               <input type="text" id="puntosptv" name="puntosptv"  class="ace" value="${pex.puntosptv}"/>

                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Puntos para Telefonillo (PTT)</label>

                            <div class="col-sm-9">
                               <input type="text" id="puntosptt" name="puntosptt"  class="ace" value="${pex.puntosptt}"/>

                            </div>
                        </div> 
                               <div class="form-group">
                            
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1">Instalacion de GAS</label>
                            <div class="col-sm-9">
                               <div class="radio">
                                   <c:if test="${pex.igg==0}">
                                    <label>
                                        <input type="radio" id="igg1" name="igg" value="1" class="ace"/>

                                        <span class="lbl">SI</span>
                                    </label>    
                                    <label>
                                        <input type="radio" id="igg2" name="igg" value="0" class="ace" checked="true"/>

                                        <span class="lbl">NO</span>
                                    </label>
                                   </c:if>
                                   <c:if test="${pex.igg==1}">
                                    <label>
                                        <input type="radio" id="igg1" name="igg" value="1" class="ace"checked="true"/>

                                        <span class="lbl">SI</span>
                                    </label>    
                                    <label>
                                        <input type="radio" id="igg2" name="igg" value="0" class="ace" />

                                        <span class="lbl">NO</span>
                                    </label>
                                   </c:if>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-1"></div>
                            <div class="col-sm-11">
                                 
                            <h3 class="header blue lighter smaller">
                                    <i class="ace-icon fa fa-asterisk"></i>
                                    Calefacción
                            </h3>
                            </div>
                        </div>   
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Radiador (R)</label>

                            <div class="col-sm-9">
                               <input type="text" id="nradiador" name="nradiador"  class="ace" value="${pex.nradiador}"/>
                               
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> </label>

                            <div class="col-sm-9">
                                <div class="radio">
                                    <c:if test="${pex.radiadortipo==1}">
                                    <label>
                                        <input type="radio" id="radiadortipo1" name="radiadortipo" value="1" class="ace" checked="true"/>

                                        <span class="lbl">Conservar (RE)</span>
                                    </label>    
                                    <label>
                                        <input type="radio" id="radiadortipo2" name="radiadortipo" value="2" class="ace"/>

                                        <span class="lbl">Cambiar por uno Nuevo (RN)</span>
                                    </label>
                                    </c:if>
                                    <c:if test="${pex.radiadortipo==2}">
                                    <label>
                                        <input type="radio" id="radiadortipo1" name="radiadortipo" value="1" class="ace"/>

                                        <span class="lbl">Conservar (RE)</span>
                                    </label>    
                                    <label>
                                        <input type="radio" id="radiadortipo2" name="radiadortipo" value="2" class="ace" checked="true"/>

                                        <span class="lbl">Cambiar por uno Nuevo (RN)</span>
                                    </label>
                                    </c:if>
                                    <c:if test="${pex.radiadortipo==0}">
                                    <label>
                                        <input type="radio" id="radiadortipo1" name="radiadortipo" value="1" class="ace"/>

                                        <span class="lbl">Conservar (RE)</span>
                                    </label>    
                                    <label>
                                        <input type="radio" id="radiadortipo2" name="radiadortipo" value="2" class="ace"/>

                                        <span class="lbl">Cambiar por uno Nuevo (RN)</span>
                                    </label>
                                    </c:if>
                                </div>
                            </div>
                         </div>
                         <div class="form-group">
                            <div class="col-sm-1"></div>
                            <div class="col-sm-11">
                                 
                            <h3 class="header blue lighter smaller">
                                    <i class="ace-icon fa fa-asterisk"></i>
                                    Fontaneria
                            </h3>
                            </div>
                        </div>
                            <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Total de Puntos (PF)</label>

                            <div class="col-sm-9">
                               <input type="text" id="fontaneriapuntos" name="fontaneriapuntos" value="${pex.fontaneriapuntos}" class="ace"/>
                               
                            </div>
                        </div>
                        
                        
                            <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1">¿Eliminar algun elemento?</label>

                            <div class="col-sm-9">
                               <div class="radio">
                                   <c:if test="${pex.eliminar==1}">
                                            <label>
                                                <input type="radio" id="eliminar1" name="eliminar" value="1" class="ace" checked="true"/>

                                                <span class="lbl">SI</span>
                                            </label>    
                                            <label>
                                                <input type="radio" id="eliminar2"  name="eliminar" value="0" class="ace"/>

                                                <span class="lbl">NO</span>
                                            </label>
                                   </c:if>    
                                   <c:if test="${pex.eliminar==0}">
                                            <label>
                                                <input type="radio" id="eliminar1" name="eliminar" value="1" class="ace"/>

                                                <span class="lbl">SI</span>
                                            </label>    
                                            <label>
                                                <input type="radio" id="eliminar2"  name="eliminar" value="0" class="ace"  checked="true"/>

                                                <span class="lbl">NO</span>
                                            </label>
                                   </c:if>
                                        </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"></label>

                            <div class="col-sm-9">
                               <input type="text"name="eliminarcual" id="eliminarcual" value="${pex.eliminarcual}"/>
                            </div>
                        </div>
                            <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Llaves de corte</label>

                            <div class="col-sm-9">
                               <div class="radio">
                                   <c:if test="${pex.llavecorte==1}">
                                            <label>
                                                <input type="radio" id="llavecorte1" name="llavecorte" value="1" class="ace" checked="true"/>

                                                <span class="lbl">SI</span>
                                            </label>    
                                            <label>
                                                <input type="radio" id="llavecorte2" name="llavecorte" value="0" class="ace"/>

                                                <span class="lbl">NO</span>
                                            </label>
                                   </c:if>  
                                   <c:if test="${pex.llavecorte==0}">
                                            <label>
                                                <input type="radio" id="llavecorte1" name="llavecorte" value="1" class="ace" />

                                                <span class="lbl">SI</span>
                                            </label>    
                                            <label>
                                                <input type="radio" id="llavecorte2" name="llavecorte" value="0" class="ace" checked="true"/>

                                                <span class="lbl">NO</span>
                                            </label>
                                   </c:if>  
                                        </div>
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <div class="col-sm-1"></div>
                            <div class="col-sm-11">
                                 
                            <h3 class="header blue lighter smaller">
                                    <i class="ace-icon fa fa-asterisk"></i>
                                    Albañileria
                            </h3>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Demoler muro (DM)</label>

                            <div class="col-sm-9">
                               <input type="text" id="demolermuro"  name="demolermuro"  class="ace" value="${pex.demolermuro}"/>
                               
                            </div>
                        </div>  
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Falso techo nuevo (FTN)</label>

                            <div class="col-sm-9">
                               <input type="text" id="falsotechonuevo" name="falsotechonuevo"  class="ace" value="${pex.falsotechonuevo}"/>
                               
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> </label>
                            <div class="col-sm-8">
                                <button type="button" id="btn_enviar" class="btn btn-primary col-xs-12 col-sm-4 col-md-3 col-lg-3">Guardar</button> 
                            </div> 
                        </div> 
                            <br/><br/>
                            </form>
                </div>
                    
                    </div>
            </div>
        </div>
        
    </div>
</div><!-- /.row -->
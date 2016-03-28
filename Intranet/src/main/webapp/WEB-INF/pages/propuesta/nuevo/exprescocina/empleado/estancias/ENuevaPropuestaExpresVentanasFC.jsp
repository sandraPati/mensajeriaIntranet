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
            <c:set value="${pa.numventanas}" var="n" scope="page" />
                      <c:forEach var="i" begin="1" end="${n}">
                          <c:set value="0" var="nVen" scope="page" />
                            <c:forEach items="${ltaventana}" var="item">
                               <c:if test="${item.num==i}">
                                   <c:set value="1" var="nVen" scope="page"/>
                                   <label class="col-sm-3 control-label no-padding-right" for="form-field-1">Ventana N° ${item.num}</label>
                                    <label class="col-sm-3 control-label no-padding-right" for="form-field-1">largo: ${item.largo}</label>
                                    <label class="col-sm-3 control-label no-padding-right" for="form-field-1">alto: ${item.alto}</label>
                                    <label class="col-sm-3 control-label no-padding-right" for="form-field-1">Superficie ${item.superficie}</label>
                                    <br/><br/>
                               </c:if>    
                            </c:forEach>
                              
                        <c:if test="${nVen==0}">    
                            
                        <form:form id="form${i}"action="" method="POST" commandName="vent">
                          <div class="form-group" >
                            <label class="col-sm-1 control-label no-padding-right" for="form-field-1">Ventana N° ${i}</label>
                            <form:hidden id="numV" path="num" value="${i}" class="col-xs-10 col-sm-4" />
                            <form:hidden id="idpano" path="idpano.id" value="${pa.id}" class="col-xs-10 col-sm-4" />
                            <label class="col-sm-1 control-label no-padding-right" for="form-field-1">LARGO</label>
                            <div class="col-sm-1">
                                <form:input type="text" id="largoventana${i}" path="largo" class="col-xs-10 col-sm-12" />
                            </div>
                            
                            <label class="col-sm-1 control-label no-padding-right" for="form-field-1">ALTO</label>
                            <div class="col-sm-1">
                                <form:input type="text" id="altoventana${i}" path="alto" class="col-xs-10 col-sm-12" />
                            </div>
                            
                            <label class="col-sm-1 control-label no-padding-right" for="form-field-1">SUPERFICIE</label>
                            <div class="col-sm-1">
                                <form:input type="text" id="superficieventana${i}" path="superficie" class="col-xs-10 col-sm-12"  readonly="true"/>
                            </div>
                             <div class="col-sm-5">
                             <button type="submit" class="btn btn-primary btn-xs col-xs-12 col-sm-4 col-md-3 col-lg-3">Guardar</button>
                             </div> 
                        </div><br/><br/>
                        </form:form>
                          </c:if> 
                     </c:forEach>
                </div>
                   
                    </div>
            </div>
        </div>
        
    </div>
</div><!-- /.row -->
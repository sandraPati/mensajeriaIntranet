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
        <a class=" btn btn-white btn-warning" href="/Intranet/emp/ENuevaPropuestaPresupuesto4.htm?idP=${idP}&idPre=${idPre}&idSC=${idSC}" data-rel="tooltip">
            <i class="ace-icon fa fa-reply icon-only"></i>

        </a>
                                </div>
        <!-- PAGE CONTENT BEGINS -->
           <form:form id="form1" class="form-horizontal" role="form" action="" method="POST" commandName="presup">
                <form:hidden id="id" path="id" value="${presup.id}"/>  
                <form:hidden id="presup_id" path="presup_id" value="${presup.presup_id}"/>
                <form:hidden id="capitulo" path="capitulo.id" value="${presup.capitulo.id}"/>
                <form:hidden id="idSubCap" path="idSubCap" value="${presup.idSubCap}"/>
                <form:hidden id="prop" path="prop" value="${presup.prop}"/>
                <form:hidden id="tipoCantidad" path="tipoCantidad" value="m2"/>
                
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">CAPITULOS: </label>

                        <div class="col-sm-9">
                            <label class="control-label ">${presup.capitulo.cod} ${presup.capitulo.nombre} </label>
                            
                        </div>
                </div>
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">SUB CAPITULOS: </label>

                        <div class="col-sm-9">
                            <label class="control-label ">${presup.subcapitulo.cod} ${presup.subcapitulo.nombre} </label>
                            
                        </div>
                </div>
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">NOTA: </label>

                        <div class="col-sm-9">
                            <label class="control-label ">${presup.subcapitulo.nota} </label> 
                        </div>
                </div>              
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">Registrar por: </label>

                        <div class="col-sm-9">
                            <label class="control-label ">m2 </label>
                            
                        </div>
                </div>            
                
                
                <div class="form-group" id="Otro">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">DESCRIPCION:</label>

                        <div class="col-sm-9">
                            <form:input type="text" id="descripcion" path="descripcion" class="col-xs-10 col-sm-4" />
                        </div>
                </div>
                <div class="form-group" id="Otro">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">metros/und</label>

                        <div class="col-sm-9">
                            <form:input type="text" id="cantidad" path="cantidad" class="col-xs-10 col-sm-4" readonly="true"/>
                        </div>
                </div>
                        
                <div class="form-group" id="Otro">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">PRECIO</label>

                        <div class="col-sm-9">
                            <form:input type="text" id="precio" path="precio" value="${presup.subcapitulo.cantidad}" class="col-xs-10 col-sm-4"  readonly="true"/>
                        </div>
                </div>
                <div class="form-group" id="Otro">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">MONTO</label>

                        <div class="col-sm-9">
                            <form:input type="text" id="monto" path="monto" class="col-xs-10 col-sm-4" readonly="true"/>
                        </div>
                </div>
                <div class="form-group">
                        <label id="" class="col-sm-3 control-label no-padding-right" for="form-field-1">  </label>

                        <div class="col-sm-9">
                               <button type="submit" class="btn btn-success col-xs-12 col-sm-4 col-md-3 col-lg-3">Actualizar</button>
                        </div>
                </div>
                         
                <br/><br/>

                <div class="hr hr-dotted hr-16"></div>

        </form:form>
                            </div></div></div>
</div>
</div>	
</div><!-- /.row -->
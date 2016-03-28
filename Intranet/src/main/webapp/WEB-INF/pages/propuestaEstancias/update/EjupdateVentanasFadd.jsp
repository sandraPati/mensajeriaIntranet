<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<div class="page-content">   
<div class="page-header">
   
        <h1>
            Agregar VENTANAS:
            <small>
                    <i class="ace-icon fa fa-angle-double-right"></i>
                    
            </small>
        </h1>
        
</div><!-- /.page-header -->
 		
<div class="row">
    
    <div class="col-xs-12">
          
                  <form:form id="form1" action="" method="POST" commandName="vent" class="form-horizontal" role="form">
                   
                   <form:hidden id="idpano" path="idpano.id" class="col-xs-10 col-sm-4" value="${vent.idpano.id}"/>
                          <div class="form-group" >
                            <label class="col-sm-1 control-label no-padding-right" for="form-field-1">Ventana N°:</label>
                            <div class="col-sm-1">
                                <form:input type="text" id="num" path="num" class="col-xs-10 col-sm-12" />
                            </div>
                            
                            <label class="col-sm-1 control-label no-padding-right" for="form-field-1">LARGO</label>
                            <div class="col-sm-1">
                                <form:input type="text" id="largoventana1" path="largo" class="col-xs-10 col-sm-12" />
                            </div>
                            
                            <label class="col-sm-1 control-label no-padding-right" for="form-field-1">ALTO</label>
                            <div class="col-sm-1">
                                <form:input type="text" id="altoventana1" path="alto" class="col-xs-10 col-sm-12" />
                            </div>
                            
                            <label class="col-sm-1 control-label no-padding-right" for="form-field-1">SUPERFICIE</label>
                            <div class="col-sm-1">
                                <form:input type="text" id="superficieventana1" path="superficie" class="col-xs-10 col-sm-12"  readonly="true"/>
                            </div>
                             <div class="col-sm-4">
                             <button type="submit" class="btn btn-primary btn-xs col-xs-12 col-sm-4 col-md-3 col-lg-3">Guardar</button>
                             </div> 
                        </div><br/><br/>
                        </form:form>
    </div>
</div>	

					</div><!-- /.row -->
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<div class="page-content">  
 
<div class="page-header">
   
        <h1>
            Tiene Armarios
            <small>
                    <i class="ace-icon fa fa-angle-double-right"></i>
                    ${pa.estancia_id.numero} ${pa.estancia_id.tipo_estancia_id.nombre} 
            </small>
        </h1>
        
</div><!-- /.page-header -->
 		
<div class="row">
    
    <div class="col-xs-12">
        <form:form id="form1" class="form-horizontal" role="form" action="" method="POST" commandName="pa">
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
            
                 <div id="Numarmarios" hidden="true">
                <div class="form-group" id="Otro">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">N° DE VENTANAS: </label>
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

					</div><!-- /.row -->

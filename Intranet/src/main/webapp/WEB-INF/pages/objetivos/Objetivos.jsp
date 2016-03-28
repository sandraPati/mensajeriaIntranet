<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 

<div class="page-content">

<div class="page-header">
    <h1>
        OBJETIVOS
        <small>
                <i class="ace-icon fa fa-angle-double-right"></i>
               ${emp.nif}  ${emp.apellidos},  ${emp.nombre} 
        </small>
    </h1>
</div><!-- /.page-header -->
<div class="row">
        <div class="col-xs-12">
                <!-- PAGE CONTENT BEGINS -->
               <form:form id="form1" class="form-horizontal" role="form" action="" method="POST" commandName="obj">
                
                        <!-- #section:elements.form -->
                        <div class="form-group">
                          <form:hidden id="id"  path="id" />      
                           <form:hidden id="nif_empleado"  path="nif_empleado" value="${obj.nif_empleado}"/>
                        </div>
                        <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-1">N° de Visitas</label>

                                <div class="col-sm-9">
                                    <form:input id="num_visitas" type="text" class="col-xs-10 col-sm-5" placeholder="" path="num_visitas" required="true"/>
                                    
                                </div>
                        </div>
                        <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-1">N° de Presupuestos </label>

                                <div class="col-sm-9">
                                    <form:input id="num_presupuesto" type="text" class="col-xs-10 col-sm-5" placeholder="" path="num_presupuesto" required="true"/>
                                    
                                </div>
                        </div>            
                        <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> N° de Contratos </label>

                                <div class="col-sm-9">
                                    <form:input id="num_contratos" type="text" class="col-xs-10 col-sm-5" placeholder="" path="num_contratos" required="true"/>
                                    
                                </div>
                        </div>
                        <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Importe </label>

                                <div class="col-sm-9">
                                     <form:input id="importe" type="text" class="col-xs-10 col-sm-5" placeholder="" path="importe" />
                                     
                                </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> </label>

                                <div class="col-sm-9">
                                       <button type="subtmit" class="btn btn-info col-xs-12 col-sm-4 col-md-3 col-lg-5">Asignar</button>
                                </div>
                        </div>
                       
                  </form:form>              
                
        </div>
</div>

 
</div>

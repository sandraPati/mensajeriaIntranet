<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  


<div class="page-content">  
 
<div class="page-header">
    <div class="row">
        <div class="col-lg-8">
        <h1>
        Nueva Propuesta
        <small>
                <i class="ace-icon fa fa-angle-double-right"></i>
                ${cliente.nif} ${cliente.nombre} ${cliente.apellidos} 
        </small>
    </h1>
        </div>
         <div class="col-lg-4 align-right">
            <a class=" btn btn-white btn-warning" href="/Intranet/emp/EverPropuestas.htm?nifC=${cliente.nif}" data-rel="tooltip">
                <i class="ace-icon fa fa-reply icon-only"></i>

            </a>
            
        </div>
             
             
    </div>
</div><!-- /.page-header -->
 		
<div class="row">
<div class="col-xs-12">
        <!-- PAGE CONTENT BEGINS -->
          <form:form id="form1" class="form-horizontal" role="form" action="" method="POST" commandName="prop">
                <form:hidden id="cliente_nif" path="cliente_nif.nif" value="${cliente.nif}"/>
                
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">DESCRIPCION de la Propuesta</label>

                        <div class="col-sm-9">
                          <form:input id="descipcion" type="text" class="col-xs-10 col-sm-5" placeholder="Descripcion" path="descipcion"/>
                        </div>
                </div>
                
                
                
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> DIRECCION </label>

                        <div class="col-sm-9">
                            <form:input id="direccion" type="text" class="col-xs-10 col-sm-5" placeholder="Direccion" path="direccion" required="true" value="${cliente.direccion}"/>
                            
                        </div>
                </div>
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> PAIS </label>

                        <div class="col-sm-9">
                             <form:input id="pais" type="text" class="col-xs-10 col-sm-5" placeholder="Pais" path="pais" required="true" value="${cliente.pais}"/>
                                
                        </div>
                </div>
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> PROVINCIA </label>

                        <div class="col-sm-9">
                            <form:input id="provincia" type="text" class="col-xs-10 col-sm-5" placeholder="Provincia" path="provincia" required="true" value="${cliente.provincia}"/>
                              
                        </div>
                </div>
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">POBLACION </label>

                        <div class="col-sm-9">
                            <form:input id="poblacion" type="text" class="col-xs-10 col-sm-5" placeholder="Poblacion" path="poblacion" required="true" value="${cliente.poblacion}"/>
                              
                        </div>
                </div>
                
              
                <div class="form-group">
                        <label id="" class="col-sm-3 control-label no-padding-right" for="form-field-1">  </label>

                        <div class="col-sm-9">
                               <button type="submit" class="btn btn-primary col-xs-12 col-sm-4 col-md-3 col-lg-3">Agregar</button>
                        </div>
                </div>
                         
                <br/><br/>

                <div class="hr hr-dotted hr-16"></div>

        </form:form>
</div>
</div>	

					</div><!-- /.row -->
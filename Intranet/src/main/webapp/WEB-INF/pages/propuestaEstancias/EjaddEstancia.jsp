<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<div class="page-content">  

<div class="page-header">
  
        <h1>
        Nueva Estancia de Propuesta:
        <small>
                <i class="ace-icon fa fa-angle-double-right"></i>
                ${prop.descipcion} 
        </small>
        </h1>
</div><!-- /.page-header -->
 		
<div class="row">
<div class="col-xs-12">
        <!-- PAGE CONTENT BEGINS -->
          <form:form id="form1" class="form-horizontal" role="form" action="" method="POST" commandName="estancia">
                <form:hidden id="propuesta_id" path="propuesta_id.id" value="${estancia.propuesta_id.id}"/>
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">N°</label>

                        <div class="col-sm-9">
                            <form:input type="text" id="numero" path="numero" class="col-xs-10 col-sm-1" required="true"/>
                           
                        </div>
                </div>
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">Tipo de Estancia</label>

                        <div class="col-sm-9">
                        <form:select id="tipo_estancia_id" name="tipo_estancia_id" path="tipo_estancia_id.id" class="col-xs-10 col-sm-4" data-placeholder="Choose a State...">
                            <form:options items="${ltaTipoEstancia}" itemValue="id" itemLabel="nombre" />
                        </form:select>
                        </div>
                </div>
                <div class="form-group" id="Otro" hidden="true">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">Nombre</label>

                        <div class="col-sm-9">
                            <form:input type="text" id="otro_tipo" path="otro_tipo" class="col-xs-10 col-sm-4" />
                        </div>
                </div>
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">ALTO</label>

                        <div class="col-sm-9">
                            <form:input type="text" id="alto" path="alto" class="col-xs-10 col-sm-4" />
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

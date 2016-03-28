<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!-- #section:settings.box -->
<div class="page-content">
<div class="page-header">
    
        <h1>
               Tareas de Plan de Obra
                <small>
                        <i class="ace-icon fa fa-angle-double-right"></i>
                       
                </small>
        </h1>
        
</div><!-- /.page-header -->
<div id="myModalU" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Actualizar Evento</h4>
      </div>
      <form:form acion="" method="post"id="formidU"  commandName="tarea">
      <div class="modal-body">
          <form:hidden id="id" path="id" />
          <form:hidden id="cli" path="cli.nif" />
          <form:hidden id="nif_empleado" path="nif_empleado.nif" />
          <form:hidden id="id_proyecto_presupuesto" path="id_proyecto_presupuesto.id" />
          
          
          <div class="form-group" >
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Cliente </label>

                        <div class="col-sm-9">
                            <label id="cli2"  class="col-sm-12"></label> 
                        </div>

                </div>
          <div class="form-group" >
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Plan de Obra: </label>

                        <div class="col-sm-9">
                            <label id="id_proyecto_presupuesto2" class="col-sm-12"></label> 
                        </div>

                </div>
          <div class="form-group" >
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">Descripcion: </label>

                        <div class="col-sm-9">
                            <label id="descripcion" class="col-sm-12"></label> 
                        </div>

                </div>
          
          <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Fecha Desde:</label>

                        <div class="col-sm-9">
                                <div class="row">
                                        <div class="col-xs-12 col-sm-5 col-md-4 col-lg-7">
                                                <div class="input-group input-group-sm">
                                                    <form:input id="finicio" type="text" class="form-control" path="finicio"  readonly="true" />
                                                   
                                                        <span class="input-group-addon">
                                                                <i class="fa fa-clock-o bigger-110"></i>
                                                        </span>
                                                </div>
                                        </div>
                                </div>
                        </div>

                </div> 
          <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Fecha Hasta:</label>

                        <div class="col-sm-9">
                                <div class="row">
                                        <div class="col-xs-12 col-sm-5 col-md-4 col-lg-7">
                                                <div class="input-group input-group-sm">
                                                    <form:input id="ffin" type="text" class="form-control" path="ffin" readonly="true" />
                                                   
                                                        <span class="input-group-addon">
                                                                <i class="fa fa-clock-o bigger-110"></i>
                                                        </span>
                                                </div>
                                        </div>
                                </div>
                        </div>

                </div>
            <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">¿Ha culminado la Tarea? </label>

                                        <div class="col-sm-9">

                                                <div class="radio">
                                                        <label>
                                                            <form:radiobutton id="estado1" path="estado" value="SI" class="ace" checked="true"/>
                                                            
                                                                <span class="lbl"> SI</span>
                                                        </label>
                                                </div>

                                                <div class="radio">
                                                        <label>
                                                            <form:radiobutton id="estado2" path="estado" value="NO" class="ace" />
                                                             
                                                                <span class="lbl"> NO</span>
                                                        </label>
                                                </div>


                                        </div>
                                </div>
                   <div class="form-group" id="nota">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">NOTA: </label>

                        <div class="col-sm-9">
                            <form:textarea type="text" id="nota" path="nota" class="col-xs-10 col-sm-10" rows="3"/>
                        </div>
                </div>    
                        <div class="form-group" id="Otro">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> </label>

                                <div class="col-sm-9">
                                    <form:checkbox path="cond" />
                                     <span class="lbl">
                                            Cerrar Tarea
                                        </span>
                                </div>
                        </div>                                        
              <label></label>
              
       
      </div>
      <div class="modal-footer">
        
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
        <button type="button" class="btn btn-info" id="btn_enviarU"><i class="ace-icon fa fa-check"></i> Ok</button>
        
      </div>
      </form:form>
    </div>

  </div>
</div>
                            <!-- /section:settings.box -->
                            <br/>
<div class="row">
    <div class="col-xs-12">
            <!-- PAGE CONTENT BEGINS -->
            <div class="row">
                    <div class="col-sm-12">
                            <div class="space"></div>

                            <!-- #section:plugins/data-time.calendar -->
                            <div id="calendar"></div>

                            <!-- /section:plugins/data-time.calendar -->
                    </div>

            </div>

            <!-- PAGE CONTENT ENDS -->
    </div><!-- /.col -->
</div><!-- /.row -->
</div><!-- /.row -->
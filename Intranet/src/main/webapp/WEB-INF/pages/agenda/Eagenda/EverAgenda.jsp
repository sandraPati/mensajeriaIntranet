<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!-- #section:settings.box -->

<div class="page-content">
<div class="page-header">
    <div class="row">
        <div class="col-lg-8">
        <h1>
               Tareas 
                <small>
                        <i class="ace-icon fa fa-angle-double-right"></i>
                    
                </small>
        </h1>
        </div>
         <div class="col-lg-4 align-right">
           
        </div>
        
             
             
    </div>
</div><!-- /.page-header -->
<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Nuevo Evento</h4>
      </div>
      <form:form acion="" method="post"id="formid"  commandName="tarea">
      <div class="modal-body">
          <form:hidden id="nifempleado" path="nifempleado" />
          <div class="form-group" >
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Supervisor </label>

                        <div class="col-sm-9">
                            <form:select id="nifsupervisor" name="nifsupervisor" path="nifsupervisor" class="col-xs-10 col-sm-3" data-placeholder="Choose a State...">
                               
                                <form:options items="${supervisorLista}" itemValue="nif" itemLabel="nif" />
                            </form:select>

                        </div>

                </div>
          <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">Cliente Asignado: </label>

                                        <div class="col-sm-9">

                                                <div class="radio">
                                                        <label>
                                                            <form:radiobutton id="cliasignado1" path="cliasignado" value="SI" class="ace" checked="true"/>
                                                            
                                                                <span class="lbl"> SI</span>
                                                                
                                                        </label>
                                                        <label>
                                                            
                                                                <form:radiobutton id="cliasignado2" path="cliasignado" value="NO" class="ace" />
                                                             
                                                                <span class="lbl"> NO</span>
                                                        </label>        
                                                </div>

                                              


                                        </div>
                                </div>
          <div class="form-group" id="clienteAsig">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Cliente </label>

                        <div class="col-sm-9">
                            <form:select id="nifcliente" name="nifcliente" path="nifcliente" class="col-xs-10 col-sm-3" data-placeholder="Choose a State...">
                               
                                <form:options items="${clientesLista}" itemValue="nif" itemLabel="nif" />
                            </form:select>

                        </div>

                </div>
                
          <div class="form-group" id="Otro">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">Tipo Tarea:</label>

                        <div class="col-sm-9">
                            <form:select id="tipotarea_id" name="tipotarea_id" path="tipotarea_id"  data-placeholder="Choose a State..." >
                                <form:option value="Visita"></form:option>
                                <form:option value="Enviar Presupuesto"></form:option>
                                <form:option value="Llamada para concretar visita"></form:option>
                                <form:option value="Llamada de seguimiento"></form:option>
                                <form:option value="Libre"></form:option>
                                <form:option value="Incidencia"></form:option>
                                <form:option value="Vacaciones"></form:option>
                            </form:select>
                          
                        </div>
                </div>
          <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Descripcion:</label>

                        <div class="col-sm-9">
                            <form:input class="middle" autocomplete="off" type="text" value="" id="descripcion" name="descripcion" path="descripcion" required="true"/>
                        </div>

                </div>
          <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Fecha Desde:</label>

                        <div class="col-sm-9">
                                <div class="row">
                                        <div class="col-xs-12 col-sm-5 col-md-4 col-lg-6">
                                                <div class="input-group input-group-sm">
                                                    <form:input id="finicio" type="text" class="form-control" path="finicio"  data-date-format="DD/MM/YYYY HH:mm tt"/>
                                                   
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
                                        <div class="col-xs-12 col-sm-5 col-md-4 col-lg-6">
                                                <div class="input-group input-group-sm">
                                                    <form:input id="ffin" type="text" class="form-control" path="ffin"/>
                                                   
                                                        <span class="input-group-addon">
                                                                <i class="fa fa-clock-o bigger-110"></i>
                                                        </span>
                                                </div>
                                        </div>
                                </div>
                        </div>

                </div> 
              <label></label>
              
       
      </div>
      <div class="modal-footer">
        
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
        <button type="button" class="btn btn-info" id="btn_enviar"><i class="ace-icon fa fa-check"></i> Ok</button>
      </div>
      </form:form>
    </div>

  </div>
</div>

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
          <form:hidden id="id1" path="id" />
          <form:hidden id="nifsupervisor1" path="nifsupervisor" />
          <form:hidden id="nifempleado1" path="nifempleado"/>
          
          <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Supervisor </label>

                        <div class="col-sm-9">
                            <label id="nifsupervisor2" class="col-sm-12"> </label>
                            

                        </div>

                </div>
          
          <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">Cliente Asignado: </label>

                                        <div class="col-sm-9">

                                                <div class="radio">
                                                        <label>
                                                            <form:radiobutton id="cliasignado3" path="cliasignado" value="SI" class="ace" checked="true"/>
                                                            
                                                                <span class="lbl"> SI</span>
                                                                
                                                        </label>
                                                        <label>
                                                            
                                                                <form:radiobutton id="cliasignado4" path="cliasignado" value="NO" class="ace" />
                                                             
                                                                <span class="lbl"> NO</span>
                                                        </label>        
                                                </div>

                                              


                                        </div>
                                </div>
          <div class="form-group" id="clienteAsig2">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Cliente </label>

                        <div class="col-sm-9">
                            <form:select id="nifcliente2" name="nifcliente" path="nifcliente" class="col-xs-10 col-sm-10" data-placeholder="Choose a State...">
                               
                                <form:options items="${clientesLista}" itemValue="nif" itemLabel="nif" />
                            </form:select>

                        </div>

                </div>
          <div class="form-group" id="Otro">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">Tipo Tarea:</label>

                        <div class="col-sm-9">
                            <form:select id="tipotarea_id1" name="tipotarea_id" path="tipotarea_id"  data-placeholder="Choose a State..." class="col-xs-10 col-sm-10">
                                <form:option value="Visita"></form:option>
                                <form:option value="Enviar Presupuesto"></form:option>
                                <form:option value="Llamada para concretar visita"></form:option>
                                <form:option value="Llamada de seguimiento"></form:option>
                                <form:option value="Libre"></form:option>
                                <form:option value="Incidencia"></form:option>
                                <form:option value="Vacaciones"></form:option>
                            </form:select>
                          
                        </div>
                </div>
          <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Descripcion:</label>

                        <div class="col-sm-9">
                            <form:input class="middle col-xs-10 col-sm-10" autocomplete="off" type="text" value="" id="descripcion1" name="descripcion" path="descripcion" required="true"/>
                        </div>

                </div>
          <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Fecha Desde:</label>

                        <div class="col-sm-9">
                                <div class="row">
                                        <div class="col-xs-12 col-sm-5 col-md-4 col-lg-7">
                                                <div class="input-group input-group-sm">
                                                    <form:input id="finicio1" type="text" class="form-control" path="finicio" />
                                                   
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
                                                    <form:input id="ffin2" type="text" class="form-control" path="ffin" />
                                                   
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
                            <form:textarea type="text" id="nota1" path="nota" class="col-xs-10 col-sm-10" rows="3"/>
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
        <button type="button" class="btn btn-sm btn-danger" id="btn_delete"><i class="ace-icon fa fa-trash-o"></i> Eliminar Evento</button>
        
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

			
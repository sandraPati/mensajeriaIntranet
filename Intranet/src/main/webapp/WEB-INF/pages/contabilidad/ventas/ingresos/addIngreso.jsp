<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<div class="page-content">  
<div class="page-header">
    <div class="row">
        <div class="col-lg-8">
        <h1>
            Otros Ingresos
            
            <small>
                    <i class="ace-icon fa fa-angle-double-right"></i>
                   
            </small>
        </h1>
        </div>
    <div class="col-lg-4 align-right">
        <a class=" btn btn-white btn-warning" href="/Intranet/sup/Ingresos.htm" data-rel="tooltip">
            <i class="ace-icon fa fa-reply icon-only"></i>

        </a>

    </div>
             
             
    </div>
</div><!-- /.page-header -->
 		
<div class="row">
<div class="col-xs-12">
        <!-- PAGE CONTENT BEGINS -->
          <form:form id="form1" class="form-horizontal" role="form" action="" method="POST" commandName="ingreso">
                <div class="well well-sm col-xs-5">
                <div class="col-sm-1"></div>
                <div class="col-sm-10">
                    
                    <div class="form-group" >
                        <label class="col-sm-12 " for="form-field-1"> Forma de Pago </label>

                        <div class="col-sm-12">
                            <form:select id="formapago_id" name="formapago_id" path="formapago_id.id" class="chosen-select col-xs-10 col-sm-12" data-placeholder="Elegir Forma de Pago...">
                                <option value="">  </option>
                                <form:options items="${ltaFormapago}" itemValue="id" itemLabel="nombre" />
                            </form:select>

                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-12" for="form-field-1"> Tipo Ingreso </label>

                        <div class="col-sm-12">
                            <form:select id="tipoingreso_id" name="tipoingreso_id" path="tipoingreso_id.id" class="chosen-select col-xs-10 col-sm-12" data-placeholder="Elegir Tipo de Ingreso...">
                                <option value="">  </option>
                                <form:options items="${ltaTipoingreso}" itemValue="id" itemLabel="nombre" />
                            </form:select>

                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-12" for="form-field-1"> Fecha Pago:</label>

                        <div class="col-sm-12">
                                <div class="row">
                                        <div class="col-xs-12 col-sm-5 col-md-4 col-lg-12">
                                                <div class="input-group input-group-sm">
                                                    <form:input id="fechapago" type="text" class="form-control" path="fechapago" data-date-format="yyyy-mm-dd" required="true"/>   
                                                         <span class="input-group-addon">
                                                                <i class="ace-icon fa fa-calendar"></i>
                                                        </span>
                                                </div>
                                        </div>
                                </div>
                        </div>

                    </div>  
                    <div class="form-group" >
                        <label class="col-sm-12" for="form-field-1"> Cliente </label>

                        <div class="col-sm-12">
                            <form:select id="cliente_nif" name="cliente_nif" path="cliente_nif.nif" class="chosen-select col-xs-10 col-sm-12" data-placeholder="Elegir Cliente...">
                               <option value="">  </option>
                                <form:options items="${ltaCliente}" itemValue="nif" itemLabel="nif" />
                            </form:select>

                        </div>

                    </div>
                </div>                                         
                <div class="col-sm-1"></div>                                         
                </div>
                <div class="col-xs-1"></div>                                    
                <div class="well well-sm col-xs-5">
                    <div class="col-sm-1"></div> 
                    <div class="col-sm-10">
                   <div class="form-group">
                        <label class="col-sm-12" for="form-field-1">Referencia:</label>

                        <div class="col-sm-12">
                            <form:input type="text" id="refenrecia" path="refenrecia" class="col-xs-10 col-sm-12" required="true"/>
                          
                        </div>
                    </div>
                    <div class="form-group" >
                        <label class="col-sm-12" for="form-field-1">Cuenta Bancaria:</label>

                        <div class="col-sm-12">
                            <form:select id="cuente_bancaria" name="cuente_bancaria" path="cuente_bancaria" class="chosen-select col-xs-10 col-sm-12" data-placeholder="Elegir Cuenta Bancaria...">
                                <option value="">  </option>
                                <form:option value="Cuenta Corriente"></form:option>
                                <form:option value="Cuenta Remunerada"></form:option>
                            </form:select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-12" for="form-field-1">Total Bruto:</label>

                        <div class="col-sm-12">
                            <form:input type="text" id="totalbruto" path="totalbruto" class="col-xs-10 col-sm-12" required="true"/>
                          
                        </div>
                    </div>
                    <div class="form-group" >
                        <label class="col-sm-12" for="form-field-1">Porcentaje IRPF:</label>

                        <div class="col-sm-12">
                            <form:input type="text" id="porcentaje_irpf" path="porcentaje_irpf" class="col-xs-10 col-sm-12" required="true"/>
                          
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-6"></div>
                            <div class="col-sm-4">
                                   <button type="submit" class="btn btn-sm btn-success col-xs-12 col-sm-4 col-md-3 col-lg-12 ">Agregar</button>
                            </div>
                    </div>
                    </div> 
                    <div class="col-sm-1"></div>         
                </div>
                
                
                
        </form:form>
</div>
</div>	

					</div><!-- /.row -->
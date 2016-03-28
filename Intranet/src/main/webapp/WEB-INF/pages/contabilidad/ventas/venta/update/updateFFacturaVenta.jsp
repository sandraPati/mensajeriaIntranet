<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<div class="page-content">		

<div class="page-header">
    <div class="row">
        <div class="col-lg-8">
        <h1>
            Facturas de Venta
            <br/>
            <small>
                    <i class="ace-icon fa fa-angle-double-right"></i>
                   Crea aqui tus facturas de ventas
            </small>
        </h1>
        </div>
    <div class="col-lg-4 align-right">
        

    </div>
             
             
    </div>
</div><!-- /.page-header -->
 		
<div class="row">
<div class="col-xs-12">
        <!-- PAGE CONTENT BEGINS -->
          <form:form id="form1" class="form-horizontal" role="form" action="" method="POST" commandName="ven" >
                <div class="well well-sm col-xs-12">
                <div class="col-sm-1"></div>
                <div class="col-sm-10">
                    <form:hidden path="num" value="${ven.num}"/>
                    <div class="form-group" >
                        <label class="col-sm-12 " for="form-field-1"> Serie </label>

                        <div class="col-sm-12">
                            <form:input type="text" id="serie" path="serie" class="col-xs-10 col-sm-3" readonly="true" value="A-"/>
                        </div>
                    </div>
                    <div class="form-group" >
                        <label class="col-sm-3" for="form-field-1"> Cliente </label>
                        <label class="col-sm-3" for="form-field-1"> Fecha:</label>
                        <label class="col-sm-3" for="form-field-1"> Fecha Vencimiento:</label>
                        <label class="col-sm-3 " for="form-field-1"> Referencia </label>
                        <div class="col-sm-12">
                            <div class="row" >
                                <div class="col-xs-10 col-sm-3">    
                                    <form:select id="cliente_nif" name="cliente_nif" path="cliente_nif.nif" class="chosen-select col-xs-10 col-sm-12" required="true" data-placeholder="Elegir...">
                                        <option value="">  </option>
                                        <form:options items="${ltaCliente}" itemValue="nif" itemLabel="nif" />
                                    </form:select>
                                </div>
                                
                                <div class="col-xs-12 col-sm-5 col-md-4 col-lg-3">
                                        <div class="input-group input-group-sm">
                                            <form:input id="fecha" type="text" class="form-control" path="fecha" data-date-format="yyyy-mm-dd" required="true"/>   
                                                 <span class="input-group-addon">
                                                        <i class="ace-icon fa fa-calendar"></i>
                                                </span>
                                        </div>
                                </div>
                                <div class="col-xs-12 col-sm-5 col-md-4 col-lg-3">
                                   <div class="input-group input-group-sm">
                                       <form:input id="fechavencimiento" type="text" class="form-control" path="fechavencimiento" data-date-format="yyyy-mm-dd" required="true"/>   
                                            <span class="input-group-addon">
                                                   <i class="ace-icon fa fa-calendar"></i>
                                           </span>
                                   </div>
                                </div>
                                <div class="col-xs-10 col-sm-3">                
                                    <form:input type="text" id="referencia" path="referencia" class="col-xs-10 col-sm-3 col-lg-12" /> 
                                </div>
                            </div>
                        </div>

                    </div>
                    
                    <div class="form-group" >
                        <label class="col-sm-6 " for="form-field-1"> Direccion Principal </label>
                        <label class="col-sm-6 " for="form-field-1"> Direccion de Envio </label>
                        <div class="col-sm-6">
                            <form:textarea type="text" id="direccionP" path="direccionP" class="col-xs-10 col-sm-12" rows="5" required="true"/>
                        </div>
                        <div class="col-sm-6">
                            <form:textarea type="text" id="direccionE" path="direccionE" class="col-xs-10 col-sm-12" rows="5" />
                            <span class="lbl col-sm-4" >
                                Es la misma que la principal
                                &nbsp;&nbsp;&nbsp;
                                <input type="checkbox"  id="direccionMisma" checked="true"/>
                            </span>
                        </div>
                    </div>
                      
                            
                </div>                                         
                <div class="col-sm-1"></div>                                         
                </div>
               <div class="well well-sm col-xs-12">
                    <div class="col-sm-1"></div>
                    <div class="col-sm-10">
                         
          
                    <div class="form-group" >
                        <table id="simple-table" class="table table-striped table-bordered table-hover ">
                            <thead>
                                    <tr>
                                           
                                            <th>Producto/Servicio</th>
                                            <th>Cant.</th>
                                            <th class="hidden-480">Precio por Unid.</th>
                                            <th class="hidden-480"></th>
                                            <th class="hidden-480">Porcentaje Desc.</th>
                                            <th class="hidden-480"></th>
                                            <th class="hidden-480">Tipo de IVA</th>
                                            <th class="hidden-480">Impuestos</th>
                                            <th class="hidden-480">Total</th>
                                    </tr>
                            </thead>

                            <tbody>
                                <c:forEach items="${tiendaV}" var="ti">
                                    <tr>
                                        <td>${ti.productoservicio}</td>
                                        <td>${ti.cantidad}</td>
                                        <td>${ti.precio}</td>
                                        <td>${ti.totalcp}</td>
                                        <td>${ti.porcentajedescuento}</td>
                                        <td>${ti.descuento}</td>
                                        <td>${ti.tipoiva_id.descripcion}</td>
                                        <input type="hidden" id="ivaCombo" value="${ti.tipoiva_id.id}" />
                                        <td>${ti.impuesto}</td>
                                        <td>${ti.totalimp}</td>
                                    </tr>    
                               </c:forEach> 
                            </tbody>
                        </table>
                    </div> 
     
                         <div class="form-group" >
                        <div class="col-xs-10 col-sm-6">   
                        <table id="simple-table" class="table table-striped table-bordered table-hover ">
                            <thead>
                                    <tr>
                                           
                                            <th>B. Imponible</th>
                                            <th>Tipo IVA</th>
                                            <th class="hidden-480">IVA</th>

                                    </tr>
                            </thead>

                            <tbody>
                                    <tr>
                                            
                                            <td>
                                                <div id="general1"></div>
                                                
                                            </td>
                                            <td>General(21%)</td>
                                            <td class="hidden-480"><div id="general2"></div></td>
                                           
                                    </tr>
                                    <tr>
                                            
                                            <td>
                                               <div id="reducido1"></div>
                                            </td>
                                            <td>Reducido(10%)</td>
                                            <td class="hidden-480"><div id="reducido2"></div></td>
                                            
                                    </tr>
                                    <tr>
                                            
                                            <td>
                                                <div id="superreducido1"></div>
                                            </td>
                                            <td>Super Reducido(4%)</td>
                                            <td class="hidden-480"><div id="superreducido2"></div></td>
                                            
                                    </tr>
                                    <tr>
                                            
                                            <td>
                                                <div id="exento1"></div>
                                            </td>
                                            <td>Exento</td>
                                            <td class="hidden-480"><div id="exento2"></div></td>
                                            
                                    </tr>
                                    <tr>
                                            
                                            <td>
                                                <div id="siniva1"></div>
                                            </td>
                                            <td>Sin IVA</td>
                                            <td class="hidden-480"><div id="siniva2"></div></td>
                                            
                                    </tr>

                            </tbody>
                    </table>
                        </div>
                        <div class="col-xs-10 col-sm-6"> 
                            <div class="form-group" >
                                <label class="col-sm-4 " for="form-field-1"> Base Imponible </label>

                                <div class="col-sm-8">
                                    <form:input type="text" id="baseimponible" path="baseimponible" class="col-xs-10 col-sm-12" readonly="true"/>
                                </div>
                            </div>
                            <div class="form-group" >
                                <label class="col-sm-4 " for="form-field-1"> IVA Total </label>

                                <div class="col-sm-8">
                                    <form:input type="text" id="ivatotal" path="ivatotal" class="col-xs-10 col-sm-12" readonly="true"/>
                                </div>
                            </div>
                            <div class="form-group" >
                                <label class="col-sm-4 " for="form-field-1"> Porcentaje IRPF </label>

                                <div class="col-sm-3">
                                    <form:input type="text" id="irpf" path="irpf" class="col-xs-10 col-sm-12" />                                    
                                    
                                </div>
                                <div class="col-sm-5">
                                    <form:input type="text" id="totalirpf" path="totalirpf" class="col-xs-10 col-sm-12" readonly="true" />
                                </div>
                            </div> 
                               
                            <div class="form-group" >
                                <label class="col-sm-4 " for="form-field-1"> Total </label>

                                <div class="col-sm-8">
                                    <form:input type="text" id="total" path="total" class="col-xs-10 col-sm-12" readonly="true" />
                                </div>
                            </div>    
                        </div>
                    </div>
                    </div>
                    <div class="col-sm-1"></div>
                </div>
               <div class="well well-sm col-xs-12">
                <div class="col-sm-1"></div>
                <div class="col-sm-10">
                    
                    <div class="form-group" >
                        <label class="col-sm-12 green" for="form-field-1"> Facturas Rectificativas </label>

                        <div class="col-sm-12">
                            <div class="row">
                            <span class="lbl col-sm-4" >
                                Es una factura rectificativa
                                &nbsp;&nbsp;&nbsp;
                                <form:checkbox  id="retificativo" path="rectificactiva"/>
                            </span>
                            <div id="causa">
                            <span class="lbl col-sm-3">Es una factura rectificativa</span>
                            <form:select id="causa" name="causa" path="causa"  class="col-sm-5" data-placeholder="Choose a State..." >
                                <form:option value="Causa"></form:option>
                            </form:select>
                            </div>
                             </div>
                        </div>
                            
                    </div>
                   
                    
                    
                            
                </div>                                         
                <div class="col-sm-1"></div>                                         
                </div> 
                <div class="well well-sm col-xs-12">
                <div class="col-sm-1"></div>
                <div class="col-sm-10">
                    
                    <div class="form-group" >
                        <label class="col-sm-6" for="form-field-1"> Notas </label>
                        <label class="col-sm-6" for="form-field-1"> Terminos </label>
                        <div class="col-sm-6">
                            <form:textarea type="text" id="notas" path="notas" class="col-xs-10 col-sm-12" rows="5" />
                        </div>
                        
                        <div class="col-sm-6">
                            <form:textarea type="text" id="terminos" path="terminos" class="col-xs-10 col-sm-12" rows="5" />
                        </div>
                    </div>
                    
                    
                      <div class="form-group" >
                        <label class="col-sm-10" for="form-field-1">  </label>
                        <button type="submit" class="btn btn-success col-xs-10 col-sm-6 col-md-6 col-lg-2 ">
                            Finalizar<i class="ace-icon fa fa-arrow-right icon-on-right"></i>
                        </button>


                    </div>        
                </div>                                         
                <div class="col-sm-1"></div>                                         
                </div> 
                      
        </form:form>
       
</div>
</div>	

					</div><!-- /.row -->
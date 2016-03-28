<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<div class="page-content">  		

<div class="page-header">
    <div class="row">
        <div class="col-lg-8">
        <h1>
            Facturas de Compra
            <br/>
            <small>
                    <i class="ace-icon fa fa-angle-double-right"></i>
                   Crea aqui tus facturas de compras
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
    
        <form:form id="form1" action="/Intranet/sup/AgregarP.htm" method="post" commandName="detalleC"> 
           <div class="well well-sm col-xs-12">
               
               <div class="col-sm-12">
                    
                    <div class="form-group" >
                        <label class="col-sm-2" for="form-field-1"> Producto/Servicio </label>
                        <label class="col-sm-1" for="form-field-1"> Tipo de Cuenta </label>
                        <label class="col-sm-1" for="form-field-1"> Cant. </label>
                        <label class="col-sm-1" for="form-field-1"> Precio por Unid.</label>
                        <label class="col-sm-1" for="form-field-1"> </label>
                        <label class="col-sm-1" for="form-field-1"> Porcentaje Desc.</label>
                        <label class="col-sm-1" for="form-field-1"> </label>
                        <label class="col-sm-1" for="form-field-1"> Tipo de IVA</label>
                        <label class="col-sm-1" for="form-field-1"> Impuestos </label>
                        <label class="col-sm-2" for="form-field-1"> Total </label>
                        <div class="col-sm-12">
                            <div class="row" >
                                <div class="col-sm-2">
                                    <form:hidden id="id" path="id" value="${detalleC.id}"/>
                                    <form:input type="text" id="productoservicio" path="productoservicio" class="col-xs-10 col-sm-12" />
                                </div>
                                 <div class="col-sm-1">
                                    <form:select id="tipogasto_id" name="tipogasto_id" path="tipogasto_id.id" class="col-xs-10 col-sm-12" data-placeholder="Choose a State...">
                                        <form:options items="${ltaTipoGasto}" itemValue="id" itemLabel="nombre" />
                                    </form:select>
                                </div>
                                <div class="col-xs-10 col-sm-1">                
                                    <form:input type="text" id="cantidad" path="cantidad" class="col-xs-10 col-sm-3 col-lg-12" /> 
                                </div>
                                <div class="col-xs-10 col-sm-1">                
                                    <form:input type="text" id="precio" path="precio" class="col-xs-10 col-sm-3 col-lg-12" /> 
                                </div>
                                <div class="col-xs-10 col-sm-1">                
                                    <form:input type="text" id="preciocantidad" path="totalcp" class="col-xs-10 col-sm-3 col-lg-12" readonly="true"/> 
                                </div>
                                <div class="col-xs-10 col-sm-1">                
                                    <form:input type="text" id="porcentajedescuento" path="porcentajedescuento" class="col-xs-10 col-sm-3 col-lg-12" /> 
                                </div>
                                <div class="col-xs-10 col-sm-1">                
                                    <form:input type="text" id="descuento" path="descuento" class="col-xs-10 col-sm-3 col-lg-12" readonly="true"/> 
                                </div>
                                <div class="col-xs-10 col-sm-1">    
                                    <form:select id="tipoivaid" name="tipoiva_id" path="tipoiva_id.id" class="col-xs-10 col-sm-12" data-placeholder="Choose a State...">

                                        <form:options items="${ltaTipoIva}" itemValue="id" itemLabel="descripcion" />
                                    </form:select>
                                </div>
                                
                                
                                <div class="col-xs-10 col-sm-1">                
                                    <form:input type="text" id="impuesto" path="impuesto" class="col-xs-10 col-sm-3 col-lg-12" readonly="true"/> 
                                </div>
                                <div class="col-xs-10 col-sm-2">                
                                    <form:input type="text" id="total" path="totalimp" class="col-xs-10 col-sm-3 col-lg-12" readonly="true"/> 
                                </div>
                                
                                <%boolean encontrado=false;%>
                                 <c:forEach items="${tiendaV}" var="car">
                                     <c:if test="${car.id==ti.id}">
                                     <%encontrado=true;%>    
                                     </c:if>
                                 </c:forEach>
                                 <%if(encontrado==false){%>
                                    <div class="col-xs-10 col-sm-1">       
                                       <button type="submit" class="btn btn-white btn-success btn-bold">
                                       <span class="green">
                                           <i class="ace-icon fa fa-check-square-o bigger-130"></i>
                                       </span>
                                       </button>
                                    </div>    
                                <%}else{%>
                                <div class="col-xs-10 col-sm-1">     
                                 <a href="/Intranet/sup/QuitarP.htm?id=${ti.id}"><span class="red"><i class="ace-icon glyphicon glyphicon-remove bigger-130"></i></span></a>
                                 </div> 
                                 <%}
                                    %>
                               
                            </div>
                        </div>

                    </div>    
                </div>
            </div>                
       </form:form>
       
        <c:forEach items="${tiendaV}" var="d">  
          <form:form id="form1" action="/Intranet/sup/AgregarP.htm" method="post" commandName="detalleC"> 
           <div class="well well-sm col-xs-12">
               
               <div class="col-sm-12">
                    
                    <div class="form-group" >
                        <label class="col-sm-2" for="form-field-1"> Producto/Servicio </label>
                        <label class="col-sm-1" for="form-field-1"> Tipo de Cuenta </label>
                        <label class="col-sm-1" for="form-field-1"> Cant. </label>
                        <label class="col-sm-1" for="form-field-1"> Precio por Unid.</label>
                        <label class="col-sm-1" for="form-field-1"> </label>
                        <label class="col-sm-1" for="form-field-1"> Porcentaje Desc.</label>
                        <label class="col-sm-1" for="form-field-1"> </label>
                        <label class="col-sm-1" for="form-field-1"> Tipo de IVA</label>
                        <label class="col-sm-1" for="form-field-1"> Impuestos </label>
                        <label class="col-sm-2" for="form-field-1"> Total </label>
                        <div class="col-sm-12">
                            <div class="row" >
                                <div class="col-sm-2">
                                    <form:hidden id="id" path="id" value="${d.id}"/>
                                    
                                    <form:input type="text" id="productoservicio" path="productoservicio" value="${d.productoservicio}"class="col-xs-10 col-sm-12" />
                                </div>
                                <div class="col-xs-10 col-sm-1">
                                    <form:select id="tipogasto_id" name="tipogasto_id" path="tipogasto_id.id" value="${d.tipogasto_id.id}" class="col-xs-10 col-sm-12" data-placeholder="Choose a State...">
                                        <form:options items="${ltaTipoGasto}" itemValue="id" itemLabel="nombre" />
                                    </form:select>
                                </div>
                                <div class="col-xs-10 col-sm-1">                
                                    <form:input type="text" id="cantidad" path="cantidad" value="${d.cantidad}"class="col-xs-10 col-sm-3 col-lg-12" /> 
                                </div>
                                <div class="col-xs-10 col-sm-1">                
                                    <form:input type="text" id="precio" path="precio" value="${d.precio}"class="col-xs-10 col-sm-3 col-lg-12" /> 
                                </div>
                                <div class="col-xs-10 col-sm-1">                
                                    <form:input type="text" id="preciocantidad" path="totalcp" value="${d.totalcp}"class="col-xs-10 col-sm-3 col-lg-12" readonly="true"/> 
                                </div>
                                <div class="col-xs-10 col-sm-1">                
                                    <form:input type="text" id="porcentajedescuento" path="porcentajedescuento" value="${d.porcentajedescuento}"class="col-xs-10 col-sm-3 col-lg-12" /> 
                                </div>
                                <div class="col-xs-10 col-sm-1">                
                                    <form:input type="text" id="descuento" path="descuento" value="${d.descuento}"class="col-xs-10 col-sm-3 col-lg-12" readonly="true"/> 
                                </div>
                                <div class="col-xs-10 col-sm-1">    
                                    <form:select id="tipoivaid" name="tipoiva_id" path="tipoiva_id.id" value="${d.tipoiva_id.id}"class="col-xs-10 col-sm-12" data-placeholder="Choose a State...">

                                        <form:options items="${ltaTipoIva}" itemValue="id" itemLabel="descripcion" />
                                    </form:select>
                                </div>
                                
                                
                                <div class="col-xs-10 col-sm-1">                
                                    <form:input type="text" id="impuesto" path="impuesto" value="${d.impuesto}"class="col-xs-10 col-sm-3 col-lg-12" readonly="true"/> 
                                </div>
                                <div class="col-xs-10 col-sm-2">                
                                    <form:input type="text" id="total" path="totalimp" value="${d.totalimp}"class="col-xs-10 col-sm-3 col-lg-12" readonly="true"/> 
                                </div>
                                
                                <%boolean encontrado2=false;%>
                                 <c:forEach items="${tiendaV}" var="car">
                                     <c:if test="${car.id==ti.id}">
                                     <%encontrado2=true;%>    
                                     </c:if>
                                 </c:forEach>
                                 <%if(encontrado2==false){%>
                                    <div class="col-xs-10 col-sm-1">       
                                       <button type="submit" class="btn btn-white btn-success btn-bold">
                                       <span class="green">
                                           <i class="ace-icon fa fa-check-square-o bigger-130"></i>
                                       </span>
                                       </button>
                                    </div>    
                                <%}else{%>
                                <div class="col-xs-10 col-sm-1">     
                                 <a href="/Intranet/sup/QuitarP.htm?id=${ti.id}"><span class="red"><i class="ace-icon glyphicon glyphicon-remove bigger-130"></i></span></a>
                                 </div> 
                                 <%}
                                    %>
                               
                            </div>
                        </div>

                    </div>    
                </div>
            </div>                
       </form:form>            
	</c:forEach>  
        </div>
</div>

					</div><!-- /.row -->
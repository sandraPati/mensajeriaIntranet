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
        <a class=" btn btn-white btn-success" href="/Intranet/emp/EaddProducto.htm" data-rel="tooltip">
            Agregar Producto/Servicio
        </a>

    </div>
             
             
    </div>
</div><!-- /.page-header -->
 		
<div class="row">
<div class="col-xs-12">
        <!-- PAGE CONTENT BEGINS -->
        <div class="well well-sm col-xs-12">
               
               <div class="col-sm-12">
                    
                    <div class="form-group" >
                        <div class="col-xs-10 col-sm-12">   
                        <table id="simple-table" class="table table-striped table-bordered table-hover ">
                            <thead>
                                    <tr>
                                           
                                            <th>Producto/Servicio</th>
                                            <th>Tipo de Cuenta</th>
                                            <th>Cant.</th>
                                            <th class="hidden-480">Precio por Unid.</th>
                                            <th class="hidden-480"></th>
                                            <th class="hidden-480">Porcentaje Desc.</th>
                                            <th class="hidden-480"></th>
                                            <th class="hidden-480">Tipo de IVA</th>
                                            <th class="hidden-480">Impuestos</th>
                                            <th class="hidden-480">Total</th>
                                            <th class="hidden-480"></th>
                                    </tr>
                            </thead>

                            <tbody>
        <c:forEach items="${tiendaV}" var="ti">
          <form:form id="form1" action="/Intranet/emp/EAgregarP.htm" method="post" commandName="detalleC"> 
            <form:hidden id="id" path="id" value="${ti.id}"/>
              
                 <tr>
                                            
                                            <td>
                                                <div id="productoservicio">${ti.productoservicio}</div>                                                
                                            </td>
                                            <td><div id="tipogasto_id">${ti.tipogasto_id.nombre}</div></td>
                                            <td><div id="cantidad">${ti.cantidad}</div></td>
                                            <td><div id="precio">${ti.precio}</div></td>
                                            <td><div id="preciocantidad2">${ti.totalcp}<input type="hidden" id="preciocantidad" value="${ti.totalcp}"/></div></td>
                                            <td><div id="porcentajedescuento">${ti.porcentajedescuento}</div></td>
                                            <td><div id="descuento2">${ti.descuento}<input type="hidden" id="descuento" value="${ti.descuento}"/></div></td>
                                            <td><div id="tipoivaid">${ti.tipoiva_id.descripcion}</div></td>
                                            <td><div id="impuesto2">${ti.impuesto}<input type="hidden" id="impuesto" value="${ti.impuesto}"/></div></td>
                                            <td><div id="total2">${ti.totalimp}<input type="hidden" id="total" value="${ti.totalimp}"/></div></td>
                                             <%boolean encontrado=false;%>
                                 <c:forEach items="${tiendaV}" var="car">
                                     <c:if test="${car.id==ti.id}">
                                     <%encontrado=true;%>    
                                     </c:if>
                                 </c:forEach>
                                 <%if(encontrado==false){%>
                                       <td>       
                                       <button type="submit" class="btn btn-white btn-success btn-bold">
                                       <span class="green">
                                           <i class="ace-icon fa fa-check-square-o bigger-130"></i>
                                       </span>
                                       </button>
                                       </td>
                                <%}else{%>
                               <td> 
                                <a href="/Intranet/emp/EQuitarP.htm?id=${ti.id}"><span class="red"><i class="ace-icon glyphicon glyphicon-remove bigger-130"></i></span></a>
                               </td> 
                                <%}
                                    %>
                                    </tr>         
       </form:form>
    </c:forEach> 
                       </tbody>
                    </table>
                        </div>
                        
                        </div>

                    </div>    
              </div>
    <div class="form-group">
            <label id="labelOficio" class="col-sm-10 control-label no-padding-right" for="form-field-1">  </label>

            <div class="col-sm-2">
                <a class="btn btn-success col-xs-12 col-sm-4 col-md-3 col-lg-12" href="/Intranet/emp/EaddFacturaCompra.htm" data-rel="tooltip">
                   Siguiente<i class="ace-icon fa fa-arrow-right icon-on-right"></i>
                </a>
                
            </div>
    </div>
</div>
</div>	

					</div><!-- /.row -->
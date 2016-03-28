<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

 <div class="page-content">  
<div class="page-header">
    <div class="row">
        <div class="col-lg-8">
        <h1>
            PROPUESTA:
            
            <small>
                    <i class="ace-icon fa fa-angle-double-right"></i>
                    ${p.descipcion} 
                    <br/>del CLIENTE: ${p.cliente_nif.nif} ${p.cliente_nif.apellidos}, ${p.cliente_nif.nombre}
            </small>
        </h1>
            
        </div>
    <div class="col-lg-4 align-right">
        <a class=" btn btn-white btn-warning" href="/Intranet/sup/Presupuesto.htm?idP=${p.id}" data-rel="tooltip">
            <i class="ace-icon fa fa-reply icon-only"></i>

        </a>

    </div>
             
             
    </div>
</div><!-- /.page-header -->

<div class="row">
    <div class="col-xs-12">
        
        <div class="clearfix">
            <div class="pull-right tableTools-container2"></div>
        </div>
        
        <div class="table-header" STYLE="background-color:#8C94C6">
                Lista de Sub Capitulos
        </div>

        <!-- div.table-responsive -->

        <!-- div.dataTables_borderWrap -->
        <div class="table-responsive">
            <table id="dynamic-table2" class="table table-striped table-bordered table-hover table-condensed">
                <thead>
                    <tr>
                        <th></th>
                        <th>SUB CAPITULO</th>
                        <th></th>
                        <th>DESCRIPCION</th>
                        <th>TIPO</th>
                        <th>CANTIDAD</th>
                        <th>PRECIO</th>
                        <th>MONTO</th>
                        <th></th>
                    </tr>
                </thead>

                    <tbody>
                        <c:forEach items="${presup}" var="item">
                            <tr>
                                <td>
                                    
                                    <c:if test="${item.tipoCantidad=='m2' || item.tipoCantidad=='ml'}">
                                           <c:if test="${not empty r}">
                                                    
                                                        
                                                    <c:if test="${presm2.idpresupuesto==item.id}">
                                                        <div class="radio">
                                                            <label>
                                                                <input type="radio" id="presupuestom2" name="presupuestom2" value="${item.id}" class="chk ace" checked="true"/>
                                                                <span class="lbl"> </span>
                                                            </label>
                                                        </div>  
                                                    </c:if>
                                                    <c:if test="${presm2.idpresupuesto!=item.id}">
                                                        <div class="radio">
                                                            <label>
                                                                <input type="radio" id="presupuestom2" name="presupuestom2" value="${item.id}" class="chk ace" />
                                                                <span class="lbl"> </span>
                                                            </label>
                                                        </div>
                                                    </c:if>
                                                          
                                                </c:if>
                                                <c:if test="${empty r}">
                                                        <div class="radio">
                                                            <label>
                                                                <input type="radio" id="presupuestom2" name="presupuestom2" value="${item.id}" class="chk ace" />
                                                                <span class="lbl"> </span>
                                                            </label>
                                                        </div>
                                                </c:if>
                                            </c:if>
                                </td>

                                    <td>
                                         <c:out value="${item.subcapitulo.cod}" />
                                    </td>
                                    <td><c:out value="${item.subcapitulo.nombre}" /></td>
                                   <td><c:out value="${item.descripcion}" /></td>
                                   <td><c:out value="${item.tipoCantidad}" /></td>
                                   <td><c:out value="${item.cantidad}" /></td>
                                   <td><c:out value="${item.precio}" /></td>
                                   <td><c:out value="${item.monto}" /></td>
                                    <td>
                                                
                                                <a class="blue tooltip-info" data-rel="tooltip" href="/Intranet/sup/verPresupuestoSC.htm?idPres=${item.id}&idP=${idP}&idPP=${idPres}" title="Consultar">
                                                    <i class="ace-icon fa fa-search-plus bigger-130"></i>
                                                </a>    
                                                          
                                                <a class="red tooltip-error" data-rel="tooltip" href="/Intranet/sup/deletePresupuestoG.htm?idPres=${item.id}&idP=${idP}&idPP=${idPres}" title="Eliminar">
                                                    <i class="ace-icon fa fa-trash-o bigger-130"></i>
                                                </a>
                                                  
                                                    
                                    </td>

                            </tr>
                        </c:forEach> 


                    </tbody>
                </table>
        </div>
        <br/>
        <br/>                    
</div>
</div>
 
</div><!-- /.row -->
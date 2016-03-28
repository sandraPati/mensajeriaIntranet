<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<div class="page-content">  
 
<div class="page-header">
    <div class="row">
        <div class="col-lg-8">
        <h1>
            Actualizar Presupuesto 
        
            de PROPUESTA:
            <br/>
            <small>
                    <i class="ace-icon fa fa-angle-double-right"></i>
                    ${p.descipcion} del CLIENTE: ${p.cliente_nif.nif} ${p.cliente_nif.apellidos}, ${p.cliente_nif.nombre}
            </small>
        </h1>
        </div>
    <div class="col-lg-4 align-right">
        <a class=" btn btn-white btn-warning" href="/Intranet/emp/EPresupuesto.htm?idP=${p.id}" data-rel="tooltip">
            <i class="ace-icon fa fa-reply icon-only"></i>

        </a>

    </div>
             
             
    </div>
</div><!-- /.page-header -->
 		
<div class="row">
<div class="col-xs-12">
        <!-- PAGE CONTENT BEGINS -->
          <form:form id="form1" class="form-horizontal" role="form" action="" method="POST" commandName="presup">
              
                <div class="form-group">
                        <label class="col-sm-1 control-label no-padding-right" for="form-field-1">CAPITULOS: </label>

                        <div class="col-sm-11">
                            <label class="control-label ">${presup.capitulo_id.cod} ${presup.capitulo_id.nombre} </label>
                            
                        </div>
                </div>
                
                <div class="form-group">
                        <label class="col-sm-1 control-label no-padding-right" for="form-field-1">SUB CAPITULOS: </label>

                        <div class="col-sm-11">
                      
                        <table id="dynamic-table2" class="table table-striped table-bordered table-hover table-condensed">
                             <thead>
                                <tr>
                                    <th></th>
                                    <th>COD</th>
                                    <th>NOMBRE</th>
                                    <th>DESCRIPCION</th>
                                    <th>CANTIDAD</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${ltaSubCap}" var="item">
                                <tr>
                                    <input type="hidden" name="propuesta_id" id="propuesta_id"value="${presc.propuesta_id}"/>
                                    <input type="hidden" name="idCap" id="idCap"value="${presc.capitulo_id}"/>
                                    <td>
                                        <c:set value="0" var="r" scope="page"/>
                                        <c:set value="" var="rTipo" scope="page"/>
                                        <c:forEach items="${ltaPresupuestos}" var="item2">
                                            <c:if test="${item2.subcapitulo.id==item.id}">
                                                <c:set value="1" var="r" scope="page"/>
                                                <c:set value="${item2.tipoCantidad}" var="rTipo" scope="page"/>
                                            </c:if>
                                        </c:forEach>
                                         <c:if test="${r==0}">
                                            <input type="checkbox" name="idSubCap" id="idSubCap" value="${item.id}" class="chk">
                                        </c:if>
                                        <c:if test="${r==1}">
                                            <input type="checkbox" name="idSubCap" id="idSubCap" value="${item.id}" class="chk" checked>
                                        </c:if>
                                    </td>
                                    <td><c:out value="${item.cod}" /></td>
                                    <td><c:out value="${item.nombre}" /></td>
                                    <td><c:out value="${item.nota}" /></td>
                                    <td><c:out value="${item.cantidad}" /></td>
                                    <td><select class="ddl" name="tipoCantidad" id="tipoc"  >
                                            <c:if test="${r==0}">
                                                <option value="und." >und.</option>
                                                    <option value="m2">m2</option>
                                            </c:if>
                                            <c:if test="${r==1}">
                                                <c:if test="${rTipo=='und.'}">
                                                    <option value="und." selected="true">und.</option>
                                                    <option value="m2">m2</option>
                                                </c:if> 
                                                <c:if test="${rTipo=='m2'}">
                                                    <option value="und.">und.</option>
                                                    <option value="m2" selected="true">m2</option>
                                                </c:if>   
                                            </c:if>    
                                        </select></td>
                                </tr> 
                                </c:forEach>
                               

                            </tbody>
                        </table>
                            
                        </div>
                </div>
               
                <div class="form-group">
                        <label id="" class="col-sm-1 control-label no-padding-right" for="form-field-1">  </label>

                        <div class="col-sm-11">
                               <button type="submit" class="btn btn-success col-xs-12 col-sm-4 col-md-3 col-lg-3">Siguiente<i class="ace-icon fa fa-arrow-right icon-on-right"></i></button>
                        </div>
                        
                </div>
                         
                <br/><br/>

                <div class="hr hr-dotted hr-16"></div>

        </form:form>
</div>
</div>	

					</div><!-- /.row -->
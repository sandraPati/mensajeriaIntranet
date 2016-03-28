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
        <h1>    
            <br/>
        <small>
            PRESUPUESTO
            
            <small>
                    <i class="ace-icon fa fa-angle-double-right"></i>
                    ${presup.descripcion}
            </small>
        </small>
        </h1>    
        </div>
    <div class="col-lg-4 align-right">
        <a class=" btn btn-white btn-warning" href="/Intranet/emp/EverPresupuesto.htm?idPres=${presup.presup_id}&idP=${idP}" data-rel="tooltip">
            <i class="ace-icon fa fa-reply icon-only"></i>

        </a>

    </div>
             
             
    </div>
</div><!-- /.page-header -->

<div class="row">
    <div class="col-xs-12">

        <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-6">
                
                <div class="profile-info-row">
                    <div class="profile-info-name"> CAPITULOS:</div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${presup.capitulo.cod}" /> <c:out value="${presup.capitulo.nombre}" /></span>
                    </div>
                </div>    
                <div class="profile-info-row">
                    <div class="profile-info-name"> SUB CAPITULOS: </div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${presup.subcapitulo.cod}" /> <c:out value="${presup.subcapitulo.nombre}" /></span>
                    </div>
                </div>
                <div class="profile-info-row">
                    <div class="profile-info-name">Registrar por: </div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${presup.tipoCantidad}" /></span>
                    </div>
                </div> 
            </div>        
            <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-6">        
                
                <div class="profile-info-row">
                    <div class="profile-info-name">DESCRIPCION: </div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${presup.descripcion}" /></span>
                    </div>
                </div>
                <div class="profile-info-row">
                    <div class="profile-info-name">metros/und </div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${presup.cantidad}" /></span>
                    </div>
                </div> 
                <div class="profile-info-row">
                    <div class="profile-info-name">precio: </div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${presup.subcapitulo.cantidad}" /></span>
                    </div>
                </div>
                <div class="profile-info-row">
                    <div class="profile-info-name">TOTAL </div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${presup.monto}" /></span>
                    </div>
                </div>    
        </div>
      

    </div>
</div>
 <br/>
 <c:if test="${not empty ltaPanos}">
<div class="row">
    <div class="col-xs-12">
          <c:forEach items="${ltaPanos}" var="item2">
        <div class="form-group">
            <label class="col-sm-1 control-label no-padding-right" for="form-field-1">ESTANCIA: </label>
        
                

                        <div class="col-sm-11">
                            <label class="control-label "><c:out value="${item2.estancia_id.tipo_estancia_id.nombre}" /><c:out value="${item2.estancia_id.otro_tipo}" /></label>
                            
                        </div>
                
                <br/>
                
                <c:forEach items="${item2.lta}" var="item3">
                <div class="form-group">
                    
                    
                    <label class="col-sm-1 control-label no-padding-right" for="form-field-1"> </label>
                    <label class="col-sm-1 control-label no-padding-right" for="form-field-1">* </label>

                        <div class="col-sm-2">
                            <label class="control-label "> <c:out value="${item3.pano.nombrepano}" /> </label>
                            
                        </div>
                    <label class="col-sm-1 control-label no-padding-right" for="form-field-1">Superficie: </label>

                        <div class="col-sm-7">
                            <label class="control-label "> <c:out value="${item3.pano.superficie}" /> </label>
                            
                        </div> 
                            <br/>
                            <c:forEach items="${item3.lta}" var="item4">
                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> </label>
                                    <div class="col-sm-2">
                                        <label class="control-label "> Ventana<c:out value="${item4.v.num}" /> </label>
                                    </div>
                                    <label class="col-sm-1 control-label no-padding-right" for="form-field-1">Superficie: </label>
                                    <div class="col-sm-2">
                                        <label class="control-label "> <c:out value="${item4.v.superficie}" /> </label>
                                    </div>
                                    <label class="col-sm-4 control-label no-padding-right" for="form-field-1"> </label>
                                    <br/><br/>
                                    
                                </div>
                                  
                            </c:forEach>
                            <br/>
                            <c:forEach items="${item3.ltap}" var="item5">
                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> </label>
                                    <div class="col-sm-2">
                                        <label class="control-label "> Puerta <c:out value="${item5.p.num}" /> </label>
                                    </div>
                                    <label class="col-sm-1 control-label no-padding-right" for="form-field-1">Superficie: </label>
                                    <div class="col-sm-2">
                                        <label class="control-label "> <c:out value="${item5.p.superficie}" /> </label>
                                    </div>
                                    <label class="col-sm-4 control-label no-padding-right" for="form-field-1"> </label>
                                    <br/><br/>
                                </div>
                            </c:forEach>
                            <br/>
                            <c:forEach items="${item3.ltaa}" var="item6">
                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> </label>
                                    <div class="col-sm-2">
                                        <label class="control-label "> Armario <c:out value="${item6.a.num}" /> </label>
                                    </div>
                                    <label class="col-sm-1 control-label no-padding-right" for="form-field-1">Superficie: </label>
                                    <div class="col-sm-2">
                                        <label class="control-label "> <c:out value="${item6.a.superficie}" /> </label>
                                    </div>
                                    <label class="col-sm-4 control-label no-padding-right" for="form-field-1"> </label>
                                    <br/><br/>
                                </div>
                            </c:forEach>
                            
                </div>
                            
                           
                            
                            
                </c:forEach>
                
            
       </div>         
        </c:forEach>
    </div>
</div>                    
</c:if>                   
</div><!-- /.row -->

<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- #section:settings.box -->
						
<div class="page-content">  
<div class="page-header">
    <div class="row">
        <div class="col-lg-8">   
        <h1>
               Popuesta: 
                <small>
                    <i class="ace-icon fa fa-angle-double-right"></i>
                   ${pa.estancia_id.propuesta_id.descipcion} del CLIENTE: ${pa.estancia_id.propuesta_id.cliente_nif.nif} ${pa.estancia_id.propuesta_id.cliente_nif.apellidos}, ${pa.estancia_id.propuesta_id.cliente_nif.nombre}
                </small>
        </h1>
      </div>
         <div class="col-lg-4 align-right">
            
            <a class=" btn btn-white btn-warning" href="/Intranet/emp/EverEstancias.htm?idE=${pa.estancia_id.id}" data-rel="tooltip">
                <i class="ace-icon fa fa-reply icon-only"></i>

            </a>
        </div>
        
             
             
    </div> 
</div><!-- /.page-header -->

<div class="row">
    <div class="col-xs-12">

        <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-4">
                
                <div class="profile-info-row">
                    <div class="profile-info-name"> ESTANCIA</div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${pa.estancia_id.numero}" />  <c:out value="${pa.estancia_id.tipo_estancia_id.nombre}" /> </span>
                    </div>
                </div>    
               
        </div>
       
    </div>
</div>

<br/>


<div class="page-header">
        <h1>
               Paño:
                <small>
                    <i class="ace-icon fa fa-angle-double-right"></i>
                   
                </small>
        </h1>       
</div><!-- /.page-header -->
<div class="row">
    <div class="col-xs-12">

        <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-2">
                
                <div class="profile-info-row">
                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${pa.nombrepano}" /> :
                            <c:if test="${pa.tipo_pano_id.id!=1}">
                                <c:if test="${pa.formapano==1}">Cuadrado</c:if>
                                <c:if test="${pa.formapano==2}">Rectangulo</c:if>
                                <c:if test="${pa.formapano==3}">'L'</c:if>
                                <c:if test="${pa.formapano==4}">Rombo</c:if>
                                <c:if test="${pa.formapano==5}">Trapecio</c:if>
                            </c:if>
                        </span>
                    </div>
                </div>    
               
                 
        </div>
                    
        <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-2">
                <div class="profile-info-row">
                    <div class="profile-info-name">
                            <c:if test="${pa.tipo_pano_id.id==1}">ALTO</c:if>
                            <c:if test="${pa.tipo_pano_id.id!=1}">
                                <c:if test="${pa.formapano==1}">a</c:if>
                                <c:if test="${pa.formapano==2}">a</c:if>
                                <c:if test="${pa.formapano==3}">a</c:if>
                                <c:if test="${pa.formapano==4}">D</c:if>
                                <c:if test="${pa.formapano==5}">b</c:if>
                            </c:if>
                    </div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${pa.alto}" /> m</span>
                    </div>
                </div>    
               
                
        </div>
        <c:if test="${pa.tipo_pano_id.id==1}">
        <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-2">
                <div class="profile-info-row">
                    <div class="profile-info-name">
                        LARGO
                           
                    </div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${pa.largo}" /> m</span>
                    </div>
                </div>  
                  
           
        </div>
        </c:if>
        <c:if test="${pa.tipo_pano_id.id!=1}">
            <c:if test="${pa.formapano==2}">
                <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-2">
                        <div class="profile-info-row">
                            <div class="profile-info-name">b
                            </div>

                            <div class="profile-info-value">
                                <span class="editable" id="username"><c:out value="${pa.largo}" /> m</span>
                            </div>
                        </div>  


                </div>
            </c:if>
            <c:if test="${pa.formapano==3}">
                <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-2">
                        <div class="profile-info-row">
                            <div class="profile-info-name">b
                            </div>

                            <div class="profile-info-value">
                                <span class="editable" id="username"><c:out value="${pa.largo}" /> m</span>
                            </div>
                        </div>  


                </div>
                <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-2">
                        <div class="profile-info-row">
                            <div class="profile-info-name">c
                            </div>

                            <div class="profile-info-value">
                                <span class="editable" id="username"><c:out value="${pa.lado3}" /> m</span>
                            </div>
                        </div>  


                </div>  
                <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-2">
                        <div class="profile-info-row">
                            <div class="profile-info-name">d
                            </div>

                            <div class="profile-info-value">
                                <span class="editable" id="username"><c:out value="${pa.lado4}" /> m</span>
                            </div>
                        </div>  


                </div>             
            </c:if>
            <c:if test="${pa.formapano==4}">
                <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-2">
                        <div class="profile-info-row">
                            <div class="profile-info-name">d
                            </div>

                            <div class="profile-info-value">
                                <span class="editable" id="username"><c:out value="${pa.largo}" /> m</span>
                            </div>
                        </div>  


                </div>
            </c:if>
            <c:if test="${pa.formapano==5}">
                <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-2">
                        <div class="profile-info-row">
                            <div class="profile-info-name">B
                            </div>

                            <div class="profile-info-value">
                                <span class="editable" id="username"><c:out value="${pa.largo}" /> m</span>
                            </div>
                        </div>  


                </div>
                <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-2">
                        <div class="profile-info-row">
                            <div class="profile-info-name">h
                            </div>

                            <div class="profile-info-value">
                                <span class="editable" id="username"><c:out value="${pa.lado3}" /> m</span>
                            </div>
                        </div>  


                </div>            
            </c:if>
        </c:if>
         <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-2">
                <div class="profile-info-row">
                    
                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${pa.superficie}" /></span>
                    </div>
                    <div class="profile-info-name">m cuadrados </div>

                </div> 
                
        </div>            
    </div>
    <c:if test="${pa.tipo_pano_id.id==1}"> 
    <div class="col-xs-8">
       <div class="hr hr-dotted hr-8"><br/><br/><br/></div> 
                         
                    
     </div> 
                   
     <div class="col-xs-12">
       <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-2">
                
                <div class="profile-info-row">
                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${pa.numventanas}" /> Ventanas</span>
                    </div>
                </div> 
               
                 
        </div>
                    
        <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-6">
                
                
        </div>                  
                    
     </div>     
                    
                    
    <c:forEach items="${pa.ventanaspano}" var="itemv">              
    <div class="col-xs-12">
       <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-1">
                
        </div>
         
        <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-1">
                 
                <div class="profile-info-row">
                    <div class="profile-info-name">N°</div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${itemv.num}" /></span>
                    </div>
                </div>     
                
                
        </div>
        <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-2">
                 
                <div class="profile-info-row">
                    <div class="profile-info-name">L </div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${itemv.largo}" /> m</span>
                    </div>
                </div>     
                
                
        </div>
        <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-2">
                
                <div class="profile-info-row">
                    <div class="profile-info-name">A</div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${itemv.alto}" /> m</span>
                    </div>
                </div> 
                 
           
        </div>
         <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-2">
                
                <div class="profile-info-row">
                    
                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${itemv.superficie}" /></span>
                    </div>
                    <div class="profile-info-name">m cuadrados </div>

                </div> 
                
        </div>                  
                    
     </div>                  
    </c:forEach>  
    
    <div class="col-xs-8">
       <div class="hr hr-dotted hr-8"><br/><br/><br/></div> 
                         
                    
     </div>
     <div class="col-xs-12">
       <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-2">
                
                <div class="profile-info-row">
                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${pa.numpuertas}" /> Puertas</span>
                    </div>
                </div> 
               
                 
        </div>
                    
        <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-6">
                
        </div>                  
                    
     </div>               
                        
                    
    <c:forEach items="${pa.puertaspano}" var="itemv">              
    <div class="col-xs-12">
       <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-1">
                
        </div>
         
        <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-1">
                 
                <div class="profile-info-row">
                    <div class="profile-info-name">N°</div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${itemv.num}" /></span>
                    </div>
                </div>     
                
                
        </div>
        <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-2">
                 
                <div class="profile-info-row">
                    <div class="profile-info-name">L </div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${itemv.largo}" /> m</span>
                    </div>
                </div>     
                
                
        </div>
        <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-2">
                
                <div class="profile-info-row">
                    <div class="profile-info-name">A</div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${itemv.alto}" /> m</span>
                    </div>
                </div> 
                 
           
        </div>
         <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-2">
                
                <div class="profile-info-row">
                    
                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${itemv.superficie}" /></span>
                    </div>
                    <div class="profile-info-name">m cuadrados </div>

                </div> 
                
        </div>                  
                    
     </div>                  
    </c:forEach>                
    
    <div class="col-xs-8">
       <div class="hr hr-dotted hr-8"><br/><br/><br/></div> 
                         
                    
     </div>                
     <div class="col-xs-12">
       <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-2">
                
                <div class="profile-info-row">
                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${pa.numarmarios}" /> Armarios</span>
                    </div>
                </div> 
               
                 
        </div>
                    
        <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-2">
             
        </div>                  
                    
     </div>             
                    
     <c:forEach items="${pa.armariospano}" var="itemv">              
    <div class="col-xs-12">
       <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-1">
                
        </div>
         
        <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-1">
                 
                <div class="profile-info-row">
                    <div class="profile-info-name">N°</div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${itemv.num}" /></span>
                    </div>
                </div>     
                
                
        </div>
        <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-2">
                 
                <div class="profile-info-row">
                    <div class="profile-info-name">L </div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${itemv.largo}" /> m</span>
                    </div>
                </div>     
                
                
        </div>
        <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-2">
                
                <div class="profile-info-row">
                    <div class="profile-info-name">A</div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${itemv.alto}" /> m</span>
                    </div>
                </div> 
                 
           
        </div>
         <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-2">
                
                <div class="profile-info-row">
                    
                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${itemv.superficie}" /></span>
                    </div>
                    <div class="profile-info-name">m cuadrados </div>

                </div> 
                
        </div>                  
                    
     </div>                  
    </c:forEach>                     
       </c:if>             
    <div class="col-xs-9">
       <div class="hr hr-dotted hr-6"><br/><br/><br/></div> 
                         
                    
     </div>            
    
    <div class="col-xs-12">
                    
        <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-7"></div>
         <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-2">
                    
                <div class="profile-info-row">
                    
                    <div class="profile-info-value">
                        <span class="editable" id="username">TOTAL:</span>
                    </div>
                    <div class="profile-info-name"><c:out value="${pa.total}" /> </div>

                </div> 
                 
        </div>   
    </div>
</div>

					</div><!-- /.row -->
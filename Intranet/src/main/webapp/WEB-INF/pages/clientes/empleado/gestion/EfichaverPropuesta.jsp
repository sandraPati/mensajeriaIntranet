<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- #section:settings.box -->
<div class="page-content">  						

<div class="page-header">
    <div class="row">
        <div class="col-lg-8">
        <h1>
               Propuestas 
                <small>
                    <i class="ace-icon fa fa-angle-double-right"></i>
                    ${prop.descipcion} 
                </small>
                <br/>
                 <small>
                    <i class="ace-icon fa fa-angle-double-right"></i>
                    Direccion: ${prop.direccion} ${prop.provincia} ${prop.poblacion} ${prop.pais} 
                </small>
        </h1>
        </div>
         <div class="col-lg-4 align-right">
            
            <a class=" btn btn-white btn-warning" href="/Intranet/emp/EfichaCliente.htm?nifC=${prop.cliente_nif.nif}" data-rel="tooltip">
                <i class="ace-icon fa fa-reply icon-only"></i>

            </a>
        </div>
             
             
    </div>
</div><!-- /.page-header -->
<c:forEach items="${ltaEstancias}" var="item">
<div class="row">
    <div class="col-xs-12">

        <div class="profile-striped col-xs-12">
            <div class="profile-info-row">
                <div class="profile-info-name">Estancia: <c:out value=" ${item.numero}" /></div>

                <div class="profile-info-value">
                    <span class="editable" id="username"><c:out value=" ${item.tipo_estancia_id.nombre}" /> <c:out value="${item.otro_tipo} " /></span>
                </div>
                
            </div>
           
                 <div class="hr hr-dotted hr-16"><br/><br/><br/></div>    
        </div>
                <div class="profile-striped col-xs-2"></div>
            <div class="profile-striped col-xs-10">
            <c:forEach items="${item.ltaPanos}" var="itemPanos">
                <div class="row">
                    <div class="col-xs-10">
                     <div class="hr hr-dotted"><hr/></div>
                     </div>
                    <div class="col-xs-12">
                    <c:out value=" ${itemPanos.tipo_pano_id.nombre}" /> <c:out value=" ${itemPanos.numero}" />
                    </div>
                    <div class="col-xs-2"></div>
                    <div class="col-xs-10">
                        <div class="profile-striped col-xs-2">
                             <div class="profile-info-row">
                                <div class="profile-info-name">
                                    L: <c:out value=" ${itemPanos.largo}" />m
                                    </div>
                            </div>
                        </div>    
                        <div class="profile-striped col-xs-2">        
                            <div class="profile-info-row">
                                <div class="profile-info-name">            
                                    A:<c:out value=" ${itemPanos.alto}" /> 
                                </div>
                            </div>
                        </div>     
                        <div class="profile-striped col-xs-2">        
                            <div class="profile-info-row">
                                <div class="profile-info-name">            
                                    Superficie:
                                </div>
                                <div class="profile-info-name"><c:out value=" ${itemPanos.superficie}" />m</div>
                                <div class="profile-info-name">cuadrados</div>
                                
                            </div>
                        </div>     
                    </div>
                    <div class="col-xs-2"></div>
                    <div class="col-xs-10">
                        <div ><br/></div> 
                    </div>
                    
                     <div class="col-xs-12">
       <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-2">
                
                <div class="profile-info-row">
                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${itemPanos.numventanas}" /> Ventanas</span>
                    </div>
                </div> 
               
                 
        </div>
                    
        <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-6">
                
                
        </div>                  
                    
     </div>     
                    
                    
    <c:forEach items="${itemPanos.ventanaspano}" var="itemv">              
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
        <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-3">
                 
                <div class="profile-info-row">
                    <div class="profile-info-name">L </div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${itemv.largo}" /> m</span>
                    </div>
                </div>     
                
                
        </div>
        <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-3">
                
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
                        <span class="editable" id="username"><c:out value="${itemPanos.numpuertas}" /> Puertas</span>
                    </div>
                </div> 
               
                 
        </div>
                    
        <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-6">
                
        </div>                  
                    
     </div>               
                        
                    
    <c:forEach items="${itemPanos.puertaspano}" var="itemv">              
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
        <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-3">
                 
                <div class="profile-info-row">
                    <div class="profile-info-name">L </div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${itemv.largo}" /> m</span>
                    </div>
                </div>     
                
                
        </div>
        <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-3">
                
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
                        <span class="editable" id="username"><c:out value="${itemPanos.numarmarios}" /> Armarios</span>
                    </div>
                </div> 
               
                 
        </div>
                    
        <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-2">
             
        </div>                  
                    
     </div>             
                    
     <c:forEach items="${itemPanos.armariospano}" var="itemv">              
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
        <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-3">
                 
                <div class="profile-info-row">
                    <div class="profile-info-name">L </div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${itemv.largo}" /> m</span>
                    </div>
                </div>     
                
                
        </div>
        <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-3">
                
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
                    
                  
                   
                </div>
            </c:forEach> 
        </div> 
     <div class="profile-striped col-xs-3"></div>          
     <div class="profile-striped col-xs-9">
         <div class="hr hr-dotted hr-16"><br/><br/><br/></div>   
            <div class="profile-info-row">
                <div class="profile-info-value">Total de superficie de estancia (suma de superficies de todos los paños)</div>
                <div class="profile-info-name"></div>
                <div class="profile-info-name">
                    <span class="editable" id="username"><c:out value="${item.totalSpanos}" /> m</span>
                </div>
                <div class="profile-info-name">cuadrados</div>
            </div>
            <div class="profile-info-row">
                <div class="profile-info-value">Total de superficie de estancia (sin elementos de los paños restando ventanas puertas y armarios)</div>
                <div class="profile-info-name"></div>
                <div class="profile-info-name">
                    <span class="editable" id="username"><c:out value="${item.superficie}" /> m</span>
                </div>
                <div class="profile-info-name">cuadrados</div>
            </div>
            <div class="profile-info-row">
                <div class="profile-info-value"> Total Superficie ventanas</div>
                
                <div class="profile-info-name">
                    <span class="editable" id="username"><c:out value="${item.numventanas}" /> Ventanas</span>
                </div>
                <div class="profile-info-name">
                    <span class="editable" id="username"><c:out value="${item.totalSventanas}" /> m</span>
                </div>
                <div class="profile-info-name">cuadrados</div>
            </div>    
            <div class="profile-info-row">
                <div class="profile-info-value"> Total Superficie Puertas</div>
                <div class="profile-info-name">
                    <span class="editable" id="username"><c:out value="${item.numpuertas}" /> Puertas</span>
                </div>
                <div class="profile-info-name">
                    <span class="editable" id="username"><c:out value="${item.totalSpuertas}" /> m</span>
                </div>
                <div class="profile-info-name">cuadrados</div>
            </div> 
            <div class="profile-info-row">
                <div class="profile-info-value"> Total Superficie Armarios</div>
                <div class="profile-info-name">
                    <span class="editable" id="username"><c:out value="${item.numarmarios}" /> Armarios</span>
                </div>
                <div class="profile-info-name">
                    <span class="editable" id="username"><c:out value="${item.totalSarmarios}" /> m</span>
                </div>
                <div class="profile-info-name">cuadrados</div>
            </div> 
            <div class="profile-info-row">
                <div class="profile-info-value"> Total Superficie suelos</div>
                <div class="profile-info-name"></div>
                <div class="profile-info-name">
                    <span class="editable" id="username"><c:out value="${item.totalSsuelos}" /> m</span>
                </div>
                <div class="profile-info-name">cuadrados</div>
            </div>     
            <div class="profile-info-row">
                <div class="profile-info-value"> Total Superficie Techos</div>
                <div class="profile-info-name"></div>
                <div class="profile-info-name">
                    <span class="editable" id="username"><c:out value="${item.totalStechos}" /> m</span>
                </div>
                <div class="profile-info-name">cuadrados</div>
            </div>      
                 <div class="hr hr-dotted hr-16"><br/><br/><br/></div>    
        </div>            
</div>
</div>         
  </c:forEach> 
<div class="page-header">
        <h1>
            Totales de Propuesta 
                <small>
                    <i class="ace-icon fa fa-angle-double-right"></i>                    
                </small>
        </h1>
    </div>

<div class="row">
    <div class="col-xs-12">
         <div class="profile-striped col-xs-12">  
            <div class="profile-info-row">
                <div class="profile-info-value">Total de superficie de estancia (suma de superficies de todos los paños)</div>
                <div class="profile-info-name"></div>
                <div class="profile-info-name">
                    <span class="editable" id="username"><c:out value="${prop.totalSpanos}" /> m</span>
                </div>
                <div class="profile-info-name">cuadrados</div>
            </div>
            <div class="profile-info-row">
                <div class="profile-info-value">Total de superficie de estancia (sin elementos de los paños restando ventanas puertas y armarios)</div>
                <div class="profile-info-name"></div>
                <div class="profile-info-name">
                    <span class="editable" id="username"><c:out value="${prop.superficie}" /> m</span>
                </div>
                <div class="profile-info-name">cuadrados</div>
            </div>
            <div class="profile-info-row">
                <div class="profile-info-value"> Total Superficie ventanas</div>
                <div class="profile-info-name">
                    <span class="editable" id="username"><c:out value="${prop.numventanas}" /> Ventanas</span>
                </div>
                <div class="profile-info-name">
                    <span class="editable" id="username"><c:out value="${prop.totalSventanas}" /> m</span>
                </div>
                <div class="profile-info-name">cuadrados</div>
            </div>    
            <div class="profile-info-row">
                <div class="profile-info-value"> Total Superficie Puertas</div>
                <div class="profile-info-name">
                    <span class="editable" id="username"><c:out value="${prop.numpuertas}" /> Puertas</span>
                </div>
                <div class="profile-info-name">
                    <span class="editable" id="username"><c:out value="${prop.totalSpuertas}" /> m</span>
                </div>
                <div class="profile-info-name">cuadrados</div>
            </div> 
            <div class="profile-info-row">
                <div class="profile-info-value"> Total Superficie Armarios</div>
                <div class="profile-info-name">
                    <span class="editable" id="username"><c:out value="${prop.numarmarios}" /> Armarios</span>
                </div>
                <div class="profile-info-name">
                    <span class="editable" id="username"><c:out value="${prop.totalSarmarios}" /> m</span>
                </div>
                <div class="profile-info-name">cuadrados</div>
            </div> 
            <div class="profile-info-row">
                <div class="profile-info-value"> Total Superficie suelos</div>
                <div class="profile-info-name"></div>
                <div class="profile-info-name">
                    <span class="editable" id="username"><c:out value="${prop.totalSsuelos}" /> m</span>
                </div>
                <div class="profile-info-name">cuadrados</div>
            </div>     
            <div class="profile-info-row">
                <div class="profile-info-value"> Total Superficie Techos</div>
                <div class="profile-info-name"></div>
                <div class="profile-info-name">
                    <span class="editable" id="username"><c:out value="${prop.totalStechos}" /> m</span>
                </div>
                <div class="profile-info-name">cuadrados</div>
            </div>      
                 <div class="hr hr-dotted hr-16"><br/><br/><br/></div>    
        </div>   
    </div>
</div>
</div>
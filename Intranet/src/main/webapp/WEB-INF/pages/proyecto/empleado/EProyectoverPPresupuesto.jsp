<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
 
<div class="page-content">  
<div class="page-header">
    <div class="row">
        <div class="col-lg-8">  
        <h1>
            Presupuesto
            <small>
                    <i class="ace-icon fa fa-angle-double-right"></i>
                    
            </small>
        </h1>
        </div>
         <div class="col-lg-4 align-right">
            
            <a class=" btn btn-white btn-warning" href="/Intranet/emp/EProyectoverLtaPresupuestos.htm?id=${idProy}&nifC=${nifC}" data-rel="tooltip">
                <i class="ace-icon fa fa-reply icon-only"></i>
            </a> 
        </div>
        
             
             
    </div>        
</div><!-- /.page-header -->   
        <div class="row" >
            <div class="col-xs-12">                             
                    <div class="form-group">
                            <div class="col-sm-12">
                                 <c:if test="${presup.estado==1}">
                                     <p class="alert alert-info">
                                         
                                            Presupuesto Pendiente 
                                     </p>
                                </c:if>
                                <c:if test="${presup.estado==2}">
                                    
                                    <p class="alert alert-success">
                                        
                                            Presupuesto Aprobado
                                            
                                    </p>
                                   
                                </c:if>
                                  <c:if test="${presup.estado==3}">
                                    
                                    <p class="alert alert-danger">
                                        
                                            Presupuesto Rechazado
                                         
                                    </p>
                                </c:if>   

                            </div>
                    </div> 
                </div> 
                    <div class="col-xs-9">
                            <!-- PAGE CONTENT BEGINS -->
                                   <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> DESCRIPCION </label>

                                            <div class="col-sm-9">
                                                <label class="col-sm-12 control-label no-padding-right" for="form-field-1">${presup.descripcion}</label>
                                                
                                            </div>
                                    </div>
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> MONTO: </label>

                                            <div class="col-sm-9">
                                                <label class="col-sm-12 control-label no-padding-right" for="form-field-1">${presup.monto}</label>
                                                
                                            </div>
                                    </div>
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> IVA: </label>

                                            <div class="col-sm-9">
                                                <label class="col-sm-12 control-label no-padding-right" for="form-field-1">${presup.iva}</label>
                                                
                                            </div>
                                            
                                    </div> 
                                   <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> NOTA: </label>

                                            <div class="col-sm-9">
                                                <label class="col-sm-12 control-label no-padding-right" for="form-field-1">${presup.nota}</label>
                                                
                                            </div>
                                    </div>
                                   
                                      

                    </div>
                    
                                                
                    <div class="col-xs-9">
                        <br/><br/><br/>
                        <div class="message-attachment clearfix">
                            <div class="attachment-title">
                                    <span class="blue bolder bigger-110">Attachments</span>
                                    &nbsp;


                            </div>

                            &nbsp;
                            <ul class="attachment-list pull-left list-unstyled">
                                 <c:forEach items="${ltaArc}" var="imagrar">
                                     
                                    <li>

                                                    <i class="ace-icon fa fa-file-o bigger-110"></i>
                                                    <span class="attached-name">${imagrar.nombre}</span>


                                            <span class="action-buttons">

                                                    <a href="/Intranet/resources/archivosProveedores/${imagrar.nombre}" id="btn_enviar">
                                                            <i class="ace-icon fa fa-download bigger-125 blue"></i>
                                                    </a>        
                                            </span>
                                    </li>
                                 </c:forEach>    

                            </ul>
                            <div class="attachment-images pull-right">
                                    <div class="vspace-4-sm"></div>

                                    <div>
                                        <c:forEach items="${ltaArc}" var="imag">
                                            <img width="100" alt="${imag.nombre}" src="/Intranet/resources/archivosProveedores/${imag.nombre}" />
                                        </c:forEach>

                                    </div>
                            </div>
                          
                    </div>
                    </div>                
        </div>

<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Presupuesto</h4>
      </div>
      
      <div class="modal-body">
         Presupuesto Rechazado Satisfactoriamente!
      </div>
      <div class="modal-footer">
        
        <button id="btn_aceptarD"type="button" class="btn btn-success" >Aceptar</button>
      </div>
    </div>

  </div>
</div> 
<script type="text/javascript">
 
       
    $(function(){

 $("#btn_enviar").click(function(){ 
     var ruta=$("#btn_enviar").attr("href");
    window.location.replace(ruta);
 });
    })		
</script> 
					</div><!-- /.row -->




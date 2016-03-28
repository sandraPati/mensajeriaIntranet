<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  


<div class="page-content">  

<div class="page-header">
    <div class="row">
        <div class="col-lg-8">  
        <h1>
            Seguimiento
            <small>
                    <i class="ace-icon fa fa-angle-double-right"></i>
                    
            </small>
        </h1>
        </div>
         <div class="col-lg-4 align-right">
            
            <a class=" btn btn-white btn-warning" href="/Intranet/sup/SeguimientoGPSEmpleado.htm?nif=${nif}" data-rel="tooltip">
                <i class="ace-icon fa fa-reply icon-only"></i>
            </a> 
        </div>
        
             
             
    </div>        
</div><!-- /.page-header -->   
        <div class="row" >
          
                    <div class="col-xs-9">
                                              
                                  
                                    <div class="form-group">
                                            

                                            <div class="col-sm-9" >
                                                <div id="mapa" style="width: 700px; height: 500px;">
                                                --ACA VA NUESTRO MAPA--
                                                </div>
                                            </div>
                                            <div class="col-sm-12" ><br/><br/> </div>
                                    </div>
                                   

                    </div>
                                 
        </div>


					</div><!-- /.row -->
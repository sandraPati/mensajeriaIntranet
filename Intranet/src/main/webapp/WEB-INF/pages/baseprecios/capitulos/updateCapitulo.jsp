<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<div class="page-content">  
<div class="page-header">
    <div class="row">
        <div class="col-lg-8">  
        <h1>
            Actualizar Capitulo
            <small>
                    <i class="ace-icon fa fa-angle-double-right"></i>

            </small>
        </h1>
        </div>
         <div class="col-lg-4 align-right">
            
            <a class=" btn btn-white btn-warning" href="/Intranet/sup/Capitulos.htm" data-rel="tooltip">
                <i class="ace-icon fa fa-reply icon-only"></i>
            </a> 
        </div>
        
             
             
    </div>        
</div><!-- /.page-header -->  
        <div class="row">
                    
                            <!-- PAGE CONTENT BEGINS -->
                            <form:form id="form1" action="" method="POST" commandName="capitulo" class="form-horizontal" role="form">
                                    <form:hidden id="id" path="id" value="${capitulo.id}"/>
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> COD: </label>

                                            <div class="col-sm-9">
                                                <form:input id="cod" type="text" class="col-xs-10 col-sm-5" placeholder="Cod" path="cod" required="true"/>
                                                
                                            </div>
                                    </div>
                                   
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> NOMBRE: </label>

                                            <div class="col-sm-9">
                                                <form:input id="nombre" type="text" class="col-xs-10 col-sm-5" placeholder="Nombre" path="nombre"/>
                                            </div>
                                    </div>
                                      <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1">  </label>

                                            <div class="col-sm-9">
                                               <button type="submit" class="btn btn-primary col-xs-12 col-sm-4 col-md-3 col-lg-3">Agregar</button>
                                            </div>
                                    </div>       
                                    


                            </form:form>
                    
							    </div>


					</div><!-- /.row -->

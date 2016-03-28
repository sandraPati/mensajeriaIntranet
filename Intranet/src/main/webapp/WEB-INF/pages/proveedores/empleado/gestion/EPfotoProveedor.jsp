<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

             
<div class="page-content">  
    
<div class="page-header">
    <h1>
        Actualizar Foto
        <small>
                <i class="ace-icon fa fa-angle-double-right"></i>
              
        </small>
    </h1>
</div><!-- /.page-header --> 
                


<div class="row">
    <div class="col-xs-12">
            <!-- PAGE CONTENT BEGINS -->
            <form:form id="form1" class="form-horizontal" enctype="multipart/form-data" action="" method="POST" commandName="proveedor">
               
                <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1">  </label>

                            <div class="col-sm-9">
                            <div class="col-sm-4">
                            <div class="widget-box">
                                    <div class="widget-header">
                                            <h4 class="widget-title">Subir Fotografia</h4>

                                            <div class="widget-toolbar">
                                                    <a href="#" data-action="collapse">
                                                            <i class="ace-icon fa fa-chevron-up"></i>
                                                    </a>

                                                   
                                            </div>
                                    </div>

                                    <div class="widget-body">
                                            <div class="widget-main">
                                                    <div class="form-group">
                                                            <div class="col-xs-12">
                                                                
                                                                    <form:input id="foto" type="file" class="col-xs-10 col-sm-5" placeholder="Foto" path="foto" />
                                                                    <!-- /section:custom/file-input -->
                                                            </div>
                                                    </div>
                                            </div>
                                    </div>
                            </div>
                            </div>
                            </div>
                    </div>
                                                                   
                   

                   <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> </label>
                            <div class="col-sm-9">
                                <button type="submit" class="btn btn-primary col-xs-12 col-sm-4 col-md-3 col-lg-3">Subir Foto</button>
                            </div>
                   </div>
                        
                    </p>
             </form:form>
    </div>
</div>


</div><!-- /.row -->
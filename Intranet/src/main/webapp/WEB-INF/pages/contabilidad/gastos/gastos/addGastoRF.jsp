<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<div class="page-content">			

<div class="page-header">
    <div class="row">
        <div class="col-lg-8">
        <h1>
            Otros Gastos
            
            <small>
                    <i class="ace-icon fa fa-angle-double-right"></i>
                   
            </small>
        </h1>
        </div>
    <div class="col-lg-4 align-right">
       
    </div>
             
             
    </div>
</div><!-- /.page-header -->
 		
<div class="row">
<div class="col-xs-12">
        <!-- PAGE CONTENT BEGINS -->
          <form:form id="form1" action="" method="POST" commandName="ga" enctype="multipart/form-data" class="form-horizontal message-form col-xs-12" role="form">
                <div class="well well-sm col-xs-5">
                <div class="col-sm-1"></div>
                <div class="col-sm-10">
                    
                    <div class="form-group" >
                        <label class="col-sm-12 " for="form-field-1"> Forma de Pago </label>

                        <div class="col-sm-12">
                            <form:input path="nombreimg" type="file" id="id-input-file-2" />


                        </div>
                    </div>
                    
                    <div class="form-group">
                        <div class="col-sm-6"></div>
                            <div class="col-sm-4">
                                   <button type="submit" class="btn btn-sm btn-success col-xs-12 col-sm-4 col-md-3 col-lg-12 ">Agregar</button>
                            </div>
                    </div>
                    </div> 
                    <div class="col-sm-1"></div>         
                </div>
                

        </form:form>
</div>
</div>	

					</div><!-- /.row -->
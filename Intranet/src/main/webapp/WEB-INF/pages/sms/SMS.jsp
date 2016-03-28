<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 

                
<div class="page-content">
<div class="page-header">
    <h1>
         Enviar Mensaje

    </h1>
</div><!-- /.page-header -->

						
<div class="row">
    <div class="col-xs-12">
            <h3 class="header smaller lighter blue"></h3>

            <div class="row">
                    <div class="col-xs-12">
                            <!-- PAGE CONTENT BEGINS -->
                             <form:form id="form1" class="form-horizontal" role="form" action="" method="POST" commandName="mensaje">
                            
                           
                                    <!-- #section:elements.form -->
                                  
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Movil </label>
                                            <div class="col-sm-3">
                                                <div class="input-group">
                                                        <span class="input-group-addon">
                                                                <i class="ace-icon fa fa-phone"></i>
                                                        </span>

                                                        <form:input class="form-control input-mask-phone" type="text" path="num"/>
                                                </div>

                                            </div>
                                    </div>
                                    
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Texto </label>

                                            <div class="col-sm-5">
                                                <form:textarea id="texto" path="texto"  class="form-control" rows="7"/>
                                                
                                               
                                            </div>
                                    </div>
                                   <div class="form-group">
                                            <label id="" class="col-sm-3 control-label no-padding-right" for="form-field-1">  </label>

                                            <div class="col-sm-9">
                                                   <button type="submit" class="btn btn-primary col-xs-12 col-sm-4 col-md-3 col-lg-3">Enviar</button>
                                            </div>
                                    </div>             
                            </form:form>
                    </div>
            </div>



    </div>

</div>
</div>             
                    

<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<div class="page-content">              
<div class="page-header">
    <h1>
        Actualizar Conocimiento
        <small>
                <i class="ace-icon fa fa-angle-double-right"></i>
              
        </small>
    </h1>
</div><!-- /.page-header -->   
        <div class="row">
                    <div class="col-xs-12">
                            <!-- PAGE CONTENT BEGINS -->
                            <form:form id="form1" action="" method="POST" commandName="conocimiento" class="form-horizontal" role="form">
                                <form:hidden path="id" value="id"/>
                                <form:hidden path="postulante_doc_identidad" />
                                    <!-- #section:elements.form -->
                                    
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Descripci&oacute;n</label>

                                            <div class="col-sm-9">
                                                <form:input id="descripcion" type="text" class="col-xs-10 col-sm-5" placeholder="Descripcion" path="descripcion" required="true"/>
                                                 
                                            </div>
                                    </div>
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Nivel </label>

                                            <div class="col-sm-9">

                                                    <div class="radio">
                                                            <label>
                                                                <form:radiobutton id="nivel" path="nivel" value="Basico" class="ace"/>
                                                                
                                                                    <span class="lbl"> Basico</span>
                                                            </label>
                                                    </div>

                                                    <div class="radio">
                                                            <label>
                                                                    <form:radiobutton id="nivel" path="nivel" value="Medio" class="ace"/>
                                                                    <span class="lbl"> Medio</span>
                                                            </label>
                                                    </div>
                                                    <div class="radio">
                                                            <label>
                                                                    <form:radiobutton id="nivel" path="nivel" value="Alto" class="ace"/>
                                                                    <span class="lbl"> Alto</span>
                                                            </label>
                                                    </div>
                                                    <div class="radio">
                                                            <label>
                                                                 <form:radiobutton id="nivel" path="nivel" value="Excelente" class="ace"/>
                                                                    <span class="lbl"> Excelente</span>
                                                            </label>
                                                    </div>
                                            </div>
                                    </div>
                                                
                                      <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1">  </label>

                                            <div class="col-sm-9">
                                               <button type="submit" class="btn btn-primary col-xs-12 col-sm-4 col-md-3 col-lg-3">Actualizar</button>
                                            </div>
                                    </div>       
                                    


                            </form:form>
                    </div>
							    </div>


					</div><!-- /.row -->
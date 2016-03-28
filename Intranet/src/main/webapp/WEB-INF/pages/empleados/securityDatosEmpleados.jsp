<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<div class="page-content">             
<div class="page-header">
    <h1>
        Actualizar Usuario y Contraseña
        <small>
                <i class="ace-icon fa fa-angle-double-right"></i>
              
        </small>
    </h1>
</div><!-- /.page-header --> 
                
<!-- #section:settings.box -->
<div class="row">
<div class="col-xs-12">
        <!-- PAGE CONTENT BEGINS -->

        <div>
                <div id="user-profile-1" class="user-profile row">
                      

                        <div class="col-xs-12 col-sm-9">

                            <form:form id="form1" class="form-horizontal" role="form" action="" method="POST" commandName="user">
                                <!-- #section:pages/profile.info -->
                                                <!-- #section:elements.form -->
                                                <div class="form-group">
                                                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Usuario </label>

                                                        <div class="col-sm-9">
                                                            
                                                            <form:input id="usuario" type="text" class="col-xs-10 col-sm-5" placeholder="Usuario" path="usuario" />
                            
                                                        </div>

                                                </div>
                                                <div class="form-group">
                                                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Contrase&ntilde;a </label>

                                                        <div class="col-sm-9">
                                                             <form:input id="contrasenna2" type="password" class="col-xs-10 col-sm-5" placeholder="Contraseña" path="contrasenna2"/>
                                                             
                                                        </div>
                                                </div>
                                                <div class="form-group">
                                                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Repetir Contrase&ntilde;a </label>

                                                        <div class="col-sm-9">
                                                             <form:input id="contrasenna" type="password" class="col-xs-10 col-sm-5" placeholder="Repetir Contraseña" path="contrasenna" />
                                                              
                                                        </div>
                                                </div>
                                                <div class="form-group" id="labelCoincide" hidden="true">
                                                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> </label>
                                                       
                                                        <div  class="col-sm-9">
                                                            <p class="text-success">Coinciden</p>
                                                        </div>
                                                       
                                                </div>
                                                <div class="form-group" id="labelNOCoincide" hidden="true">
                                                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> </label>
                                                       
                                                        <div  class="col-sm-9">
                                                            
                                                              <p class="text-danger">NO Coinciden</p>
                                                        </div>
                                                </div>  
                                                <div class="form-group">
                                                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">  </label>

                                                        <div class="col-sm-9">
                                                           <button type="submit" class="btn btn-primary col-xs-12 col-sm-4 col-md-3 col-lg-5">
                                                               <i class="ace-icon fa fa-lock"></i>Actualizar Usuario y Contrase&ntilde;a
                                                           </button>
                                                        </div>
                                                </div>
                                </form:form>


                        </div>
                </div>
        </div>



        <!-- PAGE CONTENT ENDS -->
</div><!-- /.col -->
</div><!-- /.row -->


</div><!-- /.row -->
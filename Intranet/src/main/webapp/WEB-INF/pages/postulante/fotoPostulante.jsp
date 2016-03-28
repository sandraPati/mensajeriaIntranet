
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<div class="page-content">
                
<!-- #section:settings.box -->
<div class="row">
<div class="col-xs-12">
        <!-- PAGE CONTENT BEGINS -->

        <div>
                <div id="user-profile-1" class="user-profile row">
                      

                        <div class="col-xs-12 col-sm-9">
    
            <form:form id="form1" class="form-horizontal" role="form" enctype="multipart/form-data" acceptCharset=""
           action="" method="POST">
                                <!-- #section:pages/profile.info -->
                                                <!-- #section:elements.form -->
                                                <div class="form-group">
                                                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Usuario </label>

                                                        <div class="col-sm-9">
                                                            <input type="text" name="name" />
                                                            <input type="file" name="file" />
                                                        </div>

                                                </div>
                                              
                                                <div class="form-group">
                                                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> </label>

                                                        <div class="col-sm-9">
                                                                <button type="submit" class="btn btn-white btn-purple btn-sm col-xs-10 col-sm-5 col-md-5 col-lg-4">Actualizar Usuario y Contrase&ntilde;a</button>
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
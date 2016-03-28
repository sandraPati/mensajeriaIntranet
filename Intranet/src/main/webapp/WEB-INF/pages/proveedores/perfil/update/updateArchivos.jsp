<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!-- /section:settings.box -->

<div class="page-content">
<div class="page-header">
    <h1>
         Agregar Mas Archivos

    </h1>
</div>
<!-- PAGE CONTENT BEGINS -->
<form:form id="form1" action="" method="POST" commandName="provPresupAdj" enctype="multipart/form-data" class="form-horizontal col-xs-12" role="form">
    <div class="col-sm-10"></div>
     <div class="col-sm-2">
    <button type="submit" class="btn btn-sm btn-primary no-border btn-white btn-round">
            <span class="bigger-110">Siguiente</span>

            <i class="ace-icon fa fa-arrow-right icon-on-right"></i>
    </button>
     </div>
    <br/>


        <div class="form-group no-margin-bottom">
                <label class="col-sm-3 control-label no-padding-right">Attachments:</label>

                <div class="col-sm-9">
                        <div id="form-attachments" >
                                <!-- #section:custom/file-input -->
                                <div class="form-group col-xs-10 col-sm-7 " >
                                <form:input path="nombre" type="file" />
                                </div>
                                <!-- /section:custom/file-input -->
                        </div>
                </div>
        </div>


        <div class="align-right">
                <button id="id-add-attachment" type="button" class="btn btn-sm btn-danger">
                        <i class="ace-icon fa fa-paperclip bigger-140"></i>
                        Add Attachment
                </button>
        </div>


    <!-- /section:pages/inbox.compose -->
    </form:form>

                                                
</div>


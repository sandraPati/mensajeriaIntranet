<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<div class="page-content">  
<div class="page-header">
    <div class="row">
        <div class="col-lg-4">
        <h1>
                Actualizar Tamaño Foto
                <small>
                        <i class="ace-icon fa fa-angle-double-right"></i>
                     
                </small>
        </h1>
        </div>
         <div class="col-lg-4 ">
            <a class=" btn btn-white btn-warning" href="/Intranet/sup/fotoSupervisor.htm" data-rel="tooltip">
               <i class="ace-icon fa fa-cloud-upload bigger-150"></i> Subir Foto
            </a>
            
        </div>
             
             
    </div>
</div><!-- /.page-header -->                


<div class="row">
    <div class="col-xs-12">
        
        <div>
            <div id="user-profile-1" class="user-profile row">
                
                    <div class="col-xs-12 col-sm-3 center">
                            <div>
                                    <!-- #section:pages/profile.picture -->
                                    <span class="profile-picture">
                                            <img id="avatar" class="editable img-responsive" width="300px" height="300px" alt="${empleado.apellidos}" src="/Intranet/resources/fotosPerfil/${empleado.nombrefotografia}" />
                                    </span>

                                    <!-- /section:pages/profile.picture -->
                                    <div class="space-4"></div>

                                    <div class="width-80 label label-info label-xlg arrowed-in arrowed-in-right">
                                            <div class="inline position-relative">
                                                    <a href="#" class="user-title-label dropdown-toggle" data-toggle="dropdown">
                                                            <i class="ace-icon fa fa-circle light-green"></i>
                                                            &nbsp;
                                                            <span class="white">${empleado.nombre} ${empleado.apellidos}</span>
                                                    </a>

                                                   
                                            </div>
                                    </div>
                            </div>

                            <div class="space-6"></div>

                            <!-- #section:pages/profile.contact -->
                         

                    </div>
                    <div class="col-xs-12 col-sm-9 ">
                         <form:form id="form1" class="form-horizontal"  action="" method="POST" commandName="empleado">
                            <form:hidden id="nif" path="nif"/>

                                <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Tama&ntilde;o de Foto </label>

                                        <div class="col-sm-3">

                                                <div class="radio">
                                                        <label>
                                                            <form:radiobutton id="tamanofoto" path="tamanofoto" value="Carnet /Primer plano" class="ace" />
                                                                <span class="lbl"> Carnet /Primer plano</span>
                                                        </label>
                                                </div>

                                                <div class="radio">
                                                        <label>
                                                            <form:radiobutton id="tamanofoto" path="tamanofoto" value="Cuerpo completo" class="ace" />                                                
                                                                <span class="lbl"> Cuerpo completo</span>
                                                        </label>
                                                </div>
                                                <div class="radio">
                                                        <label>
                                                            <form:radiobutton id="tamanofoto" path="tamanofoto" value="Otras" class="ace" />                                                
                                                                <span class="lbl"> Otras</span>
                                                        </label>
                                                </div>
                                        </div>
                                </div>

                               <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> </label>
                                        <div class="col-sm-9">
                                            <button type="submit" class="btn btn-primary col-xs-12 col-sm-4 col-md-3 col-lg-3">Actualizar</button>
                                        </div>
                               </div>

                                </p>
                         </form:form>
                    </div>                
                    
            </div>
    </div>
            <!-- PAGE CONTENT BEGINS -->
           
    </div>
</div>


</div><!-- /.row -->
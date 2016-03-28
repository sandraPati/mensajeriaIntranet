<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<div class="page-content">

<div class="page-header">
    <div class="row">
        <div class="col-lg-8">
        <h1>
            Agregar Certificacion
            <br/>
            <small>
                    <i class="ace-icon fa fa-angle-double-right"></i>
                   
            </small>
        </h1>
        </div>
    <div class="col-lg-4 align-right">
        <a class=" btn btn-white btn-warning" href="/Intranet/sup/verCertificaciones.htm?idPP=${idPP}" data-rel="tooltip">
            <i class="ace-icon fa fa-reply icon-only"></i>

        </a>

    </div>
             
             
    </div>
</div><!-- /.page-header -->
 		
<div class="row">
<div class="col-xs-12">
        <!-- PAGE CONTENT BEGINS -->
          <form:form id="form1" class="form-horizontal" role="form" action="" method="POST" commandName="proyCert">
                <form:hidden id="id_proyecto_presupuesto" path="id_proyecto_presupuesto.id" value="${idPP}"/>
                
               
                <div class="form-group" id="Otro">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">Semana:</label>

                        <div class="col-sm-9">
                            <form:input type="text" id="numsemana" path="numsemana" class="col-xs-10 col-sm-1" required="true"/>
                        </div>
                </div>
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Fecha:</label>

                        <div class="col-sm-9">
                                <div class="row">
                                        <div class="col-xs-12 col-sm-5 col-md-4 col-lg-3">
                                                <div class="input-group input-group-sm">
                                                    <form:input id="fecha" type="text" class="form-control" path="fecha" data-date-format="yyyy-mm-dd" required="true"/>
                                                   
                                                        <span class="input-group-addon">
                                                                <i class="ace-icon fa fa-calendar"></i>
                                                        </span>
                                                </div>
                                        </div>
                                </div>
                        </div>

                </div>        
                <div class="form-group" id="Otro">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">Porcentaje Terminado </label>

                        <div class="col-sm-9">
                            <form:input type="text" id="porcentaje_terminado" path="porcentaje_terminado" class="col-xs-10 col-sm-1" required="true"/>%
                        </div>
                </div>
                
                <div class="form-group">
                        <label id="" class="col-sm-3 control-label no-padding-right" for="form-field-1">  </label>

                        <div class="col-sm-9">
                               <button type="submit" class="btn btn-primary col-xs-12 col-sm-4 col-md-3 col-lg-3">Agregar</button>
                        </div>
                </div>
                         
                <br/><br/>

                <div class="hr hr-dotted hr-16"></div>

        </form:form>
</div>
</div>	

					</div><!-- /.row -->
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<div class="page-content"> 
<div class="page-header">
    <div class="row">
        <div class="col-lg-8">
        <h1>
            Actualizar Presupuesto de PROPUESTA:
            <small>
                    <i class="ace-icon fa fa-angle-double-right"></i>
                    ${p.descipcion} del CLIENTE: ${p.cliente_nif.nif} ${p.cliente_nif.apellidos}, ${p.cliente_nif.nombre}
            </small>
        </h1>
        </div>
    <div class="col-lg-4 align-right">
        <a class=" btn btn-white btn-warning" href="/Intranet/sup/Presupuesto.htm?idP=${p.id}" data-rel="tooltip">
            <i class="ace-icon fa fa-reply icon-only"></i>

        </a>

    </div>
             
             
    </div>
</div><!-- /.page-header -->
 		
<div class="row">
<div class="col-xs-12">
        <!-- PAGE CONTENT BEGINS -->
          <form:form id="form1" class="form-horizontal" role="form" action="" method="POST" commandName="presup">
              <form:hidden id="id" path="id" value="${presup.id}"/>  
              <form:hidden id="propuesta_id" path="propuesta_id" value="${p.id}"/>
                
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">CAPITULOS: </label>

                        <div class="col-sm-9">
                        <form:select id="capitulo_id" name="capitulo_id" path="capitulo_id.id" class="col-xs-10 col-sm-4" data-placeholder="Choose a State...">
                            <form:options items="${ltaCapitulos}" itemValue="id" itemLabel="nombre" />
                        </form:select>
                        </div>
                </div>
                
                <div class="form-group">
                        <label id="" class="col-sm-3 control-label no-padding-right" for="form-field-1">  </label>

                        <div class="col-sm-9">
                               <button type="submit" class="btn btn-success col-xs-12 col-sm-4 col-md-3 col-lg-3">
                                   Siguiente<i class="ace-icon fa fa-arrow-right icon-on-right"></i>
                               </button>
                        </div>
                </div>
                         
                <br/><br/>

                <div class="hr hr-dotted hr-16"></div>

        </form:form>
</div>
</div>	

					</div><!-- /.row -->
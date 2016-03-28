<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<div class="page-content">  
 
<div class="page-header">
    <div class="row">
        <div class="col-lg-8">
        <h1>
            Actualizar PLAN DE OBRA de PROPUESTA:
            <br/>
            <small>
                    <i class="ace-icon fa fa-angle-double-right"></i>
                    ${p.descipcion} del CLIENTE: ${p.cliente_nif.nif} ${p.cliente_nif.apellidos}, ${p.cliente_nif.nombre}
            </small>
        </h1>
        </div>
    <div class="col-lg-4 align-right">
        <a class=" btn btn-white btn-warning" href="/Intranet/emp/EPlanObra.htm?idPres=${proyPresu.id_presupuesto.id}" data-rel="tooltip">
            <i class="ace-icon fa fa-reply icon-only"></i>

        </a>

    </div>
             
             
    </div>
</div><!-- /.page-header -->
 		
<div class="row">
<div class="col-xs-12">
        <!-- PAGE CONTENT BEGINS -->
          <form:form id="form1" class="form-horizontal" role="form" action="" method="POST" commandName="proyPresu">
              <form:hidden id="id" path="id" value="${proyPresu.id}"/>
                <form:hidden id="id_presupuesto" path="id_presupuesto.id" value="${proyPresu.id_presupuesto.id}"/>
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">PRESUPUESTO: </label>

                        <div class="col-sm-9">
                            <label class="control-label ">${proyPresu.id_presupuesto.descripcion}</label>
                            
                        </div>
                </div>
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">CAPITULOS: </label>

                        <div class="col-sm-9">
                            <label class="control-label ">${proyPresu.id_presupuesto.capitulo.cod} ${proyPresu.id_presupuesto.capitulo.nombre} </label>
                            
                        </div>
                </div>
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">SUB CAPITULOS: </label>

                        <div class="col-sm-9">
                            <label class="control-label ">${proyPresu.id_presupuesto.subcapitulo.cod} ${proyPresu.id_presupuesto.subcapitulo.nombre} </label>
                            
                        </div>
                </div>
               
                <div class="form-group" id="Otro">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">N° Trabajadores:</label>

                        <div class="col-sm-9">
                            <form:input type="text" id="num_trabajadores" path="num_trabajadores" class="col-xs-10 col-sm-4" required="true"/>
                        </div>
                </div>
                <div class="form-group" id="Otro">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">N° Horas:</label>

                        <div class="col-sm-9">
                            <form:input type="text" id="numhoras" path="numhoras" class="col-xs-10 col-sm-4" required="true"/>
                        </div>
                </div>
                
                <div class="form-group">
                        <label id="" class="col-sm-3 control-label no-padding-right" for="form-field-1">  </label>

                        <div class="col-sm-9">
                               <button type="submit" class="btn btn-primary col-xs-12 col-sm-4 col-md-3 col-lg-3">Finish</button>
                        </div>
                </div>
                         
                <br/><br/>

                <div class="hr hr-dotted hr-16"></div>

        </form:form>
</div>
</div>	

					</div><!-- /.row -->

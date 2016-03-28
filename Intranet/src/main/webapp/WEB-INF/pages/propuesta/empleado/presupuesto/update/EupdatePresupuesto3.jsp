<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<div class="page-content">  
 
<div class="page-header">
    <div class="row">
        <div class="col-lg-8">
        <h1>
            Actualizar Presupuesto de PROPUESTA:
            <br/>
            <small>
                    <i class="ace-icon fa fa-angle-double-right"></i>
                    ${p.descipcion} del CLIENTE: ${p.cliente_nif.nif} ${p.cliente_nif.apellidos}, ${p.cliente_nif.nombre}
            </small>
        </h1>
        </div>
    <div class="col-lg-4 align-right">
        <a class=" btn btn-white btn-warning" href="/Intranet/emp/EupdatePresupuesto2.htm?idPres=${prec.id}&idP=${prec.propuesta_id}" data-rel="tooltip">
            <i class="ace-icon fa fa-reply icon-only"></i>

        </a>

    </div>
             
             
    </div>
</div><!-- /.page-header -->
 		
<div class="row">
<div class="col-xs-12">
        <!-- PAGE CONTENT BEGINS -->
          <form:form id="form1" class="form-horizontal" role="form" action="" method="POST" commandName="prec">
              <form:hidden id="id" path="id" />    
              <form:hidden id="propuesta_id" path="propuesta_id" value="${prec.propuesta_id}"/>
                <form:hidden id="capitulo_id" path="capitulo_id" value="${prec.capitulo_id}"/>
                <form:hidden id="descripcionmetros" path="descripcionmetros" value="${prec.descripcionmetros}"/>
                <form:hidden id="cantidadmetros" path="cantidadmetros" value="${prec.cantidadmetros}"/>
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">CAPITULOS: </label>

                        <div class="col-sm-9">
                            <label class="control-label ">${prec.cap.cod} ${prec.cap.nombre} </label>
                            
                        </div>
                </div>
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">SUB CAPITULOS: </label>

                        <div class="col-sm-9">
                            <label class="control-label "></label>
                            
                        </div>
                </div>
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">Registrar por: </label>

                        <div class="col-sm-9">
                            <label class="control-label ">und. </label>
                            
                        </div>
                </div>            
                
                
                <div class="form-group" id="Otro">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">DESCRIPCION:</label>

                        <div class="col-sm-9">
                            <form:input type="text" id="descripcion" path="descripcion" value="${prec.descripcion}"class="col-xs-10 col-sm-4" />
                        </div>
                </div>
                <div class="form-group" id="Otro">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">metros/und</label>

                        <div class="col-sm-9">
                            <form:input type="text" id="cantidad" path="cantidad" class="col-xs-10 col-sm-4" required="true"/>
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
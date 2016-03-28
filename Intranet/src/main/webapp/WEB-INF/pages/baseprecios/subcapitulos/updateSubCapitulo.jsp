<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<div class="page-content">  
<div class="page-header">
    <div class="row">
        <div class="col-lg-8">  
        <h1>
            Actualizar SUB Capitulo de Capitulo:
            <small>
                    <i class="ace-icon fa fa-angle-double-right"></i>
                    ${cap.cod} ${cap.nombre}
            </small>
        </h1>
        </div>
         <div class="col-lg-4 align-right">
            
            <a class=" btn btn-white btn-warning" href="/Intranet/sup/SubCapitulos.htm?codC=${cap.id}" data-rel="tooltip">
                <i class="ace-icon fa fa-reply icon-only"></i>
            </a> 
        </div>
        
             
             
    </div>        
</div><!-- /.page-header -->   
        <div class="row">
                    <div class="col-xs-12">
                            <!-- PAGE CONTENT BEGINS -->
                            <form:form id="form1" action="" method="POST" commandName="subcapitulo" class="form-horizontal" role="form">
                                <form:hidden id="id" path="id" />
                                <form:hidden id="id_capitulo" path="id_capitulo.id" value="${cap.id}"/>
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> CAPITULO: </label>

                                            <div class="col-sm-9">
                                                <label class=" control-label no-padding-right" for="form-field-1">${cap.cod} ${cap.nombre} </label>
                                            </div>
                                    </div>
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> COD: </label>

                                            <div class="col-sm-9">
                                                <form:input id="cod" type="text" class="col-xs-10 col-sm-5" placeholder="Cod" path="cod" required="true"/>
                                                
                                            </div>
                                    </div>
                                   
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> NOMBRE: </label>

                                            <div class="col-sm-9">
                                                <form:input id="nombre" type="text" class="col-xs-10 col-sm-5" placeholder="Nombre" path="nombre"/>
                                            </div>
                                    </div>
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Nota </label>

                                            <div class="col-sm-9">
                                                <form:textarea id="nota" type="text" class="col-xs-10 col-sm-5" placeholder="Nota" path="nota"rows="5"/>
                                            </div>
                                    </div> 
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> CANTIDAD: </label>

                                            <div class="col-sm-9">
                                                <form:input id="cantidad" type="text" class="col-xs-10 col-sm-1" placeholder="" path="cantidad"/>
                                            </div>
                                    </div>  
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> CANTIDAD: </label>

                                            <div class="col-sm-9">
                                                <form:select id="tipo" name="tipo" path="tipo"  data-placeholder="Choose a State...">
                                                    <form:option value="-"></form:option>
                                                        <form:option value="m"></form:option>
                                                        <form:option value="m2"></form:option>
                                                        <form:option value="m3"></form:option>
                                                        <form:option value="ml"></form:option>
                                                        <form:option value="kg"></form:option>
                                                        <form:option value="lm"></form:option>
                                                        <form:option value="ud"></form:option>
                                                </form:select>
                                            </div>
                                    </div>          
                                      <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1">  </label>

                                            <div class="col-sm-9">
                                               <button type="submit" class="btn btn-primary col-xs-12 col-sm-4 col-md-3 col-lg-3">Agregar</button>
                                            </div>
                                    </div>       
                                    


                            </form:form>
                    </div>
							    </div>


					</div><!-- /.row -->
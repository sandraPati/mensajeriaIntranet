<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  


<div class="page-content">  

<div class="page-header">
    <div class="row">
        <div class="col-lg-8">
        <h1>
        Actualizar Cliente
        <small>
                <i class="ace-icon fa fa-angle-double-right"></i>
        </small>
    </h1>
        </div>
         <div class="col-lg-4 align-right">
            <a class=" btn btn-white btn-warning" href="/Intranet/sup/Clientes.htm" data-rel="tooltip">
                <i class="ace-icon fa fa-reply icon-only"></i>
            </a>
            
        </div>
             
             
    </div>
</div><!-- /.page-header -->    		
<div class="row">
<div class="col-xs-12">
        <!-- PAGE CONTENT BEGINS -->
          <form:form id="form1" class="form-horizontal" role="form" action="" method="POST" commandName="cliente">
              
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> NIF </label>

                        <div class="col-sm-9">
                            <label class="control-label"> ${cliente.nif} </label>
                          
                        </div>
                </div>
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Nombre </label>

                        <div class="col-sm-9">
                            <form:input id="nombre" type="text" class="col-xs-10 col-sm-5" placeholder="Nombre" path="nombre" required="true"/>
                            
                        </div>
                </div>
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Apellidos </label>

                        <div class="col-sm-9">
                             <form:input id="apellidos" type="text" class="col-xs-10 col-sm-5" placeholder="Apellidos" path="apellidos" required="true"/>
                                
                        </div>
                </div>
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Direccion </label>

                        <div class="col-sm-9">
                             <form:input id="direccion" type="text" class="col-xs-10 col-sm-5" placeholder="Direccion" path="direccion" required="true"/>
                                
                        </div>
                </div>
                
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Pais </label>

                        <div class="col-sm-9">
                            <form:input id="pais" type="text" class="col-xs-10 col-sm-5" placeholder="Pais" path="pais" required="true"/>
                            
                        </div>
                </div>
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Provincia </label>

                        <div class="col-sm-9">
                            <form:input id="provincia" type="text" class="col-xs-10 col-sm-5" placeholder="Provincia" path="provincia" required="true"/>
                           
                        </div>
                </div>
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Población </label>

                        <div class="col-sm-9">
                            <form:input id="poblacion" type="text" class="col-xs-10 col-sm-5" placeholder="Población" path="poblacion" required="true"/>
                             
                        </div>
                </div>
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Nacionalidad </label>

                        <div class="col-sm-9">
                             <form:input id="nacionalidad" type="text" class="col-xs-10 col-sm-5" placeholder="Nacionalidad" path="nacionalidad" required="true"/>
                            
                        </div>
                </div>
               
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Codigo Postal </label>

                        <div class="col-sm-9">
                             <form:input id="codigo_postal" type="text" class="col-xs-10 col-sm-5" placeholder="Codigo Postal" path="codigo_postal" required="true"/>
                             
                        </div>
                </div>
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Telefono </label>

                        <div class="col-sm-9">
                            <form:input id="telefono" type="text" class="col-xs-10 col-sm-5" placeholder="Telefono" path="telefono" required="true"/>
                               
                        </div>
                </div>
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Otro Telefono </label>

                        <div class="col-sm-9">
                            <form:input id="otro_telefono" type="text" class="col-xs-10 col-sm-5" placeholder="Telefono" path="otro_telefono" />
                               
                        </div>
                </div>
               	
               
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Email </label>

                        <div class="col-sm-9">
                            <form:input id="email" type="text" class="col-xs-10 col-sm-5" placeholder="email" path="email" required="true"/>
                              
                        </div>

                </div>
               
                <div class="form-group">
                        <label id="" class="col-sm-3 control-label no-padding-right" for="form-field-1">  </label>

                        <div class="col-sm-9">
                               <button type="submit" class="btn btn-primary col-xs-12 col-sm-4 col-md-3 col-lg-3">Actualizar</button>
                        </div>
                </div>
                         
                <br/><br/>

                <div class="hr hr-dotted hr-16"></div>

        </form:form>
</div>
</div>	

					</div><!-- /.row -->
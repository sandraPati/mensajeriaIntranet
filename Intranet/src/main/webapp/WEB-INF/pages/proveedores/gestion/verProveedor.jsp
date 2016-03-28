<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<div class="page-content">  
<div class="page-header">
    <div class="row">
        <div class="col-lg-8">  
        <h1>
            Proveedor
            <small>
                    <i class="ace-icon fa fa-angle-double-right"></i>
                    
            </small>
        </h1>
        </div>
         <div class="col-lg-4 align-right">
            
            <a class=" btn btn-white btn-warning" href="/Intranet/sup/Gestion.htm" data-rel="tooltip">
                <i class="ace-icon fa fa-reply icon-only"></i>
            </a> 
        </div>
        
             
             
    </div>        
</div><!-- /.page-header -->   
        <div class="row" >
            <div class="col-xs-12 col-sm-3 center">
                            <div>
                                    <!-- #section:pages/profile.picture -->
                                    <span class="profile-picture">
                                            <img id="avatar" class="editable img-responsive" width="300px" height="300px" alt="${proveedor.nombre}" src="/Intranet/resources/fotosPerfil/proveedores/${proveedor.nombreFoto}" />
                                    </span>

                                    <!-- /section:pages/profile.picture -->
                                    <div class="space-4"></div>

                                    <div class="width-80 label label-info label-xlg arrowed-in arrowed-in-right">
                                            <div class="inline position-relative">
                                                    <a href="#" class="user-title-label dropdown-toggle" data-toggle="dropdown">
                                                            <i class="ace-icon fa fa-circle light-green"></i>
                                                            &nbsp;
                                                            <span class="white">${proveedor.nombre} </span>
                                                    </a>

                                                   
                                            </div>
                                    </div>
                            </div>

                            <div class="space-6"></div>

                            <!-- #section:pages/profile.contact -->
                         

                    </div>
                    <div class="col-xs-9">
                            <!-- PAGE CONTENT BEGINS -->
                                   <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> CIF: </label>

                                            <div class="col-sm-9">
                                                <label class="col-sm-12 control-label no-padding-right" for="form-field-1">${proveedor.cif}</label>
                                                
                                            </div>
                                    </div>
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> NOMBRE: </label>

                                            <div class="col-sm-9">
                                                <label class="col-sm-12 control-label no-padding-right" for="form-field-1">${proveedor.nombre}</label>
                                                
                                            </div>
                                    </div>
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> DIRECCION: </label>

                                            <div class="col-sm-9">
                                                <label class="col-sm-12 control-label no-padding-right" for="form-field-1">${proveedor.direccion}</label>
                                                <input type="hidden" id="direccion" value="${proveedor.direccion}"/>
                                                <br/><br/>
                                            </div>
                                            
                                    </div> 
                                    <div class="form-group">
                                            

                                            <div class="col-sm-9" >
                                                
                                                    <div id="map_canvas" style="width: 400px; height: 200px;"></div>
                                                
                                            </div>
                                            <div class="col-sm-12" ><br/><br/> </div>
                                    </div>
                                               
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> ACTIVIDAD: </label>

                                            <div class="col-sm-9">
                                                <label class="col-sm-12 control-label no-padding-right" for="form-field-1">${proveedor.id_actividad.nombre}</label>
                                                 
                                               
                                            </div>
                                    </div>  
                                     <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> EMAIL: </label>

                                            <div class="col-sm-9">
                                                <label class="col-sm-12 control-label no-padding-right" for="form-field-1">${proveedor.email}</label>
                                                
                                            </div>
                                    </div> 
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> TELEFONO: </label>

                                            <div class="col-sm-9">
                                                <label class="col-sm-12 control-label no-padding-right" for="form-field-1">${proveedor.telefono}</label>
                                               
                                            </div>
                                    </div>
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> PERSONA CONTACTO: </label>

                                            <div class="col-sm-9">
                                                 <label class="col-sm-12 control-label no-padding-right" for="form-field-1">${proveedor.persona_contacto}</label>
                                                
                                            </div>
                                    </div>           
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> LINK: </label>

                                            <div class="col-sm-9">
                                                 <label class="col-sm-12 control-label no-padding-right" for="form-field-1">${proveedor.link}</label>
                                                
                                            </div>
                                    </div>  
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> BANCO: </label>

                                            <div class="col-sm-9">
                                                 <label class="col-sm-12 control-label no-padding-right" for="form-field-1">${proveedor.banco}</label>
                                                
                                            </div>
                                    </div>
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> NUMERO CUENTA: </label>

                                            <div class="col-sm-9">
                                                 <label class="col-sm-12 control-label no-padding-right" for="form-field-1">${proveedor.num_cuenta}</label>
                                                
                                            </div>
                                    </div>
                                   
                                      

                    </div>
                <div class="col-xs-12">                             
                    <div class="form-group">
                            <div class="col-sm-12">
                                 <c:if test="${proveedor.aprobado==true}">
                                     <form:form id="form1" action="" method="POST" commandName="proveedor" class="form-horizontal" role="form">
                                             <form:hidden id="id" path="id" value="${proveedor.id}"/> 
                                     <p class="alert alert-info">
                                         
                                            Proveedor Aprobado 
                                           <button id="btn_desaprobar" class="btn btn-white btn-error  btn-round">
                                                   <i class="ace-icon fa fa-times bigger-120 red2"></i>
                                                   Desaprobar
                                           </button>
                                         

                                     </p>
                                     </form:form>
                                </c:if>
                                <c:if test="${proveedor.aprobado==false}">
                                    <form:form id="form2" action="" method="POST" commandName="proveedor" class="form-horizontal" role="form">
                                             <form:hidden id="id" path="id" value="${proveedor.id}"/> 
                                    <p class="alert alert-danger">
                                        
                                            Este Proveedor esta sin ser Aprobado. 
                                            <button id="btn_aprobar" class="btn btn-white btn-success  btn-round">
                                                    <i class="ace-icon glyphicon glyphicon-ok bigger-120 green"></i>
                                                    Aprobar
                                            </button>
                                        
                                    </p>
                                    </form:form>
                                </c:if>


                            </div>
                    </div> 
                </div> 
    <div class="col-xs-12">
        
        <div class="clearfix">
            <div class="pull-right tableTools-container2"></div>
        </div>
        
        <div class="table-header" STYLE="background-color:#8C94C6">
                Lista de Calificaciones
        </div>

        <!-- div.table-responsive -->

        <!-- div.dataTables_borderWrap -->
        <div class="table-responsive">
            <table id="dynamic-table2" class="table table-striped table-bordered table-hover table-condensed">
                <thead>
                    <tr>

                        <th>EMPLEADO</th>
                        <th>CALIFICACION</th>
                        <th>COMENTARIO</th>
                        <th>CALIDAD DE TRABAJO</th>
                        <th>LIMPIEZA Y ORDEN</th>
                        <th>PLAZOS DE EJECUCIÓN</th>
                        <th>CUMPLIMIENTO NORMATIVO</th>
                    </tr>
                </thead>

                    <tbody>
                        <c:forEach items="${listaCalificaciones}" var="item">
                            <tr>


                                    <td>
                                        <c:out value="${item.empleado_nif.nif}" />  <c:out value="${item.empleado_nif.apellidos}" />, <c:out value="${item.empleado_nif.nombre}" />
                                    </td>
                                    <td><c:out value="${item.calificacion}" /></td>
                                    <td><c:out value="${item.comentario}" /></td>
                                    <td><c:out value="${item.calidadtrabajo}" /></td>
                                    <td><c:out value="${item.limpiezaorden}" /></td>
                                    <td><c:out value="${item.plazos}" /></td>
                                    <td><c:out value="${item.cumplimiento}" /></td>
                                   
                            </tr>
                        </c:forEach> 


                    </tbody>
                </table>
            </div>
            <br/>
            <br/>                    
    </div>                        
        </div>

<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Nuevo Evento</h4>
      </div>
      
      <div class="modal-body">
         Proveedor Desaprobado
      </div>
      <div class="modal-footer">
        
        <button id="btn_aceptarD"type="button" class="btn btn-success" >Aceptar</button>
      </div>
    </div>

  </div>
</div>
<div id="myModal2" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Proveedor antes Aprobado</h4>
      </div>
      <form:form id="formASinUsu" class="form-horizontal" role="form" action="" method="POST" commandName="proveedor">
      <div class="modal-body">
         Este proveedor fue aprobado anteriormente, ¿Desea mantener con el mismo usuario y contraseña ? o ¿Desea cambiarlo?
         
             <form:hidden id="id" path="id" value="${proveedor.id}"/>
         <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Fecha Contrato </label>

                <div class="col-sm-9">
                     <div class="input-group input-group-sm">
                                <form:input id="fechaContrato1" type="text" class="form-control" path="fechaContrato" data-date-format="YYYY-MM-DD" required="true"/>   
                                     <span class="input-group-addon">
                                            <i class="ace-icon fa fa-calendar"></i>
                                    </span>
                            </div>

                </div>
        </div>
      </div>
      <div class="modal-footer">
        
        <button type="button" class="btn btn-default" id="btn_aceptarASinUsu">Mantener Usuario</button>
        <button type="button" class="btn btn-primary" id="btn_aceptarACUsu">Cambiar Usuario</button>
      </div>
             </form:form>
    </div>

  </div>
</div>
<div id="myModal3" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Usuario y Contraseña de Proveedor</h4>
      </div>
      
      <div class="modal-body">
                 <form:form id="formLP" class="form-horizontal" role="form" action="" method="POST" commandName="proveedor">
                                <!-- #section:pages/profile.info -->
                                                <!-- #section:elements.form -->
                                                 <div class="form-group">
                                                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Fecha Contrato </label>

                                                        <div class="col-sm-9">
                                                            <div class="input-group input-group-sm">
                                                                <form:input id="fechaContrato2" type="text" class="form-control" path="fechaContrato" data-date-format="YYYY-MM-DD" required="true"/>
                                                                <span class="input-group-addon">
                                                                        <i class="ace-icon fa fa-calendar"></i>
                                                                </span>
                                                            </div>

                                                             
                                                        </div>
                                                </div>
                                                <div class="form-group">
                                                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Usuario </label>

                                                        <div class="col-sm-9">
                                                            <form:hidden id="id" path="id" value="${proveedor.id}"/>
                                                            <form:hidden id="email" path="email" value="${proveedor.email}"/>
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
                                                             <form:input id="contrasenna" type="password" class="col-xs-10 col-sm-5" placeholder="Repetir Contraseña" path="contrasenna"  />
                                                              
                                                        </div>
                                                </div>
                                                             
                                                            
                                                <div class="form-group" id="labelCoincide">
                                                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> </label>
                                                       
                                                        <div  class="col-sm-9">
                                                            <p class="text-success">Coinciden</p>
                                                        </div>
                                                       
                                                </div>
                                                <div class="form-group" id="labelNOCoincide">
                                                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> </label>
                                                       
                                                        <div  class="col-sm-9">
                                                            
                                                              <p class="text-danger">NO Coinciden</p>
                                                        </div>
                                                </div>             
                                                 <div class="form-group">
                                                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">  </label>

                                                        <div class="col-sm-9">
                                                           <button id="btn_logeoProveedor" type="submit" class="btn btn-primary col-xs-12 col-sm-4 col-md-3 col-lg-5">
                                                               <i class="ace-icon fa fa-lock"></i>Actualizar
                                                           </button>
                                                        </div>
                                                </div>
                                </form:form>
      </div>
     
    </div>

  </div>
</div>  
<div id="myModalError" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Error</h4>
      </div>
      
      <div class="modal-body">
         Ocurrio un error!
         
      </div>
      <div class="modal-footer">
        
        <button type="button" class="btn btn-default" data-dismiss="modal">OK</button>
      </div>
    </div>

  </div>
</div>
<div id="myModalUpdUsu" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Usuario y Contraseña de Proveedor</h4>
      </div>
      
      <div class="modal-body">
                 <form:form id="formUpdUsu" class="form-horizontal" role="form" action="" method="POST" commandName="proveedor">
                                <!-- #section:pages/profile.info -->
                                                <!-- #section:elements.form -->
                                                <div class="form-group">
                                                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Fecha Contrato</label>

                                                        <div class="col-sm-9">
                                                             <div class="input-group input-group-sm">
                                                                        <form:input id="fechaContrato3" type="text" class="form-control" path="fechaContrato" data-date-format="YYYY-MM-DD" required="true"/>   
                                                                             <span class="input-group-addon">
                                                                                    <i class="ace-icon fa fa-calendar"></i>
                                                                            </span>
                                                                    </div>
                                                             
                                                        </div>
                                                </div>
                                                <div class="form-group">
                                                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Usuario </label>

                                                        <div class="col-sm-9">
                                                            <form:hidden id="id" path="id" value="${proveedor.id}"/>
                                                            <form:hidden id="email" path="email" value="${proveedor.email}"/>
                                                            <form:input id="usuario" type="text" class="col-xs-10 col-sm-5" placeholder="Usuario" path="usuario" />
                            
                                                        </div>

                                                </div>
                                                <div class="form-group">
                                                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Contrase&ntilde;a </label>

                                                        <div class="col-sm-9">
                                                             <form:input id="contrasenna2p" type="password" class="col-xs-10 col-sm-5" placeholder="Contraseña" path="contrasenna2"/>
                                                             
                                                        </div>
                                                </div>
                                                <div class="form-group">
                                                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Repetir Contrase&ntilde;a </label>

                                                        <div class="col-sm-9">
                                                             <form:input id="contrasennap" type="password" class="col-xs-10 col-sm-5" placeholder="Repetir Contraseña" path="contrasenna"  />
                                                              
                                                        </div>
                                                </div>
                                                <div class="form-group" id="labelCoincide2">
                                                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> </label>
                                                       
                                                        <div  class="col-sm-9">
                                                            <p class="text-success">Coinciden</p>
                                                        </div>
                                                       
                                                </div>
                                                <div class="form-group" id="labelNOCoincide2">
                                                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> </label>
                                                       
                                                        <div  class="col-sm-9">
                                                            
                                                              <p class="text-danger">NO Coinciden</p>
                                                        </div>
                                                </div>             
                                                 <div class="form-group">
                                                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">  </label>

                                                        <div class="col-sm-9">
                                                           <button id="btn_logeoProveedorUpdUsu" type="submit" class="btn btn-primary col-xs-12 col-sm-4 col-md-3 col-lg-5">
                                                               <i class="ace-icon fa fa-lock"></i>Actualizar
                                                           </button>
                                                        </div>
                                                </div>
                                </form:form>
      </div>
      
    </div>

  </div>
</div>                                                  
					</div><!-- /.row -->
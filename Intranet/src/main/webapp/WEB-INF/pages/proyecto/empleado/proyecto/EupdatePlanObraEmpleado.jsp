<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<div class="page-content">  
 
<div class="page-header">
    <div class="row">
        <div class="col-lg-8">
        <h1>
            Asignar Empleado a PLAN de OBRA:
            <br/>
            <small>
                    <i class="ace-icon fa fa-angle-double-right"></i>
                   
            </small>
        </h1>
        </div>
    <div class="col-lg-4 align-right">
        <a class=" btn btn-white btn-warning" href="/Intranet/emp/EPlanObraEmpleados.htm?idPP=${idPP}" data-rel="tooltip">
            <i class="ace-icon fa fa-reply icon-only"></i>

        </a>

    </div>
             
             
    </div>
</div><!-- /.page-header -->
 		
<div class="row">
<div class="col-xs-12">
        <!-- PAGE CONTENT BEGINS -->
          <form:form id="form1" class="form-horizontal" role="form" action="" method="POST" commandName="proyTrabajadores">
              <form:hidden id="id" path="id" value="${proyTrabajadores.id}"/>  
              <form:hidden id="id_proyecto_presupuesto" path="id_proyecto_presupuesto.id" value="${proyTrabajadores.id_proyecto_presupuesto.id}"/>
               <form:hidden id="nif_empleado" path="nif_empleado.nif" value="${proyTrabajadores.nif_empleado.nif}"/>
                 <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Empleado</label>

                        <div class="col-sm-9">
                           <label class=" no-padding-right control-label" >
                               ${proyTrabajadores.nif_empleado.nif} ${proyTrabajadores.nif_empleado.apellidos}, ${proyTrabajadores.nif_empleado.nombre}
                           </label>
                           
                        </div>

                </div>  
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Fecha Inicio </label>

                        <div class="col-sm-9">
                                <div class="row">
                                        <div class="col-xs-12 col-sm-5 col-md-4 col-lg-3">
                                                <div class="input-group input-group-sm">
                                                    <form:input id="finicio" type="text" class="form-control" path="finicio" />
                                                   
                                                        <span class="input-group-addon">
                                                                <i class="fa fa-clock-o bigger-110"></i>

                                                        </span>
                                                </div>
                                                 

                                        </div>
                                </div>
                        </div>

                </div>
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Fecha Inicio </label>

                        <div class="col-sm-9">
                                <div class="row">
                                        <div class="col-xs-12 col-sm-5 col-md-4 col-lg-3">
                                                <div class="input-group input-group-sm">
                                                    <form:input id="ffin" type="text" class="form-control" path="ffin" />
                                                   
                                                        <span class="input-group-addon">
                                                                <i class="fa fa-clock-o bigger-110"></i>

                                                        </span>
                                                </div>
                                                 

                                        </div>
                                </div>
                        </div>

                </div> 
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> N� Horas:</label>

                        <div class="col-sm-9">
                            <form:input id="numhoras" type="text" class="col-xs-10 col-sm-1" placeholder="N� Horas" path="numhoras" />
                             
                        </div>

                </div>  
                 <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Asunto</label>

                        <div class="col-sm-9">
                            <form:textarea id="descripcion" type="text" class="col-xs-10 col-sm-6" placeholder="Asunto" path="descripcion" />
                            

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
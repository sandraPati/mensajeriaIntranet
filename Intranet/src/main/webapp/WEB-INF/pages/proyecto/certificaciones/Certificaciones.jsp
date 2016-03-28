<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!-- #section:settings.box -->
						
<div class="page-content">
<div class="page-header">
    <div class="row">
        <div class="col-lg-8">
        <h1>
               Propuesta: 
                <small>
                    <i class="ace-icon fa fa-angle-double-right"></i>
                   ${prop.descipcion} del CLIENTE: ${prop.cliente_nif.nif} ${prop.cliente_nif.apellidos}, ${prop.cliente_nif.nombre}
                </small>
        </h1>
        </div>
         <div class="col-lg-4 align-right">
            
            <a class=" btn btn-white btn-warning" href="/Intranet/sup/verPropuestasP.htm?nifC=${prop.cliente_nif.nif}" data-rel="tooltip">
                <i class="ace-icon fa fa-reply icon-only"></i>

            </a>
        </div>
        
             
             
    </div>
</div><!-- /.page-header -->

<br/>


<div class="page-header">
   
        <h1>
               Capitulos 
                <small>
                    <i class="ace-icon fa fa-angle-double-right"></i>
                   
                </small>
        </h1>
    
</div><!-- /.page-header -->
<c:if test="${not empty error}">
	<div class="alert alert-danger">
            <button type="button" class="close" data-dismiss="alert">
                    <i class="ace-icon fa fa-times"></i>
            </button>

            <strong>
                    <i class="ace-icon fa fa-times"></i>
                    
            </strong>

            ${error}
            <br />
        </div>

    </c:if>
    <c:if test="${not empty msg}">
	<div class="alert alert-block alert-success">
            <button type="button" class="close" data-dismiss="alert">
                    <i class="ace-icon fa fa-times"></i>
            </button>

            <strong>
                    <i class="ace-icon fa fa-check"></i>
                    
            </strong>

            ${msg}
            <br />
        </div>

    </c:if>
<div class="row">
   
    <div class="col-xs-12">
        <form:form id="form1" action="/Intranet/sup/verCertificacionesSemanaPdf.htm" method="POST" commandName="certificacion"> 
                               
                                    <!-- #section:elements.form -->
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> N° Semana </label>

                                            <div class="col-sm-9">
                                                <form:input type="text" id="numsemana1" path="numsemana" required="true" value="0"/>
                                            </div>

                                    </div>
                             
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1">  </label>

                                            <div class="col-sm-9">
                                                <br/>
                                               <button id="vercert" type="submit" class="btn btn-primary col-xs-12 col-sm-4 col-md-3 col-lg-3">Ver Certificacion</button>
                                            </div>
                                    </div> 

                            </form:form>
                              
        <form:form id="form2" action="/Intranet/sup/enviarCertificacionSemana.htm" method="POST" commandName="certificacion"> 
                               
                                    <!-- #section:elements.form -->
                                    <div class="form-group">
                                            
                                            <div class="col-sm-12">
                                                <form:hidden id="numsemana2" path="numsemana"/>
                                            </div>

                                    </div>
                             
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1">  </label>

                                            <div class="col-sm-9">
                                                <br/>
                                                <button id="enviar" type="submit" class="btn btn-primary col-xs-12 col-sm-4 col-md-3 col-lg-3">Enviar Certificacion</button>
                                            </div>
                                    </div> 

        </form:form>                            
    </div>
</div>

<div class="row">
    <div class="col-xs-12">
        
        <div class="clearfix">
            <div class="pull-right tableTools-container2"></div>
        </div>
        
        <div class="table-header" STYLE="background-color:#8C94C6">
                Lista de Capitulos
        </div>

        <!-- div.table-responsive -->

        <!-- div.dataTables_borderWrap -->
        <div class="table-responsive">
            <table id="dynamic-table2" class="table table-striped table-bordered table-hover table-condensed">
                <thead>
                    <tr>

                        <th>COD</th>
                        <th>NOMBRE</th>
                        <th></th>
                    </tr>
                </thead>

                    <tbody>
                        <c:forEach items="${capitulosLista}" var="item">
                            <tr>


                                    <td>
                                        <c:out value="${item.cap.cod}" />
                                    </td>
                                    <td>
                                        <c:out value="${item.cap.nombre}" /> 
                                    </td>
                                    <td>
                                            <div class="hidden-sm hidden-xs action-buttons">
                                                <a class="blue tooltip-info" data-rel="tooltip" href="/Intranet/sup/ProyectoPresupuestoC.htm?idPres=${item.id}&idP=${prop.id}" title="Ver Sub Capitulos">
                                                            <i class="ace-icon fa fa-search-plus bigger-130"></i>
                                                    </a>    
                                                           

                                            </div>

                                            <div class="hidden-md hidden-lg">
                                                    <div class="inline pos-rel">
                                                            <button class="btn btn-minier btn-yellow dropdown-toggle" data-toggle="dropdown" data-position="auto">
                                                                    <i class="ace-icon fa fa-caret-down icon-only bigger-120"></i>
                                                            </button>

                                                            <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
                                                                    <li>
                                                                            <a href="/Intranet/sup/ProyectoPresupuestoC.htm?idPres=${item.id}&idP=${prop.id}" class="tooltip-info" data-rel="tooltip" title="Ver Sub Capitulos">
                                                                                    <span class="blue">
                                                                                            <i class="ace-icon fa fa-search-plus bigger-120"></i>
                                                                                    </span>
                                                                            </a>

                                                                    </li>
                                                                   

                                                            </ul>
                                                    </div>
                                            </div>
                                    </td>

                            </tr>
                        </c:forEach> 


                    </tbody>
                </table>
        </div>
        <br/>
        <br/>                    
</div>
</div>

</div><!-- /.row -->
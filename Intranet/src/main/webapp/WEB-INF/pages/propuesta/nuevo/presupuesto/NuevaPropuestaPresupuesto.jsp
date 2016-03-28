<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<div class="page-content"> 
 		
<div class="row">
    <div class="col-xs-12">
        <ul class="steps  ">
                <li data-step="1 " class="active ">
                        <span class="step "><i class="ace-icon glyphicon glyphicon-ok bigger-100 light-green"></i></span>
                        <span class="title ">Seleccionar un Ciente</span>
                </li>

                <li data-step="2" class="active ">
                        <span class="step"><i class="ace-icon glyphicon glyphicon-ok bigger-100 light-green"></i></span>
                        <span class="title">Registro de Estancias</span>
                </li>

                <li data-step="3" class="active ">
                        <span class="step">3</span>
                        <span class="title">Presupuesto</span>
                </li>

                <li data-step="4">
                        <span class="step">4</span>
                        <span class="title">Envio de Presupuesto</span>
                </li>
                
        </ul>
    </div>
</div>
        
   
    <br/>
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
    <br/>
    <div class="row">
        
               
<div class="col-xs-12">
    <div class="tabbable">
                 <ul class="nav nav-tabs padding-12 tab-color-blue background-blue" id="myTab4">
                        
                    </ul>
                <div class="tab-content">
                    
                            <div id="home4" class="tab-pane in active">
        <div class="col-lg-12 align-right">
            <a class=" btn btn-white btn-warning" href="/Intranet/sup/NuevaPropuestaVerEstancia.htm?idP=${p.id}" data-rel="tooltip">
                <i class="ace-icon fa fa-reply icon-only"></i>

            </a> 
                <a class="btn btn-success  btn-md "  href="/Intranet/sup/NuevaPropuestaVerPresupuestoPdf.htm?idP=${p.id}">
                   Paso 4: Ver PRESUPUESTO y enviar<i class="ace-icon fa fa-arrow-right icon-on-right"></i>
                </a>
        </div>
                 <br/><br/><br/>
        <!-- PAGE CONTENT BEGINS -->
          <form:form id="form1" class="form-horizontal" role="form" action="" method="POST" commandName="presup">
                
                
                <div class="form-group">
                        <label class="col-sm-1 control-label no-padding-right" for="form-field-1">CAPITULOS: </label>

                        <div class="col-sm-11">
                        
                        <table id="dynamic-table2" class="table table-striped table-bordered table-hover table-condensed">
                             <thead>
                                <tr>
                                    <th></th>
                                    <th>COD</th>
                                    <th>NOMBRE</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${ltaCapitulos}" var="item">
                                <tr>
                                    <input type="hidden" name="propuesta_id" id="propuesta_id"value="${p.id}"/>
                                    <td>
                                        <c:if test="${item.id!=0}">
                                            <input type="checkbox" name="idCap" id="idCap" value="${item.cap.id}" class="chk" checked="true">
                                         </c:if>
                                        <c:if test="${item.id==0}">
                                            <input type="checkbox" name="idCap" id="idCap" value="${item.cap.id}" class="chk">
                                        </c:if>
                                    </td>
                                    <td><c:out value="${item.cap.cod}" /></td>
                                    <td><c:out value="${item.cap.nombre}" /></td>
                                    <td>
                                        <div id="SubCapCheck">
                                            <c:if test="${item.id!=0}">
                                                <div class="SubCapCheckIcon1">
                                            <a class="blue tooltip-info" data-rel="tooltip"href="/Intranet/sup/NuevaPropuestaPresupuesto2.htm?idP=${p.id}&idC=${item.cap.id}"title="Ver_SubCapitulos">
                                                <i class="ace-icon fa  fa-pencil-square-o bigger-130"></i>
                                            </a>
                                              
                                                 </div>
                                            </c:if>
                                            <div class="SubCapCheckIcon" hidden="true">
                                            <a class="blue tooltip-info" data-rel="tooltip"href="/Intranet/sup/NuevaPropuestaPresupuesto2.htm?idP=${p.id}&idC=${item.cap.id}"title="Ver_SubCapitulos">
                                                <i class="ace-icon fa  fa-pencil-square-o bigger-130"></i>
                                            </a>
                                                </div>
                                        </div>
                                    </td>
                                </tr> 
                                </c:forEach>
                               

                            </tbody>
                        </table>
                        </div>
                </div>
                
                         
                <br/><br/>

                <div class="hr hr-dotted hr-16"></div>

        </form:form>
                            </div></div>
    </div>
</div>
</div>	
</div><!-- /.row -->
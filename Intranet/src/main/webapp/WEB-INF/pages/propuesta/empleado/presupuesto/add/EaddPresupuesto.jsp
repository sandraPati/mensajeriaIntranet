<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

                
<div class="page-content">  
 
<div class="page-header">
    <div class="row">
        <div class="col-lg-8">
        <h1>
            Nuevo Presupuesto de PROPUESTA:
            <small>
                    <i class="ace-icon fa fa-angle-double-right"></i>
                    ${p.descipcion} del CLIENTE: ${p.cliente_nif.nif} ${p.cliente_nif.apellidos}, ${p.cliente_nif.nombre}
            </small>
        </h1>
        </div>
    <div class="col-lg-4 align-right">
        <a class=" btn btn-white btn-warning" href="/Intranet/emp/EPresupuesto.htm?idP=${p.id}" data-rel="tooltip">
            <i class="ace-icon fa fa-reply icon-only"></i>

        </a>

    </div>
             
             
    </div>
</div><!-- /.page-header -->
 		
<div class="row">
<div class="col-xs-12">
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
                                            <a class="blue tooltip-info" data-rel="tooltip"href="/Intranet/emp/EaddPresupuesto2.htm?idP=${p.id}&idC=${item.cap.id}"title="Ver_SubCapitulos">
                                                <i class="ace-icon fa  fa-pencil-square-o bigger-130"></i>
                                            </a>
                                              
                                                 </div>
                                            </c:if>
                                            <div class="SubCapCheckIcon" hidden="true">
                                            <a class="blue tooltip-info" data-rel="tooltip"href="/Intranet/emp/EaddPresupuesto2.htm?idP=${p.id}&idC=${item.cap.id}"title="Ver_SubCapitulos">
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
</div>
</div>	

					</div><!-- /.row -->
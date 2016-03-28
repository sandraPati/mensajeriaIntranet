<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<div class="page-content">                  
 
<div class="page-header">
    <div class="row">
        <div class="col-lg-8">
        <h1>
            Nuevo Presupuesto 
            
            de PROPUESTA:
            <br/>
            <small>
                    <i class="ace-icon fa fa-angle-double-right"></i>
                    ${p.descipcion} del CLIENTE: ${p.cliente_nif.nif} ${p.cliente_nif.apellidos}, ${p.cliente_nif.nombre}
            </small>
        </h1>
        </div>
    <div class="col-lg-4 align-right">
        <a class=" btn btn-white btn-warning" href="/Intranet/sup/addPresupuesto2.htm?idP=${p.id}&idC=${idC}" data-rel="tooltip">
            <i class="ace-icon fa fa-reply icon-only"></i>

        </a>

    </div>
             
             
    </div>
</div><!-- /.page-header -->
 <div class="row">
    <div class="col-xs-12">
        
        <div class="clearfix">
            <div class="pull-right tableTools-container2"></div>
        </div>
        
        <div class="table-header" STYLE="background-color:#8C94C6">
            Elegir Estancia
        </div>

        <!-- div.table-responsive -->

        <!-- div.dataTables_borderWrap -->
        <div class="table-responsive">
            
            <table  class="table table-striped table-bordered table-hover table-condensed">
                <thead>
                    <tr>

                        <th>N°</th>
                        <th>NOMBRE ESTANCIA</th>
                        <th>Total Superficie</th>
                        <th colspan="2"></th>
                    </tr>
                </thead>

                    <tbody>
                        <c:forEach items="${ltaEstancias}" var="item">
                            <tr>


                                    <td>
                                         <c:out value="${item.numero}" />
                                    </td>
                                    <td><c:out value="${item.tipo_estancia_id.nombre}" /></td>
                                    <td><c:out value="${item.totalSpanos}" /></td>

                                    <td>
                                        <c:if test="${item.asignado==1}">
                                            <input type="checkbox" name="idEst" id="idEst" value="${item.id}" class="chk" checked="true">
                                         </c:if>
                                        <c:if test="${item.asignado==0}">
                                            <input type="checkbox" name="idEst" id="idEst" value="${item.id}" class="chk">
                                        </c:if>
                                            
                                    </td>
                                    <td>
                                        <div id="SubCapCheck">
                                            <c:if test="${item.asignado==1}">
                                                <div class="SubCapCheckIcon1">
                                            <a class="blue tooltip-info" data-rel="tooltip"href="/Intranet/sup/addPresupuesto5.htm?idE=${item.id}&idP=${p.id}&idPre=${idPre}&idSC=${idSC}&idPresup=${pres1}"title="Asignar_Panos">
                                                <i class="ace-icon fa  fa-pencil-square-o bigger-130"></i>
                                            </a>
                                              
                                                 </div>
                                            </c:if>
                                            <div class="SubCapCheckIcon" hidden="true">
                                            <a class="blue tooltip-info" data-rel="tooltip"href="/Intranet/sup/addPresupuesto5.htm?idE=${item.id}&idP=${p.id}&idPre=${idPre}&idSC=${idSC}&idPresup=${pres1}"title="Asignar_Panos">
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
        <br/>
        <br/>                    
</div>
</div>
					</div><!-- /.row -->
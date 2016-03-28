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
    <div class="row">
        
<div class="col-xs-12">
        <div class="tabbable">
                 <ul class="nav nav-tabs padding-12 tab-color-blue background-blue" id="myTab4">
                        
                    </ul>
                <div class="tab-content">
                    
                            <div id="home4" class="tab-pane in active">
        <div class="col-lg-12 align-right">
            <a class=" btn btn-white btn-warning" href="/Intranet/emp/ENuevaPropuestaPresupuesto4.htm?idP=${p.id}&idPre=${idPre}&idSC=${idSC}" data-rel="tooltip">
                <i class="ace-icon fa fa-reply icon-only"></i>

            </a> 
        </div>
                 <br/><br/><br/>
        <div class="clearfix">
            <div class="pull-right tableTools-container2"></div>
        </div>
        
        <div class="table-header" STYLE="background-color:#8C94C6">
            Elegir Paño
        </div>

        <!-- div.table-responsive -->

        <!-- div.dataTables_borderWrap -->
        <div class="table-responsive">
            <table  class="table table-striped table-bordered table-hover table-condensed">
                <thead>
                    <tr>
                        <th>NOMBRE Paños por Estancia</th>
                        <th>LARGO</th>
                        <th>ALTO</th>
                        <th>lado3</th>
                        <th>ALTURA MEDIA</th>
                        <th>SUPERFICIE</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>

                   <tbody>
                        <c:forEach items="${ltaPanos}" var="item">
                            <tr>


                                    <td>
                                         <c:out value="${item.nombrepano}" />
                                    </td>
                                    <td><c:out value="${item.largo}" /></td>
                                    <td><c:out value="${item.alto}" /></td>
                                    <td><c:out value="${item.lado3}" /></td>
                                    <td><input type="text" class="ddl" value="${item.largopresupuesto}"></td>
                                    <td><c:out value="${item.superficie}" /></td>
                                    <td>
                                        
                                        <c:if test="${item.ageregado==1}">
                                            <input type="checkbox" name="idEst" id="idEst" value="${item.id}" class="chk" checked="true">
                                         </c:if>
                                        <c:if test="${item.ageregado==0}">
                                            <input type="checkbox" name="idEst" id="idEst" value="${item.id}" class="chk">
                                        </c:if>        
                                           
                                    </td>
                                     <td>
                                        <div id="SubCapCheck">
                                            <c:if test="${item.ageregado==1}">
                                                <c:if test="${vpa==1}">
                                                <div class="SubCapCheckIcon1">
                                            <a class="blue tooltip-info" data-rel="tooltip"href="/Intranet/emp/ENuevaPropuestaPresupuesto6.htm?idE=${idE}&idP=${p.id}&idPre=${idPre}&idSC=${idSC}&idPresup=${idPresup}&idPsp=${idpresup_sup}&idPano=${item.id}"title="Asignar_Ventanas">
                                                <i class="ace-icon fa  fa-pencil-square-o bigger-130"></i>
                                            </a>
                                              
                                                 </div>
                                                </c:if>
                                            </c:if>
                                            <div class="SubCapCheckIcon" hidden="true">
                                            <a class="blue tooltip-info" data-rel="tooltip"href="/Intranet/emp/ENuevaPropuestaPresupuesto6.htm?idE=${idE}&idP=${p.id}&idPre=${idPre}&idSC=${idSC}&idPresup=${idPresup}&idPsp=${idpresup_sup}&idPano=${item.id}"title="Asignar_Ventanas">
                                                <i class="ace-icon fa  fa-pencil-square-o bigger-130"></i>
                                            </a>
                                                </div>
                                        </div>
                                    </td>

                            </tr>
                        </c:forEach> 


                    </tbody>
                </table>
            <div class="col-lg-12 align-right">
                            
                                <a class="btn btn-success  "  href="/Intranet/emp/ENuevaPropuestaPresupuestoG.htm?idP=${p.id}&idPre=${idPre}&idSC=${idSC}&idPresup=${idPresup}">
                                   Actualizar<i class="ace-icon fa fa-arrow-right icon-on-right"></i>
                                </a>
                                </div>
           
        </div>
        <br/>
        <br/> 
         </div></div>
    </div>
</div>
</div>	
                
</div><!-- /.row -->
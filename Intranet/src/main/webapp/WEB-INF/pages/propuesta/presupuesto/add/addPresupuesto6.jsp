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
        <a class=" btn btn-white btn-warning" href="/Intranet/sup/addPresupuesto5.htm?idE=${idE}&idP=${idP}&idPre=${idPre}&idSC=${idSC}&idPresup=${idPresup}" data-rel="tooltip">
            <i class="ace-icon fa fa-reply icon-only"></i>

        </a>

    </div>
             
             
    </div>
</div><!-- /.page-header -->
<c:if test="${empty ltaVentanas || empty ltaPuertas || empty ltaArmarios}">  
<div class="alert alert-warning">
<button type="button" class="close" data-dismiss="alert">
        <i class="ace-icon fa fa-times"></i>
</button>
<i class="ace-icon fa fa-ban"></i>
 No hay
    <c:if test="${empty ltaVentanas}">        
        <strong>Ventanas!</strong>
	
    </c:if>
    <c:if test="${empty ltaPuertas}">
       <strong>Puertas!</strong> 
    </c:if>
    <c:if test="${empty ltaArmarios}">
         <strong>Armarios!</strong> 
    </c:if>
        Registradas
</div>   
    </c:if>
<c:if test="${not empty ltaVentanas}">
 <div class="row">
    <div class="col-xs-12">
        
        <div class="clearfix">
            <div class="pull-right tableTools-container2"></div>
        </div>
        
        <div class="table-header" STYLE="background-color:#8C94C6">
            Elegir Ventanas
        </div>

        <!-- div.table-responsive -->

        <!-- div.dataTables_borderWrap -->
        <div class="table-responsive">
            <table  class="table table-striped table-bordered table-hover table-condensed">
                <thead>
                    <tr>
                        <th>N°</th>
                        <th>LARGO</th>
                        <th>ALTO</th>
                        <th>SUPERFICIE</th>
                        <th></th>
                    </tr>
                </thead>

                   <tbody>
                        <c:forEach items="${ltaVentanas}" var="item">
                            <tr>


                                    <td>
                                         <c:out value="${item.num}" />
                                    </td>
                                    <td><c:out value="${item.largo}" /></td>
                                    <td><c:out value="${item.alto}" /></td>
                                    <td><c:out value="${item.superficie}" /></td>
                                    <td>
                                        
                                        <c:if test="${item.agregado==1}">
                                            <input type="checkbox" name="idEst" id="idEst" value="${item.id}" class="chk" checked="true">
                                         </c:if>
                                        <c:if test="${item.agregado==0}">
                                            <input type="checkbox" name="idEst" id="idEst" value="${item.id}" class="chk">
                                        </c:if>        
                                           
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
 </c:if>  
<c:if test="${not empty ltaPuertas}">
<div class="row">
    <div class="col-xs-12">
        
        <div class="clearfix">
            <div class="pull-right tableTools-container2"></div>
        </div>
        
        <div class="table-header" STYLE="background-color:#8C94C6">
            Elegir Puertas
        </div>

        <!-- div.table-responsive -->

        <!-- div.dataTables_borderWrap -->
        <div class="table-responsive">
            <table  class="table table-striped table-bordered table-hover table-condensed">
                <thead>
                    <tr>
                        <th>N°</th>
                        <th>LARGO</th>
                        <th>ALTO</th>
                        <th>SUPERFICIE</th>
                        <th></th>
                    </tr>
                </thead>

                   <tbody>
                        <c:forEach items="${ltaPuertas}" var="item2">
                            <tr>


                                    <td>
                                         <c:out value="${item2.num}" />
                                    </td>
                                    <td><c:out value="${item2.largo}" /></td>
                                    <td><c:out value="${item2.alto}" /></td>
                                    <td><c:out value="${item2.superficie}" /></td>
                                    <td>
                                        
                                        <c:if test="${item2.agregado==1}">
                                            <input type="checkbox" name="idEst" id="idEst" value="${item2.id}" class="chkp" checked="true">
                                         </c:if>
                                        <c:if test="${item2.agregado==0}">
                                            <input type="checkbox" name="idEst" id="idEst" value="${item2.id}" class="chkp">
                                        </c:if>        
                                           
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
</c:if>
<c:if test="${not empty ltaArmarios}">
<div class="row">
    <div class="col-xs-12">
        
        <div class="clearfix">
            <div class="pull-right tableTools-container2"></div>
        </div>
        
        <div class="table-header" STYLE="background-color:#8C94C6">
            Elegir Armarios
        </div>

        <!-- div.table-responsive -->

        <!-- div.dataTables_borderWrap -->
        <div class="table-responsive">
            <table  class="table table-striped table-bordered table-hover table-condensed">
                <thead>
                    <tr>
                        <th>N°</th>
                        <th>LARGO</th>
                        <th>ALTO</th>
                        <th>SUPERFICIE</th>
                        <th></th>
                    </tr>
                </thead>

                   <tbody>
                        <c:forEach items="${ltaArmarios}" var="item3">
                            <tr>


                                    <td>
                                         <c:out value="${item3.num}" />
                                    </td>
                                    <td><c:out value="${item3.largo}" /></td>
                                    <td><c:out value="${item3.alto}" /></td>
                                    <td><c:out value="${item3.superficie}" /></td>
                                    <td>
                                        
                                        <c:if test="${item3.agregado==1}">
                                            <input type="checkbox" name="idEst" id="idEst" value="${item3.id}" class="chka" checked="true">
                                         </c:if>
                                        <c:if test="${item3.agregado==0}">
                                            <input type="checkbox" name="idEst" id="idEst" value="${item3.id}" class="chka">
                                        </c:if>        
                                           
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
</c:if>
    <div class="row">
        <div class="col-lg-10">
        
        </div>
    <div class="col-lg-2 align-right">
        
        <a class="btn btn-success col-xs-12 col-sm-4 col-md-3 col-lg-12 "  href="/Intranet/sup/addPresupuestoG.htm?idP=${idP}&idPre=${idPre}&idSC=${idSC}&idPresup=${idPresup}">
           Actualizar<i class="ace-icon fa fa-arrow-right icon-on-right"></i>
        </a>
    </div>
             
             
    </div>
					</div><!-- /.row -->

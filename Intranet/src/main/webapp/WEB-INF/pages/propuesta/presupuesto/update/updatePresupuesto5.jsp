<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<div class="page-content">                 
 
<div class="page-header">
    <div class="row">
        <div class="col-lg-8">
        <h1>
            Actualizar Presupuesto 
           
            de PROPUESTA:
            <br/>
            <small>
                    <i class="ace-icon fa fa-angle-double-right"></i>
                    ${p.descipcion} del CLIENTE: ${p.cliente_nif.nif} ${p.cliente_nif.apellidos}, ${p.cliente_nif.nombre}
            </small>
        </h1>
        </div>
    <div class="col-lg-4 align-right">
        <a class=" btn btn-white btn-warning" href="/Intranet/sup/updatePresupuesto4.htm" data-rel="tooltip">
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
            Elegir Paño
        </div>

        <!-- div.table-responsive -->

        <!-- div.dataTables_borderWrap -->
        <div class="table-responsive">
            <table id="dynamic-table2" class="table table-striped table-bordered table-hover table-condensed">
                <thead>
                    <tr>
                        <th>NOMBRE Paños por Estancia</th>
                        <th>LARGO</th>
                        <th>ALTO</th>
                        <th>lado3</th>
                        <th>SUPERFICIE</th>
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
                                    <td><c:out value="${item.superficie}" /></td>
                                    <td>
                                        <c:set value="0" var="encont" scope="page"/>
                                        <c:forEach items="${presupSupLista}" var="itemLta">
                                                <c:if test="${itemLta.pano_id.id==item.id}">
                                                    <c:if test="${itemLta.ageregado==1}">
                                                    <c:set value="1" var="encont" scope="page"/>
                                                    </c:if>
                                                </c:if>
                                            </c:forEach>
                                        <c:if test="${encont==0}">
                                            <div class="hidden-sm hidden-xs action-buttons">
                                                <a class="blue tooltip-info" data-rel="tooltip" href="/Intranet/sup/updatePresupuesto6.htm?idPano=${item.id}&idE=${idE}" title="Agregar al Presupuesto">
                                                            <i class="ace-icon glyphicon glyphicon-ok bigger-130"></i>
                                                    </a>    
                                                
                                            </div>

                                            <div class="hidden-md hidden-lg">
                                                    <div class="inline pos-rel">
                                                            <button class="btn btn-minier btn-yellow dropdown-toggle" data-toggle="dropdown" data-position="auto">
                                                                    <i class="ace-icon fa fa-caret-down icon-only bigger-120"></i>
                                                            </button>

                                                            <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
                                                                    <li>
                                                                            <a href="/Intranet/sup/updatePresupuesto6.htm?idPano=${item.id}&idE=${idE}" class="tooltip-info" data-rel="tooltip" title="Agregar al Presupuesto">
                                                                                    <span class="blue">
                                                                                            <i class="ace-icon glyphicon glyphicon-ok bigger-120"></i>
                                                                                    </span>
                                                                            </a>

                                                                    </li>
                                                                    

                                                            </ul>
                                                    </div>
                                            </div> 
                                       </c:if>
                                            <c:if test="${encont==1}">  
                                                <div class="hidden-sm hidden-xs action-buttons">
                                                <a class="red tooltip-error" data-rel="tooltip" href="/Intranet/sup/updatePresupuesto7.htm?idPano=${item.id}&idE=${idE}" title="Quitar">
                                                            <i class="ace-icon glyphicon glyphicon-remove bigger-130"></i>
                                                    </a>    
                                                
                                            </div>

                                            <div class="hidden-md hidden-lg">
                                                    <div class="inline pos-rel">
                                                            <button class="btn btn-minier btn-yellow dropdown-toggle" data-toggle="dropdown" data-position="auto">
                                                                    <i class="ace-icon fa fa-caret-down icon-only bigger-120"></i>
                                                            </button>

                                                            <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
                                                                    <li>
                                                                            <a href="/Intranet/sup/updatePresupuesto7.htm?idPano=${item.id}&idE=${idE}" class="tooltip-error" data-rel="tooltip" title="Quitar">
                                                                                    <span class="red">
                                                                                            <i class="ace-icon glyphicon glyphicon-remove bigger-120"></i>
                                                                                    </span>
                                                                            </a>

                                                                    </li>
                                                                    

                                                            </ul>
                                                    </div>
                                            </div> 
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


    <div class="row">
        <div class="col-lg-10">
        
        </div>
    
     <div class="col-lg-2 align-right">
        
        <a class="btn btn-success col-xs-12 col-sm-4 col-md-3 col-lg-12 "  href="/Intranet/sup/updatePresupuestoG.htm?idE=${idE}">
           Siguiente<i class="ace-icon fa fa-arrow-right icon-on-right"></i>
        </a>
    </div>         
             
    </div>
					</div><!-- /.row -->
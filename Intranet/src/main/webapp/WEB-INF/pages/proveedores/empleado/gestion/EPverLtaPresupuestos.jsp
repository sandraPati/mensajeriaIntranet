<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- #section:settings.box -->
<div class="page-content">  	
<div class="page-header">
    <div class="row">
        <div class="col-lg-8">
        <h1>
        Presupuestos Enviados
        <small>
                <i class="ace-icon fa fa-angle-double-right"></i>
        </small>
    </h1>
        </div>
       
             
             
    </div>
</div><!-- /.page-header -->

<div class="row">
    <div class="col-xs-12">
        
        <div class="clearfix">
            <div class="pull-right tableTools-container2"></div>
        </div>
        
        <div class="table-header" STYLE="background-color:#8C94C6">
                Lista de Presupuestos
        </div>

        <!-- div.table-responsive -->

        <!-- div.dataTables_borderWrap -->
        <div class="table-responsive">
            <table id="dynamic-table2" class="table table-striped table-bordered table-hover table-condensed">
                <thead>
                    <tr>

                        <th>DESCRIPCION</th>
                        <th>MONTO</th>
                        <th>IVA</th>
                        <th>NOTA</th>
                        <th>Estado</th>
                        <th></th>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach items="${lta}" var="item">
                        <tr>


                                <td>
                                     <c:out value="${item.descripcion}" />
                                </td>
                                <td><c:out value="${item.monto}" /></td>
                                <td><c:out value="${item.iva}" /></td>
                                <td><c:out value="${item.nota}" /></td>
                                <td><c:if test="${item.estado==1}">
                                        Pendiente
                                    </c:if>
                                    <c:if test="${item.estado==2}">  
                                        Aprobado
                                    </c:if>
                                    <c:if test="${item.estado==3}">  
                                        Rechazado
                                    </c:if></td>
                                <td>
                                    <a class="blue tooltip-info" data-rel="tooltip" href="/Intranet/emp/EPverPPresupuesto.htm?idP=${item.id}" title="ver Presupuesto">
                                       <i class="ace-icon fa fa-search-plus bigger-130"></i>
                                    </a> 
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
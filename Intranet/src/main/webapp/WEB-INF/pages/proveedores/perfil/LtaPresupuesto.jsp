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
         <div class="col-lg-4 align-right">
            <a class=" btn btn-white btn-warning" href="/Intranet/prov/enviarPresupuestoA.htm"addDatosCliente data-rel="tooltip">
                Agregar Presupuesto
            </a>
            
        </div>
             
             
    </div>
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
                                    <a class="blue tooltip-info" data-rel="tooltip" href="/Intranet/prov/PverPPresupuesto.htm?idP=${item.id}" title="ver Presupuesto">
                                       <i class="ace-icon fa fa-search-plus bigger-130"></i>
                                    </a> 
                                       <a class="green" href="/Intranet/prov/updatePresupProv.htm?idP=${item.id}" title="Actualizr">
                                                            <i class="ace-icon fa fa-pencil bigger-130"></i>
                                                    </a>
                                       <a class="red" href="/Intranet/prov/deletePresupProv.htm?idP=${item.id}" title="Eliminar">
                                                            <i class="ace-icon fa fa-trash-o bigger-130"></i>
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
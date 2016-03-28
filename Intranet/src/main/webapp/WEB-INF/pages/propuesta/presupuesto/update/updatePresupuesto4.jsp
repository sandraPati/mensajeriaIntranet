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
        <a class=" btn btn-white btn-warning" href="/Intranet/sup/updatePresupuesto2.htm?idPres=${idPresUpd}&idP=${idPropUpd}" data-rel="tooltip">
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
            <table id="dynamic-table2" class="table table-striped table-bordered table-hover table-condensed">
                <thead>
                    <tr>

                        <th>N°</th>
                        <th>NOMBRE ESTANCIA</th>
                        <th>Total Superficie</th>
                        <th></th>
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
                                            <div class="hidden-sm hidden-xs action-buttons">
                                               
                                                <a class="green tooltip-success" data-rel="tooltip" href="/Intranet/sup/updatePresupuesto5.htm?idE=${item.id}" title="Seleccionar Paños">
                                                            <i class="ace-icon fa fa-check-square-o bigger-130"></i>
                                                    </a>    


                                            </div>

                                            <div class="hidden-md hidden-lg">
                                                    <div class="inline pos-rel">
                                                            <button class="btn btn-minier btn-yellow dropdown-toggle" data-toggle="dropdown" data-position="auto">
                                                                    <i class="ace-icon fa fa-caret-down icon-only bigger-120"></i>
                                                            </button>

                                                            <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
                                                                    <li>
                                                                            <a href="/Intranet/sup/updatePresupuesto5.htm?idE=${item.id}" class="tooltip-success" data-rel="tooltip" title="Seleccionar Paños">
                                                                                    <span class="green">
                                                                                            <i class="ace-icon fa fa-check-square-o bigger-120"></i>
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
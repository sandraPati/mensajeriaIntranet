<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
            
            <a class=" btn btn-white btn-warning" href="/Intranet/sup/Proyecto.htm?idP=${prop.id}" data-rel="tooltip">
                <i class="ace-icon fa fa-reply icon-only"></i>

            </a>
        </div>
        
             
             
    </div>
</div><!-- /.page-header -->

<br/>


<div class="page-header">
   
        <h1>
               Presupuestos del Capitulo:
                <small>
                    <i class="ace-icon fa fa-angle-double-right"></i>
                   ${p.cap.cod} ${p.cap.nombre}
                </small>
        </h1>
    
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

                        <th>SUB_CAPITULO</th>
                        <th>DESCRIPCION</th>
                        <th>TIPO</th>
                        <th>CANTIDAD</th>
                        <th>PRECIO</th>
                        <th>MONTO</th>
                        <th></th>
                        
                    </tr>
                </thead>

                    <tbody>
                        <c:forEach items="${presupuestoLista}" var="item">
                            <tr>


                                    <td>
                                         <c:out value="${item.subcapitulo.cod}" /> <c:out value="${item.subcapitulo.nombre}" /> 
                                    </td>
                                    <td><c:out value="${item.descripcion}" /> </td>
                                    <td><c:out value="${item.tipoCantidad}" /> </td>
                                    <td><c:out value="${item.cantidad}" /> </td>
                                    <td><c:out value="${item.subcapitulo.cantidad}" /> </td>
                                    <td><c:out value="${item.monto}" /> </td>
                                    <td>
                                            <div class="hidden-sm hidden-xs action-buttons">
                                                <a class="blue tooltip-info" data-rel="tooltip" href="/Intranet/sup/PlanObra.htm?idPres=${item.id}" title="Consultar">
                                                            <i class="ace-icon fa fa-search-plus bigger-130"></i>
                                                </a> 
                                                <a class="green tooltip-success" data-rel="tooltip" href="/Intranet/sup/addPlanObra.htm?idPres=${item.id}" title="Agregar Plan de Obra">
                                                   <i class="ace-icon fa  fa-book bigger-130"></i>
                                                </a>             
                                                            

                                            </div>

                                            <div class="hidden-md hidden-lg">
                                                    <div class="inline pos-rel">
                                                            <button class="btn btn-minier btn-yellow dropdown-toggle" data-toggle="dropdown" data-position="auto">
                                                                    <i class="ace-icon fa fa-caret-down icon-only bigger-120"></i>
                                                            </button>

                                                            <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
                                                                    <li>
                                                                            <a href="/Intranet/sup/PlanObra.htm?idPres=${item.id}" class="tooltip-info" data-rel="tooltip" title="Consultar">
                                                                                    <span class="blue">
                                                                                            <i class="ace-icon fa fa-search-plus bigger-120"></i>
                                                                                    </span>
                                                                            </a>

                                                                    </li>
                                                                     <li>
                                                                            <a href="/Intranet/sup/addPlanObra.htm?idPres=${item.id}" class="tooltip-success" data-rel="tooltip" title="Agregar Plan de Obra">
                                                                                    <span class="green">
                                                                                            <i class="ace-icon fa  fa-book bigger-120"></i>
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
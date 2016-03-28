<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- #section:settings.box -->
						
<div class="page-content">  
<div class="page-header">
  
        <h1>
               Seleccionar Proyecto:
               
        </h1>
     
</div><!-- /.page-header -->
<div class="row">
    <div class="col-xs-12">
        
        <!-- div.table-responsive -->

        <!-- div.dataTables_borderWrap -->
        <div class="table-responsive">
            <table id="simple-table" class="table table-striped table-bordered table-hover ">
                <thead>
                    <tr>

                        <th>DESCRIPCION</th>
                        <th>EMPLEADO</th>
                        <th>DIA</th>
                        <th>HORA</th>
                        <th>CLIENTE</th>							
                        <th>DIRECCION</th>
                        <th></th>
                    </tr>
                </thead>
                    <tbody>
                        <c:forEach items="${lta}" var="item">
                            <tr>


                                    <td>
                                         <c:out value="${item.descipcion}" />
                                    </td>
                                    <td><c:out value="${item.empleado_nif.nif}" /> <c:out value="${item.empleado_nif.apellidos}" />, <c:out value="${item.empleado_nif.nombre}" /></td>
                                    <td><c:out value="${item.dia}" /></td>
                                    <td><c:out value="${item.hora}" /></td>
                                    <td><c:out value="${item.cliente_nif.nif}" /> <c:out value="${item.cliente_nif.apellidos}" />, <c:out value="${item.cliente_nif.nombre}" /></td>
                                    <td><c:out value="${item.direccion}" /></td>

                                    
                                      <td>
                                             
                                                <a class="blue tooltip-info " data-rel="tooltip" href="/Intranet/sup/PPCapitulos.htm?idPresup=${idPresup}&idP=${item.id}" title="Ver Capitulos">
                                                   <i class="ace-icon glyphicon glyphicon-ok bigger-130"></i>
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
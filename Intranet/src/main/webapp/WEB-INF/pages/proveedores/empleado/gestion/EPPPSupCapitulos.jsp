<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- #section:settings.box -->
						
<div class="page-content">  
<div class="page-header">
    
        <h1>
               Selecciones Sub Capitulo: 
                
        </h1>
       
             
    </div>

<br/>


<div class="row">
    <div class="col-xs-12">
        
        
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
                        <c:forEach items="${lta}" var="item">
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
                                            <a class="blue tooltip-info" data-rel="tooltip" href="/Intranet/emp/EPAsignarPresupuesto.htm?idPresup=${idPresup}&idSC=${item.id}" title="Consultar">
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
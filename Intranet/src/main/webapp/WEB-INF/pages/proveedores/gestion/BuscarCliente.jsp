<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- #section:settings.box -->
						
<div class="page-content">  
<div class="page-header">
    
        <h1>
               Seleccionar Cliente 
                <small>
                    <i class="ace-icon fa fa-angle-double-right"></i>
                   
                </small>
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

                        <th>NIF</th>
                        <th>NOMBRE</th>
                        <th>APELLIDOS</th>
                        <th>DIRECCION</th>
                        <th>PAIS</th>							
                        <th>PROVINCIA</th>														
                        <th>POBLACION</th>
                        <th>NACIONALIDAD</th>
                        <th>CODIGO POSTAL</th>
                        <th></th>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach items="${lta}" var="item">
                        <tr>


                                <td>
                                     <c:out value="${item.nif}" />
                                </td>
                                <td><c:out value="${item.nombre}" /></td>
                                <td><c:out value="${item.apellidos}" /></td>
                                <td><c:out value="${item.direccion}" /></td>
                                <td><c:out value="${item.pais}" /></td>
                                <td><c:out value="${item.provincia}" /></td>
                                <td><c:out value="${item.poblacion}" /></td>
                                <td><c:out value="${item.nacionalidad}" /></td>
                                <td><c:out value="${item.codigo_postal}" /></td>

                                <td>
                                        
                                            <a class="blue tooltip-info" data-rel="tooltip" href="/Intranet/sup/Proyectos.htm?idPresup=${idPresup}&nifC=${item.nif}" title="Ver Propuestas">
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
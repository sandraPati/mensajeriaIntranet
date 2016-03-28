<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- #section:settings.box -->
						
<div class="page-content">  
<div class="page-header">
    <div class="row">
        <div class="col-lg-8">  
        <h1>
               Gestion 
                <small>
                    <i class="ace-icon fa fa-angle-double-right"></i>
                </small>
        </h1>
     </div>
         <div class="col-lg-4 align-right">
            <a class=" btn btn-white btn-warning" href="/Intranet/emp/EPaddProveedor.htm" data-rel="tooltip">
                Registrar Provedor
            </a>
           
        </div>
        
             
             
    </div> 
</div><!-- /.page-header -->
<br/>

<div class="row">
    <div class="col-xs-4">
        <select class="chosen-select form-control" id="form-field-select-3" data-placeholder="Elegir Cliente...">
            <option value="">  </option>
            <c:forEach items="${listaProveedores}" var="item">                            
                <option value="<c:out value="${item.id}" />"><c:out value="${item.cif}" /> <c:out value="${item.nombre}" /> <c:out value="${item.id_actividad.nombre}" /></option>
            </c:forEach> 
        </select>
    </div>
</div>
<div id="tablaprov" hidden="true" class="row">
    <div class="col-xs-12">
        
        <div class="clearfix">
            <div class="pull-right tableTools-container2"></div>
        </div>
        
        <div class="table-header" STYLE="background-color:#8C94C6">
                Lista de Proveedores
        </div>

        <!-- div.table-responsive -->

        <!-- div.dataTables_borderWrap -->
        <div class="table-responsive">
            <table id="dynamic-table2" class="table table-striped table-bordered table-hover table-condensed">
                <thead>
                    <tr>
                        <th>FOTO</th>
                        <th>CIF</th>
                        <th>NOMBRE</th>
                        
                        <th>ACTIVIDAD</th>                        
                        <th>LINK</th>
                        <th>APROBADO</th>
                        <th>CALIFICACION</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>

                    <tbody id="tablebody">
                      


                    </tbody>
                </table>
        </div>
        <br/>
        <br/>                    
</div>
</div>

					</div><!-- /.row -->

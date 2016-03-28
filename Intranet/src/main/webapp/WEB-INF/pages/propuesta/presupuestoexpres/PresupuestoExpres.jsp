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
                   ${prop.descipcion}
                </small>
        </h1>
        </div>
         <div class="col-lg-4 align-right">
            
            <a class=" btn btn-white btn-warning" href="/Intranet/sup/verPropuestas.htm?nifC=${prop.cliente_nif.nif}" data-rel="tooltip">
                <i class="ace-icon fa fa-reply icon-only"></i>

            </a>
        </div>
        
             
             
    </div>
</div><!-- /.page-header -->

<br/>


<div class="page-header">
    <div class="row">
        <div class="col-lg-8">
        <h1>
               Presupuestos de Propuesta
                <small>
                    <i class="ace-icon fa fa-angle-double-right"></i>
                   
                </small>
        </h1>
        </div>
         
             
    </div>
</div><!-- /.page-header -->

<div class="row">
    <div class="col-xs-12">

        <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-4">
                
                <div class="profile-info-row">
                    <div class="profile-info-name"> CLIENTE</div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${prop.cliente_nif.nif}" /> <c:out value="${prop.cliente_nif.apellidos}" />, <c:out value="${prop.cliente_nif.nombre}" /></span>
                    </div>
                </div>    
                <div class="profile-info-row">
                    <div class="profile-info-name"> PAIS </div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${prop.pais}" /></span>
                    </div>
                </div>
        </div>
        <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-4">
                <div class="profile-info-row">
                    <div class="profile-info-name"> DIRECCION </div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${prop.direccion}" /></span>
                    </div>
                </div>    
           
                <div class="profile-info-row">
                    <div class="profile-info-name"> PROVINCIA </div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${prop.provincia}" /></span>
                    </div>
                </div>
                
                
        </div>
        <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-4">
            <div class="profile-info-row">
                <div class="profile-info-name"><p> </p></div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><p> </p></span>
                    </div>
                </div>    
            <div class="profile-info-row">
                    <div class="profile-info-name"> POBLACION</div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${prop.poblacion}" /></span>
                    </div>
                </div>
        </div>
                    

    </div>
</div>
<div class="row">
   
    
             
    <div class="col-xs-12">
        
        <div class="clearfix">
            <div class="pull-right tableTools-container2"></div>
        </div>
        
        <div class="table-header" STYLE="background-color:#8C94C6">
                Lista de Estancias
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
                                            <a class="blue tooltip-info" data-rel="tooltip" href="/Intranet/sup/PExpres.htm?idE=${item.id}" title="Registro">
                                                <i class="ace-icon fa fa-leaf bigger-130"></i>
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
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  


<div class="page-content">  

<div class="page-header">
    <div class="row">
        <div class="col-lg-8">  
        <h1>
            Seguimiento
            <small>
                    <i class="ace-icon fa fa-angle-double-right"></i>
                    
            </small>
        </h1>
        </div>
         <div class="col-lg-4 align-right">
            
            <a class=" btn btn-white btn-warning" href="/Intranet/sup/SeguimientoGPS.htm" data-rel="tooltip">
                <i class="ace-icon fa fa-reply icon-only"></i>
            </a> 
        </div>
        
             
             
    </div>        
</div><!-- /.page-header -->   
        <div class="row" >
          
                    <div class="col-xs-12">
                        <input type="hidden" id="direccion" value="${gpsListbox.direccion}"/>
                                    <div class="form-group">
                                            

                                            <div class="col-xs-12 col-sm-12" >
                                                <div id="mapa" style="width: 100%; height: 300px;">
                                                --ACA VA NUESTRO MAPA--
                                                </div>
                                            </div>
                                            <div class="col-sm-12" ><br/><br/> </div>
                                    </div>
                                   
                            <!-- PAGE CONTENT BEGINS -->
                            <form:form id="form1" action="" method="POST" commandName="gps1" class="form-horizontal" role="form">
                                   <div class="form-group">
                                            <label class="col-sm-1 control-label no-padding-right" for="form-field-1"> Buscar: </label>
                                           <div class="col-sm-9">
                                               <form:hidden id="" path="nif_user"value="${nif}"/>
                                                <div class="row">
                                                    <div class="col-xs-12 col-sm-5 col-md-4 col-lg-3">
                                                            <div class="input-group input-group-sm">
                                                                <form:input id="fecha" type="text" class="form-control" path="fecha" data-date-format="yyyy-mm-dd" />

                                                                    <span class="input-group-addon">
                                                                            <i class="ace-icon fa fa-calendar"></i>
                                                                    </span>
                                                            </div>
                                                                
                                                    </div>
                                                
                                                    <div class="col-xs-12 col-sm-5 col-md-4 col-lg-4">
                                                        <button id="fetchContacts" type="submit" class="btn btn-primary btn-sm col-xs-12 col-sm-4 col-md-3 col-lg-3">Ver</button>
                                                        
                                                    </div>
                                                    
                                                </div>               
                                            </div>
                                    </div>
                                
                             </form:form>                    
                                  

                    </div>
                    <div class="col-xs-12">
                        <div class="form-group">
                            <div class="col-xs-12 col-sm-10 col-md-10 col-lg-10"></div>
                            <a class="btn btn-success btn-sm col-xs-12 col-sm-2 col-md-2 col-lg-2" href="/Intranet/sup/GpsPdf.htm?nif=${nif}&f=${f}">Ver Reporte</a>  
                            <br/><br/>
                            
                        </div>
                    </div>    
        </div>
<div class="row">
<div class="col-xs-12">
   
    <div class="clearfix">
            <div class="pull-right tableTools-container2"></div>
    </div>
    <div class="table-header" STYLE="background-color:#8C94C6">
            Seguimineto por Fecha
    </div>
    
    <!-- div.table-responsive -->

    <!-- div.dataTables_borderWrap -->
    <div class="table-responsive">
            <table id="dynamic-table2" class="table table-striped table-bordered table-hover table-condensed">
                    <thead>
                            <tr>

                                    <th>DIRECION</th>
                                    <th>FECHA </th>
                                    <th class="hidden-480">HORA</th>
                                    <th>TURNO</th>
                                    <th></th>
                            </tr>
                    </thead>

                    <tbody>
                        <c:forEach items="${gpsListaHoy}" var="item">
                            <tr>
                                    <td>
                                         <c:out value="${item.direccion}" />
                                    </td>
                                    <td><c:out value="${item.fecha}" /></td>
                                    <td class="hidden-480"><c:out value="${item.hora}" /></td>
                                    <td class="hidden-480"><c:out value="${item.turno}" /></td>
                                    <td>
                                         
                                    </td>
                                    
                            </tr>
                           
                            </c:forEach> 
                    </tbody>
            </table>
    </div>
</div>																																
</div>

					</div><!-- /.row -->
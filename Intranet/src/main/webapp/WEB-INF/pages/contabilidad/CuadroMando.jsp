<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- #section:settings.box -->
						
<div class="page-content"> 
<div class="page-header">
    <div class="row">
        <h3>Cuadro Mando</h3>
    </div>
</div><!-- /.page-header -->
<div class="row">
    <div class="col-sm-3">
        
            <div class="input-group input-group-sm">
                <input id="fecha" type="text" class="form-control" data-date-format="yyyy-mm-dd" required="true"/>   
                    <span class="input-group-addon">
                            <i class="ace-icon fa fa-calendar"></i>
                    </span>
            </div>
    </div>
    <div class="col-sm-9">
        <button type="button" id="dia" class="btn btn-sm btn-white  btn-success btn-round">dia</button>
        <button type="button" id="mes" class="btn btn-sm btn-white  btn-success btn-round">mes</button>
        <button type="button" id="anio" class="btn btn-sm btn-white  btn-success btn-round">año</button>
    </div>  
</div>
<div class="row">
    <div class="col-xs-6">
            
                    
                            <div class="widget-box widget-color-green3 ">
                                
                                <div class="widget-body">
                                    <div class="widget-main padding-8">

                                    <h3 class="text-success ">Finanzas</h3>
                                    
                                    <table id="simple-table" class="table table-striped table-bordered table-hover ">
                                        <thead>
                                            <th></th>
                                            <th>Pagadas</th>
                                            <th>Pendientes</th>
                                        </thead>
                                        <tbody>
                                            <tr class="success">
                                                <td>Ingresos</td>
                                                <td><div id="ingresosP">${cm.ingresosP}</div></td>
                                                <td><div id="ingresosI">${cm.ingresosI}</div></td>
                                            </tr>
                                            <tr class="info">
                                                <td>Gastos</td>
                                                <td id="gastosP">${cm.gastosP}</td>
                                                <td id="gastosI">${cm.gastosI}</td>
                                            </tr>
                                            <tr class="active">
                                                <td>Beneficios</td>
                                                <td id="beneficioP">${cm.beneficioP}</td>
                                                <td id="beneficioI">${cm.beneficioI}</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                    <hr/>
                                    
                                    </div>
                                </div>
                            </div>
    </div>
    <div class="col-xs-6">
                    
                            <div class="widget-box widget-color-blue">
                                <div class="widget-body">
                                    
                                    <div class="widget-main padding-8">

                                    <h3 class="text-info">Clientes</h3>
                                    
                                    <table id="simple-table" class="table table-striped table-bordered table-hover ">
                                        
                                        <tbody>
                                            <tr class="success">
                                                <td >Nuevos Clientes</td>
                                                <td id="clienteF">${cm.clienteF}</td>
                                            </tr>
                                            <tr class="info">
                                                <td>Visitas Consertadas Realizadas</td>
                                                <td id="numvisitas">${cm.numvisitas}</td>
                                            </tr>
                                            <tr class="warning">
                                                
                                                <td colspan="2">
                                                    <p>Presupuestos:</p>
                                                    <table class="table table-striped table-bordered table-hover ">
                                                        <thead>
                                                        <th>Enviados</th>
                                                        <th>Aceptados</th>
                                                        <th>Rechazados</th>
                                                        <th>Pendientes</th>
                                                        </thead>
                                                            
                                                        <tbody>
                                                            <tr class="warning">
                                                                <td id="presupuestoEnviado">${cm.presupuestoEnviado}</td>
                                                                <td id="presupuestoAceptados">${cm.presupuestoAceptados}</td>
                                                                <td id="presupuestoRechazados">${cm.presupuestoRechazados}</td>
                                                                <td id="presupuestoPendientes">${cm.presupuestoPendientes}</td>
                                                            </tr>
                                                            
                                                        </tbody>
                                                    </table>
                                                    
                                                </td>
                                            </tr>
                                           
                                        </tbody>
                                    </table>
                                    <hr/>
                                    </div>
                                </div>
                            </div>     
    </div>
</div>

<div class="row">
    <div class="col-xs-6">                
                            <div class="widget-box widget-color-grey ">
                                <div class="widget-body">
                                    <h3 class="text-muted">Proceso</h3>
                                    
                                </div>
                            </div>
        </div>
    <div class="col-xs-6">
                            <div class="widget-box widget-color-orange ">
                                <div class="widget-body">
                                    <h3 class="text-warning">Desarrollo</h3>
                                    
                                </div>
                            </div>
                               
                
    </div>
</div>

</div><!-- /.row -->
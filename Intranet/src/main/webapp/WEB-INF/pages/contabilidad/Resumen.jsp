<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- #section:settings.box -->
						
<div class="page-content"> 
<div class="page-header">
    <div class="row">
        <h3>Resumen</h3>
    </div>
</div><!-- /.page-header -->

<div class="row">
    <div class="col-xs-12">
       <div class="well well-sm col-xs-3">
            
                    
                            <div class="widget-box widget-color-green3 ">
                                <div class="widget-body">
                                    <h3 class="text-success">Ventas</h3>
                                    <p class="text-success">Acumulado Anual</p> <p class="text-success" align="right">${ingresos}<i class="ace-icon glyphicon glyphicon-euro bigger-100"></i></p>
                                </div>
                            </div>
                            
                    
                            <div class="widget-box widget-color-blue">
                                <div class="widget-body">
                                    <h3 class="text-info">Gastos</h3>
                                    <p class="text-info">Acumulado Anual</p> <p class="text-info" align="right">${gastos}<i class="ace-icon glyphicon glyphicon-euro bigger-100"></i></p>
                                </div>
                            </div>     
                    
                            <div class="widget-box widget-color-grey ">
                                <div class="widget-body">
                                    <h3 class="text-muted">Beneficio</h3>
                                    <p class="text-muted">Acumulado Anual</p> <p class="text-muted" align="right">${beneficio}<i class="ace-icon glyphicon glyphicon-euro bigger-100"></i></p>
                                </div>
                            </div>
                               
                                                                                
        </div>
    </div>
</div>

</div><!-- /.row -->
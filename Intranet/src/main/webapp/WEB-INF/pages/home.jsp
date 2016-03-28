<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="page-content">
<c:if test="${activo==1}">    
<div class="page-header">
    
        <h1>
                Objetivos
                <small>
                        <i class="ace-icon fa fa-angle-double-right"></i>
                       del Mes ${fecha}
                </small>
        </h1>
</div><!-- /.page-header -->
 <div class="row">
<div class="col-xs-12">
<!-- PAGE CONTENT BEGINS -->
            <div class="well well-sm col-xs-5">
                <div class="col-sm-12">
                    
                    <div class="form-group" >
                        <label class="col-sm-12 " for="form-field-1"> N° de Visitas: ${obj.num_visitas}</label>

                        <div class="col-sm-8">
                           
                            <div class="progress pos-rel" data-percent="">
                                    <div class="progress-bar" style="width:${meta.porcentaje1}%;"></div>
                            </div>

                        </div>
                        <div class="col-sm-4 center">
                            <div class="easy-pie-chart percentage" data-percent="${meta.porcentaje1}" data-color="#D15B47">
                                    <span class="percent">${meta.numvisitas}</span>
                            </div>
                        </div>
                    </div>
                    
                </div>                                                             
                </div>
            <div class=" col-xs-1"></div>                
            <div class="well well-sm col-xs-5">
                <div class="col-sm-12">
                    
                    <div class="form-group" >
                        <label class="col-sm-12 " for="form-field-1"> N° de Presupuesto: ${obj.num_presupuesto}</label>

                        <div class="col-sm-8">
                           
                            <div class="progress pos-rel" data-percent="">
                                    <div class="progress-bar" style="width:${meta.porcentaje2}%;"></div>
                            </div>

                        </div>
                        <div class="col-sm-4 center">
                            <div class="easy-pie-chart percentage" data-percent="${meta.porcentaje2}" data-color="#D15B47">
                                    <span class="percent">${meta.num_presupuesto}</span>
                            </div>
                        </div>
                    </div>
                    
                </div>                                                             
                </div>                
</div>
<div class="col-xs-12">
<!-- PAGE CONTENT BEGINS -->
            <div class="well well-sm col-xs-5">
                <div class="col-sm-12">
                    
                    <div class="form-group" >
                        <label class="col-sm-12 " for="form-field-1"> N° de Contratos: ${obj.num_contratos}</label>

                        <div class="col-sm-8">
                           
                            <div class="progress pos-rel" data-percent="">
                                    <div class="progress-bar" style="width:${meta.porcentaje3}%;"></div>
                            </div>

                        </div>
                        <div class="col-sm-4 center">
                            <div class="easy-pie-chart percentage" data-percent="${meta.porcentaje3}" data-color="#D15B47">
                                    <span class="percent">${meta.num_contratos}</span>
                            </div>
                        </div>
                    </div>
                    
                </div>                                                             
                </div>
            <div class=" col-xs-1"></div>                
            <div class="well well-sm col-xs-5">
                <div class="col-sm-12">
                    
                    <div class="form-group" >
                        <label class="col-sm-12 " for="form-field-1"> Importe: ${obj.importe}</label>

                        <div class="col-sm-8">
                           
                            <div class="progress pos-rel" data-percent="">
                                    <div class="progress-bar" style="width:${meta.porcentaje4}%;"></div>
                            </div>

                        </div>
                        <div class="col-sm-4 center">
                            <div class="easy-pie-chart percentage" data-percent="${meta.porcentaje4}" data-color="#D15B47">
                                    <span class="percent">${meta.importe}</span>
                            </div>
                        </div>
                    </div>
                    
                </div>                                                             
                </div>                
</div>
 </div>
</c:if>
</div>

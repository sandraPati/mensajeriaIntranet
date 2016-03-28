<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 

<div class="page-content">  
<div class="page-header">
    <h1>
        NOMINA
        <small>
                <i class="ace-icon fa fa-angle-double-right"></i>
                ${nomina.nif_empleado.nif}  ${nomina.nif_empleado.apellidos},  ${nomina.nif_empleado.nombre} 
        </small>
    </h1>
</div><!-- /.page-header -->
<div class="row">
    <div class="col-xs-12">

        <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-6">
                <div class="profile-info-row">
                    <div class="profile-info-name"> Salario Base </div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${nomina.salario_base}" /></span>
                    </div>
                </div>
               <div class="profile-info-row">
                    <div class="profile-info-name">Pagas extas prorrateadas </div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${nomina.pagas_extras_prorrateadas}" /></span>
                    </div>
                </div>
                <div class="profile-info-row">
                    <div class="profile-info-name">Gratificaciones extraordinarias </div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${nomina.gratificaciones_extraordinarias}" /></span>
                    </div>
                </div>    

        

                    <div class="profile-info-row">
                    <div class="profile-info-name">Indemnizaciones suplidos </div>

                    <div class="profile-info-value">
                            <span class="editable" id="username"><c:out value="${nomina.indemnizaciones_suplidos}" /></span>
                    </div>
                     </div>
                   <div class="profile-info-row">
                    <div class="profile-info-name">Otras Percepciones no salariales </div>

                    <div class="profile-info-value">
                            <span class="editable" id="username"><c:out value="${nomina.otras_percepciones_no_salariales}" /></span>
                    </div>
                   </div>
        </div>
        <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-6">
                <div class="profile-info-row">
                    <div class="profile-info-name">Mes y Año </div>

                    <div class="profile-info-value">
                            <span class="editable" id="username"><c:out value="${nomina.mes}" /> <c:out value="${nomina.anio}" /></span>
                    </div>
                </div>    
                <div class="profile-info-row">
                    <div class="profile-info-name"> Prorrateo Vacaciones </div>

                    <div class="profile-info-value">
                            <span class="editable" id="username"><c:out value="${nomina.prorrateo_vacaciones}" /></span>
                    </div>
                </div>
            <div class="profile-info-row">
                    <div class="profile-info-name"> Salario Especie </div>

                    <div class="profile-info-value">
                            <span class="editable" id="username"><c:out value="${nomina.salario_especie}" /></span>
                    </div>
            </div>  
           <div class="profile-info-row">
                    <div class="profile-info-name"> Prestaciones indemnizaciones SS </div>

                    <div class="profile-info-value">
                            <span class="editable" id="username"><c:out value="${nomina.prestaciones_indemnizaciones_ss}" /></span>
                    </div>
            </div> 
                     <div class="profile-info-row">
                    <div class="profile-info-name">Horas extraordinarias</div>

                    <div class="profile-info-value">
                            <span class="editable" id="username"><c:out value="${nomina.horas_extraordinarias}" /></span>
                    </div>
            </div> 
            
        </div>
        <div class="hr hr-dotted hr-16"></div>
										


    </div>
</div>


<div class="page-header">
    <h1>
        DEDUCCIONES
        <small>
                <i class="ace-icon fa fa-angle-double-right"></i>
               
        </small>
    </h1>
</div><!-- /.page-header -->
<div class="row">
    <div class="col-xs-12">

        <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-6">
                <div class="profile-info-row">
                    <div class="profile-info-name"> Contingencias Comunes  </div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${deducc.contingencias_comunes}" /></span>
                    </div>
                </div>
               <div class="profile-info-row">
                    <div class="profile-info-name">Desempleo</div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${deducc.desempleo}" /></span>
                    </div>
                </div>
                <div class="profile-info-row">
                    <div class="profile-info-name">Formacion </div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${deducc.formacion}" /></span>
                    </div>
                </div> 
                    <div class="profile-info-row">
                    <div class="profile-info-name">Irpf</div>

                    <div class="profile-info-value">
                            <span class="editable" id="username"><c:out value="${deducc.irpf}" /></span>
                    </div>
                     </div>

        </div>
        <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-6">

                    
                   <div class="profile-info-row">
                    <div class="profile-info-name">Anticipos </div>

                    <div class="profile-info-value">
                            <span class="editable" id="username"><c:out value="${deducc.anticipos}" /></span>
                    </div>
                   </div>
                    <div class="profile-info-row">
                    <div class="profile-info-name">Valor Productos Recibidos </div>

                    <div class="profile-info-value">
                            <span class="editable" id="username"><c:out value="${deducc.valor_productos_recibidos}" /></span>
                    </div>
                   </div>
                    <div class="profile-info-row">
                    <div class="profile-info-name">Otras Deducciones </div>

                    <div class="profile-info-value">
                            <span class="editable" id="username"><c:out value="${deducc.otras_deducciones}" /></span>
                    </div>
                   </div>
                    
        </div>
        <div class="hr hr-dotted hr-16"></div>
										


    </div>
</div>

                    </div><!-- /.row -->
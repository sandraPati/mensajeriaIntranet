<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<div class="page-content"> 
 		
<div class="row">
    <div class="col-xs-12">
        <ul class="steps  ">
                <li data-step="1 " class="active ">
                        <span class="step "><i class="ace-icon glyphicon glyphicon-ok bigger-100 light-green"></i></span>
                        <span class="title ">Seleccionar un Ciente</span>
                </li>

                <li data-step="2" class="active ">
                        <span class="step">2</span>
                        <span class="title">Registro de Estancias</span>
                </li>

                <li data-step="3">
                        <span class="step">3</span>
                        <span class="title">Presupuesto</span>
                </li>

                <li data-step="4">
                        <span class="step">4</span>
                        <span class="title">Envio de Presupuesto</span>
                </li>
                
        </ul>
    </div>
</div>
        
    <div class="row">
    <div class="col-xs-12">
        <ul class="steps  ">
                <li data-step="1 " class="active ">
                        <span class="step "><i class="ace-icon glyphicon glyphicon-ok bigger-100 light-green"></i></span>
                        <span class="title ">Nueva Estancia</span>
                </li>
                <li data-step="2" class="active ">
                        <span class="step"><i class="ace-icon glyphicon glyphicon-ok bigger-100 light-green"></i></span>
                        <span class="title">Registro de Paños</span>
                </li>
                <li data-step="2" class="active ">
                        <span class="step">2.3</span>
                        <span class="title">Ver Estancias</span>
                </li>
                
        </ul>
        

    </div>
</div>
    <div class="page-header">
        <h1>
           
                <small>
                    <i class="ace-icon fa fa-angle-double-right"></i> Registro de nueva estancia                   
                </small>
        </h1>
    </div>
    <br/>
     <br/>
    <div class="row">
        <div class="col-xs-12">
            <div class="tabbable">
                 <ul class="nav nav-tabs padding-12 tab-color-blue background-blue" id="myTab4">
                           
                    </ul>
                <div class="tab-content">
                            <div id="home4" class="tab-pane in active">
            
        <div class="clearfix">
            <div class="pull-right tableTools-container2"></div>
        </div>
        
        <div class="table-header" STYLE="background-color:#8C94C6">
                Lista de Armarios
        </div>

        <!-- div.table-responsive -->

        <!-- div.dataTables_borderWrap -->
        <div class="table-responsive">
            <table id="dynamic-table2" class="table table-striped table-bordered table-hover table-condensed">
                <thead>
                    <tr>

                        <th>N°</th>
                        <th>LARGO</th>
                        <th>ALTO</th>
                        <th>FONDO</th>
                        <th>SUPERFICIE</th>
                        <th></th>
                    </tr>
                </thead>

                    <tbody>
                        <c:forEach items="${ltaarmario}" var="item">
                            <tr>


                                    <td>
                                         <c:out value="${item.num}" />
                                    </td>
                                    <td><c:out value="${item.largo}" /></td>
                                    <td><c:out value="${item.alto}" /></td>
                                    <td><c:out value="${item.fondo}" /></td>
                                    <td><c:out value="${item.superficie}" /></td>
                                    <td>
                                            <div class="hidden-sm hidden-xs action-buttons">
                                                  
                                                <a class="green tooltip-success" data-rel="tooltip" href="/Intranet/emp/ENuevaPropuestaExpresUpdateArmarioFC.htm?id=${item.id}" title="Actualizar">
                                                   <i class="ace-icon fa fa-pencil bigger-130"></i>
                                                </a>            
                                                <a class="red" href="/Intranet/emp/ENuevaPropuestaExpresDeleteArmarioC.htm?id=${item.id}" title="Eliminar">
                                                    <i class="ace-icon fa fa-trash-o bigger-130"></i>
                                                </a>   
                                            </div>

                                            <div class="hidden-md hidden-lg">
                                                    <div class="inline pos-rel">
                                                            <button class="btn btn-minier btn-yellow dropdown-toggle" data-toggle="dropdown" data-position="auto">
                                                                    <i class="ace-icon fa fa-caret-down icon-only bigger-120"></i>
                                                            </button>

                                                            <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
                                                                   
                                                                     <li>
                                                                            <a href="/Intranet/emp/ENuevaPropuestaExpresUpdateArmarioFC.htm?id=${item.id}" class="tooltip-success" data-rel="tooltip" title="Actualizar">
                                                                                    <span class="green">
                                                                                            <i class="ace-icon fa fa-pencil-square-o bigger-120"></i>
                                                                                    </span>
                                                                            </a>
                                                                    </li>
                                                                     <li>
                                                                            <a href="/Intranet/emp/ENuevaPropuestaExpresDeleteArmarioC.htm?id=${item.id}" class="tooltip-error" data-rel="tooltip" title="Eliminar">
                                                                                    <span class="red">
                                                                                            <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                                                                    </span>
                                                                            </a>
                                                                    </li>

                                                            </ul>
                                                    </div>
                                            </div>
                                    </td>

                            </tr>
                        </c:forEach> 


                    </tbody>
                </table>
            <br/><br/>
             
            <div class="col-lg-12 align-right">
                               <a class=" btn btn-error btn-md" href="/Intranet/emp/ENuevaPropuestaExpresUpdateArmarioFaddC.htm?idP=${idPano}" data-rel="tooltip">
                                    Agregar ARMARIO

                                </a>
                                    
                                <a class="btn btn-success  btn-md "  href="/Intranet/emp/ENuevaPropuestaExpresUpdateFinishC.htm?idP=${idPano}">
                                   Siguiente<i class="ace-icon fa fa-arrow-right icon-on-right"></i>
                                </a>
                                </div>
           
              
        </div>
        
                </div>
                   
                    </div>
            </div>
        </div>
        
    </div>
</div><!-- /.row -->
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

                
<div class="page-content">   
<div class="page-header">
   
        <h1>
            Registro de Puertas
            <small>
                    <i class="ace-icon fa fa-angle-double-right"></i>
                    ${pa.numpuertas}  
            </small>
        </h1>
        
</div><!-- /.page-header -->
 		
<div class="row">
    
    <div class="col-xs-12">
          
                  <div id="venN">
                  <div class="table-responsive">
                    <c:set value="${pa.numpuertas}" var="n" scope="page" />
                    <table class="table">
                             <thead>
                                <tr>
                                    <th>N°</th>
                                    <th></th>
                                    <th>Largo</th>
                                    <th>Alto</th>
                                    <th>Superficie</th>
                                    <th>Opcion</th>
                                </tr>
                            </thead>
                            <tbody>
                      <c:forEach var="i" begin="1" end="${n}">
                          <c:set value="0" var="nVen" scope="page" />
                            <c:forEach items="${ltapuerta}" var="item">
                               <c:if test="${item.num==i}">
                                   <c:set value="1" var="nVen" scope="page"/>
                                   <label class="col-sm-3 control-label no-padding-right" for="form-field-1">Puerta N° ${item.num}</label>
                                    <label class="col-sm-3 control-label no-padding-right" for="form-field-1">largo: ${item.largo}</label>
                                    <label class="col-sm-3 control-label no-padding-right" for="form-field-1">alto: ${item.alto}</label>
                                    <label class="col-sm-3 control-label no-padding-right" for="form-field-1">Superficie ${item.superficie}</label>
                                    <br/><br/>
                               </c:if>    
                            </c:forEach>
                              
                        <c:if test="${nVen==0}">    
                          
                                <tr>
                                    <td>
                                        <input type="text" id="numV" value="${i}" class="col-xs-12 col-sm-4 col-md-5 col-lg-3 numV" readonly="true"/>
                                    </td>
                                    <td >
                                        <select class="ddl" name="estandar" id="estandar" attrmain="true"> 
                                            <option value="1">0.60 x 2.1</option>
                                            <option value="2">0.70 x 2.1</option>
                                            <option value="3">0.80 x 2.1</option>
                                            <option value="4">0.90 x 2.1</option>
                                            <option value="5">Otro</option>
                                        </select>
                                    </td>
                                    <td>
                                        <input type="text" id="largopuerta" class="col-xs-12 col-sm-12 largopuerta" hidden="true"/>
                                    </td>
                                    <td>
                                        <input type="text" id="altopuerta" class="col-xs-12 col-sm-12 altopuerta" hidden="true"/>
                                    </td>
                                    <td >
                                        <input type="text" id="superficiepuerta" class="col-xs-12 col-sm-12 superficiepuerta" hidden="true" readonly="true"/>
                                    </td>
                                    <td>
                                        <button type="submit" class="btn btn-primary btn-xs col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                            <i class="ace-icon fa fa-floppy-o bigger-160"></i>
                                        </button>
                                    </td>
                                </tr>
                            
                        
                          </c:if> 
                     </c:forEach>
                        </tbody>
                          </table>
                 </div>  
                    </div>  
    </div>
</div>	

					</div><!-- /.row -->
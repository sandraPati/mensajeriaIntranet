<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<div class="page-content">  
 
<div class="page-header">
   
        <h1>
            Registro de Armarios
            <small>
                    <i class="ace-icon fa fa-angle-double-right"></i>
                    ${pa.numarmarios}  
            </small>
        </h1>
        
</div><!-- /.page-header -->
 		
<div class="row">
    
    <div class="col-xs-12">
          
                  <div id="venN">
                    <c:set value="${pa.numarmarios}" var="n" scope="page" />
                      <c:forEach var="i" begin="1" end="${n}">
                          <c:set value="0" var="nVen" scope="page" />
                            <c:forEach items="${ltaarmario}" var="item">
                               <c:if test="${item.num==i}">
                                   <c:set value="1" var="nVen" scope="page"/>
                                   <label class="col-sm-2 control-label no-padding-right" for="form-field-1">Puerta N� ${item.num}</label>
                                    <label class="col-sm-2 control-label no-padding-right" for="form-field-1">largo: ${item.largo}</label>
                                    <label class="col-sm-2 control-label no-padding-right" for="form-field-1">alto: ${item.alto}</label>
                                    <label class="col-sm-2 control-label no-padding-right" for="form-field-1">fondo ${item.fondo}</label>
                                    <label class="col-sm-4 control-label no-padding-right" for="form-field-1">Superficie ${item.superficie}</label>
                                    <br/><br/>
                               </c:if>    
                            </c:forEach>
                              
                        <c:if test="${nVen==0}">    
                            
                        <form:form id="form${i}"action="" method="POST" commandName="arm">
                          <div class="form-group" >
                            <label class="col-sm-1 control-label no-padding-right" for="form-field-1">Puerta N� ${i}</label>
                            <form:hidden id="numV" path="num" value="${i}" class="col-xs-10 col-sm-4" />
                            <label class="col-sm-1 control-label no-padding-right" for="form-field-1">LARGO</label>
                            <div class="col-sm-1">
                                <form:input type="text" id="largoarmario${i}" path="largo" class="col-xs-10 col-sm-12" /> 
                                
                            </div>
                            
                            <label class="col-sm-1 control-label no-padding-right" for="form-field-1">ALTO</label>
                            <div class="col-sm-1">
                                <form:input type="text" id="altoarmario${i}" path="alto" class="col-xs-10 col-sm-12" />
                            </div>
                            <label class="col-sm-1 control-label no-padding-right" for="form-field-1">FONDO</label>
                            <div class="col-sm-1">
                                <form:input type="text" id="fodoarmario${i}" path="fondo" class="col-xs-10 col-sm-12" />
                            </div>
                            <label class="col-sm-1 control-label no-padding-right" for="form-field-1">SUPERFICIE</label>
                            <div class="col-sm-1">
                                <form:input type="text" id="superficiearmario${i}" path="superficie" class="col-xs-10 col-sm-12"  readonly="true"/>
                            </div>
                            <div class="col-sm-3">
                             <button type="submit" class="btn btn-primary btn-xs col-xs-12 col-sm-4 col-md-3 col-lg-3">Guardar</button>
                             </div>
                            
                        </div><br/><br/>
                        </form:form>
                          </c:if> 
                     </c:forEach>
                 </div>  
    </div>
</div>	

					</div><!-- /.row -->
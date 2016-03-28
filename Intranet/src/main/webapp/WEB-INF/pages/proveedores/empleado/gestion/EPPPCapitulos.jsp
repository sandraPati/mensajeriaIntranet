<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- #section:settings.box -->
						
<div class="page-content">  
<div class="page-header">
 
        <h1>
               Seleccione Capitulo: 
               
        </h1>
        
        
             
             
    </div>

<br/>


<div class="row">
    <div class="col-xs-12">
        
      

        <!-- div.table-responsive -->

        <!-- div.dataTables_borderWrap -->
        <div class="table-responsive">
           <table id="simple-table" class="table table-striped table-bordered table-hover ">
                <thead>
                    <tr>

                        <th>CAPITULO</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>

                    <tbody>
                        <c:forEach items="${lta}" var="item">
                            <tr>


                                    <td>
                                         <c:out value="${item.cod}" /> 
                                    </td>
                                    <td><c:out value="${item.nombre}" /> </td>
                                    
                                    <td>
                                           
                                                <a class="blue tooltip-info" data-rel="tooltip" href="/Intranet/emp/EPPPSupCapitulos.htm?idPresup=${idPresup}&idProp=${idProp}&idC=${item.id}" title="Ver Sub Capitulos">
                                                            <i class="ace-icon glyphicon glyphicon-ok bigger-130"></i>
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
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<div class="page-content">

<script src="<c:url value="/resources/core/jquery.1.10.2.min.js" />"></script>
<script src="<c:url value="/resources/core/jquery.autocomplete.min.js" />"></script>
    
<div class="row">
<div class="col-sm-6"> 
    <c:if test="${chatadd.nifReceptor!=null}">
        
<script type="text/javascript">
     var intervalIdM = 0;
    intervalIdM = setInterval(EcrunchifyAjaxMensE, 9000);
</script>
<div class="widget-box">
    <div class="widget-header">
            <h4 class="widget-title lighter smaller">
                    <i class="ace-icon fa fa-comment blue"></i>
                    Conversación
            </h4>
    </div>

    <div class="widget-body  ">
            <div class="widget-main no-padding">
                    <!-- #section:pages/dashboard.conversations -->
                    <div class="dialogs" id="resultME">
                         <c:forEach items="${data}" var="item">
                        <div class='itemdiv dialogdiv'>
                                    <div class='user'>
                                            <img alt="" src="/Intranet/resources/fotosPerfil/${item.nombrefotografia}" />
                                    </div>
                                    <div class='body'>
                                            <div class='time'>
                                                    <i class='ace-icon fa fa-clock-o'></i>
                                                    <span class='green'>${item.hora}</span>
                                            </div>
                                            <div class='name'>
                                                ${item.nombreEmisor}
                                            </div>
                                            <div class='text'>${item.asunto}</div>
                                            <div class='tools'>
                                                    <a href='#' class='btn btn-minier btn-info'>
                                                            <i class='icon-only ace-icon fa fa-share'></i>
                                                    </a>
                                            </div>
                                    </div>
                            </div>
                        </c:forEach>
                    </div>
                   
                    <!-- /section:pages/dashboard.conversations -->
                    <form:form id="form1" action="" method="POST" commandName="chatadd"class="" role="form">
                        <form:hidden path="nifEmisor" value="${chatadd.nifEmisor}"/>
                        <form:hidden path="nifReceptor" value="${chatadd.nifReceptor}"/>
                            <div class="form-actions">
                                    <div class="input-group">
                                        <form:input type="text" id="asunto" path="asunto" class="form-control col-xs-10 col-sm-3 col-lg-12"/>     
                                        
                                            <span class="input-group-btn">
                                               
                                                    <button class="btn btn-sm btn-info no-radius" type="submit">
                                                            <i class="ace-icon fa fa-share"></i>
                                                            Enviar
                                                    </button>
                                                    <a href="/Intranet/emp/EMensajeria.htm?nifU=${chatadd.nifReceptor}" class="btn btn-white btn-info btn-bold">
                                                            <i class="ace-icon fa fa-refresh bigger-120 blue"></i>
                                                            Actualizar
                                                    </a>

                                            </span>
                                    </div>
                            </div>
                    </form:form>
                    
            </div><!-- /.widget-main -->
    </div><!-- /.widget-body -->
    
     
</div><!-- /.widget-box -->
    </c:if>
</div><!-- /.col -->
<div class="col-sm-3"></div>
<div class="col-sm-3">
         <div class=" widget-container-col">
        <div class="widget-box widget-color-blue">
                <div class="widget-header">
                        <h6 class="widget-title">Contactos</h6>

                        <div class="widget-toolbar">
                                
                                <a href="#" data-action="collapse">
                                        <i class="ace-icon fa fa-chevron-up"></i>
                                </a>


                                <a href="#" data-action="fullscreen" class="orange2">
                                        <i class="ace-icon fa fa-expand"></i>
                                </a>
                        </div>
                </div>

                <div class="widget-body">
                        <!-- #section:custom/scrollbar -->
                        <div class="widget-main padding-4 scrollable" data-size="419">
                                <div class="content" id="resultLtaEE">
                                    <c:forEach items="${empleados}" var="item2">
                                    <div >   
                                    <img src="/Intranet/resources/fotosPerfil/${item2.nombrefotografia}" width="25px" height="25px" alt="bootstrap Chat box user image" class="img-circle" />

                                    <a href="/Intranet/emp/EMensajeria.htm?nifU=${item2.nif}">${item2.nombre}</a>
                                    <c:if test="${item2.inicioS==1}">
                                        <img src="/Intranet/resources/ChatJs/Images/chat-online.png" alt="bootstrap Chat box user image" class="img-circle" />
                                    </c:if>
                                    <c:if test="${item2.inicioS==0}">
                                        <img src="/Intranet/resources/ChatJs/Images/chat-offline.png" alt="bootstrap Chat box user image" class="img-circle" />
                                    </c:if>  
                                       </div>
                                    <hr />

                                    </c:forEach> 
                                        
                                </div>
                        </div>

                        <!-- /section:custom/scrollbar -->
                </div>
        </div>
</div>
               
            </div>
</div>  
    
</div>

<script>
	$(document).ready(function() {
                
		$('#search').autocomplete({
			serviceUrl: '/Intranet/emp/EajaxBuscar.json',
			paramName: "nombre",
			delimiter: ",",
                        
		    transformResult: function(response) {
                        var json2 =  null ; 
                        json2 = ""; 
                        
		        return {
		        	
		            suggestions: $.map($.parseJSON(response), function(item) {
		            	json2=json2+"<div>"+    
                                    "<img src='/Intranet/resources/fotosPerfil/"+item.nombrefotografia+"' width='25px' height='25px' alt='bootstrap Chat box user image' class='img-circle' />"+

                                    "<a href='/Intranet/emp/EMensajeria.htm?nifU="+item.nif+"'>"+item.nombre+"</a>";
                                      if(item.inicioS===1){
                                        json2=json2+"<img src='/Intranet/resources/ChatJs/Images/chat-online.png' alt='bootstrap Chat box user image' class='img-circle' />";
                                    }else{
                                        json2=json2+"<img src='/Intranet/resources/ChatJs/Images/chat-offline.png' alt='bootstrap Chat box user image' class='img-circle' />";
                                    }
                                    
                                    json2=json2+"</div><hr />";
                             $('#resultLtaEE').html(json2);
		                return { value: "", data: ""};
		            })
		            
		        };
		        
		    }
		    
		});
		
		
	});
       
	</script>

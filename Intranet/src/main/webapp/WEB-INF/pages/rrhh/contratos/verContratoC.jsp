
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- #section:settings.box -->
<%
    String ruta1="/Intranet/reportes/Contrato"+request.getAttribute("nif")+".pdf";
%>
<div class="page-content">
    <div>
      <iframe width="1060" height="900" src="/Intranet/sup/pdfCC.htm?nif=${nif}&idC=${idC}" scrolling="no" frameborder="no" ></iframe>
    </div>

</div>
                
   
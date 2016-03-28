<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<!--[if !IE]> -->
<script type="text/javascript">
        window.jQuery || document.write("<script src='<c:url value="/resources/assets/js/jquery.js" />'>"+"<"+"/script>");
</script>

<!-- <![endif]-->

<!--[if IE]>
<script type="text/javascript">
window.jQuery || document.write("<script src='../assets/js/jquery1x.js'>"+"<"+"/script>");
</script>
<![endif]-->
<script type="text/javascript">
        if('ontouchstart' in document.documentElement) document.write("<script src='<c:url value="/resources/assets/js/jquery.mobile.custom.js"/>'>"+"<"+"/script>");
</script>
<script src="<c:url value="/resources/assets/js/bootstrap.js" />"></script>


<script type="text/javascript">
    $(document).ready(function(){
        
        var json1 =  null ; 
            $.ajax({
                url : '/Intranet/ajaxtestFoto.htm',
                success : function(data) {
                    json1 = "<img id='imagenUser'class='nav-user-photo' src='"+data+"' alt='' />"; 
                    $('#resultFoto').html(json1);
                }
            });
        
    });
function calcular_total() {
	importe_total = 0
	$(".importe_linea").each(
		function(index, value) {
			importe_total = importe_total + eval($(this).val());
		}
	);
	$("#total").val(importe_total);
}
 
function nueva_linea() {
    
        $("#lineas").append('<input type="text" class="importe_linea" value="0"/><br/>');
        
}
</script>

<script type="text/javascript">
	
                jQuery(function($){
                   
                    

                    
                    //armarios
                    $("#largoarmario1").on('change',function(e) { 
                        $("#superficiearmario1").attr("value",($("#largoarmario1").val()*$("#altoarmario1").val()).toFixed(2));
                    });
                    $("#altoarmario1").on('change',function(e) { 
                        $("#superficiearmario1").attr("value",($("#largoarmario1").val()*$("#altoarmario1").val()).toFixed(2)); 
                    });
                    
                     $("#largoarmario2").on('change',function(e) { 
                        $("#superficiearmario2").attr("value",($("#largoarmario2").val()*$("#altoarmario2").val()).toFixed(2));
                    });
                    $("#altoarmario2").on('change',function(e) { 
                        $("#superficiearmario2").attr("value",($("#largoarmario2").val()*$("#altoarmario2").val()).toFixed(2)); 
                    });
                     $("#largoarmario3").on('change',function(e) { 
                        $("#superficiearmario3").attr("value",($("#largoarmario3").val()*$("#altoarmario3").val()).toFixed(2));
                    });
                    $("#altoarmario3").on('change',function(e) { 
                        $("#superficiearmario3").attr("value",($("#largoarmario3").val()*$("#altoarmario3").val()).toFixed(2)); 
                    });
                     $("#largoarmario4").on('change',function(e) { 
                        $("#superficiearmario4").attr("value",($("#largoarmario4").val()*$("#altoarmario4").val()).toFixed(2));
                    });
                    $("#altoarmario4").on('change',function(e) { 
                        $("#superficiearmario4").attr("value",($("#largoarmario4").val()*$("#altoarmario4").val()).toFixed(2)); 
                    });
                     $("#largoarmario5").on('change',function(e) { 
                        $("#superficiearmario5").attr("value",($("#largoarmario5").val()*$("#altoarmario5").val()).toFixed(2));
                    });
                    $("#altoarmario5").on('change',function(e) { 
                        $("#superficiearmario5").attr("value",($("#largoarmario5").val()*$("#altoarmario5").val()).toFixed(2)); 
                    });
                     $("#largoarmario6").on('change',function(e) { 
                        $("#superficiearmario6").attr("value",($("#largoarmario6").val()*$("#altoarmario6").val()).toFixed(2));
                    });
                    $("#altoarmario6").on('change',function(e) { 
                        $("#superficiearmario6").attr("value",($("#largoarmario6").val()*$("#altoarmario6").val()).toFixed(2)); 
                    });
                     $("#largoarmario7").on('change',function(e) { 
                        $("#superficiearmario7").attr("value",($("#largoarmario7").val()*$("#altoarmario7").val()).toFixed(2));
                    });
                    $("#altoarmario7").on('change',function(e) { 
                        $("#superficiearmario7").attr("value",($("#largoarmario7").val()*$("#altoarmario7").val()).toFixed(2)); 
                    });
                     $("#largoarmario8").on('change',function(e) { 
                        $("#superficiearmario8").attr("value",($("#largoarmario8").val()*$("#altoarmario8").val()).toFixed(2));
                    });
                    $("#altoarmario8").on('change',function(e) { 
                        $("#superficiearmario8").attr("value",($("#largoarmario8").val()*$("#altoarmario8").val()).toFixed(2)); 
                    });
                     $("#largoarmario9").on('change',function(e) { 
                        $("#superficiearmario9").attr("value",($("#largoarmario9").val()*$("#altoarmario9").val()).toFixed(2));
                    });
                    $("#altoarmario9").on('change',function(e) { 
                        $("#superficiearmario9").attr("value",($("#largoarmario9").val()*$("#altoarmario9").val()).toFixed(2)); 
                    });
                     $("#largoarmario10").on('change',function(e) { 
                        $("#superficiearmario10").attr("value",($("#largoarmario10").val()*$("#altoarmario10").val()).toFixed(2));
                    });
                    $("#altoarmario10").on('change',function(e) { 
                        $("#superficiearmario10").attr("value",($("#largoarmario10").val()*$("#altoarmario10").val()).toFixed(2)); 
                    });
                   
                });
                    
		</script>

<!-- ace scripts -->
<script src="<c:url value="/resources/assets/js/ace/elements.scroller.js" />"></script>
<script src="<c:url value="/resources/assets/js/ace/elements.colorpicker.js" />"></script>
<script src="<c:url value="/resources/assets/js/ace/elements.fileinput.js" />"></script>
<script src="<c:url value="/resources/assets/js/ace/elements.typeahead.js" />"></script>
<script src="<c:url value="/resources/assets/js/ace/elements.wysiwyg.js" />"></script>
<script src="<c:url value="/resources/assets/js/ace/elements.spinner.js" />"></script>
<script src="<c:url value="/resources/assets/js/ace/elements.treeview.js" />"></script>
<script src="<c:url value="/resources/assets/js/ace/elements.wizard.js" />"></script>
<script src="<c:url value="/resources/assets/js/ace/elements.aside.js" />"></script>
<script src="<c:url value="/resources/assets/js/ace/ace.js" />"></script>
<script src="<c:url value="/resources/assets/js/ace/ace.ajax-content.js" />"></script>
<script src="<c:url value="/resources/assets/js/ace/ace.touch-drag.js" />"></script>
<script src="<c:url value="/resources/assets/js/ace/ace.sidebar.js" />"></script>
<script src="<c:url value="/resources/assets/js/ace/ace.sidebar-scroll-1.js" />"></script>
<script src="<c:url value="/resources/assets/js/ace/ace.submenu-hover.js" />"></script>
<script src="<c:url value="/resources/assets/js/ace/ace.widget-box.js" />"></script>
<script src="<c:url value="/resources/assets/js/ace/ace.settings.js" />"></script>
<script src="<c:url value="/resources/assets/js/ace/ace.settings-rtl.js" />"></script>
<script src="<c:url value="/resources/assets/js/ace/ace.settings-skin.js" />"></script>
<script src="<c:url value="/resources/assets/js/ace/ace.widget-on-reload.js" />"></script>
<script src="<c:url value="/resources/assets/js/ace/ace.searchbox-autocomplete.js" />"></script>

<!-- the following scripts are used in demo only for onpage help and you don't need them -->
<link rel="stylesheet" href="<c:url value="/resources/assets/css/ace.onpage-help.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/docs/assets/js/themes/sunburst.css"/>" />

<script type="text/javascript"> ace.vars['base'] = '..'; </script>
<script src="<c:url value="/resources/assets/js/ace/elements.onpage-help.js"/>"></script>
<script src="<c:url value="/resources/assets/js/ace/ace.onpage-help.js"/>"></script>
<script src="<c:url value="/resources/docs/assets/js/rainbow.js"/>"></script>
<script src="<c:url value="/resources/docs/assets/js/language/generic.js"/>"></script>
<script src="<c:url value="/resources/docs/assets/js/language/html.js"/>"></script>
<script src="<c:url value="/resources/docs/assets/js/language/css.js"/>"></script>
<script src="<c:url value="/resources/docs/assets/js/language/javascript.js"/>"></script>



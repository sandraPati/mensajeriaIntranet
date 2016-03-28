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
	$(document).ready(function(){
            $("#Numventanas").hide();
            $("#Numpuertas").hide();
            $("#Numarmarios").hide();
            
            
          //ventanas
          
            $("#ventana1").click(function() {             
                $("#Numventanas").show();
                $("#venN").show();
            });
             $("#ventana2").click(function() {             
                $("#Numventanas").hide();
            });
            //puertas
            $("#puertas1").click(function() {             
                $("#Numpuertas").show();
            });
             $("#puertas2").click(function() {             
                $("#Numpuertas").hide();
            });
            //armarios
            $("#armario1").click(function() {             
                $("#Numarmarios").show();
            });
             $("#armario2").click(function() {             
                $("#Numarmarios").hide();
            });
        });
                jQuery(function($){
                   
                    //pano
                    
                    $("#largo").on('change',function(e) { 
                        $("#superficie").attr("value",($("#largo").val()*$("#alto").val()).toFixed(2));
                    });
                    $("#alto").on('change',function(e) { 
                        $("#superficie").attr("value",($("#largo").val()*$("#alto").val()).toFixed(2)); 
                    });
                    
                    //ventanas
                    
                   
                    $("#largoventana1").on('change',function(e) { 
                        $("#superficieventana1").attr("value",($("#largoventana1").val()*$("#altoventana1").val()).toFixed(2));
                    });
                    $("#altoventana1").on('change',function(e) { 
                        $("#superficieventana1").attr("value",($("#largoventana1").val()*$("#altoventana1").val()).toFixed(2)); 
                    });
                    $("#largoventana2").on('change',function(e) { 
                        $("#superficieventana2").attr("value",($("#largoventana2").val()*$("#altoventana2").val()).toFixed(2));
                    });
                    $("#altoventana2").on('change',function(e) { 
                        $("#superficieventana2").attr("value",($("#largoventana2").val()*$("#altoventana2").val()).toFixed(2)); 
                    });
                     $("#largoventana3").on('change',function(e) { 
                        $("#superficieventana3").attr("value",($("#largoventana3").val()*$("#altoventana3").val()).toFixed(2));
                    });
                    $("#altoventana3").on('change',function(e) { 
                        $("#superficieventana3").attr("value",($("#largoventana3").val()*$("#altoventana3").val()).toFixed(2)); 
                    });
                    $("#largoventana4").on('change',function(e) { 
                        $("#superficieventana4").attr("value",($("#largoventana4").val()*$("#altoventana4").val()).toFixed(2));
                    });
                    $("#altoventana4").on('change',function(e) { 
                        $("#superficieventana4").attr("value",($("#largoventana4").val()*$("#altoventana4").val()).toFixed(2)); 
                    });
                    $("#largoventana5").on('change',function(e) { 
                        $("#superficieventana5").attr("value",($("#largoventana5").val()*$("#altoventana5").val()).toFixed(2));
                    });
                    $("#altoventana5").on('change',function(e) { 
                        $("#superficieventana5").attr("value",($("#largoventana5").val()*$("#altoventana5").val()).toFixed(2)); 
                    });
                    $("#largoventana6").on('change',function(e) { 
                        $("#superficieventana6").attr("value",($("#largoventana6").val()*$("#altoventana6").val()).toFixed(2));
                    });
                    $("#altoventana6").on('change',function(e) { 
                        $("#superficieventana6").attr("value",($("#largoventana6").val()*$("#altoventana6").val()).toFixed(2)); 
                    });
                    $("#largoventana7").on('change',function(e) { 
                        $("#superficieventana7").attr("value",($("#largoventana7").val()*$("#altoventana7").val()).toFixed(2));
                    });
                    $("#altoventana7").on('change',function(e) { 
                        $("#superficieventana7").attr("value",($("#largoventana7").val()*$("#altoventana7").val()).toFixed(2)); 
                    });
                    $("#largoventana8").on('change',function(e) { 
                        $("#superficieventana8").attr("value",($("#largoventana8").val()*$("#altoventana8").val()).toFixed(2));
                    });
                    $("#altoventana8").on('change',function(e) { 
                        $("#superficieventana8").attr("value",($("#largoventana8").val()*$("#altoventana8").val()).toFixed(2)); 
                    });
                    $("#largoventana9").on('change',function(e) { 
                        $("#superficieventana9").attr("value",($("#largoventana9").val()*$("#altoventana9").val()).toFixed(2));
                    });
                    $("#altoventana9").on('change',function(e) { 
                        $("#superficieventana9").attr("value",($("#largoventana9").val()*$("#altoventana9").val()).toFixed(2)); 
                    });
                    $("#largoventana10").on('change',function(e) { 
                        $("#superficieventana10").attr("value",($("#largoventana10").val()*$("#altoventana10").val()).toFixed(2));
                    });
                    $("#altoventana10").on('change',function(e) { 
                        $("#superficieventana10").attr("value",($("#largoventana10").val()*$("#altoventana10").val()).toFixed(2)); 
                    });
                    //puertas
                    $("#largopuerta").on('change',function(e) { 
                        $("#superficiepuerta").attr("value",(($("#largopuerta").val()*$("#altopuerta").val())*$("#numpuertas").val()).toFixed(2));
                    });
                    $("#altopuerta").on('change',function(e) { 
                        $("#superficiepuerta").attr("value",(($("#largopuerta").val()*$("#altopuerta").val())*$("#numpuertas").val()).toFixed(2)); 
                    });
                    $("#numpuertas").on('change',function(e) { 
                        $("#superficiepuerta").attr("value",(($("#largopuerta").val()*$("#altopuerta").val())*$("#numpuertas").val()).toFixed(2));
                    });
                    
                    //armarios
                    $("#largoarmario").on('change',function(e) { 
                        $("#superficiearmario").attr("value",(($("#largoarmario").val()*$("#altoarmario").val())*$("#numarmarios").val()).toFixed(2));
                    });
                    $("#altoarmario").on('change',function(e) { 
                        $("#superficiearmario").attr("value",(($("#largoarmario").val()*$("#altoarmario").val())*$("#numarmarios").val()).toFixed(2)); 
                    });
                    $("#numarmarios").on('change',function(e) { 
                        $("#superficiearmario").attr("value",(($("#largoarmario").val()*$("#altoarmario").val())*$("#numarmarios").val()).toFixed(2));
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



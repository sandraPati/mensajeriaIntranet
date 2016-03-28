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
        select_change();
        largo_change();
        alto_change();
        btn();
        var json1 =  null ; 
            $.ajax({
                url : '/Intranet/ajaxtestFoto.htm',
                success : function(data) {
                    json1 = "<img id='imagenUser'class='nav-user-photo' src='"+data+"' alt='' />"; 
                    $('#resultFoto').html(json1);
                }
            });
        
    });
    function btn() {
            $('.btn').click(function () {
 
                //Control checkbox
                var ddl = $(this);
 
                //Obtenemos   la fila contenedora para el checkbox
                var tr = ddl.closest("tr");
 
                var td = ddl.closest("td");
 
                //Si esta activo el checkbox
              var selec = tr.find('.ddl');    
                               
                               var superficiepuerta = tr.find('.superficiepuerta'); 
                            var obj=null;
                            if(selec.val()=="5"){  
                                var largopuerta = tr.find('.largopuerta');             
                               var altopuerta = tr.find('.altopuerta');  
                               obj={id_pano:${pa.id},num:tr.find('.numV').val(),largo:largopuerta.val(),alto:altopuerta.val(),superficie:superficiepuerta.val(),estandar:5};
                            }else{
                                 if(selec.val()=="1"){
                                     obj={id_pano:${pa.id},num:tr.find('.numV').val(),largo:0.6,alto:2.1,superficie:superficiepuerta.val(),estandar:1};
                                 }else  if(selec.val()=="2"){
                                     obj={id_pano:${pa.id},num:tr.find('.numV').val(),largo:0.7,alto:2.1,superficie:superficiepuerta.val(),estandar:2};
                                 }else  if(selec.val()=="3"){
                                     obj={id_pano:${pa.id},num:tr.find('.numV').val(),largo:0.8,alto:2.1,superficie:superficiepuerta.val(),estandar:3};
                                 }else  if(selec.val()=="4"){
                                     obj={id_pano:${pa.id},num:tr.find('.numV').val(),largo:0.9,alto:2.1,superficie:superficiepuerta.val(),estandar:4};
                                 }
                            }
                            $.ajax({
                                 type:'POST',
                                 contentType:'application/json',
                                 url:"/Intranet/sup/ExpresjsonNuevaPropuestaEjaddPuertasF.htm",
                                 data:JSON.stringify(obj),
                                 success:function(data){
                                    //$("#tipoc").attr('disabled', 'false');
                                    window.location.replace(data);

                                 }
                             });
            });
        }
    function select_change() {
            $('.ddl').change(function () {
 
                //Control checkbox
                var ddl = $(this);
 
                //Obtenemos   la fila contenedora para el checkbox
                var tr = ddl.closest("tr");
 
                //Buscamos en la actual fila el select, filtrando por la clase
                //var ddl = tr.find('.ddl');
 
                //Obtenemos la celda que contiene al checkbox
                var td = ddl.closest("td");
 
                //Si esta activo el checkbox
              var selec = ddl;    
                               var largopuerta = tr.find('.largopuerta');             
                               var altopuerta = tr.find('.altopuerta');  
                               var superficiepuerta = tr.find('.superficiepuerta'); 
                            if(selec.val()=="5"){                                       
                               superficiepuerta.attr("value",(largopuerta.val()*altopuerta.val()).toFixed(2));
                               largopuerta.show();
                               altopuerta.show();
                               superficiepuerta.show();
                               
                               
                            }else{
                                largopuerta.hide();
                               altopuerta.hide();
                               largopuerta.attr("value","");
                               altopuerta.attr("value","");
                                var sup=tr.find('.superficiepuerta');  
                                if(selec.val()=="1"){ 
                                    var superficiepuerta = tr.find('.superficiepuerta'); 
                                    superficiepuerta.show();
                                    sup.attr("value",(0.6*2.1).toFixed(2));
                                    
                                }else if(selec.val()=="2"){ 
                                    var superficiepuerta = tr.find('.superficiepuerta'); 
                                    superficiepuerta.show();
                                    sup.attr("value",(0.7*2.1).toFixed(2));
                                    
                                }else if(selec.val()=="3"){ 
                                    var superficiepuerta = tr.find('.superficiepuerta');
                                    superficiepuerta.show();
                                    sup.attr("value",(0.8*2.1).toFixed(2));
                                    
                                }else if(selec.val()=="4"){ 
                                    var superficiepuerta = tr.find('.superficiepuerta');
                                    superficiepuerta.show();
                                    sup.attr("value",(0.9*2.1).toFixed(2));
                                    
                                }
                                
                                
                            }
            });
        }
        function largo_change() {
            $('.largopuerta').change(function () {
 
                //Control checkbox
                var ddl = $(this);
 
                //Obtenemos   la fila contenedora para el checkbox
                var tr = ddl.closest("tr");
 
                //Buscamos en la actual fila el select, filtrando por la clase
                //var ddl = tr.find('.ddl');
 
                //Obtenemos la celda que contiene al checkbox
                var td = ddl.closest("td");
 
                //Si esta activo el checkbox
              var selec = ddl;      
                    var superficiepuerta = tr.find('.superficiepuerta'); 
                    superficiepuerta.show();
                    superficiepuerta.attr("value",(tr.find('.largopuerta').val()*tr.find('.altopuerta').val()).toFixed(2));                                               

                           
            });
        }
        function alto_change() {
            $('.altopuerta').change(function () {
 
                //Control checkbox
                var ddl = $(this);
 
                //Obtenemos   la fila contenedora para el checkbox
                var tr = ddl.closest("tr");
 
                //Buscamos en la actual fila el select, filtrando por la clase
                //var ddl = tr.find('.ddl');
 
                //Obtenemos la celda que contiene al checkbox
                var td = ddl.closest("td");
 
                //Si esta activo el checkbox
              var selec = ddl;      
                    var superficiepuerta = tr.find('.superficiepuerta'); 
                    superficiepuerta.show();
                    superficiepuerta.attr("value",(tr.find('.largopuerta').val()*tr.find('.altopuerta').val()).toFixed(2));                                               

                           
            });
        }
</script>

<script type="text/javascript">
	
                jQuery(function($){
                   
                    //pano
                    
                    $("#largo").on('change',function(e) { 
                        $("#superficiepuerta").attr("value",($("#largo").val()*$("#alto").val()).toFixed(2));
                    });
                    $("#alto").on('change',function(e) { 
                        $("#superficiepuerta").attr("value",($("#largo").val()*$("#alto").val()).toFixed(2)); 
                    });
                    
                    //ventanas
                    if($("#estandar").val()==='1') { 
                        $("#superficiepuerta").attr("value",(0.6*2.1).toFixed(2)); 
                   }
                   
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



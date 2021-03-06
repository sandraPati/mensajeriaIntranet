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
</script>

<script type="text/javascript">
	$(document).ready(function(){
            $("#Numventanas").hide();
            $("#Numpuertas").hide();
            $("#Numarmarios").hide();
            $("#venN").hide();
            
          //ventanas
          if($("#ventana1").is(":checked")){
                $("#Numventanas").show();
                $("#venN").show();
            }else if($("#ventana2").is(":checked")){
                $("#Numventanas").hide();
            }
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
            $("#formapano1").click(function() {  
                $("#labela").text("a");
                $('#ladob').hide();
                $('#ladoc').hide();
                $('#ladod').hide();
                
                                $("#superficie").attr("value",($("#a").val()*$("#a").val()).toFixed(2));
                            
            });
             $("#formapano2").click(function() {  
                $("#labela").text("a");
                $("#labelb").text("b");
                $('#ladob').show();
                $('#ladoc').hide();
                $('#ladod').hide();
                
                                $("#superficie").attr("value",($("#a").val()*$("#b").val()).toFixed(2));
            });
            $("#formapano3").click(function() {  
                $("#labela").text("a");
                $("#labelb").text("b");
                $("#labelc").text("c");
                $('#ladob').show();
                $('#ladoc').show();
                $('#ladod').show();
                var forma1=$("#a").val()*$("#b").val();
                var forma2=$("#c").val()*$("#d").val();
                                $("#superficie").attr("value",(parseFloat(forma1)+parseFloat(forma2)).toFixed(2));
            });
            $("#formapano4").click(function() {  
                $("#labela").text("D");
                $("#labelb").text("d");
                $('#ladob').show();
                $('#ladoc').hide();
                $('#ladod').hide();
                                $("#superficie").attr("value",(($("#a").val()*$("#b").val())/2).toFixed(2));
            });
            $("#formapano5").click(function() {  
                $("#labela").text("b");
                $("#labelb").text("B");
                $("#labelc").text("h");
                $('#ladob').show();
                $('#ladoc').show();
                $('#ladod').hide();
                                $("#superficie").attr("value",(((parseFloat($("#a").val())+parseFloat($("#b").val()))*parseFloat($("#c").val()))/2).toFixed(2));
            });
            
            if($("#tipo_pano_id").val()!='1') { 
                                
                                 $('#forma').show();
                                 if($("#formapano1").is(":checked")){
                                    $("#labela").text("a");
                                    $('#ladob').hide();
                                    $('#ladoc').hide();
                                    $('#ladod').hide();

                                                    $("#superficie").attr("value",($("#a").val()*$("#a").val()).toFixed(2));
                                }else if($("#formapano2").is(":checked")){
                                    $("#labela").text("a");
                                    $("#labelb").text("b");
                                    $('#ladob').show();
                                    $('#ladoc').hide();
                                    $('#ladod').hide();

                                                    $("#superficie").attr("value",($("#a").val()*$("#b").val()).toFixed(2));
                                }else if($("#formapano3").is(":checked")){
                                    $("#labela").text("a");
                                    $("#labelb").text("b");
                                    $("#labelc").text("c");
                                    $('#ladob').show();
                                    $('#ladoc').show();
                                    $('#ladod').show();
                                    var forma1=$("#a").val()*$("#b").val();
                                    var forma2=$("#c").val()*$("#d").val();
                                                    $("#superficie").attr("value",(parseFloat(forma1)+parseFloat(forma2)).toFixed(2));
                                }else if($("#formapano4").is(":checked")){
                                    $("#labela").text("D");
                                    $("#labelb").text("d");
                                    $('#ladob').show();
                                    $('#ladoc').hide();
                                    $('#ladod').hide();
                                                    $("#superficie").attr("value",(($("#a").val()*$("#b").val())/2).toFixed(2));
                                }else if($("#formapano5").is(":checked")){
                                    $("#labela").text("b");
                                    $("#labelb").text("B");
                                    $("#labelc").text("h");
                                    $('#ladob').show();
                                    $('#ladoc').show();
                                    $('#ladod').hide();
                                                    $("#superficie").attr("value",(((parseFloat($("#a").val())+parseFloat($("#b").val()))*parseFloat($("#c").val()))/2).toFixed(2));
                                }
                            }else{
                                
                                $("#labela").text("ALTO");
                                $("#labelb").text("LARGO");
                                $('#ladob').show();
                                $('#ladoc').hide();
                                $('#ladod').hide();
                            }
        
            
        });
                jQuery(function($){
                    
                    $('#tipo_pano_id').on('change',function(e) {
                            
                             if($("#tipo_pano_id").val()!='1') { 
                                
                                 $('#forma').show();
                                 if($("#formapano1").is(":checked")){
                                    $("#labela").text("a");
                                    $('#ladob').hide();
                                    $('#ladoc').hide();
                                    $('#ladod').hide();

                                                    $("#superficie").attr("value",($("#a").val()*$("#a").val()).toFixed(2));
                                }else if($("#formapano2").is(":checked")){
                                    $("#labela").text("a");
                                    $("#labelb").text("b");
                                    $('#ladob').show();
                                    $('#ladoc').hide();
                                    $('#ladod').hide();

                                                    $("#superficie").attr("value",($("#a").val()*$("#b").val()).toFixed(2));
                                }else if($("#formapano3").is(":checked")){
                                    $("#labela").text("a");
                                    $("#labelb").text("b");
                                    $("#labelc").text("c");
                                    $('#ladob').show();
                                    $('#ladoc').show();
                                    $('#ladod').show();
                                    var forma1=$("#a").val()*$("#b").val();
                                    var forma2=$("#c").val()*$("#d").val();
                                                    $("#superficie").attr("value",(parseFloat(forma1)+parseFloat(forma2)).toFixed(2));
                                }else if($("#formapano4").is(":checked")){
                                    $("#labela").text("D");
                                    $("#labelb").text("d");
                                    $('#ladob').show();
                                    $('#ladoc').hide();
                                    $('#ladod').hide();
                                                    $("#superficie").attr("value",(($("#a").val()*$("#b").val())/2).toFixed(2));
                                }else if($("#formapano5").is(":checked")){
                                    $("#labela").text("b");
                                    $("#labelb").text("B");
                                    $("#labelc").text("h");
                                    $('#ladob').show();
                                    $('#ladoc').show();
                                    $('#ladod').hide();
                                                    $("#superficie").attr("value",(((parseFloat($("#a").val())+parseFloat($("#b").val()))*parseFloat($("#c").val()))/2).toFixed(2));
                                }
                            }else{
                                $("#superficie").attr("value",($("#a").val()*$("#b").val()).toFixed(2));
                                $("#labela").text("ALTO");
                                $("#labelb").text("LARGO");
                                $('#ladob').show();
                                $('#ladoc').hide();
                                $('#ladod').hide();
                                $('#forma').hide();
                            }
        
					
					
			 });
                     
                         
                    $("#numventanas").on('change',function(e) { 
                        $("#venN").show();
                    });
        
                    //pano
                    
                    $("#a").on('change',function(e) {
                        
                        if($("#tipo_pano_id").val()!='1') { 
                            if($("#formapano1").is(":checked")){
                                $("#superficie").attr("value",($("#a").val()*$("#a").val()).toFixed(2));
                            }else if($("#formapano2").is(":checked")){
                                $("#superficie").attr("value",($("#a").val()*$("#b").val()).toFixed(2));
                            }else if($("#formapano3").is(":checked")){
                                var forma1=$("#a").val()*$("#b").val();
                                var forma2=$("#c").val()*$("#d").val();
                                                $("#superficie").attr("value",(parseFloat(forma1)+parseFloat(forma2)).toFixed(2));
                            }else if($("#formapano4").is(":checked")){
                                $("#superficie").attr("value",(($("#a").val()*$("#b").val())/2).toFixed(2));
                            }else if($("#formapano5").is(":checked")){
                                $("#superficie").attr("value",(((parseFloat($("#a").val())+parseFloat($("#b").val()))*parseFloat($("#c").val()))/2).toFixed(2));
                            }
                        }else{
                            $("#superficie").attr("value",($("#a").val()*$("#b").val()).toFixed(2));
                        }
                    });
                    $("#b").on('change',function(e) { 
                        
                        if($("#tipo_pano_id").val()!='1') { 
                            if($("#formapano1").is(":checked")){
                                $("#superficie").attr("value",($("#a").val()*$("#a").val()).toFixed(2));
                            }else if($("#formapano2").is(":checked")){
                                $("#superficie").attr("value",($("#a").val()*$("#b").val()).toFixed(2));
                            }else if($("#formapano3").is(":checked")){
                                var forma1=$("#a").val()*$("#b").val();
                                var forma2=$("#c").val()*$("#d").val();
                                                $("#superficie").attr("value",(parseFloat(forma1)+parseFloat(forma2)).toFixed(2));
                            }else if($("#formapano4").is(":checked")){
                                $("#superficie").attr("value",(($("#a").val()*$("#b").val())/2).toFixed(2));
                            }else if($("#formapano5").is(":checked")){
                                $("#superficie").attr("value",(((parseFloat($("#a").val())+parseFloat($("#b").val()))*parseFloat($("#c").val()))/2).toFixed(2));
                            }
                        }else{
                            $("#superficie").attr("value",($("#a").val()*$("#b").val()).toFixed(2));
                        }
                    });
                    $("#c").on('change',function(e) { 
                        
                        if($("#tipo_pano_id").val()!='1') { 
                            if($("#formapano1").is(":checked")){
                                $("#superficie").attr("value",($("#a").val()*$("#a").val()).toFixed(2));
                            }else if($("#formapano2").is(":checked")){
                                $("#superficie").attr("value",($("#a").val()*$("#b").val()).toFixed(2));
                            }else if($("#formapano3").is(":checked")){
                                var forma1=$("#a").val()*$("#b").val();
                                var forma2=$("#c").val()*$("#d").val();
                                                $("#superficie").attr("value",(parseFloat(forma1)+parseFloat(forma2)).toFixed(2));
                            }else if($("#formapano4").is(":checked")){
                                $("#superficie").attr("value",(($("#a").val()*$("#b").val())/2).toFixed(2));
                            }else if($("#formapano5").is(":checked")){
                                $("#superficie").attr("value",(((parseFloat($("#a").val())+parseFloat($("#b").val()))*parseFloat($("#c").val()))/2).toFixed(2));
                            }
                        }else{
                            $("#superficie").attr("value",($("#a").val()*$("#b").val()).toFixed(2));
                        }
                    });
                     $("#d").on('change',function(e) { 
                        
                        if($("#tipo_pano_id").val()!='1') { 
                            if($("#formapano1").is(":checked")){
                                $("#superficie").attr("value",($("#a").val()*$("#a").val()).toFixed(2));
                            }else if($("#formapano2").is(":checked")){
                                $("#superficie").attr("value",($("#a").val()*$("#b").val()).toFixed(2));
                            }else if($("#formapano3").is(":checked")){
                                var forma1=$("#a").val()*$("#b").val();
                                var forma2=$("#c").val()*$("#d").val();
                                                $("#superficie").attr("value",(parseFloat(forma1)+parseFloat(forma2)).toFixed(2));
                            }else if($("#formapano4").is(":checked")){
                                $("#superficie").attr("value",(($("#a").val()*$("#b").val())/2).toFixed(2));
                            }else if($("#formapano5").is(":checked")){
                                $("#superficie").attr("value",(((parseFloat($("#a").val())+parseFloat($("#b").val()))*parseFloat($("#c").val()))/2).toFixed(2));
                            }
                        }else{
                            $("#superficie").attr("value",($("#a").val()*$("#b").val()).toFixed(2));
                        }
                    });
                    //ventanas
                    
                   
                    $("#largoventana").on('change',function(e) { 
                        $("#superficieventana").attr("value",($("#largoventana").val()*$("#altoventana").val()).toFixed(2));
                    });
                    $("#altoventana").on('change',function(e) { 
                        $("#superficieventana").attr("value",($("#largoventana").val()*$("#altoventana").val()).toFixed(2)); 
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



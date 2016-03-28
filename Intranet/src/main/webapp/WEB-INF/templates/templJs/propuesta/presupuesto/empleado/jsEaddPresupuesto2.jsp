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
        checkbox_change();
        checkbox_change2();
        var json1 =  null ; 
            $.ajax({
                url : '/Intranet/ajaxtestFoto.htm',
                success : function(data) {
                    json1 = "<img id='imagenUser'class='nav-user-photo' src='"+data+"' alt='' />"; 
                    $('#resultFoto').html(json1);
                }
            });
        
    });
    function updmedida(x)
    {
        
        alert(x);
    }
    
    $("#form1").submit(function(event){
    event.preventDefault();

//    var rawData=$('#form1').serializeFormJSON();
//    
//    var formData=JSON.stringify(rawData);
//    var presupuestoJ=/*{"presupuestoJ":*/
//                [
//            {"propuesta_id":"12","idCap":"1","idSubCap":"2","tipoCantidad":"und."},
//            {"propuesta_id":"12","idCap":"1","idSubCap":"2","tipoCantidad":"und."},
//            {"propuesta_id":"12","idCap":"1","idSubCap":"2","tipoCantidad":"und."}]
//    /*}*/;
//    var r=JSON.stringify(presupuestoJ);
//    alert(formData);
    
    var rows = $('table').find(':checkbox:checked').parents('tr');
    var data = [];
    
    if(undefined !== rows && null !== rows && rows.length>0){
        $.each(rows,function(index,item){
           var json = {"propuesta_id":$(item).find('#propuesta_id').val()
                        ,"idCap":$(item).find('#idCap').val()
                        ,"idSubCap":$(item).find('#idSubCap').val()
                        ,"tipoCantidad":$(item).find('#tipoc').val()}; 
                    
                    data.push(json);
        });
    }
     $.ajax({
           type: 'POST',
            contentType:'application/json',
           url: "/Intranet/emp/EaddPresupuesto2.htm",
           data: JSON.stringify(data), // Adjuntar los campos del formulario enviado.
           success: function(data)
           {
              
               window.location.href = data;
           },error:function(data,status,er) { 
                alert("error: "+data+" status: "+status+" er:"+er);
            }
         });
});
    (function($) {
    $.fn.serializeFormJSON = function() {
    var o = [];

        $(this).find('tr').each(function() {
            var $this = $(this);
            var $elements = $this.find('input, textarea, select');
            if ($elements.size() > 0) {
                var serialized = $elements.serialize();

                var item = $.toDictionary( serialized );
                o.push(item);
            }
        });
       return o;
    };

    $.extend({
            toDictionary: function(query) {
                var parms = {};
                var items = query.split("&"); // split
                for (var i = 0; i < items.length; i++) {
                    var values = items[i].split("=");
                    var key = decodeURIComponent(values.shift());
                    var value = values.join("=");
                    parms[key] = decodeURIComponent(value);
                }
                return (parms);
            }
        });
    })(jQuery);
   
       function checkbox_change() {
            $('.chk').change(function () {
 
                //Control checkbox
                var chk = $(this);
 
                //Obtenemos   la fila contenedora para el checkbox
                var tr = chk.closest("tr");
 
                //Buscamos en la actual fila el select, filtrando por la clase
               
                //Si esta activo el checkbox
                if (chk.is(':checked')) {
                    //Habilitamos
                    var obj={presup_id:$("#presup_id").val(),idSubCap:chk.val(),tipoCantidad:tr.find('.ddl').val()};
                  
                    $.ajax({
                        type:'POST',
                        contentType:'application/json',
                        url:"/Intranet/emp/EjsonAddPresupSubCap.htm",
                        data:JSON.stringify(obj),
                        success:function(data){
                           //$("#tipoc").attr('disabled', 'false');
                          var ddl1 = tr.find('.SubCapCheckIcon');
                            ddl1.show();
                            var ddl2 = tr.find('.SubCapCheckIcon1');
                            ddl2.hide();
                            var ddl3 = tr.find('.UsarPanosGuardado3');
                            var ddl4 = tr.find('.UsarPanosGuardado4');
                            
                                        if(tr.find('.ddl').val()!="und."){                                        
                                            ddl3.show();
                                            ddl4.hide();
                                            
                                        }else{
                                            ddl3.hide();
                                            ddl4.hide();
                                        }
                        }
                    });
                    
                } else {
                   var obj={presup_id:$("#presup_id").val(),idSubCap:chk.val()};
                  
                    $.ajax({
                        type:'POST',
                        contentType:'application/json',
                        url:"/Intranet/emp/EjsonDeletePresupSubCap.htm",
                        data:JSON.stringify(obj),
                        success:function(data){
                           //$("#tipoc").attr('disabled', 'false');
                            var ddl1 = tr.find('.SubCapCheckIcon');
                            ddl1.hide();
                            var ddl2 = tr.find('.SubCapCheckIcon1');
                            ddl2.hide();
                            var ddl3 = tr.find('.UsarPanosGuardado3');
                            ddl3.hide();
                            var ddl4 = tr.find('.UsarPanosGuardado4');
                            ddl4.hide();
                            var lista1 = tr.find('.presupuestom1');
                            var lista2 = tr.find('.presupuestom2');
                            lista1.hide();
                            lista2.hide();
                        }
                    });
                }
            });
        }
        function checkbox_change2() {
            $('.chk2').change(function () {
 
                //Control checkbox
                var chk = $(this);
 
                //Obtenemos   la fila contenedora para el checkbox
                var tr = chk.closest("tr");
 
                //Buscamos en la actual fila el select, filtrando por la clase
                var ddl = tr.find('.ddl');
 
                //Obtenemos la celda que contiene al checkbox
                var td = chk.closest("td");
 
                //Si esta activo el checkbox
                if (chk.is(':checked')) {
                    
                    var obj={presup_id:$("#presup_id").val(),idSubCap:chk.val()};
                   
                    $.ajax({
                        type:'POST',
                        contentType:'application/json',
                        url:"/Intranet/emp/EjsonguardarPanosSelecAddPresup.htm",
                        data:JSON.stringify(obj),
                        success:function(data){
                           //$("#").attr('disabled', 'disabled');
                          window.location.replace(data);
                        }
                    });
                    
                } 
            });
        }
     function select_change() {
            $('.ddl').change(function () {
                
                //Obtenemos el select 
                 var ddl = $(this);
                var tr = ddl.closest("tr");
                var chk = tr.find('.chk');
                 if (chk.is(':checked')) {
                                //Asignamos al select el valor seleccionado en la primera fila.
                               
                                var obj={presup_id:$("#presup_id").val(),idSubCap:chk.val(),tipoCantidad:tr.find('.ddl').val()};
                                
                                 $.ajax({
                                     type:'POST',
                                     contentType:'application/json',
                                     url:"/Intranet/emp/EjsonAddUpdMedida.htm",
                                     data:JSON.stringify(obj),
                                     success:function(data){
                                        //$("#tipoc").attr('disabled', 'false');
                                        var ddl1 = tr.find('.SubCapCheckIcon');
                                        ddl1.show();
                                        var ddl3 = tr.find('.UsarPanosGuardado3');
                                        var ddl4 = tr.find('.UsarPanosGuardado4');
                                        var lista1 = tr.find('.presupuestom1');
                                        var lista2 = tr.find('.presupuestom2');
                                        if(tr.find('.ddl').val()!="und."){                                        
                                            
                                            
                                        }else{
                                            ddl3.hide();
                                            ddl4.hide();
                                            lista1.hide();
                                            lista2.hide();
                                        }
                                        
                                        var ddl2 = tr.find('.SubCapCheckIcon1');
                                        ddl2.hide();
                                     }
                                 });
                                
                            }
                        
                   
                
            });
        }
     
    
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



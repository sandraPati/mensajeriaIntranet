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

    <!-- page specific plugin scripts -->
		<script src="<c:url value="/resources/assets/js/jquery.bootstrap-duallistbox.js" />"></script>
		<script src="<c:url value="/resources/assets/js/jquery.raty.js" />"></script>
		<script src="<c:url value="/resources/assets/js/bootstrap-multiselect.js" />"></script>
		<script src="<c:url value="/resources/assets/js/select2.js" />"></script>
		<script src="<c:url value="/resources/assets/js/typeahead.jquery.js" />"></script>

    
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

<script type="text/javascript">
    (function ( $ ) {
 
    $.fn.rating = function( method, options ) {
		method = method || 'create';
        // This is the easiest way to have default options.
        var settings = $.extend({
            // These are the defaults.
			limit: 5,
			value: 0,
			glyph: "glyphicon-star",
            coloroff: "gray",
			coloron: "gold",
			size: "2.0em",
			cursor: "default",
			onClick: function () {},
            endofarray: "idontmatter"
        }, options );
		var style = "";
		style = style + "font-size:" + settings.size + "; ";
		style = style + "color:" + settings.coloroff + "; ";
		style = style + "cursor:" + settings.cursor + "; ";
	

		
		if (method == 'create')
		{
			//this.html('');	//junk whatever was there
			
			//initialize the data-rating property
			this.each(function(){
				attr = $(this).attr('data-rating');
				if (attr === undefined || attr === false) { $(this).attr('data-rating',settings.value); }
			})
			
			//bolt in the glyphs
			for (var i = 0; i < settings.limit; i++)
			{
				this.append('<span data-value="' + (i+1) + '" class="ratingicon glyphicon ' + settings.glyph + '" style="' + style + '" aria-hidden="true"></span>');
			}
			
			//paint
			this.each(function() { paint($(this)); });

		}
		if (method == 'set')
		{
			this.attr('data-rating',options);
			this.each(function() { paint($(this)); });
		}
		if (method == 'get')
		{
			return this.attr('data-rating');
		}
		//register the click events
		this.find("span.ratingicon").click(function() {
			rating = $(this).attr('data-value')
			$(this).parent().attr('data-rating',rating);
			paint($(this).parent());
			settings.onClick.call( $(this).parent() );
		})
		function paint(div)
		{
			rating = parseInt(div.attr('data-rating'));
			div.find("input").val(rating);	//if there is an input in the div lets set it's value
			div.find("span.ratingicon").each(function(){	//now paint the stars
				
				var rating = parseInt($(this).parent().attr('data-rating'));
				var value = parseInt($(this).attr('data-value'));
				if (value > rating) { $(this).css('color',settings.coloroff); }
				else { $(this).css('color',settings.coloron); }
			})
		}

    };
 
}( jQuery ));

$(document).ready(function(){

	//$("#stars-default").rating();
	//$("#stars-green").rating('create',{coloron:'green',onClick:function(){ alert('rating is ' + this.attr('data-rating')); }});
	//$("#stars-herats").rating('create',{coloron:'red',limit:10,glyph:'glyphicon-heart'});	
	$("#calidadtrabajo").rating();
        $("#limpiezaorden").rating();
        $("#plazos").rating();
        $("#cumplimiento").rating();
	$("#calificacion").rating();	
});
    
			jQuery(function($){
			    
				$('.rating').raty({
					'cancel' : true,
					'half': true,
					'starType' : 'i'
					/**,
					
					'click': function() {
						setRatingColors.call(this);
					},
					'mouseover': function() {
						setRatingColors.call(this);
					},
					'mouseout': function() {
						setRatingColors.call(this);
					}*/
				});//.find('i:not(.star-raty)').addClass('grey');
				
				
			
			});
		</script>


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



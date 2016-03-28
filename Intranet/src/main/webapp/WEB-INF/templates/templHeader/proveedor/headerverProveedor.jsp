<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<meta name="description" content="" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
<!-- bootstrap & fontawesome -->
<link rel="stylesheet" href="/Intranet/resources/assets/css/bootstrap.css" />
<link rel="stylesheet" href="/Intranet/resources/assets/css/font-awesome.css" />
<!-- page specific plugin styles -->
                <link rel="stylesheet" href="/Intranet/resources/assets/css/jquery-ui.css" />
<!-- text fonts -->
<link rel="stylesheet" href="/Intranet/resources/assets/css/ace-fonts.css" />

<!-- ace styles -->
<link rel="stylesheet" href="/Intranet/resources/assets/css/ace.css" class="ace-main-stylesheet" id="main-ace-style" />

<script src="/Intranet/resources/assets/js/ace-extra.js"></script>

<link rel="stylesheet" href="/Intranet/resources/assets/css/fullcalendar.css" />

<!-- page specific plugin styles -->
		<link rel="stylesheet" href="/Intranet/resources/assets/css/jquery-ui.custom.css" />
		<link rel="stylesheet" href="/Intranet/resources/assets/css/jquery.gritter.css" />
		<link rel="stylesheet" href="/Intranet/resources/assets/css/select2.css" />
		<link rel="stylesheet" href="/Intranet/resources/assets/css/datepicker.css" />
		<link rel="stylesheet" href="/Intranet/resources/assets/css/bootstrap-editable.css" />

		<!-- page specific plugin styles -->
		<link rel="stylesheet" href="/Intranet/resources/assets/css/jquery-ui.custom.css" />
		<link rel="stylesheet" href="/Intranet/resources/assets/css/chosen.css" />
		<link rel="stylesheet" href="/Intranet/resources/assets/css/datepicker.css" />
		<link rel="stylesheet" href="/Intranet/resources/assets/css/bootstrap-timepicker.css" />
		<link rel="stylesheet" href="/Intranet/resources/assets/css/daterangepicker.css" />
		<link rel="stylesheet" href="/Intranet/resources/assets/css/bootstrap-datetimepicker.css" />
		<link rel="stylesheet" href="/Intranet/resources/assets/css/colorpicker.css" />

<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?v3"></script>

 <script src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>
	  
<script type="text/javascript">
      var geocoder;
      var map;
      function initialize() {
        var latlng = new google.maps.LatLng(-34.397, 150.644);
        var mapOptions = {
          zoom: 9,
          center: latlng,
          mapTypeId: google.maps.MapTypeId.ROADMAP
        }

        map = new google.maps.Map(document.getElementById('map_canvas'), mapOptions);

        geocoder = new google.maps.Geocoder();
        geocoder.geocode( { 'address': document.getElementById("direccion").value}, function(results, status) {
          if (status == google.maps.GeocoderStatus.OK) {
            
            map.setCenter(results[0].geometry.location);
            var marker = new google.maps.Marker({
                map: map,
                position: results[0].geometry.location
            });
          } else {
            alert('Porvor Ingrese una direccion... ');
          }
        });
      }
 
    </script>
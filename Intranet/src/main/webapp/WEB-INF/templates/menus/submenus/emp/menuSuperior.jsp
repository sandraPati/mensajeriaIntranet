<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<script type="text/javascript">
    function crunchifyAjaxE() {
        $.ajax({
            url : '/Intranet/emp/Eajaxtest2.htm',
            success : function(data) {
                $('#result').html(data);
                $('#result2').html(data);
            }
        });
    }
    
    function crunchifyAjaxAgendaE() {
        $.ajax({
            url : '/Intranet/emp/EajaxtestA.htm',
            success : function(data) {
                $('#resultA').html(data);
            }
        });
    }
    function crunchifyAjaxCorreoNoLeidosE() {
        $.ajax({
            url : '/Intranet/emp/EajaxtestNoL.htm',
            success : function(data) {
                $('#resultNOL').html(data);
            }
        });
        
    }
    
    function EcrunchifyAjaxMensE() {
        
           var json1 =  null ; 
       $.ajax ({
           async :  false , 
            global :  false ,     
           url : '/Intranet/emp/EajaxMensajeria.json?nifU=${chatadd.nifReceptor}' ,
           dataType :  "json" , 
           success :  function  ( dataMen )  { 
            json1 = ""; 
            for(var i=0; i<dataMen.length; i++) 
            {
                json1=json1+"<div class='itemdiv dialogdiv'>"+
                                    "<div class='user'>"+
                                            "<img alt='' src='/Intranet/resources/fotosPerfil/"+dataMen[i]['nombrefotografia']+"' />"+
                                    "</div>"+
                                    "<div class='body'>"+
                                            "<div class='time'>"+
                                                    "<i class='ace-icon fa fa-clock-o'></i>"+
                                                    "<span class='green'>"+dataMen[i]['hora']+"</span>"+
                                            "</div>"+
                                            "<div class='name'>"+
                                                dataMen[i]['nombreEmisor']+
                                            "</div>"+
                                            "<div class='text'>"+dataMen[i]['asunto']+"</div>"+
                                            "<div class='tools'>"+
                                                    "<a href='#' class='btn btn-minier btn-info'>"+
                                                            "<i class='icon-only ace-icon fa fa-share'></i>"+
                                                    "</a>"+
                                            "</div>"+
                                    "</div>"+
                           " </div>";
  
            }
          
            $('#resultME').html(json1);
        } 
       });
    }
</script>
<script type="text/javascript">

</script>
<div id="navbar" class="navbar navbar-default navbar-fixed-top" STYLE="background-color:#FFFFFF">
	<div class="navbar-container" id="navbar-container">
        <!-- #section:basics/sidebar.mobile.toggle -->
        <button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler" data-target="#sidebar">
                <span class="sr-only">Toggle sidebar</span>

                <span class="icon-bar"></span>

                <span class="icon-bar"></span>

                <span class="icon-bar"></span>
        </button>

        <!-- /section:basics/sidebar.mobile.toggle -->
        <div class="navbar-header pull-left">
                <!-- #section:basics/navbar.layout.brand -->
                <div class="center">
                 <image src="/Intranet/resources/assets/img/logonomina.png" width="200" height="46"/>    							
                </div>
                <!--<a href="#" class="navbar-brand">
                        <small>
                                <i class="fa fa-leaf"></i>

                                Ace Admin
                        </small>
                </a>-->

                <!-- /section:basics/navbar.layout.brand -->

                <!-- #section:basics/navbar.toggle -->

                <!-- /section:basics/navbar.toggle -->
        </div>

        <!-- #section:basics/navbar.dropdown -->
        <div class="navbar-buttons navbar-header pull-right" role="navigation">
             <ul class="nav ace-nav">
        <li class="grey">
                <a href="/Intranet/emp/EverAgenda.htm">
                        <i class="ace-icon fa fa-tasks"></i>
                        <span class="badge badge-grey"></span>
                </a>
           
           
                
        </li>

        <li class="purple">
                <a href="/Intranet/emp/ESMS.htm">
                        <i class="ace-icon fa fa-bell icon-animated-bell"></i>
                        <span class="badge badge-important"></span>
                </a>

                
        </li>

        <li class="green">
            <a href="javascript:window.open('http://decorakia.ddns.net:85/Mail/')" >
                        <i class="ace-icon fa fa-envelope icon-animated-vertical"></i>
                        <span class="badge badge-success"><div id="result"></div></span>
                </a>
           

        </li>

        <!-- #section:basics/navbar.user_menu -->
        <li class="light-blue">
                <a data-toggle="dropdown" href="#" class="dropdown-toggle">
                    
                        <span id="resultFoto"></span>
                        <span class="user-info">
                                <small>Welcome,</small>
                                <c:if test="${pageContext.request.userPrincipal.name != null}">
                                        ${pageContext.request.userPrincipal.name}
                                </c:if>
                        </span>

                        <i class="ace-icon fa fa-caret-down"></i>
                </a>

                <ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
                        <li>
                                <a href="#">
                                        <i class="ace-icon fa fa-cog"></i>
                                        Settings
                                </a>
                        </li>

                        <li>
                                <a href="profile.html">
                                        <i class="ace-icon fa fa-user"></i>
                                        Profile
                                </a>
                        </li>

                        <li class="divider"></li>

                        <li>
                                <a href="/Intranet/logout.htm">
                                        <i class="ace-icon fa fa-power-off"></i>
                                        Logout
                                </a>
                        </li>
                </ul>
        </li>

        <!-- /section:basics/navbar.user_menu -->
</ul>
        </div>

        <!-- /section:basics/navbar.dropdown -->
</div><!-- /.navbar-container -->
</div>
                                    
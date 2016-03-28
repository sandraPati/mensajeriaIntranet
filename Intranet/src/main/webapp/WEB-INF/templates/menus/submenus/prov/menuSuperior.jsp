<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<script type="text/javascript">
   
    function crunchifyAjax() {
        $.ajax({
            url : '/Intranet/sup/ajaxtest2.htm',
            success : function(data) {
                $('#result').html(data);
                $('#result2').html(data);
            }
        });
    }
    
    function crunchifyAjaxAgenda() {
        $.ajax({
            url : '/Intranet/sup/ajaxtestA.htm',
            success : function(data) {
                $('#resultA').html(data);
            }
        });
    }
    function crunchifyAjaxCorreoNoLeidos() {
        $.ajax({
            url : '/Intranet/sup/ajaxtestNoL.htm',
            success : function(data) {
                $('#resultNOL').html(data);
            }
        });
        
    }
  
    
    function crunchifyAjaxMens() {
        
           var json1 =  null ; 
       $.ajax ({
           async :  false , 
            global :  false ,     
           url : '/Intranet/sup/ajaxMensajeria.json?nifU=${chatadd.nifReceptor}' ,
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
          
            $('#resultM').html(json1);
        } 
       });
    }
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
                <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                        <i class="ace-icon fa fa-tasks"></i>
                        <span class="badge badge-grey">4</span>
                </a>

                <ul class="dropdown-menu-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close">
                        <li class="dropdown-header">
                                <i class="ace-icon fa fa-check"></i>
                                4 Tasks to complete
                        </li>

                        <li class="dropdown-content">
                                <ul class="dropdown-menu dropdown-navbar">
                                        <li>
                                                <a href="#">
                                                        <div class="clearfix">
                                                                <span class="pull-left">Software Update</span>
                                                                <span class="pull-right">65%</span>
                                                        </div>

                                                        <div class="progress progress-mini">
                                                                <div style="width:65%" class="progress-bar"></div>
                                                        </div>
                                                </a>
                                        </li>

                                        <li>
                                                <a href="#">
                                                        <div class="clearfix">
                                                                <span class="pull-left">Hardware Upgrade</span>
                                                                <span class="pull-right">35%</span>
                                                        </div>

                                                        <div class="progress progress-mini">
                                                                <div style="width:35%" class="progress-bar progress-bar-danger"></div>
                                                        </div>
                                                </a>
                                        </li>

                                        <li>
                                                <a href="#">
                                                        <div class="clearfix">
                                                                <span class="pull-left">Unit Testing</span>
                                                                <span class="pull-right">15%</span>
                                                        </div>

                                                        <div class="progress progress-mini">
                                                                <div style="width:15%" class="progress-bar progress-bar-warning"></div>
                                                        </div>
                                                </a>
                                        </li>

                                        <li>
                                                <a href="#">
                                                        <div class="clearfix">
                                                                <span class="pull-left">Bug Fixes</span>
                                                                <span class="pull-right">90%</span>
                                                        </div>

                                                        <div class="progress progress-mini progress-striped active">
                                                                <div style="width:90%" class="progress-bar progress-bar-success"></div>
                                                        </div>
                                                </a>
                                        </li>
                                </ul>
                        </li>

                        <li class="dropdown-footer">
                                <a href="#">
                                        See tasks with details
                                        <i class="ace-icon fa fa-arrow-right"></i>
                                </a>
                        </li>
                </ul>
        </li>

        <li class="purple">
                <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                        <i class="ace-icon fa fa-bell icon-animated-bell"></i>
                        <span class="badge badge-important">8</span>
                </a>

                <ul class="dropdown-menu-right dropdown-navbar navbar-pink dropdown-menu dropdown-caret dropdown-close">
                        <li class="dropdown-header">
                                <i class="ace-icon fa fa-exclamation-triangle"></i>
                                8 Notifications
                        </li>

                        <li class="dropdown-content">
                                <ul class="dropdown-menu dropdown-navbar navbar-pink">
                                        <li>
                                                <a href="#">
                                                        <div class="clearfix">
                                                                <span class="pull-left">
                                                                        <i class="btn btn-xs no-hover btn-pink fa fa-comment"></i>
                                                                        New Comments
                                                                </span>
                                                                <span class="pull-right badge badge-info">+12</span>
                                                        </div>
                                                </a>
                                        </li>

                                        <li>
                                                <a href="#">
                                                        <i class="btn btn-xs btn-primary fa fa-user"></i>
                                                        Bob just signed up as an editor ...
                                                </a>
                                        </li>

                                        <li>
                                                <a href="#">
                                                        <div class="clearfix">
                                                                <span class="pull-left">
                                                                        <i class="btn btn-xs no-hover btn-success fa fa-shopping-cart"></i>
                                                                        New Orders
                                                                </span>
                                                                <span class="pull-right badge badge-success">+8</span>
                                                        </div>
                                                </a>
                                        </li>

                                        <li>
                                                <a href="#">
                                                        <div class="clearfix">
                                                                <span class="pull-left">
                                                                        <i class="btn btn-xs no-hover btn-info fa fa-twitter"></i>
                                                                        Followers
                                                                </span>
                                                                <span class="pull-right badge badge-info">+11</span>
                                                        </div>
                                                </a>
                                        </li>
                                </ul>
                        </li>

                        <li class="dropdown-footer">
                                <a href="#">
                                        See all notifications
                                        <i class="ace-icon fa fa-arrow-right"></i>
                                </a>
                        </li>
                </ul>
        </li>

        <li class="green">
                <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                        <i class="ace-icon fa fa-envelope icon-animated-vertical"></i>
                        <span class="badge badge-success"><div id="result"></div></span>
                </a>

                <ul class="dropdown-menu-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close">
                        <li class="dropdown-header">
                            <i class="ace-icon fa fa-envelope-o"></i><span id="result2"></span>
                                Messages
                        </li>

                        <li class="dropdown-content">
                                <ul class="dropdown-menu dropdown-navbar" id="resultNOL">
                                    
                                    
                                </ul>
                        </li>

                        <li class="dropdown-footer">
                                <a href="/Intranet/sup/Inbox.htm">
                                        See all messages
                                        <i class="ace-icon fa fa-arrow-right"></i>
                                </a>
                        </li>
                </ul>
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
                                    
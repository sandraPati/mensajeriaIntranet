<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- /section:settings.box -->

<div class="page-content">

<div class="row">
<div class="col-xs-12">
<!-- PAGE CONTENT BEGINS -->

<div class="row">
        <div class="col-xs-12">
                <!-- #section:pages/inbox -->
                <div class="tabbable">
                        <ul id="inbox-tabs" class="inbox-tabs nav nav-tabs padding-16 tab-size-bigger tab-space-1">
                                <!-- #section:pages/inbox.compose-btn -->
                                <li class="li-new-mail pull-right">
                                        <a data-toggle="tab" href="#write" data-target="write" class="btn-new-mail">
                                                <span class="btn btn-purple no-border">
                                                        <i class="ace-icon fa fa-envelope bigger-130"></i>
                                                        <span class="bigger-110">Write Mail</span>
                                                </span>
                                        </a>
                                </li><!-- /.li-new-mail -->

                                <!-- /section:pages/inbox.compose-btn -->
                                <li class="active">
                                        <a data-toggle="tab" href="#inbox" data-target="inbox">
                                                <i class="blue ace-icon fa fa-inbox bigger-130"></i>
                                                <span class="bigger-110">Principal</span>
                                        </a>
                                </li>

                                <li>
                                        <a data-toggle="tab" href="#sent" data-target="sent">
                                                <i class="orange ace-icon fa fa-location-arrow bigger-130"></i>
                                                <span class="bigger-110">Sent</span>
                                        </a>
                                </li>

                                <li>
                                        <a data-toggle="tab" href="#draft" data-target="draft">
                                                <i class="green ace-icon fa fa-pencil bigger-130"></i>
                                                <span class="bigger-110">Draft</span>
                                        </a>
                                </li>

                                <li class="dropdown">
                                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                                <i class="pink ace-icon fa fa-tags bigger-130"></i>

                                                <span class="bigger-110">
                                                        Tags
                                                        <i class="ace-icon fa fa-caret-down"></i>
                                                </span>
                                        </a>

                                        <ul class="dropdown-menu dropdown-light-blue dropdown-125">
                                                <li>
                                                        <a data-toggle="tab" href="#tag-1">
                                                                <span class="mail-tag badge badge-pink"></span>
                                                                <span class="pink">Tag#1</span>
                                                        </a>
                                                </li>

                                                <li>
                                                        <a data-toggle="tab" href="#tag-family">
                                                                <span class="mail-tag badge badge-success"></span>
                                                                <span class="green">Family</span>
                                                        </a>
                                                </li>

                                                <li>
                                                        <a data-toggle="tab" href="#tag-friends">
                                                                <span class="mail-tag badge badge-info"></span>
                                                                <span class="blue">Friends</span>
                                                        </a>
                                                </li>

                                                <li>
                                                        <a data-toggle="tab" href="#tag-work">
                                                                <span class="mail-tag badge badge-grey"></span>
                                                                <span class="grey">Work</span>
                                                        </a>
                                                </li>
                                        </ul>
                                </li><!-- /.dropdown -->
                        </ul>

                        <div class="tab-content no-border no-padding">
                                <div id="inbox" class="tab-pane in active">
                                        <div class="message-container">
                                                <!-- #section:pages/inbox.navbar -->
                                                

                                                <div id="id-message-item-navbar" class=" message-navbar clearfix">
                                                        <div class="message-bar">
                                                                <div class="message-toolbar">
                                                                        <div class="inline position-relative align-left">
                                                                                <button type="button" class="btn-white btn-primary btn btn-xs dropdown-toggle" data-toggle="dropdown">
                                                                                        <span class="bigger-110">Action</span>

                                                                                        <i class="ace-icon fa fa-caret-down icon-on-right"></i>
                                                                                </button>

                                                                                <ul class="dropdown-menu dropdown-lighter dropdown-caret dropdown-125">
                                                                                        <li>
                                                                                                <a href="#">
                                                                                                        <i class="ace-icon fa fa-mail-reply blue"></i>&nbsp; Reply
                                                                                                </a>
                                                                                        </li>

                                                                                        <li>
                                                                                                <a href="#">
                                                                                                        <i class="ace-icon fa fa-mail-forward green"></i>&nbsp; Forward
                                                                                                </a>
                                                                                        </li>

                                                                                        <li>
                                                                                                <a href="#">
                                                                                                        <i class="ace-icon fa fa-folder-open orange"></i>&nbsp; Archive
                                                                                                </a>
                                                                                        </li>

                                                                                        <li class="divider"></li>

                                                                                        <li>
                                                                                                <a href="#">
                                                                                                        <i class="ace-icon fa fa-eye blue"></i>&nbsp; Mark as read
                                                                                                </a>
                                                                                        </li>

                                                                                        <li>
                                                                                                <a href="#">
                                                                                                        <i class="ace-icon fa fa-eye-slash green"></i>&nbsp; Mark unread
                                                                                                </a>
                                                                                        </li>

                                                                                        <li>
                                                                                                <a href="#">
                                                                                                        <i class="ace-icon fa fa-flag-o red"></i>&nbsp; Flag
                                                                                                </a>
                                                                                        </li>

                                                                                        <li class="divider"></li>

                                                                                        <li>
                                                                                                <a href="#">
                                                                                                        <i class="ace-icon fa fa-trash-o red bigger-110"></i>&nbsp; Delete
                                                                                                </a>
                                                                                        </li>
                                                                                </ul>
                                                                        </div>

                                                                        <div class="inline position-relative align-left">
                                                                                <button type="button" class="btn-white btn-primary btn btn-xs dropdown-toggle" data-toggle="dropdown">
                                                                                        <i class="ace-icon fa fa-folder-o bigger-110 blue"></i>
                                                                                        <span class="bigger-110">Move to</span>

                                                                                        <i class="ace-icon fa fa-caret-down icon-on-right"></i>
                                                                                </button>

                                                                                <ul class="dropdown-menu dropdown-lighter dropdown-caret dropdown-125">
                                                                                        <li>
                                                                                                <a href="#">
                                                                                                        <i class="ace-icon fa fa-stop pink2"></i>&nbsp; Tag#1
                                                                                                </a>
                                                                                        </li>

                                                                                        <li>
                                                                                                <a href="#">
                                                                                                        <i class="ace-icon fa fa-stop blue"></i>&nbsp; Family
                                                                                                </a>
                                                                                        </li>

                                                                                        <li>
                                                                                                <a href="#">
                                                                                                        <i class="ace-icon fa fa-stop green"></i>&nbsp; Friends
                                                                                                </a>
                                                                                        </li>

                                                                                        <li>
                                                                                                <a href="#">
                                                                                                        <i class="ace-icon fa fa-stop grey"></i>&nbsp; Work
                                                                                                </a>
                                                                                        </li>
                                                                                </ul>
                                                                        </div>

                                                                        <button type="button" class="btn btn-xs btn-white btn-primary">
                                                                                <i class="ace-icon fa fa-trash-o bigger-125 orange"></i>
                                                                                <span class="bigger-110">Delete</span>
                                                                        </button>
                                                                </div>
                                                        </div>

                                                        <div>
                                                                <div class="messagebar-item-left">
                                                                        <a href="/Intranet/sup/Inbox.htm" class="btn-back-message-list">
                                                                                <i class="ace-icon fa fa-arrow-left blue bigger-110 middle"></i>
                                                                                <b class="bigger-110 middle">Back</b>
                                                                        </a>
                                                                </div>

                                                                <div class="messagebar-item-right">
                                                                        <i class="ace-icon fa fa-clock-o bigger-110 orange"></i>
                                                                        <span class="grey">Today, 7:15 pm</span>
                                                                </div>
                                                        </div>
                                                </div>

                                                

                                                <!-- /section:pages/inbox.navbar -->
                                                <div class=" message-content" id="id-message-content">
									<!-- #section:pages/inbox.message-header -->
									<div class="message-header clearfix">
										<div class="pull-left">
											
											<div class="space-4"></div>

											&nbsp;
											
											<a href="#" class="sender">${correo.de}</a>

											&nbsp;
											<i class="ace-icon fa fa-clock-o bigger-110 orange middle"></i>
											<span class="time grey">${correo.fecha}</span>
										</div>

										<div class="pull-right action-buttons">
											<a href="#">
												<i class="ace-icon fa fa-reply green icon-only bigger-130"></i>
											</a>

											<a href="#">
												<i class="ace-icon fa fa-mail-forward blue icon-only bigger-130"></i>
											</a>

											<a href="#">
												<i class="ace-icon fa fa-trash-o red icon-only bigger-130"></i>
											</a>
										</div>
									</div>

									<!-- /section:pages/inbox.message-header -->
									<div class="hr hr-double"></div>

									<!-- #section:pages/inbox.message-body -->
									<div class="message-body" class="ace-scroll">
										${correo.contenido}
									</div>

									<!-- /section:pages/inbox.message-body -->
									<div class="hr hr-double"></div>

									<!-- #section:pages/inbox.message-attachment -->
									<div class="message-attachment clearfix">
										<div class="attachment-title">
											<span class="blue bolder bigger-110">Attachments</span>
											&nbsp;

								
										</div>

										&nbsp;
										<ul class="attachment-list pull-left list-unstyled">
                                                                                     <c:forEach items="${correo.rar}" var="imagrar">
                                                                                           
											<li>
												
													<i class="ace-icon fa fa-file-o bigger-110"></i>
													<span class="attached-name">${imagrar}</span>
												

												<span class="action-buttons">
													
                                                                                                        <a href="/Intranet/resources/archivosMail/verCorreo/${imagrar}" id="btn_enviar">
														<i class="ace-icon fa fa-download bigger-125 blue"></i>
													</a>        
												</span>
											</li>
                                                                                     </c:forEach>    
											
										</ul>

										<div class="attachment-images pull-right">
											<div class="vspace-4-sm"></div>

											<div>
                                                                                            <c:forEach items="${correo.imagenes}" var="imag">
                                                                                                <img width="100" alt="${imag}" src="${imag}" />
                                                                                            </c:forEach>
												
											</div>
										</div>
									</div>

									<!-- /section:pages/inbox.message-attachment -->
								</div><!-- /.message-content -->


                                                <div class=" message-footer message-footer-style2 clearfix">
                                                        <div class="pull-left"> simpler footer </div>

                                                        <div class="pull-right">
                                                                <div class="inline middle"> message 1 of 151 </div>

                                                                &nbsp; &nbsp;
                                                                <ul class="pagination middle">
                                                                        <li class="disabled">
                                                                                <span>
                                                                                        <i class="ace-icon fa fa-angle-left bigger-150"></i>
                                                                                </span>
                                                                        </li>

                                                                        <li>
                                                                                <a href="#">
                                                                                        <i class="ace-icon fa fa-angle-right bigger-150"></i>
                                                                                </a>
                                                                        </li>
                                                                </ul>
                                                        </div>
                                                </div>

                                                <!-- /section:pages/inbox.message-footer -->
                                        </div>
                                </div>
                        </div><!-- /.tab-content -->
                </div><!-- /.tabbable -->

                <!-- /section:pages/inbox -->
        </div><!-- /.col -->
</div><!-- /.row -->

								

								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
                                                
</div>

<script type="text/javascript">
    
    $(function(){

 $("#btn_enviar").click(function(){ 
     var ruta=$("#btn_enviar").attr("href");
    window.location.replace(ruta);
 });
    })		
</script>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!-- /section:settings.box -->

<div class="page-content">

<div class="row">
<div class="col-xs-12">
<!-- PAGE CONTENT BEGINS -->
<form:form id="form1" action="" method="POST" commandName="correo"class="form-horizontal message-form col-xs-12" role="form">
<div class="row">
        <div class="col-xs-12">
                <!-- #section:pages/inbox -->
                <div class="tabbable">
                        <ul id="inbox-tabs" class="inbox-tabs nav nav-tabs padding-16 tab-size-bigger tab-space-1">
                                <!-- #section:pages/inbox.compose-btn -->
                                

                                <!-- /section:pages/inbox.compose-btn -->
                                <li >
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
                                                


                                                <div id="id-message-new-navbar" class=" message-navbar clearfix">
                                                        <div class="message-bar">
                                                                
                                                        </div>

                                                        <div>
                                                                <div class="messagebar-item-left">
                                                                        <a href="/Intranet/emp/EInbox.htm" class="btn-back-message-list">
                                                                                <i class="ace-icon fa fa-arrow-left bigger-110 middle blue"></i>
                                                                                <b class="middle bigger-110">Back</b>
                                                                        </a>
                                                                </div>

                                                                <div class="messagebar-item-right">
                                                                        <span class="inline btn-send-message">
                                                                                <button type="submit" class="btn btn-sm btn-primary no-border btn-white btn-round">
                                                                                        <span class="bigger-110">Send</span>

                                                                                        <i class="ace-icon fa fa-arrow-right icon-on-right"></i>
                                                                                </button>
                                                                        </span>
                                                                </div>
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


									<!-- #section:pages/inbox.compose -->
									<div>
                                                                            <br/>
										

										<div class="hr hr-18 dotted"></div>

                                                                                <div class="form-group">
											<label class="col-sm-3 control-label no-padding-right" for="form-field-recipient">Para:</label>

											<div class="col-sm-9">
												<span class="input-icon">
                                                                                                    <form:input type="email" id="de" path="de" class="col-xs-10 col-sm-3 col-lg-12" placeholder="j@decorakia.com" required="true"/> 
													<i class="ace-icon fa fa-user"></i>
												</span>
											</div>
										</div>

										<div class="hr hr-18 dotted"></div>

										<div class="form-group">
											<label class="col-sm-3 control-label no-padding-right" for="form-field-subject">Asunto:</label>

											<div class="col-sm-6 col-xs-12">
												<div class="input-icon block col-xs-12 no-padding">
												<form:input type="text" id="asunto" path="asunto" class="col-xs-10 col-sm-3 col-lg-12"/> 	
													<i class="ace-icon fa fa-comment-o"></i>
												</div>
											</div>
										</div>

										<div class="hr hr-18 dotted"></div>

										<div class="form-group">
											<label class="col-sm-3 control-label no-padding-right">
												<span class="inline space-24 hidden-480"></span>
												
											</label>

											<!-- #section:plugins/editor.wysiwyg -->
											<div class="col-sm-9">
											<form:textarea type="text" id="contenido" path="contenido" class="col-xs-10 col-sm-12 " rows="5" required="true"/>	
                                                                                           
											</div>

											<!-- /section:plugins/editor.wysiwyg -->
										</div>                        
										
										<div class="space"></div>
									</div>

									<!-- /section:pages/inbox.compose -->
								 </form:form>


								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
                                                
</div>


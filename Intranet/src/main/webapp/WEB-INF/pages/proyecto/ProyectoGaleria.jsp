
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
                    
<div class="page-content">               
<!-- #section:settings.box -->
<div class="page-header">
    <div class="row">
        <div class="col-lg-8">
        <h1>
               Galeria
                <small>
                    <i class="ace-icon fa fa-angle-double-right"></i>
                   
                </small>
        </h1>
        </div>
         <div class="col-lg-4 align-right">
            
            <a class=" btn btn-white btn-warning" href="/Intranet/sup/verPropuestasP.htm?nifC=${nifC}" data-rel="tooltip">
                <i class="ace-icon fa fa-reply icon-only"></i>

            </a>
        </div>
             
             
    </div>
        
</div><!-- /.page-header -->
<div class="row">
<div class="col-xs-12">
        <!-- PAGE CONTENT BEGINS -->

        <div>
                <div id="user-profile-1" class="user-profile row">
                      

                        <div class="col-xs-12 col-sm-9">
            <form:form id="form1" class="form-horizontal" enctype="multipart/form-data" action="" method="POST" commandName="fotogaleria">                
                    <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1">  </label>

                            <div class="col-sm-4">
                            <div class="widget-box">
                                    <div class="widget-header">
                                            <h4 class="widget-title">Subir Fotografia</h4>

                                            <div class="widget-toolbar">
                                                    <a href="#" data-action="collapse">
                                                            <i class="ace-icon fa fa-chevron-up"></i>
                                                    </a>

                                                   
                                            </div>
                                    </div>

                                    <div class="widget-body">
                                            <div class="widget-main">
                                                    <div class="form-group">
                                                            <div class="col-xs-12">
                                                               <form:input id="fotografia" type="file" class="col-xs-10 col-sm-5" placeholder="Foto" path="nombreimg" />
                                                                    <!-- /section:custom/file-input -->
                                                            </div>
                                                    </div>
                                            </div>
                                    </div>
                            </div>
                            </div>
                    </div>
                                                                   
                   

                   <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> </label>
                            <div class="col-sm-9">
                                <button type="submit" class="btn btn-primary col-xs-12 col-sm-4 col-md-3 col-lg-3">Subir Foto</button>
                            </div>
                   </div>
                        
                                </form:form>


                        </div>
                </div>
        </div>



        <!-- PAGE CONTENT ENDS -->
</div><!-- /.col -->
</div><!-- /.row -->
<div class="row">
<div class="col-xs-12">
        <!-- PAGE CONTENT BEGINS -->
        <div>
                <ul class="ace-thumbnails clearfix">
                        <!-- #section:pages/gallery -->
                        <c:forEach items="${ltaFotos}" var="item">
                       <li>
											<div>
												<img width="150" height="150" alt="150x150" src="/Intranet/resources/fotosCertificaciones/${item.nombreimg}" />
												<div class="text">
													<div class="inner">
														<span>Some Title!</span>

														<br />
														<a href="/Intranet/resources/fotosCertificaciones/${item.nombreimg}" data-rel="colorbox">
															<i class="ace-icon fa fa-search-plus"></i>
														</a>

														<a href="/Intranet/sup/ProyectoGaleriaDelete.htm?id=${item.id}">
															<i class="ace-icon fa fa-times red"></i>
														</a>

													</div>
												</div>
											</div>
										</li>
                        
                        </c:forEach>
                </ul>
        </div><!-- PAGE CONTENT ENDS -->
</div><!-- /.col -->
</div><!-- /.row -->

</div><!-- /.row -->
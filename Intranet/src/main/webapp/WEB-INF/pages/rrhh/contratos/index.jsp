<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="net.sf.jasperreports.engine.JasperExportManager"%>
<%@page import="net.sf.jasperreports.engine.JasperPrint"%>
<%@page import="net.sf.jasperreports.engine.JasperFillManager"%>
<%@page import="net.sf.jasperreports.engine.JasperReport"%>
<%@page import="net.sf.jasperreports.engine.JasperCompileManager"%>
<%@page import="java.io.File"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.intranet.intr.conexion"%>
<%@page import="java.util.Map"%>
<%
try{
    Map<String,Object> params = (Map<String,Object>)request.getAttribute("params");
    //Map<String, Object> params = new HashMap();
    conexion con=new conexion();
    Connection conn=con.getConnection();
    //List<Map<String,?>> dataSource=(List<Map<String,?>>)request.getAttribute("nif");
    //JRDataSource
            String jrxmlfile="C:\\reports\\reporte.jasper";
            InputStream input=new FileInputStream(new File(jrxmlfile));
            JasperReport jasperReport=JasperCompileManager.compileReport(input);
            //JasperPrint jasperPrint=JasperFillManager.fillReport(input, params);
            
            
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params,conn);

            JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
            response.getOutputStream().flush();
            response.getOutputStream().close();
}catch(Exception e){
}
%>
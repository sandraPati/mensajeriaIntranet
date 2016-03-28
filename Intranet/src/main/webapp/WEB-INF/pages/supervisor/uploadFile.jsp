<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%
    String ubicacionArchivo="C://RespaldoIntranetDecorakia";
    DiskFileItemFactory factory=new DiskFileItemFactory();
    factory.setSizeThreshold(1024);
    
    ServletFileUpload upload=new ServletFileUpload(factory);
    
    try{
        List<FileItem> partes=upload.parseRequest(request);
        for(FileItem item : partes)
        {
            File file=new File(ubicacionArchivo,item.getName());
            item.write(file);
        }
        out.write("Archi subido correctamente");
    }
    catch(Exception ex)
    {
        out.write("Error al subir archivo"+ex.getMessage());
    }
%>
<%-- 
    Document   : usuarioTest
    Created on : Oct 16, 2014, 10:56:14 AM
    Author     : eslem
--%>

<%@page import="com.fpmislata.banco.dominio.Usuario"%>
<%@page import="com.fpmislata.banco.persistencia.UsuarioDAO"%>
<%@page import="com.fpmislata.banco.persistencia.impl.UsuarioDAOImplHibernate"%>
<%
    UsuarioDAO usuarioDAO = (UsuarioDAO) new UsuarioDAOImplHibernate();
   //suario usuario = new Usuario("usuario", "apellido", "0000", "calle tal", 01234567, "email", "0123");
    //usuarioDAO.insert(usuario);
   usuarioDAO.delete(10);
    /*Usuario usuario = usuarioDAO.get(10);
   out.print(usuario.getContraseña());*/
%>

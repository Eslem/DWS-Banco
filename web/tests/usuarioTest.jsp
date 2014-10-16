<%-- 
    Document   : usuarioTest
    Created on : Oct 16, 2014, 10:56:14 AM
    Author     : eslem
--%>

<%@page import="com.fpmislata.banco.dominio.Usuario"%>
<%@page import="com.fpmislata.banco.persistencia.UsuarioDAO"%>
<%@page import="com.fpmislata.banco.persistencia.impl.UsuarioDAOImplHibernate"%>
<%
    UsuarioDAO usuarioDAO = new UsuarioDAOImplHibernate();
    //Usuario usuario = new Usuario("usuario", "apellido", "0123d", "calle tal", 01234567, "email", "0123");
    usuarioDAO.delete(1);
    //out.print(usuario.toString());
%>

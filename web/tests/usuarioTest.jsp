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
   Usuario usuario = new Usuario("usuario", "apellido", "0000", "calle tal", 9784521, "email", "0123");
   Usuario usuario2 = new Usuario("usuario2", "apellido2", "1111", "calle qwdqwd", 6984894, "email2", "0123");
    usuarioDAO.insert(usuario);
    usuarioDAO.insert(usuario2);
   //usuarioDAO.delete(10);
    /*Usuario usuario = usuarioDAO.get(10);
   out.print(usuario.getContraseña());*/
%>

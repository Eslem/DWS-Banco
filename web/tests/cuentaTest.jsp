<%-- 
    Document   : cuentaTest
    Created on : Oct 17, 2014, 10:03:59 AM
    Author     : eslem
--%>

<%@page import="com.fpmislata.banco.dominio.Cuenta"%>
<%@page import="com.fpmislata.banco.persistencia.impl.CuentaDAOImplJDBC"%>
<%@page import="com.fpmislata.banco.persistencia.CuentaDAO"%>
<%
    CuentaDAO cuentaDAO = new CuentaDAOImplJDBC();
    Cuenta cuenta =cuentaDAO.get(1);
    out.print(cuenta.toString());
    
    
    
    
    %>
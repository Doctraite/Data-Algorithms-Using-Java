<%@page import="crud.UserDAO"%>
<jsp:useBean id="u" class="crud.UserBean"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%
UserDAO.delete(u);
response.sendRedirect("viewUsers.jsp");
%>

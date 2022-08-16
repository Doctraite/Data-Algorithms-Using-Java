
<%@page import="crud.UserDAO"%>
<jsp:useBean id="u" class="crud.UserBean"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>
<%
int i=UserDAO.save(u);
if(i>0){
response.sendRedirect("AddUserSuccess.jsp");
}else{
response.sendRedirect("errorPage.jsp");
}
%>

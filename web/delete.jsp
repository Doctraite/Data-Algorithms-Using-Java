<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
     <title>Mbabane Municipality Transport System</title>
     <link rel="stylesheet" type="text/css" href="bst_menu_items.css"/>
</head>
<body>
    <div id="login-form">
        <div id="student">
        <h2>Welcome to our bst user section</h2>
        </div>
   <form action="binary_session.jsp" method="GET">
                <br>
                <label>Remove User</label>
                <br>
                <input type="text" name="delete" class="input-group-addon" placeholder="Remove user details"/><br/>
                <input type="submit" name="deleteUsers" id="delete" class="input-group-addon" value="Delete User">
                <br>
</form>
    </div>
</body>
</html>

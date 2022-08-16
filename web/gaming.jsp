<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Our Gaming Section</title>
        <link rel="stylesheet" href="stylesheet.css">
        <script src="https://kit.fontawesome.com/b69cc7714b.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <nav>
            <input type="checkbox" id="check">
            <label for="check" class="checkbtn">
                <i class="fas fa-bars"></i>
            </label>
            <label class="logo">Mbabane Municipality</label>
            <ul>
                <li><a href="home.jsp" class="active">Home</a></li>
                <li><a href="crud_index.jsp">System Users</a></li>
                <li><a href="gaming.jsp">Gaming Section</a></li>
                <li><a href="matsapha_chat.jsp">Chatting Platform</a></li>
            </ul>
        </nav>
    <section>
    <center>
        <br>
        <br>
        <center>
            
        <h1 align="center">Secret Phrase Game</h1>
        </center>
        <jsp:plugin type="applet" code="JSecretPhrase" codebase="Game" height="600" width="600">
            <jsp:fallback>
                Plugin tag might not be supported by the Browser
            </jsp:fallback>
        </jsp:plugin>
        <h4>
            <font color="blue">
            Play our game - guess the phrase   Enter one letter
            </font>
        </h4>
    </center>
    </section>
</body>
</html>

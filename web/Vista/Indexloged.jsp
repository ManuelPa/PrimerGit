
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="Css/Css.css" rel="stylesheet" type="text/css">
        <title>Login</title>
    </head>
    <body>
        <header class="headerindex">
            <h1 class="h1index">Elecciones generales 2016-2017.</h1>
        </header>
        <section class="sectionindex">
            <form action="ControladorLogged"> 
                <table>
                    <tr><td><input type="submit" name="sub" value="Votar" class="botonindex" /></td></tr>
                    <tr><td><input type="submit" name="sub" value="Censo electoral" class="botonindex" /></td></tr>
                    <tr><td><input type="submit" name="sub" value="Dar Baja" class="botonindex" /></td></tr>
                </table>
            </form>
        </section>
        <footer>
            <br>
            <a href="../index.jsp"><input type="button" value="Index" /></a>
        </footer>
    </body>
</html>


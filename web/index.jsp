
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
            <form action="ControladorIndex"> 
                <table>
                    <tr>
                        <td><input type="text" name="nif" placeholder="Nif" required="required" /></td>
                    </tr>
                    <tr>
                        <td><input type="password" name="clave" placeholder="Clave" required="required" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" name="submit" value="Registar Usuario" class="botonvoto" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" name="submit" value="Iniciar Sesion" class="botonvoto" /></td>
                    </tr>
                </table>
            </form>
        </section>
        <footer>
            Diciembre 2016.
        </footer>
    </body>
</html>

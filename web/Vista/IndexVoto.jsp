
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="Css/Css.css" rel="stylesheet" type="text/css">
        <title>Votos</title>
    </head>
    <body>
        <header class="headerindex">
            <h1 class="h1index">Estos son los partidos politicos a votar.</h1>
        </header>
        <section class="sectionindex">
            <form action="ControladorVoto"> 
                <table>
                    <tr><td><input type="radio" name="radio" value="pp">PartidoPopular<br></td></tr>
                    <tr><td><input type="radio" name="radio" value="psoe">PartidoSocialista Obrero Español<br></td></tr>
                    <tr><td><input type="radio" name="radio" value="podemos">Podemos<br></td></tr>
                    <tr><td><input type="radio" name="radio" value="cs">Ciudadanos - Partido de la ciudadania<br></td></tr>
                    <tr><td><input type="radio" name="radio" value="erc">Esquerra Republicana de Catalunya<br></td></tr>
                    <tr><td><input type="radio" name="radio" value="pnv">Partido Nacionalista Vasco<br></td></tr>
   
                    <tr><td><input type="submit" name="subv" value="Votar" class="botonindex" /></td></tr>
                </table>
            </form>
        </section>
        <footer>
            <br>
            <a href="../index.jsp"><input type="button" value="Index" /></a>
        </footer>
    </body>
</html>
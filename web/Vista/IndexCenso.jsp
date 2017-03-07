<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Votantes"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="Css/Css.css" rel="stylesheet" type="text/css">
        <title>Login</title>
    </head>
    <body>
        <header>
            <h1>Estas son las personas que estan en el censo de la base de datos.</h1>
        </header>
        <section>
            <%
                HttpSession sesion = request.getSession();
                ArrayList<Votantes> votantes = (ArrayList<Votantes>) sesion.getAttribute("array");
            %>
            <table>
                <tr><td>Dni</td><td>Voto</td></tr>
                <%  
                    for (Votantes i : votantes) {
                        out.println("<tr><td>" + i.getDni() + "</td><td>" + i.getVoto() + "</td></tr>");
                    }
                %>
            </table>
        </section>
        <footer>
            <a href="Indexloged.jsp">Index..</a> 
            Diciembre 2016.
        </footer>
    </body>
</html>

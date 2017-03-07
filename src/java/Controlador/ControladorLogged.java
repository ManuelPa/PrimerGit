/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dao.ConexionBBDD;
import Dao.Operaciones;
import Modelo.Votantes;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author pc
 */
public class ControladorLogged extends HttpServlet {

    private Connection Conexion;

    public void init() throws ServletException {
        /* Establecemos la conexión, si no existe */
        try {
            ConexionBBDD ConexBD = ConexionBBDD.GetConexion();
            Conexion = ConexBD.GetCon();
        } catch (ClassNotFoundException | SQLException cnfe) {
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        ServletContext sc = getServletContext();
        RequestDispatcher rd;
        HttpSession sesion = request.getSession();

        String dni = (String) sesion.getAttribute("dni");
        String clave = (String) sesion.getAttribute("clave");
        Votantes votante = new Votantes(dni, clave);

        String boton = request.getParameter("sub");

        switch (boton) {
            case "Votar": {
                if (Operaciones.votarc(Conexion, votante)) {
                    rd = sc.getRequestDispatcher("/Vista/IndexVoto.jsp");
                    rd.forward(request, response);
                } else {
                    rd = sc.getRequestDispatcher("/Vista/Error.jsp");
                    rd.forward(request, response);
                }
            }
            break;

            case "Censo electoral": {
                //Añadimos los votantes a un arrayList en un metodo de operaciones
                ArrayList<Votantes> votantes = Operaciones.añadir(Conexion);
                sesion.setAttribute("array", votantes);
                rd = sc.getRequestDispatcher("/Vista/IndexCenso.jsp");
                rd.forward(request, response);
            }
            break;

            case "Cierre Escrutinio": {
                rd = sc.getRequestDispatcher("/Vista/IndexCierre.jsp");
                rd.forward(request, response);
            }
            break;

            case "Dar Baja": {
                if (Operaciones.baja(Conexion, votante)) {
                    rd = sc.getRequestDispatcher("index.jsp");
                    rd.forward(request, response);
                } else {
                    rd = sc.getRequestDispatcher("/Vista/Error.jsp");
                    rd.forward(request, response);
                }
            }
            break;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(ControladorLogged.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(ControladorLogged.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

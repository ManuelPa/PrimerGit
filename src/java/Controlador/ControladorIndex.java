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
public class ControladorIndex extends HttpServlet {

    private Connection Conexion;

    @Override
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

        String dni = request.getParameter("nif");
        String clave = request.getParameter("clave");
        Votantes votante = new Votantes(dni, clave);

        HttpSession sesion = request.getSession(true);
        sesion.setAttribute("dni", dni);
        sesion.setAttribute("clave", clave);

        String boton = request.getParameter("submit");

        switch (boton) {
            case "Registar Usuario": {
                if (!Operaciones.comprobar(Conexion, votante)) {
                    Operaciones.registrar(Conexion, new Votantes(dni, clave));
                    response.sendRedirect("index.jsp");
                } else {
                    response.sendRedirect("Vista/Error.jsp");
                }
            }
            break;

            case "Iniciar Sesion": {
                if (Operaciones.comprobar(Conexion, votante)) {
                    if (Operaciones.iniciar(Conexion, new Votantes(dni, clave))) {
                        rd = sc.getRequestDispatcher("/Vista/Indexloged.jsp");
                        rd.forward(request, response);
                    }
                } else {
                    response.sendRedirect("Vista/Error.jsp");
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
            Logger.getLogger(ControladorIndex.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ControladorIndex.class.getName()).log(Level.SEVERE, null, ex);
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

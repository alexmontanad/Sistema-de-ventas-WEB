/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import Modelo.dto.EmpleadoDTO;
import Modelo.dao.EmpleadoDAO;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alex
 */
public class Controlador extends HttpServlet {

    EmpleadoDTO em = new EmpleadoDTO();
    EmpleadoDAO emdao = new EmpleadoDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        String menu = request.getParameter("menu");

        if (menu.equals("Principal")) {
            System.out.println("Principal");
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }

        if (menu.equals("Producto")) {
            System.out.println("Producto");
            request.getRequestDispatcher("Producto.jsp").forward(request, response);
        }

        if (menu.equals("Empleado")) {
            switch (accion) {
                case "Listar":
                    List lista = emdao.readAll();
                    request.setAttribute("empleados", lista);
                    break;
                case "Agregar":
                    String dni = request.getParameter("txtDni");
                    String nombre = request.getParameter("txtNombre");
                    String telefono = request.getParameter("txtTel");
                    String estado = request.getParameter("txtEstado");
                    String user = request.getParameter("txtUser");
                    em.setCedula(dni);
                    em.setNombre(nombre);
                    em.setTelefono(telefono);
                    em.setEstado(estado);
                    em.setUser(user);
                    emdao.create(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    break;
                case "Eliminar":
                    break;
                default:

            }
            request.getRequestDispatcher("Empleado.jsp").forward(request, response);
        }

        if (menu.equals("Clientes")) {
            System.out.println("Clientes");
            request.getRequestDispatcher("Clientes.jsp").forward(request, response);
        }

        if (menu.equals("RegistrarVenta")) {
            System.out.println("Venta");
            request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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

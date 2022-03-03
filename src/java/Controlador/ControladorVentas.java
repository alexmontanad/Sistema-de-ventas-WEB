package Controlador;

import Modelo.dto.ClienteDTO;
import Modelo.dao.ClienteDAO;
import Modelo.dto.EmpleadoDTO;
import Modelo.dao.EmpleadoDAO;
import Modelo.dto.ProductoDTO;
import Modelo.dao.ProductoDAO;
import Modelo.dto.VentaDTO;
import Modelo.dao.VentaDAO;
import Conexion.GenerarSerie;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jromano
 */
public class ControladorVentas extends HttpServlet {
    
    EmpleadoDTO em = new EmpleadoDTO();
    EmpleadoDAO edao = new EmpleadoDAO();
    ClienteDTO c = new ClienteDTO();
    ClienteDAO cdao = new ClienteDAO();
    ProductoDTO p = new ProductoDTO();
    ProductoDAO pdao = new ProductoDAO();
    int ide;
    int idc;
    int idp;
    
    VentaDTO v = new VentaDTO();
    List<VentaDTO> lista = new ArrayList<>();
    int item;
    int cod;
    String descripcion;
    double precio;
    int cant;
    double subtotal;
    double totalPagar;
    
    String numeroserie;
    VentaDAO vdao = new VentaDAO();
     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                String menu = request.getParameter("menu");
                String accion = request.getParameter("accion");
                if (menu.equals("NuevaVenta")) {
                    switch (accion) {
                        case "BuscarCliente":
                            String dni = request.getParameter("codigocliente");
                            c.setDni(dni);
                            c = cdao.buscar(dni);
                            request.setAttribute("c", c);
                            request.setAttribute("nserie", numeroserie);
                            break;
                        case "BuscarProducto":
                            int id = Integer.parseInt(request.getParameter("codigoproducto"));
                            p = pdao.listarId(id);                    
                            request.setAttribute("c", c);
                            request.setAttribute("producto", p);                    
                            request.setAttribute("lista", lista);                    
                            request.setAttribute("totalpagar", totalPagar);
                            break;
                        case "Agregar":
                            request.setAttribute("nserie", numeroserie);
                            request.setAttribute("c", c);
                            totalPagar = 0.0;
                            item = item + 1;
                            cod = p.getId();
                            descripcion = request.getParameter("nomproducto");
                            precio = Double.parseDouble(request.getParameter("precio"));
                            cant = Integer.parseInt(request.getParameter("cant"));
                            subtotal = precio * cant;
                            v = new VentaDTO();
                            v.setItem(item);
                            v.setIdproducto(cod);
                            v.setDescripcionP(descripcion);
                            v.setPrecio(precio);
                            v.setCantidad(cant);
                            v.setSubtotal(subtotal);
                            lista.add(v);
                            for (int i = 0; i < lista.size(); i++) {
                                totalPagar = totalPagar + lista.get(i).getSubtotal();
                            }
                            request.setAttribute("totalpagar", totalPagar);
                            request.setAttribute("lista", lista);                    
                            break;
                        case "GenerarVenta":
                            //Actualizacion del Stock
                            for (int i = 0; i < lista.size(); i++) {
                                ProductoDTO pr=new ProductoDTO();
                                int cantidad=lista.get(i).getCantidad();
                                int idproducto=lista.get(i).getIdproducto();
                                ProductoDAO aO=new ProductoDAO();
                                pr=aO.buscar(idproducto);
                                int sac=pr.getStock()-cantidad;
                                aO.actualizarstock(idproducto, sac);
                            }
                            //Guardar Venta
                            v.setIdcliente(c.getId());
                            v.setIdempleado(2);
                            v.setNumserie(numeroserie);
                            v.setFecha("2019-06-14");
                            v.setMonto(totalPagar);
                            v.setEstado("1");
                            vdao.guardarVenta(v);
                            //Guardar Detalle ventas
                            int idv=Integer.parseInt(vdao.IdVentas());
                            for (int i = 0; i < lista.size(); i++) {
                                v=new VentaDTO();
                                v.setId(idv);
                                v.setIdproducto(lista.get(i).getIdproducto());
                                v.setCantidad(lista.get(i).getCantidad());
                                v.setPrecio(lista.get(i).getPrecio());
                                vdao.guardarDetalleventas(v);
                            }
                            lista=new ArrayList<>();
                            break;
                        default:                    
                            v = new VentaDTO();
                            lista = new ArrayList<>();
                            item = 0;
                            totalPagar = 0.0;                    
                            numeroserie = vdao.GenerarSerie();
                            if (numeroserie == null) {
                                numeroserie = "000000001";                        
                                request.setAttribute("nserie", numeroserie);
                            } else {
                                int incrementar = Integer.parseInt(numeroserie);
                                GenerarSerie gs = new GenerarSerie();
                                numeroserie = gs.NumeroSerie(incrementar);
                                request.setAttribute("nserie", numeroserie);
                            }
                        request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
                    }
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

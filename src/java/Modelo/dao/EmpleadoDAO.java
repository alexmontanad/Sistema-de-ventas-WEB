/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.dao;

import Conexion.ConexionMySQL;
import Modelo.dto.EmpleadoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.interfaces.Obligacion;

/**
 *
 * @author Alex
 */
public class EmpleadoDAO{
    
    PreparedStatement ps;
    ResultSet rs;    
    
    ConexionMySQL acceso=new ConexionMySQL();
    Connection con;

    private static final String VALIDAR_EMPLEADO = "SELECT * FROM empleado WHERE User=? AND Dni=?";

    public EmpleadoDTO ValidarSesion(String user, String password) {
        EmpleadoDTO nn = new EmpleadoDTO();
        PreparedStatement ps;
        ResultSet rs = null;
        try {
            ConexionMySQL con = ConexionMySQL.getInstace();
            ps = con.getCnn().prepareStatement(VALIDAR_EMPLEADO);
            ps.setString(1, user);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                nn.setId(rs.getInt("IdEmpleado"));
                nn.setCedula(rs.getString("Dni"));
                nn.setNombre(rs.getString("Nombres"));
                nn.setUser(rs.getString("user"));
            }
        } catch (SQLException ex) {
            System.out.println("Error en consulta read" + ex.getMessage());
        }
        return nn;
    }


    public boolean create(EmpleadoDTO nuevo) {
        int r=0;
        String sql = "insert into empleado(Dni,Nombres,Telefono,Estado,User)values(?,?,?,?,?)";
        try {
            con = acceso.getCnn();
            ps = con.prepareStatement(sql);
            ps.setString(1, nuevo.getCedula());
            ps.setString(2, nuevo.getNombre());
            ps.setString(3, nuevo.getTelefono());
            ps.setString(4, nuevo.getEstado());
            ps.setString(5, nuevo.getUser());
            ps.executeUpdate();
        } catch (SQLException e) {
        }
        return true;
        
    }


    public List<EmpleadoDTO> readAll() {
        String sql = "select * from empleado";
        List<EmpleadoDTO> listaVendedor = new ArrayList<>();
        try {
            con = acceso.getCnn();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                EmpleadoDTO ven = new EmpleadoDTO();
                ven.setId(rs.getInt(1));
                ven.setCedula(rs.getString(2));
                ven.setNombre(rs.getString(3));
                ven.setTelefono(rs.getString(4));
                ven.setEstado(rs.getString(5));
                ven.setUser(rs.getString(6));
                listaVendedor.add(ven);
            }
        } catch (SQLException e) {
        }
        return listaVendedor;
    }


    public EmpleadoDTO read(int id) {
    EmpleadoDTO v=new EmpleadoDTO();
        String sql = "select * from empleado where IdEmpleado=" + id;
        try {
            con = acceso.getCnn();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                v.setId(rs.getInt(1));
                v.setCedula(rs.getString(2));
                v.setNombre(rs.getString(3));
                v.setTelefono(rs.getString(4));
                v.setEstado(rs.getString(5));
                v.setUser(rs.getString(6));
            }
        } catch (SQLException e) {
        }
        return v;
    }


    public boolean update(EmpleadoDTO item) {
        int r=0;
        String sql = "update empleado set Dni=?, Nombres=?,Telefono=?,Estado=? Where IdEmpleado=?";
        try {
            con = acceso.getCnn();
            ps = con.prepareStatement(sql);
            ps.setString(1, item.getCedula());
            ps.setString(2, item.getNombre());
            ps.setString(3, item.getTelefono());
            ps.setString(4, item.getEstado());
            ps.setString(5, item.getUser());
            ps.setInt(6, item.getId());
            r = ps.executeUpdate();
            if (r == 1) {
                r = 1;
            } else {
                r = 0;
            }
        } catch (SQLException e) {
            System.err.println("" + e);
        }
        return true;
    }


    public boolean delete(int id) {
        String sql = "delete from empleado where IdEmpleado=?";
        try {
            con = acceso.getCnn();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
        return true;
    }

}

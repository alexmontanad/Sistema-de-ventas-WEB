/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.dao;

import Conexion.Conexion;
import Modelo.dto.ProductoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alex
 */
public class ProductoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
  public ProductoDTO buscar(int id){
      ProductoDTO p=new ProductoDTO();
      String sql="select * from producto where idproducto="+id;
      try {
          con=cn.Conexion();
          ps=con.prepareStatement(sql);
          rs=ps.executeQuery();
          while (rs.next()) {
              p.setId(rs.getInt(1));
              p.setNom(rs.getString(2));
              p.setPre(rs.getDouble(3));
              p.setStock(rs.getInt(4));
              p.setEstado(rs.getString(5));
          }
      } catch (SQLException e) {
      }
     return p;
  }
  public int actualizarstock(int id, int stock){
      String sql="update producto set Stock=? where idproducto=?";
      try {
          con=cn.Conexion();
          ps=con.prepareStatement(sql);
          ps.setInt(1, stock);
          ps.setInt(2, id);
          ps.executeUpdate();
      } catch (SQLException e) {
      }
      return r;
  }
    
  //*******Operaciones CRUD***************//    
    public List listar(){
        String sql="select * from producto";
        List<ProductoDTO>lista=new ArrayList<>();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                ProductoDTO em=new ProductoDTO();
                em.setId(rs.getInt(1));
                em.setNom(rs.getString(2));               
                em.setPre(rs.getDouble(3));
                em.setStock(rs.getInt(4));
                em.setEstado(rs.getString(5));                
                lista.add(em);
            }
        } catch (SQLException e) {
        }
        return lista;
    }
    public int agregar(ProductoDTO p){ 
        String sql="insert into producto(Nombres, Precio,Stock,Estado)values(?,?,?,?)";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, p.getNom());
            ps.setDouble(2, p.getPre());
            ps.setInt(3, p.getStock());
            ps.setString(4, p.getEstado());        
            ps.executeUpdate();
        } catch (SQLException e) {
        }
        return r;
        
    }
    public ProductoDTO listarId(int id){
        ProductoDTO pr=new ProductoDTO();
        String sql="select * from producto where IdProducto="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                pr.setId(rs.getInt(1));
                pr.setNom(rs.getString(2));               
                pr.setPre(rs.getDouble(3));
                pr.setStock(rs.getInt(4));
                pr.setEstado(rs.getString(5));  
            }
        } catch (SQLException e) {
        }
        return pr;
    }
    public int actualizar(ProductoDTO em){
        String sql="update producto set Nombres=?, Precio=?, Stock=?, Estado=? where IdProducto=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, em.getNom());
            ps.setDouble(2, em.getPre());
            ps.setInt(3, em.getStock());
            ps.setString(4, em.getEstado());            
            ps.setInt(5, em.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
        }
        return r;
    }
    public void delete(int id){
        String sql="delete from producto where IdProducto="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }
    
}

    

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import bd.Conexion;
import modelo.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author el_ma
 */
public class Registro {

    public boolean agregarProducto(Producto producto) {

        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = "INSERT INTO producto(idproducto, nombreProd, precio, descripcion) VALUES(?,?,?,?)";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, producto.getIdproducto());
            stmt.setString(2, producto.getNombreProd());
            stmt.setInt(3, producto.getPrecio());
            stmt.setString(4, producto.getDescripcion());

            stmt.executeUpdate();
            stmt.close();
            cnx.close();

            return true;

        } catch (SQLException e) {
            System.out.println("Error al agregar producto en SQL - Clase producto" + e.getMessage());
            return false;
        }

    }

    public boolean actualizarProducto(Producto producto) {
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = "UPDATE producto set nombreProd =?, precio =?, descripcion=? WHERE idproducto =?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, producto.getIdproducto());
            stmt.setString(2, producto.getNombreProd());
            stmt.setInt(3, producto.getPrecio());
            stmt.setString(4, producto.getDescripcion());

            stmt.executeUpdate();
            stmt.close();
            cnx.close();

            return true;

        } catch (SQLException e) {
            System.out.println("Error al actualizar producto en SQL - Clase producto" + e.getMessage());
            return false;
        }
    }

    public boolean eliminarProducto(int idProducto) {
//        Producto producto = new Producto();
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = "DELETE FROM producto WHERE idproducto=?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, idProducto);

            stmt.executeUpdate();
            stmt.close();
            cnx.close();

            return true;

        } catch (SQLException e) {
            System.out.println("Error al eliminar producto en SQL - Clase producto" + e.getMessage());
            return false;
        }
    }
    
    public Producto buscarProducto(int idproducto){
        Producto producto = new Producto();
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = "SELECT idproducto, nombreProd, precio, descripcion FROM producto WHERE idproducto=?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, idproducto);
            
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                producto.setIdproducto(rs.getInt("idproducto"));
                producto.setNombreProd(rs.getString("nombreProd"));
                producto.setPrecio(rs.getInt("precio"));
                producto.setDescripcion(rs.getString("descripcion"));
            }
            rs.close();
            stmt.close();
            cnx.close();
            
        } catch (SQLException e) {
            System.out.println("Error al buscar producto en SQL - Clase producto" + e.getMessage());
        }
        return producto;
    }

    public List<Producto> buscarTodos(){
        List<Producto> lista = new ArrayList<>();
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = "SELECT idproducto, nombreProd, precio, descripcion FROM producto ORDER BY idproducto";
            PreparedStatement stmt = cnx.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setIdproducto(rs.getInt("idproducto"));
                producto.setNombreProd(rs.getString("nombreProd"));
                producto.setPrecio(rs.getInt("precio"));
                producto.setDescripcion(rs.getString("descripcion"));
                lista.add(producto);
            }
            rs.close();
            stmt.close();
            cnx.close();
            
        } catch (SQLException e) {
            System.out.println("Error al listar productos - Clase producto" + e.getMessage());
        }
        return lista;
    }
    
    public boolean verificarId(){
        Producto producto = new Producto();
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = "SELECT idproducto FROM producto WHERE idproducto=?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, producto.getIdproducto());

            stmt.close();
            cnx.close();
            
            return true;
            
        } catch (Exception e) {
            
            return false;
        }
    
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author el_ma
 */
public class Producto {
    
    public int idproducto;
    public String nombreProd;
    public int precio;
    public String descripcion;

    public Producto() {
    }

    public Producto(int idproducto, String nombreProd, int precio, String descripcion) {
        this.idproducto = idproducto;
        this.nombreProd = nombreProd;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public String getNombreProd() {
        return nombreProd;
    }

    public void setNombreProd(String nombreProd) {
        this.nombreProd = nombreProd;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Producto{" + "idproducto=" + idproducto + ", nombreProd=" + nombreProd + ", precio=" + precio + ", descripcion=" + descripcion + '}';
    }
    
    
    
}

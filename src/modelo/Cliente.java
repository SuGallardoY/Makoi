/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Susana
 */
public class Cliente {
    private int rut_cliente;
    private String nombre_cliente;
    private String direccion_envio;
    private String comuna;
    private String productos_comprados;

    public Cliente() {
    }

    public Cliente(int rut_cliente, String nombre_cliente, String direccion_envio, String comuna, String productos_comprados) {
        this.rut_cliente = rut_cliente;
        this.nombre_cliente = nombre_cliente;
        this.direccion_envio = direccion_envio;
        this.comuna = comuna;
        this.productos_comprados = productos_comprados;
    }

    public int getRut_cliente() {
        return rut_cliente;
    }

    public void setRut_cliente(int rut_cliente) {
        this.rut_cliente = rut_cliente;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getDireccion_envio() {
        return direccion_envio;
    }

    public void setDireccion_envio(String direccion_envio) {
        this.direccion_envio = direccion_envio;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getProductos_comprados() {
        return productos_comprados;
    }

    public void setProductos_comprados(String productos_comprados) {
        this.productos_comprados = productos_comprados;
    }

    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import bd.Conexion;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Usuario;
import vista.Login;
import java.lang.String;
import modelo.Cliente;
import modelo.Producto;




/**
 *
 * @author Susana
 */
public class Controlador {
    
    /** Métodos para USUARIO  */
    
    public Usuario buscarUsuario(String usuarioVentana) {
        Usuario user = new Usuario();

        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "SELECT user, password FROM makoi.usuario WHERE user=BINARY?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setString(1, usuarioVentana);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                user.setUser(rs.getString("user"));
                user.setPassword(rs.getString("password"));
            }

            rs.close();
            stmt.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return user;
    }
    
        public boolean agregarUsuario(Usuario User) {
       
        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            
            
            String query = "INSERT INTO usuario(user, password) VALUES (?,?)";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setString(1, User.getUser());
            stmt.setString(2, User.getPassword());
            

            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
    
       
   public boolean actualizarUsuario (Usuario user) {
        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "UPDATE usuario set user = ?, password = ? WHERE user=?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setString(1, user.getUser());
            stmt.setString(2, user.getPassword());

            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
    
 
    public List<Usuario> ListarTodos() {
    List <Usuario> listaUser = new ArrayList<Usuario>();

        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "SELECT user, password FROM usuario order by user";
            PreparedStatement stmt = cnx.prepareStatement(query);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Usuario usuario1 = new Usuario();
                usuario1.setUser(rs.getString("user"));
                

                listaUser.add(usuario1);
            }
            rs.close();
            stmt.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println("Error SQL al listar usuarios: "  + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al listar usuario: " + e.getMessage());
        }
        return listaUser;
    }     

    

     public Usuario buscarPorUsuario    (String Usuario) {
         Usuario usuario = new Usuario();

        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "SELECT user FROM usuario WHERE user= ?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setString(1, Usuario);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                usuario.setUser(rs.getString("user"));          

            }

            rs.close();
            stmt.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println("Error SQL al listar libro por id" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al listar libro por id" + e.getMessage());
        }
        return usuario;
  
}
     
     
    public boolean eliminar(String nombreUsuario) {
        try {
            boolean resultado = false;
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "DELETE FROM Usuario WHERE user = '"+nombreUsuario+"'";
            PreparedStatement stmt = cnx.prepareStatement(query);

            int rs = stmt.executeUpdate();
            stmt.close();
            cnx.close();
            if(rs > 0){
                resultado = true;
            }
            return resultado;
        } catch (SQLException e) {
            System.out.println("Error SQL al eliminar usuario: " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error al eliminar usuario: " + e.getMessage());
            return false;
        }
    }     
     
     
         /** Métodos para PRODUCTO  */
    
    
      public List<Producto>  MostrarTodosProductos    () {
          List<Producto> lista = new ArrayList<Producto>();
         

        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "SELECT id_producto, nombre_producto, tipo_producto, material, color, precio, stock FROM producto";
            PreparedStatement stmt = cnx.prepareStatement(query);
            

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Producto producto = new Producto();
                
                producto.setId_producto(rs.getInt("id_producto"));
                producto.setNombre_producto(rs.getString("nombre_producto"));
                producto.setTipo_producto(rs.getString("tipo_producto"));
                producto.setMaterial(rs.getString("material"));
                producto.setColor(rs.getString("color"));
                producto.setPrecio(rs.getInt("precio"));
                producto.setStock(rs.getInt("stock"));          
            
                lista.add(producto);
            }
                    
            

            rs.close();
            stmt.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println("Error SQL al listar libro por id" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al listar libro por id" + e.getMessage());
        }
        return lista;
  
}  
    
    
    
    public Producto buscarPorId(int id_producto) {
        Producto producto = new Producto();

        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "SELECT id_producto, nombre_producto, tipo_producto, material, color, precio, stock FROM producto WHERE id_producto=?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, id_producto);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                producto.setId_producto(rs.getInt("id_producto"));
                producto.setNombre_producto(rs.getString("nombre_producto"));
                producto.setTipo_producto(rs.getString("tipo_producto"));
                producto.setMaterial(rs.getString("material"));
                producto.setColor(rs.getString("color"));
                producto.setPrecio(rs.getInt("precio"));
                producto.setStock(rs.getInt("stock"));            }

            rs.close();
            stmt.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println("Error SQL al listar producto por id" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al listar producto por id" + e.getMessage());
        }
        return producto;
    }    
    
    
    
 public boolean agregarProducto(Producto producto) {
        
        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();
     
            String query = "INSERT INTO producto(id_producto, nombre_producto, tipo_producto, material, color, precio, stock) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, producto.getId_producto());
            stmt.setString(2, producto.getNombre_producto());
            stmt.setString(3, producto.getTipo_producto());
            stmt.setString(4, producto.getMaterial());
            stmt.setString(5, producto.getColor());
            stmt.setInt(6, producto.getPrecio());
            stmt.setInt(7, producto.getStock());

            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Error SQL al agregar producto" + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error al agregar producto" + e.getMessage());
            return false;
        }
    }
 
 
  public List<Producto> ListarProductos() {
    List <Producto> listaProductos = new ArrayList<Producto>();

        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "SELECT  id_producto, nombre_producto, tipo_producto, material, color, precio, stock FROM producto order by id_producto";
            PreparedStatement stmt = cnx.prepareStatement(query);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Producto producto1 = new Producto();
                
                producto1.setId_producto(rs.getInt("id_producto"));
                producto1.setNombre_producto("nombre_producto");
                producto1.setTipo_producto("tipo_producto");
                producto1.setMaterial("material");
                producto1.setColor("color");
                producto1.setPrecio(rs.getInt("precio"));
                producto1.setStock(rs.getInt("stock"));              
               

                listaProductos.add(producto1);
            }
            rs.close();
            stmt.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println("Error SQL al listar usuarios: "  + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al listar usuario: " + e.getMessage());
        }
        return listaProductos;
    }     
  
    
 public boolean actualizar(Producto producto) {
        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "UPDATE producto set nombre_producto = ?, tipo_producto = ?, material= ?, color = ?,  precio = ?,  stock= ? WHERE id_producto=?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setString(1, producto.getNombre_producto());
            stmt.setString(2, producto.getTipo_producto());
            stmt.setString(3, producto.getMaterial());
            stmt.setString(4, producto.getColor());
            stmt.setInt(5, producto.getPrecio());          
            stmt.setInt(6, producto.getStock());
            stmt.setInt(7, producto.getId_producto());
            

            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Error SQL al actualizar producto" + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error al actualizar producto" + e.getMessage());
            return false;
        }
    }
 
 
     public Producto buscarPorNombre(String nombre) {
      Producto producto = new Producto();

        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "SELECT id_producto, nombre_producto, tipo_producto, material, color, precio, stock FROM producto WHERE UPPER(nombre_producto)=UPPER(?)";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setString(1, nombre);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                producto.setId_producto(rs.getInt("id_producto"));
                producto.setNombre_producto(rs.getString("nombre_producto"));
                producto.setTipo_producto(rs.getString("tipo_producto"));
                producto.setMaterial(rs.getString("material"));
                producto.setColor(rs.getString("color"));
                producto.setPrecio(rs.getInt("precio"));
                producto.setStock(rs.getInt("stock"));                
                       }

            rs.close();
            stmt.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println("Error SQL al listar producto por id" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al listar producto  por id" + e.getMessage());
        }
        return producto;
    }
  
    public List<String> buscarNombreProducto() {
        List<String> lista = new ArrayList<String>();

        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "SELECT nombre_producto FROM producto";
            PreparedStatement stmt = cnx.prepareStatement(query);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String titulo = rs.getString("nombre_producto");
                

                lista.add(titulo);
            }
            rs.close();
            stmt.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println("Error SQL al listar productos" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al listar productos" + e.getMessage());
        }
        return lista;
    
    }
     
     public boolean eliminar(int id_producto) {
        try {
            boolean resultado = false;
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "DELETE FROM producto WHERE id_producto=?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, id_producto);

            int rs = stmt.executeUpdate();
            stmt.close();
            cnx.close();
            if(rs > 0){
                resultado = true;
            }
            return resultado;
        } catch (SQLException e) {
            System.out.println("Error SQL al eliminar producto" + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error al eliminar producto" + e.getMessage());
            return false;
        }

}
     
    public Producto buscarPorStock(int stock) {
        Producto producto = new Producto();

        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query =  "SELECT id_producto, nombre_producto, tipo_producto, material, color, precio, stock FROM producto";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, stock);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                
                producto.setId_producto(rs.getInt("id_producto"));
                producto.setNombre_producto(rs.getString("nombre_producto"));
                 producto.setTipo_producto(rs.getString("tipo_producto"));
                producto.setMaterial(rs.getString("material"));
                producto.setColor("color");
                producto.setPrecio(rs.getInt("precio"));       
                producto.setStock(rs.getInt("stock"));          
                
            
            }

            rs.close();
            stmt.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println("Error SQL al listar producto por stock" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al listar producto por stock" + e.getMessage());
        }
        return producto;
    }      
        
     
     
     
     
     
     
              /** Métodos para CLIENTE  */
     
     
     
     

 public Cliente buscarPorRut(int rut_cliente) {
        Cliente cliente = new Cliente();

        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "SELECT rut_cliente, nombre_cliente, direccion_envio, comuna, productos_comprados FROM cliente WHERE rut_cliente=?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, rut_cliente);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                cliente.setRut_cliente(rs.getInt("rut_cliente"));
                cliente.setNombre_cliente(rs.getString("nombre_cliente"));
                cliente.setComuna(rs.getString("comuna"));
                cliente.setDireccion_envio(rs.getString("direccion_envio"));
                cliente.setProductos_comprados(rs.getString("productos_comprados"));     

         }

            rs.close();
            stmt.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println("Error SQL al listar cliente por rut" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al listar cliente por rut" + e.getMessage());
        }
        return cliente; }
        
        
        public boolean agregarCliente(Cliente cliente) {
        
        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();
     
            String query = "INSERT INTO cliente(rut_cliente, nombre_cliente,  direccion_envio, comuna, productos_comprados) VALUES (?,?,?,?,?)";
            
            PreparedStatement stmt = cnx.prepareStatement(query);
            
            stmt.setInt(1, cliente.getRut_cliente());
            stmt.setString(2, cliente.getNombre_cliente());
            stmt.setString(3, cliente.getDireccion_envio());
            stmt.setString(4, cliente.getComuna());
            stmt.setString(5, cliente.getProductos_comprados());
            
            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Error SQL al agregar cliente" + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error al agregar cliente" + e.getMessage());
            return false;
        }
    }

        
      public boolean eliminarCliente(int rut_cliente) {
        try {
            boolean resultado = false;
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "DELETE FROM cliente WHERE rut_cliente=?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, rut_cliente);

            int rs = stmt.executeUpdate();
            stmt.close();
            cnx.close();
            if(rs > 0){
                resultado = true;
            }
            return resultado;
        } catch (SQLException e) {
            System.out.println("Error SQL al eliminar cliente" + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error al eliminar cliente" + e.getMessage());
            return false;
        }
  
     
}
      
       public Cliente  buscarPorNombreCliente(String nombreCliente) {
      Cliente cliente = new Cliente();

        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "SELECT rut_cliente, nombre_cliente, direccion_envio, comuna, productos_comprados FROM cliente WHERE UPPER(nombre_cliente)=UPPER(?)";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setString(1, nombreCliente);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                cliente.setRut_cliente(rs.getInt("rut_cliente"));
                cliente.setNombre_cliente(rs.getString("nombre_cliente"));
                 cliente.setDireccion_envio(rs.getString("direccion_envio"));
                  cliente.setComuna(rs.getString("comuna"));
                 cliente.setProductos_comprados(rs.getString("productos_comprados"));
    
                       }

            rs.close();
            stmt.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println("Error SQL al listar cliente nombre" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al listar cliente por nombre" + e.getMessage());
        }
        return cliente;
    }
       
       
       public boolean actualizarCliente(Cliente cliente) {
        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "UPDATE cliente set  nombre_cliente = ?, direccion_envio= ?, comuna = ?, productos_comprados = ? WHERE rut_cliente=?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            
            
            stmt.setString(1, cliente.getNombre_cliente());
            stmt.setString(2, cliente.getDireccion_envio());
            stmt.setString(3, cliente.getComuna());
            stmt.setString(4, cliente.getProductos_comprados());
            stmt.setInt(5, cliente.getRut_cliente());
                   

            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Error SQL al actualizar cliente" + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error al actualizar cliente" + e.getMessage());
            return false;
        }
    }
       
          public List<Cliente>  MostrarTodosClientes  () {
          List<Cliente> lista = new ArrayList<Cliente>();
         

        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "SELECT rut_cliente, nombre_cliente, direccion_envio, comuna, productos_comprados  FROM cliente";
            PreparedStatement stmt = cnx.prepareStatement(query);
            

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                
               cliente.setRut_cliente(rs.getInt("rut_cliente"));
                cliente.setNombre_cliente(rs.getString("nombre_cliente"));
               cliente.setDireccion_envio(rs.getString("direccion_envio"));
               cliente.setComuna(rs.getString("comuna"));
               cliente.setProductos_comprados(rs.getString("productos_comprados"));
     
                lista.add(cliente);
            }
              rs.close();
            stmt.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println("Error SQL al listar cliente por rut" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al listar cliente por rut" + e.getMessage());
        }
        return lista;
  
}  
       



















}


       
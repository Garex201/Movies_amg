/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial_progra2;

import java.sql.Connection;
import java.io.FileInputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexion {

    Connection con = null;
    String Url = null;
    String username = null;
    String password = null;
    String jndi = null;
    String driver = null;

    static Properties props = new Properties();
//aquí cree mi constructor
    public Conexion() {
        try {
            FileInputStream archi = new FileInputStream("C:\\Datitos\\Propiedades.properties");
            props.load(archi);
            archi.close();
        } catch (Exception ex) {
            System.out.print(ex);
        }
        loadProps();
    }
//pa cargar props
    public void loadProps() {
        this.username = props.getProperty("username");
        this.password = props.getProperty("password");
        this.driver = props.getProperty("driver");
        this.Url = props.getProperty("url");
    }
//pa conectar
    public Connection getConection() {
        try {
           

            con = (Connection) DriverManager.getConnection(Url, username, password);

            System.out.println("Conexion Establecida");
        } catch (Exception e) {
            System.out.println("Primer carch "+e);
        }
        return con;
    }
//pa desconectar
    public void CerrarConection() {
        try {
            con.close();
            System.out.println("La sesion se cerro exitosamente");
        } catch (Exception e) {
            System.out.println("segundo catch"+e);

        }
    }

    public String getUrl() {
        return Url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getDriver() {
        return driver;
    }
    
}

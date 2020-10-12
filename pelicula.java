/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package parcial_progra2;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 * 
 *
 */
public class pelicula {
    private final String SQL_Agre = "insert into peliculas.pelicula(PELICULA_ID,GENERO_ID,DIRECTOR_ID,TITULO,ANIO,ARGUMENTO) values (?,?,?,?,?,?)";
    private DefaultTableModel dt;
    private ResultSet rs;
    private final Conexion connect;
    
    public pelicula(){
        connect= new Conexion(); 
    }
    private DefaultTableModel setTitulos() {
        dt = new DefaultTableModel();
        dt.addColumn("PELICULA_ID");
        dt.addColumn("GENERO_ID");
        dt.addColumn("DIRECTOR_ID");
        dt.addColumn("TITULO");
        dt.addColumn("ANIO");
        dt.addColumn("ARGUMENTO");
        return dt;
    }
        public void SaveData(int PELICULA_ID, int GENERO_ID,int DIRECTOR_ID,String TITULO, String ANIO,String ARGUMENTO){
       try {
         CallableStatement cs = connect.getConection().prepareCall("call insertar_pelicula(?,?,?,?,?,?)");
           cs.setInt(1, PELICULA_ID); 
           cs.setInt(2, GENERO_ID);
           cs.setInt(3, DIRECTOR_ID);
           cs.setString(4,TITULO);
           cs.setString(5, ANIO);
            cs.setString(6, ARGUMENTO);
                    
       if (cs.executeUpdate()==1) {
          
            }
       } catch (Exception e) {
          JOptionPane.showMessageDialog(null,e);
           connect.CerrarConection();
        }
        }
       public void modData(int PELICULA_ID, int GENERO_ID,int DIRECTOR_ID,String TITULO, String ANIO,String ARGUMENTO){
       try {
         CallableStatement cs = connect.getConection().prepareCall("call actualizar_pelicula(?,?,?,?,?,?)");
           cs.setInt(1, PELICULA_ID); 
           cs.setInt(2, GENERO_ID);
           cs.setInt(3, DIRECTOR_ID);
           cs.setString(4,TITULO);
           cs.setString(5, ANIO);
           cs.setString(6, ARGUMENTO);
            
       if (cs.executeUpdate()==1) {
          
            }
       } catch (Exception e) {
          JOptionPane.showMessageDialog(null,e);
           connect.CerrarConection();
        }
       
      }

}

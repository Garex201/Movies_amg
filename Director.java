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
public class Director {
private final String SQL_Agre = "insert into peliculas.director (DIRECTOR_ID,NOMBRE,DPI,NIT,FECHA_NACIMIENTO) values (?,?,?,?,?)";
    private DefaultTableModel dt;
    private ResultSet rs;
    private final Conexion connect;
    
    public Director(){
        connect= new Conexion(); 
    }
       private DefaultTableModel setTitulos() {
        dt = new DefaultTableModel();
        dt.addColumn("DIRECTOR_ID");
        dt.addColumn("NOMBRE");
        dt.addColumn("DPI");
        dt.addColumn("NIT");
        dt.addColumn("FECHA_NACIMIENTO");
        return dt;
    }
        public void SaveData(int DIRECTOR_ID,String NOMBRE,String DPI,String NIT,String FECHA_NACIMIENTO){
       try {
         CallableStatement cs = connect.getConection().prepareCall("call insertar_direc(?,?,?,?,?)");
           cs.setInt(1, DIRECTOR_ID);
           cs.setString(2,NOMBRE);
           cs.setString(3, DPI);
           cs.setString(4, NIT);
           cs.setString(5, FECHA_NACIMIENTO);
            
       if (cs.executeUpdate()==1) {
          
            }
       } catch (Exception e) {
          JOptionPane.showMessageDialog(null,e);
           connect.CerrarConection();
        }
        }
       public void modData(int DIRECTOR_ID,String NOMBRE,String DPI,String NIT,String FECHA_NACIMIENTO){
       try {
         CallableStatement cs = connect.getConection().prepareCall("call actualizar_direc(?,?,?,?,?)");
           cs.setInt(1, DIRECTOR_ID);
           cs.setString(2,NOMBRE);
           cs.setString(3, DPI);
           cs.setString(4, NIT);
           cs.setString(5, FECHA_NACIMIENTO);
            
       if (cs.executeUpdate()==1) {
          
            }
       } catch (Exception e) {
          JOptionPane.showMessageDialog(null,e);
           connect.CerrarConection();
        }
       
      }
}

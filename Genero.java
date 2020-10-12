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
 * */
public class Genero {
private final String SQL_Agre = "insert into peliculas.genero (GENERO_ID, GENERO_DESC) values (?,?)";
    private DefaultTableModel dt;
    private ResultSet rs;
    private final Conexion connect;
    
    public Genero(){
        connect= new Conexion(); 
    }
       private DefaultTableModel setTitulos() {
        dt = new DefaultTableModel();
        dt.addColumn("GENERO_ID");
        dt.addColumn("GENERO_DESC");
        return dt;
    }
        public void SaveData(int GENERO_ID,String GENERO_DESC){
       try {
         CallableStatement cs = connect.getConection().prepareCall("call insertar_genero(?,?)");
           cs.setInt(1, GENERO_ID);
           cs.setString(2,GENERO_DESC);
                    
       if (cs.executeUpdate()==1) {
          
            }
       } catch (Exception e) {
          JOptionPane.showMessageDialog(null,e);
           connect.CerrarConection();
        }
        }
       public void modData(int GENERO_ID,String GENERO_DESC){
       try {
         CallableStatement cs = connect.getConection().prepareCall("call actualizar_genero(?,?)");
         cs.setInt(1, GENERO_ID);
         cs.setString(2,GENERO_DESC);
            
       if (cs.executeUpdate()==1) {
          
            }
       } catch (Exception e) {
          JOptionPane.showMessageDialog(null,e);
           connect.CerrarConection();
        }
       
      }
}


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class database {
    Connection con=null;
    
    public int connect() {
       ResultSet rs=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            return 1;
        }
        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost/rj","root","");
        }catch(Exception e){
            return 1;
        }
        
        return 0;
    }
    
   
    
    public int insert(String str){
        Statement stm;
        try {
            stm = con.createStatement();
            stm.execute(str);
        } catch (SQLException ex) {
            System.out.println(ex);
            return 1;
        }
        return 0;
    }
    
    
      
    
    
    public int update(String str){
         Statement stm;
        try {
            stm = con.createStatement();
            stm.execute(str);
        } catch (SQLException ex) {
            return 1;
        }
        return 0;
    }
    
    public int delete(String str){
         Statement stm;
        try {
            stm = con.createStatement();
            stm.execute(str);
        } catch (SQLException ex) {
            return 1;
        }
        return 0;
    }
    
    public ObservableList<TbContent> display() throws SQLException{
         ResultSet rs = null;
        try {
            String str="select * from data";
             Statement stm=con.createStatement();
            rs=stm.executeQuery(str);
            
        } catch (SQLException ex) {
            System.out.println("There is no data in table");
        }
        
        return convert(rs);
    }
    
   public  ObservableList<TbContent> convert(ResultSet rs) throws SQLException{
        ObservableList<TbContent> Data=  FXCollections.observableArrayList();
         while(rs.next()){
            ++TbController.c;
            Data.add(
            new TbContent(TbController.c,rs.getString("pid"),rs.getString("pname"),rs.getString("cname"),rs.getString("dept"),rs.getString("et"),rs.getString("wid"),rs.getDate("date").toString(),rs.getString("ay")));
            
           
         }
         
         return Data;
    }
    
   public ResultSet select(String str){
         ResultSet rs =null;
        try {
          Statement  stm = con.createStatement();
            rs=stm.executeQuery(str);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return rs;
       
 }
    
    public void close() throws SQLException{
        con.close();
    }
 
}
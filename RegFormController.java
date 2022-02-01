
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.sql.ResultSet;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class RegFormController extends database implements Initializable {
    @FXML
    private TextField t3pid;
    @FXML
    private TextField t3pn;
    @FXML
    private TextField t3cn;
    @FXML
    private TextField t3wid;
    @FXML
    private ComboBox<String> c3dn;
    @FXML
    private ComboBox<String> c3ey;
    @FXML
    private ComboBox<String> c3ay;
    @FXML
    private DatePicker d3d;



        
  

    public  void  reg(ActionEvent ae) throws IOException, SQLException {
        
        
 
        if(check()==0){
        int ch=0;
       connect();
        String str="Insert into data values('"+t3pid.getText()+"','"+t3pn.getText()+"','"+t3cn.getText()+"','"+c3dn.getValue()+"','"+c3ey.getValue()+"','"+t3wid.getText()+"','"+d3d.getValue()+"','"+c3ay.getValue()+"')";
         ch=insert(str);
         if(ch==1){
             
              Alert alrt = new Alert(Alert.AlertType.INFORMATION);
                alrt.setContentText("Data Instertion failed");
                alrt.show();
         }
         else{
              Alert alrt = new Alert(Alert.AlertType.INFORMATION);
                alrt.setContentText("Instertion is done");
                alrt.show();
         }
        TbContent tb = new TbContent();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("table_view.fxml"));
        Parent root  = fxmlLoader.load();
        TbController tbController = fxmlLoader.getController();


        Stage stage  = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        Scene scene2 = new Scene(root);
        stage.setScene(scene2);
        stage.show();
        
       }
    }
    public  void clear(ActionEvent e){
        t3pid.clear();
        t3cn.clear();
        t3wid.clear();
        t3pn.clear();



    }

    public  void admin(ActionEvent ae){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("admin.fxml"));
            Stage stage  = (Stage) ((Node) ae.getSource()).getScene().getWindow();
            Scene scene3 = new Scene(root);
            stage.setScene(scene3);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    public void logout(ActionEvent ae) {
        Parent root = null;
        try {
            Alert alrt = new Alert(Alert.AlertType.INFORMATION);
            alrt.setContentText("Logout Sucessful");
            alrt.show();
            root = FXMLLoader.load(getClass().getResource("login.fxml"));
            Stage stage  = (Stage) ((Node) ae.getSource()).getScene().getWindow();
            Scene scene5 = new Scene(root);
            stage.setScene(scene5);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String[] dept = {"CSE", "Mech Engg", "ISE", "EEE", "ECE"};
        c3dn.setItems(FXCollections.observableArrayList(dept));
        String[] ey ={"Technical", "Seminar", "Soft Skill", "Guest Lecture"};
        c3ey.setItems(FXCollections.observableArrayList(ey));
         String ay[]={"2021-22"};
        c3ay.setItems(FXCollections.observableArrayList(ay));
        
    }
    
    
      public void alrt(String str){
          Alert al = new Alert(Alert.AlertType.ERROR);
                al.setContentText(str);
                al.showAndWait();
        
    }
      
      
      
          public int check () {
        if(t3pid.getText()==null &&t3pn.getText() ==null &&t3cn.getText() ==null &&t3wid.getText() ==null&&c3dn.getValue()==null&&c3ey.getValue() ==null&&c3ay.getValue()==null&&d3d.getValue()==null){
              
            alrt("con't be null");
            return 1;
        }
        else if(t3pid.getText()==null){
           alrt("con't be null");
           return 1;
       }
     else  if(t3pn.getText()==null){
           alrt("con't be null");
           return 1;
       }
      else if(t3cn.getText()==null){
           alrt("con't be null");
           return 1;
       }
      else if(t3wid.getText()==null){
           alrt("con't be null");
           return 1;
       }
       
     else  if(c3dn.getValue()==null){
           alrt("con't be null");
           return 1;
       }
       
      else  if(c3ey.getValue()==null){
           alrt("con't be null");
           return 1;
       }
        
        else  if(c3ay.getValue()==null){
           alrt("con't be null");
           return 1;
       }
        else if( d3d.getValue()==null){
           alrt("con't be null");
           return 1;
       }
        return 0;
  }
      
      
      
}

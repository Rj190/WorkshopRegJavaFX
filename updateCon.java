
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
import javafx.scene.control.TableView;
import javafx.scene.control.Label;



public class updateCon extends database implements Initializable
{
    
    @FXML
    private TableView<TbContent> tbv;
    
    @FXML
    private Label t3pid;
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
        @FXML
    private Label e3;
    
    
  
      public  void  upData(ActionEvent ae) throws IOException, SQLException {
        
        
 
        if(check()==0){
        int ch=0;
       connect();
        String str="update data  set pname='"+t3pn.getText()+"',cname='"+t3cn.getText()+"',dept='"+c3dn.getValue()+"',et='"+c3ey.getValue()+"',wid='"+t3wid.getText()+"',date='"+d3d.getValue()+"',ay='"+c3ay.getValue()+"' where pid='"+t3pid.getText()+"'";
          System.out.println(str);
         ch=update(str);
         if(ch==1){
             
              Alert alrt = new Alert(Alert.AlertType.INFORMATION);
                alrt.setContentText("Updation Failed");
                alrt.show();
         }
         else{
              Alert alrt = new Alert(Alert.AlertType.INFORMATION);
                alrt.setContentText("Data Updated");
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
           String[] dept = {"CSE", "Mech Engg", "ISE", "EEE", "ECE"};
        c3dn.setItems(FXCollections.observableArrayList(dept));
        String[] ey ={"Technical", "Seminar", "Soft Skill", "Guest Lecture"};
        c3ey.setItems(FXCollections.observableArrayList(ey));
         String ay[]={"2021-22"};
        c3ay.setItems(FXCollections.observableArrayList(ay));
        
        
        
    t3pid.setText(TbController.b.getPID());
    
    
    t3pn.setText(TbController.b.getPname());
    t3cn.setText(TbController.b.getCname());;
   t3wid.setText(TbController.b.getWId());;
   c3dn.setValue(TbController.b.getDname());;
   c3ey.setValue(TbController.b.getEtype());;
   c3ay.setValue(TbController.b.getAy());;
   e3.setText(TbController.b.getEdate());
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

     
        public void alrt(String str){
          Alert al = new Alert(Alert.AlertType.ERROR);
                al.setContentText(str);
                al.showAndWait();
        
    }
     
}

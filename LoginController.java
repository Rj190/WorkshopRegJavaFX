import com.mysql.jdbc.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.sql.ResultSet;

import java.io.IOException;
import java.sql.SQLException;



public class LoginController extends database {


    @FXML
    private Button b1log;

    @FXML
    private TextField t1uid;
    @FXML
    private PasswordField p1pw;
   



    public void login(ActionEvent ae) throws IOException, SQLException {
         connect();
         ResultSet r ;
          String str="Select id from login";
             r=select(str);
             r.next();
         ResultSet r1;
         String str1="Select pass from login";
             r1=select(str1);
             r1.next();
        
            
           String username =r.getString("id");
             
             
             String  password =r1.getString("pass");
            
          
            if(t1uid.getText().equals(username) && p1pw.getText().equals(password)) {

                Alert alrt = new Alert(Alert.AlertType.INFORMATION);
                alrt.setContentText("Login Sucessful");
                alrt.show();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("admin.fxml"));
                Parent root  = fxmlLoader.load();

                AdminController adminController = fxmlLoader.getController();
              
                adminController.disply(t1uid.getText());
                Stage stage  = (Stage) ((Node) ae.getSource()).getScene().getWindow();
                Scene scene2 = new Scene(root);
                stage.setScene(scene2);
                stage.show();
            }
            else{
                Alert alrt2 = new Alert(Alert.AlertType.ERROR);
                alrt2.setContentText("Verify User name and password");
                alrt2.show();
            }

    }


       public void clear(ActionEvent as){
           t1uid.clear();
           p1pw.clear();
       }
    }


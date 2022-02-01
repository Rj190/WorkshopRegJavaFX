import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminController extends database {

    private static String str1;

    @FXML
    private Button b2rp;
    @FXML
    private Label l2usr;
    @FXML
    private Label t1uid;

    public  void disply(String username) throws SQLException{

             connect();
         ResultSet r ;
          String str="Select id from login where id='"+username+"'";
             r=select(str);
             r.next();
            String  str1 = r.getString("id");
            l2usr.setText(str1);

    }

    public void register (ActionEvent ae) throws  Exception{

            Parent root = FXMLLoader.load(getClass().getResource("reg_from.fxml"));
            Stage stage  = (Stage) ((Node) ae.getSource()).getScene().getWindow();
            Scene scene3 = new Scene(root);
            stage.setScene(scene3);
            stage.show();


    }

    public void viewall (ActionEvent ae){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("table_view.fxml"));
            Stage stage  = (Stage) ((Node) ae.getSource()).getScene().getWindow();
            Scene scene4 = new Scene(root);
            stage.setScene(scene4);
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
}

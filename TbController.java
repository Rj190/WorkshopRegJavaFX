

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TbController  extends database implements Initializable{

        @FXML
        private TableView<TbContent> tbv;
    @FXML
    private TableColumn<TbContent ,Integer> sl;
    @FXML
    private TableColumn<TbContent , String> pid;
    @FXML
    private TableColumn<TbContent , String> pn;
    @FXML
    private TableColumn<TbContent , String> cn;
    @FXML
    private TableColumn<TbContent , String> dept;
    @FXML
    private TableColumn<TbContent , String> wid;
    @FXML
    private TableColumn<TbContent , String> ey;

    @FXML
    private TableColumn<TbContent, String> dt;
    @FXML
    private TableColumn<TbContent, String> ay;


//    ObservableList<TbContent> list = FXCollections.observableArrayList();


static int c=0;
    private TbContent Tbc;

    public void setTable(TbContent tb){




        ObservableList<TbContent> regList = tbv.getItems();
        regList.add(tb);
        tbv.setItems(regList);
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
    public void register (ActionEvent ae) throws  Exception{

        Parent root = FXMLLoader.load(getClass().getResource("reg_from.fxml"));
        Stage stage  = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        Scene scene3 = new Scene(root);
        stage.setScene(scene3);
        stage.show();


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        
        sl.setCellValueFactory(new PropertyValueFactory<TbContent,Integer>("sl"));
        pid.setCellValueFactory(new PropertyValueFactory<TbContent,String>("PID"));
        pn.setCellValueFactory(new PropertyValueFactory<TbContent,String>("Pname"));
        cn.setCellValueFactory(new PropertyValueFactory<TbContent,String>("Cname"));
        wid.setCellValueFactory(new PropertyValueFactory<TbContent,String>("WId"));
        ey.setCellValueFactory(new PropertyValueFactory<TbContent,String>("Etype"));
        ay.setCellValueFactory(new PropertyValueFactory<TbContent,String>("Ay"));
        dept.setCellValueFactory(new PropertyValueFactory<TbContent,String>("Dname"));
        dt.setCellValueFactory(new PropertyValueFactory<TbContent,String>("Edate"));

          connect();
      
  c=0;
            try {
                tbv.setItems(display());
            } catch (SQLException ex) {
                Logger.getLogger(TbController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    
    
    public void admin(ActionEvent ae)throws  Exception{
        
          Parent root = FXMLLoader.load(getClass().getResource("admin.fxml"));
        Stage stage  = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        Scene scene6 = new Scene(root);
        stage.setScene(scene6);
        stage.show();
        
    }
    
    
    public void alrt(String str){
          Alert al = new Alert(Alert.AlertType.INFORMATION);
                al.setContentText(str);
                al.show();
        
    }

public  void rem(ActionEvent ae) throws SQLException{
    
    int ch=0;
     TbContent b= tbv.getSelectionModel().getSelectedItem();
    Alert alrt = new Alert(Alert.AlertType.CONFIRMATION);
                alrt.setContentText("Do you want to delet?");
              Optional<ButtonType> r=alrt.showAndWait();
              if(r.isPresent()&&r.get()==ButtonType.OK){
                  String st="DELETE FROM DATA WHERE PID='"+b.getPID()+"'";
                  ch=delete(st);
                  if(ch==1){
                      alrt("Failed to delete");
                  }
                  else
                  {
                      alrt("Data Deleted");
                      c=0;
                      tbv.setItems(display());
                  }
              }
      
    
}



static  TbContent b;
  public   void updateT(ActionEvent ae){
        Parent root = null;
        try {           
             b= tbv.getSelectionModel().getSelectedItem();
             root = FXMLLoader.load(getClass().getResource("update.fxml"));
            Stage stage  = (Stage) ((Node) ae.getSource()).getScene().getWindow();
            Scene scene4 = new Scene(root);
            stage.setScene(scene4);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
           
        }

    }
  
  
  
  
}

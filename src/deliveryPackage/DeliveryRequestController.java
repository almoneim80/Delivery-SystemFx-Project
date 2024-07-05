package deliveryPackage;
//هذا الكلاس يتحكم بتشغيل شاشة الترحيب
//الشاشة التي تطبع اسم المستخدم وتسمح له بانشاء طلب جديد

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Font;
import javafx.stage.Stage;
 //////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////
public class DeliveryRequestController implements Initializable  {
    ArrayList<String> NewDeliverytData;
    
//هنا داخل هذ المتغيرات التي من نوع اعمدة ستخزن بيانات الجدول الخاص بالطالبات السابقة
    @FXML public TableView<Tabel1> tableView;
    
    @FXML public TableColumn<Tabel1,Integer> Id;
    @FXML public TableColumn<Tabel1,String> Current;
    @FXML public TableColumn<Tabel1,String> Goal;
    
    @FXML public TableColumn<Tabel1,String> HistoryId;
    @FXML public TableColumn<Tabel1,String> PriceId;
    @FXML public TableColumn<Tabel1,String> DriverId;
    
//////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////
    String username_For_Create_Request_Page;  //متغير نخزن بداخله اسم المستخد حتى نطبعه في الرسالة الترحيبية
    @FXML Label Titellabel;                    //ليبل لعرض الرسالة الترحيبية
    @FXML
    public void dispalyUserName(String usernameArgs)  //الميثود التي ستطبع الرالة الترحيبية
    {
        this.username_For_Create_Request_Page = usernameArgs;  //بما ان الميثود تستقبل اسم المستخدم سنأخذة من الميثود ونخزنه بداخل 
        Titellabel.setText("مرحبــــا " +usernameArgs);
        Titellabel.setFont(Font.font("Tohama", 25));
    }
//////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////
    
    //عندما نضغط على زر انشاء طلب جديد تعمل هذة الميثود
            @FXML
    private void CtreatRequestBTNAction(ActionEvent event) throws IOException {
            FXMLLoader fXMLloader = new FXMLLoader(getClass().getResource("CreateRequestFXML.fxml"));
            Parent root_DeliveryRequest = (Parent) fXMLloader.load();
            Stage stage = new Stage();
            stage.setTitle("شاشة انشاء طلب جديد");
            stage.setScene(new Scene(root_DeliveryRequest));
            stage.show();
            
            //نأخذ اسم المستخدم ونرسلة للميثود التي تطبع الرسالة الترحيبية في الشاشة الاخيرة
        CreateRequestFXMLController CRFC = fXMLloader.getController();
        CRFC.dispalyUserName(username_For_Create_Request_Page);
                System.out.println(Id.toString()); 
               NewDeliverytData = CRFC.NewDeliverytData;
    }
//////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////
//فكرة الاحتفاظ بالطلبات السابقة وعرضها بجدول لايمكن ان تتم الا باستخدام قاعدة بيانات
    
        int v1;
    String v2,v3,v4,v5,v6;
    public void xss(int i,String C_lo,String G_lo,String D, String pr , String dr)
    {
        this.v1 = i;   //رقم الطلب
        this.v2 = C_lo;  //الموقع الحالي
        this.v3 = G_lo; //الموقع المراد
        this.v4 = D;   //التاريخ
        this.v5 = pr;  //السعر
        this.v6 = dr;  //السائق
    }
 //////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////
    //من هنا نستطيع اضافة الطلبات السابقة
        @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Tabel1> list = list = FXCollections.observableArrayList(
           new Tabel1(v1,v2,v3,v4,v5,v6));
            
 //////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////
        //هنا نسند قيمة كل حقل في الجدول للحقل المناسب له
        
    Id.setCellValueFactory(new PropertyValueFactory<Tabel1,Integer>("Id1"));
    Current.setCellValueFactory(new PropertyValueFactory<Tabel1,String>("CurrentLocation1"));
    Goal.setCellValueFactory(new PropertyValueFactory<Tabel1,String>("GoalLocation1"));
    HistoryId.setCellValueFactory(new PropertyValueFactory<Tabel1,String>("Date1"));
    PriceId.setCellValueFactory(new PropertyValueFactory<Tabel1,String>("price1"));
    DriverId.setCellValueFactory(new PropertyValueFactory<Tabel1,String>("Driver1"));
    tableView.setItems(list);
    
    
}}

/*******************************************
 * *****************************************
 *


//فكرة تخزين المعلومات بداخل ارري ليست ثم طلب تنفيذ 
//عمليات في المشروع لاتتم الا بتواجد قاعدة بيانات هي فكرة غير صائبة مطلقا
* 
* 
*  */
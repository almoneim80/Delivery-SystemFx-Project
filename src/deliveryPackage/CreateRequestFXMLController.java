package deliveryPackage;
//هذا الكلاس يتحكم في الشاشة الاخير الخاصة بانشاء طلب جديد او طباعته

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

 //////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////
public class CreateRequestFXMLController implements Initializable {
    public int counter=0;                     //عداد يحسب عدد مرات انشاء طلبات
     String username;                             //متغير نخزن فيه اسم المستخدم عشان نطبعة في الرسالة الترحيبية 
     @FXML Label Titellabel,label;  //ليبل يظهر الرسالة الترحيبية
     
     ArrayList<String> NewDeliverytData = new ArrayList<String>(); //ارري لست نخز بداخله بيانات الطلب
     

@FXML TextField createRequestphoneField,  createRequestCurrentLoField, createRequestGoalLoField;      //متغيراتمن نوع حقول تحتوي على بيانات الطلب
@FXML ComboBox createRequestDriverField;                      // متغير من نوع قائمة منسدلة سنحصل من خلالة على اسم السائق الذي تم اختيارة
//////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////// 
     String driverName; 
    public void dispalyUserName(String usernameArgs)  //الميثود التي ستطبع الرسالة الترحيبية
    {
        this.username = usernameArgs;
        Titellabel.setText("مرحبــــا " +usernameArgs+" : لإنشاء طلب توصيل الرجاء اكمال ");
        Titellabel.setFont(Font.font("Tohama", 25));
    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////
    public String Dprice;   //متغير نخزن بداخلة سعر التوصيل سنستقبل القيمة عندما ينشى السائق حسابة
    public void dispalyprice(String priceArgs)  //ميثود تم استدعائها في كلاس حساب السائق
    {
        this.Dprice = priceArgs;
    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////
    
@FXML private ComboBox<String> comb;           //متغير من نوع قائمة منسدلة
String D_name;
public void getSelected(ActionEvent event) {  //ميثود ستتعامل مع القيمة التي سيتم تحديدها فيالقائمة المنسدلة
   D_name =  comb.getValue(); //نستخرج اسم السائق
}
///////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////

//هنا ميثود تعمل في حال ضغط المستخدم على زر انشاء طلب
                @FXML
    private void CreateRequestBTNAction(ActionEvent event) throws IOException {
                if(createRequestphoneField.getText().isEmpty() ||
                   createRequestCurrentLoField.getText().isEmpty() ||
                   createRequestGoalLoField.getText().isEmpty() ||
                   D_name.isEmpty()
                   )
           {
       label.setText("لايمكن ان تكون الحقول فارغة");
           }
            else
           {
                Date d = new Date();                            //كلاس التاريخ حتى نخزن تاريخ انشاء الطلب
        NewDeliverytData.add(createRequestphoneField.getText());  //phone
        NewDeliverytData.add(createRequestCurrentLoField.getText()); //current location
        NewDeliverytData.add(createRequestGoalLoField.getText()); //goal location
        NewDeliverytData.add(d.toString());                       //date
        NewDeliverytData.add(Dprice);                             //price
        NewDeliverytData.add(driverName);                        //driver
        counter = counter+1;


        DeliveryRequestController drc_obj = new DeliveryRequestController();  //اوبجكت من كلاس انشاء طلب جديد
        drc_obj.xss(counter, NewDeliverytData.get(1), NewDeliverytData.get(2), NewDeliverytData.get(3), NewDeliverytData.get(4), NewDeliverytData.get(5));
        label.setText("تم انشاء الطلب بنجاح");
           }
                
    }
//////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////
    
    //ميثود تعمل في حال اراد العميل طباعة الطلب
       @FXML 
       private void PrintRequestAction(ActionEvent event) throws IOException {
           if(createRequestphoneField.getText().isEmpty() ||
                   createRequestCurrentLoField.getText().isEmpty() ||
                   createRequestGoalLoField.getText().isEmpty() ||
                   D_name.isEmpty()
                   )
           {
       label.setText("لايمكن ان تكون الحقول فارغة");
           }
           else
           {
                       try{
                    File myObj = new File("Request.txt");    //ننشئ ملف من نوع تكست

                    FileWriter myWriter = new FileWriter("Request.txt");  //نخزن معلومات الطلب بداخل الملف
                    myWriter.write("name:"+username+"      "                       //اسم صاحب الطلب
                                  +"Userlocation :"+createRequestCurrentLoField.getText()+"      "  //الموقع الحالي
                                  +"Goallocation :"+createRequestGoalLoField.getText()+"      "    //الموقع المراد
                                  +"Driver Name : "+ D_name +"      "                          //اسم السائق
                                  +"price :"+"20");                                    //سعر التوصيل
                    myWriter.close();    //اغلاق الملف بعد الطباعة
               } 
               catch (IOException ex) {  //اكسبشن في حال حصل خطأ
                   Logger.getLogger(CreateRequestFXMLController.class.getName()).log(Level.SEVERE, null, ex);
               }
       label.setText("تم طباعة الطلب بنجاح");
           }
         
       }
//////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////
       //هنا نخزن عناصر قائمة السائقين
        @Override
    public void initialize(URL url, ResourceBundle rb) {
//فكرة اقتراح اسماء السائقين والاسعار في المنطقة لايمكن ان تتم الا على قاعدة بيانات
//ولايمكن ان تتم بشكل ديناميكي الا من خلال قاعدة بيانات
//فكيف نسمح بتسجيل سائق وعميل من نفس الشاشة ثم نطلب اقتراح

         ObservableList<String> list = FXCollections.observableArrayList("السائق1","السائق2","السائق3"); //نخزن اسماء السائقين المطابقين في لست
            comb.getItems().addAll(list);    //نمر الليست للقائمة المنسدلة
            comb.setOnAction(this::getSelected);
            
            
            
    }
 ///////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////
}

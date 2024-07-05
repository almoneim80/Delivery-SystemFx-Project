package deliveryPackage;
//هذا الكلاس يتحكم في شاشة انشاء حساب سائق جديد

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.stage.Stage;

 //////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////
public class DriverAccountFXMLController implements Initializable {
    ArrayList<String> NewDrivertData = new ArrayList<String>();
     
    @FXML Label Titellabel,AccountEmptyLabel;      //هنا متغير من نوع ليبل الذي سيطبع بداخلة الرسالة الترحبيبة الخاصة بالسائق
 
        public void dispalyTitellabel(String TitellabelArgs) //ميثود تطبع الرسالة الترحبيبة وتتحكم بخصائص الخط
    {
        Titellabel.setText(TitellabelArgs);
        Titellabel.setFont(Font.font("Tohama", 25));
    }
 //////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////
        //هنا متغيرات من نوع حقول تخزن المعلومات التي سيدخلها السائق
@FXML
TextField NewDriversernameField, 
          NewDriverPhNopasswordField,
          NewDriverpasswordField,
          NewDriverLocationField,
          deliveryAreaField,
          deliveryPriceField;
 //////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////
//بعد ان يكمل السائق ادخال بياناته ستعمل هذة الميثود
//وستنقل العميل للشاشة التالية
//اعتقد ان شاشة تسجيل سائق جديد هي الشاشة الاخيرة له لانه لايحتاج للانتقال الى الصفحة التالية
//التي تسمح له بانشاء طلب 
//يمكن ايقافه هنا بحذف كل الجمل التي داخل الميثود التالية
//الجمل وليس اسم الميثود

    @FXML
    private void NewDriverButtonAction(ActionEvent event) throws IOException {
        if(NewDriversernameField.getText().isEmpty() ||
                NewDriverPhNopasswordField.getText().isEmpty() ||
                NewDriverpasswordField.getText().isEmpty() ||
                NewDriverLocationField.getText().isEmpty() ||
                deliveryAreaField.getText().isEmpty() ||
                deliveryPriceField.getText().isEmpty())
        {
            AccountEmptyLabel.setText("لايمكن ان تكون الحقول فارغة");
        }
        else
        {
            FXMLLoader fXMLloader = new FXMLLoader(getClass().getResource("DeliveryRequest.fxml")); //فتح الشاشة الثالث والتي فيها زر انشاء طلب جديد
            Parent root1 = (Parent) fXMLloader.load();
            Stage stage = new Stage();
            stage.setTitle("شاشة انشاء طلب جديد");
            stage.setScene(new Scene(root1));
            stage.show();
            
        NewDrivertData.add(NewDriversernameField.getText()); //name
        NewDrivertData.add(NewDriverPhNopasswordField.getText()); //phone
        NewDrivertData.add(NewDriverpasswordField.getText()); //pass
        NewDrivertData.add(NewDriverLocationField.getText()); //loaction
        NewDrivertData.add(deliveryAreaField.getText());      //delivery area
        NewDrivertData.add(deliveryPriceField.getText());       //price

            //هنا بعد ان يسجل السائق  بياناتنه سنحتاج لاسمه حتى نطبع على الشاشة التالية رسالة ترحبيبة تحمل اسمه مثل مرحبا افنان
        String userName = NewDrivertData.get(0);   //استخرجنا اسم العميل من داخل حق الاسم وخزناه بداخل متغير
        DeliveryRequestController drc_obj = fXMLloader.getController(); //انشئنا اوبجكت من كلاس شاشة اشناء طلب جديد
        drc_obj.dispalyUserName(userName);               //استدعينا الميثود التي تطبع الرسالة الترحبيبة ومررنا لها اسم العميل
        }
    }
 //////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void initialize(URL url, ResourceBundle rb) {}    
}

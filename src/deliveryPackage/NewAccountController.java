package deliveryPackage;
//هنا الكلاس المتحكم بشاشة تسجل عميل جديد


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.stage.Stage;

 //////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////
public class NewAccountController implements Initializable {
      ArrayList<String> NewClienttData = new ArrayList<String>();
        @FXML Label Titellabel,NewAccountEmptyLabel;  //متغير من نوع ليبل نخزن فيه الرسالة الترحيبية 
        public void dispalyTitellabel(String TitellabelArgs) // الدالة التس قمنا باستدعائها من كلاس تسجيل الدخول عند جمل العميل
    {
        Titellabel.setText(TitellabelArgs);     //اسم الرسالة
        Titellabel.setFont(Font.font("Tohama", 25));  // خصائص الخط
    }
 //////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////     
        //هنا متغيرات من نوع حقول تحمل القيم التي سيدخلها العميل عندما ينشئ حساب جديد
@FXML TextField NewAccountUsernameField, NewAccountPhNopasswordField, NewAccountpasswordField,NewAccountLocationField;
 //////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////

//بعد ان يملا العميل الحقول سيضغط على زر تسجيل وستعمل هذه الميثود
        @FXML
    private void RegesterButtonAction(ActionEvent event) throws IOException {
        if(NewAccountUsernameField.getText().isEmpty() ||
                NewAccountPhNopasswordField.getText().isEmpty() ||
                NewAccountpasswordField.getText().isEmpty() ||
                NewAccountLocationField.getText().isEmpty())
        {
         NewAccountEmptyLabel.setText("لايمكن ان تكون الحقول فارغة");
         System.out.println("xxxxxxxxxxxxxx");
        }
        else
        {
            FXMLLoader fXMLloader = new FXMLLoader(getClass().getResource("DeliveryRequest.fxml")); //فتح الشاشة الثالث والتي فيها زر انشاء طلب جديد
            Parent root1 = (Parent) fXMLloader.load();
            Stage stage = new Stage();
            stage.setTitle("شاشة انشاء طلب جديد");
            stage.setScene(new Scene(root1));
            stage.show();
            
            NewClienttData.add(NewAccountUsernameField.getText());
            NewClienttData.add(NewAccountPhNopasswordField.getText());
            NewClienttData.add(NewAccountpasswordField.getText());
            NewClienttData.add(NewAccountLocationField.getText());
            
            
            //هنا بعد ان يسجل العميل بياناتنه سنحتاج لاسمه حتى نطبع على الشاشة التالية رسالة ترحبيبة تحمل اسمه مثل مرحبا افنان
        String userName = NewClienttData.get(0);   //استخرجنا اسم العميل من داخل حق الاسم وخزناه بداخل متغير
        DeliveryRequestController drc_obj = fXMLloader.getController(); //انشئنا اوبجكت من كلاس شاشة اشناء طلب جديد
        drc_obj.dispalyUserName(userName);               //استدعينا الميثود التي تطبع الرسالة الترحبيبة ومررنا لها اسم العميل
        }
        
           
    }
 //////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void initialize(URL url, ResourceBundle rb) {}
}
package deliveryPackage;
//هذا الكلاس يتحكم بتنفيذ واجهة تسجيل الدخول


import java.io.IOException;
import java.net.URL;
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
public class LoginFXMLController implements Initializable {
    //هنا صرحنا عن مجموعة من المتغيرات
    
    //clintName يخزن اسم المستخدم
    //clintPass يخزن بداخلة كلمة مرور المستخدم بعد تسجيل الدخول
    // userKind  يخزن بداخلة قيمة عندما يضغط المستخدم على زر العميل او السائق  في الصفحة الاولى 
    String ClintName, ClintPass ,userKindVar; 
    
    //هنا متتغيرين من نوع حقل الاول يخزن يحمل بداخله اسم المستخدم والثاني كلمة المرور وسنقوم باستخراج القيم من داخلهما
    @FXML TextField LoginUsernameField,LoginpasswordField;
    
    //هنا متغير من نوع ليبل يخزن بداخلة الجملة الترحيبية القادمة من كلاس الصفحة الاولى
    @FXML Label Titellabel, compltetInfoLabel;
 //////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////  
    //هذه الميثود التي تتحكم بالجملة الترحبيبة والتي استدعيناها في كلاس البداية
    public void dispalyTitellabel(String TitellabelArgs)
    {
        Titellabel.setText(TitellabelArgs);         //تطبع القيمة الخاصة بالجملة الترحبيبة على الشاشة
        Titellabel.setFont(Font.font("Tohama", 25)); //تحدد نوع الخط وحجمة
    }
 //////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////// 
    
    //هذة الميثود تستقبل نوع المستخدم هل هو عميل ام سائق
    public void dispalyUserKind(String userKindArgs)
    {
        this.userKindVar = userKindArgs;
    }
    
    //هذة الميثود تستقبل اسم المستخدم
     public void dispalyClintName(String ClintNameArgs)
    {
        this.ClintName = ClintNameArgs;
    }
     
     //هذة الميثود تستقبل كلمة المرور
    public void dispalyClintPass(String ClintPassArgs)
    {
        this.ClintPass = ClintPassArgs;
    }
 //////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////// 
    //هنا ميثود تعمل عند الضفط على زر دخول
        @FXML
    private void LoginButtonAction(ActionEvent event) throws IOException {
        if(LoginUsernameField.getText().isEmpty() || LoginpasswordField.getText().isEmpty()) //هنا نتأكد من ان حقول تسجيل الدخول ليست فارغة
        {
               //اذا كانت كل او احد الحقول فارغة تظهر هذه الرسالة
            compltetInfoLabel.setText("الرجاء التأكد من صحة البيانات المدخلة او انشاء حساب جديد");
        }
        else   //والا في حال ان الحقو ليست فارغة
        {
            if("clint".equals(userKindVar))  //هنا نتحقق من ان المستخدم الذي يحاول الدخول عميل
            {
                if(ClintName == LoginUsernameField.getText() && ClintPass == LoginpasswordField.getText())  //في حال كان عميل ناخذ اسمه وكلمة السر المخزنة عندما قام بأنشاء حساب ونقارنها بالقيم التي ادخلها في الحقول
                {
                    //اذا كانت القيم صحيحة ومتطابقة نفتح صفحة الترحيب التي تحتوي على زر انشاء طلب جديد
            FXMLLoader fXMLloader = new FXMLLoader(getClass().getResource("DeliveryRequest.fxml"));
            Parent root1 = (Parent) fXMLloader.load();
            Stage stage = new Stage();
            stage.setTitle("شاشة الترحيب ");
            stage.setScene(new Scene(root1));
            stage.show();
                }
                else  //اذا لم تكن البيانات التي ادخلها متطابقة نظهر له رسالة
                {
                    compltetInfoLabel.setText("الرجاء التأكد من صحة البيانات المدخلة او انشاء حساب جديد");
                }
            }
            else //هذة الس مالها داعي وجودها مهم وفائدتها لايوجد
            {
                
            }
        }
    }
 //////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////
    //لدينا الزر الثاني في شاشة تسجيل الدخول وهو زر اشناء مستخدم جديد
    
            @FXML
    private void NewAccountButtonAction(ActionEvent event) throws IOException {
        if("clint".equals(userKindVar))    //هنا نتأكد هل المستخدم عميل ام سائق حتى نفتح الواجهة المناسبة لكل واحد منهم
        { 
            //في حال كان عميل افتح شاشة انشاء عميل جديد التي لها حقول خاصة
        FXMLLoader fXMLloader = new FXMLLoader(getClass().getResource("NewAccount.fxml"));    
        Parent root1 = (Parent) fXMLloader.load();
        Stage stage = new Stage();
        stage.setTitle("شاشة انشاء عميل جديد");
        stage.setScene(new Scene(root1));
        stage.show();
        
        //هنا نستدعي ميثود تطبع جملة الترحيب على شاشة انشاء عميل جديد
        NewAccountController newac_obj = fXMLloader.getController();  //اوبجكت من كلاس انشاء حساب جديد للعميل
        newac_obj.dispalyTitellabel("تسجيل مستخدم جديد" );     //هنا استدعاء الميثود التي تعرض الرسالة الترحبيبة والتي هي موجودة في كلاس انشاء حساب اعميل ونمرر لها الرسالة الترحبيبة
        }
        
        //في حال ان المستخد ليس عميل سوف نفحص اذا كان 
        //نفس عمل الجمل العليا ولكن هنا نطبقها على شاشة انشاء سائق جديد
        else if("driver".equals(userKindVar))
        {
        FXMLLoader fXMLloader = new FXMLLoader(getClass().getResource("DriverAccountFXML.fxml"));    
        Parent root2 = (Parent) fXMLloader.load();
        Stage stage = new Stage();
        stage.setTitle("شاشة انشاء سائق جديد");
        stage.setScene(new Scene(root2));
        stage.show();
        
        DriverAccountFXMLController newac_obj2 = fXMLloader.getController();
        newac_obj2.dispalyTitellabel("تسجيل سائق جديد" );
        }
        else{}  //الس مالها داعي بس وجودها مهم
    }
 //////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////  
    @Override
    public void initialize(URL url, ResourceBundle rb) {}
}

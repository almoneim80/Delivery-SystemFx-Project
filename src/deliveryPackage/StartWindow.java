package deliveryPackage;

//هنا صفحة البداية
//الصفحة الاولى في النظام



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
 //////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////  
public class StartWindow extends Application {
    @Override
    public void start(Stage stage) throws Exception {          //هنا دالة البداية
        Parent root = FXMLLoader.load(getClass().getResource("StartFXML.fxml")); //تحدد هذة الجملة ملف ال اف اكس ام ال الذي سيشغله هذا الكلاس
        
        //هنا بعض خاصائص الشاشة
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("شاشة البداية");
        stage.show();
    }
 //////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////  
    public static void main(String[] args) {
        launch(args);
    }
}

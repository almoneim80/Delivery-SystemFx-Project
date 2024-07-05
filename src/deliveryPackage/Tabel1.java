package deliveryPackage;
//هذا الكلاس خاص بالجدول الموجود في واجهة الاستقبال
//يعرض هذا الجدول الطلبات السابقة ومعلومات عنها




import javafx.beans.property.SimpleStringProperty;  //تضمين لنوع البيانات سيمبل سترنق بروبيرتي
 ///////////////////////////////////////////////////////////////////////////////////////////
 //////////////////////////////////////////////////////////////////////////////////////////
//هنا عرفنا متغيرات بعدد اعمدة الجدول 
//يخزن كل متغير قيمة حقل 

public class Tabel1 {
    private int Id1;                               //يخزن رقم الطلب
    private SimpleStringProperty CurrentLocation1; //يخزن الموقع الحالي
    private SimpleStringProperty GoalLocation1;    //يخزن الموقع الهدف
    private String Date1;                          //يخزن التاريخ
    private String Price1;                         //يخزن سعر التوصيل
    private SimpleStringProperty Driver1;          //يخزن اسم السائق
 ///////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////
     //هنا عبارة عن كونستراكتور 
    //بحيث نمرر له القيم من كلاس التحكم
    //ويقوم هذا الكونستراكتور بتهيئة قيم للحقول  المقابلة
    
    public Tabel1(int Id1, final String CurrentLocation1, String GoalLocation1, String Date1, String Price1, String Driver1) {
        this.Id1 = Id1;                
        this.CurrentLocation1 = new SimpleStringProperty(CurrentLocation1) ;
        this.GoalLocation1 = new SimpleStringProperty(GoalLocation1);
        this.Date1 =Date1;
        this.Price1 =Price1;
        this.Driver1 =new SimpleStringProperty(Driver1);
    }
 ///////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////
    //هنا عبارة عن قيتتر لكل متغير 
    //تمكننا من الوصول لقيم المتغيرات
    
    public SimpleStringProperty CurrentLocation1Property() {
        return CurrentLocation1;
    }

    public SimpleStringProperty GoalLocation1Property() {
        return GoalLocation1;
    }
    
    public SimpleStringProperty Driver1Property() {
        return Driver1;
    }

    public int getId1() {
        return Id1;
    }

    public String getDate1() {
        return Date1;
    }

    public String getPrice1() {
        return Price1;
    }
}


import java.util.ArrayList;

public class Employee {
private String name;
private String eponymo;
private String phone;
private String email;
private ArrayList<Computer>kempl;

//συνάρτηση δημιουργίας
    public Employee(String name, String eponymo, String phone, String email) {
        this.name = name;
        this.eponymo = eponymo;
        this.phone = phone;
        this.email = email;
        kempl= new ArrayList<Computer>();
    }

   
    
 //μέθοδος επιστροφής του Eponymo
    public String getEponymo() {
        return eponymo;
    }//τέλος της μεθόδου getEponymo

    //μέθοδος ορισμού της Eponymo
    public void setEponymo(String eponymo) {
        this.eponymo = eponymo;
    }//  τέλος της μεθόδου setEponymo

   //μέθοδος επιστροφής του Name
       public String getName() {
        return name;
    }//τέλος της μεθόδου getName



    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

 public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override//επιστρέφει τη string αναπαράσταση της Employee
    public String toString() {
        return "Employee[" + "NAME=" + name + " - EPONYMO=" + eponymo +
                " - PHONE=" + phone + " - EMAIL=" + email + "]";
    }
    //μέθοδος που προσθέτει ενα υπολογιστή στον εξοπλισμό
    public void addExoplismos(Computer p){
        kempl.add(p);
    }

     //μέθοδος που αφαιρεί έναν υπολογιστή από τον εξοπλισμό
    public void removeExoplismos(Computer p){
        kempl.remove(p);
    }
// ArrayList του εξοπλισμού 
    public ArrayList<Computer> getExoplismos(){
        return kempl;
    }

    
}//τέλος της κλάσης Employee


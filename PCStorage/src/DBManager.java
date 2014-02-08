
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

//κλάση DBManager για την επικοινωνία με τη βάση δεδομένων(ΒΔ)
public class DBManager {
	
	//Ερωτήματα Εισαγωγής
        private PreparedStatement insertEmployee;
   
    //Δημιουργεί μία insert που προσθέτει μία νέα καταχώρηση υπαλλήλου βάση δεδομένων
    //κάθε ? αντιστοιχεί σε ένα χαρακτηριστικό του υπαλλήλου
        insertEmployee = dBconnection.prepareStatement("INSERT INTO ERGASIA3.EMPLOYEE VALUES(?,?,?,?)");
        
        //ΠΡΟΣΩΠΙΚΟ

        //Μέθοδος για την εισαγωγή του προσωπικού στη ΒΔ
        public void storeEmployee(Employee k){
            try {
                insertEmployee.setString(1, k.getPhone());
                insertEmployee.setString(2, k.getName());
                insertEmployee.setString(3, k.getEponymo());
                insertEmployee.setString(4, k.getEmail());

                            insertEmployee.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }    
        
        
    }
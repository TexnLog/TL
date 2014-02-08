
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

//κλάση DBManager για την επικοινωνία με τη βάση δεδομένων(ΒΔ)
public class DBManager {
	private String database = "//localhost:1527/pcstorage_db"; // το όνομα της ΒΔ που δημιουργήσαμε
    private String user = "storage_mgr";
    private String password = "test123";
    private String driver = "org.apache.derby.jdbc.ClientDriver";
    private String connString = "jdbc:derby:";
    private Connection dBconnection; //διαχειρίζεται τη σύνδεση με τη ΒΔ.
    private Statement statement;
    
	//Ερωτήματα Εισαγωγής
        private PreparedStatement insertEmployee;
   
   
   // Ερωτήματα Ανάκτησης
        private PreparedStatement readAllEmployees;
        private PreparedStatement readEmployee;
     
    //Δημιουργεί μία insert που προσθέτει μία νέα καταχώρηση υπαλλήλου βάση δεδομένων
    //κάθε ? αντιστοιχεί σε ένα χαρακτηριστικό του υπαλλήλου
        insertEmployee = dBconnection.prepareStatement("INSERT INTO pcstorage_db.EMPLOYEE VALUES(?,?,?,?)");
    
        //Ανάκτηση Υπαλληλλων από τη βάση δεδομένων
        readAllEmployees = dBconnection.prepareStatement("SELECT * FROM pcstorage_db.EMPLOYEE");
        readEmployee = dBconnection.prepareStatement("SELECT * FROM pcstorage_db.EMPLOYEE" +
         " WHERE pcstorage_db.EMPLOYEE.PHONE = ?");
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
        //Μέθοδος για την ανάκτηση όλων των υπαλλήλων
        public ArrayList<Employee> readAllEmployees() {

              //δημιουργώ ArrayList από employees
            ArrayList<Employee> employees = new ArrayList<Employee>();

            try {
                ResultSet rs = readAllEmployees.executeQuery();
                while(rs.next()){
                    Employee k = new Employee(
                            rs.getString(2), rs.getString(3),
                             rs.getString(1), rs.getString(4)
                            );
                    employees.add(k);
                }
                return employees;
            } catch (SQLException ex) {
                Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }

        //μέθοδος για την ανάκτηση ενός συγκεκριμένου υπαλλήλου
        public Employee readEmployee(String phone) {//αναφορά στο πρωτεύον κλειδί phone
            try {
                readEmployee.setString(1, phone);
                ResultSet rs = readEmployee.executeQuery();
                if(rs.next()){
                     Employee k = new Employee(
                            rs.getString(2), rs.getString(3),
                            rs.getString(1), rs.getString(4)
                            );
                    return k;
                }//τέλος if
            } catch (SQLException ex) {
                Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }
        
    }
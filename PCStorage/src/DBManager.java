
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
    private PreparedStatement insertComputer;
    private PreparedStatement insertEmployee;
    private PreparedStatement insertXrewsh;   
   
    	// Ερωτήματα Ανάκτησης
    private PreparedStatement readAllComputers;
    private PreparedStatement readComputer;
    private PreparedStatement readAllEmployees;
    private PreparedStatement readEmployee;
    private PreparedStatement readAllXrewshs;
    private PreparedStatement readXrewsh_ByComputer;
    private PreparedStatement readFreeComputers;
	
		// Ερωτήματα διαγραφής
    private PreparedStatement deleteEmployee;
    private PreparedStatement deleteXrewsh;
        
    
    public DBManager() {
        try {
           
            Class.forName(driver);
            // Σύνδεση με τη βάση δεδομένων
            dBconnection = DriverManager.getConnection(connString + database, user, password);
            statement = dBconnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

            //Δημιουργεί μία insert που προσθέτει μία νέα καταχώρηση υπολογιστή στη βάση δεδομένων
            // κάθε ? αντιστοιχεί σε ένα στοιχείο του υπολογιστή
            insertComputer = dBconnection.prepareStatement("INSERT INTO pcstorage_db.COMPUTER "
            											  + "VALUES(?,?,?,?,?,?,?,?)");        	

            //Δημιουργεί μία insert που προσθέτει μία νέα καταχώρηση υπαλλήλου βάση δεδομένων
            //κάθε ? αντιστοιχεί σε ένα χαρακτηριστικό του υπαλλήλου
            insertEmployee = dBconnection.prepareStatement("INSERT INTO pcstorage_db.EMPLOYEE VALUES(?,?,?,?)");
            
            //Εισαγωγή Χρεώσεων στη βάση δεδομένων
            insertXrewsh = dBconnection.prepareStatement("INSERT INTO pcstorage_db.XREWSH VALUES(?,?)");            
            
            //Ανάκτηση Υπολογιστών από τη βάση δεδομένων          
            readAllComputers = dBconnection.prepareStatement("SELECT * FROM pcstorage_db.COMPUTER");
            readComputer = dBconnection.prepareStatement("SELECT * "
            											+ "FROM pcstorage_db.COMPUTER" 
            											+" WHERE pcstorage_db.COMPUTER.SERIALNUMBER = ?");            
            
            //Ανάκτηση μόνο των διαθέσιμων υπολογιστών
            readFreeComputers = dBconnection.prepareStatement("SELECT * "
					+ "FROM pcstorage_db.COMPUTER "
					+ "WHERE pcstorage_db.COMPUTER.SERIALNUMBER NOT IN "
						+ "(SELECT pcstorage_db.XREWSH.SERIALNUMBER "
						+  "FROM pcstorage_db.XREWSH)");
               
            //Ανάκτηση Υπαλληλλων από τη βάση δεδομένων
            readAllEmployees = dBconnection.prepareStatement("SELECT * "
            												+"FROM pcstorage_db.EMPLOYEE");
   
            readEmployee = dBconnection.prepareStatement("SELECT * "
            											+"FROM pcstorage_db.EMPLOYEE" +
            											" WHERE pcstorage_db.EMPLOYEE.PHONE = ?");

            //Ανάκτηση χρεώσεων από τη βάση δεδομένων
            readAllXrewshs = dBconnection.prepareStatement("SELECT * "
            											 + "FROM pcstorage_db.XREWSH");
            
            readXrewsh_ByComputer = dBconnection.prepareStatement("SELECT * FROM pcstorage_db.XREWSH "
            													+ "WHERE pcstorage_db.XREWSH.SERIALNUMBER = ?");
            
            // Διαγραφή Υπαλληλων από τη βάση δεδομένων
            deleteEmployee = dBconnection.prepareStatement("DELETE FROM pcstorage_db.EMPLOYEE"
            											+ " WHERE pcstorage_db.EMPLOYEE.PHONE = ?");

            //Διαγραφή Χρεώσεων από τη βάση δεδομένων
            deleteXrewsh = dBconnection.prepareStatement("DELETE FROM pcstorage_db.XREWSH "
                    									+ "WHERE pcstorage_db.XREWSH.SERIALNUMBER = ?");

            
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }        
        
    // Για κάθε ερώτημα που προετοιμάσαμε δημιουργούμε μία μέθοδο

    //ΥΠΟΛΟΓΙΣΤΕΣ

	    //Μέθοδος για την αποθήκευση των υπολογιστών στη ΒΔ
	    public void storeComputer(Computer P){
	        try {
	            //το 1 αντιστοιχεί στο serialNumber του υπολογιστή
	            insertComputer.setString(1, P.getSerialNumber());
	             //το 2 αντιστοιχεί στην Etiketa του υπολογιστή
	            insertComputer.setString(2, P.getEtiketa());
	           //το 3 αντιστοιχεί στο model του υπολογιστή
	            insertComputer.setString(3, P.getModel());
	             //το 4 αντιστοιχεί στο perigrafi του υπολογιστή
	            insertComputer.setString(4, P.getPerigrafi());
	             //το 5 αντιστοιχεί στο typos του υπολογιστή
	            insertComputer.setString(5, P.getTypos());
	             //το 6 αντιστοιχεί στη cpu του υπολογιστή
	            insertComputer.setInt(6, P.getCpu());
	             //το 7 αντιστοιχεί στη ram του υπολογιστή
	            insertComputer.setInt(7, P.getRam());
	             //το 8 αντιστοιχεί στο disk του υπολογιστή
	            insertComputer.setInt(8, P.getDisk());
	
	            insertComputer.executeUpdate();
	        } catch (SQLException ex) {
	            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }
	
	    //Μέθοδος για την ανάκτηση όλων των υπολογιστών
	    public ArrayList<Computer> readAllComputers() {
	
	        //δημιουργώ ArrayList από computers
	                ArrayList<Computer> computers = new ArrayList<Computer>();
	        try {
	
	            ResultSet rs = readAllComputers.executeQuery();
	            while(rs.next()){
	                Computer p = new Computer(
	                        rs.getString(1), rs.getString(2),
	                        rs.getString(3), rs.getString(4),
	                        rs.getString(5), rs.getInt(6),
	                        rs.getInt(7), rs.getInt(8)
	                        );
	                computers.add(p);
	            }//τέλος while
	            return computers;
	        } //  τέλος try
	        catch (SQLException ex) {
	            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
	        }//τέλος catch
	        return null;
	    }//τέλος μεθόδου
	
	    //Μέθοδος για την ανάκτηση ενός συγκεκριμένου υπολογιστή
	    public Computer readComputer(String serialNumber) {
	        try {
	            readComputer.setString(1, serialNumber);
	
	            ResultSet rs = readComputer.executeQuery();
	            if(rs.next()){
	                Computer p = new Computer(
	                        rs.getString(1), rs.getString(2),
	                        rs.getString(3), rs.getString(4),
	                        rs.getString(5), rs.getInt(6),
	                        rs.getInt(7), rs.getInt(8)
	                        );
	                return p;
	            }//τέλος if
	        } catch (SQLException ex) {
	            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
	        }//τέλος catch
	        return null;
	    }//τέλος μεθόδου   
	    
		//μέθοδος για την ανάκτηση όλων των διαθέσιμων υπολογιστών
		public ArrayList<Computer> readFreeComputers() {
		    //δημιουργία ArrayList  με τους διαθέσιμους υπολογιστές
		    ArrayList<Computer> free = new ArrayList<Computer>();
		
		            try {
		        ResultSet rs = readFreeComputers.executeQuery();
		        while(rs.next()){
		            Computer p = new Computer(
		                    rs.getString(1), rs.getString(2),
		                    rs.getString(3), rs.getString(4),
		                    rs.getString(5), rs.getInt(6),
		                    rs.getInt(7), rs.getInt(8)
		                    );
		            free.add(p);//προσθέτει τους διαθέσιμους υπολογιστές
		        }
		        return free;//επιστρέφει τους διαθέσιμους υπολογιστές
		    } catch (SQLException ex) {
		        Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
		    }//τέλος catch
		    return null;
		}
	
	
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
        
        //Μέθοδος για τη διαγραφή ενός συγκεκριμένου υπαλλήλου
        public void deleteEmployee(String phone) {

                    try {
                deleteEmployee.setString(1, phone);
                deleteEmployee.execute();
            } catch (SQLException ex) {
                Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    

	//ΧΡΕΩΣΕΙΣ
	
		//Μέθοδος για την αποθήκευση των χρεωμένων υπολογιστών στη ΒΔ
		public void storeXrewsh(String phone, String serialNumber){
		    try {
		        insertXrewsh.setString(1, phone);
		        insertXrewsh.setString(2, serialNumber);
		        insertXrewsh.executeUpdate();
		    }//τέλος try
		    catch (SQLException ex) {
		        Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
		    }//τέλος catch
		}//τέλος μεθόδου storeXrewsh
		
		//μέθοδος για τη διαγραφή μιας χρέωσης
		public void deleteXrewsh(String serialNumber) {
		    try {
		        deleteXrewsh.setString(1, serialNumber);
		        deleteXrewsh.execute();
		    } catch (SQLException ex) {
		        Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
		    }//τέλος catch
		}//τέλος μεθόδου

}//τέλος κλάσης



import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

//����� DBManager ��� ��� ����������� �� �� ���� ���������(��)
public class DBManager {
private String database = "//localhost:1527/pcstorage_db"; // �� ����� ��� �� ��� �������������
    private String user = "storage_mgr";
    private String password = "test123";
    private String driver = "org.apache.derby.jdbc.ClientDriver";
    private String connString = "jdbc:derby:";
    private Connection dBconnection; //������������� �� ������� �� �� ��.
    private Statement statement;

    	//��������� ���������
    private PreparedStatement insertComputer;
    private PreparedStatement insertXrewsh;
    
       // ��������� ���������
    private PreparedStatement readAllComputers;
    private PreparedStatement readComputer;
    private PreparedStatement readFreeComputers;
    private PreparedStatement readAllXrewshs;
    private PreparedStatement readXrewsh_ByComputer;   

    //��������� ���������
    private PreparedStatement deleteXrewsh;    

    public DBManager() {
        try {
           
            Class.forName(driver);
            // ������� �� �� ���� ���������
            dBconnection = DriverManager.getConnection(connString + database, user, password);
            statement = dBconnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

            //���������� ��� insert ��� ��������� ��� ��� ���������� ���������� ��� ���� ���������
            // ���� ? ����������� �� ��� �������� ��� ����������
            insertComputer = dBconnection.prepareStatement("INSERT INTO pcstorage_db.COMPUTER "
            											 + "VALUES(?,?,?,?,?,?,?,?)");

            //�������� ����������� ��� �� ���� ���������
            readAllComputers = dBconnection.prepareStatement("SELECT * FROM pcstorage_db.COMPUTER");
            readComputer = dBconnection.prepareStatement("SELECT * "
            											+ "FROM pcstorage_db.COMPUTER" 
            											+" WHERE pcstorage_db.COMPUTER.SERIALNUMBER = ?");

            //�������� ����������� ��� ��� ����� ���������
            readFreeComputers = dBconnection.prepareStatement("SELECT * "
                    										+ "FROM pcstorage_db.COMPUTER "
                    										+ "WHERE pcstorage_db.COMPUTER.SERIALNUMBER NOT IN "
                    											+ "(SELECT pcstorage_db.XREWSH.SERIALNUMBER "
                     											+ " FROM pcstorage_db.XREWSH)");

            //�������� �������� ��� ���� ���������
            insertXrewsh = dBconnection.prepareStatement("INSERT INTO pcstorage_db.XREWSH "
            											+ "VALUES(?,?)");

            //�������� �������� ��� �� ���� ���������
            	//���� ��� ��������
            readAllXrewshs = dBconnection.prepareStatement("SELECT *"
            											+ " FROM pcstorage_db.XREWSH");
            	//��� ����������
            readXrewsh_ByComputer = dBconnection.prepareStatement("SELECT * "
            													+ "FROM pcstorage_db.XREWSH "
            													+ "WHERE pcstorage_db.XREWSH.SERIALNUMBER = ?");
            
            //�������� �������� ��� �� ���� ���������
            deleteXrewsh = dBconnection.prepareStatement("DELETE FROM pcstorage_db.XREWSH "
                    									+ "WHERE pcstorage_db.XREWSH.SERIALNUMBER = ?");
            
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }

    // ��� ���� ������� ��� ������������� ������������ ��� ������

    //�����������

    //������� ��� ��� ���������� ��� ����������� ��� ��
    public void storeComputer(Computer P){
        try {
            //�� 1 ����������� ��� serialNumber ��� ����������
            insertComputer.setString(1, P.getSerialNumber());
             //�� 2 ����������� ���� Etiketa ��� ����������
            insertComputer.setString(2, P.getEtiketa());
           //�� 3 ����������� ��� model ��� ����������
            insertComputer.setString(3, P.getModel());
             //�� 4 ����������� ��� perigrafi ��� ����������
            insertComputer.setString(4, P.getPerigrafi());
             //�� 5 ����������� ��� typos ��� ����������
            insertComputer.setString(5, P.getTypos());
             //�� 6 ����������� ��� cpu ��� ����������
            insertComputer.setInt(6, P.getCpu());
             //�� 7 ����������� ��� ram ��� ����������
            insertComputer.setInt(7, P.getRam());
             //�� 8 ����������� ��� disk ��� ����������
            insertComputer.setInt(8, P.getDisk());

            insertComputer.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //������� ��� ��� �������� ���� ��� �����������
    public ArrayList<Computer> readAllComputers() {

        //��������� ArrayList ��� computers
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
            }//����� while
            return computers;
        } //  ����� try
        catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }//����� catch
        return null;
    }//����� �������

    //������� ��� ��� �������� ���� ������������� ����������
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
            }//����� if
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }//����� catch
        return null;
    }//����� �������

    //������� ��� ��� �������� ���� ��� ���������� �����������
    public ArrayList<Computer> readFreeComputers() {
        //���������� ArrayList  �� ���� ����������� �����������
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
                free.add(p);//��������� ���� ����������� �����������
            }
            return free;//���������� ���� ����������� �����������
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }//����� catch
        return null;
    }

    
    //��������

    //������� ��� ��� ���������� ��� ��������� ����������� ��� ��
    public void storeXrewsh(String phone, String serialNumber){
        try {
            insertXrewsh.setString(1, phone);
            insertXrewsh.setString(2, serialNumber);
            insertXrewsh.executeUpdate();
        }//����� try
        catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }//����� catch
    }//����� ������� storeXrewsh
    
    //������� ��� �� �������� ���� �������
    public void deleteXrewsh(String serialNumber) {
        try {
            deleteXrewsh.setString(1, serialNumber);
            deleteXrewsh.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }//����� catch
    }//����� �������
    
}//����� ������


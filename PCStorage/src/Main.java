import java.util.ArrayList;
import java.util.List;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DBManager m = new DBManager();
		
		ArrayList<Computer> LC = m.readAllComputers();
		
		listResult(LC);
	}

    public static void listResult(List<?> result){
    	
    	int rows =  result.size();
    	
    	if(rows > 0){
    		System.out.println("Retrieved \""+rows+"\" Rows:");
    		for (Object o : result) {
    			System.out.println("\t"+o);
    		}
    		System.out.println();
    	}else
    		System.out.println("NO Rows found. Retrieved \""+rows+"\" Rows.\n");
    }
}

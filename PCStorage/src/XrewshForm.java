	import java.util.ArrayList;
	import javax.swing.DefaultListModel;
	import javax.swing.JOptionPane;

	public class XrewshForm extends javax.swing.JFrame {

		 // Variables declaration - do not modify//GEN-BEGIN:variables
	    private javax.swing.JButton jButton1;
	    private javax.swing.JButton jButton2;
	    private javax.swing.JButton jButton3;
	    private javax.swing.JLabel jLabel1;
	    private javax.swing.JLabel jLabel2;
	    private javax.swing.JLabel jLabel3;
	    DefaultListModel employeemodel = new DefaultListModel();
	    private javax.swing.JList jList1;
	    DefaultListModel freemodel = new DefaultListModel();
	    private javax.swing.JList jList2;
	    DefaultListModel xrewmenomodel = new DefaultListModel();
	    private javax.swing.JList jList3;
	    private javax.swing.JPanel jPanel1;
	    private javax.swing.JScrollPane jScrollPane1;
	    private javax.swing.JScrollPane jScrollPane2;
	    private javax.swing.JScrollPane jScrollPane3;
	    // End of variables declaration//GEN-END:variables
	    
	    //Anafores se alles klaseis
	    ArrayList<Employee> employees; //δημιουργία λίστας με όλους τους υπαλλήλους
	    ArrayList<Computer> free; //δημιουργία λίστας με τους διαθέσιμους υπολογιστές
	    ArrayList<Computer> xrewmeno; //δημιουργία λίστας με τους δεσμευμένους υπολογιστές
	    private DBManager db; //αναφορά στην κλάση σύνδεσης με τη βάση δεδομένων
	    private MainForm parent; //αναφορά στη αρχική φόρμα

	    public XrewshForm(MainForm parent, DBManager db) {
	        int i;
	        initComponents();
	        this.db = db;
	        this.parent = parent;

	        //ανάγνωση όλων των υπαλλήλων από τη ΒΔ και εμφάνιση τους στη λίστα
	        employees = db.readAllEmployees();
	        if(employees != null)
	            for(i = 0; i < employees.size(); i++)
	                employeemodel.add(i, employees.get(i).toString());
	        //ανάγνωση όλων των διαθέσιμων υπολογιστών από τη ΒΔ και εμφάνιση τους στη λίστα
	        free = db.readFreeComputers();
	        if(free != null)
	            for(i = 0; i < free.size(); i++)
	                freemodel.add(i, free.get(i).toString());
	    }//τέλος μεθόδου XrewshForm

	    
		 /** This method is called from within the constructor to
	     * initialize the form.
	     * WARNING: Do NOT modify this code. The content of this method is
	     * always regenerated by the Form Editor.
	     */
	    @SuppressWarnings("unchecked")
	    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	    private void initComponents() {

	        jPanel1 = new javax.swing.JPanel();
	        jLabel1 = new javax.swing.JLabel();
	        jScrollPane1 = new javax.swing.JScrollPane();
	        jList1 = new javax.swing.JList(employeemodel);
	        jScrollPane2 = new javax.swing.JScrollPane();
	        jList2 = new javax.swing.JList(freemodel);
	        jScrollPane3 = new javax.swing.JScrollPane();
	        jList3 = new javax.swing.JList(xrewmenomodel);
	        jLabel2 = new javax.swing.JLabel();
	        jLabel3 = new javax.swing.JLabel();
	        jButton1 = new javax.swing.JButton();
	        jButton2 = new javax.swing.JButton();
	        jButton3 = new javax.swing.JButton();

	        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

	        jPanel1.setBackground(new java.awt.Color(255, 204, 102));

	        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
	        jLabel1.setText("Χρέωση/Αποδέσμευση Υπολογιστών σε Προσωπικό");
	        
	        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
	        jPanel1.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addGap(80, 80, 80)
	                .addComponent(jLabel1)
	                .addContainerGap(126, Short.MAX_VALUE))
	        );
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
	        );

	        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
	            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
	                jList1ValueChanged(evt);
	            }
	        });
	        jScrollPane1.setViewportView(jList1);

	        jScrollPane2.setViewportView(jList2);

	        jScrollPane3.setViewportView(jList3);

	        jLabel2.setText("Διαθέσιμοι Υπολογιστές");

	        jLabel3.setText("Χρεωμένοι Υπολογιστές");

	        jButton1.setText("Χρέωση->");
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton1ActionPerformed(evt);
	            }
	        });

	        jButton2.setText("<-Αποδέσμευση");
	        jButton2.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton2ActionPerformed(evt);
	            }
	        });

	        jButton3.setText("Επιστροφή");
	        jButton3.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton3ActionPerformed(evt);
	            }
	        });

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
	                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
	                        .addGap(18, 18, 18)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
	                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                        .addGap(29, 29, 29)
	                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                .addContainerGap())
	            .addGroup(layout.createSequentialGroup()
	                .addGap(37, 37, 37)
	                .addComponent(jLabel2)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 214, Short.MAX_VALUE)
	                .addComponent(jLabel3)
	                .addGap(37, 37, 37))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(18, 18, 18)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel2)
	                    .addComponent(jLabel3))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
	                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                        .addGroup(layout.createSequentialGroup()
	                            .addComponent(jButton1)
	                            .addGap(18, 18, 18)
	                            .addComponent(jButton2))
	                        .addGroup(layout.createSequentialGroup()
	                            .addGap(3, 3, 3)
	                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
	                .addGap(19, 19, 19)
	                .addComponent(jButton3)
	                .addContainerGap())
	        );

	        pack();
	    }// </editor-fold>//GEN-END:initComponents
	    
	    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
	        // TODO add your handling code here:
	        int i;
	        //βρίσκω τον επιλεγμένο υπάλληλο
	        int selected = jList1.getSelectedIndex();
	        //ανάγνωση των χρεωμένων υπολογιστών στο συγκεκριμένο υπάλληλο
	        xrewmeno = db.readXrewsh_ByEmployee(employees.get(selected).getPhone());
	        //διαγράφει από τη λίστα όλους τους υπολογιστές
	        xrewmenomodel.removeAllElements();
	        //Προσθέτει στη λίστα τους υπολογιστές του υπαλλήλου
	        if(xrewmeno != null)
	            for(i = 0; i < xrewmeno.size(); i++)
	                xrewmenomodel.add(i, xrewmeno.get(i).toString());

	    }//GEN-LAST:event_jList1ValueChanged

	    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
	        // TODO add your handling code here:
	        //βρίσκει τον επιλεγμένο υπάλληλο
	        int selectedEmployee = jList1.getSelectedIndex();
	        //βρίσκει επιλεγμένο διαθέσιμο υπολογιστή
	        int selectedFreeComputer = jList2.getSelectedIndex();
	        int thesi;
	        {
	            //αποθήκευση της χρέωσης
	            db.storeXrewsh(employees.get(selectedEmployee).getPhone(), free.get(selectedFreeComputer).getSerialNumber());
	            //προσθήκη του υπολογιστή στη λίστα του υπαλλήλου
	            employees.get(selectedEmployee).addExoplismos(free.get(selectedFreeComputer));
	            //βρίσκουμε την τελευταία θέση των χρεωμένων υπολογιστών
	            thesi = xrewmenomodel.size();
	            if(xrewmenomodel == null)
	                thesi = 0;
	            //προσθέτουμε στη λίστα με τους χρεωμένους υπολογιστές τον υπολογιστή αυτό
	            xrewmenomodel.add(thesi, free.get(selectedFreeComputer).toString());
	            //προσθέτουμε στους χρεωμένους υπολογιστές τον υπολογιστή αυτό
	            xrewmeno.add(free.get(selectedFreeComputer));
	            //διαγράφουμε τον υπολογιστή από τη λίστα με τους διαθέσιμους υπολογιστές
	            free.remove(free.get(selectedFreeComputer));
	            freemodel.remove(selectedFreeComputer);
	           }

	    }//GEN-LAST:event_jButton1ActionPerformed
	    
	    //χειρίζεται την κλήση όταν γίνει κλικ στο jButton2
	    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
	        // TODO add your handling code here:
	        //Επιλεγμένος υπολογιστής
	        int selected = jList3.getSelectedIndex();
	        //Επιλεγμένος υπαλληλος
	        int selectedEmployee = jList1.getSelectedIndex();
	        int thesi;

	        //αν δεν έχει επιλεγεί κάποιος υπολογιστής
	        if(selected == -1)
	         // εμφανιζουμε μήνυμα για να επιλέξει έναν δεσμευμένο υπολογιστή από τη λίστα ο χρήστης
	            JOptionPane.showMessageDialog(this, "Επιλέξτε ένα δεσμευμένο υπολογιστή από την αντίστοιχη λίστα");
	        //αλλιώς αν έχει επιλεγεί υπολογιστή αποδεσμεύεται
	        else{
	            //διαγραφή της χρέωσης από τη ΒΔ
	            db.deleteXrewsh(xrewmeno.get(selected).getSerialNumber());
	            //διαγραφή του υπολογιστή από τη λίστα του υπαλλήλου
	            employees.get(selectedEmployee).removeExoplismos(xrewmeno.get(selected));
	            //διαγραφή της χρέωσης από τη λίστα
	            xrewmenomodel.remove(selected);
	                    thesi = freemodel.size();
	            if(freemodel == null)
	                thesi = 0;
	            //προσθήκη του υπολογιστή στη λίστα με τους διαθέσιμους υπολογιστές
	            freemodel.add(thesi, xrewmeno.get(selected).toString());
	            //διαγραφή της χρέωσης από τη λίστα
	            xrewmeno.remove(selected);
	        }

	    }//GEN-LAST:event_jButton2ActionPerformed
	    
	    //χειρίζεται την κλήση όταν γίνει κλικ στο jButton3
	    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
	        // TODO add your handling code here:
	        //Ενεργοποίησε την αρχική φόρμα
	        parent.setEnabled(true);
	        
	        //Απελευθέρωσε την τρέχουσα φόρμα
	        dispose();

	    }//GEN-LAST:event_jButton3ActionPerformed
	    
	}
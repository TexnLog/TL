public class Printer extends Exoplismos {
private String typos;
private int ppm;

//συνάρτηση δημιουργίας
    public Printer(String etiketa, String serialNumber, String model,
            String perigrafi, String typos, int ppm) {
        super(etiketa, serialNumber, model, perigrafi);
        this.typos = typos;
        this.ppm = ppm;
    }
//μέθοδος επιστροφής του Ppm
    public int getPpm() {
        return ppm;
    }//τέλος της μεθόδου getppm

     //μέθοδος ορισμού του Ppm
    public void setPpm(int ppm) {
        this.ppm = ppm;
    }//τέλος της μεθόδου setPpm

    public String getTypos() {
        return typos;
    }

    public void setTypos(String typos) {
        this.typos = typos;
    }

    @Override//επιστρέφει τη string αναπαράσταση  του Printer
    public String toString() {
        return "Printer[" + super.toString() + " - TYPOS=" + typos + " - PPM=" + ppm + "]";
    }

   }//τέλος της κλάσης  Printer
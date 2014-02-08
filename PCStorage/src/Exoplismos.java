

public class Exoplismos {
private String etiketa;
private String serialNumber;
private String model;
private String perigrafi;

//συνάρτηση δημιουργίας
    public Exoplismos(String etiketa, String serialNumber, String model, String perigrafi) {
        this.etiketa = etiketa;
        this.serialNumber = serialNumber;
        this.model = model;
        this.perigrafi = perigrafi;
    }
//μέθοδος επιστροφής της ετικέτας
    public String getEtiketa() {
        return etiketa;
    }//τέλος της μεθόδου getEtiketa

    //μέθοδος ορισμού της ετικέτας
    public void setEtiketa(String etiketa) {
        this.etiketa = etiketa;
    }
//μέθοδος επιστροφής της ετικέτας
    public String getModel() {
        return model;
    }//τέλος της μεθόδου getEtiketa

    //μέθοδος ορισμού της ετικέτας
    public void setModel(String model) {
        this.model = model;
    }//τέλος της μεθόδου settEtiketa

//μέθοδος επιστροφής της περιγραφής
    public String getPerigrafi() {
        return perigrafi;
    }//τέλος της μεθόδου getPerigrafi

    //μέθοδος ορισμού της περιγραφής
    public void setPerigrafi(String perigrafi) {
        this.perigrafi = perigrafi;
    }//τέλος της μεθόδου getEtiketa

//μέθοδος επιστροφής του SerialNumber
    public String getSerialNumber() {
        return serialNumber;
    }//τέλος της μεθόδου getSerialNumber

    //μέθοδος ορισμού του SerialNumber
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }//τέλος της μεθόδου set SerialNumber

    @Override //επιστρέφει ένα string της μορφής SERIALNUMBER=,- ETIKETA= , - MODEL= ,- PERIGRAFI=
    public String toString() {
        return "SERIALNUMBER=" + serialNumber + " - ETIKETA=" + etiketa +
                " - MODEL=" + model + " - PERIGRAFI=" + perigrafi;
    }//τέλος της μεθόδου toString

}//τέλος της κλάσης Exoplismos
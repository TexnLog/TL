
public class Othoni extends Exoplismos{
private String typos;
private float megethos;

//συνάρτηση δημιουργίας
    public Othoni(String etiketa, String serialNumber, String model,
    String perigrafi, String typos, float megethos) {
        super(etiketa, serialNumber, model, perigrafi);
        this.typos = typos;
        this.megethos = megethos;
    }
 //μέθοδος επιστροφής του Megethos
    public float getMegethos() {
        return megethos;
    }//τέλος της μεθόδου getMegethos

    //μέθοδος ορισμού της Megethos
    public void setMegethos(float megethos) {
        this.megethos = megethos;
    }//τέλος της μεθόδου setMegethos

     //μέθοδος επιστροφής του τύπου
    public String getTypos() {
        return typos;
    }//τέλος της μεθόδου getTypos

    //μέθοδος ορισμού του typos
    public void setTypos(String typos) {
        this.typos = typos;
    }//τέλος της μεθόδου setTypos

    @Override //επιστρέφει τη string αναπαράσταση της Othoni
    public String toString() {
        return "Othoni[" + super.toString() + " - TYPOS=" + typos +
                " - MEGETHOS=" + megethos + "]";
    }//τέλος της μεθόδου toString

}//τέλος της κλάσης  Othoni
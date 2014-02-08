public class Computer extends Exoplismos{
private String typos;
private int cpu;
private int ram;
private int disk;

//συνάρτηση δημιουργίας
    public Computer(String etiketa, String serialNumber, String model,
            String perigrafi, String typos, int cpu, int ram, int disk) {
        super(serialNumber, etiketa , model, perigrafi );
        this.typos = typos;
        this.cpu = cpu;
        this.ram = ram;
        this.disk = disk;
    }


    //μέθοδος επιστροφής του τύπου
    public String getTypos() {
        return typos;
    }//τέλος της μεθόδου getTypos

    //μέθοδος ορισμού του τύπου
    public void setTypos(String typos) {
        this.typos = typos;
    }//τέλος της μεθόδου setTypos

    //μέθοδος επιστροφής της Cpu
    public int getCpu() {
        return cpu;
    }//τέλος της μεθόδου getCpu

//μέθοδος ορισμού της Cpu
    public void setCpu(int cpu) {
        this.cpu = cpu;
    }//τέλος της μεθόδου setCpu

    //μέθοδος επιστροφής Disk
    public int getDisk() {
        return disk;
    }//τέλος της μεθόδου getDisk

    //μέθοδος ορισμού της Disk
    public void setDisk(int disk) {
        this.disk = disk;
    }//τέλος της μεθόδου setDisk

    //μέθοδος επιστροφής της Ram
    public int getRam() {
        return ram;
    }//τέλος της μεθόδου getRam

   //μέθοδος ορισμού της Ram
    public void setRam(int ram) {
        this.ram = ram;
    }//τέλος της μεθόδου setRam

    @Override //επιστρέφει τη string αναπαράσταση του Computer
    public String toString() {
        return "Computer[" + super.toString() + " - TYPOS=" + typos +
                " - CPU=" + cpu + " - RAM=" + ram + " - DISKOS=" + disk + "]";
    }//τέλος της μεθόδου toString

}//τέλος της κλάσης Computer
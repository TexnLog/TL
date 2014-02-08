public class Computer extends Exoplismos{
private String typos;
private int cpu;
private int ram;
private int disk;

//��������� �����������
    public Computer(String etiketa, String serialNumber, String model,
            String perigrafi, String typos, int cpu, int ram, int disk) {
        super(serialNumber, etiketa , model, perigrafi );
        this.typos = typos;
        this.cpu = cpu;
        this.ram = ram;
        this.disk = disk;
    }


    //������� ���������� ��� �����
    public String getTypos() {
        return typos;
    }//����� ��� ������� getTypos

    //������� ������� ��� �����
    public void setTypos(String typos) {
        this.typos = typos;
    }//����� ��� ������� setTypos

    //������� ���������� ��� Cpu
    public int getCpu() {
        return cpu;
    }//����� ��� ������� getCpu

//������� ������� ��� Cpu
    public void setCpu(int cpu) {
        this.cpu = cpu;
    }//����� ��� ������� setCpu

    //������� ���������� Disk
    public int getDisk() {
        return disk;
    }//����� ��� ������� getDisk

    //������� ������� ��� Disk
    public void setDisk(int disk) {
        this.disk = disk;
    }//����� ��� ������� setDisk

    //������� ���������� ��� Ram
    public int getRam() {
        return ram;
    }//����� ��� ������� getRam

   //������� ������� ��� Ram
    public void setRam(int ram) {
        this.ram = ram;
    }//����� ��� ������� setRam

    @Override //���������� �� string ������������ ��� Computer
    public String toString() {
        return "Computer[" + super.toString() + " - TYPOS=" + typos +
                " - CPU=" + cpu + " - RAM=" + ram + " - DISKOS=" + disk + "]";
    }//����� ��� ������� toString

}//����� ��� ������ Computer
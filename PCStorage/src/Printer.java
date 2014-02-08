public class Printer extends Exoplismos {
private String typos;
private int ppm;

//��������� �����������
    public Printer(String etiketa, String serialNumber, String model,
            String perigrafi, String typos, int ppm) {
        super(etiketa, serialNumber, model, perigrafi);
        this.typos = typos;
        this.ppm = ppm;
    }
//������� ���������� ��� Ppm
    public int getPpm() {
        return ppm;
    }//����� ��� ������� getppm

     //������� ������� ��� Ppm
    public void setPpm(int ppm) {
        this.ppm = ppm;
    }//����� ��� ������� setPpm

    public String getTypos() {
        return typos;
    }

    public void setTypos(String typos) {
        this.typos = typos;
    }

    @Override//���������� �� string ������������  ��� Printer
    public String toString() {
        return "Printer[" + super.toString() + " - TYPOS=" + typos + " - PPM=" + ppm + "]";
    }

   }//����� ��� ������  Printer
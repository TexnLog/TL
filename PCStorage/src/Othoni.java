
public class Othoni extends Exoplismos{
private String typos;
private float megethos;

//��������� �����������
    public Othoni(String etiketa, String serialNumber, String model,
    String perigrafi, String typos, float megethos) {
        super(etiketa, serialNumber, model, perigrafi);
        this.typos = typos;
        this.megethos = megethos;
    }
 //������� ���������� ��� Megethos
    public float getMegethos() {
        return megethos;
    }//����� ��� ������� getMegethos

    //������� ������� ��� Megethos
    public void setMegethos(float megethos) {
        this.megethos = megethos;
    }//����� ��� ������� setMegethos

     //������� ���������� ��� �����
    public String getTypos() {
        return typos;
    }//����� ��� ������� getTypos

    //������� ������� ��� typos
    public void setTypos(String typos) {
        this.typos = typos;
    }//����� ��� ������� setTypos

    @Override //���������� �� string ������������ ��� Othoni
    public String toString() {
        return "Othoni[" + super.toString() + " - TYPOS=" + typos +
                " - MEGETHOS=" + megethos + "]";
    }//����� ��� ������� toString

}//����� ��� ������  Othoni
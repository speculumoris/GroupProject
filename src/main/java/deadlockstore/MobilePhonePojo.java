package deadlockstore;

public class MobilePhonePojo  {

    private double birimFiyat;
    private int indOrani;
    private static int stokMik;
    private Markalar markaInfo;

    private String urunAdi;
    private int hafizaInfo;
    private double ekranBoyutu;
    private double kameraMps;
    private int pilGucu;
    private int ram;
    private String renk;
    private int id;

    public MobilePhonePojo() {
    }

    public MobilePhonePojo(double birimFiyat, Markalar markaInfo, String urunAdi, int hafizaInfo, double ekranBoyutu, double kameraMps, int pilGucu, int ram, String renk) {
        this.birimFiyat = birimFiyat;
        this.markaInfo = markaInfo;
        this.urunAdi = urunAdi;
        this.hafizaInfo = hafizaInfo;
        this.ekranBoyutu = ekranBoyutu;
        this.kameraMps = kameraMps;
        this.pilGucu = 4000;
        this.ram = ram;
        this.renk = renk;
        this.indOrani=getIndOrani();
        stokMik=getStokMik()+1;
        this.id=getId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Markalar getMarkaInfo() {
        return markaInfo;
    }

    public void setMarkaInfo(Markalar markaInfo) {
        this.markaInfo = markaInfo;
    }

    public double getKameraMps() {
        return kameraMps;
    }

    public void setKameraMps(double kameraMps) {
        this.kameraMps = kameraMps;
    }

    public double getEkranBoyutu() {
        return ekranBoyutu;
    }

    public void setEkranBoyutu(double ekranBoyutu) {
        this.ekranBoyutu = ekranBoyutu;
    }

    public double getBirimFiyat() {
        return birimFiyat;
    }

    public void setBirimFiyat(double birimFiyat) {
        this.birimFiyat = birimFiyat;
    }

    public int getIndOrani() {
        return indOrani;
    }

    public void setIndOrani(int indOrani) {
        this.indOrani = indOrani;
    }

    public static int getStokMik() {
        return stokMik;
    }

    public static void setStokMik(int stokMika) {
       stokMik=stokMika;
    }

    public String getUrunAdi() {
        return urunAdi;
    }

    public void setUrunAdi(String urunAdi) {
        this.urunAdi = urunAdi;
    }

    public int getHafizaInfo() {
        return hafizaInfo;
    }

    public void setHafizaInfo(int hafizaInfo) {
        this.hafizaInfo = hafizaInfo;
    }

    public int getPilGucu() {
        return pilGucu;
    }

    public void setPilGucu(int pilGucu) {
        this.pilGucu = pilGucu;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getRenk() {
        return renk;
    }

    public void setRenk(String renk) {
        this.renk = renk;
    }

    @Override
    public String toString() {
        return
                "birimFiyat:" + birimFiyat +
                "| indOrani:" + indOrani +
                "| markaInfo:" + markaInfo +
                "| urunAdi:'" + urunAdi + '\'' +
                "| hafizaInfo:" + hafizaInfo +
                "| ekranBoyutu:" + ekranBoyutu +
                "| kameraMps:" + kameraMps +
                "| pilGucu:" + pilGucu +
                "| ram:" + ram +
                "| renk:'" + renk +
                "|stok miktarı:"+ stokMik+ "\n" ;
    }
}

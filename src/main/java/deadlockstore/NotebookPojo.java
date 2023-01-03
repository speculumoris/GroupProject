package deadlockstore;

public class NotebookPojo {
    private int urunId;
    private double birimFiyat;
    private int indirimOrani;
    private static int stokMiktari;
    private String urunAdi;
    private String markaInfo;
    private int ramNo;
    private int depolInfo;
    private double ekranB;
    private String renkN;

    public NotebookPojo() {
    }

    public NotebookPojo(String urunAdi,double birimFiyat,String markaInfo, int ramNo, int depolInfo, double ekranB, String renkN) {
        this.birimFiyat = birimFiyat;
        this.urunAdi = urunAdi;
        this.markaInfo = markaInfo;
        this.ramNo = ramNo;
        this.depolInfo = depolInfo;
        this.ekranB = ekranB;
        this.renkN=renkN;
        stokMiktari=getStokMiktari()+1;
        this.indirimOrani=getIndirimOrani();
        this.urunId=getUrunId();
    }

    public String getRenkN() {
        return renkN;
    }

    public void setRenkN(String renkN) {
        this.renkN = renkN;
    }

    public int getUrunId() {
        return urunId;
    }

    public void setUrunId(int urunId) {
        this.urunId = urunId;
    }

    public double getBirimFiyat() {
        return birimFiyat;
    }

    public void setBirimFiyat(double birimFiyat) {
        this.birimFiyat = birimFiyat;
    }

    public int getIndirimOrani() {
        return indirimOrani;
    }

    public void setIndirimOrani(int indirimOrani) {
        this.indirimOrani = indirimOrani;
    }

    public int getStokMiktari() {
        return stokMiktari;
    }

    public void setStokMiktari(int stokMiktari) {
        this.stokMiktari = stokMiktari;
    }

    public String getUrunAdi() {
        return urunAdi;
    }

    public void setUrunAdi(String urunAdi) {
        this.urunAdi = urunAdi;
    }

    public String getMarkaInfo() {
        return markaInfo;
    }

    public void setMarkaInfo(String markaInfo) {
        this.markaInfo = markaInfo;
    }

    public int getRamNo() {
        return ramNo;
    }

    public void setRamNo(int ramNo) {
        this.ramNo = ramNo;
    }

    public int getDepolInfo() {
        return depolInfo;
    }

    public void setDepolInfo(int depolInfo) {
        this.depolInfo = depolInfo;
    }

    public double getEkranB() {
        return ekranB;
    }

    public void setEkranB(double ekranB) {
        this.ekranB = ekranB;
    }

    @Override
    public String toString() {
        return
                "birimFiyat=" + birimFiyat +
                "| indirimOrani=" + indirimOrani +
                "| stokMiktari=" + stokMiktari +
                "| urunAdi='" + urunAdi + '\'' +
                "| markaInfo='" + markaInfo + '\'' +
                "| ramNo=" + ramNo +
                "| depolInfo=" + depolInfo +
                "| ekranB=" + ekranB +"\n";
    }
}

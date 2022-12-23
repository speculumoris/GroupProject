package deadlockstore;

public enum Markalar {
    //Samsung, Lenovo, Apple, Huawei, Casper, Asus, HP, Xiaomi, Monster
    APPLE(1000),
    SAMSUNG(1001),
    LENOVO(1002),
    HUAWEI(1003),
    CASPER(1004),
    ASUS(1005),
    HP(1006),
    XIAOMI(1007),
    MONSTER(1008);


    private final int id;

    public int getId() {
        return id;
    }

    private Markalar(int id){
        this.id=id;
    }



}

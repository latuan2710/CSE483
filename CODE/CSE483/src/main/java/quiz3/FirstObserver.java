package quiz3;

public class FirstObserver {
    public static void main(String[] args) {
        TGDD_519062697 s = new TGDD_519062697();

        Observer a = new DLMN_947837071();
        Observer b = new DLTN_939980731();

        s.attach(a);
        s.attach(b);

        s.changePrice(5000);

    }
}

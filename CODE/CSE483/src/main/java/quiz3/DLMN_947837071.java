package quiz3;

public class DLMN_947837071 implements Observer {

    @Override
    public void update(double price) {
        System.out.println("DLMN_947837071 just got the update");
        System.out.println("DLMN_947837071 just got the update: " + price);
        System.out.println("DLMN_947837071 needs to modify the update by adding 21% : " + (price + price * 0.21));
    }

}

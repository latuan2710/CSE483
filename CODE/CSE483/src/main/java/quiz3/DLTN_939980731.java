package quiz3;

public class DLTN_939980731 implements Observer {

    @Override
    public void update(double price) {
        System.out.println("DLTN_939980731 just got the update");
        System.out.println("DLTN_939980731 just got the update: " + price);
        System.out.println("DLTN_939980731 needs to modufy the update by adding 15% : " + (price + price * 0.15));
    }

}

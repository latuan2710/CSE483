package quiz3;

import java.util.ArrayList;
import java.util.List;

public class TGDD_519062697 implements TGDD {

    private List<Observer> observers = new ArrayList<>();
    private double price;

    @Override
    public void attach(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void detatch(Observer observer) {
        if (observers.contains(observer)) {
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(price);
        }
    }

    public void changePrice(double newPrice) {
        this.price = newPrice;
        System.out.println("TGDD has new state change");
        notifyObservers();
    }
}
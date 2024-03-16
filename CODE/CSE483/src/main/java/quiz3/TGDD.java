package quiz3;

public interface TGDD {
    public void attach(Observer observer);

    public void detatch(Observer observer);

    public void notifyObservers();
}

package Monolithic.service;

public class NotificationService {
    public void sendProductNotification(int status, int productId) {
        if (status == 0) {
            System.out.println("-----------Create product successfully-----------");
        } else if (status == 1) {
            System.out.println("-----------Get productId failed-----------");
        } else if (status == 2) {
            System.out.println("-----------Create product failed-----------");
        } else if (status == 3) {
            System.out.println("-----------Delete productId=" + productId + " successfully-----------");
        } else if (status == 4) {
            System.out.println("-----------Delete productId=" + productId + " failed-----------");
        } else if (status == 5) {
            System.out.println("-----------ProductId=" + productId + " is not exist-----------");
        }
    }

    public void sendInventoryNotification(int status, int productId, int quantity) {
        if (status == 1) {
            System.out.println("-----------ProductId=" + productId + " is out of stock-----------");
        } else if (status == 2) {
            System.out.println("-----------ProductId=" + productId + " is not exist in stock-----------");
        } else if (status == 4) {
            System.out.println("-----------ProductId=" + productId + " has just been added to the inventory with quantity=" + quantity + "-----------");
        }
    }

    public void sendOrderNotification(int status) {
        if (status == 0) {
            System.out.println("-----------Place order failed-----------");
        } else if (status == 1) {
            System.out.println("-----------Place order successfully-----------");
        }
    }
}



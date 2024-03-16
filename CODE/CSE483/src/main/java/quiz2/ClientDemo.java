package quiz2;

import java.util.Scanner;

public class ClientDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();

        Facade facade=new Facade();
        facade.displayMenu(option);

        sc.close();
    }
}

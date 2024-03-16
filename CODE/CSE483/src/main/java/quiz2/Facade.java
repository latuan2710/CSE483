package quiz2;

public class Facade {
    VegRestaurant vegRestaurantService;
    NonVegRetaurant nonVegRetaurantService;

    public Facade() {
        vegRestaurantService = new VegRestaurant();
        nonVegRetaurantService = new NonVegRetaurant();
    }

    public void displayMenu(int option) {
        switch (option) {
            case 1:
                nonVegRetaurantService.displayMenu();
                break;
            case 2:
                vegRestaurantService.displayMenu();
                break;
            case 3:
                nonVegRetaurantService.displayMenu();
                vegRestaurantService.displayMenu();
                break;

            default:
                break;
        }
    }
}

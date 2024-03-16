package quiz4;

import java.util.Scanner;

public class BankService {

	public static void main(String[] args) {
		Scanner myObj = new Scanner(System.in);

		System.out.println("Enter bank to transfer: ");
		String bankType = myObj.nextLine();

		IBankService vietcombank = new Vietcombank();
		IBankService viettinbank = new Viettinbank();
		IBankService tpbank = new TPbank();

		BankForwarder bf = new BankForwarder();

		switch (bankType.toUpperCase()) {
			case "TPBANK":
				bf.SETTER(tpbank);
				bf.transfer();
				break;
			case "VIETTINBANK":
				bf.SETTER(viettinbank);
				bf.transfer();
				break;
			case "VIETCOMBANK":
				bf.SETTER(vietcombank);
				bf.transfer();
				break;
			default:
				System.out.println("This bank type is unsupported");
		}

	}

}

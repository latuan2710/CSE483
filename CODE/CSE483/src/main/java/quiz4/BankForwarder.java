package quiz4;

public class BankForwarder {
    private IBankService bankService;

    public BankForwarder() {
    }

    public void SETTER(IBankService bankService) {
        this.bankService = bankService;
    }

    public void transfer() {
        bankService.transfer();
    }
}
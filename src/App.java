import com.finance.service.TransactionService;

public class App {
    public static void main(String[] args) {
        String fileName = "transactions.csv";
        TransactionService service = new TransactionService(fileName);
        service.getLastTransaction().ifPresent(System.out::println);
    }
}

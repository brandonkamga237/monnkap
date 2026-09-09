import java.math.BigDecimal;
import java.util.Scanner;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {

        TransactionManager transactionManager = new TransactionManager();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {

            System.out.println("\n===== TRANSACTION MANAGER =====");
            System.out.println("1. Ajouter une transaction");
            System.out.println("2. Afficher toutes les transactions");
            System.out.println("3. Afficher les transactions IN");
            System.out.println("4. Afficher les transactions OUT");
            System.out.println("5. Modifier la description");
            System.out.println("6. Changer le type IN/OUT");
            System.out.println("7. Supprimer une transaction");
            System.out.println("8. Supprimer toutes les transactions");
            System.out.println("9. Rechercher une transaction");
            System.out.println("0. Quitter");
            System.out.print("Choix : ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Description : ");
                    String description = scanner.nextLine();

                    System.out.print("Montant : ");
                    BigDecimal amount = scanner.nextBigDecimal();
                    scanner.nextLine();

                    System.out.print("Type (IN/OUT) : ");
                    TransactionType type =
                            TransactionType.valueOf(scanner.nextLine().toUpperCase());

                    transactionManager.addTransaction(
                            new Transaction(description, amount, type)
                    );

                    System.out.println("Transaction ajoutée.");
                    break;

                case 2:
                    System.out.println("\n--- Toutes les transactions ---");

                    for (Transaction transaction : transactionManager.getTransactions()) {
                        System.out.println(
                                transaction.getNum() + " | "
                                + transaction.getDescription() + " | "
                                + transaction.getAmount() + " | "
                                + transaction.getTransactionType()
                        );
                    }
                    break;

                case 3:
                    System.out.println("\n--- Transactions IN ---");

                    for (Transaction transaction : transactionManager.getTransactionTypeIn()) {
                        System.out.println(
                                transaction.getNum() + " | "
                                + transaction.getDescription() + " | "
                                + transaction.getAmount()
                        );
                    }
                    break;

                case 4:
                    System.out.println("\n--- Transactions OUT ---");

                    for (Transaction transaction : transactionManager.getTransactionTypeOut()) {
                        System.out.println(
                                transaction.getNum() + " | "
                                + transaction.getDescription() + " | "
                                + transaction.getAmount()
                        );
                    }
                    break;

                case 5:
                    System.out.print("Numéro de la transaction : ");
                    UUID numDescription = UUID.fromString(scanner.nextLine());

                    System.out.print("Nouvelle description : ");
                    String newDescription = scanner.nextLine();

                    transactionManager.updateDescriptionTransactionByNum(
                            numDescription,
                            newDescription
                    );

                    System.out.println("Description modifiée.");
                    break;

                case 6:
                    System.out.print("Numéro de la transaction : ");
                    UUID numType = UUID.fromString(scanner.nextLine());

                    transactionManager.updateTypeTransactionByNum(numType);

                    System.out.println("Type de transaction modifié.");
                    break;

                case 7:
                    System.out.print("Numéro de la transaction : ");
                    UUID numDelete = UUID.fromString(scanner.nextLine());

                    transactionManager.deleteTransactionByNum(numDelete);

                    System.out.println("Transaction supprimée.");
                    break;

                case 8:
                    transactionManager.deleteAllTransaction();

                    System.out.println("Toutes les transactions ont été supprimées.");
                    break;

                case 9:
                    System.out.print("Numéro de la transaction : ");
                    UUID numSearch = UUID.fromString(scanner.nextLine());

                    Transaction transaction =
                            transactionManager.getTransactionByNum(numSearch);

                    if (transaction != null) {
                        System.out.println(
                                "Numéro : " + transaction.getNum()
                                + "\nDescription : " + transaction.getDescription()
                                + "\nMontant : " + transaction.getAmount()
                                + "\nType : " + transaction.getTransactionType()
                        );
                    } else {
                        System.out.println("Transaction introuvable.");
                    }
                    break;

                case 0:
                    running = false;
                    System.out.println("Au revoir.");
                    break;

                default:
                    System.out.println("Choix invalide.");
            }
        }

        scanner.close();
    }
}
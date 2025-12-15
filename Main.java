import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws InputMismatchException {
        try {
            Contact contactBook = new Contact();
            System.out.println("hello");
            while (true){
                System.out.println("Выберите действие:\n" +
                        "1 \uE088 Добавить контакт\n" +
                        "2 \uE088 Удалить контакт\n" +
                        "3 \uE088 Посмотреть все контакты\n" +
                        "4 \uE088 Найти контакт по имени\n" +
                        "5 \uE088 Посмотреть контакты по группе\n" +
                        "0 \uE088 Выход");
                System.out.print("|0-5>");
                byte firstCmd = scanner.nextByte();
                switch (firstCmd){
                    case 1 ->{contactBook.addContact();}
                    case 2 ->{contactBook.deleteContact();}
                    case 3 ->{contactBook.lookContact();}
                    case 4 ->{contactBook.searchContactName();}
                    case 5 ->{contactBook.lookContactGroup();}
                    case 0 ->{System.exit(0);}
                    default -> {
                        System.out.println("Number cmd: 0-5");
                    }
                }
            }
        }catch (InputMismatchException e){
            System.out.println(e.getMessage());
        }finally {
            System.out.println(" иди поучись");
        }

    }
}
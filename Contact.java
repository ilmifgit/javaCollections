import java.util.*;

public class Contact {
    private String name;
    private String phone;
    private String email;
    private String group;

    public Contact(String name, String phone, String email, String group){
        this.name=name;
        this.phone=phone;
        this.email=email;
        this.group=group;
    }

    public String getName(){return name;}
    public void setName(String name){this.name=name;} // проверка на имя. пусто
    public String getPhone(){return phone;}
    public void setPhone(String phone){this.phone=phone;} // пусто или формат
    public String getEmail(){return email;}
    public void setEmail(String email){this.email=email;} // формат
    public String getGroup(){return group;}
    public void setGroup(String group){this.group=group;} // хз

    private static ArrayList<Contact> contacts;
    private static HashSet<String> contactPhoneSet;
    private static HashSet<String> contactEmailSet;
    private static HashMap<String,ArrayList<Contact>> contactGroupMap;
    Contact(){
        contacts = new ArrayList<>();
        contactPhoneSet = new HashSet<>();
        contactEmailSet = new HashSet<>();
        contactGroupMap = new HashMap<>();
    }

    /*
    «1» Добавить контакт
    «2» Удалить контакт
    «3» Посмотреть все контакты
    «4» Найти контакт
    «5» Посмотреть контакты по группе
    */

    public static void addContact(){
        /*
        Введите имя: Иван Иванов
        Введите телефон: 123456
        Введите email: ivan@example.com
        Введите группу: Работа
        Контакт добавлен.
         */
        // данный метод создания и заполения не подходит для одновременного сравнения и тд
        /*
        Contact contact = new Contact();
        Main.scanner.nextLine();
        System.out.print("Введите имя:");
        contact.setName(Main.scanner.nextLine()); // not check
        System.out.print("Введите телефон:");
        contact.setPhone(Main.scanner.nextLine()); // check hashSet
        if(contactPhoneSet.contains())
        System.out.print("Введите email:");
        contact.setEmail(Main.scanner.nextLine()); // check hashSet
        System.out.print("Введите группу:");
        contact.setGroup(Main.scanner.nextLine()); // check hashMap
        // проверка на наличие дубликата ? Такой контакт уже существует! : Контакт добавлен.;
        // equls and hashCode
        contacts.add(contact);
         */
        Main.scanner.nextLine();
        System.out.print("Введите имя:");
        String name = Main.scanner.nextLine();
        System.out.print("Введите телефон:");
        String phone = Main.scanner.nextLine();
        if(contactPhoneSet.contains(phone)){
            System.out.println("Такой контакт уже существует!");
            return;
        }
        System.out.print("Введите email:");
        String email = Main.scanner.nextLine();
        if(contactEmailSet.contains(email)){
            System.out.println("Такой контакт уже существует!");
            return;
        }
        System.out.print("Введите группу:");
        String group = Main.scanner.nextLine();

        Contact contact = new Contact();
        contacts.add(contact);
        contactPhoneSet.add(phone);
        contactEmailSet.add(email);

    }
    public static void deleteContact(){
        // вывод списка имен
        /*
        какой контакт хотите удалить?
        1 - name
        2 - name
        3 - name
        <1-3> 1
         */
        System.out.println("Выберите контакт для удаления:");
        for(int i = 0; i < contacts.size(); i++){
            System.out.println( ( i + 1 ) + " - " + contacts.get(i).getName() );
        }
        byte choiceContactDelete = Main.scanner.nextByte();
        choiceContactDelete-=1;
        contacts.remove(choiceContactDelete);
        System.out.println("Контакт был удален.");
    }
    public void lookContact(){
        for(Contact enumeration : contacts){
            System.out.println(enumeration);
        }
    }
    public void searchContactName(){}
    public void lookContactGroup(){
        /*
        Введите название группы: Работа
         Контакты в группе "Работа": --
        Иван Иванов | 123456 | ivan@example.com
         */
    }

    public String toString(){
        return "Имя: "+getName()+"; Телефон: "+getPhone()+"; Email: "+getEmail()+"; Группа: "+getGroup();
    }

}

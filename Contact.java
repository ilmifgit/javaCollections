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

    public Contact() {

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
    static {
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
        Contact contact = new Contact();
        Main.scanner.nextLine();
        System.out.print("Введите имя:");
        contact.setName(Main.scanner.nextLine());
        System.out.print("Введите телефон:");
        contact.setPhone(Main.scanner.nextLine());
        String phone = contact.getPhone();
        if(contactPhoneSet.contains(phone)){
            System.out.println("Такой контакт уже существует!");
            return;
        }
        System.out.print("Введите email:");
        contact.setEmail(Main.scanner.nextLine());
        String email = contact.getEmail();
        if(contactEmailSet.contains(email)){
            System.out.println("Такой контакт уже существует!");
            return;
        }
        System.out.print("Введите группу:");
        contact.setGroup(Main.scanner.nextLine());
        String group = contact.getGroup();
        if (!contactGroupMap.containsKey(group)) {
            contactGroupMap.put(group, new ArrayList<>());
        }
        contactGroupMap.get(group).add(contact);


        contacts.add(contact);
        contactPhoneSet.add(phone);
        contactEmailSet.add(email);
        contactGroupMap.get(group).add(contact);

        System.out.println("Контакт добавлен.");

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
        if (contacts.isEmpty()) {
            System.out.println("Список контактов пуст!");
            return;
        }
        System.out.println("Выберите контакт для удаления:");
        for(int i = 0; i < contacts.size(); i++){
            System.out.println( ( i + 1 ) + " - " + contacts.get(i).getName() );
        }
        System.out.print("|1-"+contacts.size()+">");
        byte choiceContactDelete = Main.scanner.nextByte();
        choiceContactDelete-=1;
        if(choiceContactDelete <= 0 && choiceContactDelete > contacts.size()){
            System.out.println("Был выбран некорректный номер!");
            return;
        }
        contactPhoneSet.remove(contacts.get(choiceContactDelete));
        contactEmailSet.remove(contacts.get(choiceContactDelete));
        contactGroupMap.remove(contacts.get(choiceContactDelete));
        contacts.remove(choiceContactDelete);
        System.out.println("Контакт был удален.");
    }
    public void lookContact(){
        if (contacts.isEmpty()) {
            System.out.println("Список контактов пуст!");
            return;
        }
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

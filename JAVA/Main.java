import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        DataBase db = new DataBase();
        db.base.add(new Person("Еблан","Долбоебов",0));
        db.base.add(new Person("Еблан2","Долбоебов2",2));
        db.baseinfo();
        db.idinfo(1);
        db.idremove(0);
        db.baseinfo();
        db.baseadd();
        
        db.baseinfo();
    }
}
class Person{
    private String name,surname;
    private int statusid;
    private static int id=0;
    private String[] status= new String[7];
    
    {
    status[0]="блатной";
    status[1]="крутой";
    status[2]="мужик";
    status[3]="вор";
    status[4]="ковшик";
    status[5]="водолаз";
    status[6]="петух";
    }

    {
        id++;
    }

    Person(String name,String surname,int statusid){
        this.name = name;
        this.surname = surname;
        this.statusid = statusid;
    } 

    public int getID() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getStatus() {
        return status[statusid];
    }
    public int getStatusid() {
        return statusid;
    }
}
class DataBase{
    private String name,surname;
    private int statusid,choice; 
    private boolean baseaddstatus=true;
    public Scanner input = new Scanner(System.in);
    ArrayList<Person> base = new ArrayList<Person>();

    public void baseinfo(){
        base.stream().forEach(Person -> System.out.printf("HEllo, %s %s. YouR Id is %d.Yo're a fucking %s\n",Person.getName(),Person.getSurname(),Person.getID(),Person.getStatus()));
    }
    public void idinfo(int id){
        if(base.stream().anyMatch(d -> d.getID()==id)) {
            System.out.printf("-----NOT WORKING RIGHT NOW-----\n");
        }
    }
    public void idremove(int id){
        if(base.stream().anyMatch(d -> d.getID()==id)) {
            base.remove(id);
        }
    }
    public void baseadd(){
        do{
            System.out.println("Введите имя студента:");
            name = input.nextLine();
            System.out.println("Введите фамилию студента:");
            surname = input.nextLine();
            System.out.printf("Выберите статус студента:\n1.блатной\n2.крутой\n3.мужик\n4.вор\n5.ковшик\n6.петух\n");
            statusid = input.nextInt();
            while(statusid > 6    ||  statusid < 1){
                System.out.printf("Выберите статус студента:\n1.блатной\n2.крутой\n3.мужик\n4.вор\n5.ковшик\n6.петух\n");
                statusid = input.nextInt();
            }
            base.add(new Person(name,surname,statusid));

            System.out.printf("Добавим еще студента?\n1.Да\n2.Нет\n");
            choice = input.nextInt();
            switch(choice){
                case 1:
                    break;
                case 2:
                    baseaddstatus=false;
                    break;
                default:
                    while(choice != 1 && choice != 2) {
                        System.out.println("Введите 1 или 2!");
                        choice = input.nextInt();
                    }
                    break;
            }
        }while(baseaddstatus);
    }
}
// Нужно доделать присвоение id у каждого из челов
// Доработать метод вывода инфы о всех стдентах (добавить сортировку по статусу)
// Добавить метод вывода инфы о студенте по id
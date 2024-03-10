import EnumOrganization.Organization;
import EnumOrganization.Status;


import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;


public class Worker implements Comparable<Worker>{
    private static int nextId = 1; // Статическое поле для генерации уникальных id
    private long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    String name; //Поле не может быть null, Строка не может быть пустой
    private int age;
    private float salary; //Поле не может быть null, Значение поля должно быть больше 0
    private Status status; //Поле может быть null
    private Organization organization;

    public Worker(String name, int age, Float salary) {
        this.id = nextId++;  // Присваиваем текущее значение nextId и затем увеличиваем его на 1
        this.name = name;
        this.age = age;
        this.salary = salary;

    }
    public long getId() {
        return id;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public Status getStatus() {
        return status;
    }
    public Organization getOrganization() {
        return organization;
    }
    private float getSalary() {
        return salary;
    }
    @Override
    public String toString() {                // Переопределение метода toString() для вывода информации о работнике
        return " | " + "Worker: " +
                "имя = " + name + ", salary = " + salary + ", " + status;
    }
    public static void showWorker(HashSet<Worker> workersSet) {   // Метод для вывода информации о коллекции
        System.out.println("Информация о коллекции:");
        System.out.println("--------------------------------------------------");

        for (Worker worker : workersSet) {
            System.out.println(worker);
        }
        System.out.println("--------------------------------------------------");
    }
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Worker worker = (Worker) o;
        return age == worker.age && (name == null ? worker.name == null : name.equals(worker.name));
    }
    @Override
    public int hashCode() {

        return age + name.hashCode();
    }

    public static float sumOfSalary(HashSet<Worker> workersSet) {  // Метод для вычисления суммы зарплат всех работников
        float totalSalary = 0;              // totalSalary - которая будет хранить сумму зарплат всех работников totalSalary
        for (Worker worker : workersSet) {  // Выполняется проход по каждому работнику и добавляется их зарплата к
            totalSalary += worker.getSalary();
        }
        return totalSalary;   // По завершению цикла возвращается totalSalary, в которой находится сумма зарплат всех работников
    }

    public static void addNewWorker(HashSet<Worker> workersSet) {   // Метод для добавления нового элемента в коллекцию
        Scanner scanner = new Scanner(System.in);  //Создается объект Scanner для чтения пользовательского ввода с консоли

        System.out.println("Введите имя нового работника: ");
        String name = scanner.nextLine();  //метод для получения значения имени

        System.out.println("Введите возраст нового работника: ");
        int age = scanner.nextInt();

        System.out.println("Введите зарплату нового работника: ");
        float salary = Float.parseFloat(scanner.nextLine());  //метод для получения значения зарплаты

        workersSet.add(new Worker(name, age, salary));
        System.out.println("Новый работник добавлен в коллекцию работников.");
    }
    public static void clearWorker(HashSet<Worker> workersSet) {   // Метод для очистки коллекции
        workersSet.clear();
        System.out.println("Коллекция очищена.");
    }

    @Override
    public int compareTo(Worker otherWorker) {
        return this.name.compareTo(otherWorker.getName());
    }

}

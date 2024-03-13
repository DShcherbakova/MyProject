package AppWorker;

import AppWorker.EnumOrganization.Organization;
import AppWorker.EnumOrganization.Status;

import java.util.Objects;
import java.util.Scanner;
import java.util.HashSet;





public class Worker implements Comparable<Worker>{
    private static int nextId = 1; // Статическое поле для генерации уникальных id
    private long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    String name; //Поле не может быть null, Строка не может быть пустой
    private int age;
    private float salary; //Поле не может быть null, Значение поля должно быть больше 0
    private Status status; //Поле может быть null
    private Organization organization;

    public Worker(String name, int age, float salary) {
        this.id = nextId++;  // Присваиваем текущее значение nextId и затем увеличиваем его на 1
        this.name = name;
        this.age = age;
        this.salary = salary;

    }
    public long getId() {

        return id;
    }
    public void setId(int id) {

        this.id = id;
    }
    public String getName(){

        return name;
    }
    public int getAge(){

        return age;
    }
    public void setAge(int age) {
        if (age >= 18 && age <= 65) { // Проверка возраста на допустимый диапазон
            this.age = age;
        } else {
            System.out.println("Недопустимый возраст");
        }
    }

    public Status getStatus() {

        return status;
    }
    /*public void setStatus(String status) {
        if (status != null && !status.isEmpty()) { // Проверка статуса на непустое значение
                                                   // Это условие проверяет, что значение переменной status не является пустой строкой
            this.status = Status.valueOf(status);  // Преобразования строки status в соответствующий объект типа Status
        } else {
            System.out.println("Статус не может быть пустым");
        }
    }

     */
    /*public void setSalary(float salary) {
        if (salary >= 0) {                // Проверка зарплаты на неотрицательное значение
            this.salary = salary;
        } else {
            System.out.println("Зарплата не может быть отрицательной");
        }
    }

     */
    public Organization getOrganization() {

        return organization;
    }
    public float getSalary() {

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
        return age == worker.age &&
                Objects.equals(name, worker.name);
    }
    @Override
    public int hashCode() {

        return 31 * age + name.hashCode();
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
        float salary = scanner.nextFloat();  //метод для получения значения зарплаты

        workersSet.add(new Worker(name, age, salary));
        System.out.println("Новый работник добавлен в коллекцию работников.");
    }
    /*public static void clearWorker(HashSet<Worker> workersSet) {  // Метод для очистки коллекции
        Scanner scanner = new Scanner(System.in);
        System.out.println("Вы уверены, что хотите очистить всю коллекцию? (да/нет)");
        System.out.println("Ваш ответ: ");
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("да")) {  // Метод строки, который сравнивает содержимое строки answer
                                              // с заданной строкой "да", игнорируя регистр символов
            workersSet.clear();
            System.out.println("Коллекция очищена.");
        } else {
            System.out.println("Очистка коллекции отменена.");
        }
    }

     */
    public static void clearWorker(HashSet<Worker> workersSet){   // Метод для очистки коллекции
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Вы уверены, что хотите очистить всю коллекцию? [да/нет]");
            System.out.println("Ваш ответ: ");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("да")) {  // Метод строки, который сравнивает содержимое строки answer
                                                              // с заданной строкой "да", игнорируя регистр символов
                workersSet.clear();      //Метод очистки коллекции работников
                System.out.println("Коллекция очищена.");
                break;
            } else if (answer.equalsIgnoreCase("нет")){
                System.out.println("Очистка коллекции отменена.");
                break;
            }
        } while (true);
    }

    @Override
    public int compareTo(Worker otherWorker) {

        return this.name.compareTo(otherWorker.getName());
    }

    /* public static void removeLower(HashSet<Worker> workersSet, float fieldValue) {
        int countRemoved = 0;               // Счетчик удаленных элементов

        HashSet<Worker> toRemove = new HashSet<>();  // Создаем временную коллекцию

        for (Worker worker : workersSet) {  // Проходим по каждому работнику в коллекции
                                            // Сравнение значения зарплаты с заданным значением fieldValue
            if (worker.getSalary() < fieldValue) {  // Если зарплата меньше, добавляем работника в коллекцию на удаление
                toRemove.add(worker);
                countRemoved++;             // Увеличиваем счетчик удаленных элементов
            }
        }
    }

     */
}

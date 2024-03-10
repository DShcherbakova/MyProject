package AppWorker;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        Worker[] workersArray = {     // Создание массива работников
                new Worker("Hanna", 23, 50000.6F),
                new Worker("Maksim", 34,25000.3F),
                new Worker("Robert",56, 33000.3F),
                new Worker("Alice",30, 22000.2F),
                new Worker("Violetta",21, 33000.7F),
                new Worker("Karla", 56, 44000.4F),
                new Worker("Nina", 31, 35000.5F),
                new Worker("Viktor", 27, 40000.3F),
                new Worker("Vins", 34, 37000.7F)
        };
        HashSet<Worker> workersSet = new HashSet<>();   // Создание коллекции

        for (Worker worker : workersArray) {
            workersSet.add(worker);
        }

        Worker.showWorker(workersSet);  // Вывод информации о работниках в HashSet

        System.out.println("Количество работников в HashSet: " + workersSet.size());  // Вывод количества работников в HashSet

        float totalSalary = Worker.sumOfSalary(workersSet);
        System.out.println("Сумма зарплат всех работников: " + totalSalary);

        Worker.addNewWorker(workersSet);
        Worker.showWorker(workersSet);

        float totalSalary1 = Worker.sumOfSalary(workersSet);
        System.out.println("Сумма зарплат всех работников: " + totalSalary1);

        Worker.clearWorker(workersSet);
        Worker.showWorker(workersSet);


    }

}

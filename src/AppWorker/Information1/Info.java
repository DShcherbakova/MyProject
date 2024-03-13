package AppWorker.Information1;

public class Info implements AppInformation{

    @Override
    public void workerHello() {           // Переопределённый метод workerHello выводит информацию о доступных действиях пользователя
        System.out.println("Для списка доступных команд введите 'help'.");
        System.out.println("Для выхода из программы введите 'exit'.");
        System.out.println(": ");
    }

    @Override
    public void workerInfo() {              // Переопределённый метод workerInfo выводит информацию о коллекции
        System.out.println("Тип: Коллекция работников");
        System.out.println("Количество элементов: ");
    }

    @Override
    public void workerHelp() {                // Переопределённый метод workerHelp выводит информацию о доступных пользователю командах
        System.out.println("info: вывести информацию о коллекции работников");
        System.out.println("show: вывести все элементы коллекции работников");
        System.out.println("add: добавить новый элемент в коллекцию работников");
        System.out.println("update (id): обновить элемент коллекции работников");
        System.out.println("remove_by_id: удалить элемент по id");
        System.out.println("clear: очистить коллекцию работников");
        System.out.println("exit: завершить программу(без сохранения)");
        System.out.println("add_if_max: добавить новый элемент в коллекцию работников");
        System.out.println("remove_lower: удалить из коллекции работников все элементы");
        System.out.println("sum_of_salary: вывести сумму значений зарплат");
        System.out.println("filter_starts_with_name: вывести элементы, значение поля name");
        System.out.println("print_field_ascending_status: вывести значения поля status всех элементов в порядке возрастания");
    }
}

package Airline;

import Aircraft.*;
import Aircraft.Comparator.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Comparator;


/**
 * Клас авіакомпанії, який зберігає список авіапарку, каталог,
 * а також містить методи для роботи з ними
 */
public class Airline {
    private final Scanner in = new Scanner(System.in);

    public boolean exist = false;
    private String airlineName;
    private ArrayList <Plane> PlaneList = new ArrayList<Plane>();
    private ArrayList <Plane> PlaneTypeList = new ArrayList<Plane>();


    /**
     * Метод для створення нової авіакомпанії; також каталог
     * моделей літаків заповнюється кількома базовими моделями
     */
    public void CreateAirline(){
        System.out.print("Введіть назву нової авіакомпанії: ");
        this.airlineName = in.next();
        FillPlaneTypeList();
        exist = true;
        System.out.println("Авіакомпанію успішно створено!");
    }

    /**
     * Додавання літака в авіапарк компанії
     */
    public void PlaneAdd(){
        int choice, i;

        System.out.println(" Оберіть літак, який ви хочете додати: ");
        for(i=0; i<PlaneTypeList.size(); i++){
            System.out.println("\t"+(i+1)+") "+PlaneTypeList.get(i).getName());
        }
        System.out.println("\t"+(i+1)+") Додати новий..");

        while(true){
            choice = in.nextInt();
            if ((choice > 0) && (choice <= PlaneTypeList.size()+1)){
                if(choice == (i+1)){
                    PlaneList.add(CreateNewPlane());
                }
                else{
                    PlaneList.add(new Plane(PlaneTypeList.get(choice-1)));
                    System.out.print("Введіть бортовий номер: ");
                    String sideNumber = in.next();
                    PlaneList.get(PlaneList.size()-1).setSideNumber(sideNumber);
                }
                break;
            }
            else{
                System.out.print("\nВи ввели неправильне значення! Введіть повторно: ");
            }
        }

    }

    /**
     * Зміна характеристик літаків
     */
    public void PlaneChange(){
        if(PlaneList.size() == 0){
            System.out.println("В авіапарку компанії ще немає жодного літака!");
            return;
        }
        int choice, paramChoice, i;

        System.out.println(" Оберіть літак, який ви хочете змінити:");
        for(i=0; i<PlaneList.size(); i++){
            System.out.println("\t"+(i+1)+") "+PlaneList.get(i).getName());
        }

        while(true){
            choice = in.nextInt();
            if ((choice > 0) && (choice <= PlaneList.size()+1)){

                System.out.println("Список характеристик для зміни:");
                System.out.println("\t1) Назва"+"\n\t2) Бортовий номер"+"\n\t3) Дальність"+"\n\t4) Споживання палива"
                        +"\n\t5) Пасажиромісткість"+"\n\t6) Вантажопідйомність"+"\n\t7) Завершити");
                while(true){
                    System.out.print("\nОберіть характеристику: ");
                    paramChoice = in.nextInt();
                    if ((paramChoice > 0) && (paramChoice <= 7)){
                        switch (paramChoice){
                            case 1 -> {
                                System.out.print("\tВведіть нову назву: ");
                                String newName = in.next();
                                PlaneList.get(choice-1).setName(newName);
                            }
                            case 2 -> {
                                System.out.print("\tВведіть новий бортовий номер: ");
                                String newSideNumber = in.next();
                                PlaneList.get(choice-1).setSideNumber(newSideNumber);
                            }
                            case 3 -> {
                                System.out.print("\tВведіть нову дальність: ");
                                int newFlyDistance = in.nextInt();
                                PlaneList.get(choice-1).setFlyDistance(newFlyDistance);
                            }
                            case 4-> {
                                System.out.print("\tВведіть новий розхід палива: ");
                                double newFuelConsumption = in.nextDouble();
                                PlaneList.get(choice-1).setFuelConsumption(newFuelConsumption);
                            }
                            case 5 -> {
                                System.out.print("\tВведіть нову пасажиромісткість: ");
                                int newPassengerCapacity = in.nextInt();
                                PlaneList.get(choice-1).setPassengerCapacity(newPassengerCapacity);
                            }
                            case 6 -> {
                                System.out.print("\tВведіть нову вантажопідйомність: ");
                                int newCargoCapacity = in.nextInt();
                                PlaneList.get(choice-1).setCargoCapacity(newCargoCapacity);
                            }
                            case 7 -> {
                                return;
                            }
                        }
                    }
                    else{
                        System.out.print("\nВи ввели неправильне значення! Введіть повторно: ");
                    }
                }

            }
            else{
                System.out.print("\nВи ввели неправильне значення! Введіть повторно: ");
            }
        }
    }

    /**
     * Видалення літака зі списку
     */
    public void PlaneDelete(){
        if(PlaneList.size() == 0){
            System.out.println("В авіапарку компанії ще немає жодного літака!");
            return;
        }
        int choice, i;

        System.out.println("Оберіть літак для видалення:");
        for(i=0; i<PlaneList.size(); i++){
            System.out.println("\t"+(i+1)+") "+PlaneList.get(i).getName());
        }
        while(true){
            choice = in.nextInt();
            if ((choice > 0) && (choice <= PlaneList.size()+1)){
                PlaneList.remove(choice-1);
                break;
            }
            else{
                System.out.print("\nВи ввели неправильне значення! Введіть повторно: ");
            }
        }
    }

    /**
     * Виведення інформації про літак
     */
    public void PlaneInfo(){
        if(PlaneList.size() == 0){
            System.out.println("В авіапарку компанії ще немає жодного літака!");
            return;
        }
        int choice, i;

        System.out.println("Оберіть літак:");
        for(i=0; i<PlaneList.size(); i++){
            System.out.println("\t"+(i+1)+") "+PlaneList.get(i).getName());
        }
        while(true){
            choice = in.nextInt();
            if ((choice > 0) && (choice <= PlaneList.size()+1)){
                System.out.println(PlaneList.get(choice-1).toString());
                break;
            }
            else{
                System.out.print("\nВи ввели неправильне значення! Введіть повторно: ");
            }
        }

    }

    /**
     * Виводить на екран список літаків
     */
    public void PlaneList(){
        if(PlaneList.size() == 0){
            System.out.println("В авіапарку компанії ще немає жодного літака!");
            return;
        }

        System.out.println("Наявні літаки ("+PlaneList.size()+"):");
        for(int i=0; i<PlaneList.size(); i++){
            System.out.print("\t"+(i+1)+") "+PlaneList.get(i).getName()+"  SN:"+PlaneList.get(i).getSideNumber()+"  ");

            if((PlaneList.get(i).getCargoCapacity() != 0) && (PlaneList.get(i).getPassengerCapacity() != 0))
                System.out.print("(універсальний)\n");
            else{
                if(PlaneList.get(i).getCargoCapacity() == 0)
                    System.out.print("(пасажирський)\n");
                else
                    System.out.print("(вантажний)\n");
            }
        }
    }

    /**
     * Виведення переліку літаків, які відповідають певному діапазону параметрів
     */
    public void PlaneListRange(){
        if(PlaneList.size() == 0){
            System.out.println("В авіапарку компанії ще немає жодного літака!");
            return;
        }

        int choice, min, max, counter = 0;
        System.out.println("Оберіть параметр:");
        System.out.println("\t1) Дальність польоту\n\t2) Споживання палива" +
                "\n\t3) Вантажопідйомність\n\t4) Пасажиромісткість:");
        while(true){
            choice = in.nextInt();
            if ((choice > 0) && (choice < 5)){
                System.out.println("Введіть мінімальну та максимальну межу: ");
                System.out.print("\tmin: ");
                min = in.nextInt();
                System.out.print("\tmax: ");
                max = in.nextInt();

                System.out.println("Перелік літаків у даному діапазоні параметрів:");
                for(int i=0; i<PlaneList.size(); i++){
                    switch (choice){
                        case 1 -> {
                            if((PlaneList.get(i).getFlyDistance() >= min) && (PlaneList.get(i).getFlyDistance() <= max)){
                                System.out.println("\t"+(i+1)+") "+PlaneList.get(i).getName()+
                                " SN: " + PlaneList.get(i).getSideNumber()+
                                " Вантажопідйомність: " + PlaneList.get(i).getFlyDistance() + " (км)"
                                );
                                counter++;
                            }
                        }
                        case 2 -> {
                            if((PlaneList.get(i).getFuelConsumption() >= min) && (PlaneList.get(i).getFuelConsumption() <= max)){
                                System.out.println("\t"+(i+1)+") "+PlaneList.get(i).getName()+
                                        " SN: " + PlaneList.get(i).getSideNumber()+
                                        " Споживання палива: " + PlaneList.get(i).getFuelConsumption() + " (т/год)"
                                );
                                counter++;
                            }
                        }
                        case 3 -> {
                            if((PlaneList.get(i).getCargoCapacity() >= min) && (PlaneList.get(i).getCargoCapacity() <= max)){
                                System.out.println("\t"+(i+1)+") "+PlaneList.get(i).getName()+
                                        " SN: " + PlaneList.get(i).getSideNumber()+
                                        " Вантажомісткість: " + PlaneList.get(i).getCargoCapacity() + " (т)"
                                );
                                counter++;
                            }
                        }
                        case 4 -> {
                            if((PlaneList.get(i).getPassengerCapacity() >= min) && (PlaneList.get(i).getPassengerCapacity() <= max)){
                                System.out.println("\t"+(i+1)+") "+PlaneList.get(i).getName()+
                                        " SN: " + PlaneList.get(i).getSideNumber()+
                                        " Пасажиромісткість: " + PlaneList.get(i).getPassengerCapacity()
                                );
                                counter++;
                            }
                        }
                    }
                }
                if(counter == 0){
                    System.out.println("В авіапарку немає літаків, які відповідають даному діапазону значень");
                }
                break;
            }
            else{
                System.out.print("\nВи ввели неправильне значення! Введіть повторно: ");
            }
        }
    }

    /**
     * Сортування списку літаків за обраним параметром
     */
    public void PlaneListSort(){
        if(PlaneList.size() == 0){
            System.out.println("В авіапарку компанії ще немає жодного літака!");
            return;
        }
        int choice;

        System.out.println("Оберіть параметр для сортування:");
        System.out.println("\t1) Дальність польоту\n\t2) Споживання палива" +
                "\n\t3) Вантажопідйомність\n\t4) Пасажиромісткість:");
        while(true){
            choice = in.nextInt();
            if ((choice > 0) && (choice < 5)) {
                Comparator comparator;
                switch (choice){
                    case 1 -> {
                        comparator = new FlyDistanceComparator();
                        PlaneList.sort(comparator);
                    }
                    case 2 -> {
                        comparator = new FuelConsumptionComparator();
                        PlaneList.sort(comparator);
                    }
                    case 3 -> {
                        comparator = new CargoCapacityComparator();
                        PlaneList.sort(comparator);
                    }
                    case 4 -> {
                        comparator = new PassengerCapacityComparator();
                        PlaneList.sort(comparator);
                    }
                }
                System.out.println("Список літаків було успішно відсортовано!");
                break;
            }
            else{
                System.out.print("\nВи ввели неправильне значення! Введіть повторно: ");
            }
        }
    }

    /**
     * Підрахування загальної місткості та вантажопідйомності всього авіапарку
     */
    public void PlaneListSummary(){
        if(PlaneList.size() == 0){
            System.out.println("В авіапарку компанії ще немає жодного літака!");
            return;
        }
        int choice, sum=0, planeSum=0;

        System.out.println("Оберіть параметр виведення загального значення:");
        System.out.println("\t1) Вантажопідйомність\n\t2) Пасажиромісткість");
        while(true){
            choice = in.nextInt();
            if ((choice > 0) && (choice <= 2)){
                switch (choice){
                    case 1 -> {
                        for(int i=0; i<PlaneList.size(); i++){
                            sum += PlaneList.get(i).getCargoCapacity();
                            if(PlaneList.get(i).getCargoCapacity() != 0)
                                planeSum++;
                        }
                        System.out.print("Загальна вантажопідйомність: "+sum+" (т)");
                    }
                    case 2 -> {
                        for(int i=0; i<PlaneList.size(); i++){
                            sum += PlaneList.get(i).getPassengerCapacity();
                            if(PlaneList.get(i).getPassengerCapacity() != 0)
                                planeSum++;
                        }
                        System.out.print("Загальна пасажиромісткість: "+sum+" (місць)");
                    }
                }
                System.out.print(", загалом " + planeSum + " літаків для даного завдання");
                break;
            }
            else{
                System.out.print("\nВи ввели неправильне значення! Введіть повторно: ");
            }
        }
    }

    /**
     * Виведення підказки користувачу
     */
    public void Help(){
        System.out.println("Коротка підказка по користуванню програмою:");
        System.out.println("\t- Для користуванням меню, необхідно ввести цифру, яка відповідає номеру" +
                "обраного вами пункту.\n\t  Наприклад: 1) Створити авіакомпанію  ->  1 + \"Enter\"");
        System.out.println("\t- Даний принцип використовується у всіх розділах меню програми\n");
    }

    /**
     * Виведення інформації про авіакомпанію
     */
    public void AirlineInfo(){
        System.out.println("Коротка довідка:\n\tАвіакомпанія \"" + airlineName + "\"" +
                ", кількість літаків в розпорядженні: "+PlaneList.size());
    }

    /**
     * Виведення інформації про призначення програми та автора
     */
    public void ProgramInfo(){
        System.out.println("Airline application - програма для ведення зручного обліку літаків, " +
                "наявних у розпорядженні авіакомпанії.\nТакож присутні додаткові можливості, такі як" +
                " обчислення загальної вантажо/пасажиро підйомності та\nвиведення списку наявних літаків" +
                " у вказаному діапазоні параметрів. Приємного користування!\n\nАвтор: Студент групи КН-207" +
                "\n\t   Чепюк Ярослав\n");
    }

    /**
     * Метод для заповнення каталогу базовими моделями літаків
     */
    private void FillPlaneTypeList(){
        // Вантажні
        Plane plane = new Plane("АН-225 \"Мрія\"", 7000, 16.9,0,250);
        PlaneTypeList.add(plane);
        plane = new Plane("АН-124 \"Руслан\"", 11900, 12.7,0,120);
        PlaneTypeList.add(plane);
        plane = new Plane("Airbus A300-600ST \"Beluga\"", 4600, 8.4,0,47);
        PlaneTypeList.add(plane);
        plane = new Plane("Casa C-295 ", 4600, 2.94,0,6);
        PlaneTypeList.add(plane);
        plane = new Plane("АН-132 ", 4400, 3.41,0,9);
        PlaneTypeList.add(plane);

        // Пасажирські
        plane = new Plane("Boeing 757", 7250, 14.8,235,0);
        PlaneTypeList.add(plane);
        plane = new Plane("Boeing 747 \"Jumbo Jet\"", 14800, 20.4,416,0);
        PlaneTypeList.add(plane);
        plane = new Plane("АН-24 \"Кокс\"", 14800, 2.93,52,0);
        PlaneTypeList.add(plane);
        plane = new Plane("Airbus A340", 14600, 19.22,475,0);
        PlaneTypeList.add(plane);
        plane = new Plane("Airbus A300", 5375, 15.1,269,0);
        PlaneTypeList.add(plane);
    }

    /**
     * Метод для створення нового літака та додавання його в каталог
     */
    private Plane CreateNewPlane(){
        System.out.println("Введіть характеристики:");

        System.out.print("\t1) Назва: ");
        String name = in.next();
        System.out.print("\t2) Бортовий номер: ");
        String sideNumber = in.next();
        System.out.print("\t3) Дальність польоту(км): ");
        int flyDistance = in.nextInt();
        System.out.print("\t4) Споживання палива(т/год): ");
        double fuelConsumption = in.nextDouble();
        System.out.print("\t5) Вантажопідйомність(т): ");
        int cargoCapacity = in.nextInt();;
        System.out.print("\t6) Пасажиромісткість: ");
        int passengerCapacity = in.nextInt();;

        Plane plane = new Plane(name, sideNumber, flyDistance, fuelConsumption, passengerCapacity, cargoCapacity);

        System.out.print(" Додавати в каталог? (Введіть 1, щоб підтвердити): ");
        int choice = in.nextInt();
        if(choice == 1){
            PlaneTypeList.add(plane);
        }
        return(plane);
    }
}

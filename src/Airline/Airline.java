package Airline;

import Aircraft.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Airline {
    private final Scanner in = new Scanner(System.in);

    public boolean exist = false;
    private String airlineName;
    private ArrayList <CargoPlane> cargoPlaneList = new ArrayList<CargoPlane>();
    private ArrayList <PassengerPlane> passengerPlaneList = new ArrayList<PassengerPlane>();
    private ArrayList <CargoPlane> cargoPlaneTypeList = new ArrayList<CargoPlane>();
    private ArrayList <PassengerPlane> passengerPlaneTypeList = new ArrayList<PassengerPlane>();

    /**
     * Метод для створення нової авіакомпанії; також каталог
     * моделей літаків заповнюється кількома базовими моделями
     */
    public void CreateAirline(){
        System.out.print("Введіть назву нової авіакомпанії: ");
        this.airlineName = in.next();

        // Створюємо базовий каталог типів літаків
        CargoPlane cPlane = new CargoPlane("АН-225 \"Мрія\"", 7000, 16.9,250);
        cargoPlaneTypeList.add(cPlane);
        cPlane = new CargoPlane("АН-124 \"Руслан\"", 11900, 12.7,120);
        cargoPlaneTypeList.add(cPlane);
        cPlane = new CargoPlane("Airbus A300-600ST \"Beluga\"", 4600, 8.4,47);
        cargoPlaneTypeList.add(cPlane);
        cPlane = new CargoPlane("Casa C-295 ", 4600, 2.94,6);
        cargoPlaneTypeList.add(cPlane);
        cPlane = new CargoPlane("АН-132 ", 4400, 3.41,9);
        cargoPlaneTypeList.add(cPlane);

        PassengerPlane pPlane= new PassengerPlane("Boeing 757", 7250, 14.8,235);
        passengerPlaneTypeList.add(pPlane);
        pPlane= new PassengerPlane("Boeing 747 \"Jumbo Jet\"", 14800, 20.4,416);
        passengerPlaneTypeList.add(pPlane);
        pPlane= new PassengerPlane("АН-24 \"Кокс\"", 14800, 2.93,52);
        passengerPlaneTypeList.add(pPlane);
        pPlane= new PassengerPlane("Airbus A340", 14600, 19.22,475);
        passengerPlaneTypeList.add(pPlane);
        pPlane= new PassengerPlane("Airbus A300", 5375, 15.1,269);
        passengerPlaneTypeList.add(pPlane);

        exist = true;
        System.out.println("Авіакомпанію успішно створено!");
    }

    /**
     * Метод для додавання літака в авіапарк компанії
     */
    public void PlaneAdd(){
        int choice, i;

        System.out.println("Оберіть призначення літака, який ви хочете додати: ");
        System.out.println("\t1) Вантажний\n\t2) Пасажирський");
        // Обираємо тип літака, який хочемо додати
        while(true){
            choice = in.nextInt();
            if(choice == 1 || choice == 2){
                break;
            }
            else
                System.out.print("Неправильна команда! Введіть повторно: ");
        }

        System.out.print("Оберіть літак:");
        // Для вантажних
        if(choice == 1){
            // Виводимо на екран список доступних літаків
            for(i=0; i<cargoPlaneTypeList.size(); i++)
                System.out.print("\n\t"+(i+1)+") "+cargoPlaneTypeList.get(i).getName());
            System.out.println("\n\t"+(i+1)+") Додати новий..");

            // Обираємо один з можливих
            while (true){
                choice = in.nextInt();
                if ((choice > 0) && (choice <= cargoPlaneTypeList.size()+1)) {
                    // Додаємо новий
                    if(choice == i+1)
                        cargoPlaneList.add(CreateNewCargoPlane());

                    // Додаємо один з існуючих в каталозі
                    else{
                        cargoPlaneList.add(cargoPlaneTypeList.get(i-1));
                        System.out.print("Введіть бортовий номер: ");
                        String sideNumber = in.next();
                        cargoPlaneList.get(cargoPlaneList.size()-1).setSideNumber(sideNumber);
                    }
                    break;
                }
                else
                    System.out.println("Неправильна команда!");
            }
        }
        // Для пасажирських літаків
        else{
            // Виводимо на екран список доступних літаків
            for(i=0; i<passengerPlaneTypeList.size(); i++){
                System.out.print("\n\t"+(i+1)+") "+passengerPlaneTypeList.get(i).getName());
            }
            System.out.println("\n1\t"+(i+1)+") Додати новий..");

            // Обираємо один з можливих
            while (true){
                choice = in.nextInt();
                if ((choice > 0) && (choice <= passengerPlaneTypeList.size()+1)) {
                    // Додаємо новий
                    if(choice == i+1)
                        passengerPlaneList.add(CreateNewPassengerPlane());

                    // Додаємо один з існуючих в каталозі
                    else{
                        passengerPlaneList.add(passengerPlaneTypeList.get(i-1));
                        System.out.print("Введіть бортовий номер: ");
                        String sideNumber = in.next();
                        passengerPlaneList.get(passengerPlaneList.size()-1).setSideNumber(sideNumber);
                    }
                    break;
                }
                else
                    System.out.println("Неправильна команда!");
            }
        }
    }

    /**
     * Метод для зміни характеристик літаків
     */
    public void PlaneChange(){
        int choice, parameterChoice;

        // Обираємо тип літака, який хочемо змінити
        System.out.println("Оберіть категорію літака для зміни: ");
        System.out.println("\t1) Вантажний\n\t2) Пасажирський");
        while(true){
            choice = in.nextInt();
            if(choice == 1 || choice == 2){
                break;
            }
            else
                System.out.print("Неправильна команда! Введіть повторно: ");
        }

        // Для вантажних
        if(choice == 1) {
            // Перевірка на наявність літаків
            if(cargoPlaneList.size() == 0){
                System.out.println("В авіапарку вантажних літаків компанії пусто!");
                return;
            }
            // Виводимо список літаків
            System.out.print("Оберіть літак: ");
            for(int i=0; i<cargoPlaneList.size(); i++)
                System.out.print("\n\t"+(i+1)+") "+cargoPlaneList.get(i).getName()
                        +" "+cargoPlaneList.get(i).getSideNumber());
            System.out.print("\n");

            while (true){
                choice = in.nextInt();
                // Змінюємо характеристики
                if((choice > 0) && (choice <= cargoPlaneList.size()+1)){
                    System.out.println("\t1) Назва"+"\n\t2) Бортовий номер"+"\n\t3) Вантажопідйомність"
                            +"\n\t4) Дальність"+"\n\t5) Споживання палива"+"\n\t6) Завершити");
                    while(true){
                        System.out.print("Оберіть характеристику для зміни: ");
                        parameterChoice = in.nextInt();

                        switch (parameterChoice){
                            case 1 -> {
                                System.out.print("\tВведіть нову назву: ");
                                String newName = in.next();
                                cargoPlaneList.get(choice-1).setName(newName);
                            }
                            case 2 -> {
                                System.out.print("\tВведіть новий бортовий номер: ");
                                String newSideNumber = in.next();
                                cargoPlaneList.get(choice-1).setSideNumber(newSideNumber);
                            }
                            case 3 -> {
                                System.out.print("\tВведіть нову вантажопідйомність: ");
                                int newCargoCapacity = in.nextInt();
                                cargoPlaneList.get(choice-1).setCargoCapacity(newCargoCapacity);
                            }
                            case 4 -> {
                                System.out.print("\tВведіть нову дальність: ");
                                int newFlyDistance = in.nextInt();
                                cargoPlaneList.get(choice-1).setFlyDistance(newFlyDistance);
                            }
                            case 5 -> {
                                System.out.print("\tВведіть новий розхід палива: ");
                                double newFuelConsumption = in.nextDouble();
                                cargoPlaneList.get(choice-1).setFuelConsumption(newFuelConsumption);
                            }
                            case 6 -> {
                                return;
                            }
                        }

                    }
                }
                else
                    System.out.print("Неправильна команда! Введіть повторно: ");
            }

        }
        // Для пасажирських
        else {
            // Перевірка на наявність літаків
            if(passengerPlaneList.size() == 0){
                System.out.println("В авіапарку пасажирський літаків компанії пусто!");
                return;
            }
            // Виводимо список літаків
            System.out.print("Оберіть літак: ");
            for(int i=0; i<passengerPlaneList.size(); i++)
                System.out.print("\n\t"+(i+1)+") "+passengerPlaneList.get(i).getName()
                        +" "+passengerPlaneList.get(i).getSideNumber());
            System.out.print("\n");

            while (true){
                choice = in.nextInt();
                // Змінюємо характеристики
                if((choice > 0) && (choice <= passengerPlaneList.size()+1)){
                    System.out.println("\t1) Назва"+"\n\t2) Бортовий номер"+"\n\t3) Пасажиромісткість"
                            +"\n\t4) Дальність"+"\n\t5) Споживання палива"+"\n\t6) Завершити");
                    while(true){
                        System.out.print("Оберіть характеристику для зміни: ");
                        parameterChoice = in.nextInt();

                        switch (parameterChoice){
                            case 1 -> {
                                System.out.print("\tВведіть нову назву: ");
                                String newName = in.next();
                                passengerPlaneList.get(choice-1).setName(newName);
                            }
                            case 2 -> {
                                System.out.print("\tВведіть новий бортовий номер: ");
                                String newSideNumber = in.next();
                                passengerPlaneList.get(choice-1).setSideNumber(newSideNumber);
                            }
                            case 3 -> {
                                System.out.print("\tВведіть нову пасажиромісткість: ");
                                int newPassengerCapacity = in.nextInt();
                                passengerPlaneList.get(choice-1).setPassengerCapacity(newPassengerCapacity);
                            }
                            case 4 -> {
                                System.out.print("\tВведіть нову дальність: ");
                                int newFlyDistance = in.nextInt();
                                passengerPlaneList.get(choice-1).setFlyDistance(newFlyDistance);
                            }
                            case 5 -> {
                                System.out.print("\tВведіть новий розхід палива: ");
                                double newFuelConsumption = in.nextDouble();
                                passengerPlaneList.get(choice-1).setFuelConsumption(newFuelConsumption);
                            }
                            case 6 -> {
                                return;
                            }
                        }

                    }
                }
                else
                    System.out.print("Неправильна команда! Введіть повторно: ");
            }
        }
    }


    public void PlaneDelete(){

    }

    public void PlaneInfo(){

    }

    /**
     * Метод виводить на екран список літаків
     */
    public void PlaneList(){
        System.out.println("Наявні літаки:");

    }

    public void PlaneListRange(){

    }

    public void PlaneListSort(){

    }

    public void PlaneListSummary(){

    }

    public void Help(){

    }

    public void AirlineInfo(){

    }

    /**
     * Метод для створення та додавання в каталог нового вантажного літака
     * @return вантажний літак з введеним бортовим номером
     */
    private CargoPlane CreateNewCargoPlane(){
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

        CargoPlane plane = new CargoPlane(name, flyDistance, fuelConsumption, cargoCapacity);
        cargoPlaneTypeList.add(plane);
        plane.setSideNumber(sideNumber);
        return plane;
    }

    /**
     * Метод для створення та додавання в каталог нового пасажирського літака
     * @return пасажирський літак з введеним бортовим номером
     */
    private PassengerPlane CreateNewPassengerPlane(){
        System.out.println("Введіть характеристики:");

        System.out.print("\t1) Назва: ");
        String name = in.next();
        System.out.print("\t2) Бортовий номер: ");
        String sideNumber = in.next();
        System.out.print("\t3) Дальність польоту(км): ");
        int flyDistance = in.nextInt();
        System.out.print("\t4) Споживання палива(т/год): ");
        double fuelConsumption = in.nextDouble();
        System.out.print("\t5) Кількість пасажирських місць: ");
        int passengerCapacity = in.nextInt();;

        PassengerPlane plane = new PassengerPlane(name, flyDistance, fuelConsumption, passengerCapacity);
        passengerPlaneTypeList.add(plane);
        plane.setSideNumber(sideNumber);
        return plane;
    }
}

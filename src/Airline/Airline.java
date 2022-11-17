package Airline;

import Aircraft.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Airline {
    private final Scanner in = new Scanner(System.in);

    public boolean exist = false;
    private String airlineName;
    private ArrayList <Plane> cargoPlaneList = new ArrayList<Plane>();
    private ArrayList <Plane> passengerPlaneList = new ArrayList<Plane>();
    private ArrayList <Plane> cargoPlaneTypeList = new ArrayList<Plane>();
    private ArrayList <Plane> passengerPlaneTypeList = new ArrayList<Plane>();

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
     * Метод для додавання літака в авіапарк авіакомпанії
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

    public void PlaneChange(){

    }


    public void PlaneDelete(){

    }

    public void PlaneInfo(){

    }

    public void PlaneList(){

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
    private Plane CreateNewCargoPlane(){
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
    private Plane CreateNewPassengerPlane(){
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

        CargoPlane plane = new CargoPlane(name, flyDistance, fuelConsumption, passengerCapacity);
        passengerPlaneTypeList.add(plane);
        plane.setSideNumber(sideNumber);
        return plane;
    }
}

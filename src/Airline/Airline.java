package Airline;

import Aircraft.*;
import java.util.ArrayList;
import java.util.Scanner;

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

    }

    /**
     * Видалення літака зі списку
     */
    public void PlaneDelete(){

    }

    /**
     * Виведення інформації про літак
     */
    public void PlaneInfo(){

    }

    /**
     * Виводить на екран список літаків
     */
    public void PlaneList(){
        System.out.println("Наявні літаки ("+PlaneList.size()+"):");
        for(int i=0; i<PlaneList.size(); i++){
            System.out.print("\t"+(i+1)+") "+PlaneList.get(i).getName()+" "+PlaneList.get(i).getSideNumber()+" ");

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

    }

    /**
     * Сортування списку літаків за обраним параметром
     */
    public void PlaneListSort(){

    }

    /**
     * Підрахування загальної місткості та вантажопідйомності всього авіапарку
     */
    public void PlaneListSummary(){

    }

    /**
     * Виведення підказки користувачу
     */
    public void Help(){

    }

    /**
     * Виведення інформації про авіалінію
     */
    public void AirlineInfo(){

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

        Plane plane = new Plane(name, flyDistance, fuelConsumption, passengerCapacity, cargoCapacity);
        PlaneTypeList.add(plane);
        return(plane);
    }
}

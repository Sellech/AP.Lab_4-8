package Airline;

import Aircraft.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Airline {
    private final Scanner in = new Scanner(System.in);

    private String airlineName;
    private boolean exist = false;
    private ArrayList <Plane> airlinePlaneList = new ArrayList<Plane>();
    private ArrayList <Plane> planeTypeList = new ArrayList<Plane>();


    public void CreateAirline(){
        System.out.print("Введіть назву нової авіакомпанії: ");
        this.airlineName = in.next();

        // Створюємо базовий каталог типів літаків
        CargoPlane cPlane = new CargoPlane("АН-225 \"Мрія\"", 7000, 16.9,250);
        planeTypeList.add(cPlane);
        cPlane = new CargoPlane("АН-124 \"Руслан\"", 11900, 12.7,120);
        planeTypeList.add(cPlane);
        cPlane = new CargoPlane("Airbus A300-600ST \"Beluga\"", 4600, 8.4,47);
        planeTypeList.add(cPlane);
        cPlane = new CargoPlane("Casa C-295 ", 4600, 2.94,6);
        planeTypeList.add(cPlane);
        cPlane = new CargoPlane("АН-132 ", 4400, 3.41,9);
        planeTypeList.add(cPlane);

        PassengerPlane pPlane= new PassengerPlane("Boeing 757", 7250, 14.8,235);
        planeTypeList.add(pPlane);
        pPlane= new PassengerPlane("Boeing 747 \"Jumbo Jet\"", 14800, 20.4,416);
        planeTypeList.add(pPlane);
        pPlane= new PassengerPlane("АН-24 \"Кокс\"", 14800, 2.93,52);
        planeTypeList.add(pPlane);
        pPlane= new PassengerPlane("Airbus A340", 14600, 19.22,475);
        planeTypeList.add(pPlane);
        pPlane= new PassengerPlane("Airbus A300", 5375, 15.1,269);
        planeTypeList.add(pPlane);

        exist = true;
        System.out.println("Авіакомпанію успішно створено!");
    }

    public void PlaneAdd(){
        System.out.println("Оберіть ");
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

    public boolean getExist(){
        return (exist);
    }
}

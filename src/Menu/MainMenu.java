package Menu;

import Commands.*;
import Commands.AircraftCommand.*;
import Commands.AirlineCommand.*;
import Commands.GeneralCommand.*;

import Airline.Airline;


import java.util.Scanner;

public class MainMenu {
    private static Airline airline;

    public static void start() throws Exception {
        airline = new Airline();
        while (true)
            runMenu();
    }

    public static void runMenu() throws Exception {
        if(!airline.getExist()){
            System.out.println("""            
                --------------------------------------------------------------
                |   Список команд:                                           |
                |       1) Інформація про програму                           |
                |       2) Створити авіакомпанію                             |
                |       3) Зчитати з файлу                                   |
                |       4) Вийти з програми                                  |
                --------------------------------------------------------------
                """);
        }
        else{
            System.out.println("""            
                --------------------------------------------------------------
                |   Список команд:                                           |
                |       1) Help (опис функціоналу)                           |
                |       2) Інформація про авіакомпанію                       |
                |                                                            |
                |       3) Додати новий літак                                |
                |       4) Видалити існуючий                                 |
                |       5) Змінити параметри літака                          |
                |       6) Довідка про літак                                 |
                |                                                            |
                |       7) Список літаків                                    |
                |       8) Відсортувати список                               |
                |       9) Вивести перелік літаків, які відповідають         |
                |          введеному діапазону параметрів                    |
                |      10) Підрахувати загальну місткість та                 |
                |          вантажопідйомність всього авіапарку               |
                |                                                            |
                |      11) Зберегти у файл                                   |
                |      12) Вийти з програми                                  |
                --------------------------------------------------------------
                """);
        }
        choice();
    }

    private static void choice() throws Exception {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        Command[] commandArray;

        if(!airline.getExist()){
            commandArray = new Command[]{
                    new ProgramInfo(),
                    new CreateAirline(),
                    new ReadFromFile(),
                    new Exit()
            };
        }
        else{
            commandArray = new Command[]{
                    new Help(),
                    new PlaneAdd(),
                    new PlaneDelete(),
                    new PlaneChange(),
                    new PlaneInfo(),
                    new PlaneList(),
                    new PlaneListSort(),
                    new PlaneListRange(),
                    new PlaneListSummary(),
                    new SaveToFile(),
                    new Exit()
            };
        }

        if ((input > 0) && (input <= commandArray.length)) {
            commandArray[input-1].execute(airline);
        }
        else
            System.out.println("Неправильна команда!");
    }
}
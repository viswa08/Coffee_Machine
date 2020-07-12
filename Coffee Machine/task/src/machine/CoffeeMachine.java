package machine;


import java.util.Scanner;


public class CoffeeMachine {

    private static int moneyInMachine = 550;
    private static int waterInMachine = 400;
    private static int milkInMachine = 540;
    private static int coffeeBeansInMachine = 120;
    private static int cupsInMachine = 9;
    private static boolean end = false;

    public static void machineContent(){
        System.out.printf("%d of water\n%d of milk\n%d of coffee beans\n%d of disposable cups\n$%d of money\n",waterInMachine,milkInMachine,coffeeBeansInMachine,cupsInMachine,moneyInMachine);
    }

    public static void buyAction(int coffeeOption){
        switch(coffeeOption){
            case 1: //espresso
                waterInMachine -= 250;
                coffeeBeansInMachine -= 16;
                moneyInMachine += 4;
                cupsInMachine--;
                if(waterInMachine < 0 || coffeeBeansInMachine < 0 || cupsInMachine < 0 ){
                    System.out.println("Sorry, not enough water!");
                    waterInMachine += 250;
                    coffeeBeansInMachine += 16;
                    cupsInMachine++;
                }else {
                    System.out.println("I have enough resources, making you a coffee!");
                }
                break;
            case 2: //latte
                waterInMachine -= 350;
                milkInMachine -= 75;
                coffeeBeansInMachine -= 20;
                moneyInMachine += 7;
                cupsInMachine--;
                if(waterInMachine < 0 || coffeeBeansInMachine < 0 || cupsInMachine < 0 || milkInMachine <0){
                    System.out.println("Sorry, not enough water!");
                    waterInMachine += 350;
                    milkInMachine += 75;
                    coffeeBeansInMachine += 20;
                    cupsInMachine++;
                }else {
                    System.out.println("I have enough resources, making you a coffee!");
                }
                break;
            case 3: //cappuccino
                waterInMachine -= 200;
                milkInMachine -= 100;
                coffeeBeansInMachine -= 12;
                moneyInMachine += 6;
                cupsInMachine--;
                if(waterInMachine < 0 || coffeeBeansInMachine < 0 || cupsInMachine < 0 || milkInMachine <0){
                    System.out.println("Sorry, not enough water!");
                    waterInMachine += 200;
                    milkInMachine += 100;
                    coffeeBeansInMachine += 12;
                    cupsInMachine++;
                }else {
                    System.out.println("I have enough resources, making you a coffee!");
                }
                break;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        while(!end) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = sc.nextLine();
            switch(action){
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                    String coffeeOption_t = sc.nextLine();
                    if (coffeeOption_t.compareTo("back") == 0){
                        break;
                    }
                    int coffeeOption = Integer.parseInt(coffeeOption_t);
                    buyAction(coffeeOption);
                    break;
                case "fill":
                    System.out.println("Write how many ml of water do you want to add: ");
                    waterInMachine += sc.nextInt();
                    System.out.println("Write how many ml of milk do you want to add: ");
                    milkInMachine += sc.nextInt();
                    System.out.println("Write how many grams of coffee beans do you want to add:");
                    coffeeBeansInMachine += sc.nextInt();
                    System.out.println("Write how many disposable cups of coffee do you want to add: ");
                    cupsInMachine += sc.nextInt();

                    break;
                case "take":
                    System.out.println("I gave you $" + moneyInMachine);
                    moneyInMachine = 0;

                    break;
                case "remaining":
                    machineContent();
                    break;
                case "exit":
                    end = true;
                    break;
            }
        }


    }
}

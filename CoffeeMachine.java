package machine;

import java.util.Scanner;


public class CoffeeMachine {
    int waterAmount = 400;
    int milkAmount = 540;
    int beansAmount = 120;
    int cupsAmount = 9;
    int dollarAmount = 550;
    int fillCounter = 0;
    CoffeeMachineState state = CoffeeMachineState.ACTION;


    public void CoffeeMachine(String input) {
        if (state == CoffeeMachineState.ACTION) {
            switch (input) {
                case "buy":
                    state = CoffeeMachineState.BUYING;
                    break;
                case "fill":
                    state = CoffeeMachineState.FILLING;
                    break;
                case "take":
                    System.out.println("\nI gave you $" + dollarAmount);
                    dollarAmount = 0;
                    break;
                case "remaining":
                    System.out.println("\nThe coffee machine has:\n" + waterAmount + " of water\n" + milkAmount + " of milk\n" + beansAmount + " of coffee beans\n" + cupsAmount + " of disposable cups\n" + dollarAmount + " of money\n");
                    break;
                case "exit":
                    break;
                default:
                    System.out.println("Invalid Command");
            }
        } else if (state == CoffeeMachineState.BUYING) {
            System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
            switch (input) {
                case "1":
                    if (waterAmount - 250 < 0) {
                        System.out.println("Sorry, not enough water!");
                    } else if (beansAmount - 16 < 0) {
                        System.out.println("Sorry, not enough beans!");
                    } else if (cupsAmount - 1 < 0) {
                        System.out.println("Sorry, not enough cups!");
                    } else {
                        System.out.println("I have enough resources, making you a coffee!\n");
                        waterAmount = waterAmount - 250;
                        beansAmount = beansAmount - 16;
                        dollarAmount = dollarAmount + 4;
                        cupsAmount = cupsAmount - 1;
                    }
                    break;
                case "2":
                    if (waterAmount - 350 < 0) {
                        System.out.println("Sorry, not enough water!");
                    } else if (beansAmount - 20 < 0) {
                        System.out.println("Sorry, not enough beans!");
                    } else if (milkAmount - 75 < 0) {
                        System.out.println("Sorry, not enough milk!");
                    } else if (cupsAmount - 1 < 0) {
                        System.out.println("Sorry, not enough cups!");
                    } else {
                        System.out.println("I have enough resources, making you a coffee!\n");
                        waterAmount = waterAmount - 350;
                        milkAmount = milkAmount - 75;
                        beansAmount = beansAmount - 20;
                        dollarAmount = dollarAmount + 7;
                        cupsAmount = cupsAmount - 1;
                    }
                    break;
                case "3":
                    if (waterAmount - 200 < 0) {
                        System.out.println("Sorry, not enough water!");
                    } else if (beansAmount - 12 < 0) {
                        System.out.println("Sorry, not enough beans!");
                    } else if (milkAmount - 100 < 0) {
                        System.out.println("Sorry, not enough milk!");
                    } else if (cupsAmount - 1 < 0) {
                        System.out.println("Sorry, not enough cups!");
                    } else {
                        waterAmount = waterAmount - 200;
                        milkAmount = milkAmount - 100;
                        beansAmount = beansAmount - 12;
                        dollarAmount = dollarAmount + 6;
                        cupsAmount = cupsAmount - 1;
                    }
                    break;
                case "back":
                    break;
            }
            state = CoffeeMachineState.ACTION;
        }else if(state == CoffeeMachineState.FILLING){
            if(this.fillCounter == 0){
                System.out.println("\nWrite how many ml of water do you want to add:");
                this.waterAmount = waterAmount + Integer.parseInt(input);
                ++this.fillCounter;
            }else if(this.fillCounter == 1){
                System.out.println("Write how many ml of milk do you want to add:");
                this.milkAmount = milkAmount + Integer.parseInt(input);
                ++this.fillCounter;
            }else if(this.fillCounter == 2){
                System.out.println("Write how many grams of coffee beans do you want to add:");
                this.beansAmount = beansAmount + Integer.parseInt(input);
                ++this.fillCounter;
            }else if(this.fillCounter == 3){
                System.out.println("Write how many disposable cups of coffee do you want to add:");
                this.cupsAmount = cupsAmount + Integer.parseInt(input);
                this.fillCounter = 0;
                state = CoffeeMachineState.ACTION;
            }
        }
    }

    enum CoffeeMachineState {
        ACTION(1, "Choosing an action"),
        BUYING(2, "Choosing a coffee variant"),
        FILLING(3, "Filling supplies");

        int num;
        String description;

        CoffeeMachineState(int num, String description) {
            this.num = num;
            this.description = description;
        }

        public int getNum() {
            return num;
        }

        public String getDescription() {
            return description;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String coffeeType;
        String input = "";
        CoffeeMachine coffeeMachine = new CoffeeMachine();

        while (!input.equals("exit")) {
            input = scanner.next();
            coffeeMachine.CoffeeMachine(input);
        }
    }
}

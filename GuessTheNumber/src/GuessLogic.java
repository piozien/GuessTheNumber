
import java.util.Random;
import java.util.Scanner;

public class GuessLogic {
    public void GuessTheNumber(){
        game();
    }

    private int drawNumber() {
        Random random = new Random();
        int intNumber = random.nextInt(100) +1;
        return intNumber;
    }
    public void game(){
        System.out.println("Hi, it's a guess the number game! You have 4 attempts to correctly predict a number between 1 and 100. Good luck!");
        int number = drawNumber();
        boolean win = false;
        for(int i = 1; i < 5; i++){
            Scanner scan = new Scanner(System.in);
            System.out.print("\nEnter a " + i +" number: ");
            int enteredNumber = scan.nextInt();
            if(enteredNumber == number){
                System.out.println("Amazing, you guessed it!");
                win = true;
                break;
            } else if (enteredNumber > number) {
                System.out.print("The number entered is too large :( There are still " + (4-i) +" trials left");
            } else if (enteredNumber < number) {
                System.out.print("The number entered is too small :( There are still " + (4-i) +" trials left");
            }
        }
        if(!win){
            System.out.print("\nThe drawn number was: " + number);
        }

    }


}

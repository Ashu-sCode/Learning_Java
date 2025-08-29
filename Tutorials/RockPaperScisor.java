import java.util.*;

public class RockPaperScisor {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your choice: (Rock, Paper, Scissor) : ");
        String userChoice = scanner.nextLine();

        String[] choices = { "Rock", "Paper", "Scissor" };
        Random random = new Random();
        int computerChoiceIndex = random.nextInt(choices.length);
        String computerChoice = choices[computerChoiceIndex];

        System.out.println("You chose: " + userChoice);
        System.out.println("Computer chose: " + computerChoice);

     if(userChoice.equals(computerChoice)) {
        System.out.println("It's a tie!");
     } else if (userChoice.equals("Rock") && computerChoice.equals("Scissor")) {
        System.out.println("You win!");
     } else if (userChoice.equals("Paper") && computerChoice.equals("Rock")) {
        System.out.println("You win!");
     } else if (userChoice.equals("Scissor") && computerChoice.equals("Paper")) {
        System.out.println("You win!");
     } else {
        System.out.println("You lose!");
     }

    }
}

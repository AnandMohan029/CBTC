import java.util.Scanner;

public class guessingGame{
    public static void main(String[] args) {
       int i; 
       for(i=0;i<6;i++){
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter your guess Number:-");
        int number = myObj.nextInt();  
        int randomNum=(int)(Math.random()*6)+1;
          if(number==randomNum){
            System.out.println("You Won!!");
            break;
          }else{
            System.out.println("SORRY! You LOss!!");
            System.out.println("Random Number Was "+ randomNum);
          }
       }
    }
}
//I kept the limit upto 6 because it's easy to match number between them and to demonstarate them.


/*Increaing limit to show that we did not get a match easily 
and to show that user have n number of chances only.*/
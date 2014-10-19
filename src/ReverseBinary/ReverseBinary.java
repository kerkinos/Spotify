package ReverseBinary;

import java.util.Scanner;

public class ReverseBinary {

  public static void main(String[] args) {

    //Read a number between 1 and 1000000000"
    Scanner in = new Scanner(System.in);

    try {

      int a = in.nextInt();
      if (a <= 1000000000 && a >= 1) {

        //Where the magic happens
        reverse(a);

      } else {
        System.exit(0);
      }

    }
    //Used for debugging, but should not print anything according to instructions
    catch (Exception e){
      in.close();
    //e.printStackTrace();
    }
  }

  //Method that turn an integer into binary
  //then reverses the binary
  //and prints the new integer
  private static void reverse(int a) {
    String binary = Integer.toBinaryString(a);
    StringBuilder reversedSB = new StringBuilder(binary).reverse();
    String reversedString = reversedSB.toString();
    int reversedInt = Integer.parseInt(reversedString, 2);
    System.out.println(reversedInt);
  }

}

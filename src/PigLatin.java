import java.util.Scanner;

/**
 * This Program allows the user to write sentences in Pig Latin until
 * they choose to quit. The following conventions are used:
 * Words that begin with a vowel are appended with "way".
 * Words with vowel somewhere between the first and last letters have
 * the wor split at the first vowel and append the split to the end
 * and add "ay" after.
 * Words with only consonants are appeded with "ay". Also, "y" is
 * treated as a consonant and not a vowel.
 *
 * Created by kuwu on 2017/07/04.
 */
public class PigLatin {

  public static void main(String[] args) {
    PigLatin pigLatin = new PigLatin();
    Scanner scan = new Scanner(System.in);
    boolean done = false;
    // loop to continue using or to quit
    while (!done) {


      System.out.println("Enter a sentence to translate:   or enter 'n' to exit");
      String input = scan.nextLine();
      // making a literal check for input of 'n'
      if (input.compareTo("n") != 0) {
        String output = pigLatin.translate(input);
        System.out.println(output);
      } else {
        done = true;
        System.out.println("Goodbye!");
      }
    }

  }
  //
  public String translate(String input) {
    int startPos = 0;
    int endPos = 0;
    String word;
    String output = "";

    while (startPos < input.length()) {
      endPos = findSpace(input, startPos);

      if (endPos >= 0) {
        word = input.substring(startPos, endPos);
        startPos = ++endPos;
        output += verbEvaluation(word) + " ";
      } else {
        word = input.substring(startPos);
        output += verbEvaluation(word);

        break;
      }
    }
    return output;
  }

  // finding the spaces between words in the string
  private int findSpace(String input, int startPos) {
    int i = -1;

    if ((input != null) && (input.length() > 0)) {
      for (i = startPos; (i < input.length()) && (input.charAt(i) != ' '); ++i) {
        // Empty for - in case needed later
      }
    }

    if (i >= input.length()) {
      // No space found in input
      i = -1;
    }

    return i;
  }
  // checking for vowel location
  private String verbEvaluation(String input) {
    if (input.length() > 0) {
      int i;
      String lowerInput = input.toLowerCase();

      for (i = 0; i < input.length(); ++i) {
        if (isVowel(lowerInput.charAt(i))) {
          break;
        }
      }

      if (i == 0) {
        return input + "way";
      } else if (i >= input.length()) {
        return input + "ay";
      } else {
        String tail = input.substring(0, i);
        String head = input.substring(i);
        return head + tail + "ay";
      }
    }
    return "";
  }
  // what is a vowel
  public boolean isVowel(char ch) {

    if ((ch == 'a') || (ch == 'e') || (ch == 'i') || (ch == 'o') || (ch == 'u')) {
      return true;
    }
    return false;
  }


}

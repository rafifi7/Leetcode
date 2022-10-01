import java.io.*; 
import java.util.*;
// Add any extra import statements you may need here


class Main {

  // Add any helper functions you may need here
  

  String[] returnMismatchedWords(String str1, String str2) {
    // Write your code here
    String[] strOne = str1.split(" ");
    String[] strTwo = str2.split(" ");
    
    String[] diffWords = new String[strOne.length + strTwo.length];
    int index = 0;
    int countEqual = 0;
    int count = 0;
    for (int i = 0; i < strOne.length; i++) {
      countEqual = 0;
      for (int j = 0; j < strTwo.length; j++) {
        if (strOne[i].equals(strTwo[j]))
           countEqual++;
      }
      if (countEqual == 0) {
        diffWords[index++] = strOne[i];
        count++;
      }
    }
    
    for (int i = 0; i < strTwo.length; i++) {
      countEqual = 0;
      for (int j = 0; j < strOne.length; j++) {
        if (strTwo[i].equals(strOne[j]))
           countEqual++;
      }
      if (countEqual == 0) {
        diffWords[index++] = strTwo[i];
        count++;
      }
    }
    String[] diff = new String[count];
    for (int i = 0; i < count; i++)
       diff[i] = diffWords[i];
    return diff;
  }







 
  // These are the tests we use to determine if the solution is correct.
  // You can add your own at the bottom.
  int test_case_number = 1;
  void check(String[] expected, String[] output) {
    int expected_size = expected.length; 
    int output_size = output.length; 
    boolean result = true; 
    if (expected_size != output_size) {
      result = false;
    }
    for (int i = 0; i < Math.min(expected_size, output_size); i++) {
      result &= (output[i] == expected[i]);
    }
    char rightTick = '\u2713';
    char wrongTick = '\u2717';
    if (result) {
      System.out.println(rightTick + " Test #" + test_case_number);  
    }
    else {
      System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
      System.out.println(Arrays.toString(expected)); 
      System.out.print(" Your output: ");
      System.out.println(Arrays.toString(output)); 
      System.out.println();
    }
    test_case_number++;
  }
  public void run() throws IOException {
    Scanner sc = new Scanner(System.in);
    
    // Test Case 1
    String str1 = "Firstly this is the first string";
    String str2 = "Next is the second string";
    String[] expected_1 = {"Firstly", "this", "first", "Next", "second"};
    String[] output_1 = returnMismatchedWords(str1, str2);
    check(expected_1, output_1);
    

    // Test Case 2
    String str3 = "This is the first string extra";
    String str4 = "This is the second string";
    String[] expected_2 = {"first", "extra", "second"};
    String[] output_2 = returnMismatchedWords(str3, str4);
    check(expected_2, output_2);

  
    // Test Case 3
    String str5 = "This is the first text";
    String str6 = "This is the second string";
    String[] expected_3 = {"first", "second", "text", "string"};
    String[] output_3 = returnMismatchedWords(str5, str6);
    check(expected_3, output_3);
    
    // Add your own test cases here
    
  }
  public static void main(String[] args) throws IOException {
    new Main().run();
  }
}

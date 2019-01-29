import java.io.PrintWriter;

public class CaesarCipher {
  public static void main(String[] args) {
    parse(args); //wrapper function
  }//main

 /*
  * @param args, an array of Strings from the command line
  * @pre none, we check for correctness of input
  * @post desired output or specified error outputs on terminal
  */
  public static void parse(String[] args) {
    if (args.length == 2) {
      if (args[0].equals("encode")) {
        if (args[1].indexOf(' ') != -1)
          exit1();
        encode(args[1]);
      } else if (args[0].equals("decode")) {
        if (args[1].indexOf(' ') != -1)
          exit1();
        decode(args[1]);
      } else
        exit1();
    } else
      exit2();
  }//parse

  /*
   * @param str, a String
   * @pre str is all lowercase, and does not contain any non-alphabetic chars
   * @post prints all 26 possible ciphers of str to the terminal
   */
  private static void encode(String str) {
    PrintWriter pen = new PrintWriter(System.out, true);
    for (int n = 0; n < 26; n++) {
      char[] cstr = str.toCharArray();
      for (int i = 0; i < str.length(); i++)
        cstr[i] = (char) ((((int) cstr[i] - 97 + n) % 26) + 97);
      pen.println("n = " + n + ": " + (new String(cstr)));
    }//for
    pen.close();
  }//encode

  /*
   * @param str, a String
   * @pre str is all lowercase, and does not contain any non-alphabetic chars
   * @post prints all 26 possible decryptions of str to the terminal
   */
  private static void decode(String str) {
    PrintWriter pen = new PrintWriter(System.out, true);
    for (int n = 0; n < 26; n++) {
      char[] cstr = str.toCharArray();
      for (int i = 0; i < str.length(); i++) {
        int letter = ((int) cstr[i] - 97 - n) % 26;
        if (letter < 0)
          letter += 26;
        cstr[i] = (char) (letter + 97);
      }//for
      pen.println("n = " + n + ": " + (new String(cstr)));
    }//for
    pen.close();
  }//decode

  //wrapper for error type 1
  private static void exit1() {
    System.err.println("Valid options are \"encode\" or \"decode\"");
    System.exit(1);
  }//exit1

  //wrapper for error type 2
  private static void exit2() {
    System.err.println("Incorrect number of parameters");
    System.exit(2);
  }//exit2
}//CaesarCipher

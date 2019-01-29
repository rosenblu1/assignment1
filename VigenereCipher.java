import java.io.PrintWriter;

public class VigenereCipher {
  public static void main(String[] args) {
    parse(args);
  }//main
  
  /*
   * @param args, an array of Strings from the command line
   * @pre none, we check for correctness of input
   * @post desired output or specified error outputs on terminal
   */
  public static void parse(String[] args) {
    if (args.length == 3) {
      if (args[0].equals("encode")) {
        if (args[1].indexOf(' ') != -1 || args[2].indexOf(' ') != -1)
          exit1();
        encode(args[1], args[2]);
      } else if (args[0].equals("decode")) {
        if (args[1].indexOf(' ') != -1 || args[2].indexOf(' ') != -1)
          exit1();
        decode(args[1], args[2]);
      } else
        exit1();
    } else
      exit2();
  }//parse

  /*
   * @param str, a String
   * @pre str is all lowercase, and does not contain any non-alphabetic chars
   * @post prints the encrypted text with the provided key
   */
  private static void encode(String str, String key) {
    PrintWriter pen = new PrintWriter(System.out, true);
    char[] cstr = str.toCharArray();
    char[] kstr = key.toCharArray();
    for (int i = 0; i < str.length(); i++) {
      if (key.length() != 0) {
        int letter = (int) cstr[i] + (int) kstr[i % key.length()];
        letter = (letter - 194) % 26;
        cstr[i] = (char) (letter + 97);
      }//if
    }//for
    pen.println(new String(cstr));
    pen.close();
  }//encode

  /*
   * @param str, a String
   * @pre str is all lowercase, and does not contain any non-alphabetic chars
   * @post prints the decrypted text with the provided key
   */
  private static void decode(String str, String key) {
    PrintWriter pen = new PrintWriter(System.out, true);
    char[] cstr = str.toCharArray();
    char[] kstr = key.toCharArray();
    for (int i = 0; i < str.length(); i++) {
      if (key.length() != 0) {
        int letter = (int) cstr[i] - (int) kstr[i % key.length()];
        letter %= 26;
        if (letter < 0)
          letter += 26;
        cstr[i] = (char) (letter + 97);
      }//if
    }//for
    pen.println(new String(cstr));
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
}//VignereCipher

import javax.swing.JOptionPane;

public class ConvertToBinary
{
  public static void main(String[] args)
  {
    String message = JOptionPane.showInputDialog("Input Your Message in Text:");
    String binaryMessage = "";
    int messageLength = message.length();
    char character;
    int ASCIICharacter;
    String binaryCharacter;
    String checkSum = "1101011";
    String compare = "";
    String converted = "";
    String checkSumMessage = "";
    char[] characterArray = new char[messageLength];

    for (int x = 0; x < messageLength; x++)
      {
        character = message.charAt(x);
        characterArray[x] = character;
        ASCIICharacter = character;
        binaryCharacter = Integer.toBinaryString(ASCIICharacter);
        if (binaryCharacter.length() < 7)
          binaryMessage += "0" + binaryCharacter;
        else
          binaryMessage += binaryCharacter;
      }

    checkSumMessage = binaryMessage + "000000";
    int checkSumMessageLength = checkSumMessage.length();

    while (checkSumMessageLength > 7)
      {
        if (checkSumMessage.charAt(0) == 48)
          checkSumMessage = checkSumMessage.substring(1);
        else
          {
            compare = checkSumMessage.substring(0,7);
            for(int y = 0; y < 7; y++)
              {
                if (compare.charAt(y) == checkSum.charAt(y))
                  converted += "0";
                else
                  converted += "1";
              }
            checkSumMessage = converted + checkSumMessage.substring(7);
            converted = "";
          }
        checkSumMessageLength = checkSumMessage.length();
      }
    int binaryMessageLength = binaryMessage.length();
    String checkSumResult = checkSumMessage.substring(checkSumMessageLength - 6);
    System.out.println("1" + binaryMessage + checkSumResult + "1");
    System.out.println("\nThe number of characters in your binary message is " + (binaryMessageLength + 8));
    System.out.println("\nYour check sum result is " + checkSumResult);
    System.out.println("\nJust the binary message without the flags or check sum is");

    for (int a = 0; a < binaryMessageLength - 6; a += 7)
      {
        binaryCharacter = binaryMessage.substring(a, a + 7);
        System.out.println(a/7 + ":  \"" + characterArray[a/7] + "\" = " + binaryCharacter + "\n");
        if (characterArray[a/7] == ' ')
          {
            System.out.println("======================================================================");
          }
      }
  }
}

/*

 (1) Convert message to 7 bit non-signed binary based on a traditional ASCII table.
 (2) Calculate a 6 bit remainder using a CRC with a divisor of "1101011."
 (3) Transmit a "1" + Binary Message + 6 bit CRC remainder + "1"

 **If the message is entirely in binary, transmit 8 1's followed by the message along with the CRC remainder and a trailing 1.
 **(CRC remainder can be calculated using binaryCheckSumGenerator class.)

 */
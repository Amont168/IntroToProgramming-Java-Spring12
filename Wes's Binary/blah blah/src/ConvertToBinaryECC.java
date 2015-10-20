import javax.swing.JOptionPane;

public class ConvertToBinaryECC
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
    int x = 0;

    for (x = 0; x < messageLength; x++)
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

    int binaryMessageLength = binaryMessage.length();

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

    String checkSumResult = checkSumMessage.substring(checkSumMessageLength - 6);
    System.out.println("\nJust the binary message without the flags or check sum is");

    for (x = 0; x < binaryMessageLength - 6; x += 7)
      {
        binaryCharacter = binaryMessage.substring(x, x + 7);
        System.out.println(x/7 + ":  \"" + characterArray[x/7] + "\" = " + binaryCharacter + "\n");
        if (characterArray[x/7] == ' ')
          {
            System.out.println("======================================================================");
          }
      }
    String binaryMessageECC = "";
    for (x = 0; x<binaryMessageLength; x++)
      {
        binaryMessageECC += binaryMessage.substring(x, x+1);
        binaryMessageECC += binaryMessage.substring(x, x+1);
        binaryMessageECC += binaryMessage.substring(x, x+1);
      }

    String checkSumResultExpanded = "";

    for (x = 0; x<6; x++)
      {
        binaryMessageECC += binaryMessage.substring(x, x+1);
        binaryMessageECC += binaryMessage.substring(x, x+1);
        binaryMessageECC += binaryMessage.substring(x, x+1);
      }

    System.out.println("Your Binary is on the following line:");
    System.out.println("1" + binaryMessageECC + checkSumResultExpanded + "1");
    System.out.println("\nThe number of characters in your binary message is " + (binaryMessageLength*3 + 8));
    System.out.println("\nYour check sum result is " + checkSumResult);
  }
}

/*
 * GROUP 1
 *  Nathan Clark
 *  Dustyne Brown
 *  Kimberyly Driver
 *  Zach Humphry
 *
 **DO NOT COPY TRAILING 1's or 0's**
 *
 (1) Convert message to 7 bit non-signed binary based on a traditional ASCII table.
 (2) Calculate a 6 bit remainder using a CRC with a divisor of "1101011."
 (3) Insert 3 0's for every 0 in your Binary Message and 3 1's for every 1.
 (4) Transmit a "1" + Triplicate Binary Message + 6 bit CRC remainder + "1"
(5) An code must be sent to show if the received message was right or wrong. "1100111" = Right, "1110011" = Wrong.
(6) If you receive a wrong...retransmit, otherwise, respond with another right to end the session.
(7) When decoding...take each triplet as only one bit...if there are 2 or 3 1's...it's a 1, otherwise it's a 0.

 *
 *
 *
 *(REMEMBER...WE ARE USING THE 7 DIGIT "1101011" AS A DIVISOR...OUR CRC REMAINDER IS 6 DIGITS)
 *(The ConvertToBinary program will build everything for you...if you have to send a message
 * To compute an n-bit binary CRC, line the bits representing the input in a row, and position the (n+1)-bit pattern representing the CRC's divisor (called a "polynomial") underneath the left-hand end of the row.

Start with the message to be encoded:

11010011101100
This is first padded with zeroes corresponding to the bit length n of the CRC. Here is the first calculation for computing a 3-bit CRC:

11010011101100 000 <--- input left shifted by 3 bits
1011               <--- divisor (4 bits) = x³+x+1
------------------
01100011101100 000 <--- result
If the input bit above the leftmost divisor bit is 0, do nothing. If the input bit above the leftmost divisor bit is 1, the divisor is XORed into the input (in other words, the input bit above each 1-bit in the divisor is toggled). The divisor is then shifted one bit to the right, and the process is repeated until the divisor reaches the right-hand end of the input row. Here is the entire calculation:

11010011101100 000 <--- input left shifted by 3 bits
1011               <--- divisor
01100011101100 000 <--- result
 1011              <--- divisor ...
00111011101100 000
  1011
00010111101100 000
   1011
00000001101100 000
       1011
00000000110100 000
        1011
00000000011000 000
         1011
00000000001110 000
          1011
00000000000101 000
           101 1
-----------------
00000000000000 100 <---remainder (3 bits)
Since the leftmost divisor bit zeroed every input bit it touched, when this process ends the only bits in the input row that can be nonzero are the n bits at the right-hand end of the row. These n bits are the remainder of the division step, and will also be the value of the CRC function (unless the chosen CRC specification calls for some postprocessing).

The validity of a received message can easily be verified by performing the above calculation again, this time with the check value added instead of zeroes. The remainder should equal zero if there are no detectable errors.

11010011101100 100 <--- input with check value
1011               <--- divisor
01100011101100 100 <--- result
 1011              <--- divisor ...
00111011101100 100

......

00000000001110 100
          1011
00000000000101 100
           101 1
------------------
                 0 <--- remainder
 */
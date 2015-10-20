import javax.swing.JOptionPane;

public class binaryCheckSumGenerator
{
  public static void main(String[] args)
  {
    String binaryMessage = JOptionPane.showInputDialog("Input Your Message in Binary:");
    String checkSum = "1101011";
    String checkSumMessage = "";
    String compare = "";
    String converted = "";

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

    System.out.println("\nYour check sum result is " + checkSumResult);
  }
}
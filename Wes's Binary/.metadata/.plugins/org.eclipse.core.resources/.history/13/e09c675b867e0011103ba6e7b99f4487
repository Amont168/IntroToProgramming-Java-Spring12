import javax.swing.JOptionPane;

public class ConvertToTextEEC
{
  public static void main(String[] args)
  {
    String feedInMessage = JOptionPane.showInputDialog("Input Your Message in Binary:");
    feedInMessage = feedInMessage.trim();
    int feedInMessageLength = feedInMessage.length();
    String binaryMessageNonECC = feedInMessage.substring(1, feedInMessageLength - 19);
    int binaryMessageNonECCLength = binaryMessageNonECC.length();
    int x;
    int total = 0;
    String binaryMessageECC = "";
    String checkSumResultReceivedExpanded = "";
    String checkSumResultReceived = "";
    for(x = 0; x < binaryMessageNonECCLength; x += 3)
      {
        total += binaryMessageNonECC.charAt(x);
        total += binaryMessageNonECC.charAt(x + 1);
        total += binaryMessageNonECC.charAt(x + 2);

        if (total%48 == 0)
          binaryMessageECC += "0";
        if (total%48 == 1)
          binaryMessageECC += "0";
        if (total%48 == 2)
          binaryMessageECC += "1";
        if (total%48 == 3)
          binaryMessageECC += "1";
        total = 0;
      }


    int binaryMessageECCLength = binaryMessageECC.length();
    String message = "";
    String checkSum = "1101011";
    checkSumResultReceivedExpanded = feedInMessage.substring(feedInMessageLength - 19, feedInMessageLength - 1);
    for(x = 0; x < 18; x += 3)
      {
        total += binaryMessageNonECC.charAt(x);
        total += binaryMessageNonECC.charAt(x + 1);
        total += binaryMessageNonECC.charAt(x + 2);

        if (total%48 == 0)
          checkSumResultReceived += "0";
        if (total%48 == 1)
          checkSumResultReceived += "0";
        if (total%48 == 2)
          checkSumResultReceived += "1";
        if (total%48 == 3)
          checkSumResultReceived += "1";
        total = 0;
      }
    String compare = "";
    String converted = "";
    String binaryCharacter = "";
    char character;
    String checkSumMessage = binaryMessageECC + "000000";
    int checkSumMessageLength = checkSumMessage.length();
    int a64;
    int a32;
    int a16;
    int a8;
    int a4;
    int a2;
    int a1;
    int ASCII = 0;

    while (checkSumMessageLength > 7)
      {
        if (checkSumMessage.charAt(0) == 48)
          checkSumMessage = checkSumMessage.substring(1);
        else
          {
            compare = checkSumMessage.substring(0, 7);
            for (x = 0; x < 7; x++)
              {
                if (compare.charAt(x) == checkSum.charAt(x))
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
    if (checkSumResult.equals(checkSumResultReceived))
      System.out.println("Everything seems right, we recieved a Checksum of: " + checkSumResultReceived + " and we calculated a Checksum of: " + checkSumResult);
    else
      System.out.println("Something went wrong, we recieved a Checksum of: " + checkSumResultReceived + ", but we calculated a Checksum of: " + checkSumResult);

    if (binaryMessageECCLength % 7 != 0)
      {
        System.out.println("\nIt looks like you may have accidentally deleted part of the Binary before entering or part of the message may not have been transmitted...be careful.");
        System.out.println("The following translation may be incomplete:");
      }

    for (x = 0; x < binaryMessageECCLength - 6; x += 7)
      {
        binaryCharacter = binaryMessageECC.substring(x, x + 7);

        a64 = binaryCharacter.charAt(0);
        if (a64 == 49)
          ASCII += 64;

        a32 = binaryCharacter.charAt(1);
        if (a32 == 49)
          ASCII += 32;

        a16 = binaryCharacter.charAt(2);
        if (a16 == 49)
          ASCII += 16;

        a8 = binaryCharacter.charAt(3);
        if (a8 == 49)
          ASCII += 8;

        a4 = binaryCharacter.charAt(4);
        if (a4 == 49)
          ASCII += 4;

        a2 = binaryCharacter.charAt(5);
        if (a2 == 49)
          ASCII += 2;

        a1 = binaryCharacter.charAt(6);
        if (a1 == 49)
          ASCII += 1;

        character = (char) ASCII;
        message += character;
        ASCII = 0;
      }
    System.out.println("\nWe have translated your binary to say:");
    System.out.println(message);
  }
}

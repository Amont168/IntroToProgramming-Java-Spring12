import javax.swing.JOptionPane;
public class one {
	public static void main(String[] args) {
			int answer, val1, val2;
			
			val1=getNumberRange(1,100);
			val2=getNumberRange(1,20);
			
			
			answer=val1+val2;
			
			
			System.out.println("Answer is " + answer);

	}





public static int getNumberRange(int lowerbound, int upperbound) {
	String answer;
	int num;
	do {
		answer = JOptionPane.showInputDialog("Enter a number from " + lowerbound + "to" + upperbound);
		num = Integer.parseInt(answer);
		if (num<lowerbound || num>upperbound)
			{
			JOptionPane.showMessageDialog(null, "Number is outside of range");
			}
	}while(num<lowerbound || num>upperbound);
	return num;
	}
}
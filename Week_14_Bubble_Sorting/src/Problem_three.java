import javax.swing.JOptionPane;
public class Problem_three {
public static void main(String[] args) {
		
		int entry0=0, males=0, females=0, invalid=0;
		String bob="nothing";
		
		input(entry0, males, females, invalid, bob);
		
		System.out.println("Males   :" + males);
		System.out.println("Females :" + females);
		System.out.println("Invalid :" + invalid);
	}

public static int input(int entry0, int males, int females, int invalid,
		String bob) {
	while(entry0!=-999){
		bob=JOptionPane.showInputDialog(null,"Please enter a number 1 for males, 2 for females, -999 to exit.");
		entry0=Integer.parseInt(bob);
			if(entry0==1){
				males++;
						}
			else if(entry0==2){
				females++;
						}
			else if(entry0==-999){
				break;
			}
			else{
				invalid++;
			}		
		}
	return entry0;
	return females;
	
}
}

import javax.swing.JOptionPane;
public class Problem_two {
	public static void main(String[] args) {
		
		int entry0=0, males=0, females=0, invalid=0;
		String bob;
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
		System.out.println("Males   :" + males);
		System.out.println("Females :" + females);
		System.out.println("Invalid :" + invalid);
	}
}

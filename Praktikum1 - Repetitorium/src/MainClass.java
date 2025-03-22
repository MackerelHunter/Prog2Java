import java.util.Arrays;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		doExercise1();
	}
	
	static void doExercise1() {
		int[][] dreieck = new int[6][];
		for (int i = 0; i < dreieck.length; i++) {
			dreieck[i] = new int[i+1];		
		}
		System.out.println(Arrays.deepToString(dreieck));
		for (int i = 0; i < dreieck.length; i++) {
			for (int j = 0; j < dreieck[i].length; j++) {
				if ((j == 0) || (j == i)) {
					dreieck[i][j] = 1;
				} else {
					dreieck[i][j] = dreieck[i-1][j]+dreieck[i-1][j-1];
				}
			}
		}
		System.out.println(Arrays.deepToString(dreieck));
		
	}
	
	

}

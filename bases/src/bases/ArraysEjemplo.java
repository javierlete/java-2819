package bases;

import java.util.Arrays;

public class ArraysEjemplo {
	public static void main(String[] args) {
		int[] arr = new int[3];
		
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		
		System.out.println(Arrays.toString(arr));
		
		int total = 0;
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println("Posición " + i + " = " + arr[i]);
			
			total += arr[i];
		}
		
		System.out.println(total);
		
		for(int dato: arr) {
			System.out.println(dato);
		}
	}
}

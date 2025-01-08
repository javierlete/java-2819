package bases;

public class Bucles {
	public static void main(String[] args) {
		int num = 1;

		while (num <= 10) {
			System.out.print(num + " ");
			num++; // num += 1; // num = num + 1;
		}

		System.out.println();

		do {
			num--; // num -= 1; // num = num - 1;
			System.out.print(num + " ");
		} while (num > 1);

		System.out.println();

		for (int n = 1; n <= 10; n++) {
			System.out.print(n + " ");
		}
	}
}

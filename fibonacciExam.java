// изкарване на редицата на Фибоначи
public class Fibonacci {

	public static void main(String[] args){
		int fibCount = 150;
		int[] fib = new int[fibCount];
		fib[0] = 0;
		fib[1] = 1;
		for (int i = 2; i < fibCount; i++){
			fib[i] = fib[i - 1] + fib[i - 2];
		}

		for (int i = 0; i < fibCount; i++){
			System.out.print(fib[i] + " ");
		}
	}

}
 
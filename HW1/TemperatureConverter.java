import java.util.Scanner;
import java.lang.Math;

class TemperatureConverter {
	public static void main(String[] args) {
		String question = "Enter a temperature in Kelvin: ";
		Scanner input = new Scanner(System.in);
		System.out.print(question);
		String k = input.nextLine();
		double kelvin = Double.parseDouble(k);
		double f = (kelvin * (9.0/5.0) - 459.67);
		double rounded = (double) Math.round(f * 100) / 100;
		System.out.print(k + " Kelvin is ");
		System.out.printf("%.2f", rounded);
		System.out.print(" degrees Fahrenheit\n");
	}
}

/*In order to help learn course concepts, I worked on the homework with Gabi Schweinfurth, and consulted related material 
that can be found at https://www.sololearn.com/Play/Java, https://docs.oracle.com/javase/8/docs/api/
https://stackoverflow.com/questions/10959424/show-only-two-digit-after-decimal/10959430#10959430.
https://stackoverflow.com/questions/5769669/convert-string-to-double-in-java*/
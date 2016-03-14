package Hw2;

import java.lang.Math;
import java.util.Scanner;
import java.text.DecimalFormat;

public class SolveEquation {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		double coef_a = keyboard.nextDouble();
		double coef_b = keyboard.nextDouble();
		double coef_c = keyboard.nextDouble();
		String formatinput = keyboard.next();
		DecimalFormat pattern = new DecimalFormat(formatinput);
		double root1 = ((-1) * coef_b + Math.sqrt( Math.pow(coef_b, 2) - 4.0 *coef_a * coef_c )) / (2.0*coef_a);
		double root2 = ((-1) * coef_b - Math.sqrt( Math.pow(coef_b, 2) - 4 *coef_a * coef_c )) / (2*coef_a);
		System.out.println(pattern.format(root1));
		System.out.println(pattern.format(root2));
	}
}

package Polynomial;

import java.text.DecimalFormat;

import Operations.OpWith2Terms;

/*Polynom class implements the basic features of a polynomial.
 * It transforms a String read from the keyboard into an object
 * and viceversa. It gets the degree of a polynomial and it 
 * implements a polynom(more like monomyal) creation.
 * */
public class Polynom {
	public double[] coefficients;
	public int degree;
	int n = 0;

	/*
	 * The constructor gets 2 arguments , an integer which will be the
	 * coefficient and another integer which will be the exponent. It's more or
	 * less a monomyal which is going to be added to an array of coefficients.
	 * The exponent(power) represents the index where the coefficient will be
	 * added in the array
	 */
	public Polynom(int coeff, int power) {
		coefficients = new double[power + 1];
		coefficients[power] = coeff;
		degree = degr();
	}

	/*
	 * The following method named degr is a method that gets no arguments and
	 * using a for loop it gets the highest exponent of an ax which has a
	 * coefficient different from 0. It returns an integer which will be the
	 * degree of the polynomial
	 */
	public int degr() {
		int d = 0;
		for (int i = 0; i < coefficients.length; i++) {
			if (coefficients[i] != 0)
				d = i;
		}
		return d;
	}

	/*
	 * parseToPoly is a method that gets a String as an argument which is going
	 * to be split into parts so that it's content can be interpreted as a
	 * polynomial. Each coefficient and exponent read separately will be loaded
	 * into 2 arrays coefS and degS. After loading the coefficients and
	 * exponents into the arrays we create a new polynom object which will be
	 * added to the main polynomial. It returns a Polynom object.
	 */
	public Polynom parseToPoly(String s) {
		int[] coefS = new int[50];
		int[] degS = new int[50];
		OpWith2Terms obj = new OpWith2Terms();
		Polynom polynomial = new Polynom(0, 0);
		String[] coef = s.split("[xX]\\^(-?\\d+\\b)");
		for (String part : coef) {
			int nr = 0;
			if (part.equals(""))
				nr = 1;
			else if (part.equals("-"))
				nr = -1;
			else
				nr = Integer.parseInt(part);
			n++;
			coefS[n] = nr;
		}
		int nrOfCoef = n;
		n = 0;
		// for degree
		String[] degree = s.split("(-|\\+)");
		for (String part : degree) {
			if (part.contains("^")) {
				part = part.substring(part.lastIndexOf("^") + 1);
				int nr = Integer.parseInt(part);
				n++;
				degS[n] = nr;
			}
		}
		for (int i = 1; i <= nrOfCoef; i++) {
			int a = coefS[i];
			int b = degS[i];
			Polynom aux = new Polynom(a, b);
			polynomial = obj.add(polynomial, aux);
		}
		return polynomial;
	}

	/*
	 * This method is supposed to translate the content of a polynom object into
	 * readable user format i.e. String. It takes no arguments and it returns a
	 * String.
	 */
	public String toString() {
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		if (degree == 0)
			return "" + df.format(coefficients[0]);
		if (degree == 1)
			if (coefficients[1] == 1)
				if (coefficients[0] > 0)
					return "x " + "+" + df.format(coefficients[0]);
				else
					return "x " + df.format(coefficients[0]);
			else if (coefficients[1] == -1)
				return "-x " + df.format(coefficients[0]);
			else
				return df.format(coefficients[1]) + "x " + df.format(coefficients[0]);
		String poly = "";
		if (coefficients[degree] == 1)
			poly = "x^" + degree;
		else if (coefficients[degree] == -1)
			poly = "-x^" + degree;
		else
			poly = df.format(coefficients[degree]) + "x^" + degree;
		for (int i = degree - 1; i >= 0; i--) {
			if (coefficients[i] == 0)
				continue;
			else if (coefficients[i] > 0)
				if (coefficients[i] == 1 && i != 0)
					poly = poly + " + ";
				else if (coefficients[0] == 1)
					poly = poly + " +1";
				else
					poly = poly + " + " + df.format(coefficients[i]);
			else if (coefficients[i] < 0)
				if (coefficients[i] == -1 && i != 0)
					poly = poly + " - ";
				else if (coefficients[0] == -1)
					poly = poly + " -1";
				else
					poly = poly + " - " + df.format(-coefficients[i]);
			if (i == 1)
				poly = poly + "x";
			else if (i > 1)
				poly = poly + "x^" + i;
		}
		return poly;

	}
}

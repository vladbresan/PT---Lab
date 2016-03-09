package Operations;

import Polynomial.Polynom;

/* The OpWith1Term class implements the operations which are performed
 * on one polynomial by overriding the methods created in the interface
 * OneTermOperation
 * */
public class OpWith1Term implements OneTermOp {
	/*
	 * The diff method implements the differentiation of a polynomial. It takes
	 * as an argument an object Polynom and returns an object Polynom named
	 * deriv. The for loop starts at the lowest index which represents the term
	 * with x^0 and from there it builds the derivative by multiplying the
	 * exponent with the coefficient. Ex: 2x^4 will become 4(exponent, i+1
	 * )*2(coefficient, coefficients[i+1])*x^3(the new index i)
	 **/

	@Override
	public Polynom diff(Polynom p) {
		if (p.degree == 0)
			return new Polynom(0, 0);
		Polynom deriv = new Polynom(0, p.degree - 1);
		deriv.degree = p.degree - 1;
		for (int i = 0; i < p.degree; i++)
			deriv.coefficients[i] = (i + 1) * p.coefficients[i + 1];
		return deriv;
	}

	/* Antiderivative * TO DO ! */
	@Override
	public Polynom integr(Polynom p) {
		Polynom integral = new Polynom(0, p.degree + 1);
		for (int i = p.degree; i >= 0; i--)
			integral.coefficients[i + 1] = p.coefficients[i] / (i + 1);
		integral.degree = integral.degr();
		return integral;
	}

	/* Value of polynomial at point x * TO DO ! */
	@Override
	public double evaluate(Polynom p, double x) {
		double val = 0;
		p.degree = p.degr();
		for (int i = p.degree; i >= 0; i--) {
			double aux = (double) i;
			val += p.coefficients[i] * (Math.pow(x, aux));
		}
		return val;
	}

	/* Definite integral from a to b * TO DO ! */
	@Override
	public double integrAtoB(Polynom p, double a, double b) {
		Polynom integral = new Polynom(0, p.degree + 1);
		double val = 0;
		integral = integr(p);
		val = evaluate(integral, b) - evaluate(integral, a);
		return val;
	}

}

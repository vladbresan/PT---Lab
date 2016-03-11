package Operations;

import Polynomial.Polynom;

public class OpWith2Terms implements TwoTermOp {
	/*
	 * Addition of two polynomials. This method performs the additon of two
	 * polynomials. It adds the coefficient for a specific exponent into an
	 * object c of type Polynom.
	 */
	@Override
	public Polynom add(Polynom p, Polynom q) {
		Polynom c = new Polynom(0, Math.max(p.degree, q.degree));
		for (int i = 0; i <= p.degree; i++)
			c.coefficients[i] += p.coefficients[i];
		for (int i = 0; i <= q.degree; i++)
			c.coefficients[i] += q.coefficients[i];
		c.degree = c.degr();
		return c;
	}

	/*
	 * Substraction of two polynomials. This method performs the substraction of
	 * two polynomials. Firstly it "copies" the first polynomial to another
	 * polynom object which is going to be returned. After the object that is to
	 * be returned has the same values with the first polynomial it substracts
	 * the second polynomial given as argument from the polynomial that is to be
	 * returned
	 */
	@Override
	public Polynom sub(Polynom p, Polynom q) {
		Polynom c = new Polynom(0, Math.max(p.degree, q.degree));
		for (int i = 0; i <= p.degree; i++)
			c.coefficients[i] += p.coefficients[i];
		for (int i = 0; i <= q.degree; i++)
			c.coefficients[i] -= q.coefficients[i];
		c.degree = c.degr();
		return c;
	}

	/*
	 * Division of two polynomials. This method performs the division of two
	 * polynomials. In case the the 2nd polynomial is the zero polynomial it
	 * will thrown a division by zero exception. It willl also throw an
	 * exception if the degree of the second polynomial greater than the degree
	 * of the first polynomial. The algorithm works as follows: it takes the
	 * monomial with the highest exponent of the first polynom and it divides
	 * it's coefficient to the coefficient of the highest monomial. The result
	 * is the coefficient of the monomial with the exponent given by
	 * substracting the exponent of the second monomial from the exponent of the
	 * first monomial. This step is perfomed in a while loop until the degree of
	 * the first polynomial is lower than the degree of the second polynomial.
	 * each time a division of two monomials is performed the product of the
	 * resulted coefficient with each coefficient of the second polynomial is
	 * substracted from the first polynomial , this way the division is perfomed
	 * until a division can no longer be performed. The method takes 2 arguments
	 * of type Polynom and returns a Polynom object.
	 */
	@Override
	public Polynom div(Polynom p, Polynom q) {
		if ((q.degree == 0) && (q.coefficients[0] == 0))
			throw new RuntimeException("Division by zero polynomial");

		if (p.degree < q.degree && p.degree != 0)
			throw new RuntimeException("Grade of first polynomial lower than grade of second polynomial");
		if (p.degree == 0)
			return new Polynom(0, 0);
		Polynom quotient = new Polynom(0, p.degree - q.degree);
		quotient.degree = p.degree - q.degree;

		while (p.degree >= q.degree) {
			int i = p.degree;
			int j = q.degree;
			int aux = p.degree - q.degree;
			if (q.coefficients[j] > 0)
				quotient.coefficients[aux] = p.coefficients[i] / q.coefficients[j];
			for (int k = p.degree; k >= 0; k--) {
				if (j >= 0)
					p.coefficients[k] -= (q.coefficients[j] * quotient.coefficients[aux]);
				j--;
			}
			p.degree = p.degr();
		}
		return quotient;
	}

	/*
	 * Multiplication of two polynomials.It's a method that takes as input
	 * arguments two objects of type Polynom and returns a Polynom. The
	 * algorithm is composed of a nested for statement which multiplies each
	 * coefficient of polynomial 1 with each coefficient of the second
	 * polynomial. If the indexes(exponents) match the coefficients for that
	 * specific exponent are added together
	 */
	@Override
	public Polynom mul(Polynom p, Polynom q) {
		Polynom c = new Polynom(0, p.degree + q.degree);
		for (int i = 0; i <= p.degree; i++)
			for (int j = 0; j <= q.degree; j++)
				c.coefficients[i + j] += (p.coefficients[i] * q.coefficients[j]);
		c.degree = c.degr();
		return c;
	}

	/*
	 * Check if the two polynomials are identical. This method takes as input
	 * arguments two objects Polynom and returns true if the two objects hold
	 * the same values of coefficients for the exponents. It returns false is
	 * they are not the same .
	 */
	@Override
	public boolean equality(Polynom p, Polynom q) {
		if (p.degree != q.degree)
			return false;
		for (int i = p.degree; i >= 0; i--)
			if (p.coefficients[i] != q.coefficients[i])
				return false;
		return true;
	}

}

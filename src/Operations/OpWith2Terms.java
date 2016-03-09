package Operations;

import Polynomial.Polynom;

public class OpWith2Terms implements TwoTermOp {
	/* Addition of two polynomials * TO DO ! */
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

	/* Substraction of two polynomials * TO DO ! */
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

	/* Division of two polynomials * TO DO ! */
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

	/* Multiplication of two polynomials * TO DO ! */
	@Override
	public Polynom mul(Polynom p, Polynom q) {
		Polynom c = new Polynom(0, p.degree + q.degree);
		for (int i = 0; i <= p.degree; i++)
			for (int j = 0; j <= q.degree; j++)
				c.coefficients[i + j] += (p.coefficients[i] * q.coefficients[j]);
		c.degree = c.degr();
		return c;
	}

	/* Check if the two polynomials are identical * TO DO ! */
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

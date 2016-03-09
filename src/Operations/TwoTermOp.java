package Operations;

import Polynomial.Polynom;

/*Interface for the operations perfomed on 2 polynomials */
public interface TwoTermOp {
	/* Addition of two polynomials * TO DO ! */
	Polynom add(Polynom p, Polynom q);

	/* Substraction of two polynomials * TO DO ! */
	Polynom sub(Polynom p, Polynom q);

	/* Division of two polynomials * TO DO ! */
	Polynom div(Polynom p, Polynom q);

	/* multiplication of two polynomials * TO DO ! */
	Polynom mul(Polynom p, Polynom q);

	/* Equality test of two polynomials * TO DO ! */
	boolean equality(Polynom p, Polynom q);
}

package Operations;

import Polynomial.Polynom;

/*Interface for the operations perfomed on 1 polynomial */
public interface OneTermOp {
	/* Derivation of a polynomial */
	Polynom diff(Polynom p);

	/* Antiderivative of a polynomial */
	Polynom integr(Polynom p);

	/* Evaluation at point x of a polynomial */
	double evaluate(Polynom p, double x);

	/* Definite integral of a polynomial */
	double integrAtoB(Polynom p, double a, double b);
}

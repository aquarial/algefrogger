package algefrogger.game;

import java.util.Random;

public class EquationGenerator {

	int xL, xR; // Left and right x values
	int constL, constR; // Left and right constant values
	String signL, signR; // Left and right operator signs (+/-)
	int ansMax = 9; // Maximum value for answer (CANNOT BE NEGATIVE)
	int divMax = 4; // Maximum value for end division step
	int answer; // Final answer of equation
	Random r = new Random(); // Random obj
	String eqL = "", eqR = ""; // Equation left and right

	/**
	 * Constructs a new EquationGenerator object
	 */
	public EquationGenerator() {
		generateNewEquation();
	}

	/**
	 * Randomly generates a new equation for EG object
	 */
	public void generateNewEquation() {
		answer = r.nextInt(ansMax) + 1;
		int div = r.nextInt(divMax) + 1;

		while (answer % div != 0) {
			answer = r.nextInt(ansMax) + 1;
		}
		xL = div + r.nextInt(3);
		xR = xL - (Math.random() > .5 ? div : -div);

		int tmp = answer * div;

		if (xL > xR) {
			constL = r.nextInt(tmp) - r.nextInt(tmp);
			constR = tmp + constL;
		} else {
			constR = r.nextInt(tmp) - r.nextInt(tmp);
			constL = tmp + constR;
		}
		signL = constL > 0 ? " + " : " - ";
		signR = constR > 0 ? " + " : " - ";

		eqL = constructSide(xL, constL, signL);
		eqR = constructSide(xR, constR, signR);
	}

	/**
	 * Returns an int value of the answer
	 * @return answer
	 */
	public int getAnswer() {
		return answer;
	}
	/**
	 * Returns a String value of the equation
	 * @return equation
	 */
	public String getEquation() {
		return eqL + " = " + eqR;
	}

	/**
	 * Creates one side of the equation with the given parameters
	 * @param x
	 *            x value
	 * @param c
	 *            constant value
	 * @param s
	 *            intermittent sign
	 * @return Constructed side
	 */
	private String constructSide(int x, int c, String s) {
		String tmp;
		boolean xZero = x == 0, cZero = c == 0;

		if (xZero && cZero)
			tmp = "0";
		else if (!xZero && cZero)
			tmp = x + "x";
		else if (!xZero && !cZero)
			tmp = x + "x" + s + Math.abs(c);
		else
			tmp = c + "";

		return tmp;
	}
}

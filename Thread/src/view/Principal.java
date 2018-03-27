package view;

import controller.ThreadCalc;

public class Principal {

	public static void main(String[] args) {
		int a = 10;
		int b = 10;
		// int op = 2;
		for (int op = 0; op <= 3; op++) {
			ThreadCalc tCalc = new ThreadCalc(a, b, op);
			tCalc.start();
		}

	}

}

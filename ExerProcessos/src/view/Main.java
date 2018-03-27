	package view;

import javax.swing.JOptionPane;

import controller.RedesController;

public class Main {
	public static void main(String[] args) {
		int op = 0;
		while (op != 9) {
			op = Integer.parseInt(JOptionPane.showInputDialog("1- IP\n2- Ping\n9- Sair"));
			switch (op) {
			case 1:
				System.out.println(RedesController.getIP());
				break;
			case 2:
				RedesController.getPING();
				break;
			case 9:
				System.exit(1);
				break;
			default:
				break;
			}
		}
	}
}

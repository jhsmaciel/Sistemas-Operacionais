package view;

import controller.ProcController;

public class Principal {
	public static void main(String[] args) {
		ProcController proc = new ProcController();
		//String out = "Windows 10";
		//String os1 = proc.os();
		//proc.propriedades();
		// System.out.println(proc.os());
		//if (out.equals(os1)) {
			//System.out.println("vdd");}
		String caminhoProcesso ="C:\\Level Up\\Ragnarok\\Ragexe.exe";
		proc.chamaProcesso(caminhoProcesso);
	}
}

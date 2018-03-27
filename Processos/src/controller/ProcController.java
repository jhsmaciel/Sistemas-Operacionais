package controller;

import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import javax.swing.JOptionPane;

public class ProcController {
	public ProcController() {
		super();
	}

	public String os() {
		String os = System.getProperty("os.name");
		return os;
	}

	public void propriedades() {
		Properties prop = System.getProperties();
		Set<Object> chaves = prop.keySet();
		for (Object key : chaves){
			String chave = key.toString();
			System.out.print(chave);
			System.out.print(" ==> ");
			String propriedade = System.getProperty(chave);
			System.out.println(propriedade);
			
		}
	}
	public void chamaProcesso(String caminhoProcesso){
		try {
			Runtime.getRuntime().exec(caminhoProcesso);
			
		} catch (IOException e) {
			//e.printStackTrace();
			String errMsg = e.getMessage();
			if (errMsg.contains("740")){
				StringBuffer buffer = new StringBuffer();
				buffer.append ("cmd /c");
				buffer.append (" ");
				buffer.append(caminhoProcesso);
				try {
					Runtime.getRuntime().exec(buffer.toString());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(null,e.getMessage(),"ERRO",JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
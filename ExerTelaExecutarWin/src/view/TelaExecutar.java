package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class TelaExecutar extends JFrame {
	private String caminhoArquivo = "";

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfCaminho;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaExecutar frame = new TelaExecutar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaExecutar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 412, 218);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnOk = new JButton("OK");
		btnOk.setBounds(60, 137, 95, 23);
		contentPane.add(btnOk);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCancelar.setBounds(165, 137, 95, 23);
		contentPane.add(btnCancelar);

		JLabel lblAbrir = new JLabel("Abrir :");
		lblAbrir.setBounds(10, 65, 46, 23);
		contentPane.add(lblAbrir);

		tfCaminho = new JTextField();
		tfCaminho.setBounds(60, 65, 300, 23);
		contentPane.add(tfCaminho);
		tfCaminho.setColumns(10);

		JButton btnProcurar = new JButton("Procurar...");
		btnProcurar.setBounds(270, 137, 95, 23);
		contentPane.add(btnProcurar);

		JLabel lblDigiteAlgoAq = new JLabel("Digite o caminho do execut\u00E1vel ou clique em procurar");
		lblDigiteAlgoAq.setBounds(60, 11, 313, 28);
		contentPane.add(lblDigiteAlgoAq);

		ActionListener busca = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				procuraArquivo();
			}
		};
		btnProcurar.addActionListener(busca);

		ActionListener frame = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				procuraCancelar();
			}
		};
		btnCancelar.addActionListener(frame);

		ActionListener ok = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ExecutaTuto();
			}
		};
		btnOk.addActionListener(ok);
	}

	public void procuraCancelar() {
		System.exit(1);
	}

	public void ExecutaTuto() {
		try {
			System.out.println(caminhoArquivo);
			Runtime.getRuntime().exec(caminhoArquivo);
			System.exit(1);
		} catch (IOException e) {
			System.out.println("ERROOOO! Endereço/Executável inválido.");
		}

	}

	public void procuraArquivo() {
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("Arquivos Executáveis (.exe)", "exe");
		String diretorioBase = System.getProperty("user.home") + "/Desktop";
		File dir = new File(diretorioBase);
		JFileChooser choose = new JFileChooser();
		choose.setCurrentDirectory(dir);
		choose.setFileSelectionMode(JFileChooser.FILES_ONLY);
		choose.setAcceptAllFileFilterUsed(false);
		choose.addChoosableFileFilter(filtro);
		int retorno = choose.showOpenDialog(null);
		if (retorno == JFileChooser.APPROVE_OPTION) {
			caminhoArquivo = choose.getSelectedFile().getAbsolutePath();
			tfCaminho.setText(caminhoArquivo);
		}
	}
}

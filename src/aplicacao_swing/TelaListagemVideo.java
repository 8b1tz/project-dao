package aplicacao_swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import fachada.Fachada;
import modelo.Video;
import java.awt.Toolkit;

public class TelaListagemVideo {
	/**
	 * 
	 */
	// private static final long serialVersionUID = 1L;
	private JFrame frmListagemVideo;
	private JTextField textField_1;
	private JTextField textField;

//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    TelaListagemVideo window = new TelaListagemVideo();
//                    window.frmListagemVideo.setVisible(true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//    }

	public TelaListagemVideo() {
		initialize();
	}

	private void initialize() {
		// Fachada.inicializar();
		frmListagemVideo = new JFrame();
		frmListagemVideo.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaListagemVideo.class.getResource("/imagem/icon.png")));
		frmListagemVideo.setTitle("Listagem de videos");
		frmListagemVideo.setResizable(false);
		frmListagemVideo.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmListagemVideo.setBounds(100, 100, 592, 480);
		frmListagemVideo.getContentPane().setLayout(null);

		JTextArea txtrOi = new JTextArea();
		txtrOi.setSelectionColor(Color.BLACK);
		txtrOi.setTabSize(56);
		txtrOi.setEditable(false);
		txtrOi.setLineWrap(true);
		txtrOi.setText("Selecione uma opc�ao");
		txtrOi.setFont(new Font("Candara", Font.PLAIN, 18));
		txtrOi.setBounds(20, 168, 393, 262);
		JScrollPane scroll = new JScrollPane(txtrOi);
		scroll.setBounds(10, 174, 556, 244);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		frmListagemVideo.getContentPane().add(scroll);

		JButton btnNewButton = new JButton("Todos");
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String texto = " ";
				for (Video v : Fachada.listarVideos()) {
					texto = texto + "Nome: " + v.getNome() + "\n" + v.getListaAssuntos() + "\n" + "Link: " + v.getLink()
							+ "\n ----- \n";
				}
				txtrOi.setText(texto);
			}
		});

		btnNewButton.setBounds(20, 26, 101, 34);
		frmListagemVideo.getContentPane().add(btnNewButton);

		JLabel lblNewLabel = new JLabel("Listar Videos por ... ");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 0, 162, 28);
		frmListagemVideo.getContentPane().add(lblNewLabel);

		JButton btnAssunto = new JButton("Assunto");
		btnAssunto.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnAssunto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String texto = "";
				for (Video v : Fachada.consultarVideosPorAssunto(textField.getText())) {
					texto = texto + "Nome: " + v.getNome() + "\n" + v.getListaAssuntos() + "\n" + "Link: " + v.getLink()
							+ "\n ----- \n";
					txtrOi.setText(texto);
				}
			}
		});
		btnAssunto.setBounds(21, 71, 101, 34);
		frmListagemVideo.getContentPane().add(btnAssunto);

		JButton btnUsuario = new JButton("Usuario");
		btnUsuario.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String texto = " ";
				for (Video v : Fachada.consultarVideosPorUsuario(textField_1.getText())) {
					texto = texto + "Nome: " + v.getNome() + "\n" + v.getListaAssuntos() + "\n" + "Link: " + v.getLink()
							+ "\n ----- \n";
				}
				txtrOi.setText(texto);
			}
		});
		btnUsuario.setBounds(21, 116, 101, 34);
		frmListagemVideo.getContentPane().add(btnUsuario);

		textField_1 = new JTextField();
		textField_1.setBounds(149, 116, 264, 34);
		frmListagemVideo.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(149, 73, 264, 34);
		frmListagemVideo.getContentPane().add(textField);

	}

	public JFrame getFrmListagemVideo() {
		return frmListagemVideo;
	}

	public void setFrmListagemVideo(JFrame frmListagemVisu) {
		this.frmListagemVideo = frmListagemVisu;
	}
}
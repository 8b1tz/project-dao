package aplicacao_swing;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TelaRegistroVisualizacao extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frmRegistroVisu;
	private JTextField link;
	private JTextField textField;
	private JTextField textField_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRegistroVisualizacao window = new TelaRegistroVisualizacao();
					window.frmRegistroVisu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public TelaRegistroVisualizacao() {
		initialize();
	}

	private void initialize() {
		setTitle("Registro de Visualizacao");
		frmRegistroVisu = new JFrame();
		frmRegistroVisu.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaRegistroVisualizacao.class.getResource("/imagem/icon.png")));
		frmRegistroVisu.setResizable(false);
		frmRegistroVisu.getContentPane().setLayout(null);
		frmRegistroVisu.setBounds(100, 100, 450, 300);
		link = new JTextField();
		link.setFont(new Font("Tahoma", Font.PLAIN, 16));
		link.setBounds(113, 79, 215, 27);
		link.setColumns(10);
		frmRegistroVisu.getContentPane().add(link);
		
		JLabel lblNewLabel = new JLabel("link");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		lblNewLabel.setBounds(65, 85, 38, 13);
		frmRegistroVisu.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setColumns(10);
		textField.setBounds(113, 127, 215, 27);
		frmRegistroVisu.getContentPane().add(textField);
		
		JLabel lblEmail = new JLabel("email");
		lblEmail.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		lblEmail.setBounds(51, 128, 56, 22);
		frmRegistroVisu.getContentPane().add(lblEmail);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(152, 175, 38, 22);
		frmRegistroVisu.getContentPane().add(textField_1);
		
		JLabel lblNewLabel_1 = new JLabel("nota");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(93, 175, 62, 18);
		frmRegistroVisu.getContentPane().add(lblNewLabel_1);
		
		JButton buttonRegistrar = new JButton("Registrar");
		buttonRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttonRegistrar.setBounds(242, 178, 93, 19);
		frmRegistroVisu.getContentPane().add(buttonRegistrar);
		
		JLabel lblNewLabel_2 = new JLabel("REGISTRO DE VISUALIZA\u00C7\u00C3O");
		lblNewLabel_2.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(93, 10, 224, 29);
		frmRegistroVisu.getContentPane().add(lblNewLabel_2);
	}

	public JFrame getFrmRegistroVisu() {
		return frmRegistroVisu;
	}

	public void setFrmRegistroVisu(JFrame frmListagemVisu) {
		this.frmRegistroVisu = frmListagemVisu;
	}
}

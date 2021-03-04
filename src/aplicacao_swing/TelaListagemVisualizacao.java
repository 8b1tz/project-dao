package aplicacao_swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import fachada.Fachada;
import modelo.Visualizacao;

public class TelaListagemVisualizacao {
	/**
	 * 
	 */
	// private static final long serialVersionUID = 1L;
	private JFrame frmListagemVisu;

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

	public TelaListagemVisualizacao() {
		initialize();
	}

	private void initialize() {
		// Fachada.inicializar();
		frmListagemVisu = new JFrame();
		frmListagemVisu.setResizable(false);
		frmListagemVisu.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaListagemVisualizacao.class.getResource("/imagem/icon.png")));
		frmListagemVisu.setTitle("Listagem de visualiza\u00E7oes");
		frmListagemVisu.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmListagemVisu.setBounds(100, 100, 592, 480);
		frmListagemVisu.getContentPane().setLayout(null);

		JTextArea txtrOi = new JTextArea();
		txtrOi.setSelectionColor(Color.BLACK);
		txtrOi.setTabSize(56);
		txtrOi.setEditable(false);
		txtrOi.setLineWrap(true);
		txtrOi.setText("Selecione uma opcçao");
		txtrOi.setFont(new Font("Candara", Font.PLAIN, 18));
		txtrOi.setBounds(20, 168, 393, 262);
		JScrollPane scroll = new JScrollPane(txtrOi);
		scroll.setBounds(10, 113, 556, 244);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		frmListagemVisu.getContentPane().add(scroll);

		JButton btnNewButton = new JButton("Listar");
		btnNewButton.setBounds(10, 386, 101, 34);
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String texto = " ";
				for (Visualizacao v : Fachada.listarVisualizacoes()) {
					texto = texto + "Id da visualização: " + v.getId() +"\n Nome do vídeo: " + v.getVideo() + "\n Usuario: " + v.getUsuario()
							+ "\n ----- \n";
				}
				txtrOi.setText(texto);
			}
		});
		frmListagemVisu.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("LISTAR VISUALIZA\u00C7\u00C3O");
		lblNewLabel.setFont(new Font("Sitka Small", Font.PLAIN, 26));
		lblNewLabel.setBounds(116, 28, 383, 73);
		frmListagemVisu.getContentPane().add(lblNewLabel);

	}

	public JFrame getFrmListagemVisu() {
		return frmListagemVisu;
	}

	public void setFrmListagemVisu(JFrame frmListagemVisu) {
		this.frmListagemVisu = frmListagemVisu;
	}
}
package aplicacao_swing;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class TelaListagemVisualizacao extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frmListagemVisu;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListagemVisualizacao window = new TelaListagemVisualizacao();
					window.frmListagemVisu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public TelaListagemVisualizacao() {
		initialize();
	}

	private void initialize() {
		frmListagemVisu = new JFrame();
		frmListagemVisu.setBounds(100, 100, 450, 300);
	}

	public JFrame getFrmListagemVisu() {
		return frmListagemVisu;
	}

	public void setFrmListagemVisu(JFrame frmListagemVisu) {
		this.frmListagemVisu = frmListagemVisu;
	}
}

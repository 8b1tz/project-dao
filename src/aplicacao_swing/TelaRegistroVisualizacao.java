package aplicacao_swing;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class TelaRegistroVisualizacao extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frmRegistroVisu;

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
		frmRegistroVisu = new JFrame();
		frmRegistroVisu.setBounds(100, 100, 450, 300);
	}

	public JFrame getFrmRegistroVisu() {
		return frmRegistroVisu;
	}

	public void setFrmRegistroVisu(JFrame frmListagemVisu) {
		this.frmRegistroVisu = frmListagemVisu;
	}
}

package aplicacao_swing;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class TelaListagemVideo extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frmListagem;
	private JTextField textField;
	
	public JFrame getFrame() {
		return frmListagem;
	}

	public void setFrame(JFrame frame) {
		this.frmListagem = frame;
	}
}


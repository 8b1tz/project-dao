package aplicacao_swing;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class TelaCadastroVideo extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frmCadastroVideo;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroVideo window = new TelaCadastroVideo();
					window.frmCadastroVideo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public TelaCadastroVideo() {
		initialize();
	}

	private void initialize() {
		frmCadastroVideo = new JFrame();
		frmCadastroVideo.setBounds(100, 100, 450, 300);
	}

	public JFrame getFrmCadastroVideo() {
		return frmCadastroVideo;
	}

	public void setFrmCadastroVideo(JFrame frmListagemVisu) {
		this.frmCadastroVideo = frmListagemVisu;
	}
}

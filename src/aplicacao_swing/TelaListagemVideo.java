package aplicacao_swing;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class TelaListagemVideo extends JFrame {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private JFrame frmListagemVideo;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TelaListagemVideo window = new TelaListagemVideo();
                    window.frmListagemVideo.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    public TelaListagemVideo() {
        initialize();
    }

    private void initialize() {
        frmListagemVideo = new JFrame();
        frmListagemVideo.setBounds(100, 100, 450, 300);
    }

    public JFrame getFrmListagemVideo() {
        return frmListagemVideo;
    }

    public void setFrmListagemVideo(JFrame frmListagemVisu) {
        this.frmListagemVideo = frmListagemVisu;
    }
}
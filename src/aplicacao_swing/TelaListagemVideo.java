package aplicacao_swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import fachada.Fachada;
import modelo.Video;

public class TelaListagemVideo {
    /**
     * 
     */
    //private static final long serialVersionUID = 1L;
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
    	Fachada.inicializar();
        frmListagemVideo = new JFrame();
        frmListagemVideo.getContentPane().setBackground(Color.LIGHT_GRAY);
        frmListagemVideo.setBounds(100, 100, 450, 480);
        frmListagemVideo.getContentPane().setLayout(null);
        
        
        
        JButton btnNewButton = new JButton("Todos");
        btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 14));
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.out.println("Listagem de videos:");
    			for (Video v : Fachada.listarVideos())
    				System.out.println(v);
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
        btnAssunto.setBounds(21, 71, 101, 34);
        frmListagemVideo.getContentPane().add(btnAssunto);
        
        JButton btnUsuario = new JButton("Usuario");
        btnUsuario.setFont(new Font("Verdana", Font.PLAIN, 14));
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
        
        JTextArea textArea = new JTextArea();
        textArea.setFont(new Font("Cambria Math", Font.PLAIN, 17));
        textArea.setBounds(20, 168, 393, 262);
        frmListagemVideo.getContentPane().add(textArea);
        

        
    }

    public JFrame getFrmListagemVideo() {
        return frmListagemVideo;
    }

    public void setFrmListagemVideo(JFrame frmListagemVisu) {
        this.frmListagemVideo = frmListagemVisu;
    }
}
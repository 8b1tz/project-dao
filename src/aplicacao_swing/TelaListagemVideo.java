package aplicacao_swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import fachada.Fachada;
import modelo.Assunto;
import modelo.Video;
import java.awt.Toolkit;
import javax.swing.JTable;

public class TelaListagemVideo {
	/**
	 * 
	 */
	// private static final long serialVersionUID = 1L;
	private JFrame frmListagemVideo;
	private JTextField textField_1;
	private JTextField textField;
	private JTable table;
	private JScrollPane scrollPane;

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
		/*
		JTextArea txtrOi = new JTextArea();
		txtrOi.setSelectionColor(Color.BLACK);
		txtrOi.setTabSize(56);
		txtrOi.setEditable(false);
		txtrOi.setLineWrap(true);
		txtrOi.setText("Selecione uma opcçao");
		txtrOi.setFont(new Font("Candara", Font.PLAIN, 18));
		txtrOi.setBounds(20, 168, 393, 262);
		JScrollPane scroll = new JScrollPane(txtrOi);
		scroll.setBounds(10, 174, 556, 244);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		 
		frmListagemVideo.getContentPane().add(scroll);
		*/
		

		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 183, 554, 257);
		frmListagemVideo.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setGridColor(Color.BLACK);
		table.setRequestFocusEnabled(false);
		table.setFocusable(false);
		table.setBackground(Color.WHITE);
		table.setFillsViewportHeight(true);
		table.setRowSelectionAllowed(true);
		table.setFont(new Font("Dialog", Font.PLAIN, 15));
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {"", "", ""}
				));
		table.setShowGrid(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		JButton btnNewButton = new JButton("Todos");
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					DefaultTableModel model = new DefaultTableModel();
					model.addColumn("Nome");
					model.addColumn("Assunto");
					model.addColumn("Link");
				
					List<Video> listaVideos = Fachada.listarVideos();
					
					for(Video v : listaVideos)
						for(Assunto a : v.getListaAssuntos())
							model.addRow(new Object[]{ v.getNome(), a.getPalavra(), v.getLink() });

					table.setModel(model);
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(frmListagemVideo,erro.getMessage());
				}
				
				
				
				
				
				
				
				
				
				
				
				/*for (Video v : Fachada.listarVideos()) {
					texto = texto + "Nome: " + v.getNome() + 
							"\n" + v.getListaAssuntos() + 
							"\n" + "Link: " + v.getLink()
							+ "\n ----- \n";
				}
				txtrOi.setText(texto); */
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
        		String assunto = textField.getText();
        		ListaVideosAssunto(assunto);
        	}

			private void ListaVideosAssunto(String assunto) {
				
				try{
					DefaultTableModel model = new DefaultTableModel();
					model.addColumn("Nome");
					model.addColumn("Assunto");
					model.addColumn("Link");
				
					List<Video> listaVideos = Fachada.consultarVideosPorAssunto(assunto);
					
					for(Video v : listaVideos)
						for(Assunto a : v.getListaAssuntos())
							model.addRow(new Object[]{ v.getNome(), a.getPalavra(), v.getLink() });

					table.setModel(model);
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(frmListagemVideo,erro.getMessage());
				}
				
				
				
				
				/*
				try {
					for (Video v : Fachada.consultarVideosPorAssunto(assunto)) {
	    				texto = texto + 
	    						"Nome: " + v.getNome() +	    						
	    						"\n" + v.getListaAssuntos() +
	    						"\n"+ "Link: " +  v.getLink() + "\n ----- \n";
	    			}
	    			
				} catch (Exception e) {
					texto = texto + "Assunto com a palavra {  " +  assunto + "   } não existe !\n\n Tente Novamente !";
					
				}
				txtrOi.setText(texto);
				*/
			}
        });
        btnAssunto.setBounds(21, 71, 101, 34);
        frmListagemVideo.getContentPane().add(btnAssunto);
        
        JButton btnUsuario = new JButton("Usuario");
        btnUsuario.setFont(new Font("Verdana", Font.PLAIN, 14));
        btnUsuario.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String usuario = textField_1.getText();
        		ListaVideosUsuario(usuario);
        	}

			private void ListaVideosUsuario( String usuario) {
				
				try{
					DefaultTableModel model = new DefaultTableModel();
					model.addColumn("Nome");
					model.addColumn("Assunto");
					model.addColumn("Link");
				
					List<Video> listaVideos = Fachada.consultarVideosPorUsuario(usuario);
					
					for(Video v : listaVideos)
						for(Assunto a : v.getListaAssuntos())
							model.addRow(new Object[]{ v.getNome(), a.getPalavra(), v.getLink() });

					table.setModel(model);
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(frmListagemVideo,erro.getMessage());
				}
				/*
				try {
					for (Video v : Fachada.consultarVideosPorUsuario(usuario)) {
	    				texto = texto + 
	    						"Nome: " + v.getNome() +
	    						"\n" + v.getListaAssuntos() +
	    						"\n"+ "Link: " +  v.getLink() + "\n ----- \n";}
	    			
				} catch (Exception e) {
					texto = texto + "O Usuario {  " +  usuario + "   } não existe ! \n\n Tente Novamente !";
					
				}
				txtrOi.setText(texto);
				*/
			}
		});

		btnNewButton.setBounds(20, 26, 101, 34);
		frmListagemVideo.getContentPane().add(btnNewButton);

		btnAssunto.setBounds(21, 71, 101, 34);
		frmListagemVideo.getContentPane().add(btnAssunto);
		
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
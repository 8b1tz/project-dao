package aplicacao_swing;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import fachada.Fachada;
import modelo.Assunto;
import modelo.Video;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class TelaListagemVideo extends JFrame{
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JFrame frame;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListagemVideo window = new TelaListagemVideo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public TelaListagemVideo() {
		
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Listar Videos :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(6, 0, 121, 26);
		getContentPane().add(lblNewLabel);
		
		table = new JTable();
		table.setBounds(16, 63, 397, 187);
		getContentPane().add(table);
		table.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {"", "", ""}
				));
		
		table.setShowGrid(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		
		JButton btnNewButton = new JButton("Todos");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try{
					DefaultTableModel model = new DefaultTableModel();
					model.addColumn("Link");
					model.addColumn("Nome");
					model.addColumn("Assunto");
					//					table.getColumnModel().getColumn(0).setPreferredWidth(10);
					//					table.getColumnModel().getColumn(1).setPreferredWidth(10);

					List<Video> lista = Fachada.listarVideos();
					for(Video v : lista)
						for(Assunto a : v.getListaAssuntos())
							model.addRow(new Object[]{ v.getLink(), v.getNome(), a.getPalavra() });

					table.setModel(model);
				}
				catch(Exception erro){
					System.out.println(erro.getMessage());
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(153, 29, 89, 23);
		getContentPane().add(btnNewButton);
		initialize();
		
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

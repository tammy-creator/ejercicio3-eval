package unidad8.ficheros;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class Ejercicio6 extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JTextArea texto;
	private Charset codificacion = StandardCharsets.UTF_8;
	
	public Ejercicio6() throws FontFormatException, IOException {
		InputStream is= Ejercicio6.class.getResourceAsStream("/Espania Normal.ttf");
		Font font = Font.createFont(Font.PLAIN, is).deriveFont(50f); 
		
		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		
		JMenu menuArchivo = new JMenu("Archivo");
		menuArchivo.setMnemonic(KeyEvent.VK_A);
		menuBar.add(menuArchivo);
		
		JMenuItem menuArchivoAbrir = new JMenuItem("Abrir");
		menuArchivoAbrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
//		menuArchivoAbrir.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//				
//			}rootPaneCheckingEnabled
//			
//		});
//		menuArchivoAbrir.addActionListener((e) -> abrir());		
		menuArchivoAbrir.addActionListener(this::abrir);
		menuArchivo.add(menuArchivoAbrir);
		
		JMenuItem menuArchivoSalir = new JMenuItem("Salir");
		menuArchivoSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));	
		menuArchivoSalir.addActionListener(this::salir);
		menuArchivo.add(menuArchivoSalir);
		
		JMenu menuCodificacion = new JMenu("Codificación");
		menuCodificacion.setMnemonic(KeyEvent.VK_C);
		menuBar.add(menuCodificacion);
		
		JRadioButtonMenuItem menuCodificacionUTF8 = new JRadioButtonMenuItem("UTF-8");
		menuCodificacionUTF8.setActionCommand("utf8");
		menuCodificacionUTF8.setSelected(true);
		menuCodificacionUTF8.addActionListener(this::setCodificacion);
		menuCodificacion.add(menuCodificacionUTF8);
		JRadioButtonMenuItem menuCodificacionISO = new JRadioButtonMenuItem("ISO-8859-1");
		menuCodificacionISO.setActionCommand("iso");
		menuCodificacionISO.addActionListener(this::setCodificacion);
		menuCodificacion.add(menuCodificacionISO);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(menuCodificacionUTF8);
		bg.add(menuCodificacionISO);
		
		texto = new JTextArea();
		texto.setEditable(false);
		texto.setFont(font);
		texto.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30), BorderFactory.createLineBorder(Color.BLUE)), BorderFactory.createEmptyBorder(20, 20, 20, 20)));
		JScrollPane scrollPane = new JScrollPane(texto, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setPreferredSize(new Dimension(900, 700));
		getContentPane().add(scrollPane);
		
		pack();
		setLocationRelativeTo(null);
//		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void abrir(ActionEvent e) {
		JFileChooser fc = new JFileChooser();
		if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), codificacion))) {
				texto.setText("");
				String linea;
				while ((linea = br.readLine()) != null)
					texto.append(linea + "\n");
				texto.setCaretPosition(0);
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(), "Abrir", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	private void salir(ActionEvent e) {
		System.exit(0);
	}
	
	private void setCodificacion(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "utf8":
			codificacion = StandardCharsets.UTF_8;
			break;
		case "iso":
			codificacion = StandardCharsets.ISO_8859_1;
			break;
		}
	}
	
	public static void main(String[] args) throws FontFormatException, IOException {
		Ejercicio6 e = new Ejercicio6();
		SwingUtilities.invokeLater(() -> e.setVisible(true));
	}

}

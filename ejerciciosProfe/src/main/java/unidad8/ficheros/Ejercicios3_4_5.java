package unidad8.ficheros;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class Ejercicios3_4_5 {

	static JFrame appFrame = new JFrame("Ejercicio 3 de ficheros");
	static JTextArea textArea;
	static int contCaracteres;
	static int contPalabras;
	static int contLineas;
	static File ficheroTexto = null;
	static JMenuItem menuArchivoGuardar;

	public static void main(String[] args) {
//		SwingUtilities.invokeLater(new Runnable() {
//			@Override
//			public void run() {
//				crearGUI();
//			}
//		});

//		SwingUtilities.invokeLater(() -> crearGUI());

		SwingUtilities.invokeLater(Ejercicios3_4_5::crearGUI);
	}

	static void crearGUI() {
		JMenuBar menuBar = new JMenuBar();
		appFrame.setJMenuBar(menuBar);

		JMenu menuArchivo = new JMenu("Archivo");
		menuArchivo.setMnemonic(KeyEvent.VK_A);
		menuBar.add(menuArchivo);

		JMenuItem menuArchivoAbrirTexto = new JMenuItem("Abrir fichero de texto");
		menuArchivoAbrirTexto.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));

//		menuArchivoAbrir.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent evt) {
//				abrir();
//			}
//		});

//		menuArchivoAbrir.addActionListener(e -> abrir());

		menuArchivoAbrirTexto.addActionListener(Ejercicios3_4_5::abrir);
		menuArchivo.add(menuArchivoAbrirTexto);

		JMenuItem menuArchivoAbrirBin = new JMenuItem("Abrir fichero binario");
		menuArchivoAbrirBin.addActionListener(Ejercicios3_4_5::abrirBinario);
		menuArchivo.add(menuArchivoAbrirBin);

		menuArchivoGuardar = new JMenuItem("Guardar");
		menuArchivoGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		menuArchivoGuardar.addActionListener(Ejercicios3_4_5::guardar);
		menuArchivoGuardar.setEnabled(false);
		menuArchivo.add(menuArchivoGuardar);

		JMenuItem menuArchivoSalir = new JMenuItem("Salir");
		menuArchivoSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.ALT_MASK));
		menuArchivoSalir.addActionListener(Ejercicios3_4_5::salir);
		menuArchivo.add(menuArchivoSalir);

		JPanel panel = (JPanel) appFrame.getContentPane();
		panel.setLayout(new BorderLayout());

		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setPreferredSize(new Dimension(700, 500));
		panel.add(textArea, BorderLayout.CENTER);

//		textArea.append("Dispose: " + JFrame.DISPOSE_ON_CLOSE + "\n");
//		textArea.append("Exit: " + JFrame.EXIT_ON_CLOSE + "\n");
//		textArea.append("Do nothing: " + JFrame.DO_NOTHING_ON_CLOSE + "\n");
//		textArea.append("Hide: " + JFrame.HIDE_ON_CLOSE + "\n");
//		textArea.append("Valor por defecto: " + appFrame.getDefaultCloseOperation());

		appFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		appFrame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				salir(null);
			}
		});
		appFrame.pack();
		appFrame.setResizable(false);
		appFrame.setLocationRelativeTo(null);
		appFrame.setVisible(true);
	}

	static boolean confirmaGuardarDatos(String mensaje) {
		if (ficheroTexto != null) {
			switch (JOptionPane.showConfirmDialog(appFrame, mensaje)) {
			case JOptionPane.YES_OPTION:
				guardar(null);
				if (ficheroTexto == null)
					return true;
				return false;
			case JOptionPane.NO_OPTION:
				return true;
			default:
				return false;
			}
		}
		return true;
	}

	static void abrir(ActionEvent evt) {
		if (confirmaGuardarDatos("¿Guardar datos actuales antes de abrir el fichero de texto?")) {
			JFileChooser fileChooser = new JFileChooser();
			if (fileChooser.showOpenDialog(appFrame) == JFileChooser.APPROVE_OPTION) {
				ficheroTexto = fileChooser.getSelectedFile();
				try (BufferedReader br = new BufferedReader(new FileReader(ficheroTexto))) {
					contCaracteres = 0;
					contPalabras = 0;
					contLineas = 0;
					String line;
					while ((line = br.readLine()) != null) {
						contLineas++;
						for (String palabra : line.split("\\P{L}+")) {
							contPalabras++;
							contCaracteres += palabra.length();
						}
					}
					textArea.setText("Número de caracteres: " + String.valueOf(contCaracteres) + "\n");
					textArea.append("Número de palabras: " + String.valueOf(contPalabras) + "\n");
					textArea.append("Número de líneas: " + String.valueOf(contLineas) + "\n");
					menuArchivoGuardar.setEnabled(true);
				} catch (IOException e) {
					ficheroTexto = null;
					menuArchivoGuardar.setEnabled(false);
					JOptionPane.showMessageDialog(appFrame, e.getMessage(), "Abrir archivo",
							JOptionPane.ERROR_MESSAGE + JOptionPane.OK_OPTION);
				}
			}
		}
	}

	static void abrirBinario(ActionEvent evt) {
		if (confirmaGuardarDatos("¿Guardar datos actuales antes de abrir el fichero binario?")) {
			JFileChooser fileChooser = new JFileChooser();
			if (fileChooser.showOpenDialog(appFrame) == JFileChooser.APPROVE_OPTION) {
				try (DataInputStream in = new DataInputStream(
						new BufferedInputStream(new FileInputStream(fileChooser.getSelectedFile())))) {
					StringBuilder sb = new StringBuilder();
					try {
						while (true) {
							sb.append(in.readUTF() + "\n");
							sb.append(String.valueOf(in.readInt()) + "\n");
							sb.append(String.valueOf(in.readInt()) + "\n");
							sb.append(String.valueOf(in.readInt()) + "\n");
						}
					} catch (EOFException e) {
						ficheroTexto = null;
						menuArchivoGuardar.setEnabled(false);
						textArea.setText(sb.toString());
					}
				} catch (IOException e) {
					JOptionPane.showMessageDialog(appFrame, e.getMessage(), "Abrir archivo binario",
							JOptionPane.ERROR_MESSAGE + JOptionPane.OK_OPTION);
				}
			}
		}
	}

	static void guardar(ActionEvent evt) {
		JFileChooser fileChooser = new JFileChooser();
		if (fileChooser.showSaveDialog(appFrame) == JFileChooser.APPROVE_OPTION) {
			try (DataOutputStream out = new DataOutputStream(
					new BufferedOutputStream(new FileOutputStream(fileChooser.getSelectedFile(), true)))) {
				out.writeUTF(ficheroTexto.getAbsolutePath());
				out.writeInt(contCaracteres);
				out.writeInt(contPalabras);
				out.writeInt(contLineas);
				ficheroTexto = null;
				menuArchivoGuardar.setEnabled(false);
				textArea.setText("");
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(appFrame, ex.getMessage(), "Guardar archivo",
						JOptionPane.ERROR_MESSAGE + JOptionPane.OK_OPTION);
			}
		}
	}

	static void salir(ActionEvent evt) {
		if (confirmaGuardarDatos("¿Guardar datos actuales antes de salir?")) 
			System.exit(0);
	}

}

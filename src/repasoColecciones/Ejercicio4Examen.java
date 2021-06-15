package repasoColecciones;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Ejercicio4Examen extends JFrame implements ActionListener, MouseListener, WindowListener{

	private static final long serialVersionUID = 1L;
	private JLabel label;
	private int contador = 0;
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new Ejercicio4Examen().setVisible(true));
	}
	
	public Ejercicio4Examen() {
		super("Examen 3ª Evaluación - Ejercicio 4");
		addWindowListener(this);
		JPanel panel = (JPanel) getContentPane();
		panel.setLayout(new GridLayout(0, 1));
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
		JButton button = new JButton("Pulsa aquí");
		button.addActionListener(this);
		button.setMnemonic(KeyEvent.VK_P);
		button.setActionCommand("click");
		panel.add(button);
		label = new JLabel();
		label.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));
		label.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		label.addMouseListener(this);
		actualizarNumeroPulsaciones();
		panel.add(label);
		button = new JButton("Reiniciar");
		button.addActionListener(this);
		button.setMnemonic(KeyEvent.VK_R);
		button.setActionCommand("reset");
		panel.add(button);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
	}
	
	private void actualizarNumeroPulsaciones() {
		label.setText(String.format("Número de pulsaciones: %-20d", contador));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "click":
			contador++;
			actualizarNumeroPulsaciones();
			break;
		case "reset":
			contador = 0;
			actualizarNumeroPulsaciones();
			break;
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		label.setForeground(Color.RED);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		label.setForeground(Color.BLACK);
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		if (JOptionPane.showConfirmDialog(this, "Salir de la aplicación", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)
			System.exit(0);
	}
	
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

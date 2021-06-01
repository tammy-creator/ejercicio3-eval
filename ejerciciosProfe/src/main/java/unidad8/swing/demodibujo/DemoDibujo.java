package unidad8.swing.demodibujo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;

public class DemoDibujo extends JFrame {

	private static final long serialVersionUID = 1L;
	private Lienzo lienzo;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new DemoDibujo().setVisible(true));
	}
	
	public DemoDibujo() {
		super("Demo Dibujo");
		Color color = Color.BLACK;
		
		getContentPane().setLayout(new BorderLayout());
		
		JToolBar toolBar = new JToolBar();
		toolBar.setLayout(new FlowLayout());
		getContentPane().add(toolBar, BorderLayout.NORTH);
		ButtonGroup toolsBG = new ButtonGroup();
		toolBar.add(toggleButton(new ImageIcon(DemoDibujo.class.getResource("/draw.png")), "draw", toolsBG, true));
		toolBar.add(toggleButton(new ImageIcon(DemoDibujo.class.getResource("/rect.png")), "rect", toolsBG, false));
		toolBar.add(toggleButton(new ImageIcon(DemoDibujo.class.getResource("/oval.png")), "oval", toolsBG, false));
		toolBar.addSeparator();
		ButtonGroup drawBG = new ButtonGroup();
		toolBar.add(toggleButton(new ImageIcon(DemoDibujo.class.getResource("/stroke.png")), "draw", drawBG, true));
		toolBar.add(toggleButton(new ImageIcon(DemoDibujo.class.getResource("/fill.png")), "fill", drawBG, false));
		toolBar.addSeparator();
		toolBar.add(button(new ImageIcon(DemoDibujo.class.getResource("/color.png")), this::setColor, color));
		toolBar.addSeparator();
		toolBar.add(new JLabel("Grosor del trazo: "), BorderLayout.WEST);
		JSpinner spinner = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
		spinner.addChangeListener(this::setGrosorTrazo);
		((JSpinner.DefaultEditor) spinner.getEditor()).getTextField().setColumns(2);
		toolBar.add(spinner, BorderLayout.EAST);
		
		lienzo = new Lienzo(900, 700, toolsBG, drawBG, color, (Integer) spinner.getValue());
		getContentPane().add(lienzo, BorderLayout.CENTER);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
	}
	
	private void setColor(ActionEvent e) {
		Color c;
		JButton b = (JButton) e.getSource();
		if ((c = JColorChooser.showDialog(this, "Color de dibujo", b.getBackground(), true)) != null) {
			b.setBackground(c);
			lienzo.setFGColor(c);
		}
	}
	
	private void setGrosorTrazo(ChangeEvent e) {
		lienzo.setGrosorTrazo((Integer) ((JSpinner) e.getSource()).getValue());
	}
	
	public JButton button(ImageIcon icon, ActionListener actionListener, Color bgColor) {
		JButton button = new JButton(icon);
		button.addActionListener(actionListener);
		button.setBorder(BorderFactory.createCompoundBorder(button.getBorder(), BorderFactory.createEmptyBorder(5, 0, 5, 0)));
		if (bgColor != null)
			button.setBackground(bgColor);
		return button;
	}
	
	public JToggleButton toggleButton(ImageIcon icon, String cmd, ButtonGroup buttonGroup, boolean selected) {
		JToggleButton button = new JToggleButton(icon);
		button.setSelected(selected);
		button.setActionCommand(cmd);
		if (buttonGroup != null)
			buttonGroup.add(button);
		button.setBorder(BorderFactory.createCompoundBorder(button.getBorder(), BorderFactory.createEmptyBorder(5, 0, 5, 0)));
		return button;
	}

}

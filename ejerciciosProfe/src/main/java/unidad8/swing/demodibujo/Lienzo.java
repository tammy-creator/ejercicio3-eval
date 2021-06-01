package unidad8.swing.demodibujo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;

public class Lienzo extends JPanel implements MouseListener, MouseMotionListener {

	private static final long serialVersionUID = 1L;
	
	private Stroke stroke;
	
	private BufferedImage imagen;
	private Graphics2D g2d;
	private Shape shape;
	private int x;
	private int y;
	private Color color;
	private ButtonGroup toolsBG;
	private ButtonGroup drawBG;
	
	public Lienzo(int ancho, int alto, ButtonGroup toolsBG, ButtonGroup drawBG, Color color, int grosorTrazo) {
		setPreferredSize(new Dimension(ancho, alto));
		this.toolsBG = toolsBG;
		this.drawBG = drawBG;
		this.color = color;
		setGrosorTrazo(grosorTrazo);
		addMouseListener(this);
		addMouseMotionListener(this);
		imagen = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_ARGB);
		g2d = (Graphics2D) imagen.createGraphics();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setBackground(Color.WHITE);
		g2d.clearRect(0, 0, imagen.getWidth(), imagen.getHeight());
	}
	
	public void setFGColor(Color color) {
		this.color = color;
	}
	
	public void setGrosorTrazo(int grosorTrazo) {
		stroke = new BasicStroke(grosorTrazo);
	}
	
	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.drawImage(imagen, 0, 0, this);
		if (shape != null) 
			drawShape(g2d);
	}
	
	public void drawShape(Graphics2D g) {
		g.setColor(color);
		g.setStroke(stroke);
		if (toolsBG.getSelection().getActionCommand().equals("draw") || drawBG.getSelection().getActionCommand() == "draw")
			g.draw(shape);
		else
			g.fill(shape);
	}
	

	@Override
	public void mouseDragged(MouseEvent e) {
		if ((e.getModifiersEx() & MouseEvent.BUTTON1_DOWN_MASK) != 0) {
			switch (toolsBG.getSelection().getActionCommand()) {
			case "draw":
				((Path2D) shape).lineTo(e.getX(), e.getY());
				break;
			case "rect":
				int x = e.getX() >= this.x ? this.x : e.getX();
				int y = e.getY() >= this.y ? this.y : e.getY();
				int w = Math.abs(this.x - e.getX());
				int h = Math.abs(this.y - e.getY());
				((Rectangle2D.Float) shape).setFrame(x, y, w, h);
				break;
			case "oval":
				x = e.getX() >= this.x ? this.x : e.getX();
				y = e.getY() >= this.y ? this.y : e.getY();
				w = Math.abs(this.x - e.getX());
				h = Math.abs(this.y - e.getY());
				((Ellipse2D.Float) shape).setFrame(x, y, w, h);
				break;
			}
			repaint();
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			switch (toolsBG.getSelection().getActionCommand()) {
			case "draw":
				Path2D path = new Path2D.Float();
				path.moveTo(e.getX(), e.getY());
				path.lineTo(e.getX(), e.getY());
				shape = path;
				break;
			case "rect":
				shape = new Rectangle2D.Float(x = e.getX(), y = e.getY(), 1, 1);
				break;
			case "oval":
				shape = new Ellipse2D.Float(x = e.getX(), y = e.getY(), 1, 1);
				break;
			}
			repaint();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		g2d.setColor(color);
		drawShape(g2d);
		shape = null;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

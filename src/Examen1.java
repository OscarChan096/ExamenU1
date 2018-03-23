import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Examen1 extends JFrame implements ActionListener{
	
	private JPanel  panel, panelInf, panelCen;
	private JButton btnCalcular,btnChange;
	private JLabel labV, labD, labT;
	private JTextField jtfV, jtfD, jtfT;
	
	public Examen1(String titulo) {
		setSize(350,150);
		setLayout(new BorderLayout());
		setTitle(titulo);
		
		Container contentPane = getContentPane();
		
		panel = new JPanel();
		panelInf = new JPanel();
		panelCen = new JPanel();
		panelCen.setLayout(new GridLayout(0,3));
		
		TitledBorder border = BorderFactory.createTitledBorder("Examen");
		border.setTitleColor(Color.BLACK);
		panel.setBorder(border);
		
		contentPane.add(panel, BorderLayout.CENTER);
		panel.add(panelCen, BorderLayout.NORTH);
		panel.add(panelInf, BorderLayout.CENTER);
		
		addComponent();
		
	}
	
	public void addComponent() {
		// etiquetas
		labV = new JLabel("Velocidad(m/s)");
		labD = new JLabel("Distancia(m)");
		labT = new JLabel("Tiempo(seg)");
		// campos de texto
		jtfV = new JTextField();
		jtfD = new JTextField();
		jtfT = new JTextField();
		//boton
		btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(this);
		btnChange = new JButton("Cambiar calculo");
		btnChange.addActionListener(this);
		
		panelCen.add(labV);
		panelCen.add(labD);
		panelCen.add(labT);
		
		panelCen.add(jtfV);
		panelCen.add(jtfD);
		panelCen.add(jtfT);
		
		panelInf.add(btnCalcular);
		panelInf.add(btnChange);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		if(ev.getSource() == btnCalcular) {
			if((jtfV.getText().length() != 0) && (jtfD.getText().length() != 0)) {
				Tiempo();
			}else if((jtfT.getText().length() != 0) && (jtfD.getText().length() != 0)) {
				Velocidad();
			}else if((jtfT.getText().length() != 0) && (jtfV.getText().length() != 0)) {
				Distancia();
			}else{
				JOptionPane.showMessageDialog(null, "Ingrese datos", "", JOptionPane.INFORMATION_MESSAGE);
			}
		}else if(ev.getSource() == btnChange) {
			Opciones();
		}
	}
	
	public void Distancia() {
		int tiempo = Integer.parseInt(jtfT.getText());
		int velocidad = Integer.parseInt(jtfV.getText());
		int distancia = velocidad * tiempo;
		JOptionPane.showMessageDialog(null, "Distancia: "+distancia+" m", "Resultado", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void Tiempo() {
		int velocidad = Integer.parseInt(jtfV.getText());
		int distancia = Integer.parseInt(jtfD.getText());
		int tiempo = distancia / velocidad;
		JOptionPane.showMessageDialog(null, "Tiempo: "+tiempo+" Segundos", "Resultado", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void Velocidad() {
		int tiempo = Integer.parseInt(jtfT.getText());
		int distancia = Integer.parseInt(jtfD.getText());
		int velocidad = distancia / tiempo;
		JOptionPane.showMessageDialog(null, "Velocidad: "+velocidad+" m/s", "Resultado", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void Opciones() {
		String[] opciones = {"Velocidad","Distancia","Tiempo","Salir"};
	    int opcion = JOptionPane.showOptionDialog(
	        null
	       ,"Seleccione una opcion a calcular"
	       ,"Ventana de opciones"
	       ,JOptionPane.DEFAULT_OPTION
	       ,JOptionPane.QUESTION_MESSAGE
	       ,null
	       ,opciones
	       ,null
	    );

	    switch(opciones[opcion]){
	      case "Velocidad":
	    	  jtfV.setEditable(false);
	    	  jtfT.setEditable(true);
	    	  jtfD.setEditable(true);
	        break;
	      case "Distancia":
	    	  jtfD.setEditable(false);
	    	  jtfV.setEditable(true);
	    	  jtfT.setEditable(true);
	        break;
	      case "Tiempo":
	    	  jtfT.setEditable(false);
	    	  jtfD.setEditable(true);
	    	  jtfV.setEditable(true);
	        break;
	      case "Salir":
	    	  System.exit(0);
	        break;
	    }
	}

	public static void main(String[] args) {
		Examen1 frame = new Examen1("Examen");
		frame.Opciones();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

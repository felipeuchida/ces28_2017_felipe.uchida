package clockTImeObs;

import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ClockView implements Observer {

	private Clock clock = new Clock();
	private JLabel label = new JLabel();
	private JButton buttonPause = new JButton("Pausar");
	private JButton buttonPlay = new JButton("Retomar");
	private static JFrame frame = new JFrame("Relogio do Rocha e Uchida");

	public ClockView(){
		clock.startClock();
		this.mountDisplay();
		clock.addObserver(this);
	}

	public static void main(String[] args){
		javax.swing.SwingUtilities.invokeLater(new Runnable() {  
			@Override
			public void run() {  
				ClockView main = new ClockView();
			}
		});   
	}

	public void mountDisplay(){  
		JPanel panel = new JPanel();   

		panel.add(label);
		panel.add(buttonPause);
		panel.add(buttonPlay);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));

		label.setFont(new Font("Times New Roman", Font.BOLD, 30));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   

		frame.getContentPane().add(panel);   

		frame.setResizable(false);   
		frame.setBounds(200, 200, 500, 110);
		frame.setLocationRelativeTo(null);  
		frame.setVisible(true); 
		buttonPause.addActionListener(new ButtonPause());
		buttonPlay.addActionListener(new ButtonPlay());
		label.setText(clock.getTime());

	}   

	@Override
	public void update(Observable arg0, Object arg1) {
		System.out.println("Hora: " + arg1);
		label.setText((String)arg1);
	}
}

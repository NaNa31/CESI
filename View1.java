import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTree;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;

public class View1 extends JFrame {

	public JPanel contentPane;
	public JSlider slide;
    public JFChart chart;
    public JLabel rosee;
    public JSpinner spinner; 
    public JProgressBar progressBar;
    public JLabel humid;
    public JLabel temp;
    public JButton btnGraphComplet;
    public JButton btnGraphTemp;
   // public JFrame frame;
	/**
	 * Create the frame.
	 */
	public View1() {
		
		 setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel lblTemprature = new JLabel("Temp\u00E9rature :");
		lblTemprature.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		temp = new JLabel("\u00B0C");
		temp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblHumidit = new JLabel("Humidit\u00E9 :");
		lblHumidit.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		humid = new JLabel("%");
		humid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		btnGraphTemp = new JButton("Afficher Graphique des Temp\u00E9ratures");
		
		btnGraphComplet = new JButton("Afficher Graphique Complet");
		
		progressBar = new JProgressBar();
		progressBar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		progressBar.setStringPainted(true);
	
		
		spinner = new JSpinner();
		
		slide = new JSlider();
		
		this.setSize(600,600);
		
		JLabel lblTempratureSouhaite = new JLabel("Temp\u00E9rature souhait\u00E9e : ");
		lblTempratureSouhaite.setFont(new Font("Tahoma", Font.BOLD, 14));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(47)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(lblHumidit, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblTempratureSouhaite))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(temp)
										.addComponent(lblTemprature)
										.addComponent(humid, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
									.addGap(30)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(btnGraphComplet, GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
										.addComponent(btnGraphTemp, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(progressBar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGap(36))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(31)
							.addComponent(slide, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(36, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnGraphTemp)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnGraphComplet)
							.addGap(38)
							.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(57)
							.addComponent(lblTemprature)
							.addGap(25)
							.addComponent(temp)
							.addGap(18)
							.addComponent(lblHumidit, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(humid, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)))
					.addGap(42)
					.addComponent(lblTempratureSouhaite, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
					.addGap(44)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(slide, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(206, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	
		
		
	}
}

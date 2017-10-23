import javax.swing.*;
import java.awt.*;



public class View extends JPanel{

    public JFChart chart;
    public JFChart chart2;
    public JSlider slide;
    public JLabel rosee;
    public JFrame frame;

    public View(){

       frame = new JFrame("Pimp My Fridge");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        chart = new JFChart("Temperature (°C)");
        chart2 = new JFChart("Humidite  (%)");
        rosee = new JLabel("", SwingConstants.CENTER);
        slide = new JSlider();


        rosee.setForeground(Color.red);
        rosee.setFont(new java.awt.Font("Century Schoolbook L", 1, 30));


        slide.setMaximum(255);
        slide.setMinimum(0);
        slide.setValue(30);
        slide.setPaintTicks(true);
        slide.setPaintLabels(true);
        slide.setMinorTickSpacing(10);
        slide.setMajorTickSpacing(20);


        frame.getContentPane().add(rosee, BorderLayout.CENTER);
        frame.getContentPane().add(chart, BorderLayout.WEST);
        frame.getContentPane().add(chart2, BorderLayout.EAST);
        frame.getContentPane().add(slide, BorderLayout.SOUTH);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

    }

}


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Controller implements ActionListener, ModelObserver {

	private static int vCons;
	private static View1 view;
	private Model data;

	public Controller(Model data) {

		view = new View1();

		data.addObserver(this);
		
		this.data = data;

		view.setVisible(true);
		view.slide.setVisible(true);
		//gObjects.rosee.setVisible(true);

		view.slide.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent event) {
				vCons = ((JSlider) event.getSource()).getValue();
				data.setSlider(vCons);
			}
		});
		
		
		view.slide.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int consigne = view.slide.getValue();
				view.spinner.setValue(consigne);
				data.setTempCons(consigne);
			}
		});
		
		view.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				data.setStateChange(false);
			}
		});
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTemperatureIntChanged(double value) {
		// TODO
//		gObjects.chart.update(value);
//		gObjects.rosee.setText("Point de ros�e: " + data.getpRosee() + " C°");

	}

	@Override
	public void onHumidityChanged(double value) {
		//gObjects.chart2.update(value);
		view.progressBar.setValue((int) data.getHumid());
	}

	@Override
	public void onTemperatureConsigneChanged(double value) {
		// TODO PWM Arduino

	}

	@Override
	public void onStateChanged(boolean value) { }

}

/*
 * 
 * public static void main(String[] args) throws Exception {
 * 
 * 
 * 
 * 
 * Thread t=new Thread() { public void run() { try {Thread.sleep(1000000);}
 * catch (InterruptedException ie) {} } }; t.start();
 * System.out.println("Started");
 * 
 * EventQueue.invokeLater(new Runnable() {
 * 
 * @Override public void run() { Model data = new Model(); data.initialize();
 * gObjects = new View();
 * 
 * Timer timer = new Timer(1000, new ActionListener() {
 * 
 * @Override public void actionPerformed(ActionEvent e) {
 * 
 * String dataS = Model.getInput();
 * 
 * if (dataS!=null){ String parts[] = dataS.split("_"); String hum = parts[0];
 * String temp = parts[1]; String pRosee = parts[2]; float t =
 * Float.parseFloat(temp); float h = Float.parseFloat(hum);
 * gObjects.chart.update(t); gObjects.chart2.update(h);
 * gObjects.rosee.setText("Point de rosée: " + pRosee + " C°");
 * 
 * gObjects.slide.addChangeListener(new ChangeListener(){ public void
 * stateChanged(ChangeEvent event){ vCons =
 * ((JSlider)event.getSource()).getValue(); data.setSlider(vCons); } }); } } });
 * timer.start(); } }); }
 */

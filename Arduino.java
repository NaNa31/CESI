import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Enumeration;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

public class Arduino implements SerialPortEventListener, ModelObserver {

	private Model data;
	private BufferedReader input;
	private OutputStream output;
	private SerialPort port;

	private static final String PORT_NAMES[] = { "COM3", // Windows
	};

	private static final int TIME_OUT = 2000;
	private static final int DATA_RATE = 9600;

	// static String inputArduino;

	public Arduino() {

		this.data = new Model(this);
		
		data.addObserver(this);

	}

	public void startArduino() {
		
		System.out.println("[Arduino] Start connection to Arduino");

		CommPortIdentifier portId = null;
		Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

		while (portEnum.hasMoreElements()) {
			CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
			for (String portName : PORT_NAMES) {
				if (currPortId.getName().equals(portName)) {
					portId = currPortId;
					break;
				}
			}
		}
		if (portId == null) {
			System.out.println("Could not find COM port.");
			return;
		}
		
		System.out.println("[Arduino] Connected to: " + portId.getName());

		try {
			port = (SerialPort) portId.open(this.getClass().getName(), TIME_OUT);

			port.setSerialPortParams(DATA_RATE, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);

			input = new BufferedReader(new InputStreamReader(port.getInputStream()));
			output = port.getOutputStream();

			port.addEventListener(this);
			port.notifyOnDataAvailable(true);
			
			System.out.println("[Arduino] Connected !");

		}
		catch (Exception e) {
			System.err.println("[Arduino] Error: ");
			System.err.println(e.toString());
		}
	}

	public synchronized void close() {
		if (port != null) {
			System.out.println("[Arduino] Close connection");
			port.removeEventListener();
			try {
				input.close();
				output.close();
			} catch (IOException e) { }
			port.close();
		}
	}

	@Override
	public synchronized void serialEvent(SerialPortEvent oEvent) {
		if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
			try {
				//TODO output.write(String.valueOf(data.getSlider()).getBytes());
				String in = input.readLine();

				// inputArduino = in;
				System.out.println("[Arduino] Received: " + in);

				String parts[] = in.split("_");
				String hum = parts[0];
				String temp = parts[1]; 
				String pRosee = parts[2];

				data.setTempInt(Float.parseFloat(temp));
				data.setHumid((int)Float.parseFloat(hum));
				data.setpRosee(Float.parseFloat(pRosee));


			}
			catch (Exception e) {
				// Ceci n'est pas une erreur
				if (e.getMessage().contains("Underlying input stream returned zero bytes"))
					return;
				System.err.println("[Arduino] Read failure: " + e.toString());
				e.printStackTrace();
			}
		}
	}

	@Override
	public void onTemperatureIntChanged(double value) { }

	@Override
	public void onHumidityChanged(double value) { }

	@Override
	public void onTemperatureConsigneChanged(double value) {
		// TODO Envoyer à l'arduino !!
		System.out.println("[Arduino] Change consigne: " + value);
	}

	@Override
	public void onStateChanged(boolean value) {
		if (!value) close();
	}

}

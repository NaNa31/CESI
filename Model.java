
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class Model {

	private List<ModelObserver> list = new ArrayList<ModelObserver>();
	private float tempInt = 0;
	private int humid = 0;
	private float tempCons = 0;
	private float pRosee = 0;
	private int slider;

	private Arduino arduino;
	private Controller controller;
	private boolean state = true;

	public Model(Arduino arduino) {

		this.arduino = arduino;

		this.controller = new Controller(this);

	}

	public void setSlider(int slider) {
		this.slider = slider;
	}

	public int getSlider() {
		return slider;
	}

	public void setpRosee(float r) {
		this.pRosee = r;
	}

	public float getpRosee() {
		return pRosee;
	}

	public float getTempInt() {
		return tempInt;
	}

	public void setTempInt(float tempInt) {
		this.tempInt = tempInt;
		notifyTemperatureChanged();
	}

	public int getHumid() {
		return humid;
	}

	public void setHumid(int humid) {
		this.humid = humid;
		notifyHumidityChanged();
	}

	public float getTempCons() {
		return tempCons;
	}

	public void setTempCons(float tempCons) {
		if (this.tempCons == tempCons)
			return;
		this.tempCons = tempCons;
		notifyTemperatureConsigneChanged();
	}
	
	public void setStateChange(boolean value) {
		if (this.state == value)
			return;
		this.state = value;
		notifyStateChanged();
	}


	public void addObserver(ModelObserver observer) {
		list.add(observer);
	}

	public void removeObserver(ModelObserver observer) {
		list.remove(observer);
	}
	
	private void notifyStateChanged() {
		for (ModelObserver observer : list) {
			observer.onStateChanged(this.state);
		}
	}

	private void notifyTemperatureChanged() {
		for (ModelObserver observer : list) {
			observer.onTemperatureIntChanged(this.tempInt);
		}
	}

	private void notifyHumidityChanged() {
		for (ModelObserver observer : list) {
			observer.onHumidityChanged(this.humid);
		}

	}

	private void notifyTemperatureConsigneChanged() {
		for (ModelObserver observer : list) {
			observer.onTemperatureConsigneChanged(this.tempCons);
		}
	}

	
}
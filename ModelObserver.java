
public interface ModelObserver {
	
	
	void onTemperatureIntChanged(double value);
	
	void onHumidityChanged(double value);
	
	void onTemperatureConsigneChanged(double value);
	
	void onStateChanged(boolean value);
}

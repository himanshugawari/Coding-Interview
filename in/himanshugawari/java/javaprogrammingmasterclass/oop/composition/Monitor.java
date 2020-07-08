package in.himanshugawari.java.javaprogrammingmasterclass.oop.composition;

/**
 * @author himanshu
 *
 */
public class Monitor {

	private String model;
	private String manufacturer;
	private int size;
	private Resolution nativeResolution;

	public Monitor(String model, String manufacturer, int size, Resolution nativeResolution) {
		super();
		this.model = model;
		this.manufacturer = manufacturer;
		this.size = size;
		this.nativeResolution = nativeResolution;
	}

	public void drawPixelAt(int x, int y, String color) {
		System.out.println("Drawing pixel at " + x + " , " + y + " in color " + color);
	}

	public String getModel() {
		return model;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public int getSize() {
		return size;
	}

	public Resolution getNativeResolution() {
		return nativeResolution;
	}

	@Override
	public String toString() {
		return "Monitor [model=" + model + ", manufacturer=" + manufacturer + ", size=" + size + ", nativeResolution="
				+ nativeResolution.toString() + "]";
	}

}

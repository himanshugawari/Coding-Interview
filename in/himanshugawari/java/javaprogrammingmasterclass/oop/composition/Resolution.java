package in.himanshugawari.java.javaprogrammingmasterclass.oop.composition;

/**
 * @author himanshu
 *
 */
public class Resolution {

	private int width;
	private int height;

	public Resolution(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	@Override
	public String toString() {
		return "Resolution [width=" + width + ", height=" + height + "]";
	}

}

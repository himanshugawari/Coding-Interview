package in.himanshugawari.java.javaprogrammingmasterclass.oop.composition;

/**
 * @author himanshu
 *
 */
public class Dimensions {

	private int width;
	private int height;
	private int depth;

	public Dimensions(int width, int height, int depth) {
		super();
		this.width = width;
		this.height = height;
		this.depth = depth;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getDepth() {
		return depth;
	}

	@Override
	public String toString() {
		return "Dimensions [width=" + width + ", height=" + height + ", depth=" + depth + "]";
	}

}

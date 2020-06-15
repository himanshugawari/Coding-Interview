package in.himanshugawari.java.javaprogrammingmasterclass.innerclass.innerclass3;

public class Button {
	private String title;
	private OnClickListener onClickListener;

	public Button(String title) {
		super();
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setOnClickListener(OnClickListener onClickListener) {
		this.onClickListener = onClickListener;
	}

	public void onClick() {
		this.onClickListener.onClick(this.title);
	}

	public interface OnClickListener {
		void onClick(String title);
	}

}

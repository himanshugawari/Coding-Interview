package in.himanshugawari.java.javaprogrammingmasterclass.abstracts.BinarySearchTreeImplementation;

// Linked Link Implementation insertion in ascending order

public class Main {
	public static void main(String[] args) {

		SearchTree tree = new SearchTree(null);
		tree.traverse(tree.getRoot());

		// String stringData = "Darwin Brisbane Perth Melbourne Canberra Adalaide Sydney
		// Canberra";
		String stringData = "5 7 3 9 8 2 1 0 4 6";

		String[] data = stringData.split(" ");
		for (String s : data) {
			tree.addItem(new Node(s));
		}

		// tree.traverse(tree.getRoot());

		tree.traverse(tree.getRoot());
		System.out.println();

		tree.removeItem(new Node("3"));
		tree.traverse(tree.getRoot());
		System.out.println();


		tree.removeItem(new Node("5"));
		tree.traverse(tree.getRoot());
		System.out.println();


		tree.removeItem(new Node("0"));
		tree.removeItem(new Node("4"));
		tree.removeItem(new Node("2"));
		tree.traverse(tree.getRoot());
		System.out.println();


		tree.removeItem(new Node("9"));
		tree.traverse(tree.getRoot());
		System.out.println();


		tree.removeItem(new Node("8"));
		tree.traverse(tree.getRoot());
		System.out.println();


		tree.removeItem(new Node("6"));
		tree.traverse(tree.getRoot());
		System.out.println();


		tree.removeItem(tree.getRoot());
		tree.traverse(tree.getRoot());
		System.out.println();


		tree.removeItem(tree.getRoot());
		tree.traverse(tree.getRoot());
		System.out.println();


		tree.addItem(new Node("5"));
		tree.traverse(tree.getRoot());
		System.out.println();


		tree.addItem(new Node("5"));
		tree.traverse(tree.getRoot());
		System.out.println();


		tree.addItem(new Node("9"));
		tree.traverse(tree.getRoot());

	}
}

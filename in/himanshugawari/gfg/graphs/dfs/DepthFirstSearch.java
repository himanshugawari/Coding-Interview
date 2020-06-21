package in.himanshugawari.gfg.graphs.dfs;

import java.util.ArrayList;

public class DepthFirstSearch {
	public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
		adj.get(u).add(v);
		adj.get(v).add(u);
	}

	public static void printGraph(ArrayList<ArrayList<Integer>> adj) {
		for (int i = 0; i < adj.size() - 1; i++) {
			System.out.print(i + " -> ");
			for (int j = 0; j < adj.get(i).size(); j++) {
				System.out.print(adj.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}

	public static void dfsRec(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited) {
		visited[s] = true;
		System.out.print(s + " ");
		for (int u : adj.get(s)) {
			if (visited[u] == false) {
				dfsRec(adj, u, visited);
			}
		}
	}

	public static void dfs(ArrayList<ArrayList<Integer>> adj, int v, int s) {
		boolean[] visited = new boolean[v];
		dfsRec(adj, s, visited);
	}

	// for disconnected graph
	public static void dfs1(ArrayList<ArrayList<Integer>> adj, int v) {
		boolean[] visited = new boolean[v];
		for (int i = 0; i < v; i++) {
			if (visited[i] == false) {
				dfsRec(adj, i, visited);
			}
		}
	}

	// count components in graph
	public static int dfsDisconnected(ArrayList<ArrayList<Integer>> adj, int v) {
		int count = 0;
		boolean[] visited = new boolean[v];
		for (int i = 0; i < v; i++) {
			if (visited[i] == false) {
				dfsRec(adj, i, visited);
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int v = 5;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(v);
		for (int i = 0; i < v; i++) {
			adj.add(new ArrayList<Integer>());
		}
		addEdge(adj, 0, 1);
		addEdge(adj, 0, 2);
		addEdge(adj, 1, 3);
		addEdge(adj, 1, 4);
		addEdge(adj, 2, 3);
		addEdge(adj, 3, 4);
		System.out.println();

		printGraph(adj);
		System.out.println();

		dfs(adj, v, 0);
		System.out.println();

		v = 7;
		ArrayList<ArrayList<Integer>> adj1 = new ArrayList<ArrayList<Integer>>(v);
		for (int i = 0; i < v; i++) {
			adj1.add(new ArrayList<Integer>());
		}
		addEdge(adj1, 0, 1);
		addEdge(adj1, 0, 2);
		addEdge(adj1, 1, 3);
		addEdge(adj1, 2, 3);
		addEdge(adj1, 4, 5);
		addEdge(adj1, 4, 6);
		addEdge(adj1, 5, 6);
		System.out.println();

		printGraph(adj1);
		System.out.println();

		dfs1(adj1, v);
		System.out.println("\n");

		System.out.println("\n" + dfsDisconnected(adj1, v));
		System.out.println();

	}

}

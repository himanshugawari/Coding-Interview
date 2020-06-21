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

	}

}

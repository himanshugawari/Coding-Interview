package in.himanshugawari.gfg.graphs.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

	public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
		adj.get(u).add(v);
		adj.get(v).add(u);
	}

	public static void printGraph(ArrayList<ArrayList<Integer>> adj) {
		for (int i = 0; i < adj.size(); i++) {
			System.out.print(i + " -> ");
			for (int j = 0; j < adj.get(i).size(); j++) {
				System.out.print(adj.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}

	// find all reachable vertices of graph
	public static void bfs(ArrayList<ArrayList<Integer>> adj, int v, int s) {
		boolean[] visited = new boolean[v + 1];
		Queue<Integer> q = new LinkedList<Integer>();
		visited[s] = true;
		q.add(s);
		while (q.isEmpty() == false) {
			int u = q.poll();
			System.out.print(u + " ");
			for (Integer i : adj.get(u)) {
				if (visited[i] == false) {
					visited[i] = true;
					q.add(i);
				}
			}
		}
	}

	// bfs when no source given and graph may be disconnected
	public static void bfs1(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited) {
		Queue<Integer> q = new LinkedList<Integer>();
		visited[s] = true;
		q.add(s);
		while (q.isEmpty() == false) {
			int u = q.poll();
			System.out.print(u + " ");
			for (Integer i : adj.get(u)) {
				if (visited[i] == false) {
					visited[i] = true;
					q.add(i);
				}
			}
		}
	}

	// bfs for disconnected graph
	public static void bfsDisconnected(ArrayList<ArrayList<Integer>> adj, int v) {
		boolean[] visited = new boolean[v + 1];
		for (int i = 0; i < v; i++) {
			if (visited[i] == false) {
				bfs1(adj, i, visited);
			}
		}
	}

	public static void main(String[] args) {
		int v = 5;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(v);
		for (int i = 0; i < v; i++) {
			adj.add(new ArrayList<Integer>());
		}
		addEdge(adj, 0, 1);
		addEdge(adj, 0, 2);
		addEdge(adj, 1, 2);
		addEdge(adj, 1, 3);
		addEdge(adj, 2, 3);
		addEdge(adj, 2, 4);
		addEdge(adj, 3, 4);
		System.out.println();

		printGraph(adj);
		System.out.println();

		bfs(adj, v, 0);
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

		bfsDisconnected(adj1, v);
		System.out.println();
	}
}

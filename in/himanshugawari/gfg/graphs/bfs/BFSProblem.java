package in.himanshugawari.gfg.graphs.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//Print number of islands in a graph (or number of connected components in a graph).

public class BFSProblem {
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
	public static int bfsDisconnected(ArrayList<ArrayList<Integer>> adj, int v) {
		int count = 0;
		boolean[] visited = new boolean[v + 1];
		for (int i = 0; i < v; i++) {
			if (visited[i] == false) {
				bfs1(adj, i, visited);
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int v = 9;
		ArrayList<ArrayList<Integer>> adj1 = new ArrayList<ArrayList<Integer>>(v);
		for (int i = 0; i < v; i++) {
			adj1.add(new ArrayList<Integer>());
		}
		addEdge(adj1, 0, 1);
		addEdge(adj1, 0, 2);
		addEdge(adj1, 1, 2);
		addEdge(adj1, 3, 4);
		addEdge(adj1, 5, 6);
		addEdge(adj1, 5, 7);
		addEdge(adj1, 7, 8);
		System.out.println();

		printGraph(adj1);
		System.out.println();

		System.out.println("\n"+bfsDisconnected(adj1, v));
		System.out.println();
	}
}

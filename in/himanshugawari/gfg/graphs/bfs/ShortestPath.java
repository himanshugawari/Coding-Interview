package in.himanshugawari.gfg.graphs.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPath {
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
	public static int[] shortestPathBfs(ArrayList<ArrayList<Integer>> adj, int v, int s) {
		int[] dist = new int[v-1];
		Arrays.fill(dist, -1);
		dist[s] = 0;
		boolean[] visited = new boolean[v + 1];
		Queue<Integer> q = new LinkedList<Integer>();
		visited[s] = true;
		q.add(s);
		while (q.isEmpty() == false) {
			int u = q.poll();
			System.out.print(u + " ");
			for (Integer i : adj.get(u)) {
				if (visited[i] == false) {
					dist[i] = dist[u] + 1;
					visited[i] = true;
					q.add(i);
				}
			}
		}
		return dist;
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
		System.out.println();

		printGraph(adj);
		System.out.println();

		int[] shortestPathBfs = shortestPathBfs(adj, v, 0);
		System.out.println();
		System.out.println(Arrays.toString(shortestPathBfs));

	}
}

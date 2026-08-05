/**
 * Name: Chuma
 * Surname: Nxazonke
 * Student No: 219181187
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PartE_Graphs {

        // Graph representation using adjacency matrix
        static class Graph {
            private int vertices;
            private int[][] adjacencyMatrix;

            public Graph(int vertices) {
                this.vertices = vertices;
                adjacencyMatrix = new int[vertices][vertices];
            }

            public void addEdge(int source, int destination) {
                adjacencyMatrix[source][destination] = 1;
                adjacencyMatrix[destination][source] = 1; // For undirected graph
            }

            // Recursive DFS
            public void dfsRecursive(int startVertex) {
                boolean[] visited = new boolean[vertices];
                dfsRecursive(startVertex, visited);
                System.out.println();
            }

            private void dfsRecursive(int vertex, boolean[] visited) {
                visited[vertex] = true;
                System.out.print(vertex + " ");

                for (int i = 0; i < vertices; i++) {
                    if (adjacencyMatrix[vertex][i] == 1 && !visited[i]) {
                        dfsRecursive(i, visited);
                    }
                }
            }

            // BFS using queue
            public void bfs(int startVertex) {
                boolean[] visited = new boolean[vertices];
                Queue<Integer> queue = new LinkedList<>();

                visited[startVertex] = true;
                queue.add(startVertex);

                while (!queue.isEmpty()) {
                    int vertex = queue.poll();
                    System.out.print(vertex + " ");

                    for (int i = 0; i < vertices; i++) {
                        if (adjacencyMatrix[vertex][i] == 1 && !visited[i]) {
                            visited[i] = true;
                            queue.add(i);
                        }
                    }
                }
                System.out.println();
            }

            // Find shortest path using BFS (unweighted graph)
            public void shortestPath(int source, int destination) {
                boolean[] visited = new boolean[vertices];
                int[] parent = new int[vertices];
                Queue<Integer> queue = new LinkedList<>();

                for (int i = 0; i < vertices; i++) {
                    parent[i] = -1;
                }

                visited[source] = true;
                queue.add(source);

                while (!queue.isEmpty()) {
                    int vertex = queue.poll();

                    if (vertex == destination) {
                        break;
                    }

                    for (int i = 0; i < vertices; i++) {
                        if (adjacencyMatrix[vertex][i] == 1 && !visited[i]) {
                            visited[i] = true;
                            parent[i] = vertex;
                            queue.add(i);
                        }
                    }
                }

                // Reconstruct the path
                Stack<Integer> path = new Stack<>();
                int current = destination;

                while (current != -1) {
                    path.push(current);
                    current = parent[current];
                }

                // Print the path
                System.out.print("Shortest path from " + source + " to " + destination + ": ");
                while (!path.isEmpty()) {
                    System.out.print(path.pop());
                    if (!path.isEmpty()) {
                        System.out.print(" -> ");
                    }
                }
                System.out.println();
            }
        }

        public static void run() {
            System.out.println("=== Part E: Graphs ===");

            // Create a transport network (cities represented by numbers)
            Graph transportNetwork = new Graph(8); // 8 cities

            // Add connections between cities
            transportNetwork.addEdge(0, 1); // City 0 connected to City 1
            transportNetwork.addEdge(0, 2); // City 0 connected to City 2
            transportNetwork.addEdge(1, 3); // City 1 connected to City 3
            transportNetwork.addEdge(2, 4); // City 2 connected to City 4
            transportNetwork.addEdge(3, 5); // City 3 connected to City 5
            transportNetwork.addEdge(4, 5); // City 4 connected to City 5
            transportNetwork.addEdge(5, 6); // City 5 connected to City 6
            transportNetwork.addEdge(6, 7); // City 6 connected to City 7

            // Test DFS
            System.out.print("DFS starting from city 0: ");
            transportNetwork.dfsRecursive(0);

            // Test BFS
            System.out.print("BFS starting from city 0: ");
            transportNetwork.bfs(0);

            // Find shortest path between two cities
            transportNetwork.shortestPath(0, 7);

            System.out.println();
        }
    }


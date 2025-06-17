import GameEngine.Coordinate;

import java.util.HashMap;
import java.util.Map;

public class Grapher {
	char[][] graph;
	HashMap<Integer, Coordinate> points = new HashMap<>();
	int size;

	public Grapher(int size) {
		this.size = size;
		initGraph();
	}

	public void getPointData() {
		for(Map.Entry<Integer, Coordinate> entry: points.entrySet()) {
			Integer id = entry.getKey();
			Coordinate coord = entry.getValue();

			System.out.println("ID: " + id + "\tCoordinates: " + coord);
		}
	}

	public void initGraph() {
		graph = new char[size][size];

		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				graph[i][j] = '*';
			}
		}
	}

	public void addPoint(int xPos, int yPos, char symbol, int id) {
		Coordinate coords = new Coordinate(xPos, yPos);
		graph[size - 1 - coords.getXPos()][coords.getXPos()] = symbol;
		points.put(id, coords);
	}

	public void showGraph() {
		int x = size - 1;

		for(int i = 0; i < size + 1; i++) {
			if(x != -1)
				System.out.print(x-- + "\t");
			else
				System.out.print("\t");

			for(int j = 0; j < size; j++) {
				if(i == size)
					System.out.print(j + " ");
				else
					System.out.print(graph[i][j] + " ");
			}
			if(i != size)
				System.out.println();
		}
	}
}
package informatica;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

// Questions can be found on desktop

public class Informatica_GoodNodes {

	static int goodNodes(int[] points_to) {

		for (int i = 0; i < points_to.length; i++) {
			points_to[i] = points_to[i] - 1;
		}

		int nodeCount = points_to.length;
		int[] parentList = new int[nodeCount];
		
		for (int iterator = 0; iterator < parentList.length; iterator++) {
			parentList [iterator] = -1;
		}
		
		for (int iterator = 0; iterator < nodeCount; iterator++) {
			findSetUnion(parentList, iterator, points_to[iterator]);
		}
		
		int res = 0;
		
		for (int iterator = 1; iterator < nodeCount; iterator++) {
			if (findInSet(parentList, iterator) == iterator)
				res++;
		}
		return res;
	}

	public static void findSetUnion(int[] parentList, int a, int b) {
		int aParent = findInSet(parentList, a);
		int bParent = findInSet(parentList, b);
		parentList[aParent] = bParent;
	}

	public static int findInSet(int[] parent, int node) {
		if (node == 0)
			return 0;
		if (parent[node] == -1 || parent[node] == node) {
			return node;
		}
		return findInSet(parent, parent[node]);
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		// final String fileName = System.getenv("OUTPUT_PATH");
		// BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
		int res;

		int _points_to_size = 0;
		_points_to_size = Integer.parseInt(in.nextLine());
		int[] _points_to = new int[_points_to_size];
		int _points_to_item;
		for (int _points_to_i = 0; _points_to_i < _points_to_size; _points_to_i++) {
			_points_to_item = Integer.parseInt(in.nextLine());
			_points_to[_points_to_i] = _points_to_item;
		}

		res = goodNodes(_points_to);
		System.out.println(res);
		// bw.write(String.valueOf(res));
		// bw.newLine();

		// bw.close();
	}
}

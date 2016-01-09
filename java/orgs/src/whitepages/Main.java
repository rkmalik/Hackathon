package whitepages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	private static void updateJumps(ArrayList<Integer> arr, CanyonPoint[] cur, int curIndx) {
		if (cur[curIndx].minJump == Integer.MAX_VALUE) {
			System.out.println("failure");
			return;
		}

		int range = arr.get(curIndx);
		for (int i = curIndx + 1; i <= (curIndx + range); i++) {
			if (i == arr.size())
				return;
			int curJump = cur[i].minJump;
			int jumpAtPoint = cur[curIndx].minJump + 1;

			if (jumpAtPoint < curJump) {
				cur[i].minJump = jumpAtPoint;
				cur[i].prevList.clear();
				cur[i].prevList.add(cur[curIndx]);
			} else if (jumpAtPoint == curJump) {
				cur[i].prevList.add(cur[curIndx]);
			}
		}
	}

	public static void findMinJumpsToEnd(ArrayList<Integer> input) {

		int inputSize = input.size();

		CanyonPoint[] cur = new CanyonPoint[inputSize];
		cur[0] = new CanyonPoint(0, input.get(0), 0);
		for (int i = 1; i < inputSize; i++) {
			cur[i] = new CanyonPoint(Integer.MAX_VALUE, input.get(i), i);
		}

		for (int index = 0; index < inputSize; index++) {
			try {
				updateJumps(input, cur, index);
			} catch (RuntimeException r) {
				System.out.println("failure");
				return;
			}
		}

		CanyonPoint end = cur[cur.length - 1];

		List<ArrayList<CanyonPoint>> listOfAllPaths = findPath(end);
		String str = ", ";
		StringBuilder sb = new StringBuilder();
		/*
		 * ArrayList<CanyonPoint> path = listOfAllPaths.get(0); for (CanyonPoint
		 * node : path) { sb.append(node.index + str); }
		 */
		ArrayList<CanyonPoint> minPath = listOfAllPaths.get(0);
		for (ArrayList<CanyonPoint> path : listOfAllPaths) {
            
			if (path.size() > 2) {
				CanyonPoint cp = path.get(path.size() - 2);
				if (cp.value + cp.index >= input.size())
					path.remove(path.size() - 1);
			}
			
			if (minPath.size() > path.size()) minPath = path;
		}

			for (CanyonPoint node : minPath) {
				sb.append(node.index + str);
			}
			sb.append("out");
			System.out.println(sb);

		
	}

	private static class CanyonPoint {
		int minJump;
		int value;
		int index;
		List<CanyonPoint> prevList = new ArrayList<>();

		CanyonPoint(int totalDist, int value, int index) {
			this.minJump = totalDist;
			this.value = value;
			this.index = index;
		}
	}

	private static List<ArrayList<CanyonPoint>> findPath(CanyonPoint node) {
		List<ArrayList<CanyonPoint>> paths = new ArrayList<ArrayList<CanyonPoint>>();
		if (node.prevList.size() == 0) {
			paths.add(new ArrayList<>(Arrays.asList(node)));
		}

		for (CanyonPoint prev : node.prevList) {
			List<ArrayList<CanyonPoint>> pathToPrev = findPath(prev);
			for (ArrayList<CanyonPoint> path : pathToPrev) {
				path.add(node);
			}

			paths.addAll(pathToPrev);
		}

		return paths;
	}

	public static void main(String[] args) throws IOException {

		/*
		 * Scanner in = new Scanner(System.in); ArrayList<Integer> input = new
		 * ArrayList<Integer>(); while (in.hasNextInt()) {
		 * input.add(in.nextInt()); } findMinJumpsToEnd(input);
		 */
		/*
		 * ArrayList<Integer> input = new ArrayList<Integer>(); BufferedReader
		 * in = new BufferedReader(new InputStreamReader(System.in)); String s;
		 * while ((s = in.readLine()) != null) { input.add(Integer.parseInt(s));
		 * }
		 */

		ArrayList<Integer> input = new ArrayList<Integer>();
		// 4, 0, 0, 3, 6, 5, 4, 7, 1, 0, 1, 2
		int[] arr = { 4, 0, 0, 3, 6, 5, 4, 7, 1, 0, 1, 2 };
		// int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		for (int i = 0; i < arr.length; i++) {
			input.add(arr[i]);
		}

		findMinJumpsToEnd(input);
	}
}

/*
 * Pmj6kwm-52ezus
 * 
 * 
 * 
 * -------------------------- Single line separated by comma, 2. Multiple
 * solutions Same Number of Flight Choose arbitrarily any solution.
 * 
 * 3. Sequence of array indices 2. Invalid input/ No solution "failure"
 * 
 */
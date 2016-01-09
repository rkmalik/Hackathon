package a_unionfind;

import java.util.Scanner;

public class UFQuickFind {

	int[] ids;
	int count;

	public UFQuickFind(int n) {

		ids = new int[n];
		count = n;

		for (int i : ids) {
			ids[i] = i;
		}
	}

	public int count() {
		return count;
	}

	public int find(int p) {
		validate(p);
		return ids[p];
	}

	public boolean validate(int p) {

		if (p < 0 || p >= count)
			return false;

		return true;
	}

	public void union(int p, int q) {

	}

	public int root(int p) {

		while (ids[p] != p) {
			p = ids[p];
		}
		return p;
	}

	public boolean connected(int p, int q) {

		int rootp = root(p);
		int rootq = root(q);

		if (rootp == rootq)
			return true;
		return false;

	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		UFQuickFind uf = new UFQuickFind(N);
		while (!in.hasNextInt()) {
			int p = in.nextInt();
			int q = in.nextInt();
			if (uf.connected(p, q))
				continue;
			uf.union(p, q);
			System.out.println(p + " " + q);
		}
		
		System.out.println("Nodes connected" + uf.connected(0, 9));
		
		System.out.println();
		System.out.println(uf.count() + " components");
	}
}

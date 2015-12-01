import java.util.LinkedList;
import java.util.Queue;

public class RoundRobin {

	public float waitingTime(int[] a, int[] burst, int ts) {

		boolean done[] = new boolean[a.length];
		int wt[] = new int[a.length];
		int j = 0;
		Queue q = new LinkedList<>();
		int ctime = 0;
		int donecount = 0;
		do {
			if (a[j] <= ts && done[j] == false) {
				for (int k = 0; k < a.length; k++) {
					if (done[k] == false && k != j)
						wt[k] += a[j];
				}
				q.add(a[j]);
				ctime += a[j];
				a[j] = 0;
				done[j] = true;
				donecount++;
			}
			else if (burst[j] > ts && done[j] == false)
			{
				for (int k = 0; k < a.length; k++)
				{
					if (done[k] == false && k != j)
						wt[k] += ts;
				}
				q.add(a[j]);
				ctime += ts;
				burst[j] -= ts;
			}
			if (j == a.length - 1)
				j = 0;
			else
				j++;
			if (donecount == a.length)
				break;

		} while (true);

		float sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += wt[i];
		}
		float avg = sum / a.length;
		return avg;
	}

}

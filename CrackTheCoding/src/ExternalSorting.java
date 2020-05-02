import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ExternalSorting {

	public static void main(String args[]) {

		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		ArrayList<Integer> l = new ArrayList<>();
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(8);
		list.add(l);

		ArrayList<Integer> l2 = new ArrayList<>();
		l2.add(1);
		l2.add(6);
		l2.add(13);
		l2.add(81);
		list.add(l2);

		ArrayList<Integer> l3 = new ArrayList<>();
		l3.add(3);
		l3.add(4);
		l3.add(8);
		l3.add(16);
		list.add(l3);

		ArrayList<Integer> l4 = new ArrayList<>();
		l4.add(4);
		l4.add(5);
		l4.add(9);
		l4.add(12);
		list.add(l4);
		
		ArrayList<Integer> result = mergeSortedArray(list);
		System.out.println(result);

	}

	private static ArrayList<Integer> mergeSortedArray(ArrayList<ArrayList<Integer>> list) {
		ArrayList<Integer> result = new ArrayList<>();
		//SortValue obj = new SortValue();
		// pas this object in pq
		PriorityQueue<IdexObject> pq = new PriorityQueue<>();

		for (int i = 0; i < list.size(); i++) {
			if(list.get(i) != null && list.get(i).size() > 0)
				pq.add(new IdexObject(list.get(i).get(0), i, 0));
		}
		if(pq.isEmpty())
			return null;
		
		IdexObject remove = pq.poll();
		result.add(remove.value);
		int x_c = remove.x;
		int y_c = remove.y;

		while (! pq.isEmpty()) {
			if(x_c < list.size() && y_c < list.get(x_c).size() - 1)
				pq.add(new IdexObject(list.get(x_c).get(y_c + 1), x_c, y_c + 1));
			
			IdexObject removedObject = pq.poll();
			result.add(removedObject.value);
			x_c = removedObject.x;
			y_c = removedObject.y;
			
		}
		return result;
	}
}

//class SortValue implements Comparator<IdexObject> {
//
//	public int compare(IdexObject o1, IdexObject o2) {
//		if (o1.value > o2.value)return 1;
//		else if (o1.value < o2.value) return -1;
//		else return 0;
//	}
//}

class IdexObject implements Comparable{
	int x;
	int y;
	int value;

	public IdexObject(int v, int i, int y) {
		this.x = i;
		this.y = y;
		this.value = v;
	}

	@Override
	public int compareTo(Object obj) {
		IdexObject ob = (IdexObject)obj;
		return this.value - ob.value;
	}
}

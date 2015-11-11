package functionalAPI;

import java.util.*;

public class Demo {
	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(2, -4, -3, 89, 18, -5);

		/*
		 * class MyComparator implements Comparator<Integer> {
		 * 
		 * @Override public int compare(Integer o1, Integer o2) { if(o1 < o2)
		 * return -1; if(o1 > o2) return 1;
		 * 
		 * return 0; } }
		 * 
		 * MyComparator c = new MyComparator();
		 * 
		 * Collections.sort(list, c);
		 */

		/*
		 * Collections.sort(list, new Comparator<Integer>() {
		 * 
		 * @Override public int compare(Integer o1, Integer o2) { if(o1 < o2)
		 * return -1; if(o1 > o2) return 1;
		 * 
		 * return 0; } });
		 */

		/*
		 * Collections.sort(list, (o1, o2) -> { if(o1 < o2) return -1; if(o1 >
		 * o2) return 1;
		 * 
		 * return 0; });
		 */

		/*
		 * Collections.sort(list, (o1, o2) -> { return ( (o1 < o2) ? -1 : ((o1 >
		 * o2) ? 1 : 0) ); });
		 */

		Collections.sort(list, (o1, o2) -> ((o1 < o2) ? -1
				: ((o1 > o2) ? 1 : 0)));

		System.out.println("sorted list: " + list);
	}
}

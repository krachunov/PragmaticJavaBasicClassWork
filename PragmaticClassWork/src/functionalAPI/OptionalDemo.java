package functionalAPI;

import java.util.*;

public class OptionalDemo {

	public static Optional<Integer> f(List<Integer> list) {
		for (Integer i : list) {
			if (i > -3 && i % 2 == 0) {
				return Optional.of(i * 2);
			}
		}

		return Optional.empty();
	}

	public static void main(String[] args) {
		List<Integer> l1 = Arrays.asList(-1, 5, 3, 5);
		System.out.println(f(l1));

		List<Integer> l2 = Arrays.asList(-1, 0, 3, 5);
		System.out.println(f(l2));
	}
}

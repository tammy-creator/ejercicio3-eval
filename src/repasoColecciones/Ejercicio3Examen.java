package repasoColecciones;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Ejercicio3Examen {

	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<Integer>(Arrays.asList(2, 13, -42, 21, 4, 9, 14, -3, 11, 5));
		System.out.println(q);
		invertir(4, q);
		System.out.println(q);

	}
	
	public static void invertir(int n, Queue<Integer> q) {
		if (n <= 0)
			return;
		if (q == null || n > q.size())
			throw new IllegalArgumentException();
		Deque<Integer> p = new ArrayDeque<>();
		int r = q.size() - n;
		while (n-- > 0)
			p.push(q.poll());
		while (!p.isEmpty())
			q.offer(p.pop());
		while (r-- > 0)
			q.offer(q.poll());
	}

}

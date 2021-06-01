package unidad8.colecciones;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class ColeccionesTest {

	@Test
	public void testEliminarLasDeLongitudPar() {
//		Set<String> set = Set.of("uno", "dos", "tres", "cuatro", "cinco", "seis");
		Set<String> set1 = new HashSet<>(Set.of("uno", "dos", "tres", "cuatro", "cinco", "seis"));
		Colecciones.eliminarLasDeLongitudPar(set1);
		assertEquals(set1, Set.of("uno", "dos", "cinco"));
		Set<String> set2 = new HashSet<>();
		Colecciones.eliminarLasDeLongitudPar(set2);
		assertEquals(set2, Set.of());
		Set<String> set3 = new HashSet<>(Set.of("uno", "dos", "cinco"));
		Colecciones.eliminarLasDeLongitudPar(set3);
		assertEquals(set3, Set.of("uno", "dos", "cinco"));
		Set<String> set4 = new HashSet<>(Set.of("tres", "seis"));
		Colecciones.eliminarLasDeLongitudPar(set4);
		assertEquals(set4, Set.of());
	}

	@Test
	public void testContieneImpares() {
		fail("Not yet implemented");
	}

	@Test
	public void testValoresUnicos() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testSeRepiteAlMenos3Veces() {
		assertTrue(Colecciones.seRepiteAlMenos3Veces(List.of("uno", "dos", "dos", "tres", "dos", "tres")));
	}
	
	@Test
	public void testDuplicar() {
		Deque<Integer> pila1 = new LinkedList<>();
		pila1.push(1);
		pila1.push(2);
		pila1.push(3);
		pila1.push(4);
		pila1.push(5);
		Deque<Integer> pila2 = new LinkedList<>();
		pila2.push(1);
		pila2.push(1);
		pila2.push(2);
		pila2.push(2);
		pila2.push(3);
		pila2.push(3);
		pila2.push(4);
		pila2.push(4);
		pila2.push(5);
		pila2.push(5);
		Colecciones.duplicar(pila1);
		assertEquals(pila1, pila2);
	}

}

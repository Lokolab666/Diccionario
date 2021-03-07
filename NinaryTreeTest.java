package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Test;

import Model.BynaryTree;
import Model.Matter;
import Model.Node;

public class BinaryTreeTest {

	private BinaryTree<Matter>bt = new BinaryTree<>(Matter.compId);
	
	private void setUp() {
		
		bt.addNode(new Matter("3232", "Fisica", 3));
		bt.addNode(new Matter("8947", "Programacion", 4));
		bt.addNode(new Matter("7263", "Socio", 2));
		bt.addNode(new Matter("4623", "TGS", 3));
		bt.addNode(new Matter("3221", "Matematicas", 3));

	}
	
private void setUp2() {
		
		bt = new BynaryTree<>(Matter.compId);
		
		bt.addNode(new Matter("50", "Fisica", 3));
		bt.addNode(new Matter("20", "Programacion", 4));
		bt.addNode(new Matter("80", "Socio", 2));
		bt.addNode(new Matter("30", "TGS", 3));
		bt.addNode(new Matter("70", "Matematicas", 3));
		bt.addNode(new Matter("90", "Calculo", 4));
		bt.addNode(new Matter("25", "Lenguajes formales", 3));
		bt.addNode(new Matter("35", "Comunicaciones", 4));
		bt.addNode(new Matter("85", "Ingles", 2));
		bt.addNode(new Matter("10", "Logica", 3));
		bt.addNode(new Matter("23", "Transmision", 4));
}

//
//@Test
//public void testListInorden(){
//	setUp2();
//	ArrayList<Matter> matters=bt.listInorden();
//	for (Matter matter : matters) {
//		System.out.println(matter.toString());
//	}
//	System.out.println("\n ");
//}




@Test
public void testListPresort(){
	setUp2();
	ArrayList<Matter> matters=bt.listPresort();
	for (Matter matter : matters) {
		System.out.println(matter.toString());
	}
	System.out.println("\n ");
}
@Test
public void testFindNode() {
	setUp2();
	assertNull(bt.findNode(new Matter("65", null, 0)));
	assertNotNull(bt.findNode(new Matter("50", null, 0)));
	assertNotNull(bt.findNode(new Matter("80", null, 0)));
	assertNotNull(bt.findNode(new Matter("20", null, 0)));
	assertNotNull(bt.findNode(new Matter("70", null, 0)));
	assertNotNull(bt.findNode(new Matter("90", null, 0)));
	assertNotNull(bt.findNode(new Matter("85", null, 0)));
	assertNotNull(bt.findNode(new Matter("35", null, 0)));
	assertNotNull(bt.findNode(new Matter("25", null, 0)));
	assertNotNull(bt.findNode(new Matter("10", null, 0)));
	assertNotNull(bt.findNode(new Matter("23", null, 0)));
	
}

@Test 
public void testIsLeaf() {
	setUp2();
	assertFalse(bt.isLeaf(bt.findNode(new Matter("80", null, 0))));
	assertTrue(bt.isLeaf(bt.findNode(new Matter("70", null, 0))));
	assertTrue(bt.isLeaf(bt.findNode(new Matter("23", null, 0))));
	assertTrue(bt.isLeaf(bt.findNode(new Matter("35", null, 0))));
	assertTrue(bt.isLeaf(bt.findNode(new Matter("85", null, 0))));

}



@Test
public void testGradeNode(){
	setUp2();
	assertEquals(0, bt.gradeNode(bt.findNode(new Matter("23","",0))));
	assertEquals(1, bt.gradeNode(bt.findNode(new Matter("90","",0))));
	assertEquals(2, bt.gradeNode(bt.findNode(new Matter("30","",0))));
	
}


@Test
public void testFindFather() {
	setUp2();
	assertNull(bt.findFather(bt.findNode(new Matter("50","",0))));
	assertNotNull(bt.findFather(bt.findNode(new Matter("80","",0))));
	assertEquals("50", bt.findFather(bt.findNode(new Matter("80","",0))).getInfo().getId());
	assertEquals("20", bt.findFather(bt.findNode(new Matter("10","",0))).getInfo().getId());


}

@Test
public void testLevelNode() {
	setUp2();
	assertEquals(0, bt.levelNode(bt.findNode(new Matter("50", null, 0))));
	assertEquals(1, bt.levelNode(bt.findNode(new Matter("20", null, 0))));
	assertEquals(1, bt.levelNode(bt.findNode(new Matter("80", null, 0))));
	assertEquals(2, bt.levelNode(bt.findNode(new Matter("10", null, 0))));
	assertEquals(2, bt.levelNode(bt.findNode(new Matter("30", null, 0))));
	assertEquals(2, bt.levelNode(bt.findNode(new Matter("70", null, 0))));
	assertEquals(2, bt.levelNode(bt.findNode(new Matter("90", null, 0))));
	assertEquals(3, bt.levelNode(bt.findNode(new Matter("25", null, 0))));
	assertEquals(3, bt.levelNode(bt.findNode(new Matter("35", null, 0))));
	assertEquals(3, bt.levelNode(bt.findNode(new Matter("85", null, 0))));
	assertEquals(4, bt.levelNode(bt.findNode(new Matter("23", null, 0))));

}

@Test 
public void testHeightNode() {
	setUp2();
	assertEquals(0, bt.heightNode(bt.findNode(new Matter("10", null, 0))));
	assertEquals(0, bt.heightNode(bt.findNode(new Matter("35", null, 0))));
	assertEquals(0, bt.heightNode(bt.findNode(new Matter("23", null, 0))));
	assertEquals(0, bt.heightNode(bt.findNode(new Matter("85", null, 0))));
	assertEquals(0, bt.heightNode(bt.findNode(new Matter("70", null, 0))));
	assertEquals(1, bt.heightNode(bt.findNode(new Matter("25", null, 0))));
	assertEquals(1, bt.heightNode(bt.findNode(new Matter("90", null, 0))));
	assertEquals(2, bt.heightNode(bt.findNode(new Matter("30", null, 0))));
	assertEquals(2, bt.heightNode(bt.findNode(new Matter("80", null, 0))));
	assertEquals(3, bt.heightNode(bt.findNode(new Matter("20", null, 0))));
	assertEquals(4, bt.heightNode(bt.findNode(new Matter("50", null, 0))));

}

@Test 
public void testHeightTree() {
	setUp2();
	assertEquals(4, bt.heightTree());
}


@Test
public void testWeightTree() {
	setUp2();
	assertEquals(11, bt.weightTree());
}

@Test
public void testLisAmplitudDown() {
	setUp2();
	assertEquals(11, bt.listAmplitudDown().size());
	assertEquals("50", bt.listAmplitudDown().getFirst().getId());
	assertEquals("23", bt.listAmplitudDown().getLast().getId());
	
//	Iterator<Matter> it = bt.listAmplitudDown().iterator();
//	
//	while (it.hasNext()) {
//		System.out.println(it.next());		
//	}
}

@Test
 public void testListAmplitudTop() {
	setUp2();
	assertEquals("23", bt.listAmplitudTop().get(0).getId());
	assertEquals("50", bt.listAmplitudTop().get(10).getId());
	assertEquals("70", bt.listAmplitudTop().get(5).getId());

	
//	for (Matter matter: bt.listAmplitudTop()) {
//		System.out.println(matter);
//	}
	
	
}


@Test
public void testDeleteLeaf() {
	setUp2();
		
	assertEquals(2, bt.gradeNode(bt.findNode(new Matter("20", null, 0))));
	assertEquals("10", bt.deleteNode(bt.findNode(new Matter("10", null, 0))).getId());
	assertEquals(1, bt.gradeNode(bt.findNode(new Matter("20", null, 0))));
	assertNull(bt.findNode(new Matter("10", null, 0)));
	assertEquals("23", bt.deleteNode(bt.findNode(new Matter("23", null, 0))).getId());
	assertEquals("35", bt.deleteNode(bt.findNode(new Matter("35", null, 0))).getId());
	assertEquals("70", bt.deleteNode(bt.findNode(new Matter("70", null, 0))).getId());
	assertEquals("85", bt.deleteNode(bt.findNode(new Matter("85", null, 0))).getId());
	assertEquals(6, bt.weightTree());

}

@Test
public void testDeleteSon() {
	setUp2();
	
	assertEquals(11, bt.weightTree());
	assertEquals("30", bt.deleteNode(bt.findNode(new Matter("30", null, 0))).getId());
	assertEquals(10, bt.weightTree());
	assertEquals(1, bt.gradeNode(bt.findNode(new Matter("35", null, 0))));
	assertEquals("90", bt.deleteNode(bt.findNode(new Matter("90", null, 0))).getId());
	assertEquals(0, bt.gradeNode(bt.findNode(new Matter("85", null, 0))));
	assertEquals(9, bt.weightTree());
	assertEquals(2, bt.gradeNode(bt.findNode(new Matter("80", null, 0))));

}

@Test
public void testDeleteSons() {
	setUp2();
//	
//	assertEquals(11, bt.weightTree());
//assertEquals("25", bt.deleteNode(bt.findNode(new Matter("25", null, 0))).getId());
//	assertEquals(10, bt.weightTree());
//	assertEquals(0, bt.gradeNode(bt.findNode(new Matter("10", null, 0))));
	assertEquals("20", bt.deleteNode(bt.findNode(new Matter("20", null, 0))).getId());
//	assertEquals("80", bt.deleteNode(bt.findNode(new Matter("80", null, 0))).getId());
//	assertEquals("50", bt.deleteNode(bt.findNode(new Matter("50", null, 0))).getId());

//	
//	
//	//
////	assertEquals(2, bt.gradeNode(bt.findNode(new Matter("70", null, 0))));
//	assertEquals(7, bt.weightTree());
//	
//	
	//	
//	assertEquals(2, bt.gradeNode(bt.findNode(new Matter("70", null, 0))));
//	assertEquals(0, bt.gradeNode(bt.findNode(new Matter("90", null, 0))));
//	assertEquals(0, bt.gradeNode(bt.findNode(new Matter("35", null, 0))));
//	assertEquals(2, bt.gradeNode(bt.findNode(new Matter("23", null, 0))));
//	assertEquals(1, bt.gradeNode(bt.findNode(new Matter("85", null, 0))));
//	assertEquals(3, bt.heightTree());
	
	assertEquals("23", bt.findFather(bt.findNode(new Matter("30","",0))).getInfo().getId());
	assertEquals("30", bt.findFather(bt.findNode(new Matter("25","",0))).getInfo().getId());


}
//	
//	@Test
//	public void testListPreSort() {
//		setUp();
//		assertEquals(5, bt.listPresort().size());
//		assertEquals("3232", bt.listPresort().get(0).getId());
//	}
//	
//	@Test
//	public void testListPosOrden() {
//		setUp();
//		//assertEquals(5, bt.listPreSort().size());
//		assertEquals("3232", bt.listPosOrden().get(4).getId());
//	}
	
}


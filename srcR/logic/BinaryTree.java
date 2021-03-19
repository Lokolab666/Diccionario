package logic;
/**
 * Clase que obtiene el arbol binario junto con sus metodos.
 *
 * @version 0.1.2.9
 * @Author Cristian Fandiño y Jenifer Gómez
 */


import java.util.ArrayList;
import java.util.Comparator;


/**
 * @param <T> Objeto parametrizado
 */
public class BinaryTree<T> {

	private ArrayList<T> out;
	private Comparator<T> comparator;
	private Node<T> root;
	private int aux;

	/**
	 * Constructor el cual inicializa las variables, crea un ArrayList para denotar la salida de los datos.
	 * @param comparator Función que compara los nodos de acuerdo con su comparador en el objeto establecido.
	 */
	public BinaryTree(Comparator<T> comparator) {
		this.comparator=comparator;
		out=new ArrayList<T>();
	}

	/**
	 * Método para verificar si un árbol está vacio
	 * @return boolean con la raíz nula.
	 */
	public boolean isEmpty() {
		return root==null;
	}

	/**
	 * Método que agrega un nodo. Verifica si esta vacio para ponerlo con el nodo.
	 * Crea dos nodos para que uno tenga una raíz y se pueda anexar al otro nodo. Enlazandolos con el nodo padre o a quien le corresponda.
	 * @param info Contiene la información de un nodo.
	 */
	public void addNode(T info) {
		Node<T> node=new Node<T>(info);
		if(isEmpty()){
			root=node;
		}else{
			Node<T> actually=root;
			Node<T> previous=null;
			while(actually!=null){
				previous=actually;
				actually=comparator.compare(info, actually.getInfo())>0?actually.getRight():actually.getLeft();
			}
			if(comparator.compare(info, previous.getInfo())>0){
				previous.setRight(node);
			}else{
				previous.setLeft(node);
			}
		}
	}

	/**
	 * Método para encontrar el nodo. Recibe la información de este nodo y con un comparador, verifica tanto el nodo izquierdo como el derecho, sino lo encuentra, sigue buscando
	 * @param info Contiene la información de un nodo.
	 * @return Node<T> La palabra o el nodo obtenido.
	 */
	public Node<T> findNode(T info){
		Node<T> node=root;
		while(node!=null){
			if(comparator.compare(info, node.getInfo())==0){
				return node;
			}
			node=comparator.compare(info, node.getInfo())>0?node.getRight():node.getLeft();
		}
		return null;
	}

	/**
	 * Método para organizar las palabras o los nodos.
	 * @return ArrayList<T> con los nodos organizados de acuerdo con los nodos orgenados.
	 */
	public ArrayList<T> listInOrder(){
		out=new ArrayList<>();
		inOrder(root);
		return out;
	}

	/**
	 * Método recursivo para organizar los nodos izquierda o derecha.
	 * @param node Contiene el nodo del arbol.
	 */
	private void inOrder(Node<T> node) {
		if(node!=null){
			inOrder(node.getLeft());
			out.add(node.getInfo());
			inOrder(node.getRight());
		}
	}

	/**
	 * Método que verifica el grado del nodo. El grado del nodo verifica si existen nodos por izquierda o derecha.
	 * @param node Contiene el nodo del arbol.
	 * @return byte con el número del nodo,
	 */
	public byte gradeNode(Node<T> node){
		byte grade = 0; 
		if (node.getLeft()==null && node.getRight()==null) {
			grade=0; 
		}if (node.getLeft()!=null || node.getRight()!=null) {
			grade= 1;
		}if (node.getLeft()!=null && node.getRight()!=null) {
			grade= 2; 
		}
		return grade;
	}

	/**
	 * Método que retorno el padre del nodo. Ingresa dentro del ciclo el cual recorre el arbol verificando que el izuqierdo y derecho sea diferente del nodo a buscar.
	 * @param node Contiene el nodo del arbol.
	 * @return Node<T> Nodo padre.
	 */
	public Node<T> findFather(Node<T> node){
		if(node==root){
			return null;
		}else{
			Node<T> father=root;
			while(father.getLeft()!=node && father.getRight()!=node){
				father=comparator.compare(node.getInfo(), father.getInfo())>0?father.getRight():father.getLeft();
				}
			return father;
		}
	}

	/**
	 * Método que muestra el peso del arbol o el total de los nodos. Ingresa al método weight.
	 * @return int con el peso del arbol
	 */
	public int weightTree() {
		return weight(root);
	}

	/**
	 * Método recursivo para obtener el peso del arbol mientras que la raíz sea diferente de null. Obtiene los nodos y los va sumando uno a uno.
	 * @param root Contiene la raíz del arbol.
	 * @return int con el número obtenido del método recursivo.
	 */
	private int weight(Node<T> root) {
		if (root != null) {
			return (weight(root.getLeft()) + weight(root.getRight())) + 1;	
		}
		return 0;
	}

	/**
	 * Método para verificar si el nodo a eliminar es una hoja, tiene un hijo o tiene dos hijos y que no afecten la estructura.
	 * @param node Contiene el nodo del arbol.
	 * @return T nodo eliminado
	 */
	public T deleteNode(Node<T> node) {
		switch (gradeNode(node)) {
			case 0: return deleteLeaf(node);
			case 1: return deleteSon(node);
			default: return deleteSons(node);
		}
	}

	/**
	 * Método que elimina una hoja, si es el caso. Verifica si el nodo es la raíz, cuandoruccre, lo pone null o elimina.
	 * Cuando no se cumple la condición, encuentra al nodo padre y verifica si esta por izquierda o derecha para proceder a la eliminación
	 * @param node Contiene el nodo del arbol.
	 * @return T información del nodo eliminado
	 */
	private T deleteLeaf(Node<T> node) {
		if(node==root) {
			root=null;
		}else {
			Node<T> father=findFather(node);
			if(father.getLeft()==node) {
				father.setLeft(null);
			}else {
				father.setRight(null);
			}
		}
		return node.getInfo();
	}

	/**
	 * Método que elimina el nodo que contiene un hijo. Recibe el nodo y la información de ese nodo la almacena en la clase T.
	 * Si el nodo es igual a la raíz, la raiz pasa a obtener el nodo izquierdo o derecho segun sea el caso.
	 * Cuando no, busca al padre y dentro del condicional, obtiene el nodo izquierdo o derecho (de acuerdo con el caso) y los agrega con su respectivo nodo
	 * @param node Contiene el nodo del arbol.
	 * @return T con la información del nodo eliminado.
	 */
	private T deleteSon(Node<T> node) {
		T out=node.getInfo();
		if(node==root) {
			root=node.getLeft()!=null?node.getLeft():node.getRight();
		}else {
			Node<T> father=findFather(node);
			if(father.getLeft()==node) {
				father.setLeft(node.getLeft()!=null?node.getLeft():node.getRight());
			}else {
				father.setRight(node.getLeft()!=null?node.getLeft():node.getRight());
			}
		}
		return out;
	}

	/**
	 * Método de eliminar un nodo que contenga dos hijos. En este método, se crea un nodo sustituto que obtenga el nodo derecho, y un nodo padre sustituto.
	 * Con el ciclo while, se recorre el arbol mientras que el sustituto de ese arbol al obtener el izquierdo sea diferente de null, adentro del ciclo, el padre sustituto ahora es el nodo sustitudo y este obtiene el nodo izquierdo.
	 *Si el nodo padre sustituto es diferente de null, se cambia el nodo izquierdo enviandole el sustituto del lado derecho. Luego el sustituto obtiene el nodo derecho cambiandoselo
	 * Luego de salir del condicional, el sustituto obtiene el nodo izquierdo y se crea un nuevo padre, el cual va a tener el cambio de alli.
	 * @param node Contiene el nodo del arbol.
	 * @return T con la información del nodo eliminado
	 */
	public T deleteSons(Node<T> node) {
		Node<T> sustitute=node.getRight();
		Node<T>fatherSustitute=null;
		while (sustitute.getLeft()!=null) {
			fatherSustitute=sustitute;
			sustitute=sustitute.getLeft();
		}
		if (fatherSustitute!=null) {
			fatherSustitute.setLeft(sustitute.getRight());
			sustitute.setRight(node.getRight());
		}
		sustitute.setLeft(node.getLeft());
		Node<T> father=findFather(node);
		if (father==null) {
			root=sustitute;
		}else if(father.getLeft()==node) {
			father.setLeft(sustitute);
		}else {
			father.setRight(sustitute);
		}
		return node.getInfo();
	}
}

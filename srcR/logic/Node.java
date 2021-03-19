package logic;
/**
 * Clase que tiene los atributos del nodo. Esta clase está parametrizada
 * @version 0.1.2.9
 * @Author Cristian Fandiño y Jenifer Gómez
 */
public class Node<T> {

	/**
	 * Atributos de la clase node. El T info contiene la información, y left y right son la parte izquierda y derecha, respectivamente.
	 */
	private T info;
	private Node<T> left;
	private Node<T> right;

	/**
	 * Constructor de la clase Node. Inicializa los atributos y recibe la información del nodo.
	 * @param info Contiene la información del nodo.
	 */
	public Node(T info) {
		this.info = info;
		this.left = left;
		this.right = right;
	}

	/**
	 * Metodo para obtener la información de un nodo
	 * @return T con la información
	 */
	public T getInfo() {
		return info;
	}

	/**
	 * Metodo que cambia la información de un nodo.
	 * @param info Contiene la información del nodo editada.
	 */
	public void setInfo(T info) {
		this.info = info;
	}

	/**
	 * Metodo que obtiene el izquierdo de ese nodo.
	 * @return Node<T> con el izquierdo.
	 */
	public Node<T> getLeft() {
		return left;
	}

	/**
	 * Metodo que cambia el izquierdo de ese nodo
	 * @param left Cambia el izquierdo de ese nodo.
	 */
	public void setLeft(Node<T> left) {
		this.left = left;
	}

	/**
	 * Metodo que obtiene el derecho de ese nodo.
	 * @return Node<T> con el derecho.
	 */
	public Node<T> getRight() {
		return right;
	}

	/**
	 * Metodo que cambia el derecho de ese nodo.
	 * @param right ambia el derecho de ese nodo.
	 */
	public void setRight(Node<T> right) {
		this.right = right;
	}
	
	
}

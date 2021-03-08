package logic;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;


public class BinaryTree<T> {


	private ArrayList<T> out;
	private Comparator<T> comparator;
	private Node<T> root;
	private int aux;

	public BinaryTree(Comparator<T> comparator) {
		this.comparator=comparator;
		out=new ArrayList<T>();
	}

	public boolean isEmpty() {
		return root==null;
	}

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

	public ArrayList<T> listPresort(){

		out=new ArrayList<>();
		presort(root);
		return out;
	}


	private void presort(Node<T> node) {

		if(node!=null){
			out.add(node.getInfo());
			presort(node.getLeft());
			presort(node.getRight());
		}
	}

	public ArrayList<T> listInorden(){

		out=new ArrayList<>();
		inOrden(root);
		return out;
	}


	private void inOrden(Node<T> node) {

		if(node!=null){
			inOrden(node.getLeft());
			out.add(node.getInfo());
			inOrden(node.getRight());
		}
	}


	public ArrayList<T> listPosOrden() {

		out=new ArrayList<>();
		posOrden(root);
		return out;
	}

	private void posOrden(Node<T> node) {
		if(node!=null){
			posOrden(node.getLeft());
			posOrden(node.getRight());
			out.add(node.getInfo());
		}
	}



	public boolean isLeaf(Node<T> node) {
		return gradeNode(node) == 0 ? true : false;
	}



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

	public Node<T> findFather(Node<T> node){

		if(node==root){
			return null;
		}else{
			Node<T> father=root;
			//mientras el new node sea diferente al nodeo que se recibe como arumento y el nodo es diferente al nodo buscando por la derecha
			while(father.getLeft()!=node && father.getRight()!=node){
				//evio los dos objetos, uno es el nodo y el otro el father
				father=comparator.compare(node.getInfo(), father.getInfo())>0?father.getRight():father.getLeft();
				//si se envia mayor a cero seria: avanzar por derecha
			}
			//retotrna el nodo del padre
			return father;
		}
	}

	public int levelNode(Node<T> node){

		Node<T> level=root;
		int cont=0;

		if(node==root){
			return 0;
		}else{

			while(node!=root){
				level=comparator.compare(node.getInfo(), level.getInfo())<0?level.getLeft():level.getRight();
				cont++;

				if(level==node){
					return cont;
				}
			}
		}
		return cont;
	}


	public int heightNode(Node<T> node){
		aux=0;
		height(node, 0);
		return aux;
	}

	public int heightTree() {
		aux=0;
		height(root, 0);
		return aux;
	}

	private void height(Node<T> node, int level){

		if(node!=null){
			height(node.getLeft(), level+1);
			aux = level > aux ? level : aux;
			height(node.getRight(), level+1);

		}
	}

	public int weightTree() {
		return weight(root);
	}

	private int weight(Node<T> root) {
		if (root != null) {
			return (weight(root.getLeft()) + weight(root.getRight())) + 1;	
		}
		return 0;
	}

	public ArrayDeque<T> listAmplitudDown(){

		ArrayDeque<T> tailOut = new ArrayDeque<>();
		ArrayDeque<Node> tailAux = new ArrayDeque<>();
		tailAux.add(root);

		while (!tailAux.isEmpty()) {

			Node aux = tailAux.poll();
			if (aux.getLeft() != null) {
				tailAux.add(aux.getLeft());
			}
			if (aux.getRight()!=null) {
				tailAux.add(aux.getRight());
			}
			tailOut.add((T) aux.getInfo());
		}
		return tailOut;
	}

	public ArrayList<T> listAmplitudTop(){

		ArrayDeque<Node> tailAux = new ArrayDeque<>();
		Stack<T> stack = new Stack<>();
		tailAux.add(root);
		

		while (!tailAux.isEmpty()) {

			Node aux= tailAux.poll();
			if (aux.getLeft()!=null) {
				tailAux.add(aux.getLeft());
			}
			if (aux.getRight()!=null) {
				tailAux.add(aux.getRight());
			}
			stack.push((T) aux.getInfo());	
		}

		ArrayList<T> out = new ArrayList<>();
		while (!stack.empty()) {
			out.add(stack.pop());

		}
		return out;
	}


			public T deleteNode(Node<T> node) {
				switch (gradeNode(node)) {
				case 0: return deleteLeaf(node);
				case 1: return deleteSon(node);
				default: return deleteSons(node);
				}
			}

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



	public ArrayList<T> getArray() {
		return (ArrayList<T>) out.clone();
	}



}

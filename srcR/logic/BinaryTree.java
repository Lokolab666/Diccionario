package logic;

import java.util.ArrayList;
import java.util.Comparator;


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

	public ArrayList<T> listInOrder(){
		out=new ArrayList<>();
		inOrder(root);
		return out;
	}

	private void inOrder(Node<T> node) {
		if(node!=null){
			inOrder(node.getLeft());
			out.add(node.getInfo());
			inOrder(node.getRight());
		}
	}

	private void posOrder(Node<T> node) {
		if(node!=null){
			posOrder(node.getLeft());
			posOrder(node.getRight());
			out.add(node.getInfo());
		}
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
			while(father.getLeft()!=node && father.getRight()!=node){
				father=comparator.compare(node.getInfo(), father.getInfo())>0?father.getRight():father.getLeft();
				}
			return father;
		}
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
}

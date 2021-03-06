package com.example.project;

public class SinglyLinkedList<T extends Comparable> {
    private Node<T> first; // Primero nodo de la lista
    private int size; // Tamano de la lista

    // Constructor (crea lista vacia)
    SinglyLinkedList() {
        first = null;
        size = 0;
    }

    // Retorna el tamano de la lista
    public int size() {
        return size;
    }

    // Devuelve true si la lista esta vazia o false caso contrario
    public boolean isEmpty() {
        return (size == 0);
    }

    // Adiciona v al inicio de la lista
    public void addFirst(T v) {
        Node<T> newNode = new Node<T>(v, first);
        first = newNode;
        size++;
    }

    // Adiciona v al final de la lista
    public void addLast(T v) {
        Node<T> newNode = new Node<T>(v, null);
        if (isEmpty()) {
            first = newNode;
        } else {
            Node<T> cur = first;
            while (cur.getNext() != null)
                cur = cur.getNext();
            cur.setNext(newNode);
        }
        size++;
    }

    // Retorna el primer valor de la lista (o null si la lista esta vacia)
    public T getFirst() {
        if (isEmpty())
            return null;
        return first.getValue();
    }

    // Retorna el ultimo valor de la lista (o null si la lista esta vazia)
    public T getLast() {
        if (isEmpty())
            return null;
        Node<T> cur = first;
        while (cur.getNext() != null)
            cur = cur.getNext();
        return cur.getValue();
    }

    // Elimina el primer elemento de la lista (si esta vacia no hara nada)
    public void removeFirst() {
        if (isEmpty())
            return;
        first = first.getNext();
        size--;
    }

    // Elimina el ultimo elemento de la lista (si esta vacia no hara nada)
    public void removeLast() {
        if (isEmpty())
            return;
        if (size == 1) {
            first = null;
        } else {
            // Ciclo con for y uso de size para mostrar alternativa al while
            Node<T> cur = first;
            for (int i = 0; i < size - 2; i++)
                cur = cur.getNext();
            cur.setNext(cur.getNext().getNext());
        }
        size--;
    }

    // Convierte la lista para um String
    public String toString() {
        String str = "{";
        Node<T> cur = first;
        while (cur != null) {
            str += cur.getValue();
            cur = cur.getNext();
            if (cur != null)
                str += ",";
        }
        str += "}";
        return str;
    }

    // NUEVOS METODOS

    // Elimina aquellos nodos de la lista que esten duplicados
    public void deleteDuplicates() {
        Node<T> auxiliar = first; //este nodo se mantiene mientras se compara con los demas nodos
        Node<T> auxiliar2 = first; //este nodo se compara con el nodo auxiliar
        
        //
        while(auxiliar.getNext() != null){
            
            while(auxiliar2.getNext() != null){
                //comparamos valores, si es 0 entonces son iguales
                if(auxiliar.getValue().compareTo(auxiliar2.getNext().getValue())==0){
                    
                    size--;
                    //verificamos el ultimo nodo y comparamos el primer con el ultimo nodo
                    //luego removemos el primero de ser iguales
                    if(auxiliar2.getNext().getNext() == null && first.getValue().compareTo(auxiliar2.getNext().getValue()) == 0 ){  
                        removeFirst();
                    }
                    //verificamos que es el ultimo nodo repetido y lo removemos
                    else if(auxiliar2.getNext().getNext() == null){
                        removeLast();
                    }
                    else{
                        //enlaza nodo anterior con el posterior del nodo actual
                        auxiliar2.setNext(auxiliar2.getNext().getNext());
                    }
                }
                auxiliar2 = auxiliar2.getNext();//recorre primer while
            }
            auxiliar2 = auxiliar.getNext();//actualizamos el nodo
            auxiliar = auxiliar.getNext(); //recorre segundo while
            
        }
    }

    // Inserta un nuevo nodo en una posicion especifica de la lista
    public void insertNth(T data, int position) {

    }

    // Elimina el nodo de una posicion especifica de la lista
    public void deleteNth(int position) {
        int cont = 0; //controla la cantidad de iteraciones
    	Node<T> auxiliar  = first;
    	
    	//Evaluo si esta fuera de rango
    	if(position > size-1) {
    		
    		System.out.println("Fuera de rango.");
		size--;
    	}
    	//si la posicion es el primer elemento
    	else if(position == 0) {
    		
    		removeFirst();
    		size--;
    	}
    	else {
    		//recorre la lista hasta uno antes de la posicion indicada
    		//para poder eliminar el nodo que sigue
	    	while(cont < position-1) {
	    		
	    		auxiliar = auxiliar.getNext();
	    		
	    		cont++;
	    		
	    	}
	    	//enlaza un nodo anterior a uno posterior con respecto al nodo actual
	    	
	    	auxiliar.setNext(auxiliar.getNext().getNext());
	    	size--;
    	}
    }

    public static void main(final String[] args) {

        testExercicio1();
        // testExercicio2();
        testExercicio3();       

    }

    public static void testExercicio1(){

        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();

        list.addLast(47);
        list.addLast(89);
        list.addLast(56);
        list.addLast(89);
        list.addLast(56);

        System.out.println(list);

        list.deleteDuplicates();

        System.out.println(list);
    }

    public static void testExercicio2(){

        SinglyLinkedList<Character> list = new SinglyLinkedList<Character>();

        list.addLast('a');
        list.addLast('b');
        list.addLast('d');

        System.out.println(list);

        list.insertNth('c', 2);

        System.out.println(list);
    }

    public static void testExercicio3(){

        SinglyLinkedList<Character> list = new SinglyLinkedList<Character>();

        list.addLast('a');
        list.addLast('b');
        list.addLast('d');

        System.out.println(list);

        list.deleteNth(2);

        System.out.println(list);
    }

}

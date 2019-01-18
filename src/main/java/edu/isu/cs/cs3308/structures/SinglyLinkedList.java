package edu.isu.cs.cs3308.structures;

import java.io.PrintStream;

public class SinglyLinkedList<E> implements List<E> {

    protected Node<E> head;
    protected Node<E> tail;
    protected int size = 0;

    @Override
    public E first() {
        if(isEmpty())
            return null;
        return head.getData();
    }

    @Override
    public E last() {
        if(isEmpty())
            return null;
        return tail.getData();
    }

    @Override
    public void addLast(E element) {
        if(element == null)
            return;
        if(size == 0){
            head = new Node<>(element);
            tail = new Node<>(element);
        }
        else if(size == 1){
            Node<E> newNode = new Node<>(element);
            this.head.setNext(newNode);
            this.tail = newNode;
        }
        else {
            Node<E> newNode = new Node<>(element);
            this.tail.setNext(newNode);
            this.tail = newNode;
        }
        size++;
    }

    /**
     *
     * @param element Element to be added to the front of the list.
     */
    @Override
    public void addFirst(E element) {
        if(element == null)
            return;
        if(size == 0){
            head = new Node<>(element);
            tail = new Node<>(element);
        }
        else
            head = new Node<>(element, head);
        size++;
    }

    @Override
    public E removeFirst() {
        if(this.isEmpty())
            return null;
        Node<E> tempNode = new Node<>(head.getData());
        head = head.getNext();
        tempNode.setNext(null);
        size--;
        return tempNode.getData();
    }

    @Override
    public E removeLast() {
        if(this.isEmpty())
            return null;

        Node<E> tempNode = head;
        for(int i = 1;i<size-1;i++)
            tempNode = tempNode.getNext();

        Node<E> toRemove = tempNode.getNext();
        tempNode.setNext(null);
        tail = tempNode;
        size--;
        return toRemove.getData();
    }

    @Override
    public void insert(E element, int index) {
        if(index < 0 || element == null)
            return;
        Node<E> toInsert = new Node<>(element);
        if(index > size) {
            tail.setNext(toInsert);
            tail = toInsert;
        }
        else {
            Node<E> tempNode = head;
            for (int i = 0; i < index - 1; i++) {
                tempNode = tempNode.getNext();
            }
            toInsert.setNext(tempNode.getNext());
            tempNode.setNext(toInsert);
        }
        size++;
    }

    @Override
    public E remove(int index) {
        if(index < 0 || index >= size)
            return null;

        Node<E> tempNode = head;
        for(int i = 0;i<index-1;i++)
            tempNode = tempNode.getNext();

        Node<E> toRemove = tempNode.getNext();
        tempNode.setNext(toRemove.getNext());
        size--;
        return toRemove.getData();
    }

    @Override
    public E get(int index) {
        if(index < 0 || index >= size)
            return null;

        Node<E> tempNode = head;
        for(int i = 0;i<index;i++)
            tempNode = tempNode.getNext();
        return tempNode.getData();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void printList() {
        if(isEmpty())
            return;
        Node<E> tempNode = head;

        for(int i=0;i<size;i++){

            System.out.println(tempNode.getData());
            tempNode = tempNode.getNext();
        }
    }
}

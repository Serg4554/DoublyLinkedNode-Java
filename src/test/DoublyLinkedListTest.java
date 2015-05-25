package org.iis.doublylinkednode;

import static org.junit.Assert.*;
import java.util.NoSuchElementException;

import org.iis.doublylinkednode.DoublyLinkedList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DoublyLinkedListTest<T> {

  DoublyLinkedList<T> lista = null;
  DoublyLinkedList<T> listaVacia = null;
  DoublyLinkedList<Integer> listaNumeros = null;

  @Before
  public void inicializa() {
    lista = new DoublyLinkedList<T>(3);
    listaVacia = new DoublyLinkedList<T>(0);
    listaNumeros =  new DoublyLinkedList<Integer>(3);
  }

  @After
  public void finaliza() {
    lista = null;
    listaVacia = null;
    listaNumeros = null;
  }

  @Test
  public void testListaVacia() {
    int esperado = 0;
    int real = listaVacia.getNodeList().size();

    assertEquals(esperado, real);
  }

  @Test
  public void testListaConUnNodo() {
    DoublyLinkedList<T> listaUnNodo = new DoublyLinkedList<T>(1);
    int esperado = 1;
    int real = listaUnNodo.getNodeList().size();

    assertNotNull(listaUnNodo);
    assertEquals(esperado, real);
  }

  @Test
  public void testAnteriorDelPrimerNodoEsNull() {
    assertEquals(lista.getNodeList().get(0).getPrevNode(), null);
  }

  @Test
  public void testPosteriorDelUltimoNodoEsNull() {
    int tamano = lista.getNodeList().size();
    Node<T> esperado = null;
    Node<T> real = lista.getNodeList().get(tamano - 1).getNextNode();

    assertEquals(esperado, real);
  }
  
  @Test
  public void testInsertarNodoAlPrincipioListaVacia() {
    Node<T> nodoNuevo = new Node<T>();
    int esperado = 1;
    
    listaVacia.insertBeginning(listaVacia.getNodeList(), nodoNuevo);
    int real = listaVacia.getNodeList().size();
    
    assertEquals(esperado, real);
  }
  
  @Test
  public void testInsertarNodoAlFinalListaVacia() {
    Node<T> nodoNuevo = new Node<T>();
    int esperado = 1;
    
    listaVacia.insertEnd(listaVacia.getNodeList(), nodoNuevo);
    int real = listaVacia.getNodeList().size();
    
    assertEquals(esperado, real);
  }
  
  @Test
  public void testInsertarNodoAlPrincipioLista() {
    Node<Integer> nodoNuevo = new Node<Integer>();
    int esperado = listaNumeros.getNodeList().size() + 1;
    int datoEsperado = 3;
    
    nodoNuevo.setNodeData(datoEsperado);
    listaNumeros.insertBeginning(listaNumeros.getNodeList(), nodoNuevo);
    int real = listaNumeros.getNodeList().size();
    int datoReal = listaNumeros.getNodeList().get(0).getNodeData();
    
    assertEquals(datoEsperado, datoReal);
    assertEquals(esperado, real);
  }
  
  @Test
  public void testInsertarNodoAlFinalLista() {
    Node<Integer> nodoNuevo = new Node<Integer>();
    int esperado = listaNumeros.getNodeList().size() + 1;
    int datoEsperado = 3;
    
    nodoNuevo.setNodeData(datoEsperado);
    listaNumeros.insertEnd(listaNumeros.getNodeList(), nodoNuevo);
    int real = listaNumeros.getNodeList().size();
    int datoReal = listaNumeros.getNodeList().get(real-1).getNodeData();
    
    assertEquals(datoEsperado, datoReal);
    assertEquals(esperado, real);
  }
  
  @Test
  public void testInsertarNodoAlPrincipioDeOtroDado() {
    Node<Integer> nodoNuevo = new Node<Integer>();
    int esperado = listaNumeros.getNodeList().size() + 1;
    int datoEsperado = 3;
    
    nodoNuevo.setNodeData(datoEsperado);
    listaNumeros.insertBefore(listaNumeros.getNodeList(), listaNumeros.getNodeList().get(2), nodoNuevo);
    int real = listaNumeros.getNodeList().size();
    int datoReal = listaNumeros.getNodeList().get(2).getNodeData();
    
    assertEquals(datoEsperado, datoReal);
    assertEquals(esperado, real);
  }
  
  @Test
  public void testInsertarNodoAlFinalDeOtroDado() {
    Node<Integer> nodoNuevo = new Node<Integer>();
    int esperado = listaNumeros.getNodeList().size() + 1;
    int datoEsperado = 3;
    
    nodoNuevo.setNodeData(datoEsperado);
    listaNumeros.insertAfter(listaNumeros.getNodeList(), listaNumeros.getNodeList().get(1), nodoNuevo);
    int real = listaNumeros.getNodeList().size();
    int datoReal = listaNumeros.getNodeList().get(2).getNodeData();
    
    assertEquals(datoEsperado, datoReal);
    assertEquals(esperado, real);
  }
  
  @Test (expected = IndexOutOfBoundsException.class)
  public void testInsertarNodoAlPrincipioFueraDeRango() {
    Node<Integer> nodoNuevo = new Node<Integer>();
    
    listaNumeros.insertBefore(listaNumeros.getNodeList(), listaNumeros.getNodeList().get(0), nodoNuevo);
  }
  
  @Test (expected = IndexOutOfBoundsException.class)
  public void testInsertarNodoAlFinalFueraDeRango() {
    Node<Integer> nodoNuevo = new Node<Integer>();
    int tam = listaNumeros.getNodeList().size();
    
    listaNumeros.insertAfter(listaNumeros.getNodeList(), listaNumeros.getNodeList().get(tam-1), nodoNuevo);
  }
  
  @Test (expected = NoSuchElementException.class)
  public void testBorrarNodoListaVacia() {
    Node<T> nodoABorrar = new Node<T>();
    listaVacia.removeNode(listaVacia.getNodeList(), nodoABorrar);
  }
  
  @Test
  public void testStringListaVacia() {
    String esperado = "";
    String real = listaVacia.toString();
    
    assertEquals(esperado, real);
  }
  
  @Test
  public void testStringListaUnElemento() {
    DoublyLinkedList<T> listaUnNodo = new DoublyLinkedList<T>(1);
    String esperado = listaUnNodo.getNodeList().get(0).toString();
    String real = listaUnNodo.toString();
    
    assertEquals(esperado, real);
  }

}

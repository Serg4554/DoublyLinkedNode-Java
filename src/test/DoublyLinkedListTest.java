package org.iis.doublylinkednode;

import static org.junit.Assert.*;

import org.iis.doublylinkednode.DoublyLinkedList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DoublyLinkedListTest<T> {

  DoublyLinkedList<T> lista = null;

  @Before
  public void inicializa() {
    lista = new DoublyLinkedList<T>(3);
  }

  @After
  public void finaliza() {
    lista = null;
  }

  @Test
  public void testListaVacia() {
    DoublyLinkedList<T> listaVacia = new DoublyLinkedList<T>(0);

    assertEquals(listaVacia.getNodeList().size(), 0);
  }

  @Test
  public void testListaConUnNodo() {
    DoublyLinkedList<T> listaUnNodo = new DoublyLinkedList<T>(1);

    assertNotNull(listaUnNodo);
    assertEquals(listaUnNodo.getNodeList().size(), 1);
  }

  @Test
  public void testAnteriorDelPrimerNodoEsNull() {
    assertEquals(lista.getNodeList().get(0).getPrevNode(), null);
  }

  @Test
  public void testPosteriorDelUltimoNodoEsNull() {
    int tamano = lista.getNodeList().size();

    assertEquals(lista.getNodeList().get(tamano - 1).getNextNode(), null);
  }

}

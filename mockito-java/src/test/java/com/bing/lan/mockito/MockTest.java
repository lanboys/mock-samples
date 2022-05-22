package com.bing.lan.mockito;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.LinkedList;
import java.util.UUID;

import static org.mockito.Mockito.*;

/**
 * Created by oopcoder.
 */

public class MockTest {


  @Test
  public void test1() {
    // 使用mock模拟Statement接口行为，这里假设执行查询，返回的结果为test
    Statement imock = mock(Statement.class);
    when(imock.query()).thenReturn("test");

    System.out.println("test1(): " + imock.query());

    // 使用spy创建一个真实对象
    ResultSetHandler useMock = Mockito.spy(ResultSetHandler.class);
    useMock.handlerResultSets(imock);
  }

  @Test
  public void test2() {
    LinkedList<UUID> mockedList = mock(LinkedList.class);
    //Stubbing 模拟mockList行为
    when(mockedList.get(0)).thenReturn(UUID.randomUUID());

    RuntimeException exception = new RuntimeException("ddd");
    when(mockedList.get(1)).thenThrow(exception);

    System.out.println(mockedList.get(0));
    try {
      System.out.println(mockedList.get(1));
    } catch (Exception e) {
      System.out.println("main(): ");
    }
  }

  @Test
  public void test3() {
    //你可以mock一个具体的类型，而不仅是接口
    LinkedList mockedList = mock(LinkedList.class);

    mockedList.add("one");
    mockedList.getFirst();

    //验证
    verify(mockedList).add("one");
    verify(mockedList).getFirst();
  }
}

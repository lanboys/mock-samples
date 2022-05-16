package com.bing.lan.mockito;

import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;

import java.util.LinkedList;
import java.util.UUID;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockTest {

  public static void main(String[] args) {

    // 使用mock模拟Statement接口行为，这里假设执行查询，返回的结果为test
    Statement imock = mock(Statement.class);
    when(imock.query()).thenReturn("test");

    // 使用spy创建一个真实对象
    ResultSetHandler useMock = Mockito.spy(ResultSetHandler.class);
    useMock.handlerResultSets(imock);

    LinkedList<UUID> mockedList = mock(LinkedList.class);
    //Stubbing 模拟mockList行为
    OngoingStubbing<UUID> when = when(mockedList.get(0)).thenReturn(UUID.randomUUID());
    RuntimeException exception = new RuntimeException("ddd");
    when(mockedList.get(1)).thenThrow(exception);
    System.out.println(mockedList.get(0));
    try {
      System.out.println(mockedList.get(1));
    } catch (Exception e) {
      System.out.println("main(): ");
    }
  }
}
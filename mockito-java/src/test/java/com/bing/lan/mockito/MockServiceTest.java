package com.bing.lan.mockito;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by lanbing on 2022/5/20.
 */

public class MockServiceTest {

  @Test
  public void test() {
    MyHelloService myHelloService = mock(MyHelloService.class);
    when(myHelloService.sayHello("coder")).thenReturn("hello coder");

    System.out.println("test(): " + myHelloService.sayHello("coder"));
  }

  @Test
  public void test1() {
    RemoteHelloService.HelloServiceClient client = mock(RemoteHelloService.HelloServiceClient.class);
    when(client.sayHello("coder")).thenReturn("hello coder");

    MyHelloService myHelloService = new MyHelloService();
    System.out.println("test(): " + myHelloService.sayHelloByClient(client, "coder"));
  }
}

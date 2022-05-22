package com.bing.lan.mockito;

/**
 * Created by lanbing on 2022/5/20.
 */

interface RemoteHelloService {


  public String sayHello(String str);

  public class HelloServiceClient implements RemoteHelloService {
    @Override
    public String sayHello(String str) {
      System.out.println("模拟Rpc远程调用....");
      return "hello " + str;
    }
  }
}

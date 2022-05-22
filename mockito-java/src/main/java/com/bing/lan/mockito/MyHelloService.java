package com.bing.lan.mockito;


/**
 * Created by lanbing on 2022/5/20.
 */

public class MyHelloService implements LocalHelloService {

  public String sayHello(String s) {
    return new RemoteHelloService.HelloServiceClient().sayHello(s);
  }

  public String sayHelloByClient(RemoteHelloService.HelloServiceClient client, String s) {
    return client.sayHello(s);
  }
}

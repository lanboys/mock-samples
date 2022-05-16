package com.bing.lan.mockito;

public class ResultSetHandler {

  public void handlerResultSets(Statement statement) {
    String queryStr = statement.query();
    System.out.println(queryStr);
  }
}
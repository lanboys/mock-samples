package com.bing.lan.power;

import java.io.File;

/**
 * Created by oopcoder at 2022/5/22 22:13 .
 * <p>
 * 测试目标代码
 */

public class ClassUnderTest {

  public boolean createDirectoryStructure(String directoryPath) {
    File directory = new File(directoryPath);
    if (directory.exists()) {
      String msg = "\"" + directoryPath + "\" 已经存在.";
      throw new IllegalArgumentException(msg);
    }
    return directory.mkdirs();
  }
}
package com.bing.lan.power;

import static org.junit.Assert.*;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.verifyNew;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.mockito.PowerMockito.whenNew;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Created by oopcoder at 2022/5/22 22:14 .
 * <p> 详解看 readme.md
 * 测试用例代码
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest(ClassUnderTest.class)
public class TestConstruction {

  //模拟构造函数
  @Test
  public void createDirectoryStructureWhenPathDoesntExist() throws Exception {
    final String directoryPath = "seemygod";
    //创建File的模拟对象
    File directoryMock = PowerMockito.mock(File.class);
    //在当前测试用例下,当出现new File("seemygod")时,就返回模拟对象
    whenNew(File.class).withArguments(directoryPath).thenReturn(directoryMock);
    //当调用模拟对象的exists时,返回false
    when(directoryMock.exists()).thenReturn(false);
    //当调用模拟对象的mkdirs时,返回true
    when(directoryMock.mkdirs()).thenReturn(true);
    assertTrue(new ClassUnderTest().createDirectoryStructure(directoryPath));
    //验证new File(directoryPath);  是否被调用过
    verifyNew(File.class).withArguments(directoryPath);
  }
}
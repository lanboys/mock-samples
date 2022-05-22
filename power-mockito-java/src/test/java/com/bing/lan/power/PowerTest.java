package com.bing.lan.power;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.File;


/**
 * Created by lanbing on 2022/5/20.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(PowerTest.class)
public class PowerTest {

  //测试目标代码：
  public boolean callArgumentInstance(File file) {
    return file.exists();
  }

  // 测试用例代码：
  @Test
  public void testCallArgumentInstance() {
    File file = PowerMockito.mock(File.class, Mockito
        .withSettings()
        .name("file")
        .verboseLogging());
    PowerMockito.when(file.exists()).thenReturn(true);

    PowerTest underTest = new PowerTest();
    Assert.assertTrue(underTest.callArgumentInstance(file));
  }

  //测试目标代码：
  public boolean callInternalInstance(String path) {
    File file = new File(path);
    return file.exists();
  }

  //测试用例代码：
  @Test
  public void testCallInternalInstance() throws Exception {
    String firstArgument = "bbb";
    File file = PowerMockito.mock(File.class);
    PowerMockito.whenNew(File.class).withArguments(firstArgument).thenReturn(file);
    PowerMockito.when(file.exists()).thenReturn(true);

    PowerTest underTest = new PowerTest();
    Assert.assertTrue(underTest.callInternalInstance(firstArgument));

    PowerMockito.verifyNew(File.class).withArguments(firstArgument);
  }
}

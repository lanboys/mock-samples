package com.bing.lan.power;

import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

import java.io.File;

/**
 * Created by lanbing on 2022/5/20.
 */

public class PowerTest {

   //测试目标代码：
   public boolean callArgumentInstance(File file) {
      return file.exists();
   }

   // 测试用例代码：
   // https://www.cnblogs.com/hunterCecil/p/5721468.html
   // https://www.cnblogs.com/ting152/p/13304003.html
   @Test
   public void testCallArgumentInstance() {
      File file = PowerMockito.mock(File.class);
      PowerTest underTest = new PowerTest();

      PowerMockito.when(file.exists()).thenReturn(true);

      Assert.assertTrue(underTest.callArgumentInstance(file));
   }
}

package com.maezia.hack.resource.core;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.boot.SpringApplication;

/**
 * @author : ChenRan
 * @date ： 2023/8/8 15:41
 * Description ：BusinessApplicationTest
 * project ：hack-resource-service-parent
 * dep : TT-32
 * company: MA
 */
@RunWith(PowerMockRunner.class)
@PowerMockIgnore("javax.management.*")
@PrepareForTest({SpringApplication.class})
public class BusinessApplicationTest {

    @Before
    public void setUp() throws Exception {
        PowerMockito.mockStatic(SpringApplication.class);
    }
    /**
     * main method
     */
    @Test
    public void main() {
        Assertions.assertDoesNotThrow(() -> BusinessApplication.main(new String[1]));
    }
}

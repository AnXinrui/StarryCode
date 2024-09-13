package com.starrycode;

import com.starrycode.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author axr
 */
@SpringBootTest
public class MPTest {
    @Autowired
    private UserService userService;
    @Test
    public void test() {
        long count = userService.count();
        System.out.println(count);
    }
}

package com.example.seed.web.controller;

import com.example.seed.SeedApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * ApiController Tester.
 *
 * @author Fururur
 * @since <pre>12/12/2019</pre>
 */
@Slf4j
@ActiveProfiles(value = "dev")
@SpringBootTest(classes = SeedApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApiControllerTest {

    @Test
    public void testQuery() throws Exception {
        //TODO: Test goes here...
    }
}

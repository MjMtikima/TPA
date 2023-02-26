package com.makitigroup.training.integrationtests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.BDDAssertions.then;

/**
 * Basic integration tests for service traning provider application.
 *
 * @author TikiMajM
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = {"management.port=0"})
 class BaseTraningApplicationIntegrationTests {

    @LocalServerPort
    private static final int SERVER_PORT = 9000;

    private static final String BASE_URL = "http://localhost:";

    private static final String VERSION = "/v1";

    private static final String HEALTH_STATUS_URL = "/health/status";

    private static final String COURSE_GETALL_URL = "/course/all";

    private static final String SERVICE_GROUP = "/tpa";

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
     void shouldReturn200WhenSendingRequestToHealthController() throws Exception {
        @SuppressWarnings("rawtypes")
        ResponseEntity<String> entity = this.testRestTemplate.getForEntity(
                BaseTraningApplicationIntegrationTests.BASE_URL + BaseTraningApplicationIntegrationTests.SERVER_PORT + BaseTraningApplicationIntegrationTests.SERVICE_GROUP + BaseTraningApplicationIntegrationTests.VERSION + BaseTraningApplicationIntegrationTests.HEALTH_STATUS_URL, String.class);

        then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
     void shouldReturn200WhenSendingRequestToManagementEndpoint() throws Exception {
        @SuppressWarnings("rawtypes")
        ResponseEntity<String> entity = this.testRestTemplate.getForEntity(
                this.BASE_URL + this.SERVER_PORT + this.SERVICE_GROUP + this.VERSION + COURSE_GETALL_URL, String.class);
        then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}

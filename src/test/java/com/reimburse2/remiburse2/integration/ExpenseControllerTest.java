package com.reimburse2.remiburse2.integration;


import com.reimburse2.remiburse2.domain.Expense;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ExpenseControllerTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void test_get_all(){

        ResponseEntity<Expense> response = restTemplate.getForEntity("/expenses", Expense.class);
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

}
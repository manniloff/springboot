package com.example.sweater.controller;

import com.example.sweater.Application;
import com.example.sweater.domen.Message;
import com.google.common.collect.ImmutableList;
import com.mysql.cj.x.protobuf.MysqlxCrud;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = Application.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class MessageControllerIT {

    TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void testGetList(){
        ResponseEntity<List<Message>> responseEntity =
        restTemplate.exchange("http://localhost:8080/messages",
                HttpMethod.GET,null,
                new ParameterizedTypeReference<List<Message>>() {
                });

        List<Message> actualList = responseEntity.getBody();
        //validate
        assertThat(actualList.size(), is(8));
        List<Integer> actualId = actualList.stream()
                                .map(message -> message.getId())
                                     .collect(collectingAndThen(toList(), ImmutableList::copyOf));

        assertThat(actualId,containsInAnyOrder(1,2,3,5,6,9,10,11));
    }

}
package com.board.khjk.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class IndexControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void 메인페이지_로딩(){
        //when
        String body = this.restTemplate.getForObject("/",String.class);

        //then
        assertThat(body).contains("Simple Board");
    }

    @Test
    public void 세이브페이지_로딩(){
        //when
        String body = this.restTemplate.getForObject("/posts/save", String.class);
        //then
        assertThat(body).contains("등록");
    }

    @Test
    public void 업데이트페이지_로딩(){
        //when
        String body = this.restTemplate.getForObject("/posts/update/1", String.class);
        //then
        assertThat(body).contains("수정");
    }


}

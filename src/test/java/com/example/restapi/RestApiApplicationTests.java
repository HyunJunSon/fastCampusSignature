package com.example.restapi;

import com.example.restapi.model.UserRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RestApiApplicationTests {

	@Autowired
	ObjectMapper objectMapper;

	@Test
	void contextLoads() throws JsonProcessingException {
		var user = new UserRequest();
		user.setName("홍길동");
		user.setPhoneNumber("111-222");
		user.setEmail("111@gmail.com");
		user.setKorean(true);

		var json = objectMapper.writeValueAsString(user);
		System.out.println("json = " + json);

		var dto = objectMapper.readValue(json, UserRequest.class );
		System.out.println("dto = " + dto);


	}

}

package com.liunix.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.liunix.SpringTestCase;

@SpringTestCase
@RunWith(SpringRunner.class)
public class FoodApiTest {

	/* client 集成测试 */
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void jsonTest() {
		String body = this.restTemplate.getForObject("/", String.class);
		System.out.println(body);
	}
}

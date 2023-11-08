package com.rating.ratingmanagementsystem;

import com.rating.ratingmanagementsystem.entity.Rating;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RatingManagementSystemApplicationTests {
@LocalServerPort
private int port;
private String baseUrl ="http://localhost";
private static RestTemplate restTemplate;

@BeforeAll
public static void init()
{
	restTemplate = new RestTemplate();
}
@BeforeEach
public void setUp()
{
	baseUrl = baseUrl.concat(":").concat(port+"").concat("/api/rating");
}
@Test
public void testSubmitRating(){
	Rating rating = new Rating();
	rating.setRating(2.5);
	String url = baseUrl.concat("/submit");
	Rating response = restTemplate.postForObject(url,
			rating, Rating.class);
    assert response != null;
    assertEquals(2.5,response.getRating());
}


}

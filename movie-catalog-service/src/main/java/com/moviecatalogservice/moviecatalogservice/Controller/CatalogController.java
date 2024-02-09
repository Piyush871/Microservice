package com.moviecatalogservice.moviecatalogservice.Controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import com.moviecatalogservice.moviecatalogservice.Modals.*;

@RestController
@RequestMapping("/catalog")
public class CatalogController {


	  @Autowired
	  private RestTemplate restTemplate;



	  @GetMapping("/{userId}")
	  public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
	    List<Rating> userRating = Arrays.asList(
	      new Rating("1234", 4),
	      new Rating("5678", 3)
	    );

	    return userRating
	      .stream()
	      .map(rating -> {
	    	  
	        Movie movie = restTemplate.getForObject(
	          "http://localhost:8081/movies/" + rating.getMovieId(),
	          Movie.class
	        );
	        
	        return new CatalogItem(
	          movie.getName(),
	          movie.getDescription(),
	          rating.getRating()
	        );
	      })
	      .collect(Collectors.toList());
	  }
}

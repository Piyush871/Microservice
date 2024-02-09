package com.movieinfoservice.movieinfoservice.Controller;

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
@RequestMapping("/movies")
public class MovieInfoController {

	 @GetMapping("/{movieId}")
	 public Movie getMovieById (@PathVariable("movieId")String movieId)
	 {
		 return new Movie(movieId,"Test Name","Test Desc");
	 }
}

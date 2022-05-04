package com.hr.springwebflux.videostreaming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.hr.springwebflux.videostreaming.service.VideoStreamingService;

import reactor.core.publisher.Mono;

/*
 * Important: Don't map any URL mapping for the @RestController annotation.
 */
@RestController
public class VideoStreamingController {

	@Autowired
	private VideoStreamingService videoStreamingService;
	
	@GetMapping(value = "/video/{videoName}", produces = "video/mp4")
	Mono<Resource> getVideo(@PathVariable final String videoName, @RequestHeader("range") final String range)
	{
		System.out.println("The selected range is : "+range);
		return videoStreamingService.getVideo(videoName);
	}
}

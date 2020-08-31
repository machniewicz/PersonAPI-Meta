package br.com.meta.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "SourceEndpoint", description = "Return Git Repository")
@RestController
@RequestMapping("/source")
public class HtmlController {

	private String gitRepository = "http://github.com/machniewicz/PersonAPI-Meta/";

	@ApiOperation(value = "Return Repository Git")
	@GetMapping
	@ResponseBody
	public String repositoryGit() {
		return gitRepository;
	}

}

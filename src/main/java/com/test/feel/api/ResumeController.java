/**
 * 
 */
package com.test.feel.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.feel.business.ResumeService;
import com.test.feel.domain.Resume;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author Christian Bernardino de Moura
 *
 * christiabmoura@gmail.com
 */

@RestController
@RequestMapping("/resume")
@Api(value = "Feel Test - ResumeController", description = "Resume data")
public class ResumeController {

	@Autowired
	private ResumeService service;
	
	@ApiOperation(value = "Return all resumes.")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Data returned with sucess"),
        @ApiResponse(code = 401, message = "Unauthenticated"),
        @ApiResponse(code = 403, message = "Unauthorized"),
        @ApiResponse(code = 500, message = "Internal error unexpected on server")
    })
	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	public List<Resume> getAllResume() {
		return service.searchAllResume();
	}
	
	@ApiOperation(value = "Return resume by id.")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Data returned with sucess"),
        @ApiResponse(code = 401, message = "Unauthenticated"),
        @ApiResponse(code = 403, message = "Unauthorized"),
        @ApiResponse(code = 500, message = "Internal error unexpected on server")
    })
	@RequestMapping(value = "/getbyid/{id}", method = RequestMethod.GET)
	public Resume getResume(@ApiParam(value = "Resume Id", example = "1", required = true)
	@PathVariable Long id) {
		return service.searchResumeById(id);
	}
	
	@ApiOperation(value = "Return resume Add.")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Data returned with sucess"),
        @ApiResponse(code = 401, message = "Unauthenticated"),
        @ApiResponse(code = 403, message = "Unauthorized"),
        @ApiResponse(code = 500, message = "Internal error unexpected on server")
    })
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Resume addResume(@RequestBody @Valid Resume resume) {
		return service.addResume(resume);
	}
	
	@ApiOperation(value = "Return resume Updated.")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Data returned with sucess"),
        @ApiResponse(code = 401, message = "Unauthenticated"),
        @ApiResponse(code = 403, message = "Unauthorized"),
        @ApiResponse(code = 500, message = "Internal error unexpected on server")
    })
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public Resume updateResume(@RequestBody @Valid Resume resume) {
		return service.saveResume(resume);
	}
	
	@ApiOperation(value = "Return feedback of resume deleted.")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Data returned with sucess"),
        @ApiResponse(code = 401, message = "Unauthenticated"),
        @ApiResponse(code = 403, message = "Unauthorized"),
        @ApiResponse(code = 500, message = "Internal error unexpected on server")
    })
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public String deleteResume(@ApiParam(value = "Resume Id", example = "1", required = true)
	@PathVariable Long id) {
		return service.deleteResume(id);
	}
	
}

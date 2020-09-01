/**
 * 
 */
package com.test.feel.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.feel.domain.Resume;
import com.test.feel.repository.ResumeRepository;

/**
 * @author Christian Bernardino de Moura
 *
 * christiabmoura@gmail.com
 */

@Service
public class ResumeService {

	@Autowired
	private ResumeRepository repository;
	
	public List<Resume> searchAllResume(){
		return repository.findAll();
	}
	
	
	public Resume searchResumeById(Long id) {
		return repository.getOne(id);
	}
	
	public Resume addResume(Resume resume) {
		return repository.save(resume);
	}
	
	public Resume saveResume(Resume resume) {
		return repository.save(resume);
	}
	
	public String deleteResume(Long id) {
		
		String out = "Not found Resume with id " + id.toString();
		
		Resume in = repository.getOne(id);
		
		if (in != null) {
			
			repository.delete(in);
		    out = "Resume Deleted";
		}
		
		return out;
		
	}
}

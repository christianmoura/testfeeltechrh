/**
 * 
 */
package com.test.feel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.feel.domain.Resume;

/**
 * @author Christian Bernardino de Moura
 *
 * christiabmoura@gmail.com
 */

@Repository
public interface ResumeRepository  extends JpaRepository<Resume, Long>  {

}

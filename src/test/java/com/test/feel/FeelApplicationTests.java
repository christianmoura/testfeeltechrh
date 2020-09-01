package com.test.feel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.test.feel.business.ResumeService;
import com.test.feel.domain.AcademicFormation;
import com.test.feel.domain.Certification;
import com.test.feel.domain.Contact;
import com.test.feel.domain.Experience;
import com.test.feel.domain.Resume;
import com.test.feel.domain.Skil;
import com.test.feel.factory.CreateAcademicFormationTest;
import com.test.feel.factory.CreateCertificationTest;
import com.test.feel.factory.CreateContactTest;
import com.test.feel.factory.CreateExperienceTest;
import com.test.feel.factory.CreateResumeTest;
import com.test.feel.factory.CreateSkilTest;
import com.test.feel.repository.ResumeRepository;

@SpringBootTest
class FeelApplicationTests {

	@Test
	void contextLoads() {
	}

	@InjectMocks
	private ResumeService service;
	
	@Mock
	private ResumeRepository repository;
	
	@Test
	public void getAllResumesTest() {
		AcademicFormation academicFormation = CreateAcademicFormationTest.get(1L, "ULBRA-AM", "Sistemas de Informação", 2007, 2011);
		Certification certification = CreateCertificationTest.get(1L,"MTA - Database Administration");
		Contact contact = CreateContactTest.get(1L, "92991555536", "christianbmoura@gmail.com", "https://www.linkedin.com/in/christianmoura/");
		Skil skil = CreateSkilTest.get(1L, "Java");
		
		ZoneId defaultZoneId = ZoneId.systemDefault();
		
		LocalDate localDateStart = LocalDate.of(1997, 9, 1);
		
		LocalDate localDateFinish = LocalDate.of(1999, 12, 31);
		
		Experience experience = CreateExperienceTest.get(1L, "CTISC", "Instrutor de Informática"
				, Date.from(localDateStart.atStartOfDay(defaultZoneId).toInstant())
				, Date.from(localDateFinish.atStartOfDay(defaultZoneId).toInstant()), false, "Manaus-AM"
				, "Ministrei cursos de informática básica e Administrei a rede do local");
		
		Set<Skil> skils = new HashSet<>();
		
		skils.add(skil);
		
		Set<Certification> certifications = new HashSet<>();
		
		certifications.add(certification);
		
		Set<Experience> experiences = new HashSet<>();
		
		experiences.add(experience);
		
		Set<AcademicFormation> academicFormations = new HashSet<>();
		
		academicFormations.add(academicFormation);
		
		Resume resume = CreateResumeTest.get(1L, "Christian Bernardino de Moura", contact
				, skils, certifications, "System Developer Senior", experiences
				, academicFormations);
		
		List<Resume> resumes = new ArrayList<>();
		
		resumes.add(resume);
		
		when(repository.findAll()).thenReturn(resumes);
		
		assertEquals(service.searchAllResume(), resumes);
		
	}
	
	@Test
	public void getAllResumesEmptyTest() {
		
		when(repository.findAll()).thenReturn(null);
		
		assertNull(service.searchAllResume());
		
	}
	
	@Test
	public void getResumeByIdTest() {
		AcademicFormation academicFormation = CreateAcademicFormationTest.get(1L, "ULBRA-AM", "Sistemas de Informação", 2007, 2011);
		Certification certification = CreateCertificationTest.get(1L,"MTA - Database Administration");
		Contact contact = CreateContactTest.get(1L, "92991555536", "christianbmoura@gmail.com", "https://www.linkedin.com/in/christianmoura/");
		Skil skil = CreateSkilTest.get(1L, "Java");
		
		ZoneId defaultZoneId = ZoneId.systemDefault();
		
		LocalDate localDateStart = LocalDate.of(1997, 9, 1);
		
		LocalDate localDateFinish = LocalDate.of(1999, 12, 31);
		
		Experience experience = CreateExperienceTest.get(1L, "CTISC", "Instrutor de Informática"
				, Date.from(localDateStart.atStartOfDay(defaultZoneId).toInstant())
				, Date.from(localDateFinish.atStartOfDay(defaultZoneId).toInstant()), false, "Manaus-AM"
				, "Ministrei cursos de informática básica e Administrei a rede do local");
		
		Set<Skil> skils = new HashSet<>();
		
		skils.add(skil);
		
		Set<Certification> certifications = new HashSet<>();
		
		certifications.add(certification);
		
		Set<Experience> experiences = new HashSet<>();
		
		experiences.add(experience);
		
		Set<AcademicFormation> academicFormations = new HashSet<>();
		
		academicFormations.add(academicFormation);
		
		Resume resume = CreateResumeTest.get(1L, "Christian Bernardino de Moura", contact
				, skils, certifications, "System Developer Senior", experiences
				, academicFormations);
		
		when(repository.getOne(1L)).thenReturn(resume);
		
		assertEquals(service.searchResumeById(1L), resume);
		
	}
	
	@Test
	public void getResumeByIdInvalidTest() {
		AcademicFormation academicFormation = CreateAcademicFormationTest.get(1L, "ULBRA-AM", "Sistemas de Informação", 2007, 2011);
		Certification certification = CreateCertificationTest.get(1L,"MTA - Database Administration");
		Contact contact = CreateContactTest.get(1L, "92991555536", "christianbmoura@gmail.com", "https://www.linkedin.com/in/christianmoura/");
		Skil skil = CreateSkilTest.get(1L, "Java");
		
		ZoneId defaultZoneId = ZoneId.systemDefault();
		
		LocalDate localDateStart = LocalDate.of(1997, 9, 1);
		
		LocalDate localDateFinish = LocalDate.of(1999, 12, 31);
		
		Experience experience = CreateExperienceTest.get(1L, "CTISC", "Instrutor de Informática"
				, Date.from(localDateStart.atStartOfDay(defaultZoneId).toInstant())
				, Date.from(localDateFinish.atStartOfDay(defaultZoneId).toInstant()), false, "Manaus-AM"
				, "Ministrei cursos de informática básica e Administrei a rede do local");
		
		Set<Skil> skils = new HashSet<>();
		
		skils.add(skil);
		
		Set<Certification> certifications = new HashSet<>();
		
		certifications.add(certification);
		
		Set<Experience> experiences = new HashSet<>();
		
		experiences.add(experience);
		
		Set<AcademicFormation> academicFormations = new HashSet<>();
		
		academicFormations.add(academicFormation);
		
		Resume resume = CreateResumeTest.get(1L, "Christian Bernardino de Moura", contact
				, skils, certifications, "System Developer Senior", experiences
				, academicFormations);
		
		when(repository.getOne(1L)).thenReturn(resume);
		
		assertNull(service.searchResumeById(2L));
		
	}
	
	
	@Test
	public void postResumeTest() {
		AcademicFormation academicFormation = CreateAcademicFormationTest.get(1L, "ULBRA-AM", "Sistemas de Informação", 2007, 2011);
		Certification certification = CreateCertificationTest.get(1L,"MTA - Database Administration");
		Contact contact = CreateContactTest.get(1L, "92991555536", "christianbmoura@gmail.com", "https://www.linkedin.com/in/christianmoura/");
		Skil skil = CreateSkilTest.get(1L, "Java");
		
		ZoneId defaultZoneId = ZoneId.systemDefault();
		
		LocalDate localDateStart = LocalDate.of(1997, 9, 1);
		
		LocalDate localDateFinish = LocalDate.of(1999, 12, 31);
		
		Experience experience = CreateExperienceTest.get(1L, "CTISC", "Instrutor de Informática"
				, Date.from(localDateStart.atStartOfDay(defaultZoneId).toInstant())
				, Date.from(localDateFinish.atStartOfDay(defaultZoneId).toInstant()), false, "Manaus-AM"
				, "Ministrei cursos de informática básica e Administrei a rede do local");
		
		Set<Skil> skils = new HashSet<>();
		
		skils.add(skil);
		
		Set<Certification> certifications = new HashSet<>();
		
		certifications.add(certification);
		
		Set<Experience> experiences = new HashSet<>();
		
		experiences.add(experience);
		
		Set<AcademicFormation> academicFormations = new HashSet<>();
		
		academicFormations.add(academicFormation);
		
		Resume resume = CreateResumeTest.get(1L, "Christian Bernardino de Moura", contact
				, skils, certifications, "System Developer Senior", experiences
				, academicFormations);
		
		when(repository.save(resume)).thenReturn(resume);
		
		assertEquals(service.addResume(resume), resume);
		
	}
	
	@Test
	public void putResumeTest() {
		AcademicFormation academicFormation = CreateAcademicFormationTest.get(1L, "ULBRA-AM", "Sistemas de Informação", 2007, 2011);
		Certification certification = CreateCertificationTest.get(1L,"MTA - Database Administration");
		Contact contact = CreateContactTest.get(1L, "92991555536", "christianbmoura@gmail.com", "https://www.linkedin.com/in/christianmoura/");
		Skil skil = CreateSkilTest.get(1L, "Java");
		
		ZoneId defaultZoneId = ZoneId.systemDefault();
		
		LocalDate localDateStart = LocalDate.of(1997, 9, 1);
		
		LocalDate localDateFinish = LocalDate.of(1999, 12, 31);
		
		Experience experience = CreateExperienceTest.get(1L, "CTISC", "Instrutor de Informática"
				, Date.from(localDateStart.atStartOfDay(defaultZoneId).toInstant())
				, Date.from(localDateFinish.atStartOfDay(defaultZoneId).toInstant()), false, "Manaus-AM"
				, "Ministrei cursos de informática básica e Administrei a rede do local");
		
		Set<Skil> skils = new HashSet<>();
		
		skils.add(skil);
		
		Set<Certification> certifications = new HashSet<>();
		
		certifications.add(certification);
		
		Set<Experience> experiences = new HashSet<>();
		
		experiences.add(experience);
		
		Set<AcademicFormation> academicFormations = new HashSet<>();
		
		academicFormations.add(academicFormation);
		
		Resume resume = CreateResumeTest.get(1L, "Christian Bernardino de Moura", contact
				, skils, certifications, "System Developer Senior", experiences
				, academicFormations);
		
		resume.setApresentationShort("Desenvolvedor Java");
		
		
		when(repository.save(resume)).thenReturn(resume);
		
		assertEquals(service.saveResume(resume), resume);
		
	}
	
	@Test
	public void deleteResumeTest() {
		AcademicFormation academicFormation = CreateAcademicFormationTest.get(1L, "ULBRA-AM", "Sistemas de Informação", 2007, 2011);
		Certification certification = CreateCertificationTest.get(1L,"MTA - Database Administration");
		Contact contact = CreateContactTest.get(1L, "92991555536", "christianbmoura@gmail.com", "https://www.linkedin.com/in/christianmoura/");
		Skil skil = CreateSkilTest.get(1L, "Java");
		
		ZoneId defaultZoneId = ZoneId.systemDefault();
		
		LocalDate localDateStart = LocalDate.of(1997, 9, 1);
		
		LocalDate localDateFinish = LocalDate.of(1999, 12, 31);
		
		Experience experience = CreateExperienceTest.get(1L, "CTISC", "Instrutor de Informática"
				, Date.from(localDateStart.atStartOfDay(defaultZoneId).toInstant())
				, Date.from(localDateFinish.atStartOfDay(defaultZoneId).toInstant()), false, "Manaus-AM"
				, "Ministrei cursos de informática básica e Administrei a rede do local");
		
		Set<Skil> skils = new HashSet<>();
		
		skils.add(skil);
		
		Set<Certification> certifications = new HashSet<>();
		
		certifications.add(certification);
		
		Set<Experience> experiences = new HashSet<>();
		
		experiences.add(experience);
		
		Set<AcademicFormation> academicFormations = new HashSet<>();
		
		academicFormations.add(academicFormation);
		
		Resume resume = CreateResumeTest.get(1L, "Christian Bernardino de Moura", contact
				, skils, certifications, "System Developer Senior", experiences
				, academicFormations);
		
		
		when(repository.getOne(1L)).thenReturn(resume);
		
		assertEquals(service.deleteResume(1L), "Resume Deleted");
		
	}
	
	@Test
	public void deleteResumeInvalidTest() {
		AcademicFormation academicFormation = CreateAcademicFormationTest.get(1L, "ULBRA-AM", "Sistemas de Informação", 2007, 2011);
		Certification certification = CreateCertificationTest.get(1L,"MTA - Database Administration");
		Contact contact = CreateContactTest.get(1L, "92991555536", "christianbmoura@gmail.com", "https://www.linkedin.com/in/christianmoura/");
		Skil skil = CreateSkilTest.get(1L, "Java");
		
		ZoneId defaultZoneId = ZoneId.systemDefault();
		
		LocalDate localDateStart = LocalDate.of(1997, 9, 1);
		
		LocalDate localDateFinish = LocalDate.of(1999, 12, 31);
		
		Experience experience = CreateExperienceTest.get(1L, "CTISC", "Instrutor de Informática"
				, Date.from(localDateStart.atStartOfDay(defaultZoneId).toInstant())
				, Date.from(localDateFinish.atStartOfDay(defaultZoneId).toInstant()), false, "Manaus-AM"
				, "Ministrei cursos de informática básica e Administrei a rede do local");
		
		Set<Skil> skils = new HashSet<>();
		
		skils.add(skil);
		
		Set<Certification> certifications = new HashSet<>();
		
		certifications.add(certification);
		
		Set<Experience> experiences = new HashSet<>();
		
		experiences.add(experience);
		
		Set<AcademicFormation> academicFormations = new HashSet<>();
		
		academicFormations.add(academicFormation);
		
		Resume resume = CreateResumeTest.get(1L, "Christian Bernardino de Moura", contact
				, skils, certifications, "System Developer Senior", experiences
				, academicFormations);
		
		
		when(repository.getOne(1L)).thenReturn(resume);
		
		assertEquals(service.deleteResume(2L), "Not found Resume with id 2");
		
	}
	
}

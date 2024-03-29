package edu.mum.cs544.MumRegistrationApi.Service;

import edu.mum.cs544.MumRegistrationApi.Model.Admission;
import edu.mum.cs544.MumRegistrationApi.Model.Result;
import edu.mum.cs544.MumRegistrationApi.Model.Admission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@Service
public class AdmissionService {

    private String admissionURL = "http://localhost:8081/api/admission";

    @Autowired
    private RestTemplate restTemplate;


   // @Secured("ROLE_a")
    public List<Admission> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Admission>> response = restTemplate.exchange(admissionURL, HttpMethod.GET,null,new ParameterizedTypeReference<List<Admission>>(){});
        List<Admission> admissions = response.getBody();
        return admissions;
    }

    public Admission get(long id){
        return  restTemplate.getForObject(admissionURL+"/"+ id,  Admission.class);
    }


   // @Secured("ROLE_a")
    public Result add(Admission Admission) {
        URI uri=restTemplate.postForLocation(admissionURL,Admission);
        return new Result(true, "Admission added!");
    }

    //@Secured("ROLE_a")
    public Result update(Admission Admission) {
        restTemplate.put(admissionURL,Admission,Admission.getId());
        return new Result(true, "Admission updated!");
    }

    //@Secured("ROLE_a")
    public Result delete(long id) {
        restTemplate.delete(admissionURL +"/" +id,id);
        return new Result(true, "Admission deleted!");
    }


//    //@Secured("ROLE_s")
//    public List<SectionDto> getEnrolledSections(long userId) {
//        Admission Admission = getAdmissionByUserId(userId);
//        List<SectionDto> sectionDtoList = new ArrayList<>();
//
//        List<Section> sections = Admission.getSections();
//        for (Section section : sections) {
//            SectionDto sectionDto = new SectionDto();
//            sectionDto.setId(section.getId());
//            sectionDto.setCourseName(section.getCourse().getName());
//            sectionDto.setCourseCode(section.getCourse().getCode());
//            sectionDto.setBlock(section.getAssignedBlock().getName());
//            sectionDto.setFaculty(section.getFaculty().getFirstName() + " " + section.getFaculty().getLastName());
//            sectionDtoList.add(sectionDto);
//        }
//        return sectionDtoList;
//    }

  //  @Secured("ROLE_s")
  //  public Result registerForSections(long userId, int[] sectionIdArray) {
//        Admission Admission = getAdmissionByUserId(userId);
//        List<Section> sections = new ArrayList<>();
//
//        for (int sectionId : sectionIdArray) {
//            Section section = sectionRepo.getSectionById(sectionId);
//            if (section.getCapacity() == section.getEnrolledAdmissions().size())
//                return new Result(false, section.getCourse().getName() + " - " + section.getFaculty().getFirstName() + " " + section.getFaculty().getLastName() + " section has no available seats!");
//            sections.add(section);
//        }
//        Admission.setSections(sections);
//        AdmissionRepo.save(Admission);

      //  return new Result(true, "Registered for these sections!");
   // }
}

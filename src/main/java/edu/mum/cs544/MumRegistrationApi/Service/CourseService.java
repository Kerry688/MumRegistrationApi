package edu.mum.cs544.MumRegistrationApi.Service;

import edu.mum.cs544.MumRegistrationApi.Model.Block;
import edu.mum.cs544.MumRegistrationApi.Model.Course;
import edu.mum.cs544.MumRegistrationApi.Model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CourseService {
   @Autowired
   private RestTemplate restTemplate;

    private String courseUrl = "http://localhost:8083/api/course";

    public List<Course>getCourses(){
        ResponseEntity<List<Course>> response= restTemplate.exchange(courseUrl,
                HttpMethod.GET,null,new ParameterizedTypeReference<List<Course>>(){});
        return response.getBody();
    }

    public Course getCourse(Long id) {
        return restTemplate.getForObject(courseUrl + "/" + id, Course.class);
    }

    public Long addCourse(Course course){
      URI uri=restTemplate.postForLocation(courseUrl,course);
        if (uri == null) { return null; }
        Matcher m = Pattern.compile(".*/course/(\\d+)").matcher(uri.getPath());
        m.matches();
        return Long.parseLong(m.group(1));
        //restTemplate.postForLocation("http://localhost:8083/api/course",course);
        }

    public void updateCourse(Course course){
        restTemplate.put(courseUrl,course,course.getId());
    }

    public Result deleteCourse(long id){
        restTemplate.delete(courseUrl+id,id);
        return new Result(true, "Course deleted!");
    }


}

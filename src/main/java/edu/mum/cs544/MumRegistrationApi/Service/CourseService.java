package edu.mum.cs544.MumRegistrationApi.Service;

import edu.mum.cs544.MumRegistrationApi.Model.Course;
import edu.mum.cs544.MumRegistrationApi.Model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CourseService {
   @Autowired
   private RestTemplate restTemplate;
    public List<Course>getCourses(){
        ResponseEntity<List<Course>> response= restTemplate.exchange("http://localhost:8083/api/course",
                HttpMethod.GET,null,new ParameterizedTypeReference<List<Course>>(){});
        return response.getBody();
    }

    public Long addCourse(Course course){
      URI uri=restTemplate.postForLocation("http://localhost:8083/api/course",course);
        if (uri == null) { return null; }
        Matcher m = Pattern.compile(".*/course/(\\d+)").matcher(uri.getPath());
        m.matches();
        return Long.parseLong(m.group(1));
        //restTemplate.postForLocation("http://localhost:8083/api/course",course);
        }

    public void updateCourse(Course course){
        restTemplate.put("http://localhost:8083/api/course",course,course.getId());
            }


    public Result deleteCourse(long id){
        restTemplate.delete("http://localhost:8083/api/course/"+id,id);
        return new Result(true, "Course deleted!");
    }


}

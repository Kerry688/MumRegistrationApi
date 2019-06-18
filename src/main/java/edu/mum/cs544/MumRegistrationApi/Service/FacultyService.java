package edu.mum.cs544.MumRegistrationApi.Service;


import edu.mum.cs544.MumRegistrationApi.Model.Course;
import edu.mum.cs544.MumRegistrationApi.Model.Faculty;
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
public class FacultyService  {

    @Autowired
    private RestTemplate restTemplate;


    public List<Faculty> getFaculties(){

        ResponseEntity<List<Faculty>> response= restTemplate.exchange("http://localhost:8084/api/faculty",
                HttpMethod.GET,null,new ParameterizedTypeReference<List<Faculty>>(){});
        return response.getBody();
    }




    public Long addFaculty(Faculty faculty){

        URI uri=restTemplate.postForLocation("http://localhost:8084/api/faculty",faculty);
        if (uri == null) { return null; }
        Matcher m = Pattern.compile(".*/faculty/(\\d+)").matcher(uri.getPath());
        m.matches();
        return Long.parseLong(m.group(1));

        //return new Result(true, "Faculty added!");
    }


    public void updateFaculty(Faculty faculty){
        restTemplate.put("http://localhost:8084/api/faculty",faculty,faculty.getId());
    }

    public Result deleteFaculty(long id){

        restTemplate.delete("http://localhost:8084/api/faculty/"+id,id);
        return new Result(true, "Course deleted!");

    }

}

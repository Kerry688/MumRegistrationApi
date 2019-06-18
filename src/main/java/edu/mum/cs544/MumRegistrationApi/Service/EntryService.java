package edu.mum.cs544.MumRegistrationApi.Service;
import edu.mum.cs544.MumRegistrationApi.Model.Course;
import edu.mum.cs544.MumRegistrationApi.Model.Entry;
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
public class EntryService {
    @Autowired
    private RestTemplate restTemplate;
    private String entryURL ="http://localhost:8083/api/course";

    public List<Entry> getEntries() {
        ResponseEntity<List<Entry>> response = restTemplate.exchange(entryURL,
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Entry>>() {
                });
        return response.getBody();
    }
    public Entry getEntry(Long id) {
        return restTemplate.getForObject(entryURL + "/" + id, Entry.class);
    }
    public Long addEntry(Entry entry){
        URI uri=restTemplate.postForLocation("http://localhost:8083/api/entry",entry);
        if (uri == null) { return null; }
        Matcher m = Pattern.compile(".*/entry/(\\d+)").matcher(uri.getPath());
        m.matches();
        return Long.parseLong(m.group(1));
    }
    public void updateEntry(Entry entry){
        restTemplate.put(entryURL,entry,entry.getId());
    }
    public void deleteEntry(long id){
        restTemplate.delete(entryURL+id,id);
    }
}

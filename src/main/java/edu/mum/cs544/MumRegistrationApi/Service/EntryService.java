package edu.mum.cs544.MumRegistrationApi.Service;
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

    public List<Entry> getEntries() {
        ResponseEntity<List<Entry>> response = restTemplate.exchange("http://localhost:8083/api/entry",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Entry>>() {
                });
        return response.getBody();
    }

    public Long addEntry(Entry entry){
        URI uri=restTemplate.postForLocation("http://localhost:8083/api/entry",entry);
        if (uri == null) { return null; }
        Matcher m = Pattern.compile(".*/entry/(\\d+)").matcher(uri.getPath());
        m.matches();
        return Long.parseLong(m.group(1));
    }
    public void updateEntry(Entry entry){
        restTemplate.put("http://localhost:8083/api/course",entry,entry.getId());
    }
    public void deleteEntry(long id){
        restTemplate.delete("http://localhost:8083/api/entry/"+id,id);
    }
}

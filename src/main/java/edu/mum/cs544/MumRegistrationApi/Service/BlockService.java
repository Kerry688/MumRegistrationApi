package edu.mum.cs544.MumRegistrationApi.Service;


import edu.mum.cs544.MumRegistrationApi.Model.Admission;
import edu.mum.cs544.MumRegistrationApi.Model.Block;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class BlockService {
    @Autowired
    private RestTemplate restTemplate;

    private String blockURL = "http://localhost:8083/api/block";

    public List<Block> getBlocks() {
        ResponseEntity<List<Block>> response = restTemplate.exchange("http://localhost:8083/api/block", HttpMethod.GET, null, new ParameterizedTypeReference<List<Block>>() {
        });
        return response.getBody();
    }

    public Block getBlock(Long id) {
        return restTemplate.getForObject(blockURL + "/" + id, Block.class);
    }

    public Long addBlock(Block block) {
        URI uri = restTemplate.postForLocation(blockURL, block);
        if (uri == null) {
            return null;
        }
        Matcher m = Pattern.compile(".*/block/(\\d+)").matcher(uri.getPath());
        m.matches();
        return Long.parseLong(m.group(1));
    }

    public void updateBlock(Block block) {
        restTemplate.put(blockURL, block, block.getId());
    }

    public void deleteBlock(long id) {
        restTemplate.delete(blockURL + id, id);
    }
    public List<Block> getBlocksWithSections(){
        List<Block> blocks = new ArrayList<>();

        for(Block block : blocks){

        }
        return blocks;
    }
}
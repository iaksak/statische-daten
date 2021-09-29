package com.gefa.statischedaten.impl;

/*
 * @created 21/09/2021 12:48 AM
 * @author Ivan Aksak aksak@iname.com
 */
import java.io.Console;
import java.util.*;
import java.util.stream.Stream;

import com.gefa.statischedaten.api.ExampleApi;
import com.gefa.statischedaten.model.Example;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController implements ExampleApi {

    private static final String MESSAGE_NULL_ID = "null is not a valid id";
    private static final String MESSAGE_NULL_USER = "null is not a valid user object";
    private Map<String, Example> examples = new HashMap<>();

    public ExampleController() {
        //Stream.of("Spring Example", "Swagger Example").map(name -> save(new Example(name)));
        for (String name : Arrays.asList("Spring Example", "Swagger Example")) {
            Example example = new Example(name);
            save(example);
        }
    }

    @Override
    public List<Example> findAll() {
        return new ArrayList<>(examples.values());
    }

    @Override
    public Example findById(String id) {
        return examples.get(id);
    }

    @Override
    public Example save(Example example) {

        if(example == null) {
            throw new IllegalArgumentException(MESSAGE_NULL_USER);
        }

        example.setId(UUID.randomUUID().toString());
        examples.put(example.getId(), example);

        return example;
    }

    @Override
    public Example update(String id, Example example) {

        if(id == null) {
            throw new IllegalArgumentException(MESSAGE_NULL_ID);
        }
        if(example == null) {
            throw new IllegalArgumentException(MESSAGE_NULL_USER);
        }

        examples.put(id, example);

        return example;
    }

    @Override
    public void delete(String id) {

        if(id == null) {
            throw new IllegalArgumentException(MESSAGE_NULL_ID);
        }

        examples.remove(id);
    }

}

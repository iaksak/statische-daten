package com.gefa.statischedaten.api;

/*
 * @created 20/09/2021 10:33 PM
 * @author Ivan Aksak aksak@iname.com
 */
import java.util.List;

import com.gefa.statischedaten.model.Example;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping("/api/examples")
@Tag(name = "Example API", description = "Example Management API")
public interface ExampleApi {

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<Example> findAll();

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    Example findById(@PathVariable String id);

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    Example save(@RequestBody Example example);

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    Example update(@PathVariable String id, @RequestBody Example example);

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void delete(@PathVariable String id);
}

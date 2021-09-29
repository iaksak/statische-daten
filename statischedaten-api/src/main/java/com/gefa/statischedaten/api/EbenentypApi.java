package com.gefa.statischedaten.api;

import com.gefa.statischedaten.model.Ebenentyp;
import com.gefa.statischedaten.model.Example;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * @created 29/09/2021 3:07 AM
 * @author Ivan Aksak aksak@iname.com
 */
@RequestMapping("/api/ebenentyp")
@Tag(name = "Ebebentyp API", description = "Ebebentyp API")
public interface EbenentypApi {
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<Ebenentyp> findAll();

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    Ebenentyp findById(@PathVariable Integer id);

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    Ebenentyp save(@RequestBody Ebenentyp example);

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    Ebenentyp update(@PathVariable Integer id, @RequestBody Ebenentyp example);

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void delete(@PathVariable Integer id);
}

package com.gefa.statischedaten.api;

import com.gefa.statischedaten.model.Justizbehoerdentyp;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * @created 29/09/2021 2:53 PM
 * @author Ivan Aksak aksak@iname.com
 */
@RequestMapping("/api/justizbehoerdentyp")
@Tag(name = "Justizbehoerdentyp API", description = "Justizbehoerdentyp (ENUM_24) API")
public interface JustizbehoerdentypApi {
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<Justizbehoerdentyp> findAll();

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    Justizbehoerdentyp findById(@PathVariable Integer id);

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    Justizbehoerdentyp save(@RequestBody Justizbehoerdentyp justizbehoerdentyp);

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    Justizbehoerdentyp update(@PathVariable Integer id, @RequestBody Justizbehoerdentyp justizbehoerdentyp);

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void delete(@PathVariable Integer id);
}

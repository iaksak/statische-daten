package com.gefa.statischedaten.impl;

/*
 * @created 29/09/2021 3:14 AM
 * @author Ivan Aksak aksak@iname.com
 */

import com.gefa.statischedaten.api.EbenentypApi;
import com.gefa.statischedaten.model.Ebenentyp;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class EbenentypController implements EbenentypApi {
    private static int LAST_ID = 0;


    private static final String MESSAGE_NULL_ID = "null is not a valid id";
    private static final String MESSAGE_NULL_USER = "null is not a valid user object";
    private Map<Integer, Ebenentyp> ebenentypen = new HashMap<>();

    public EbenentypController() {
        save (new Ebenentyp("JBeh", "Justizbehörde"));
        save (new Ebenentyp("Abt", "Abteilung"));
        save (new Ebenentyp("OE", "Organisationseinheit"));
    }

    @Override
    public List<Ebenentyp> findAll() {
        return new ArrayList<>(ebenentypen.values());
    }

    @Override
    public Ebenentyp findById(Integer id) {
        return ebenentypen.get(id);
    }

    @Override
    public Ebenentyp save(Ebenentyp example) {

        if(example == null) {
            throw new IllegalArgumentException(MESSAGE_NULL_USER);
        }

        example.setId(++LAST_ID);
        ebenentypen.put(example.getId(), example);

        return example;
    }

    @Override
    public Ebenentyp update(Integer id, Ebenentyp example) {

        if(id == null) {
            throw new IllegalArgumentException(MESSAGE_NULL_ID);
        }
        if(example == null) {
            throw new IllegalArgumentException(MESSAGE_NULL_USER);
        }

        ebenentypen.put(id, example);

        return example;
    }

    @Override
    public void delete(Integer id) {

        if(id == null) {
            throw new IllegalArgumentException(MESSAGE_NULL_ID);
        }

        ebenentypen.remove(id);
    }
}

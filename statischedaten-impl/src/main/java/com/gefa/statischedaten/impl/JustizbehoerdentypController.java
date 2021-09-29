package com.gefa.statischedaten.impl;

import com.gefa.statischedaten.api.JustizbehoerdentypApi;
import com.gefa.statischedaten.model.Justizbehoerdentyp;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @created 29/09/2021 2:58 PM
 * @author Ivan Aksak aksak@iname.com
 */
@RestController
public class JustizbehoerdentypController implements JustizbehoerdentypApi {
    private static int LAST_ID = 0;


    private static final String MESSAGE_NULL_ID = "null is not a valid id";
    private static final String MESSAGE_NULL_USER = "null is not a valid user object";
    private Map<Integer, Justizbehoerdentyp> justizbehoerdentypen = new HashMap<>();

    public JustizbehoerdentypController() {
        save (new Justizbehoerdentyp("Amtsgericht", "AG"));
        save (new Justizbehoerdentyp("Landgericht", "LG"));
        save (new Justizbehoerdentyp("Oberlandesgericht", "OLG"));
        save (new Justizbehoerdentyp("Bayerisches Oberstes Landesgericht", "BayObLG"));
        save (new Justizbehoerdentyp("Arbeitsgericht", "ArbG"));
        save (new Justizbehoerdentyp("Landesarbeitsgericht", "LAG"));
        save (new Justizbehoerdentyp("Sozialgericht", "SG"));
        save (new Justizbehoerdentyp("Landessozialgericht", "LSG"));
        save (new Justizbehoerdentyp("Verwaltungsgericht", "VG"));
        save (new Justizbehoerdentyp("Oberverwaltungsgericht", "OVG"));
        save (new Justizbehoerdentyp("Verwaltungsgerichtshof", "VGH"));
        save (new Justizbehoerdentyp("Finanzgericht", "FG"));
        save (new Justizbehoerdentyp("Staatsanwaltschaft", "STA"));
        save (new Justizbehoerdentyp("Generalstaatsanwaltschaft", "GStA/GenStA"));
        save (new Justizbehoerdentyp("Kammergericht", "KG"));
    }

    @Override
    public List<Justizbehoerdentyp> findAll() {
        return new ArrayList<>(justizbehoerdentypen.values());
    }

    @Override
    public Justizbehoerdentyp findById(Integer id) {
        return justizbehoerdentypen.get(id);
    }

    @Override
    public Justizbehoerdentyp save(Justizbehoerdentyp example) {

        if(example == null) {
            throw new IllegalArgumentException(MESSAGE_NULL_USER);
        }

        example.setId(++LAST_ID);
        justizbehoerdentypen.put(example.getId(), example);

        return example;
    }

    @Override
    public Justizbehoerdentyp update(Integer id, Justizbehoerdentyp example) {

        if(id == null) {
            throw new IllegalArgumentException(MESSAGE_NULL_ID);
        }
        if(example == null) {
            throw new IllegalArgumentException(MESSAGE_NULL_USER);
        }

        justizbehoerdentypen.put(id, example);

        return example;
    }

    @Override
    public void delete(Integer id) {

        if(id == null) {
            throw new IllegalArgumentException(MESSAGE_NULL_ID);
        }

        justizbehoerdentypen.remove(id);
    }
}

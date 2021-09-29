package com.gefa.statischedaten.integrationtest;

import com.gefa.statischedaten.client.api.JustizbehoerdentypApiApi;
import com.gefa.statischedaten.client.api.JustizbehoerdentypApiApi;
import com.gefa.statischedaten.client.api.model.Justizbehoerdentyp;
import com.gefa.statischedaten.client.invoker.ApiClient;
import com.gefa.statischedaten.client.invoker.ApiException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/*
 * @created 29/09/2021 4:59 PM
 * @author Ivan Aksak aksak@iname.com
 */
public class JustizbehoerdentypIntegrationTest {
    private JustizbehoerdentypApiApi justizbehoerdentypApi;

    @BeforeEach
    public void init() {
        ApiClient apiClient = new ApiClient();
        apiClient.setHost("localhost");
        apiClient.setPort(8080);
        justizbehoerdentypApi = new JustizbehoerdentypApiApi(apiClient);
    }

    @Test
    void testSaveJustizbehoerdentyp() throws ApiException {

        Justizbehoerdentyp justizbehoerdentyp = new Justizbehoerdentyp();
        justizbehoerdentyp.setName("testSaveJustizbehoerdentyp");
        Justizbehoerdentyp savedJustizbehoerdentyp = justizbehoerdentypApi.save(justizbehoerdentyp);

        assertNotNull(savedJustizbehoerdentyp);
        assertNotNull(savedJustizbehoerdentyp.getId());
        assertNotEquals(savedJustizbehoerdentyp.getId(), justizbehoerdentyp.getId());
        assertEquals(savedJustizbehoerdentyp.getName(), justizbehoerdentyp.getName());
    }

    @Test
    void testGetJustizbehoerdentyp() throws ApiException {

        Justizbehoerdentyp justizbehoerdentyp = new Justizbehoerdentyp();
        justizbehoerdentyp.setName("testGetJustizbehoerdentyp");
        Justizbehoerdentyp savedJustizbehoerdentyp = justizbehoerdentypApi.save(justizbehoerdentyp);

        Justizbehoerdentyp findJustizbehoerdentyp = justizbehoerdentypApi.findById(savedJustizbehoerdentyp.getId());

        assertNotNull(findJustizbehoerdentyp);
        assertEquals(findJustizbehoerdentyp.getName(), justizbehoerdentyp.getName());
    }

    @Test
    void testFindAllJustizbehoerdentyp() throws ApiException {

        Justizbehoerdentyp justizbehoerdentyp = new Justizbehoerdentyp();
        justizbehoerdentyp.setName("findAllJustizbehoerdentyp");
        Justizbehoerdentyp savedJustizbehoerdentyp = justizbehoerdentypApi.save(justizbehoerdentyp);

        List<Justizbehoerdentyp> justizbehoerdentyps = justizbehoerdentypApi.findAll();

        Optional<Justizbehoerdentyp> foundJustizbehoerdentyp = justizbehoerdentyps.stream().filter(u -> savedJustizbehoerdentyp.getId().equals(u.getId())).findAny();
        assertTrue(foundJustizbehoerdentyp.isPresent());
    }
}

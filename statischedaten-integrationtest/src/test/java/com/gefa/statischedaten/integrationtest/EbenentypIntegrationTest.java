package com.gefa.statischedaten.integrationtest;

import com.gefa.statischedaten.client.api.EbenentypApiApi;
import com.gefa.statischedaten.client.api.model.Ebenentyp;
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
 * @created 29/09/2021 10:42 AM
 * @author Ivan Aksak aksak@iname.com
 */
public class EbenentypIntegrationTest {
    private EbenentypApiApi ebenentypApi;

    @BeforeEach
    public void init() {
        ApiClient apiClient = new ApiClient();
        apiClient.setHost("localhost");
        apiClient.setPort(8080);
        ebenentypApi = new EbenentypApiApi(apiClient);
    }

    @Test
    void testSaveEbenentyp() throws ApiException {

        Ebenentyp ebenentyp = new Ebenentyp();
        ebenentyp.setName("testSaveEbenentyp");
        Ebenentyp savedEbenentyp = ebenentypApi.save1(ebenentyp);

        assertNotNull(savedEbenentyp);
        assertNotNull(savedEbenentyp.getId());
        assertNotEquals(savedEbenentyp.getId(), ebenentyp.getId());
        assertEquals(savedEbenentyp.getName(), ebenentyp.getName());
    }

    @Test
    void testGetEbenentyp() throws ApiException {

        Ebenentyp ebenentyp = new Ebenentyp();
        ebenentyp.setName("testGetEbenentyp");
        Ebenentyp savedEbenentyp = ebenentypApi.save1(ebenentyp);

        Ebenentyp findEbenentyp = ebenentypApi.findById1(savedEbenentyp.getId());

        assertNotNull(findEbenentyp);
        assertEquals(findEbenentyp.getName(), ebenentyp.getName());
    }

    @Test
    void testFindAllEbenentyp() throws ApiException {

        Ebenentyp ebenentyp = new Ebenentyp();
        ebenentyp.setName("findAllEbenentyp");
        Ebenentyp savedEbenentyp = ebenentypApi.save1(ebenentyp);

        List<Ebenentyp> ebenentyps = ebenentypApi.findAll1();

        Optional<Ebenentyp> foundEbenentyp = ebenentyps.stream().filter(u -> savedEbenentyp.getId().equals(u.getId())).findAny();
        assertTrue(foundEbenentyp.isPresent());
    }
}

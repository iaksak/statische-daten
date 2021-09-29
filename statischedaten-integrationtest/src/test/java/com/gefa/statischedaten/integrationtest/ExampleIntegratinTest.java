package com.gefa.statischedaten.integrationtest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import java.util.List;
import java.util.Optional;

import com.gefa.statischedaten.client.api.ExampleApiApi;
import com.gefa.statischedaten.client.api.model.Example;
import com.gefa.statischedaten.client.invoker.ApiClient;
import com.gefa.statischedaten.client.invoker.ApiException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
 * @created 29/09/2021 12:25 AM
 * @author Ivan Aksak aksak@iname.com
 */
public class ExampleIntegratinTest {
    private ExampleApiApi exampleApi;

    @BeforeEach
    public void init() {
        ApiClient apiClient = new ApiClient();
        apiClient.setHost("localhost");
        apiClient.setPort(8080);
        exampleApi = new ExampleApiApi(apiClient);
    }

    @Test
    void testSaveExample() throws ApiException {

        Example example = new Example();
        example.setName("testSaveExample");
        Example savedExample = exampleApi.save(example);

        assertNotNull(savedExample);
        assertNotNull(savedExample.getId());
        assertNotEquals(savedExample.getId(), example.getId());
        assertEquals(savedExample.getName(), example.getName());
    }

    @Test
    void testGetExample() throws ApiException {

        Example example = new Example();
        example.setName("testGetExample");
        Example savedExample = exampleApi.save(example);

        Example findExample = exampleApi.findById(savedExample.getId());

        assertNotNull(findExample);
        assertEquals(findExample.getName(), example.getName());
    }

    @Test
    void testFindAllExample() throws ApiException {

        Example example = new Example();
        example.setName("findAllExample");
        Example savedExample = exampleApi.save(example);

        List<Example> examples = exampleApi.findAll();

        Optional<Example> foundExample = examples.stream().filter(u -> savedExample.getId().equals(u.getId())).findAny();
        assertTrue(foundExample.isPresent());
    }
}

package com.RestApiForCalculator.testCalciModel;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;

import com.RestApiForCalculator.model.RequestResponseTimestampEntity;

public class RequestResponseTimestampEntityTest {
	@Test
    public void testGettersAndSetters() {
        RequestResponseTimestampEntity entity = new RequestResponseTimestampEntity();
        entity.setId(1L);
        entity.setRequest("request");
        entity.setResponse("response");
        entity.setTimestamp(new Date());

        assertEquals(1L, entity.getId().longValue());
        assertEquals("request", entity.getRequest());
        assertEquals("response", entity.getResponse());
    }
}

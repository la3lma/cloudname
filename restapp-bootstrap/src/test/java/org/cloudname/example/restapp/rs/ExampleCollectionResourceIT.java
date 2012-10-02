package org.cloudname.example.restapp.rs;

import static org.junit.Assert.*;

import org.junit.Test;

import javax.ws.rs.core.Response.Status;
import com.sun.jersey.api.client.ClientResponse;

/**
 * Example integration test of a REST resource.
 * <p>
 *  Its name ends with *IT so that Infinitest/Surefire don't run it all the time
 *  (because it is slow). It is executed by Failsafe or manually.
 * </p>
 * @author jholy
 */
public class ExampleCollectionResourceIT extends AbstractResourceTester {

    @Test
    public void get_should_return_http_ok_and_the_message() throws Exception {

        final ClientResponse response =
                resource().path("/").get(ClientResponse.class);

        assertHttpStatus(Status.OK, response);

        String responseBody = response.getEntity(String.class);
        // Note: getEntity returns null in subsequent calls

        assertEquals("There is not much to show, buddy", responseBody);
    }

}

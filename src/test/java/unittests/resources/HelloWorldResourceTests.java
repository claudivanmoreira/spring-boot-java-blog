package unittests.resources;

import br.edu.claudivan.springconectado.rest.HelloWorldResource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import java.util.AbstractMap.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class HelloWorldResourceTests {

    HelloWorldResource helloWorldResource = mock(HelloWorldResource.class);

    @Test
    @DisplayName("should get hello world message successfully")
    void testSayHello() throws Exception {

        ResponseEntity<SimpleEntry> expected = ResponseEntity.ok(new SimpleEntry("message", "Hello World claudivan!"));
        Mockito.when(helloWorldResource.sayHelloWorld("claudivan")).thenReturn(expected);

        SimpleEntry result = helloWorldResource.sayHelloWorld("claudivan").getBody();

        assertEquals(expected.getBody(), result);
    }

}

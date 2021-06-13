package unittests.respository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.exceptions.base.MockitoException;

class HelloWorldRepositoryTests {

    @Test
    @DisplayName("Verify that mockito cannot mock/spy final class")
    void testMockInteger() {
        MockitoException error = Assertions.assertThrows(
                MockitoException.class,
                () -> Mockito.mock(Integer.class),
                "Mensagem XPTO");
        Assertions.assertTrue(error.getMessage().contains("final class"));
    }

}

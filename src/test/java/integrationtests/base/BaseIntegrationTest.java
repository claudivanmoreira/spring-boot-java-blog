package integrationtests.base;

import br.edu.claudivan.springconectado.SpringConectadoApplication;
import br.edu.claudivan.springconectado.rest.HelloWorldResource;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import integrationtests.utils.TestUtils;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = {
                SpringConectadoApplication.class,
                HelloWorldResource.class
        }
)
@ActiveProfiles("integration")
public abstract class BaseIntegrationTest {

    @LocalServerPort
    private int serverPort;
    private String baseURI;

    @BeforeEach
    public void setUp() {
        baseURI = "http://localhost:"+serverPort;
    }

    public String getRequestPath(String resource) {
        return new StringBuilder(baseURI).append(resource).toString();
    }

    public String getExpectedResponse(String sampleName) {
        return TestUtils.apiResponse(sampleName);
    }

    public String getExpectedRequest(String sampleName) {
        return TestUtils.apiRequest(sampleName);
    }
}

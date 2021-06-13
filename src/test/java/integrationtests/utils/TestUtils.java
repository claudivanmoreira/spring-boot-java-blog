package integrationtests.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;

public class TestUtils {

    private static final String requestFilesDir = "requests";
    private static final String responseFilesDir = "responses";
    private static final ObjectMapper jsonMapper = new ObjectMapper();


    public static String apiResponse(String sampleName) {
        return readFile(responseFilesDir, sampleName);
    }

    public static String apiRequest(String sampleName) {
        return readFile(requestFilesDir, sampleName);
    }

    private static String readFile(String fileSubDir, String sampleName) {
        try {
            String fileWithExtension = new StringBuilder(sampleName).append(".json").toString();
            Path filePath = Paths.get("src","test","resources","samples", fileSubDir, fileWithExtension);
            return jsonMapper.readTree(new String(Files.readAllBytes(filePath))).toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
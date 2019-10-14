package utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class FileIoUtils {
    public static byte[] loadFileFromClasspath(String filePath) throws IOException, URISyntaxException {
        Path path = Paths.get(FileIoUtils.class.getClassLoader().getResource(filePath).toURI());
        return Files.readAllBytes(path);
    }

    public static boolean exists(String filePath) throws URISyntaxException {
        URL url = FileIoUtils.class.getClassLoader().getResource(filePath);

        return !Objects.isNull(url) && Files.exists(Paths.get(url.toURI()));
    }
}

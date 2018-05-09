
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LargeResponses {

    public static final int MAX_BYTES = 5000;
    public static final String FILE_PREFIX = "bytes_";
    public static final String WHITE_SPACE = " ";

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        LargeResponses largeResponses = new LargeResponses();
        largeResponses.parseFile("hosts_access_log_00.txt", MAX_BYTES);
    }

    public void parseFile(String logFileName, int maxResponseSize) {
        try (Stream<String> stream = Files.lines(Paths.get(getClass().getClassLoader()
                .getResource(logFileName).toURI()))) {

            int[] bytes = stream
                    .map(str -> str.substring(str.lastIndexOf(WHITE_SPACE) + 1))
                    .mapToInt(Integer::parseInt)
                    .filter(totalBytes -> totalBytes > maxResponseSize)
                    .toArray();

            writeToFile(logFileName, bytes);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToFile(String logFileName, int[] bytes) throws IOException {
        FileWriter writer = new FileWriter(FILE_PREFIX  + logFileName);
        writer.write(bytes.length + System.lineSeparator());
        writer.write(IntStream.of(bytes).sum() + System.lineSeparator());
        writer.close();
    }
}

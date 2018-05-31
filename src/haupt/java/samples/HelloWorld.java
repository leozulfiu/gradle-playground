package samples;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Objects;

public class HelloWorld {

    public static void main(String[] args) throws IOException {
        RandomCatFactGenerator generator = new RandomCatFactGenerator();
        String catFact = generator.generateCatFact();
        System.out.println("Cat Fact: " + catFact);

        ClassLoader classLoader = HelloWorld.class.getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource("dog-facts.txt")).getFile());

        String dogFact = new String(Files.readAllBytes(file.toPath()));
        System.out.println("Dog Fact: " + dogFact);
    }
}

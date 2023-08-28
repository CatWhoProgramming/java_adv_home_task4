package Task2;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
    public static void main(String[] args) throws IOException {
        String str = "For the time being, Java Guardians sees the situation as status quo. If after all this we see\n" +
                "no real activity or details after JavaOne, it will be very worrisome indeed,\n " +
                "Rahman said. An online petition has been posted by Java EE Guardians urging Oracle to move forward with EE or\n " +
                "turn the work over to others. As of Tuesday, the petition had more than 3,200 signatures.\n " +
                "Java EE Guardians has pondered developing enterprise-level Java improvements on its own.\n";
        File file = new File("file.txt");
        file.createNewFile();
        System.out.println(file.exists());
        writeInFile(str, file);
        findWord(file);

//        try (PrintWriter out = new PrintWriter(file, StandardCharsets.UTF_8))
//        {
//            out.print("Write from PrintWriter");
//            System.out.println("Successfully written data to the file");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try (FileWriter fw = new FileWriter(file);
//             BufferedWriter bf = new BufferedWriter(fw);
//             PrintWriter out = new PrintWriter(bf))
//        {
//            out.print("Write from file writer");
//            System.out.println("Successfully written data to the file");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

    private static void writeInFile(String str, File file) {
        try {
            byte[] bs = str.getBytes();
            Path writtenFilePath = Files.write(file.toPath(), bs);
            System.out.println("Written content in file:\n" + new String(Files.readAllBytes(writtenFilePath)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void findWord(File file) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get((file).toURI()));
        ArrayList<String> list = new ArrayList<>();
        Pattern pattern = Pattern.compile("Java");
        Matcher matcher;
        for (String s : lines) {
            matcher = pattern.matcher(s);
            while (matcher.find()) {
                s = matcher.replaceAll("HELLO");
            }
            list.add(Arrays.toString(s.split("\n")));
            System.out.println((s));
        }
        StringBuffer buffer = new StringBuffer();
        for (String str : list) {
            buffer.append(str).append("\n");
        }
        writeInFile(buffer.toString(), file);
    }
}
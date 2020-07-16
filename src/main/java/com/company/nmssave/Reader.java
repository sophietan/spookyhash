package com.company.nmssave;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Reader {
    private final Path filePath;

    public Reader(String filepath) {
        this.filePath = Path.of(filepath);
    }

    public void read(OutputStream out) throws IOException {
        try (InputStream in = Files.newInputStream(filePath, StandardOpenOption.READ)) {
            int b;
            while ((b = in.read()) != -1) {
                out.write(b << 1);
            }
        } finally {
            if (out != null)
                out.close();
        }
    }

    public static void main(String[] args) throws IOException {
	    if(args.length != 1) {
	        System.out.println("Usage: <filepath>");
	        System.exit(0);
        }

	    Reader reader = new Reader(args[0]);
	    reader.read(new FileOutputStream("test_copy.txt"));

    }
}

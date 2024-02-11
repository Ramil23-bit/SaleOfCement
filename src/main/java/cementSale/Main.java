package cementSale;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ParsingListString.parseListString(ReadFile.readingFilesWithCompanies());
    }
}

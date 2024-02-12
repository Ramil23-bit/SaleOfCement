package cementSale;

import java.io.IOException;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        ManagerCompany m = new ManagerCompany();
        m.orderProcessing(ParsingListString.parseListString(ReadFile.readingFilesWithCompanies()));
    }
}

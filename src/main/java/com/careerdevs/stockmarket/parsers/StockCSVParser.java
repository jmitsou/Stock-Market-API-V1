package com.careerdevs.stockmarket.parsers;

import com.careerdevs.stockmarket.models.CompCSV;
import com.opencsv.CSVReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StockCSVParser {

    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        System.out.println(readCSV());
    }
    public static List<CompCSV> readCSV() {
        try {
            //CSVReader reader = new CSVReader(new FileReader("src/Dataset_1.csv"), ',');
            CSVReader reader = new CSVReader(new FileReader("src/Dataset_2.csv"), ',');

            List<CompCSV> allCompanies = new ArrayList<CompCSV>();

            // read line by line
            String[] record = null;

            while ((record = reader.readNext()) != null) {
                //symbol,name,exchange,assetType,ipoDate,delistingDate,status
                CompCSV company = new CompCSV();
                company.setSymbol(record[0]);
                company.setName(record[1]);
                company.setExchange(record[2]);
                company.setAssetType(record[3]);
                company.setIpoDate(record[4]);
                company.setDelistingDate(record[5]);
                company.setStatus(record[6]);
                allCompanies.add(company);
            }

            reader.close();

            return allCompanies;
        } catch (FileNotFoundException e) {
            System.out.println("FILE NOT FOUND");
        } catch (IOException e) {
            System.out.println("ERROR READING DATA");
        }

        return null;
    }

}

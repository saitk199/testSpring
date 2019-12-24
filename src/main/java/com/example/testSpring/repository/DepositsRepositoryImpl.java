package com.example.testSpring.repository;

import com.example.testSpring.model.Deposit;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.opencsv.*;

public class DepositsRepositoryImpl implements DepositsRepository {
    @Override
    public List<Deposit> getAllDeposit() {
        File sourceFile = new File("DepositData.csv");
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy");

        List<Deposit> deposits = new ArrayList<>();
        List<List<String>> allElements;

        allElements = takeCSV(sourceFile);

        for (List<String> i : allElements) {
            Deposit deposit = new Deposit();
            deposit.setId(i.get(0));
            deposit.setId(i.get(0));
            deposit.setIdClient(i.get(1));
            deposit.setAmount(Double.parseDouble(i.get(2)));
            deposit.setPercent(Double.parseDouble(i.get(3)));
            deposit.setPretermPercent(Double.parseDouble(i.get(4)));
            deposit.setTermDays(Integer.parseInt(i.get(5)));
            String dateStr = i.get(6);
            Date dateFromStr = null;
            try {
                dateFromStr = format.parse(dateStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            deposit.setStartDate(dateFromStr);
            deposit.setWithPercentCapitalization(Boolean.parseBoolean(i.get(7)));
            deposits.add(deposit);
        }
        return deposits;
    }

    public List<List<String>> takeCSV(File sourceFile) {
        CSVParser parser = new CSVParserBuilder()
                .withSeparator(';')
                .withIgnoreQuotations(true)
                .build();
        List<List<String>> allElements = new ArrayList<>();
        try {
            CSVReader csvReader = new CSVReaderBuilder(new FileReader(sourceFile))
                    .withSkipLines(0)
                    .withCSVParser(parser)
                    .build();
            csvReader.readAll().forEach(it -> {
                allElements.add(Arrays.asList(it));
            });
            csvReader.close();
        } catch (IOException e) {
            System.out.println("Error");
        }
        return allElements;
    }
}

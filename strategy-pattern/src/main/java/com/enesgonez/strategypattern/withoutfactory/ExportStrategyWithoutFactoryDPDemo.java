package com.enesgonez.strategypattern.withoutfactory;

import com.enesgonez.strategypattern.exportstrategy.ExportStrategy;
import com.enesgonez.strategypattern.exportstrategy.impl.ExcelExport;
import com.enesgonez.strategypattern.exportstrategy.impl.WordExport;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExportStrategyWithoutFactoryDPDemo {


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Write your data : ");
        String data = reader.readLine();
        System.out.println("Write export type : ");
        String exportType = reader.readLine();

        ExportStrategy exportStrategy = null;
        if ("excel".equalsIgnoreCase(exportType)) {
            exportStrategy = new ExcelExport();
        } else if ("word".equalsIgnoreCase(exportType)) {
            exportStrategy = new WordExport();
        } else {
            System.out.println("unknown export type");
            return;
        }

        exportStrategy.export(data);

    }

}

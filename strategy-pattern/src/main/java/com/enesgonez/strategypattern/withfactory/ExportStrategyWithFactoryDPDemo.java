package com.enesgonez.strategypattern.withfactory;

import com.enesgonez.strategypattern.exportstrategy.ExportStrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExportStrategyWithFactoryDPDemo {


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Write your data : ");
        String data = reader.readLine();
        System.out.println("Write export type : ");
        String exportType = reader.readLine();
        ExportStrategyFactory exportStrategyFactory = new ExportStrategyFactory();
        ExportStrategy exportStrategy = exportStrategyFactory.getExportStrategy(exportType);
        exportStrategy.export(data);
    }

}

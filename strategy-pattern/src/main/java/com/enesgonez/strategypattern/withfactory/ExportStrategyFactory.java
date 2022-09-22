package com.enesgonez.strategypattern.withfactory;

import com.enesgonez.strategypattern.exportstrategy.ExportStrategy;
import com.enesgonez.strategypattern.exportstrategy.impl.ExcelExport;
import com.enesgonez.strategypattern.exportstrategy.impl.WordExport;

public class ExportStrategyFactory {

    public ExportStrategy getExportStrategy(String exportType) {
        if ("excel".equalsIgnoreCase(exportType)) {
            return new ExcelExport();
        } else if ("word".equalsIgnoreCase(exportType)) {
            return new WordExport();
        } else {
            throw new RuntimeException("unknown export type");
        }
    }

}

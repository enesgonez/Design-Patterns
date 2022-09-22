package com.enesgonez.strategypattern.exportstrategy.impl;

import com.enesgonez.strategypattern.exportstrategy.ExportStrategy;

public class ExcelExport implements ExportStrategy {

    @Override
    public void export(String data) {
        System.out.println(data + " exported to excel");
    }

}

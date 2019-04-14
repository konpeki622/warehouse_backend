package com.wanglei.service;

import com.wanglei.pojo.PrintHistory;

import java.util.List;

public interface PrintService {
    List<PrintHistory> getPrintHistoryList(Integer type, String[] keywords);
    boolean insertPrintHistory(PrintHistory printHistory);
}

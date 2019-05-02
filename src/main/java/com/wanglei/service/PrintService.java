package com.wanglei.service;

import com.wanglei.pojo.PrintHistory;

import java.util.List;

public interface PrintService {
    List<PrintHistory> getPrintHistoryList(String[] keywords, Integer page);
    Integer getCount(String[] keywords);
    boolean insertPrintHistory(PrintHistory printHistory);
}

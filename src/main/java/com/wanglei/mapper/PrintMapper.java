package com.wanglei.mapper;

import com.wanglei.pojo.PrintHistory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrintMapper {
    List<PrintHistory> getPrintHistoryList();
    void insertPrintHistory(PrintHistory printHistory);
}

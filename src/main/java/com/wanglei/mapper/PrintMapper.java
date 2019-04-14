package com.wanglei.mapper;

import com.wanglei.pojo.PrintHistory;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrintMapper {
    List<PrintHistory> getPrintHistoryList();
    List<PrintHistory> getPrintListByKeywords(@Param("keywords")String[] keywords);
    void insertPrintHistory(PrintHistory printHistory);
}

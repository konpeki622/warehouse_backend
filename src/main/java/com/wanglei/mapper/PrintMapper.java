package com.wanglei.mapper;

import com.wanglei.pojo.PrintHistory;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrintMapper {
    List<PrintHistory> getPrintHistoryList(@Param("keywords")String[] keywords, @Param("page") Integer page);
    Integer getCount(@Param("keywords")String[] keywords);
    void insertPrintHistory(PrintHistory printHistory);
}

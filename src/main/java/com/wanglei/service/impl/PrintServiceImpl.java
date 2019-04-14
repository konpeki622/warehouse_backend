package com.wanglei.service.impl;

import com.wanglei.mapper.PrintMapper;
import com.wanglei.pojo.PrintHistory;
import com.wanglei.service.PrintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrintServiceImpl implements PrintService {
    @Autowired
    PrintMapper printMapper;

    @Override
    public List<PrintHistory> getPrintHistoryList(Integer type, String[] keywords) {
        if (type == 0) {
            return printMapper.getPrintHistoryList();
        }
        else {
            return printMapper.getPrintListByKeywords(keywords);
        }
    }


    @Override
    public boolean insertPrintHistory(PrintHistory printHistory){
        printMapper.insertPrintHistory(printHistory);
        return true;
    }
}

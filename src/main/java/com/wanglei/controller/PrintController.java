package com.wanglei.controller;

import com.wanglei.pojo.PrintHistory;
import com.wanglei.pojo.ResponseMessage;
import com.wanglei.service.PrintService;
import com.wanglei.util.CheckToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public class PrintController {
    @Autowired
    private PrintService printService;

    @CheckToken
    @RequestMapping(value = {"/history/print"}, method = RequestMethod.GET)
    public ResponseMessage printController(){
        List<PrintHistory> materials = printService.getPrintHistoryList();
        return new ResponseMessage<>(materials).success();
    }

    @CheckToken
    @RequestMapping(value = {"/print/add"}, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity printAddController(@RequestBody PrintHistory printHistory){
        printService.insertPrintHistory(printHistory);
        return ResponseEntity.status(200).body(new ResponseMessage<>(null).success());
    }
}

package com.wanglei.controller;

import com.wanglei.pojo.PrintHistory;
import com.wanglei.pojo.ResponseMessage;
import com.wanglei.service.PrintService;
import com.wanglei.util.CheckToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PrintController {

    @Autowired
    private PrintService printService;

    @CheckToken
    @RequestMapping(value = {"/history/print"}, method = RequestMethod.GET)
    public ResponseMessage printController(@RequestParam(value = "type", defaultValue = "0") Integer type, @RequestParam(value = "keywords",required = false) String[] keywords){
        List<PrintHistory> materials = printService.getPrintHistoryList(type, keywords);
        return new ResponseMessage<>(materials).success();
    }

    @CheckToken
    @RequestMapping(value = {"/print/add"}, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity printAddController(@RequestBody PrintHistory printHistory){
        if(printService.insertPrintHistory(printHistory)){
            return ResponseEntity.status(200).body(new ResponseMessage<>(null).success());
        }
        return ResponseEntity.status(202).body(new ResponseMessage<>(null).error(202,"failed to update goods!"));
    }
}

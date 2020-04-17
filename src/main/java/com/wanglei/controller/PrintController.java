package com.wanglei.controller;

import com.wanglei.pojo.PrintHistory;
import com.wanglei.pojo.ResponseMessage;
import com.wanglei.service.PrintService;
import com.wanglei.util.CheckToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.Map;

@RestController
public class PrintController {

    @Autowired
    private PrintService printService;

    @CheckToken
    @RequestMapping(value = {"/history/print"}, method = RequestMethod.GET)
    public ResponseMessage printController(@RequestParam(value = "keywords",required = false) String[] keywords, @RequestParam(value = "page") Integer page){
        List<PrintHistory> print = printService.getPrintHistoryList(keywords, page);
        Integer count = printService.getCount(keywords);
        return new ResponseMessage<>(print, count).success();
    }

    @RequestMapping(value = {"/print/add"}, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity printAddController(@RequestBody PrintHistory printHistory){
        if(printService.insertPrintHistory(printHistory)){
            return ResponseEntity.status(200).body(new ResponseMessage<>(null, 0).success());
        }
        return ResponseEntity.status(202).body(new ResponseMessage<>(null, 0).error(202,"failed to update goods!"));
    }

//    @RequestMapping(value = "/download", method = RequestMethod.GET)
//    public String download(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        String fileName="excel文件";
//        //填充projects数据
//        ExcelUtil excelUtil = new ExcelUtil();
//        List<Project> projects = excelUtil.createData();
//        List<Map<String,Object>> list = excelUtil.createExcelRecord(projects);
//        String columnNames[]={"ID","项目名","销售人","负责人","所用技术","备注"};//列名
//        String keys[]   =    {"id","name","saler","principal","technology","remarks"};//map中的key
//        ByteArrayOutputStream os = new ByteArrayOutputStream();
//        try {
//            ExcelUtil.createWorkBook(list,keys,columnNames).write(os);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        byte[] content = os.toByteArray();
//        InputStream is = new ByteArrayInputStream(content);
//        // 设置response参数，可以打开下载页面
//        response.reset();
//        response.setContentType("application/vnd.ms-excel;charset=utf-8");
//        response.setHeader("Content-Disposition", "attachment;filename="+ new String((fileName + ".xls").getBytes(), "utf-8"));
//        ServletOutputStream out = response.getOutputStream();
//        BufferedInputStream bis = null;
//        BufferedOutputStream bos = null;
//        try {
//            bis = new BufferedInputStream(is);
//            bos = new BufferedOutputStream(out);
//            byte[] buff = new byte[2048];
//            int bytesRead;
//            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
//                bos.write(buff, 0, bytesRead);
//            }
//            bos.flush();
//        } catch (final IOException e) {
//            throw e;
//        } finally {
//            if (bis != null)
//                bis.close();
//            if (bos != null)
//                bos.close();
//        }
//        return null;
//    }
}

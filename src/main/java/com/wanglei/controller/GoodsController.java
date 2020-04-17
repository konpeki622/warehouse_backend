package com.wanglei.controller;

import com.wanglei.pojo.*;
import com.wanglei.service.GoodsService;
import com.wanglei.util.CheckToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @CheckToken
    @RequestMapping(value = {"/goods"}, method = RequestMethod.GET)
    public ResponseMessage goodsController(@RequestParam(value = "type", defaultValue = "0") Integer type, @RequestParam(value = "keywords",required = false) String[] keywords, @RequestParam(value = "page") Integer page){
        List<Goods> goodsList = goodsService.getGoodsList(type, keywords, page);
        Integer count = goodsService.getGoodsCount(type, keywords);
        return new ResponseMessage<>(goodsList, count).success();
    }

    @CheckToken
    @RequestMapping(value = {"/goods/query"}, method = RequestMethod.GET)
    public ResponseMessage goodsQueryController(@RequestParam(value = "goodsId") Integer goodsId){
        List<ShelveInfo> goodsList = goodsService.queryGoodsShelve(goodsId);
        return new ResponseMessage<>(goodsList, 0).success();
    }

    @CheckToken
    @RequestMapping(value = {"/goods/delete"}, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity goodsDeleteController(@RequestParam(value = "goods_id", defaultValue = "0") Integer goodsId){
        if(goodsService.deleteGoods(goodsId)){
            return ResponseEntity.status(200).body(new ResponseMessage<>(null, 0).success());
        }
        return ResponseEntity.status(202).body(new ResponseMessage<>(null, 0).error(202,"failed to delete goods!"));
    }

    @CheckToken
    @RequestMapping(value = {"/account"}, method = RequestMethod.GET)
    public ResponseMessage getAccountController(@RequestParam(value = "goodsId", defaultValue = "0") Integer goodsId, @RequestParam(value = "keywords",required = false) String[] keywords, @RequestParam(value = "page") Integer page){
        List<Goods> goodsList = goodsService.getAccountList(goodsId, keywords, page);
        Integer count = goodsService.getAccountCount(goodsId, keywords);
        return new ResponseMessage<>(goodsList, count).success();
    }

    @CheckToken
    @RequestMapping(value = {"/account/table"}, method = RequestMethod.GET)
    public ResponseMessage getAccountTableController(@RequestParam(value = "type", defaultValue = "0") Integer type, @RequestParam(value = "goodsId", defaultValue = "0") Integer goodsId, @RequestParam(value = "condition", defaultValue = "0") Integer condition, @RequestParam(value = "page") Integer page){
        List<Goods> goodsList = goodsService.getAccountByDate(type, goodsId, condition, page);
        Integer count = goodsService.getAccountCountByDate(type, goodsId, condition);
        return new ResponseMessage<>(goodsList, count).success();
    }

    @CheckToken
    @RequestMapping(value = {"/account/graph"}, method = RequestMethod.GET)
    public ResponseMessage getAccountGraphController(@RequestParam(value = "type") Integer type, @RequestParam(value = "goodsId", defaultValue = "0") Integer goodsId, @RequestParam(value = "condition") Integer condition){
        List<GoodsSum> goodsList = goodsService.getGoodsGraph(type, goodsId, condition);
        return new ResponseMessage<>(goodsList, 2).success();
    }

    @CheckToken
    @RequestMapping(value = {"/store"}, method = RequestMethod.GET)
    public ResponseMessage getStoreController(@RequestParam(value = "goodsId", defaultValue = "0") Integer goodsId, @RequestParam(value = "page") Integer page){
        List<Goods> goodsList = goodsService.getStoreList(goodsId, page);
        Integer count = goodsService.getStoreCount(goodsId);
        return new ResponseMessage<>(goodsList, count).success();
    }

    @CheckToken
    @RequestMapping(value = {"/deliver"}, method = RequestMethod.GET)
    public ResponseMessage getDeliverController(@RequestParam(value = "goodsId", defaultValue = "0") Integer goodsId, @RequestParam(value = "page") Integer page){
        List<Goods> goodsList = goodsService.getDeliverList(goodsId, page);
        Integer count = goodsService.getDeliverCount(goodsId);
        return new ResponseMessage<>(goodsList, count).success();
    }

    @CheckToken
    @RequestMapping(value = {"/goodsSum/material"}, method = RequestMethod.GET)
    public ResponseMessage getGoodsSumByMaterialController(@RequestParam(value = "type", defaultValue = "0") Integer type){
        List<GoodsSum> goodsList = goodsService.getGoodsSumByMaterial(type);
        return new ResponseMessage<>(goodsList, goodsList.size()).success();
    }

    @CheckToken
    @RequestMapping(value = {"/goodsSum/area"}, method = RequestMethod.GET)
    public ResponseMessage getGoodsSumByAreaController(@RequestParam(value = "type", defaultValue = "0") Integer type){
        List<GoodsSum> goodsList = goodsService.getGoodsSumByArea(type);
        return new ResponseMessage<>(goodsList, goodsList.size()).success();
    }

    @CheckToken
    @RequestMapping(value = {"/goodsSum/sell"}, method = RequestMethod.GET)
    public ResponseMessage getGoodsSellSumController(@RequestParam(value = "type", defaultValue = "0") Integer type, @RequestParam(value = "id") Integer id){
        List<GoodsSum> goodsList = goodsService.getGoodsSellSum(type, id);
        return new ResponseMessage<>(goodsList, goodsList.size()).success();
    }

    @RequestMapping(value = {"/goods/update"}, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity goodsUpdateController(@RequestParam(value = "material_id", defaultValue = "0")Integer materialId,
                                                @RequestParam(value = "area_id", defaultValue = "0")Integer areaId,
                                                @RequestParam(value = "goods_id", defaultValue = "0")Integer goodsId,
                                                @RequestParam(value = "update_date", required = false)String updateDate,
                                                @RequestParam(value = "deliver_owner", required = false)String deliverOwner,
                                                @RequestParam(value = "update_size", required = false)Float updateSize,
                                                @RequestParam(value = "behavior", required = false)Integer behavior,
                                                @RequestParam(value = "username", required = false)String username,
                                                @RequestParam(value = "place", required = false)Integer place){
        if(goodsService.updateGoods(materialId, areaId, goodsId, updateDate, deliverOwner, updateSize, behavior, username, place)){
            return ResponseEntity.status(200).body(new ResponseMessage<>(null, 0).success());
        }
        return ResponseEntity.status(202).body(new ResponseMessage<>(null, 0).error(202,"failed to update goods!"));
    }

    @RequestMapping(value = {"/goods/place"}, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity goodsPlaceController(
                                                @RequestParam(value = "goods_id", defaultValue = "0")Integer goodsId,
                                                @RequestParam(value = "update_size", required = false)Float updateSize,
                                                @RequestParam(value = "behavior", required = false)Integer behavior,
                                                @RequestParam(value = "place", required = false)Integer place){
        if(goodsService.updateGoodsShelve(goodsId, updateSize, behavior, place)){
            return ResponseEntity.status(200).body(new ResponseMessage<>(null, 0).success());
        }
        return ResponseEntity.status(202).body(new ResponseMessage<>(null, 0).error(202,"failed to update goods!"));
    }

    @RequestMapping(value = {"/goods/alter"}, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity goodsAlterController(@RequestParam("goodsId")Integer goodsId, @RequestParam(value = "update_date")String updateDate){
        if(goodsService.alterGoodsSize(goodsId, updateDate)){
            return ResponseEntity.status(200).body(new ResponseMessage<>(null, 0).success());
        }
        return ResponseEntity.status(202).body(new ResponseMessage<>(null, 0).error(202,"failed to alter size!"));
    }

    @RequestMapping(value = {"/shelve/get"}, method = RequestMethod.GET)
    public ResponseMessage getShelveInfoController(@RequestParam(value = "floor", defaultValue = "0") Integer floor){
        List<ShelveInfo> shelveList = goodsService.getShelveInfo(floor);
        return new ResponseMessage<>(shelveList, null).success();
    }

    @RequestMapping(value = {"/shelve/recommend"}, method = RequestMethod.GET)
    public ResponseMessage getShelveRecommendController(){
        List<ShelveInfo> shelveList = goodsService.getShelveRecommend();
        return new ResponseMessage<>(shelveList, null).success();
    }

    @RequestMapping(value = {"/shelve/init"}, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity initShelveInfoController(@RequestParam(value = "rowNum") Integer rowNum, @RequestParam(value = "colNum") Integer colNum, @RequestParam(value = "floorNum") Integer floorNum, @RequestParam(value = "capacity") Integer capacity){
        if(goodsService.initShelveInfo(rowNum, colNum, floorNum, capacity)){
            return ResponseEntity.status(200).body(new ResponseMessage<>(null,0).success());
        }
        return ResponseEntity.status(202).body(new ResponseMessage<>(null,0).error(202,"failed to init!"));
    }

    @CheckToken
    @RequestMapping(value = {"/shelve/insert"}, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity addShelveInfoController(@RequestParam(value = "rowNo") Integer rowNo, @RequestParam(value = "colNum") Integer colNum, @RequestParam(value = "floorNum") Integer floorNum, @RequestParam(value = "capacity") Integer capacity){
        if(goodsService.insertShelveInfo(rowNo, colNum, floorNum, capacity)){
            return ResponseEntity.status(200).body(new ResponseMessage<>(null,0).success());
        }
        return ResponseEntity.status(202).body(new ResponseMessage<>(null,0).error(202,"failed to add!"));
    }

    @CheckToken
    @RequestMapping(value = {"/shelve/query"}, method = RequestMethod.GET)
    public ResponseMessage shelveQueryController(@RequestParam(value = "place") Integer place){
        List<ShelveInfo> goodsList = goodsService.queryShelveGoods(place);
        return new ResponseMessage<>(goodsList, 0).success();
    }

}

package com.wanglei.controller;

import com.wanglei.pojo.AddGoods;
import com.wanglei.pojo.Goods;
import com.wanglei.pojo.ResponseMessage;
import com.wanglei.service.GoodsService;
import com.wanglei.util.CheckToken;
import org.apache.ibatis.jdbc.Null;
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
    public ResponseMessage goodsController(@RequestParam(value = "type", defaultValue = "0") Integer type, @RequestParam(value = "keywords",required = false) String[] keywords){
        List<Goods> goodsList = goodsService.getGoodsList(type, keywords);
        return new ResponseMessage<>(goodsList).success();
    }

    @CheckToken
    @RequestMapping(value = {"/goods/delete"}, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity goodsDeleteController(@RequestParam(value = "goods_id", defaultValue = "0") Integer goodsId){
        if(goodsService.deleteGoods(goodsId)){
            return ResponseEntity.status(200).body(new ResponseMessage<>(null).success());
        }
        return ResponseEntity.status(202).body(new ResponseMessage<>(null).error(202,"failed to delete goods!"));
    }

    @CheckToken
    @RequestMapping(value = {"/account"}, method = RequestMethod.GET)
    public ResponseMessage getAccountController(@RequestParam(value = "type", defaultValue = "0") Integer type, @RequestParam(value = "goodsId",required = false) Integer goodsId, @RequestParam(value = "keywords",required = false) String[] keywords){
        List<Goods> goodsList = goodsService.getAccountList(type, goodsId, keywords);
        return new ResponseMessage<>(goodsList).success();
    }

    @CheckToken
    @RequestMapping(value = {"/account/graph"}, method = RequestMethod.GET)
    public ResponseMessage getAccountGraphController(@RequestParam(value = "type", defaultValue = "0") Integer type, @RequestParam(value = "goodsId", defaultValue = "0") Integer goodsId, @RequestParam(value = "condition",required = false) Integer condition){
        List<Goods> goodsList = goodsService.getAccountByDate(type, goodsId, condition);
        return new ResponseMessage<>(goodsList).success();
    }

    @CheckToken
    @RequestMapping(value = {"/store"}, method = RequestMethod.GET)
    public ResponseMessage getStoreController(@RequestParam(value = "type", defaultValue = "0") Integer type, @RequestParam(value = "goodsId",required = false) Integer goodsId){
        List<Goods> goodsList = goodsService.getStoreList(type, goodsId);
        return new ResponseMessage<>(goodsList).success();
    }

    @CheckToken
    @RequestMapping(value = {"/deliver"}, method = RequestMethod.GET)
    public ResponseMessage getDeliverController(@RequestParam(value = "type", defaultValue = "0") Integer type, @RequestParam(value = "goodsId",required = false) Integer goodsId){
        List<Goods> goodsList = goodsService.getDeliverList(type, goodsId);
        return new ResponseMessage<>(goodsList).success();
    }

    @RequestMapping(value = {"/goods/update"}, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity goodsUpdateController(@RequestParam(value = "material_id", defaultValue = "0")Integer materialId,
                                                @RequestParam(value = "area_id", defaultValue = "0")Integer areaId,
                                                @RequestParam(value = "goods_id", defaultValue = "0")Integer goodsId,
                                                @RequestParam(value = "update_date")String updateDate,
                                                @RequestParam(value = "deliver_owner", required = false)String deliverOwner,
                                                @RequestParam(value = "update_size")Integer updateSize,
                                                @RequestParam(value = "behavior")Integer behavior,
                                                @RequestParam(value = "username")String username){
        if(goodsService.updateGoods(materialId, areaId, goodsId, updateDate, deliverOwner, updateSize, behavior, username)){
            return ResponseEntity.status(200).body(new ResponseMessage<>(null).success());
        }
        return ResponseEntity.status(202).body(new ResponseMessage<>(null).error(202,"failed to update goods!"));
    }
}
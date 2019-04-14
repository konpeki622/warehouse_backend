package com.wanglei.service;

import com.wanglei.pojo.AddGoods;
import com.wanglei.pojo.Goods;

import java.util.List;

public interface GoodsService {
    List<Goods> getGoodsList(Integer type, String[] keywords);
    List<Goods> getAccountList(Integer type, Integer goodsId, String[] keywords);
    List<Goods> getStoreList(Integer type, Integer goodsId);
    List<Goods> getDeliverList(Integer type, Integer goodsId);
    List<Goods> getAccountByDate(Integer type, Integer goodsId, Integer condition);
    boolean updateGoods(Integer materialId, Integer areaId, Integer goodsId, String updateDate, String deliverOwner, Integer updateSize, Integer behavior, String username);
    boolean deleteGoods(Integer goodsId);
}
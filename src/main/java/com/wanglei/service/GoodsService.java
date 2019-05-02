package com.wanglei.service;

import com.wanglei.pojo.Goods;
import com.wanglei.pojo.GoodsSum;

import java.util.List;

public interface GoodsService {
    List<Goods> getGoodsList(Integer type, String[] keywords, Integer page);
    List<Goods> getAccountList(Integer goodsId, String[] keywords, Integer page);
    List<Goods> getStoreList(Integer goodsId, Integer page);
    List<Goods> getDeliverList(Integer goodsId, Integer page);
    List<Goods> getAccountByDate(Integer type, Integer goodsId, Integer condition, Integer page);

    Integer getGoodsCount(Integer type, String[] keywords);
    Integer getAccountCount(Integer goodsId, String[] keywords);
    Integer getStoreCount(Integer goodsId);
    Integer getDeliverCount(Integer goodsId);
    Integer getAccountCountByDate(Integer type, Integer goodsId, Integer condition);

    List<GoodsSum> getGoodsSumByArea(Integer type);
    List<GoodsSum> getGoodsSumByMaterial(Integer type);
    List<GoodsSum> getGoodsSellSum(Integer type, Integer id);

    boolean updateGoods(Integer materialId, Integer areaId, Integer goodsId, String updateDate, String deliverOwner, Float updateSize, Integer behavior, String username);
    boolean alterGoodsSize(Integer type, Float updateSize, Integer goodsId);
    boolean deleteGoods(Integer goodsId);
}

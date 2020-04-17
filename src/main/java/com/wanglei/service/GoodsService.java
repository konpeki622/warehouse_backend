package com.wanglei.service;

import com.wanglei.pojo.Goods;
import com.wanglei.pojo.GoodsSum;
import com.wanglei.pojo.Inventory;
import com.wanglei.pojo.ShelveInfo;

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

    List<GoodsSum> getGoodsGraph(Integer type, Integer goodsId, Integer condition);

    List<GoodsSum> getGoodsSumByArea(Integer type);
    List<GoodsSum> getGoodsSumByMaterial(Integer type);
    List<GoodsSum> getGoodsSellSum(Integer type, Integer id);

    List<ShelveInfo> queryGoodsShelve(Integer goodsId);
    List<ShelveInfo> queryShelveGoods(Integer place);

    boolean updateGoods(Integer materialId, Integer areaId, Integer goodsId, String updateDate, String deliverOwner, Float updateSize, Integer behavior, String username, Integer place);
    boolean updateGoodsShelve(Integer goodsId, Float updateSize, Integer behavior, Integer place);
    boolean alterGoodsSize(Integer goodsId, String updateDate);
    boolean deleteGoods(Integer goodsId);

    List<ShelveInfo> getShelveInfo(Integer floor);
    List<ShelveInfo> getShelveRecommend();
    boolean initShelveInfo(Integer rowNum, Integer colNum, Integer floorNum, Integer capacity);
    boolean insertShelveInfo(Integer rowNo, Integer colNum, Integer floorNum, Integer capacity);
}

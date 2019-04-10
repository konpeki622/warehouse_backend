package com.wanglei.service.impl;

import com.wanglei.mapper.GoodsMapper;
import com.wanglei.pojo.AddGoods;
import com.wanglei.pojo.Goods;
import com.wanglei.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> getGoodsList(Integer type, String[] keywords){
        switch (type) {
            case 1: // 按全部查找
                return goodsMapper.getGoodsByKeywords(keywords);
            case 2: // 按材料查找
                return goodsMapper.getGoodsByMaterial(keywords);
            case 3: // 按产地查找
                return goodsMapper.getGoodsByArea(keywords);
                default: return goodsMapper.getGoodsAll();
        }
    }

    @Override
    public List<Goods> getAccountList(Integer type, Integer goodsId) {
        if (type == 1) {
            return goodsMapper.getAccountByGoods(goodsId);
        }
        else {
            return goodsMapper.getAccountAll();
        }
    }

    @Override
    public List<Goods> getStoreList(Integer type, Integer goodsId) {
        if (type == 1) {
            return goodsMapper.getStoreByGoods(goodsId);
        }
        else {
            return goodsMapper.getStoreAll();
        }
    }

    @Override
    public List<Goods> getDeliverList(Integer type, Integer goodsId) {
        if (type == 1) {
            return goodsMapper.getDeliverByGoods(goodsId);
        }
        else {
            return goodsMapper.getDeliverAll();
        }
    }

    @Override
    public boolean updateGoods(Integer goodsId, AddGoods goods) {
        try {
            if (goodsId == 0) {
                if (goodsMapper.getId(goods.getMaterialId(), goods.getAreaId()) == -1) {
                    goodsMapper.insertGoods(goods);
                    goods.setGoodsId(goodsMapper.getId(goods.getMaterialId(), goods.getAreaId()));
                }
            }
            goodsMapper.insertAccount(goods);
            goodsMapper.updateAccount(goods);
            return true;
        }
        catch (Error e) {
            return false;
        }
    }

    @Override
    public List<Goods> getAccountByDate(Integer type, Integer goodsId, Integer condition) {
        switch (type) {
            case 0: return goodsMapper.getAccountToday(goodsId);
            case 1: return goodsMapper.getAccountYesterday(goodsId);
            case 2: return goodsMapper.getAccountThisWeek(goodsId);
            case 3: return goodsMapper.getAccountByMonth(goodsId, condition);
            case 4: return goodsMapper.getAccountBySeason(goodsId, condition);
            case 5: return goodsMapper.getAccountByYear(goodsId, condition);
            default: return null;
        }
    }
}

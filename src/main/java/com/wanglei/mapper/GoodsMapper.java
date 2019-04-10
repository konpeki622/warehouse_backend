package com.wanglei.mapper;

import com.wanglei.pojo.AddGoods;
import com.wanglei.pojo.Goods;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface GoodsMapper {
    List<Goods> getGoodsAll();
    List<Goods> getAccountAll();
    List<Goods> getStoreAll();
    List<Goods> getDeliverAll();
    List<Goods> getGoodsByKeywords(@Param("keywords") String[] keywords);
    List<Goods> getGoodsByMaterial(@Param("keywords") String[] keywords);
    // TODO: 根据日期筛选
    List<Goods> getAccountToday(@Param("goods_id")Integer goodsId);
    List<Goods> getAccountYesterday(@Param("goods_id")Integer goodsId);
    List<Goods> getAccountThisWeek(@Param("goods_id")Integer goodsId);
    List<Goods> getAccountByMonth(@Param("goods_id")Integer goodsId, @Param("month")Integer month);
    List<Goods> getAccountBySeason(@Param("goods_id")Integer goodsId, @Param("season")Integer season);
    List<Goods> getAccountByYear(@Param("goods_id")Integer goodsId, @Param("year")Integer year);

    List<Goods> getGoodsByArea(@Param("keywords") String[] keywords);
    List<Goods> getAccountByGoods(Integer goodsId);
    List<Goods> getStoreByGoods(Integer goodsId);
    List<Goods> getDeliverByGoods(Integer goodsId);
    int getId(@Param("material_id")Integer materialId, @Param("area_id")Integer areaId);
    void insertGoods(AddGoods goods);
    void insertAccount(AddGoods goods);
    void updateAccount(AddGoods goods);
}

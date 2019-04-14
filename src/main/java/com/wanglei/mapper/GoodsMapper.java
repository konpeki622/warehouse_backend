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

    List<Goods> getAccountByKeywords(@Param("keywords") String[] keywords);

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
    Integer isExist(@Param("material_id")Integer materialId, @Param("area_id")Integer areaId);
    Integer getId(@Param("material_id")Integer materialId, @Param("area_id")Integer areaId);
    void insertGoods(@Param("material_id")Integer materialId, @Param("area_id")Integer areaId, @Param("update_size")Integer updateSize);
    void deleteGoods(Integer goodsId);
    void insertAccount(@Param("goods_id")Integer goodsId, @Param("update_date")String updateDate, @Param("deliver_owner")String deliverOwner, @Param("update_size")Integer updateSize, @Param("behavior")Integer behavior, @Param("username")String username);
    void updateAccount(@Param("behavior")Integer behavior, @Param("update_size")Integer updateSize, @Param("goods_id")Integer goodsId);
}

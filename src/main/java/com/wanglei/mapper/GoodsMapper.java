package com.wanglei.mapper;

import com.wanglei.pojo.Goods;
import com.wanglei.pojo.GoodsSum;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsMapper {
    List<Goods> getGoodsAll(@Param("page") Integer page);
    Integer getGoodsCount();
    List<Goods> getAccountAll(@Param("goodsId") Integer goodsId, @Param("keywords") String[] keywords, @Param("page") Integer page);
    Integer getAccountCount(@Param("goodsId") Integer goodsId, @Param("keywords") String[] keywords);
    List<Goods> getStoreAll(@Param("goodsId") Integer goodsId, @Param("page") Integer page);
    Integer getStoreCount(@Param("goodsId") Integer goodsId);
    List<Goods> getDeliverAll(@Param("goodsId") Integer goodsId, @Param("page") Integer page);
    Integer getDeliverCount(@Param("goodsId") Integer goodsId);

    List<Goods> getGoodsByKeywords(@Param("keywords") String[] keywords, @Param("page") Integer page);
    Integer getGoodsCountByKeywords(@Param("keywords") String[] keywords);
    List<Goods> getGoodsByMaterial(@Param("keywords") String[] keywords, @Param("page") Integer page);
    Integer getGoodsCountByMaterial(@Param("keywords") String[] keywords);
    List<Goods> getGoodsByArea(@Param("keywords") String[] keywords, @Param("page") Integer page);
    Integer getGoodsCountByArea(@Param("keywords") String[] keywords);

    List<Goods> getAccountToday(@Param("goodsId")Integer goodsId, @Param("page") Integer page);
    Integer getAccountCountToday(@Param("goodsId")Integer goodsId);
    List<Goods> getAccountYesterday(@Param("goodsId")Integer goodsId, @Param("page") Integer page);
    Integer getAccountCountYesterday(@Param("goodsId")Integer goodsId);
    List<Goods> getAccountThisWeek(@Param("goodsId")Integer goodsId, @Param("page") Integer page);
    Integer getAccountCountThisWeek(@Param("goodsId")Integer goodsId);
    List<Goods> getAccountByMonth(@Param("goodsId")Integer goodsId, @Param("month")Integer month, @Param("page") Integer page);
    Integer getAccountCountByMonth(@Param("goodsId")Integer goodsId, @Param("month")Integer month);
    List<Goods> getAccountBySeason(@Param("goodsId")Integer goodsId, @Param("year")Integer year, @Param("season")Integer season, @Param("page") Integer page);
    Integer getAccountCountBySeason(@Param("goodsId")Integer goodsId, @Param("year")Integer year, @Param("season")Integer season);
    List<Goods> getAccountByYear(@Param("goodsId")Integer goodsId, @Param("year")Integer year, @Param("page") Integer page);
    Integer getAccountCountByYear(@Param("goodsId")Integer goodsId, @Param("year")Integer year);

    List<GoodsSum> getGraphByDate(@Param("goodsId")Integer goodsId, @Param("day")Integer day);
    List<GoodsSum> getGraphByYear(@Param("goodsId")Integer goodsId, @Param("month")Integer month);

    List<GoodsSum> getStoreSumByArea();
    List<GoodsSum> getStoreSumByMaterial();
    List<GoodsSum> getDeliverSumByArea();
    List<GoodsSum> getDeliverSumByMaterial();
    List<GoodsSum> getCurrentSumByMaterial();
    List<GoodsSum> getCurrentSumByArea();
    List<GoodsSum> getSellSumByMaterial(@Param("materialId")Integer materialId);
    List<GoodsSum> getSellSumByArea(@Param("areaId")Integer areaId);

    Integer isExist(@Param("material_id")Integer materialId, @Param("area_id")Integer areaId);
    Integer getId(@Param("material_id")Integer materialId, @Param("area_id")Integer areaId);
    void insertGoods(@Param("material_id")Integer materialId, @Param("area_id")Integer areaId, @Param("update_size")Float updateSize, @Param("update_date")String updateDate);
    void deleteGoods(Integer goodsId);
    void alterGoods(@Param("goodsId")Integer goodsId, @Param("update_date")String updateDate);
    void insertAccount(@Param("goodsId")Integer goodsId, @Param("update_date")String updateDate, @Param("deliver_owner")String deliverOwner, @Param("update_size")Float updateSize, @Param("behavior")Integer behavior, @Param("username")String username);
    void updateAccount(@Param("behavior")Integer behavior, @Param("update_size")Float updateSize, @Param("update_date")String updateDate, @Param("goodsId")Integer goodsId);
}

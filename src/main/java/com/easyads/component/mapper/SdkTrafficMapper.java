package com.easyads.component.mapper;

import com.easyads.management.distribution.strategy.model.group.SdkGroupStrategy;
import com.easyads.management.distribution.strategy.model.percentage.SdkPercentageStrategy;
import com.easyads.management.distribution.traffic.model.SdkTrafficSingle;
import com.easyads.management.distribution.traffic.model.SdkTraffic;
import com.easyads.management.distribution.traffic.model.SdkTrafficGroupSimple;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public interface SdkTrafficMapper {
    // 流量分发页面相关操作数据库查询
    // 获取广告位上的SDK分发
    List<SdkTraffic> getOneAdspotSdkTrafficDetail(Integer adspotId, Integer percentageId);
    // 获取广告位上的SDK分发的简易信息
    SdkTrafficGroupSimple getOneAdspotOneSdkTrafficSimple(Long adspotId, Long sdkTrafficId);
    // 更新流量分发组的分发信息
    int updateTrafficGroup(Long sdkTrafficId, String supplierIds);
    // 更新广告位上的SDK分发
    int updateOneAdspotAllTraffic(List<SdkTrafficGroupSimple> sdkTrafficList);
    // 获取广告位上的SDK分发的简易信息
    List<SdkTrafficGroupSimple> getOneAdspotSdkTrafficSimple(Long adspotId, Integer sdkChannelId);

    // 因为流量分组的改动更新流量分发信息
    int createPercentageTraffic(Integer adspotId, List<SdkPercentageStrategy> trafficPercentageList,
                                List<SdkGroupStrategy> sdkGroupStrategyList);
    int deletePercentageTraffic(Set<Integer> percentageIdList);

    // 因为分发策略的改动更新流量分发信息
    int createOnePercentageGroupStrategyTraffic(SdkTrafficSingle sdkTraffic);

    int createGroupStrategyTraffic(Integer adspotId, Integer percentageId,
                                   List<SdkGroupStrategy> sdkGroupStrategyList);
    int createGroupStrategyTrafficWithSupplier(Integer adspotId, Integer percentageId,
                                               List<SdkGroupStrategy> sdkGroupStrategyList,
                                               List<String> supplierTraffic);
    int deleteGroupStrategyTraffic(Set<Long> groupTargetIdList);
}

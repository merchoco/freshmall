package com.kxmall.market.admin.api.api.goods;

import com.kxmall.market.core.annotation.HttpMethod;
import com.kxmall.market.core.annotation.HttpOpenApi;
import com.kxmall.market.core.annotation.HttpParam;
import com.kxmall.market.core.annotation.HttpParamType;
import com.kxmall.market.core.annotation.param.NotNull;
import com.kxmall.market.core.annotation.param.Range;
import com.kxmall.market.core.exception.ServiceException;
import com.kxmall.market.data.dto.goods.GroupShopDTO;
import com.kxmall.market.data.model.Page;

import java.util.List;

@HttpOpenApi(group = "admin.groupShop", description = "管理团购商品服务")
public interface AdminGroupShopGoodsService {

    @HttpMethod(description = "增加", permission = "operation:groupShop:addGroupShopSpu", permissionParentName = "商品管理", permissionName = "团购商品管理")
    public String addGroupShopSpu(
            @NotNull @HttpParam(name = "adminId", type = HttpParamType.ADMIN_ID, description = "管理员Id") Long adminId,
            @NotNull @HttpParam(name = "spuId", type = HttpParamType.COMMON, description = "spuId") Long spuId,
            @NotNull @HttpParam(name = "gmtStart", type = HttpParamType.COMMON, description = "团购开始时间戳") Long gmtStart,
            @NotNull @HttpParam(name = "gmtEnd", type = HttpParamType.COMMON, description = "团购结束时间戳") Long gmtEnd,
            @NotNull @Range(min = 1) @HttpParam(name = "minimumNumber", type = HttpParamType.COMMON, description = "团购最低人数") Integer minimumNumber,
            @NotNull @HttpParam(name = "automaticRefund", type = HttpParamType.COMMON, description = "团购人数未满是否自动退款")  Integer automaticRefund,
            @NotNull @HttpParam(name = "groupShopSkuList", type = HttpParamType.COMMON, description = "团购sku链表") List groupShopSkuList) throws ServiceException;

    @HttpMethod(description = "删除", permission = "operation:groupShop:deleteGroupShopSpu", permissionParentName = "商品管理", permissionName = "团购商品管理")
    public String deleteGroupShopSpu(
            @NotNull @HttpParam(name = "adminId", type = HttpParamType.ADMIN_ID, description = "管理员Id") Long adminId,
            @NotNull @HttpParam(name = "id", type = HttpParamType.COMMON, description = "团购商品的Id") Long id) throws  ServiceException;

    @HttpMethod(description = "修改", permission = "operation:groupShop:editGroupShopSpu", permissionParentName = "商品管理", permissionName = "团购商品管理")
    public GroupShopDTO editGroupShopSpu(
            @NotNull @HttpParam(name = "adminId", type = HttpParamType.ADMIN_ID, description = "管理员Id") Long adminId,
            @NotNull @HttpParam(name = "id", type = HttpParamType.COMMON, description = "团购商品spuID") Long id,
            @NotNull @HttpParam(name = "spuId", type = HttpParamType.COMMON, description = "spuId") Long spuId,
            @NotNull @HttpParam(name = "gmtStart", type = HttpParamType.COMMON, description = "团购开始时间戳") Long gmtStart,
            @NotNull @HttpParam(name = "gmtEnd", type = HttpParamType.COMMON, description = "团购结束时间戳") Long gmtEnd,
            @NotNull @Range(min = 1) @HttpParam(name = "minimumNumber", type = HttpParamType.COMMON, description = "团购最低人数") Integer minimumNumber,
            @NotNull @HttpParam(name = "automaticRefund", type = HttpParamType.COMMON, description = "团购人数未满是否自动退款")  Integer automaticRefund,
            @NotNull @HttpParam(name = "groupShopSkuList", type = HttpParamType.COMMON, description = "团购sku链表") List groupShopSkuDOList ) throws ServiceException;

    @HttpMethod(description = "查询", permission = "operation:groupShop:queryGroupShop", permissionParentName = "商品管理", permissionName = "团购商品管理")
    public Page<GroupShopDTO> queryGroupShop(
            @NotNull @HttpParam(name = "adminId", type = HttpParamType.ADMIN_ID, description = "管理员Id") Long adminId,
            @HttpParam(name = "id", type = HttpParamType.COMMON, description = "团购商品的ID") Long id,
            @HttpParam(name = "spuName", type = HttpParamType.COMMON, description = "团购商品的名称") String spuName,
            @HttpParam(name = "status", type = HttpParamType.COMMON, description = "团购商品的状态") Integer status,
            @Range(min = 1) @HttpParam(name = "page", type = HttpParamType.COMMON, description = "团购商品页码", valueDef = "1") Integer page,
            @Range(min = 1) @HttpParam(name = "limit", type = HttpParamType.COMMON, description = "团购商品长度", valueDef = "20") Integer limit ) throws ServiceException;

}

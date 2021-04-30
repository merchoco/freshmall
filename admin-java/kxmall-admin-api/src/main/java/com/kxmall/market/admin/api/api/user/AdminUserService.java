package com.kxmall.market.admin.api.api.user;

import com.kxmall.market.core.annotation.HttpMethod;
import com.kxmall.market.core.annotation.HttpOpenApi;
import com.kxmall.market.core.annotation.HttpParam;
import com.kxmall.market.core.annotation.HttpParamType;
import com.kxmall.market.core.annotation.param.NotNull;
import com.kxmall.market.core.annotation.param.Range;
import com.kxmall.market.core.exception.ServiceException;
import com.kxmall.market.data.domain.UserDO;
import com.kxmall.market.data.model.Page;

/**
 *
 * Description:
 * User: admin
 * Date: 2019-07-11
 * Time: 下午7:30
 */

@HttpOpenApi(group = "admin.user", description = "用户管理")
public interface AdminUserService {

    @HttpMethod(description = "创建", permission = "admin:user:create", permissionParentName = "系统管理", permissionName = "用户管理")
    public Boolean create(
            @NotNull @HttpParam(name = "adminId", type = HttpParamType.ADMIN_ID, description = "管理员ID") Long adminId,
            @NotNull @HttpParam(name = "user", type = HttpParamType.COMMON, description = "用户信息") UserDO user) throws ServiceException;

    @HttpMethod(description = "删除", permission = "admin:user:delete", permissionParentName = "系统管理", permissionName = "用户管理")
    public Boolean delete(
            @NotNull @HttpParam(name = "adminId", type = HttpParamType.ADMIN_ID, description = "管理员ID") Long adminId,
            @NotNull @HttpParam(name = "id", type = HttpParamType.COMMON, description = "用户Id") Long id) throws ServiceException;

    @HttpMethod(description = "修改", permission = "admin:user:update", permissionParentName = "系统管理", permissionName = "用户管理")
    public Boolean update(
            @NotNull @HttpParam(name = "adminId", type = HttpParamType.ADMIN_ID, description = "管理员ID") Long adminId,
            @NotNull @HttpParam(name = "user", type = HttpParamType.COMMON, description = "用户信息") UserDO user) throws ServiceException;

    @HttpMethod(description = "激活冻结", permission = "admin:user:updateStatus", permissionParentName = "系统管理", permissionName = "用户管理")
    public Boolean updateStatus(
            @NotNull @HttpParam(name = "adminId", type = HttpParamType.ADMIN_ID, description = "管理员ID") Long adminId,
            @NotNull @HttpParam(name = "userId", type = HttpParamType.COMMON, description = "用户信息") Long userId,
            @NotNull @HttpParam(name = "status", type = HttpParamType.COMMON, description = "用户信息") Integer status) throws ServiceException;


    @HttpMethod(description = "查询", permission = "admin:user:query", permissionParentName = "系统管理", permissionName = "用户管理")
    public Page<UserDO> query(
            @NotNull @HttpParam(name = "adminId", type = HttpParamType.ADMIN_ID, description = "管理员ID") Long adminId,
            @HttpParam(name = "phone", type = HttpParamType.COMMON, description = "用户手机号") String phone,
            @HttpParam(name = "nickname", type = HttpParamType.COMMON, description = "用户昵称") String nickname,
            @HttpParam(name = "level", type = HttpParamType.COMMON, description = "用户等级") Integer level,
            @HttpParam(name = "gender", type = HttpParamType.COMMON, description = "用户性别") Integer gender,
            @HttpParam(name = "status", type = HttpParamType.COMMON, description = "用户状态") Integer status,
            @Range(min = 1) @HttpParam(name = "pageNo", type = HttpParamType.COMMON, description = "当前页码") Integer pageNo,
            @Range(min = 1) @HttpParam(name = "limit", type = HttpParamType.COMMON, description = "页码长度") Integer limit) throws ServiceException;
}

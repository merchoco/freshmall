package com.kxmall.market.admin.api.api.category;

import com.kxmall.market.core.annotation.HttpMethod;
import com.kxmall.market.core.annotation.HttpOpenApi;
import com.kxmall.market.core.annotation.HttpParam;
import com.kxmall.market.core.annotation.HttpParamType;
import com.kxmall.market.core.annotation.param.NotNull;
import com.kxmall.market.core.annotation.param.Range;
import com.kxmall.market.core.exception.ServiceException;
import com.kxmall.market.data.domain.CategoryDO;
import com.kxmall.market.data.dto.CategoryTreeNodeDTO;
import com.kxmall.market.data.model.Page;

import java.util.List;

/**
 *
 * @author admin
 * @date 2019/7/12
 */
@HttpOpenApi(group = "admin.category", description = "类目管理服务")
public interface AdminCategoryService {

    @HttpMethod(description = "获取二级类目树")
    public List<CategoryTreeNodeDTO> categorySecondLevelTree() throws ServiceException;

    @HttpMethod(description = "获取类目树")
    public List<CategoryTreeNodeDTO> categoryTree() throws ServiceException;

    @HttpMethod(description = "创建", permission = "operation:category:addCategory", permissionParentName = "商品管理", permissionName = "类目管理")
    public CategoryDO addCategory(
            @NotNull @HttpParam(name = "adminId", type = HttpParamType.ADMIN_ID, description = "管理员ID") Long adminId,
            @NotNull @HttpParam(name = "title", type = HttpParamType.COMMON, description = "类目标题") String title,
            @HttpParam(name = "parentId", type = HttpParamType.COMMON, description = "类目父节点", valueDef = "0") Long parentId,
            @HttpParam(name = "iconUrl", type = HttpParamType.COMMON, description = "类目图标") String iconUrl,
            @HttpParam(name = "picUrl", type = HttpParamType.COMMON, description = "类目图片") String picUrl,
            @HttpParam(name = "level", type = HttpParamType.COMMON, description = "类目等级") Integer level) throws ServiceException;

    @HttpMethod(description = "改变状态", permission = "operation:category:deleteCategory", permissionParentName = "商品管理", permissionName = "类目管理")
    public boolean changeStatus(
            @NotNull @HttpParam(name = "status", type = HttpParamType.COMMON, description = "状态") Integer status,
            @NotNull @HttpParam(name = "id", type = HttpParamType.COMMON, description = "类目ID") Long id) throws ServiceException;

    @HttpMethod(description = "删除", permission = "operation:category:deleteCategory", permissionParentName = "商品管理", permissionName = "类目管理")
    public boolean deleteCategory(
            @NotNull @HttpParam(name = "adminId", type = HttpParamType.ADMIN_ID, description = "管理员ID") Long adminId,
            @NotNull @HttpParam(name = "id", type = HttpParamType.COMMON, description = "类目ID") Long id) throws ServiceException;

    @HttpMethod(description = "修改", permission = "operation:category:updateCategory", permissionParentName = "商品管理", permissionName = "类目管理")
    public CategoryTreeNodeDTO updateCategory(
            @NotNull @HttpParam(name = "adminId", type = HttpParamType.ADMIN_ID, description = "管理员ID") Long adminId,
            @NotNull @HttpParam(name = "id", type = HttpParamType.COMMON, description = "类目ID") Long id,
            @NotNull @HttpParam(name = "title", type = HttpParamType.COMMON, description = "类目标题") String title,
            @NotNull @HttpParam(name = "parentId", type = HttpParamType.COMMON, description = "类目父节点") Long parentId,
            @HttpParam(name = "iconUrl", type = HttpParamType.COMMON, description = "类目图标") String iconUrl,
            @HttpParam(name = "picUrl", type = HttpParamType.COMMON, description = "类目图片") String picUrl,
            @HttpParam(name = "level", type = HttpParamType.COMMON, description = "类目等级") Integer level) throws ServiceException;

    @HttpMethod(description = "查询", permission = "operation:category:queryCategory", permissionParentName = "商品管理", permissionName = "类目管理")
    public Page<CategoryTreeNodeDTO> queryCategory(
            @NotNull @HttpParam(name = "adminId", type = HttpParamType.ADMIN_ID, description = "管理员ID") Long adminId,
            @HttpParam(name = "id", type = HttpParamType.COMMON, description = "类目ID") Long id,
            @HttpParam(name = "title", type = HttpParamType.COMMON, description = "类目标题") String title,
            @HttpParam(name = "level", type = HttpParamType.COMMON, description = "类目等级") Integer level,
            @HttpParam(name = "parentId", type = HttpParamType.COMMON, description = "父类目id") Long parentId,
            @Range(min = 1) @HttpParam(name = "pageNo", type = HttpParamType.COMMON, description = "页码", valueDef = "1") Integer pageNo,
            @Range(min = 1) @HttpParam(name = "limit", type = HttpParamType.COMMON, description = "页码长度", valueDef = "10") Integer limit) throws ServiceException;
}

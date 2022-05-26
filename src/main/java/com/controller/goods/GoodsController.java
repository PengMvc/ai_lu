package com.controller.goods;

import com.common.BaseResponse;
import com.controller.req.QueryGoodsRequest;
import com.define.exception.VerifyParameterException;
import com.entity.goods.Goods;
import com.github.pagehelper.PageInfo;
import com.service.goods.IGoodsService;
import com.until.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 商品信息相关接口
 * @Author: PengMvc
 * @Date: 2022/05/26/11:25
 */
@Api(tags = {"03.商品相关接口"})
@Controller
@RequestMapping("goods")
public class GoodsController {

    @Autowired
    private IGoodsService goodService;

    @PostMapping("/getGoodsPage")
    @ApiOperation("按照条件查询商品信息分页展示")
    @ResponseBody
    public BaseResponse<PageInfo<Goods>> queryGoodsByCondition(@RequestBody QueryGoodsRequest req) throws VerifyParameterException {

        // check param
        if(req.getPageNo() ==null || req.getPageSize() == null){
            throw new VerifyParameterException("商品分页查询没有传pageNo或pageSize");
        }
       return BaseResponse.success(goodService.queryGoodsListPage(req));
    }
}

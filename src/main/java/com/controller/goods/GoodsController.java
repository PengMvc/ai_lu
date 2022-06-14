package com.controller.goods;

import com.common.BaseResponse;
import com.common.ailuenum.APICode;
import com.controller.goods.req.AddGoodsRequest;
import com.controller.goods.req.EditGoodsRequest;
import com.controller.goods.req.QueryGoodsRequest;
import com.controller.goods.res.GoodsExcelResponse;
import com.define.exception.VerifyParameterException;
import com.entity.goods.Goods;
import com.github.pagehelper.PageInfo;
import com.mapper.IGoodsMapper;
import com.service.goods.IGoodsService;
import com.until.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;


/**
 * 商品信息相关接口
 * @Author: PengMvc
 * @Date: 2022/05/26/11:25
 */
@Api(tags = {"03.商品相关模块"})
@Controller
@RequestMapping("goods")
public class GoodsController {

    @Autowired
    private IGoodsService goodService;

    @Autowired
    private IGoodsMapper goodsMapper;

    private static final String fileName = "Goods_list_"+ DateUtil.getStringDate(new Date(),"yyyy-MM-dd");

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

    @PostMapping("/getGoodsDetail")
    @ApiOperation("查询商品详情")
    @ResponseBody
    public BaseResponse<Goods> queryGoodsDetail(@RequestParam Integer goodsNo) throws VerifyParameterException {

        // check param
        if(goodsNo == null){
            throw new VerifyParameterException("查询商品详情时，缺少商品编号必传参数");
        }

        // get goodsDetail
        return BaseResponse.success(goodService.queryGoodsDetail(goodsNo));
    }

    @PostMapping("/editGoods")
    @ApiOperation("修改商品信息")
    @ResponseBody
    public BaseResponse<String> editGoodsInfo(@RequestBody EditGoodsRequest req) throws VerifyParameterException {

        // check param
        if(req.getGoodsNo() == null){
            throw new VerifyParameterException("修改商品信息缺少必传参数");
        }

        // edit goodsInfo
        goodService.editGoodsInfo(req);
        return BaseResponse.success(APICode.SUCCESS_EDIT_GOODSINFO.getMessage());
    }

    @PostMapping("/exportGoodsExcel")
    @ApiOperation("导出商品信息")
    @ResponseBody
    public void exportGoodsInfo(@RequestBody QueryGoodsRequest req,HttpServletResponse response){

        // get goods list
        List<Goods> goodsList = goodsMapper.queryGoodsPage(req);

        // check size
        AssertUtil.isTrue(goodsList.size()>10000,"导出的商品信息太多，服务端不支持");
        List<GoodsExcelResponse> goodsExcelResponses = BeanUtil.copyBeanFromNewList(goodsList, GoodsExcelResponse.class);
        for (int i = 0; i < goodsExcelResponses.size();i++){
            goodsExcelResponses.get(i).setIndex(i+1);
        }

        // export goods excel
        ExcelUtils.writeExcel(response,goodsExcelResponses,GoodsExcelResponse.class,fileName,"商品列表");

    }

    @PostMapping("/addSingleGoods")
    @ApiOperation("新增商品信息")
    @ResponseBody
    public BaseResponse<String> addGoodsInfo(@RequestBody AddGoodsRequest req) throws VerifyParameterException {

        // check param
        if(checkParam(req)){
            throw new VerifyParameterException("新增商品缺少必传参数");
        }

        // add single goods
        goodService.addGoodsInfo(req);

        return BaseResponse.success(APICode.SUCCESS_ADD_GOODSINFO.getMessage());
    }

    private Boolean checkParam(AddGoodsRequest req){
        if(req.getGoodsNum() == null || req.getGoodsPrice() ==null || req.getIsOnSale() ==null || StringUtils.isBlank(req.getGoodsDesc()) ||
                StringUtils.isBlank(req.getFirstCategory())||StringUtils.isBlank(req.getGoodsName()) || StringUtils.isBlank(req.getGoodsSource())||
        StringUtils.isBlank(req.getSecondCategory()) || StringUtils.isBlank(req.getThirdCategory()) || StringUtils.isBlank(req.getGoodsImg()) || StringUtils.isBlank(req.getGoodsSendLocation())){
            return true;
        }
        return false;
    }
}

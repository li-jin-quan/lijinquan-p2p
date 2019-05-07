package cn.lijinquan.action.product;

import cn.lijinquan.action.common.BaseAction;
import cn.lijinquan.action.common.FrontStatusConstants;
import cn.lijinquan.action.common.Response;
import cn.lijinquan.domain.Product;
import cn.lijinquan.service.product.IProductService;
import cn.lijinquan.utils.RegValidationUtil;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.List;

import static cn.lijinquan.action.common.JsonMapper.logger;
import static org.apache.struts2.ServletActionContext.getResponse;

/**
 * Created by lijinquan on 2019/5/7.
 */

@Controller
@Scope("prototype")
@Namespace("/product")
public class ProductAction extends BaseAction{

    @Autowired
    private IProductService productService;

    @Action(value = "findAllProduct", results = { @Result(name = "success", type = "json") }, params = { "contentType",
            "text/html" })
    public void findAllProduct() {
        try {
            List<Product> list = productService.getAllProducts();
            getResponse().setContentType("text/html;charset=UTF-8");
            getResponse().getWriter()
                    .write(Response.build().setStatus(FrontStatusConstants.SUCCESS).setData(list).toJSON());
        } catch (Exception e) {
            e.getMessage();
            try {
                getResponse().getWriter().write(Response.build().setStatus(FrontStatusConstants.SYSTEM_ERROE).toJSON());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            logger.error("系统异常：", e);
        }
    }

//
//    // 根据id查询商品
//    @Action(value = "findProductById", results = { @Result(name = "success", type = "json") }, params = { "contentType",
//            "text/html" })
//    public void findProductById() {
//        getResponse().setContentType("text/html;charset=UTF-8");
//        String proId = this.getRequest().getParameter("proId");
//        // 验证产品id
//        if (!RegValidationUtil.validateIsNumber(proId)) {
//            try {
//                getResponse().getWriter().write(Response.build().setStatus(FrontStatusConstants.PARAM_VALIDATE_FAILED)
//                        .setMessage("参数错误：" + proId).toJSON());
//            } catch (IOException e) {
//                e.printStackTrace();
//                logger.error(e.getMessage());
//            }
//        }
//        try {
//            Product product = productService.getById(Long.valueOf(proId));
//            if (null == product) {
//                getResponse().getWriter().write(Response.build().setStatus(FrontStatusConstants.NULL_RESULT).toJSON());
//            } else {
//                getResponse().getWriter()
//                        .write(Response.build().setStatus(FrontStatusConstants.SUCCESS).setData(product).toJSON());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            logger.error(e.getMessage());
//        }
//    }

}

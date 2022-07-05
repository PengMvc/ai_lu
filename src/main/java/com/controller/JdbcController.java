package com.controller;

import com.common.BaseResponse;
import com.service.user.impl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.*;

/**
 * @Author: PengMvc
 * @Date: 2022/05/31/20:56
 */
@Api(tags = "jdbc操作数据库demo")
@Controller
@RequestMapping("/jdbc")
public class JdbcController {

    private static final Logger logger = LoggerFactory.getLogger(JdbcController.class);

    @PostMapping("/getData")
    @ApiOperation("从数据库获取数据")
    @ResponseBody
    public BaseResponse<Void> getDataByJdbc(){
        ResultSet result = null;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?serverTimezone=GMT%2B8&characterEncoding=utf-8&useSSL=false", "root", "123");
            logger.info("*get connection" + connection);
            StringBuilder baseSql = new StringBuilder().append(" select * from ai_lu_goods");
            baseSql.append(" where id = ? ");
            statement = connection.prepareStatement(baseSql.toString());
            statement.setInt(1,1);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getString("goods_name"));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            closeMysqlResource(result,statement,connection);
        }
        return BaseResponse.success();
    }

    private void closeMysqlResource(ResultSet result,PreparedStatement statement,Connection connection ){
        if(result !=null){
            try {
                result.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(statement !=null){
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(connection !=null){
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

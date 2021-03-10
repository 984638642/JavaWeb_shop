package com.shop.test;

import com.shop.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;

/**
 * 作者：zhanwei
 * 时间:21/03/09  16:17
 * 描述：
 */
public class JdbcUtilsTest {
    @Test
    public void testJdbcUtils(){
        for (int i = 0; i <100 ; i++) {
            Connection con = JdbcUtils.getConnection();
            System.out.println(con);
            JdbcUtils.close(con);
        }
    }
}

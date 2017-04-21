package com.kklt.paging.db;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by root on 17-4-21.
 */
public class JdbcConnectionUtilTest {
    @Test
    public void getConnection() throws Exception {
        assertNotNull(JdbcConnectionUtil.getConnection());
    }

}
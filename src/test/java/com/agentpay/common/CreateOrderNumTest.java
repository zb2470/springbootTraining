package com.agentpay.common;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CreateOrderNumTest {

    @Test
    public void getSerialNo() {
        CreateOrderNum createOrderNum=CreateOrderNum.GetInstance();
        List<String> list=new ArrayList<>();
        for (int i=0;i<100;i++)
        {
            list.add(createOrderNum.GetSerialNo());
        }
        list.forEach(c->{
            Integer i=0;
            if(list.contains(c))
            {
                i++;
            }
            Assert.assertEquals(new Integer(1),i);
        });
    }
}
package com.thinkingcao.springbootmemcached;

import com.thinkingcao.springbootmemcached.utils.MemcacheUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemcachedApplicationTests {

    @Resource
    private MemcacheUtils memcacheUtils;

    @Test
    public void testSetGet() {
        Boolean result = memcacheUtils.set("someKey", 10000, "666666");
        if (result) {
            System.out.println("***********  " + memcacheUtils.get("someKey").toString());
            return;
        }
        System.out.println("***********  操作失败!  ***********");
    }

    @Test
    public void testAsyncGet2() {
        //获取值，如果在5秒内没有返回值，将取消
        Object myObj = null;
        Object result = memcacheUtils.ascynGet("someKey");
        System.out.println(result);
    }

    @Test
    public void testReplace() {
        Boolean flag = memcacheUtils.replace("someKey", "dashuai", 10000);
        if (flag) {
            System.out.println("更新替换键值成功!");
            System.out.println("最终结果为:" + memcacheUtils.get("someKey").toString());
            return;
        }
        System.out.println("更新键值失败!");
    }

    @Test
    public void testAdd() {
        Boolean flag = memcacheUtils.add("someKey", "dashuai", 10000);
        if (flag) {
            System.out.println("最终结果为:" + memcacheUtils.get("someKey").toString());
            return;
        }
        System.out.println("添加键值失败!");
    }

    @Test
    public void delete() {
        Boolean f = memcacheUtils.delete("someKey");
        System.out.println("删除" + (f ? "成功!" : "失败!"));
    }

    @Test
    public void incrementTest() {
        long result = memcacheUtils.increment("increment", 5, 20, 10000);
        System.out.println(result);
    }

    @Test
    public void decrementTest() {
        long result = memcacheUtils.decrement("increment", 5, 20, 10000);
        System.out.println(result);
    }

    @Test
    public void asyncIncrement() {
        Long result = memcacheUtils.asyncIncrement("increment", 5);
        System.out.println(result);
    }

    @Test
    public void asyncGetMultiTest() {
        memcacheUtils.set("aa", 100000, "大帅");
        memcacheUtils.set("bb", 100000, "大傻");
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        Map map = memcacheUtils.asyncGetMulti(list);
        //System.out.println(JSONParseUtils.object2JsonString(map));
    }

    @Test
    public void flushTest() {
        memcacheUtils.flush();
        Object result = memcacheUtils.get("aa");
        System.out.println(result);
    }
}

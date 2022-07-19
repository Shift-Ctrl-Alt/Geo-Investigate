package com.oymn.geoinvestigate.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.oymn.geoinvestigate.dao.pojo.LandType;
import com.oymn.geoinvestigate.vo.LandTypeVo;
import org.junit.jupiter.api.Test;

import java.util.*;

public class ProjectTest {
    
    @Test
    public void test01(){
        LandTypeVo landTypeVo = new LandTypeVo(1L, "aa", "aa");
        List<LandType> landTypeList = new ArrayList<>();
        landTypeList.add(new LandType(1L, "aa", "bb", 10L, new Date(), new Date()));
        landTypeList.add(new LandType(2L, "aa", "bb", 10L, new Date(), new Date()));
        landTypeVo.setSubLandType(landTypeList);

        LandTypeVo landTypeVo2 = new LandTypeVo(2L, "aa", "aa");
        landTypeVo2.setSubLandType(landTypeList);

        List<LandTypeVo> landTypeVoList = new ArrayList<>();
        landTypeVoList.add(landTypeVo);
        landTypeVoList.add(landTypeVo2);

        String json = JSONObject.toJSONString(landTypeVoList);
        System.out.println(json);
        List<LandTypeVo> newLandTypeVoList = JSONObject.parseArray(json, LandTypeVo.class);
        System.out.println(newLandTypeVoList);
    }
    
    @Test
    public int findRepeatNumber(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if(set.contains(num)){
                return num;
            }
            set.add(num);
        }
        
        return 0;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public int[] reversePrint(ListNode head) {
        ListNode p = head;
        int count = 0;
        while(p != null){
            count++;
            p = p.next;
        }

        int[] result = new int[count];
        p = head;
        for(int i = count - 1; i >= 0; i--){
            result[i] = p.val;
            p = p.next;
        }
        
        return result;
    }

    public ListNode reverseList(ListNode head) {
        
        return null;
        
    }
}

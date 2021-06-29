package com.yh.junit.json;

import com.alibaba.fastjson.JSONArray;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.List;

/**
 * JsonTest class
 *
 * @author yh
 * @date 2021/3/4
 */
public class JsonTest {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("D:\\file\\data.json");
             InputStreamReader isr = new InputStreamReader(fis);
             BufferedReader br = new BufferedReader(isr)) {
            String oneLineString;
            while ((oneLineString = br.readLine()) != null) {
                List<FileBeat> fileBeat = JSONArray.parseArray(oneLineString, FileBeat.class);
                System.out.println(fileBeat);
                for (int i = 0; i < fileBeat.size(); i++) {
                    System.out.println(fileBeat.get(i));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

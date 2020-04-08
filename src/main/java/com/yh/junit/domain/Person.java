package com.yh.junit.domain;

import lombok.Data;

import java.util.List;

@Data
public class Person {
    private String name;
    private String sex;
    private String address;
    private String national;
    private Integer age;
    private List<Piece> pieceList;

    @Data
    public static class Piece {
        private String pieceId;
        private Integer num;
    }
}

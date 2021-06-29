package com.yh.junit.json;

import lombok.Data;

import java.util.Date;

/**
 * FileBeat class
 *
 * @author yh
 * @date 2021/3/4
 */
@Data
public class FileBeat {
    private String source;
    private int offset;
    private String timestamp;
    private int ttl;
    private String type;
    private String meta;
    private FileStateOS fileStateOS;

    @Data
    public static class FileStateOS {
        private long idxhi;
        private long idxlo;
        private long vol;
    }
}

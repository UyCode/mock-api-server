package com.uycode.mockapiserver.dto;

import lombok.Data;

/**
 * @author ahmatjan(UyCode)
 * @email Hyper-Hack@outlook.com
 * @date 3/16/2021 23:18
 */

@Data
public class UserFileDto {

    private String userEmail;

    private String userName;

    private String fileName;

    private String filePath;

    private int fileStatus;
}

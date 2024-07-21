package com.yun.springmvc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageInfo {
    private String to;
    private String from;
    private String say;
}

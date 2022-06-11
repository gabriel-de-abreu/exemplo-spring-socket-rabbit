package com.websocket.demo.dto;

import com.websocket.demo.utils.JsonUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExampleMessageDTO {

    private String message;

    @Override
    public String toString() {
        return JsonUtils.toJson(this);
    }
}

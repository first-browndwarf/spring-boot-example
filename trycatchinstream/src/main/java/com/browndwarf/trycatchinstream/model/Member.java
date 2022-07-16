package com.browndwarf.trycatchinstream.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Member {

    @JsonProperty("id")
    private long    id;

    @JsonProperty("name")
    private String  name;

    @JsonProperty("age")
    private int age;

    @JsonProperty("group")
    private String group;

    @JsonProperty("groupInfo")
    private String groupInfo;
}

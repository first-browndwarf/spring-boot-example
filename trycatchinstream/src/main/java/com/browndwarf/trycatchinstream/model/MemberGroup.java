package com.browndwarf.trycatchinstream.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class MemberGroup {

    @JsonProperty("name")
    String  name;

    @JsonProperty("category")
    String  category;

    @JsonProperty("count")
    int  memberCount;

}

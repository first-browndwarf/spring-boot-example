package com.browndwarf.jpqlex.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "team")
public class TeamEntity {

    @Id
    @Column(name = "id")
    private long    teamId;

    @Column(name = "name")
    private String  teamName;

    @Column(name="role")
    private String  role;

    @OneToMany(mappedBy = "team")
    private List<MemberEntity> member = new ArrayList<>();
}

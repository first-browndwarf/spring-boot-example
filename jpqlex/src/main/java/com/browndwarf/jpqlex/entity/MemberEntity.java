package com.browndwarf.jpqlex.entity;

import javax.persistence.*;

@Entity
@Table(name = "member")
public class MemberEntity {

    @Id
    @Column(name = "id")
    private long    memberId;

    @Column(name = "name")
    private String  memberName;

    @Column(name = "age")
    private int age;

    @Column(name = "level")
    private int level;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teamId", insertable=false, updatable=false)
    private TeamEntity team;

}

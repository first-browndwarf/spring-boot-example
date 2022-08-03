package com.browndwarf.jpqlex.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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

}

package com.browndwarf.jpqlex.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "project")
public class ProjectEntity {

    @Id
    @Column(name = "id")
    private long    projectId;

    @Column(name = "name")
    private String  projectName;

    @Column(name = "desc")
    private String  desc;

    @Column(name = "assignee_type")
    private String  assigneeType;

    @Column(name = "assignee_id")
    private long  assigneeId;
}

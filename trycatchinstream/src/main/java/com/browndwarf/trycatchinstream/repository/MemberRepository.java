package com.browndwarf.trycatchinstream.repository;

import com.browndwarf.trycatchinstream.model.Member;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MemberRepository {

    private List<Member>    memberList;

    public List<Member> findAllByGroup(String groupName) {
        return memberList.stream()
                .filter(p->p.getGroup().equalsIgnoreCase(groupName))
                .collect(Collectors.toList());
    }
}

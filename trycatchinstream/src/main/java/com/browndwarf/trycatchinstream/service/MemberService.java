package com.browndwarf.trycatchinstream.service;

import com.browndwarf.trycatchinstream.common.custominterface.FunctionWithThrows;
import com.browndwarf.trycatchinstream.common.util.CustomFunctionalInterfaces;
import com.browndwarf.trycatchinstream.model.Member;
import com.browndwarf.trycatchinstream.model.MemberGroup;
import com.browndwarf.trycatchinstream.repository.MemberRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Slf4j
@Service
public class MemberService {

    @Autowired
    private MemberRepository    memberRepository;

    public MemberGroup    getMemberGroupInfo01(String groupName) {

        ObjectMapper    mapper = new ObjectMapper();

        return memberRepository.findAllByGroup(groupName).stream()
                .findFirst()
                .map(v -> {
                    try {
                        return mapper.readValue(v.getGroupInfo(), MemberGroup.class);
                    } catch (JsonProcessingException e) {
                        log.error(">>> JsonProcessingException : {}", e.getMessage());
                        return null;
                        //throw new RuntimeException("Fail to parse : " + e.getMessage());
                    }
                })
                .orElse(null);

    }

    public MemberGroup    getMemberGroupInfo02(String groupName) {

        ObjectMapper    mapper = new ObjectMapper();

        return memberRepository.findAllByGroup(groupName).stream()
                .findFirst()
                .map(v -> {
                    try {
                        return mapper.readValue(v.getGroupInfo(), MemberGroup.class);
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException("Fail to parse Json String : '" + v.getGroupInfo() + "'");
                    }
                })
                .get();

    }

    public MemberGroup    getMemberGroupInfo03(String groupName) {
        return memberRepository.findAllByGroup(groupName).stream()
                .findFirst()
                .map(this::getMemberGroupFromMember)
                .orElse(null);
    }

    private MemberGroup getMemberGroupFromMember(Member member) {
        ObjectMapper    mapper = new ObjectMapper();

        try {
            return mapper.readValue(member.getGroupInfo(), MemberGroup.class);
        } catch (JsonProcessingException e) {
            log.error(">>> JsonProcessingException : {}", e.getMessage());
            return null;
        }
    }

    public MemberGroup    getMemberGroupInfo04(String groupName) {
        return memberRepository.findAllByGroup(groupName).stream()
                .findFirst()
                .map(this::getMemberGroupFromMemberWithException)
                .get();
    }

    private MemberGroup getMemberGroupFromMemberWithException(Member member) {
        ObjectMapper    mapper = new ObjectMapper();

        try {
            return mapper.readValue(member.getGroupInfo(), MemberGroup.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Fail to parse Json String : '" + member.getGroupInfo() + "'");
        }
    }

    public MemberGroup    getMemberGroupInfo05(String groupName) {
        return memberRepository.findAllByGroup(groupName).stream()
                .findFirst()
                .map(CustomFunctionalInterfaces.functionWithNull(v->(new ObjectMapper()).readValue(v.getGroupInfo(), MemberGroup.class)))
                .orElse(null);
    }

    public MemberGroup    getMemberGroupInfo06(String groupName) {
        return memberRepository.findAllByGroup(groupName).stream()
                .findFirst()
                .map(CustomFunctionalInterfaces.functionWithThrows(v->(new ObjectMapper()).readValue(v.getGroupInfo(), MemberGroup.class)))
                .get();
    }
}

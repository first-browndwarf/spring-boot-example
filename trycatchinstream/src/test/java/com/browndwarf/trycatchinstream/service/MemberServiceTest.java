package com.browndwarf.trycatchinstream.service;

import com.browndwarf.trycatchinstream.model.Member;
import com.browndwarf.trycatchinstream.model.MemberGroup;
import com.browndwarf.trycatchinstream.repository.MemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MemberServiceTest {

    private List<Member> memberList;

    @Mock
    private MemberRepository mockMemberRepository;

    @InjectMocks
    private MemberService   memberService;

    @BeforeEach
    private void init(){
        memberList = Arrays.asList(new Member(1, "Martin", 15, "Klavery", "{\"name\":\"Klavery\",\"category\":\"Tantsida\",\"count\":20}"),
                new Member(2,"Andres",17,"Shark","{\"info\":\"invalid\"}"),
                new Member(3, "Marten", 22, "Klavery", "{\"name\":\"Klavery\",\"category\":\"Tantsida\",\"count\":20}"),
                new Member(4,"Andres",16,"Tera","{\"name\":\"Shark\",\"category\":\"Uisutamine\",\"count\":25}"),
                new Member(5, "Kristo", 16, "Klavery", "{\"name\":\"Klavery\",\"category\":\"Tantsida\",\"count\":20}")
        );
    }


    @Test
    void getMemberGroupInfo01_WhenOccurException_ThenNullReturn() {
        // Given
        when(mockMemberRepository
                .findAllByGroup("Shark"))
                .thenReturn(memberList.stream().filter(member->member.getGroup().equalsIgnoreCase("Shark")).collect(Collectors.toList()));

        // When
        MemberGroup invalidMemberGroup = memberService.getMemberGroupInfo01("Shark");

        // Then
        assertEquals(null, invalidMemberGroup);
    }

    @Test
    void getMemberGroupInfo02_WhenOccurException_ThenThrowException() {
        // Given
        when(mockMemberRepository
                .findAllByGroup("Shark"))
                .thenReturn(memberList.stream().filter(member->member.getGroup().equalsIgnoreCase("Shark")).collect(Collectors.toList()));

        // When

        // Then
        RuntimeException e = assertThrows(RuntimeException.class, ()->{
            memberService.getMemberGroupInfo02("Shark");
        });
        System.out.printf(">>> Exception Message : %s\n", e.getMessage());
    }

    @Test
    void getMemberGroupInfo03_WhenOccurException_ThenNullReturn() {
        // Given
        when(mockMemberRepository
                .findAllByGroup("Shark"))
                .thenReturn(memberList.stream().filter(member->member.getGroup().equalsIgnoreCase("Shark")).collect(Collectors.toList()));

        // When
        MemberGroup invalidMemberGroup = memberService.getMemberGroupInfo03("Shark");

        // Then
        assertEquals(null, invalidMemberGroup);
    }

    @Test
    void getMemberGroupInfo04_WhenOccurException_ThenThrowException() {
        // Given
        when(mockMemberRepository
                .findAllByGroup("Shark"))
                .thenReturn(memberList.stream().filter(member->member.getGroup().equalsIgnoreCase("Shark")).collect(Collectors.toList()));

        // When

        // Then
        RuntimeException e = assertThrows(RuntimeException.class, ()->{
            memberService.getMemberGroupInfo04("Shark");
        });
        System.out.printf(">>> Exception Message : %s\n", e.getMessage());
    }

    @Test
    void getMemberGroupInfo05_WhenOccurException_ThenNullReturn() {
        // Given
        when(mockMemberRepository
                .findAllByGroup("Shark"))
                .thenReturn(memberList.stream().filter(member->member.getGroup().equalsIgnoreCase("Shark")).collect(Collectors.toList()));

        // When
        MemberGroup invalidMemberGroup = memberService.getMemberGroupInfo05("Shark");

        // Then
        assertEquals(null, invalidMemberGroup);
    }

    @Test
    void getMemberGroupInfo06_WhenOccurException_ThenThrowException() {
        // Given
        when(mockMemberRepository
                .findAllByGroup("Shark"))
                .thenReturn(memberList.stream().filter(member->member.getGroup().equalsIgnoreCase("Shark")).collect(Collectors.toList()));

        // When

        // Then
        RuntimeException e = assertThrows(RuntimeException.class, ()->{
            memberService.getMemberGroupInfo06("Shark");
        });
        System.out.printf(">>> Exception Message : %s\n", e.getMessage());
    }

}

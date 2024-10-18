package com.example.springdi;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MemberTest {
    @Test
    public void getterSetter(){
        Member member = new Member();
        member.setName("baejeu");
        assertThat(member.getName()).isEqualTo("baejeu");
    }
}
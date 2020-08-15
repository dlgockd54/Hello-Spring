package hello.hellospring.service

import hello.hellospring.domain.Member
import hello.hellospring.repository.MemoryMemberRepository
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import java.lang.IllegalStateException

internal class MemberServiceTest {

    private lateinit var memberService : MemberService
    private lateinit var memberRepository : MemoryMemberRepository

    @BeforeEach
    fun beforeEach() {
        memberRepository = MemoryMemberRepository()
        memberService = MemberService(memberRepository)
    }

    @AfterEach
    fun afterEach() {
        memberRepository.clearStore()
    }

    @Test
    fun join() {
        // given
        val member = Member(name = "hello")

        // when
        val saveId = memberService.join(member)

        // then
        val findMember = memberService.findOne(saveId).get()
        Assertions.assertThat(member.name).isEqualTo(findMember.name)
    }

    @Test
    fun 중복_회원_예외() {
        // given
        val member1 = Member(name = "spring")
        val member2 = Member(name = "spring")

        // when
        memberService.join(member1)

        val e = assertThrows(IllegalStateException::class.java) {
            memberService.join(member2)
        }

        Assertions.assertThat(e.message).isEqualTo("이미 존재하는 회원")
        Assertions.assertThat(e.message).isEqualTo("이미 존재하는 회원ㅎㅎ")

        // then
    }

    @Test
    fun findMembers() {
    }

    @Test
    fun findOne() {
    }
}
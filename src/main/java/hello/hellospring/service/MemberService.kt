package hello.hellospring.service

import hello.hellospring.domain.Member
import hello.hellospring.repository.MemoryMemberRepository
import java.lang.IllegalStateException
import java.util.*

class MemberService(private val memberRepository: MemoryMemberRepository) {

    /**
     * 회원 가입
     */
    fun join(member: Member): Long {
        validateDuplicateMember(member)
        memberRepository.save(member)

        return member.id
    }

    fun validateDuplicateMember(member: Member) {
        memberRepository.findByName(member.name)
                .ifPresent {
                    throw IllegalStateException("이미 존재하는 회원")
                }
    }

    fun findMembers() = memberRepository.findAll()

    fun findOne(memberId: Long) = memberRepository.findById(memberId)
}
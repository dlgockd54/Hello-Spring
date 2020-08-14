package hello.hellospring.repository

import hello.hellospring.domain.Member
import java.util.*

interface MemberRepository {

    fun save(member: Member): Member

    fun findById(id: Long): Optional<Member>

    fun findByName(name: String): Optional<Member>

    fun findAll(): List<Member>
}
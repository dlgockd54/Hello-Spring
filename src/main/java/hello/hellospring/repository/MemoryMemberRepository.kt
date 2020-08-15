package hello.hellospring.repository

import hello.hellospring.domain.Member
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class MemoryMemberRepository : MemberRepository {

    companion object {

        private val store = hashMapOf<Long, Member>()
        private var sequence = -1L
    }

    override fun save(member: Member): Member {
        sequence++
        member.id = sequence
        store[member.id] = member

        return member
    }

    override fun findById(id: Long): Optional<Member> = Optional.ofNullable(store[id])

    override fun findByName(name: String): Optional<Member> =
            Optional.ofNullable(store.entries.filter {
                it.value.name == name
            }.firstOrNull()?.value)

    override fun findAll(): List<Member> = store.values.toList()

    fun clearStore() {
        store.clear()
    }
}
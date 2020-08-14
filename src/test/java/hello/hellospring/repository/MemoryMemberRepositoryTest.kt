package hello.hellospring.repository

import hello.hellospring.domain.Member
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test

class MemoryMemberRepositoryTest {

    val repository = MemoryMemberRepository()

    @AfterEach
    fun afterEach() {
        repository.clearStore()
    }

    @Test
    fun save() {
        val member = Member(name = "spring")

        repository.save(member)
        val result = repository.findById(member.id).get()

        Assertions.assertThat(member).isEqualTo(result)
    }

    @Test
    fun findByName() {
        val member1 = Member(name = "spring1")
        val member2 = Member(name = "spring2")

        repository.save(member1)
        repository.save(member2)

        val result = repository.findByName("spring1").get()

        Assertions.assertThat(result).isEqualTo(member1)
    }

    @Test
    fun findAll() {
        val member1 = Member(name = "spring1")
        val member2 = Member(name = "spring2")

        repository.save(member1)
        repository.save(member2)

        val results = repository.findAll()

        Assertions.assertThat(results.size).isEqualTo(2)
    }
}
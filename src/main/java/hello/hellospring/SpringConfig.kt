package hello.hellospring

import hello.hellospring.repository.MemoryMemberRepository
import hello.hellospring.service.MemberService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class SpringConfig {

    @Bean
    open fun memberService() = MemberService(memberRepository())

    @Bean
    open fun memberRepository() = MemoryMemberRepository()
}
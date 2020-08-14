package hello.hellospring

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class HelloController {

    @GetMapping("hello")
    fun hello(model: Model): String {
        model.addAttribute("data", "hello!!")
        model.addAttribute("name", "이해창")

        return "hello"
    }

    @GetMapping("hello-mvc")
    fun helloMvc(@RequestParam("name", required = false) name: String?, model: Model): String {
        model.addAttribute("name", name)

        return "hello-template"
    }

    @GetMapping("hello-string")
    @ResponseBody
    fun helloString(@RequestParam("name") name: String?): String {
        return "hello $name"
    }

    @GetMapping("hello-api")
    @ResponseBody
    fun helloApi(@RequestParam("name") name: String): Hello {
        return Hello(name)
    }

    data class Hello(val name: String)
}
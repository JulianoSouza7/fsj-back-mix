//package br.com.fsjdemandamix.config
//
//import com.fsj.reflection.Reflection
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import org.springframework.core.env.Environment
//
//@Configuration
//class ReflectionFeingConfig(private val environment: Environment) {
//
//    @Bean
//    fun getReflection(): Reflection {
//        return Reflection(environment, "br.com.fsjdemanda.feign")
//    }
//}
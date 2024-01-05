package br.andrew.serasa.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
@ConfigurationProperties(prefix = "serasa")
class SerasaConfiguration() {

    var url : String = "";
    var user : String = "";
    var password : String = "";

    @Bean
    fun serasaProperties() : SerasaProperties {
        return SerasaProperties(url, user, password)
    }

}

class SerasaProperties(val url : String, val user : String,
                       val password: String) {
    fun getBase(): String {
        val newPassword = "        "
        return "$url/consultahttps?p=$user${password}${newPassword}"
    }
}
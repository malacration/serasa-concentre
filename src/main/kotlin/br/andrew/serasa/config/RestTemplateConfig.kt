package br.andrew.serasa.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate


@Configuration
class RestTemplateConfig {

    @Bean
    fun restTemplate(): RestTemplate? {
//        val acceptingTrustStrategy = TrustStrategy { cert: Array<X509Certificate?>?, authType: String? -> true }
//        val sslContext: SSLContext = SSLContexts.custom()
//                .loadTrustMaterial(null, acceptingTrustStrategy)
//                .build()
//        val sslsf = SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE)
//        val socketFactoryRegistry: Registry<ConnectionSocketFactory> = RegistryBuilder.create < ConnectionSocketFactory ? > ()
//                .register("https", sslsf)
//                .register("http", PlainConnectionSocketFactory())
//                .build()
//        val connectionManager = PoolingHttpClientConnectionManager(socketFactoryRegistry)
//        val httpClient = HttpClients.custom().setConnectionManager(connectionManager).build()
//
//        val requestFactory = HttpComponentsClientHttpRequestFactory()
//        requestFactory.httpClient = httpClient
        return RestTemplate()
    }

}
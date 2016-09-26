package example.drama.service

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement
import javax.persistence.EntityManagerFactory
import javax.sql.DataSource

@Configuration
@EntityScan(basePackages = arrayOf("example.common.entity", "example.drama.service"))
@EnableJpaRepositories(basePackages = arrayOf("example.drama.service.dao"))
@EnableTransactionManagement
open class DramaServiceApplicationConfigJPA {

    @Bean
    @Primary
    open fun dataSource(): DataSource =
            EmbeddedDatabaseBuilder()
                    .setType(EmbeddedDatabaseType.HSQL)
                    .addScripts("classpath:/hsql/data.sql")
                    .build()

    @Bean
    open fun transactionManager(entityManagerFactory: EntityManagerFactory): PlatformTransactionManager =
            JpaTransactionManager(entityManagerFactory)

}

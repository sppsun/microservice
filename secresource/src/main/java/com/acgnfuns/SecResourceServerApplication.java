package com.acgnfuns;

import com.acgnfuns.domain.Account;
import com.acgnfuns.service.AccountService;
import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.security.auth.login.AccountException;
import javax.sql.DataSource;
import java.util.Arrays;

@SpringBootApplication
@Configuration
@EnableJpaRepositories("com.acgnfuns.repository")
@EnableDiscoveryClient
@EnableAdminServer
public class SecResourceServerApplication {
    private static final Class<SecResourceServerApplication> applicationClass = SecResourceServerApplication.class;
    private static final Logger log = LoggerFactory.getLogger(applicationClass);

    public static void main(String[] args) {
        SpringApplication.run(applicationClass, args);
    }

    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(applicationClass);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean @Qualifier("mainDataSource")
    public DataSource dataSource(){
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase db = builder
                .setType(EmbeddedDatabaseType.H2)
                .build();
        return db;
    }

    @Bean
    CommandLineRunner init(
            AccountService accountService
    ) {
        return (evt) -> Arrays.asList(
                "user,admin".split(",")).forEach(
                username -> {
                    Account acct = new Account();
                    acct.setUsername(username);
                    if ( username.equals("user"))
                        acct.setPassword("password");
                    else
                        acct.setPassword(passwordEncoder().encode("password"));
                    acct.setFirstName(username);
                    acct.setLastName("LastName");
                    acct.grantAuthority("ROLE_USER");
                    if ( username.equals("admin") )
                        acct.grantAuthority("ROLE_ADMIN");
                    try {
                        accountService.register(acct);
                    } catch (AccountException e) {
                        e.printStackTrace();
                    }
                }
        );
    }

}

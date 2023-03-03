package peaksoft.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * name : kutman
 **/
@EnableWebSecurity
@Configuration
public class SecurityConfig {
    @Bean
    public UserDetailsService userDetailsService(){
        User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();
        UserDetails admin = userBuilder.username("admin").password("admin123").roles("ADMIN").build();
        UserDetails doctor = userBuilder.username("doctor").password("doctor123").roles("DOCTOR").build();
        UserDetails patient = userBuilder.username("patient").password("patient123").roles("PATIENT").build();
        return new InMemoryUserDetailsManager(admin,doctor,patient);
    }


    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests()
                //HOSPITAL
                .requestMatchers("/hospital").hasAnyRole("ADMIN","DOCTOR","PATIENT")
                .requestMatchers("/hospital/saveHospital").hasRole("ADMIN")
                .requestMatchers("/hospital/createHospital").hasRole("ADMIN")
                .requestMatchers("/hospital/{id}/delete").hasRole("ADMIN")
                .requestMatchers("/hospital/{id}/edit").hasRole("ADMIN")
                .requestMatchers("/hospital/{id}/update").hasRole("ADMIN")
                //DEPARTMENT
                .requestMatchers("/department/{id}/getAll").hasAnyRole("ADMIN","DOCTOR","PATIENT")
                .requestMatchers("/department/saveDepartment").hasRole("ADMIN")
                .requestMatchers("/department/creatDepartment").hasRole("ADMIN")
                .requestMatchers("/department/{id}/delete").hasRole("ADMIN")
                .requestMatchers("/department/{id}/edit").hasRole("ADMIN")
                .requestMatchers("/department/{id}/update").hasRole("ADMIN")
                .requestMatchers("/department").hasRole("ADMIN")
                //DOCTOR
                .requestMatchers("/doctor/{id}/getAll").hasAnyRole("ADMIN","DOCTOR","PATIENT")
                .requestMatchers("/doctor/{id}/saveDoctor").hasRole("ADMIN")
                .requestMatchers("/doctor/{id}/creatDoctor").hasRole("ADMIN")
                .requestMatchers("/doctor/{id}/delete").hasRole("ADMIN")
                .requestMatchers("/doctor/{id}/edit").hasRole("ADMIN")
                .requestMatchers("/doctor/{id}/update").hasRole("ADMIN")
                .requestMatchers("/doctor/{id}/assign").hasRole("ADMIN")
                .requestMatchers("/doctor/{id}/ass").hasRole("ADMIN")
                .requestMatchers("/doctor").hasRole("ADMIN")
                //PATIENT
                .requestMatchers("/patient/{id}/getAll").hasAnyRole("ADMIN","DOCTOR","PATIENT")
                .requestMatchers("/patient/{id}/savePatient").hasAnyRole("ADMIN","DOCTOR")
                .requestMatchers("/patient/{id}/createPatient").hasAnyRole("ADMIN","DOCTOR")
                .requestMatchers("/patient/{id}/delete").hasAnyRole("ADMIN","DOCTOR")
                .requestMatchers("/patient/{id}/editPatient").hasAnyRole("ADMIN","DOCTOR")
                .requestMatchers("/patient/{id}/update").hasAnyRole("ADMIN","DOCTOR")
                //APPOINTMENT
                .requestMatchers("/appointment/{id}/getAll").hasAnyRole("ADMIN","DOCTOR","PATIENT")
                .requestMatchers("/appointment/{id}/saveAppointment").hasAnyRole("ADMIN","DOCTOR","PATIENT")
                .requestMatchers("/appointment/{id}/createAppointment").hasAnyRole("ADMIN","DOCTOR","PATIENT")
                .requestMatchers("/appointment/{id}/delete").hasAnyRole("ADMIN","DOCTOR","PATIENT")
                .requestMatchers("/appointment/{id}/editAppointment").hasAnyRole("ADMIN","DOCTOR","PATIENT")
                .requestMatchers("/appointment/{id}/updateAppointment").hasAnyRole("ADMIN","DOCTOR","PATIENT")
                .and()
                .formLogin()
                .defaultSuccessUrl("/hospital")
                .permitAll();

        return http.build();
    }


}

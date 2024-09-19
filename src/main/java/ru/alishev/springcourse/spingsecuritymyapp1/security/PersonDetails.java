package ru.alishev.springcourse.spingsecuritymyapp1.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.alishev.springcourse.spingsecuritymyapp1.models.Person;
import java.util.Collection;


public class PersonDetails implements UserDetails {
    private final Person person;

    public PersonDetails(Person person) {
        this.person = person;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null; // Список прав - доступ к определенным страницам
    }

    @Override
    public String getPassword() {
        return this.person.getPassword();
    }

    @Override
    public String getUsername() {
        return this.person.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // прописываем способы определения просрочки
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // описываем способ проверки на наличие блокировки
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // описываем проверку на просрочку
    }

    @Override
    public boolean isEnabled() {
        return true; // аккаунты в рабочем состоянии - описываем проверку
    }

    // Нужно, чтобы получать данные аутентифицированного пользователя
    public Person getPerson() {
        return this.person;
    }
}

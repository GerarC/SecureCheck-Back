package co.edu.udea.securecheck.domain.utils.filters;

import co.edu.udea.securecheck.domain.utils.Generated;

import java.time.LocalDateTime;

@Generated
public class CompanyFilter {
    private final String nit;
    private final String name;
    private final String nick;
    private final LocalDateTime createdAfter;
    private final LocalDateTime createdBefore;

    public CompanyFilter(String nit, String name, String nick, LocalDateTime createdAfter, LocalDateTime createdBefore) {
        this.nit = nit;
        this.name = name;
        this.nick = nick;
        this.createdAfter = createdAfter;
        this.createdBefore = createdBefore;
    }

    public String getNit() {
        return nit;
    }

    public String getName() {
        return name;
    }

    public String getNick() {
        return nick;
    }

    public LocalDateTime getCreatedAfter() {
        return createdAfter;
    }

    public LocalDateTime getCreatedBefore() {
        return createdBefore;
    }
}

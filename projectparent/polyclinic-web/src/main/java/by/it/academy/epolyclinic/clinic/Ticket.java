package by.it.academy.epolyclinic.clinic;

import java.util.Objects;

public class Ticket {
    private Long id;
    private String specialist;

    public Ticket() {
    }

    public Ticket(Long id, String specialist) {
        this.id = id;
        this.specialist = specialist;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpecialist() {
        return specialist;
    }

    public void setSpecialist(String specialist) {
        this.specialist = specialist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(id, ticket.id) &&
                Objects.equals(specialist, ticket.specialist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, specialist);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", specialist='" + specialist + '\'' +
                '}';
    }
}

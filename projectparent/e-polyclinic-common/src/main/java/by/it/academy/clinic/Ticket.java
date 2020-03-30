package by.it.academy.clinic;

import java.util.Objects;

public class Ticket {
    private Long id;
    private Doctor specialist;
    private Long data;

    public Ticket() {
    }

    public Ticket(Long id, Doctor specialist, Long data) {
        this.id = id;
        this.specialist = specialist;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Doctor getSpecialist() {
        return specialist;
    }

    public void setSpecialist(Doctor specialist) {
        this.specialist = specialist;
    }

    public Long getData() {
        return data;
    }

    public void setData(Long data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(id, ticket.id) &&
                Objects.equals(specialist, ticket.specialist) &&
                Objects.equals(data, ticket.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, specialist, data);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", specialist=" + specialist +
                ", data=" + data +
                '}';
    }
}

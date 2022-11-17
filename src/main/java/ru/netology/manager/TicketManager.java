package ru.netology.manager;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;
import java.util.Arrays;

public class TicketManager {
    protected TicketRepository repo;

    public TicketManager(TicketRepository repo) {
        this.repo = repo;
    }

    public void add(Ticket ticket) {
        repo.addTicket(ticket);
    }

    public void removeById(int id) {
        repo.removeById(id);
    }

    public Ticket[] findAll() {
        return repo.getTickets();
    }

    public Ticket[] searchBy(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repo.getTickets()) {
            if (matchesTo(ticket, to, from)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public boolean matchesTo(Ticket ticket, String from, String to) {
        if (!ticket.getFrom().equals(from)) {
            return false;
        }
        if (!ticket.getTo().equals(to)) {
            return false;
        }
        return true;
    }
}
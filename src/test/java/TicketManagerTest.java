import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.manager.TicketManager;
import ru.netology.repository.TicketRepository;

public class TicketManagerTest {
    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);

    Ticket ticket1 = new Ticket(1, 1000, "LED", "VKO", 90);
    Ticket ticket2 = new Ticket(2, 2000, "LED", "SVO", 90);
    Ticket ticket3 = new Ticket(3, 3000, "LED", "VKO", 90);
    Ticket ticket4 = new Ticket(4, 8000, "VKO", "LED", 90);
    Ticket ticket5 = new Ticket(5, 2000, "LED", "SVO", 90);
    Ticket ticket6 = new Ticket(6, 6000, "VKO", "LED", 90);

    @BeforeEach
    public void setup() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

    }

    @Test
    public void shouldFindAndSort() {
        Ticket[] expected = {ticket6, ticket4};
        Ticket[] actual = manager.searchBy("VKO", "LED");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAndSortEquals() {
        Ticket[] expected = {ticket2, ticket5};
        Ticket[] actual = manager.searchBy("LED", "SHE");
    }

    @Test
    public void shouldRemoveAndFind() {
        repo.removeById(1);

        Ticket[] expected = {ticket3};
        Ticket[] actual = manager.searchBy("LED", "VKO");
    }
}

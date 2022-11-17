package ru.netology.domain;

public class Ticket implements Comparable<Ticket> {
    protected int id;
    protected int price;
    protected String to;
    protected String from;
    protected int travelTime;

    public Ticket(int id, int price, String to, String from, int travelTime) {
        this.id = id;
        this.price = price;
        this.to = to;
        this.from = from;
        this.travelTime = travelTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public int getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(int travelTime) {
        this.travelTime = travelTime;
    }

    @Override
    public int compareTo(Ticket o) {
        // переписать тело сгенерированного метода, чтобы если билет, у которого вызвали метод compareTo, стоит дешевле,
        // чем тот, который передали через параметр, то возвращалось бы число меньше нуля.
        // Если же билет, наоборот, дороже, то число больше нуля, а если стоимость одинакова, то 0.
        if (this.price < o.price) {
            return -1;
        } else if (this.price > o.price) {
            return 1;
        } else {
            return 0;
        }
    }
}

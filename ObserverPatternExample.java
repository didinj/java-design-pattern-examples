import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String news);
}

interface Subject {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

class NewsAgency implements Subject {
    private final List<Observer> observers = new ArrayList<>();
    private String news;

    public void setNews(String news) {
        this.news = news;
        notifyObservers();
    }

    public void addObserver(Observer o) { observers.add(o); }
    public void removeObserver(Observer o) { observers.remove(o); }
    public void notifyObservers() { observers.forEach(o -> o.update(news)); }

    public static void main(String[] args) {
        NewsAgency agency = new NewsAgency();
        Observer alice = news -> System.out.println("Alice received update: " + news);
        Observer bob = news -> System.out.println("Bob received update: " + news);
        agency.addObserver(alice);
        agency.addObserver(bob);
        agency.setNews("Breaking: New Java Design Patterns Tutorial Released!");
    }
}
package com.short_projects.random_quotes;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api")
public class QuoteController {

    private List<Quote> quoteList;

    public QuoteController () {

        quoteList= new ArrayList<>();
        quoteList.add(new Quote("Dobro jest dobrem, nawet gdy nikt go nie czyni. " +
                "Zło jest złem, nawet gdy wszyscy je czynią", "Augustyn z Hippony" ));
        quoteList.add(new Quote("Życie jest jak jazda na rowerze. Żeby utrzymać równowagę, musisz być w ciągłym ruchu",
                "Albert Einstein"));
        quoteList.add(new Quote("Nie licz dni, spraw by dni się liczyły", "Muhammad Ali"));
        quoteList.add(new Quote("Zwycięzcy nigdy się nie poddają. Ci, którzy się poddają, nigdy nie zwyciężają",
                "Vince Lombardi"));
        quoteList.add(new Quote("Nie ma znaczenia jak wolno idziesz, tak długo jak nie przestajesz", "Konfucjusz"));
        quoteList.add(new Quote("Jeśli nie potrafisz wyjaśnić czegoś prosto, nie rozumiesz tego wystarczająco dobrze",
                "Albert Einstein"));
        quoteList.add(new Quote("Sukces jest sumą małych wysiłków, powtarzanych dzień po dniu", "Robert Collier"));

    }

    //losowanie cytatu
    @GetMapping("/quote")
    public Quote randomQuote() {

        Random random= new Random();
        int index= random.nextInt(quoteList.size());
        return quoteList.get(index);
    }

    //zwraca wszystkie cytaty
    @GetMapping("/quotes")
    public List<Quote> getAllQuotes() {
        return quoteList;
    }

    //dodaje nowy cytat do listy
    @PostMapping("/quote")
    public void addQuote(@RequestBody Quote quote) {
        quoteList.add(quote);
    }

    //usuwa wybrany cytat z listy
    @DeleteMapping("/quote/{index}")
    public void delQuote (@PathVariable int index) {
        quoteList.remove(index);
    }
}

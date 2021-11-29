package com.github.tagirqa;

import java.util.ArrayList;
import java.util.List;

public class Cassette<T extends Banknote> {
    private List<T> banknotes;

    public Cassette(ArrayList<T> banknotes) {
        this.banknotes = banknotes;
    }

    public int getCountBanknotes() {
        return banknotes.size();
    }
}

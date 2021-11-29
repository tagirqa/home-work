package com.sbrf.reboot.atm.cassettes;

import com.github.tagirqa.Banknote;
import com.github.tagirqa.Cassette;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class CassetteTest {

    class OneHundred extends Banknote {
        public OneHundred() {
            setCount(100);
            setCurrency("RUB");
        }
    }

    class FiveHundred extends Banknote {
        public FiveHundred() {
            setCount(500);
            setCurrency("RUB");
        }
    }

    class OneThousand extends Banknote {
        public OneThousand() {
            setCount(1000);
            setCurrency("RUB");
        }
    }

    class FiveThousand extends Banknote {
        public FiveThousand() {
            setCount(5000);
            setCurrency("RUB");
        }
    }

    @Test
    void getCountBanknotes() {
        OneHundred oneHundred = new OneHundred();

        Cassette<OneHundred> cassette = new Cassette<>(new ArrayList<OneHundred>() {{
            add(oneHundred);
//            add(new OneThousand()); //it will not compile
//            add(new Banknote()); //it will not compile
        }});

        Assertions.assertEquals(1, cassette.getCountBanknotes());
    }
}
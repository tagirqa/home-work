package com.github.tagirqa;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Banknote  {
    private int count;
    private String currency;
}

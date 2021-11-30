package com.github.tagirqa;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountRepositoryImpl implements AccountRepository {
    private static final String CLIENT = "clientId";
    private static final String NUMBER = "number";
    private static final String REGEX = "\\s*\\{\\s*\"clientId\": (?<" + CLIENT + ">\\d+),\\s*\"number\": \"(?<" + NUMBER + ">\\S+)\"\\s*}";
    private static final StringBuilder TEXT_FILE = new StringBuilder();
    private String fileName;

    public AccountRepositoryImpl(String fileName) throws IOException {
        this.fileName = fileName;
    }



    @Override
    public Set<Account> getAllAccountsByClientId(long l) throws FileNotFoundException {
        Set<Account> accounts = new HashSet<Account>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                TEXT_FILE.append(line);
            }


        } catch (FileNotFoundException fileNotFoundException) {
            throw new FileNotFoundException("Файл не найден!");

        } catch (IOException e){
            System.out.println(e.getMessage());
        }

        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(TEXT_FILE);
        while (m.find()) {
            long id;
            String number;

            if ((id = Long.parseLong(m.group(CLIENT))) == l) {
                number = m.group(NUMBER);
                accounts.add(new Account(id, number));
            }
        }
        return accounts;
    }


}

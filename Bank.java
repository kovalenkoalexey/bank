import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Bank {
    private HashMap<Client, ArrayList<Account>> bank=new HashMap<>();
    Bank(Client client, ArrayList<Account> acc) {
        bank.put(client, acc);
    }
    public void putToBank(Client client, ArrayList<Account> account) {
        bank.put(client, account);
    }
    public void findClient1(Account theAccount) {
        HashMap<Client, ArrayList<Account>> map=bank;
        Collection<Client> keys = map.keySet();
        String message="Клиент не найден.";
        for (Client client: keys) {
            ArrayList<Account> accounts=map.get(client);
            for (Account account: accounts) {
                if (account.equals(theAccount))
                    message="Аккаунт "+theAccount.getNumber()+" принадлежит клиенту "+client.getName()+".";
            }
        }
        System.out.println(message);
    }
    public void findClient2(int accountNumber) {
        String message="Клиент по аккаунту "+accountNumber+" не найден.";
        Account theAccount=new Account(accountNumber);
        HashMap<Client, ArrayList<Account>> map=bank;
        Collection<Client> keys = map.keySet();
        for (Client client: keys) {
            ArrayList<Account> accounts=map.get(client);
            for (Account account: accounts) {
                if (account.equals(theAccount))
                    message="Аккаунт "+account.getNumber()+" принадлежит клиенту "+client.getName()+".";
            }
        }
        System.out.println(message);
    }
    public void findAccounts1(String name, int age) {
        String message="Аккаунт не найден.";
        Client theClient=new Client(name, age);
        for (Client client: bank.keySet()) {
            if (theClient.equals(client)){
                ArrayList<Account> accounts=bank.get(client);
                message="Аккаунты клиента "+client.getName()+": ";
                for (Account acc: accounts)
                    message+=acc.getNumber()+"/";
            }
        }
        System.out.println(message);
    }
    public void findAccounts2(Client client) {
        String message="Аккаунт не найден.";
        Set<Client> set=bank.keySet();
        for (Client findClient: set) {
            if (findClient.equals(client)) {
                message="Аккаунты клиента "+client.getName()+": ";
                ArrayList<Account> accounts=bank.get(client);
                for (Account account: accounts)
                    message+=account.getNumber()+"/";
            }
        }
        System.out.println(message);
    }
    public static void main(String[] args) {
        Client client1=new Client("Иванов", 35);
        Account account1=new Account(111);
        Account account2=new Account(222);
        Account account3=new Account(333);
        ArrayList<Account> acc1=new ArrayList<>();
        acc1.add(account1);
        acc1.add(account2);
        acc1.add(account3);
        Bank bank=new Bank(client1, acc1);
        Client client2=new Client("Петров", 30);
        Account account4=new Account(444);
        Account account5=new Account(555);
        Account account6=new Account(777);
        ArrayList<Account> acc2=new ArrayList<>();
        acc2.add(account4);
        acc2.add(account5);
        acc2.add(account6);
        bank.putToBank(client2, acc2);
        bank.findAccounts1("Иванов", 35);
        bank.findAccounts1("Петров", 30);
        bank.findAccounts2(client1);
        bank.findAccounts2(client2);
        bank.findClient1(account6);
        bank.findClient1(account1);
        bank.findClient2(666);
        bank.findClient2(222);
    }
}
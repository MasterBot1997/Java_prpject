import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class toyLottery {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        LinkedList<Toy> stockInToy = addFirst();
        LinkedList<String> prizeList = new LinkedList<>();
        int lastId = checkId(stockInToy);

        int command = -1;
        System.out.println("Приветствую на лотерее магазина игрушек!");
        while (command != 0) {
            if (stockInToy.size() != 0) {
                System.out.println("\nНапишите цифру обозначающую что вы хотите сделать\n" +
                        "1 - Посмотреть доступные игрушки\n" +
                        "2 - Добавить новую игрушку\n" +
                        "3 - Изменить шанс выпадения игрушки\n" +
                        "4 - Сыграть в лотерею\n" +
                        "5 - Посмотреть список выигранных призов\n" +
                        "6 - Забрать игрушку\n" +
                        "0 - Завершить программу\n");
                command = sc.nextInt();
            } else {
                System.out.println("Закончились игрушки для розыгрыша, добавьте новую!");
                command = 2;
            }

            switch (command) {
                case 1:
                    for (int i = 0; i < stockInToy.size(); i++) {
                        System.out.println(stockInToy.get(i));
                    }
                    break;
                case 2:
                    stockInToy.addLast(newToy(sc, lastId));
                    break;
                case 3:
                    System.out.print("Введите индекс игрушки у которой хотите поменять шанс выпадения: ");
                    int numId = sc.nextInt();
                    removeDrop(stockInToy.get(numId - 1), sc);
                    break;
                case 4:
                    Toy prize = lottery(stockInToy);
                    remLot(prize, stockInToy);
                    prizeList.addLast(prize.getName());
                    break;
                case 5:
                    printPrize(prizeList);
                    break;
                case 6:
                    if (prizeList.size() != 0) {
                        prizeFile(prizeList);
                        prizeList.removeFirst();
                    } else
                        System.out.println("Вы уже забрали все призы");
                    break;
                default:
                    break;
            }

        }

        sc.close();
    }

    public static void removeDrop(Toy remD, Scanner scan) {
        System.out.print("Введите новый шанс выпадения: ");
        remD.setDropСhance(scan.nextInt());
    }

    public static Toy newToy(Scanner scan, Integer lstId) {
        int id = lstId + 1;
        System.out.print("Введите имя: ");
        String name = scan.next();
        System.out.print("Введите Количество: ");
        int quant = scan.nextInt();
        System.out.print("Введите шанс выигрыша: ");
        int dropCh = scan.nextInt();
        Toy newT = new Toy(id, name, quant, dropCh);

        return newT;
    }

    public static Integer checkId(LinkedList<Toy> stockInToy) {
        if (stockInToy.size() != 0) {
            return stockInToy.getLast().getId();
        }
        return 0;
    }

    // Метод розыгрыша
    public static Toy lottery(LinkedList<Toy> stockToy) {
        LinkedList<Toy> temp = new LinkedList<>();
        Random random = new Random();
        Toy prize = new Toy();

        for (int i = 0; i < stockToy.size(); i++) {
            for (int j = 0; j < stockToy.get(i).getDropChance(); j++) {
                temp.add(stockToy.get(i));
            }
        }

        prize = temp.get(random.nextInt(0, temp.size()));

        return prize;
    }

    public static void remLot(Toy a, LinkedList<Toy> s) {
        for (int i = 0; i < s.size(); i++) {
            if (s.get(i) == a) {
                s.get(i).setQuantity(s.get(i).getQuantity() - 1);
                if (s.get(i).getQuantity() == 0) {
                    s.remove(i);
                }
            }

        }
    }

    public static void prizeFile(LinkedList<String> pL) {
        FileWriter writer;
        try {
            writer = new FileWriter("prize.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(pL.getFirst() + "\n");
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void printPrize(LinkedList<String> prizeStock) {
        for (int i = 0; i < prizeStock.size(); i++) {
            int temp = i + 1;
            System.out.println(temp + " " + prizeStock.get(i).toString());
        }
    }

    public static LinkedList<Toy> addFirst() {
        LinkedList<Toy> first = new LinkedList<>();
        Toy toy1 = new Toy(1, "Dad", 4, 15);
        Toy toy2 = new Toy(2, "Fred", 5, 20);
        Toy toy3 = new Toy(3, "Tom", 6, 25);
        Toy toy4 = new Toy(4, "Row", 4, 10);
        first.addLast(toy1);
        first.addLast(toy2);
        first.addLast(toy3);
        first.addLast(toy4);
        return first;
    }

}

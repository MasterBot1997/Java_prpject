# Промежуточная контрольная работа по блоку специализация

## Магазин игрушек (Java)
___

### **Задание**
___
Выполнить задание, согласно ТЗ
https://docs.google.com/document/d/1gw-SjDyKuT7dY4JEZ2hbrCuzdcP9sl2CFVyCVFhn-sU/edit?usp=sharing

Необходимо написать программу – розыгрыша игрушек в магазине детских товаров.

Желательный функционал программы:
1. В программе должен быть минимум один класс со следующими свойствами:
    - id игрушки,
    - текстовое название, количество
    - частота выпадения игрушки (вес в % от 100)
 
2.  Метод добавление новых игрушек и возможность изменения веса (частоты выпадения игрушки)

3. Возможность организовать розыгрыш игрушек.
Например, следующим образом:
С помощью метода выбора призовой игрушки – мы получаем эту призовую игрушку и записываем в список\массив.
Это список призовых игрушек, которые ожидают выдачи.
Еще у нас должен быть метод – получения призовой игрушки.
После его вызова – мы удаляем из списка\массива первую игрушку и сдвигаем массив. А эту игрушку записываем в текстовый файл.
Не забываем уменьшить количество игрушек

К написанию программы можно подойти более творчески и делать так, как Вы поняли задание. Немного менять и отходить от примера выше.
___

### **Реализация** 
___
Согласно ТЗ создано консольное приложение розыгрыша призов в магазине игрушек.

Был создан класс **Toy** который содержит в себе информацию *id, name, quantity,dropChance*. Для класса были созданы неоходимые для работы сеттеры и геттеры, так же было создано 2 конструктора.

В начале работы создается LinkedList который содержит в себе все доступные игрушки. После чего пользователю предлагается какое дейсткие он хочет выполнить.
Всего доступно 7 действий:
 - Распечатать доступные игрушки для розыгрыша;
 - Добавть новую игрушку для розыгрыша;
 - Изменить шанс выпадения у игрушки;
 - Сыграть в лоттерею;
 - Посмотреть выигранные призы;
 - Забрать приз;
 - Завершить работу приложения.

Программа работает до тех пор пока пока польхователь ее не остановит введя 0.

В работе программы предусмотренны проверки добавления id что бы они были уникальны. Так же предусмотренна проверка наличия игрушек для розыгрыша, если это первый запуск и они предварительно не добавлены или при розыгрыше они закончились, пользователь должен добавить игрушку принудительно.
Так же при розыгрыше предусмотренно уменьшение количества выигранной игрушки, если количество опустилось до 0, игрушка удаляется из списка.

Все выгранные в летерею игрушки храняться в отдельном списке, его так же можно вывести в консоль и посмотреть. Если пользователь забирает призы, то они забираются поочередно с первой по последнюю. В случае если все призы забрали пользователь получает сообщение что все приз уже забрали.

Все призы которые пользователь забрал сохраняются в файл "prize.txt".


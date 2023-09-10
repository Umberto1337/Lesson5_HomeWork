package models;

import presenters.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;

public class TableModel implements Model {

    private Collection<Table> tables;

    public Collection<Table> loadTables(){

        if (tables == null){
            tables = new ArrayList<>();

            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }

        return tables;
    }


    public int reservationTable(Date reservationDate, int tableNo, String name){
        for (Table table : loadTables()) {
            if (table.getNo() == tableNo){
                Reservation reservation = new Reservation(reservationDate, name);
                table.getReservations().add(reservation);
                return reservation.getId();
            }
        }
        return -1;
        //throw new RuntimeException("Некорректный номер столика");
    }

    public int changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
        for (Table table : tables) {
            if (table.getNo() == tableNo) {
                for (Reservation reservation : table.getReservations()) {
                    if (reservation.getId() == oldReservation) {
                        reservation.setDate(reservationDate);
                        reservation.setName(name);
                        return reservation.getId();
                    }
                }
                System.out.println("Бронирование с номером #" + oldReservation + " не найдено для столика #" + tableNo);
                return -1;
            }
        }
        System.out.println("Столик #" + tableNo + " не найден");
        return -1; // В случае, если бронирование не найдено
    }
    

}
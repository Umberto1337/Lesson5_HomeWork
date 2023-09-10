package presenters;

import java.util.Date;

public interface ViewObserver {
    void onReservationTable(Date orderDate, int tableNo, String name);

    int onChangeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name);
}

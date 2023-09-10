package presenters;

import models.Table;

import java.util.Collection;

public interface View {

    /**
     * Отобразить список столиков в представлении
     * @param tables список столиков
     */
    void showTables(Collection<Table> tables);

    /**
     * Регистрация наблюдателя
     * @param observer
     */
    void setObserver(ViewObserver observer);

    /**
     * Распечатать результат бронирования столика
     * @param reservationNo
     */
    void printReservationTableResult(int reservationNo);
}

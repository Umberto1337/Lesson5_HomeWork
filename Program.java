import models.TableModel;
import presenters.BookingPresenter;
import views.BookingView;

import java.util.Date;

public class Program {

    public static void main(String[] args) {
        TableModel model = new TableModel();
        BookingView view = new BookingView();
        BookingPresenter bookingPresenter = new BookingPresenter(model, view);
        bookingPresenter.updateTablesUI();

        view.reservationTable(new Date(), 3, "Станислав");
        // Успешное изменение бронирование
        view.changeReservationTable(101, new Date(), 3, "Станислав");
        // Указали не существующий столик
        view.changeReservationTable(101, new Date(), 6, "Станислав");
        // Указали не существующую бронь
        view.changeReservationTable(103, new Date(), 3, "Станислав");
    }

}
package br.com.mathbc;

import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@ApplicationScoped
public class BookingService {
    private final Map<Long, Booking> bookings = new HashMap<>();

    public BookingService() {
        bookings.put(
                12345L,
                new Booking(
                        12345L,
                        "John Doe",
                        "Tesouros do Egito",
                        LocalDate.now().plusMonths(2),
                        LocalDate.now().plusMonths(2).plusDays(2),
                        BookingStatus.CONFIRMED,
                        Category.TREASURE
                )
        );
        bookings.put(
                678202L,
                new Booking(
                        678202L,
                        "Jane Smith",
                        "Aventura Amazônia",
                        LocalDate.now().plusMonths(2),
                        LocalDate.now().plusMonths(3).plusDays(2),
                        BookingStatus.CONFIRMED,
                        Category.ADVENTURE
                )
        );
    }

    public Optional<Booking> getBookingDetails(long bookingId) {
        return Optional.ofNullable(bookings.get(bookingId));
    }

    public Optional<Booking> cancelBooking(Long bookingId) {
        String currentUser = SecurityContext.getCurrentUser();

        if (bookings.containsKey(bookingId)) {
            Booking booking = bookings.get(bookingId);

            if (booking.customerName().endsWith(currentUser)) {
                Booking cancelledBooking = new Booking(booking.id(), booking.customerName(), booking.destination(), booking.startDate(), booking.endDate(), BookingStatus.CANCELLED, booking.category());
                bookings.put(bookingId, cancelledBooking);
                return Optional.of(cancelledBooking);
            }
        }
        return Optional.empty();
    }

    public List<Booking> findPackagesByCategory(Category category) {
        return bookings.values()
                .stream()
                .filter(booking -> booking.category() == category)
                .toList();
    }
}

//-------------------------------------------
//20191228 s.toku
//-------------------------------------------
package mrs.domain.repository.reservation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mrs.domain.model.ReservableRoomId;
import mrs.domain.model.Reservation;

/**
 * 予約情報を管理するリポジトリです。
 * 
 * @author shoheitokumaru
 *
 */
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
	List<Reservation> findByReservableRoom_ReservableRoomIdOrderByStartTimeAsc(
			ReservableRoomId reservableRoomId);
}
